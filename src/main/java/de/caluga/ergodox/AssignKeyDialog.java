package de.caluga.ergodox;/**
 * Created by stephan on 11.04.16.
 */

import de.caluga.ergodox.macros.LongPressAndTypeMacro;
import de.caluga.ergodox.macros.Macro;
import de.caluga.ergodox.macros.MacroAction;
import de.caluga.ergodox.macros.TypeMacro;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO: Add Documentation here
 **/
public class AssignKeyDialog {
    private ErgodoxLayout ergodoxLayout;

    public AssignKeyDialog(ErgodoxLayout ergodoxLayout) {
        this.ergodoxLayout = ergodoxLayout;
    }

    public void show(Key k) {
        List<String> choices = Main.getKeyCodesList();

        String def = k.getValue();
        //describing choices
        Map<String, String> prefixDescriptionByPrefix = Main.getPrefixDescriptionMap();

        // Create the custom dialog.
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Choose Key");
        dialog.setHeaderText("Key from available keys");

        ButtonType assignButtonType = new ButtonType("Assign", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(assignButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        ComboBox<String> prefixCBX = new ComboBox<>();
        for (String prfx : prefixDescriptionByPrefix.keySet()) {
            prefixCBX.getItems().add(prfx + " - " + prefixDescriptionByPrefix.get(prfx));
        }

        ComboBox<String> keyCodexCBX = new ComboBox<>();
        keyCodexCBX.setEditable(true);
        keyCodexCBX.getItems().addAll(choices);
        ComboBoxAutocompleter ac = new ComboBoxAutocompleter(keyCodexCBX);

        String lastKey = Main.applicationSettings.getProperty("last_key_prefix");

        if (lastKey != null) {
            prefixCBX.getSelectionModel().select(lastKey);
            keyCodexCBX.getEditor().setText(lastKey.substring(0, lastKey.indexOf(" - ")));
            Platform.runLater(() -> {
                ac.updateSelection();
            });
        } else {
            prefixCBX.getSelectionModel().select("ALL - " + prefixDescriptionByPrefix.get("ALL"));
        }


        prefixCBX.addEventHandler(ActionEvent.ACTION, event -> {
            String selectedItem = prefixCBX.getSelectionModel().getSelectedItem();
            if (selectedItem.startsWith("ALL - ")) {
                keyCodexCBX.getEditor().setText("");
            } else {
                keyCodexCBX.getEditor().setText(selectedItem.substring(0, selectedItem.indexOf(" - ")));
            }
            ac.updateSelection();
            Node assignButton = dialog.getDialogPane().lookupButton(assignButtonType);
            assignButton.setDisable(true);
            Main.applicationSettings.setProperty("last_key_prefix", selectedItem);
            Main.saveConfig();
        });

        keyCodexCBX.addEventHandler(ActionEvent.ACTION, event -> {
            Node assignButton = dialog.getDialogPane().lookupButton(assignButtonType);
            assignButton.setDisable(false);

        });
        keyCodexCBX.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().equals("ENTER")) {
                k.setValue(keyCodexCBX.getSelectionModel().getSelectedItem());
                dialog.close();
            }
        });

//        ToggleGroup toggleGroup = new ToggleGroup();

        CheckBox shiftCbx = new CheckBox("Shift");
        CheckBox ctrlCbx = new CheckBox("Ctrl");
        CheckBox altCbx = new CheckBox("Alt");
        CheckBox cmdCbx = new CheckBox("Cmd");
//        cmdCbx.setToggleGroup(toggleGroup);
//        shiftCbx.setToggleGroup(toggleGroup);
//        altCbx.setToggleGroup(toggleGroup);
//        ctrlCbx.setToggleGroup(toggleGroup);

        CheckBox[] checkBoxes = new CheckBox[]{shiftCbx, ctrlCbx, altCbx, cmdCbx};
        CheckBox combinationLT = new CheckBox("if checked, modifier will issued when held, key when typed");
        Label desc = new Label("when more than one modifier is selected, a macro will be created!");
        Label currentValue = new Label("current value: ");
        Pane p = new FlowPane();
        for (CheckBox cbx : checkBoxes) {
            p.getChildren().add(cbx);
        }
        Map<CheckBox, ErgodoxKeyCode> modifierByCBox = new HashMap();
        modifierByCBox.put(shiftCbx, ErgodoxKeyCode.KC_LSFT);
        modifierByCBox.put(ctrlCbx, ErgodoxKeyCode.KC_LCTL);
        modifierByCBox.put(altCbx, ErgodoxKeyCode.KC_LALT);
        modifierByCBox.put(cmdCbx, ErgodoxKeyCode.KC_LGUI);

