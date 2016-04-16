/*
 * Copyright © 2007 Free Software Foundation, Inc. <http://fsf.org/>
 *
 * Everyone is permitted to copy and distribute verbatim copies of this license document, but changing it is not allowed.
 *
 * This version of the GNU Lesser General Public License incorporates the terms and conditions of version 3 of the GNU General Public License, supplemented by the additional permissions listed below.
 *
 * 0. Additional Definitions.
 * As used herein, “this License” refers to version 3 of the GNU Lesser General Public License, and the “GNU GPL” refers to version 3 of the GNU General Public License.
 *
 * “The Library” refers to a covered work governed by this License, other than an Application or a Combined Work as defined below.
 *
 * An “Application” is any work that makes use of an interface provided by the Library, but which is not otherwise based on the Library. Defining a subclass of a class defined by the Library is deemed a mode of using an interface provided by the Library.
 *
 * A “Combined Work” is a work produced by combining or linking an Application with the Library. The particular version of the Library with which the Combined Work was made is also called the “Linked Version”.
 *
 * The “Minimal Corresponding Source” for a Combined Work means the Corresponding Source for the Combined Work, excluding any source code for portions of the Combined Work that, considered in isolation, are based on the Application, and not on the Linked Version.
 *
 * The “Corresponding Application Code” for a Combined Work means the object code and/or source code for the Application, including any data and utility programs needed for reproducing the Combined Work from the Application, but excluding the System Libraries of the Combined Work.
 *
 * 1. Exception to Section 3 of the GNU GPL.
 * You may convey a covered work under sections 3 and 4 of this License without being bound by section 3 of the GNU GPL.
 *
 * 2. Conveying Modified Versions.
 * If you modify a copy of the Library, and, in your modifications, a facility refers to a function or data to be supplied by an Application that uses the facility (other than as an argument passed when the facility is invoked), then you may convey a copy of the modified version:
 *
 * a) under this License, provided that you make a good faith effort to ensure that, in the event an Application does not supply the function or data, the facility still operates, and performs whatever part of its purpose remains meaningful, or
 * b) under the GNU GPL, with none of the additional permissions of this License applicable to that copy.
 * 3. Object Code Incorporating Material from Library Header Files.
 * The object code form of an Application may incorporate material from a header file that is part of the Library. You may convey such object code under terms of your choice, provided that, if the incorporated material is not limited to numerical parameters, data structure layouts and accessors, or small macros, inline functions and templates (ten or fewer lines in length), you do both of the following:
 *
 * a) Give prominent notice with each copy of the object code that the Library is used in it and that the Library and its use are covered by this License.
 * b) Accompany the object code with a copy of the GNU GPL and this license document.
 * 4. Combined Works.
 * You may convey a Combined Work under terms of your choice that, taken together, effectively do not restrict modification of the portions of the Library contained in the Combined Work and reverse engineering for debugging such modifications, if you also do each of the following:
 *
 * a) Give prominent notice with each copy of the Combined Work that the Library is used in it and that the Library and its use are covered by this License.
 * b) Accompany the Combined Work with a copy of the GNU GPL and this license document.
 * c) For a Combined Work that displays copyright notices during execution, include the copyright notice for the Library among these notices, as well as a reference directing the user to the copies of the GNU GPL and this license document.
 * d) Do one of the following:
 * 0) Convey the Minimal Corresponding Source under the terms of this License, and the Corresponding Application Code in a form suitable for, and under terms that permit, the user to recombine or relink the Application with a modified version of the Linked Version to produce a modified Combined Work, in the manner specified by section 6 of the GNU GPL for conveying Corresponding Source.
 * 1) Use a suitable shared library mechanism for linking with the Library. A suitable mechanism is one that (a) uses at run time a copy of the Library already present on the user's computer system, and (b) will operate properly with a modified version of the Library that is interface-compatible with the Linked Version.
 * e) Provide Installation Information, but only if you would otherwise be required to provide such information under section 6 of the GNU GPL, and only to the extent that such information is necessary to install and execute a modified version of the Combined Work produced by recombining or relinking the Application with a modified version of the Linked Version. (If you use option 4d0, the Installation Information must accompany the Minimal Corresponding Source and Corresponding Application Code. If you use option 4d1, you must provide the Installation Information in the manner specified by section 6 of the GNU GPL for conveying Corresponding Source.)
 * 5. Combined Libraries.
 * You may place library facilities that are a work based on the Library side by side in a single library together with other library facilities that are not Applications and are not covered by this License, and convey such a combined library under terms of your choice, if you do both of the following:
 *
 * a) Accompany the combined library with a copy of the same work based on the Library, uncombined with any other library facilities, conveyed under the terms of this License.
 * b) Give prominent notice with the combined library that part of it is a work based on the Library, and explaining where to find the accompanying uncombined form of the same work.
 * 6. Revised Versions of the GNU Lesser General Public License.
 * The Free Software Foundation may publish revised and/or new versions of the GNU Lesser General Public License from time to time. Such new versions will be similar in spirit to the present version, but may differ in detail to address new problems or concerns.
 *
 * Each version is given a distinguishing version number. If the Library as you received it specifies that a certain numbered version of the GNU Lesser General Public License “or any later version” applies to it, you have the option of following the terms and conditions either of that published version or of any later version published by the Free Software Foundation. If the Library as you received it does not specify a version number of the GNU Lesser General Public License, you may choose any version of the GNU Lesser General Public License ever published by the Free Software Foundation.
 *
 * If the Library as you received it specifies that a proxy can decide whether future versions of the GNU Lesser General Public License shall apply, that proxy's public statement of acceptance of any version is permanent authorization for you to choose that version for the Library.
 */

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
                            shiftCbx.setSelected(true);
                        } else if (m.group(1).startsWith("CTL")) {
                            ctrlCbx.setSelected(true);
                        }
                    } else {
                        if (m.group(1).startsWith("LALT")) {
                            altCbx.setSelected(true);
                        } else if (m.group(1).startsWith("LGUI")) {
                            cmdCbx.setSelected(true);
                        } else if (m.group(1).startsWith("LSFT")) {
                            shiftCbx.setSelected(true);
                        } else if (m.group(1).startsWith("LCTL")) {
                            ctrlCbx.setSelected(true);
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
        grid.add(keyCodexCBX, 1, 2);
        grid.add(p, 0, 1, 2, 1);
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