        if (def != null) {
            if (def.startsWith("M(")) {
                //Macro
                Macro macro = ergodoxLayout.getMacros().get(def.substring(2, def.length() - 1));
                if (macro != null && macro instanceof TypeMacro) {
                    TypeMacro tm = (TypeMacro) macro;
                    for (MacroAction a : tm.getActions()) {
                        if (a.getAction().equals(MacroAction.Action.DOWN)) {
                            for (CheckBox bx : modifierByCBox.keySet()) {
                                if (modifierByCBox.get(bx).equals(a.getCode())) {
                                    bx.setSelected(true);
                                }
                            }
                        } else if (a.getAction().equals(MacroAction.Action.TYPE)) {
                            keyCodexCBX.getSelectionModel().select(a.getCode().name());
                        }

                    }
                    combinationLT.setSelected(false);
                } else if (macro != null && macro instanceof LongPressAndTypeMacro) {
                    LongPressAndTypeMacro lp = (LongPressAndTypeMacro) macro;
                    for (MacroAction a : lp.getLongPressKeys()) {
                        if (a.getAction().equals(MacroAction.Action.DOWN)) {
                            for (CheckBox bx : modifierByCBox.keySet()) {
                                if (modifierByCBox.get(bx).equals(a.getCode())) {
                                    bx.setSelected(true);
                                }
                            }
                        }
                    }
                    for (MacroAction a : lp.getShortStrokes()) {
                        if (a.getAction().equals(MacroAction.Action.TYPE)) {
                            keyCodexCBX.getSelectionModel().select(a.getCode().name());
                        }
                    }
                    combinationLT.setSelected(true);
                }
            } else if (def.contains("(")) {
                Pattern defp = Pattern.compile("([0-9A-Z_]+)\\(([0-9A-Z_]+)\\)");
                Matcher m = defp.matcher(def);
                if (m.matches()) {
                    if (m.group(1).endsWith("_T")) {
                        if (m.group(1).startsWith("ALT")) {
                            altCbx.setSelected(true);
                        } else if (m.group(1).startsWith("GUI")) {
                            cmdCbx.setSelected(true);
                        } else if (m.group(1).startsWith("SHFT")) {
                            cmdCbx.setSelected(true);
                        } else if (m.group(1).startsWith("CTL")) {
                            cmdCbx.setSelected(true);
                        }
                    } else {
                        if (m.group(1).startsWith("LALT")) {
                            altCbx.setSelected(true);
                        } else if (m.group(1).startsWith("LGUI")) {
                            cmdCbx.setSelected(true);
                        } else if (m.group(1).startsWith("LSFT")) {
                            cmdCbx.setSelected(true);
                        } else if (m.group(1).startsWith("LCTL")) {
                            cmdCbx.setSelected(true);
                        }
                    }

                    keyCodexCBX.getSelectionModel().select(m.group(2));
                }
            } else {
                keyCodexCBX.getSelectionModel().select(def);
            }
        }
        if (def != null) currentValue.setText("Current value: " + def);
        else currentValue.setText("Currently no value");
        grid.add(new Label("Prefix:"), 0, 0);
        grid.add(prefixCBX, 1, 0);
        grid.add(new Label("Key:"), 0, 1);
        grid.add(keyCodexCBX, 1, 1);
        grid.add(p, 0, 2, 2, 1);
        grid.add(combinationLT, 0, 3, 2, 1);
        grid.add(desc, 0, 4, 2, 1);
        grid.add(currentValue, 1, 5);

// Enable/Disable login button depending on whether a username was entered.
        Node assignButton = dialog.getDialogPane().lookupButton(assignButtonType);
        assignButton.setDisable(true);


        dialog.getDialogPane().setContent(grid);


// Request focus on the username field by default.
        Platform.runLater(() -> keyCodexCBX.requestFocus());


        Optional<ButtonType> result = dialog.showAndWait();

        result.ifPresent(btn -> {
            if (btn.getButtonData().equals(ButtonBar.ButtonData.CANCEL_CLOSE)) return;
            int cnt = 0;
            for (CheckBox b : checkBoxes) {
                if (b.isSelected()) cnt++;
            }

            String selectedItem = keyCodexCBX.getSelectionModel().getSelectedItem();
            if (combinationLT.isSelected()) {
                if (cnt == 4) {
                    //Hyper
                    selectedItem = "ALL_T(" + selectedItem + ")";
                } else if (cnt == 3 && shiftCbx.isSelected() && altCbx.isSelected() && ctrlCbx.isSelected()) {
                    //Meh
                    selectedItem = "MEH_T(" + selectedItem + ")";
                } else if (cnt <= 3 && cnt > 1) {
                    //Macro implementation
                    LongPressAndTypeMacro lp = new LongPressAndTypeMacro();
                    //Setting modifiers for longpress
                    for (CheckBox cbx : checkBoxes) {
                        if (cbx.isSelected()) {
                            //Pressing modifiers
                            MacroAction a = new MacroAction();
                            a.setCode(modifierByCBox.get(cbx));
                            a.setAction(MacroAction.Action.DOWN);
                            a.setWait(0);
                            lp.getLongPressKeys().add(a);

                            //releasing them
                            a = new MacroAction();
                            a.setCode(modifierByCBox.get(cbx));
                            a.setAction(MacroAction.Action.UP);
                            lp.getShortStrokes().add(a);
                        }

                    }
                    //typing _the_ key
                    MacroAction keyType = new MacroAction();
                    keyType.setCode(ErgodoxKeyCode.valueOf(selectedItem));
                    keyType.setAction(MacroAction.Action.TYPE);
                    lp.getShortStrokes().add(keyType);

                    lp.setName("M_Key_" + selectedItem + "_MODS");
                    lp.setTimeout(150);
                    ergodoxLayout.getMacros().put(lp.getName(), lp);

                    selectedItem = "M(" + lp.getName() + ")";

                } else if (cnt == 1) {
                    if (shiftCbx.isSelected()) {
                        selectedItem = "SHFT_T(" + selectedItem + ")";
                    } else if (ctrlCbx.isSelected()) {
                        selectedItem = "CTL_T(" + selectedItem + ")";
                    } else if (cmdCbx.isSelected()) {
                        selectedItem = "GUI_T(" + selectedItem + ")";
                    } else if (altCbx.isSelected()) {
                        selectedItem = "ALT_T(" + selectedItem + ")";
                    }
                }
            } else {
                if (cnt == 1) {
                    //Got selection ok
                    if (shiftCbx.isSelected()) {
                        selectedItem = "LSFT(" + selectedItem + ")";
                    } else if (ctrlCbx.isSelected()) {
                        selectedItem = "LCTL(" + selectedItem + ")";
                    } else if (cmdCbx.isSelected()) {
                        selectedItem = "LGUI(" + selectedItem + ")";
                    } else if (altCbx.isSelected()) {
                        selectedItem = "LALT(" + selectedItem + ")";
                    }
                } else if (cnt > 1) {
                    //macro necessary
                    TypeMacro tm = new TypeMacro();
                    for (CheckBox cbx : checkBoxes) {
                        if (cbx.isSelected()) {
                            MacroAction a = new MacroAction();
                            a.setAction(MacroAction.Action.DOWN);
                            a.setCode(modifierByCBox.get(cbx));
                            tm.getActions().add(a);
                        }
                    }
                    //Typing the key
                    MacroAction type = new MacroAction();
                    type.setCode(ErgodoxKeyCode.valueOf(selectedItem));
                    type.setAction(MacroAction.Action.TYPE);
                    tm.getActions().add(type);
                    //releasing modifiers
                    for (CheckBox cbx : checkBoxes) {
                        if (cbx.isSelected()) {
                            MacroAction a = new MacroAction();
                            a.setAction(MacroAction.Action.UP);
                            a.setCode(modifierByCBox.get(cbx));
                            tm.getActions().add(a);
                        }
                    }

                    tm.setName("M_MOD_" + selectedItem);
                    ergodoxLayout.getMacros().put(tm.getName(), tm);
                    selectedItem = "M(" + tm.getName() + ")";
                }
            }
            k.setValue(selectedItem);
        });

    }
}
