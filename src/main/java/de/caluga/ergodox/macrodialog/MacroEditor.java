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

package de.caluga.ergodox.macrodialog;

import de.caluga.ergodox.*;
import de.caluga.ergodox.macros.*;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * User: Stephan Bösebeck
 * Date: 11.04.16
 * Time: 23:06
 * <p>
 * TODO: Add documentation here
 */
public class MacroEditor {

    private TextField macroContent1;
    private TextField nameTF;
    private Macro theMacro;
    private TextField macroContent2;
    private ComboBox<Integer> timeoutCBX;
    private TextField focusedTF;
    private TextArea textArea;

    private ErgodoxLayout layout;
    private ComboBox<String> layersCBX;
    private CheckBox holdAndType;

    public MacroEditor(ErgodoxLayout l) {
        this(l, null);
    }

    public MacroEditor(ErgodoxLayout l, Macro m) {
        layout = l;
        theMacro = m; //for Editing
    }

    public void showEditor() {
        Stage macroEditor = new Stage();


        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(20);
        grid.setPadding(new Insets(20, 150, 10, 10));

        ToggleGroup tg = new ToggleGroup();
        RadioButton typeMacroRB = new RadioButton("Typing macro");
        typeMacroRB.setToggleGroup(tg);
        RadioButton longPMacroRB = new RadioButton("Long press type macro");
        longPMacroRB.setToggleGroup(tg);
        RadioButton holdKeyMacroRB = new RadioButton("Hold key macro");
        holdKeyMacroRB.setToggleGroup(tg);
        RadioButton layerToggleRB = new RadioButton("layertoggle macro");
        layerToggleRB.setToggleGroup(tg);
        RadioButton layerToggleTypeRB = new RadioButton("layertoggle type macro");
        layerToggleTypeRB.setToggleGroup(tg);
        RadioButton customMacro = new RadioButton("Custom macro");
        customMacro.setToggleGroup(tg);
        GridPane content = new GridPane();
        content.setHgap(10);
        content.setVgap(10);

        FlowPane p = new FlowPane(10, 10);
        p.getChildren().add(typeMacroRB);
        p.getChildren().add(longPMacroRB);
        p.getChildren().add(holdKeyMacroRB);
        p.getChildren().add(customMacro);
        p.getChildren().add(layerToggleRB);
        p.getChildren().add(layerToggleTypeRB);

        typeMacroRB.setSelected(true);
        showTypeMacro(content);

        typeMacroRB.addEventHandler(ActionEvent.ACTION, event -> {
            showTypeMacro(content);
            content.requestLayout();
            p.requestLayout();
        });

        layerToggleTypeRB.addEventHandler(ActionEvent.ACTION, event -> {
            showLayerToggleTypeMacor(content);
            content.requestLayout();
            p.requestLayout();
        });
        longPMacroRB.addEventHandler(ActionEvent.ACTION, event -> {
            showLongPressMacro(content);
        });

        holdKeyMacroRB.addEventHandler(ActionEvent.ACTION, event -> {
            showHoldKeyMacro(content);
        });

        customMacro.addEventHandler(ActionEvent.ACTION, event -> {
            showCustomMacro(content);
        });

        layerToggleRB.addEventHandler(ActionEvent.ACTION, event -> {
            showLayerToggle(content);
        });


        nameTF = new TextField();
        grid.add(new Label("Macro name:"), 0, 0);
        grid.add(nameTF, 1, 0);
        grid.add(new Label("Type:"), 0, 1);
        grid.add(p, 1, 1);
        grid.add(content, 0, 2, 2, 1);


        FlowPane fp = new FlowPane();
        Button ok = new Button("OK");
        Button cancel = new Button("cancel");
        fp.getChildren().add(ok);
        fp.getChildren().add(cancel);

        grid.add(fp, 1, 3);


//        grid.add(new Label("Key typed:"), 0, 2);
//        grid.add(keyCBX, 1, 2);
//        grid.add(new Label("Layer when held:"), 0, 1);
//        grid.add(layerCBX, 1, 1);

// Enable/Disable login button depending on whether a username was entered.
        Scene scene = new Scene(grid, 1000, 500);


        cancel.addEventHandler(ActionEvent.ACTION, event -> {
            theMacro = null;
            macroEditor.close();
        });
        ok.addEventHandler(ActionEvent.ACTION, event -> {
            Macro m = null;
            if (nameTF.getText().matches("^[0-9.]+§")) {
                nameTF.setText("M_"); //avoiding number-names for macros, would kill compilation
            }
            if (typeMacroRB.isSelected()) {
                m = getTypeMacro();
            } else if (longPMacroRB.isSelected()) {
                m = getLongPressMacro();
            } else if (layerToggleRB.isSelected()) {
                m = getLayerToggleMacro();
            } else if (holdKeyMacroRB.isSelected()) {
                m = getHoldKeyMacro();
            } else if (layerToggleTypeRB.isSelected()) {
                m = getLayerToggleTypeMacro();
            } else if (customMacro.isSelected()) {
                m = getCustomMacro();
            }
            if (m == null) return;
            theMacro = m;
            macroEditor.close();
        });

        if (theMacro != null) {
            nameTF.setText(theMacro.getName());
            StringBuilder b = new StringBuilder();
            if (theMacro instanceof LongPressAndTypeMacro) {
                longPMacroRB.setSelected(true);
                showLongPressMacro(content);
                LongPressAndTypeMacro lp = (LongPressAndTypeMacro) theMacro;
                KeymapWriter.macroActionListToCString(b, lp.getLongPressKeys());
                b.setLength(b.length() - 1);
                macroContent1.setText(b.toString());
                b.setLength(0);
                KeymapWriter.macroActionListToCString(b, lp.getShortStrokes());
                b.setLength(b.length() - 1);
                macroContent2.setText(b.toString());
                timeoutCBX.getSelectionModel().select(lp.getTimeout());
            } else if (theMacro instanceof HoldKeyMacro) {
                holdKeyMacroRB.setSelected(true);
                showHoldKeyMacro(content);
                HoldKeyMacro hm = (HoldKeyMacro) theMacro;
                KeymapWriter.macroActionListToCString(b, hm.getOnPress());
                b.setLength(b.length() - 1);
                macroContent1.setText(b.toString());
                b.setLength(0);
                KeymapWriter.macroActionListToCString(b, hm.getOnRelease());
                b.setLength(b.length() - 1);
                macroContent2.setText(b.toString());
            } else if (theMacro instanceof CustomMacro) {
                customMacro.setSelected(true);
                showCustomMacro(content);
                textArea.setText(((CustomMacro) theMacro).getContent());
            } else if (theMacro instanceof TypeMacro) {
                typeMacroRB.setSelected(true);
                showTypeMacro(content);
                TypeMacro tm = (TypeMacro) theMacro;
                KeymapWriter.macroActionListToCString(b, tm.getActions());
                b.setLength(b.length() - 1);
                macroContent1.setText(b.toString());
            } else if (theMacro instanceof LayerToggleTypeMacro) {
                layerToggleTypeRB.setSelected(true);
                showLayerToggleTypeMacor(content);
                LayerToggleTypeMacro ltt = (LayerToggleTypeMacro) theMacro;
                KeymapWriter.macroActionListToCString(b, ltt.getActionsOnType());
                b.setLength(b.length() - 1);
                macroContent1.setText(b.toString());
                layersCBX.getSelectionModel().select(ltt.getLayer());
                timeoutCBX.getSelectionModel().select(ltt.getTimeout());

            } else if (theMacro instanceof LayerToggleAndHoldMacro) {
                layerToggleRB.setSelected(true);
                showLayerToggle(content);
                LayerToggleAndHoldMacro lth = (LayerToggleAndHoldMacro) this.theMacro;
                layersCBX.getSelectionModel().select(lth.getLayer());
                timeoutCBX.getSelectionModel().select(lth.getTimeout());
                holdAndType.setSelected(true);
                timeoutCBX.setVisible(true);
            } else if (theMacro instanceof LayerToggleMacro) {
                layerToggleRB.setSelected(true);
                showLayerToggle(content);
                layersCBX.getSelectionModel().select(((LayerToggleMacro) theMacro).getLayer());
            }
        }
        macroEditor.setTitle("MacroEditor");
        macroEditor.setScene(scene);
        macroEditor.showAndWait();


    }

    private void showLayerToggleTypeMacor(GridPane content) {
        content.getChildren().clear();
        content.add(new Label("Toggle layer on hold and type macro"), 0, 0);
        macroContent1 = new TextField("");
        macroContent1.setMinWidth(350);
        layersCBX = createLayerCBX();
        timeoutCBX = createTimeoutCBX();
        content.add(new Label("on type"), 0, 1);
        content.add(new Label("layer switch"), 0, 2);
        content.add(new Label("Timeout"), 0, 3);
        content.add(macroContent1, 1, 1);
        content.add(layersCBX, 1, 2);
        content.add(timeoutCBX, 1, 3);
        Button btn = new Button("convert text to macro");
        btn.addEventHandler(ActionEvent.ACTION, event -> {
            macroContent1.setText(macronifyString(macroContent1.getText()));
        });
        content.add(btn, 2, 1);

    }

    private LayerToggleTypeMacro getLayerToggleTypeMacro() {
        LayerToggleTypeMacro ret = new LayerToggleTypeMacro();
        ret.setTimeout(timeoutCBX.getSelectionModel().getSelectedItem());
        ret.setActionsOnType(KeymapParser.parseActionList(macroContent1.getText()));
        ret.setLayer(layersCBX.getSelectionModel().getSelectedItem());
        ret.setName(nameTF.getText());
        return ret;
    }

    private Macro getCustomMacro() {
        CustomMacro m = new CustomMacro();
        m.setName(nameTF.getText());
        m.setContent(textArea.getText());
        return m;
    }

    private void showCustomMacro(GridPane content) {
        content.getChildren().clear();
        textArea = new TextArea();
        content.add(new Label("Custom macro content"), 0, 0);
        content.add(textArea, 0, 1);
    }

    private void showHoldKeyMacro(GridPane content) {
        content.getChildren().clear();
        content.add(new Label("Hold key macro"), 0, 0);
        macroContent1 = new TextField("");
        macroContent2 = new TextField("");
        content.add(new Label("on press"), 0, 1);
        content.add(new Label("on release"), 0, 2);
        content.add(macroContent1, 1, 1);
        content.add(macroContent2, 1, 2);
        Button btn = new Button("convert text to macro");
        btn.addEventHandler(ActionEvent.ACTION, event -> {
            macroContent1.setText(macronifyString(macroContent1.getText()));
        });
        content.add(btn, 2, 1);
        btn = new Button("convert text to macro");
        btn.addEventHandler(ActionEvent.ACTION, event -> {
            macroContent2.setText(macronifyString(macroContent2.getText()));
        });
        content.add(btn, 2, 2);
    }

    private Macro getHoldKeyMacro() {
        HoldKeyMacro hm = new HoldKeyMacro();
        hm.setName(nameTF.getText());
        hm.setOnPress(KeymapParser.parseActionList(macroContent1.getText()));
        return hm;
    }

    private void showLongPressMacro(GridPane content) {
        content.getChildren().clear();
        content.add(new Label("long press and type macro."), 0, 0, 3, 1);
        content.add(new Label("Timeout in ms: "), 0, 1);
        timeoutCBX = createTimeoutCBX();
        content.add(timeoutCBX, 1, 1);
        content.add(new Label("typing part:"), 0, 3);
        macroContent1 = new TextField();
        macroContent1.setPrefWidth(500);
        content.add(macroContent1, 1, 3);
        content.add(new Label("holding key part:"), 0, 2);
        macroContent2 = new TextField("");
        content.add(macroContent2, 1, 2);
        Button btn = new Button("Convert text to macro");
        content.add(btn, 2, 3);
        btn.addEventHandler(ActionEvent.ACTION, event -> {
            String txt = macroContent1.getText();
            String newTxt = macronifyString(txt);
            macroContent1.setText(newTxt);
        });
        btn = new Button("Convert text to macro");
        content.add(btn, 2, 2);
        btn.addEventHandler(ActionEvent.ACTION, event -> {
            String txt = macroContent2.getText();
            String newTxt = macronifyString(txt);
            macroContent2.setText(newTxt);
        });


        ComboBox<String> validKeyCodesCbx = new ComboBox<>();
        for (ErgodoxKeyCode c : ErgodoxKeyCode.values()) {
//            if (c.name().startsWith("KC_")) {
                validKeyCodesCbx.getItems().add(c.name());
//            }
        }
        ComboBoxAutocompleter<String> autocompleter = new ComboBoxAutocompleter<>(validKeyCodesCbx);


//        content.add(validKeyCodesCbx, 3, 1);
//        validKeyCodesCbx.addEventHandler(ActionEvent.ACTION, event -> {
//
//
//        });


        Button insert = new Button("T");
        insert.addEventHandler(ActionEvent.ACTION, event -> {
            if (focusedTF != null && validKeyCodesCbx.getSelectionModel().getSelectedItem() != null) {
                focusedTF.insertText(focusedTF.getCaretPosition(), "TYPE(" + validKeyCodesCbx.getSelectionModel().getSelectedItem().substring(3) + ")");//no KC_ prefix
            }
        });
        Button down = new Button("D");
        down.addEventHandler(ActionEvent.ACTION, event -> {
            if (focusedTF != null && validKeyCodesCbx.getSelectionModel().getSelectedItem() != null) {
                focusedTF.insertText(focusedTF.getCaretPosition(), "DOWN(" + validKeyCodesCbx.getSelectionModel().getSelectedItem().substring(3) + ")");//no KC_ prefix
            }
        });
        Button up = new Button("U");
        up.addEventHandler(ActionEvent.ACTION, event -> {
            if (focusedTF != null && validKeyCodesCbx.getSelectionModel().getSelectedItem() != null) {
                focusedTF.insertText(focusedTF.getCaretPosition(), "UP(" + validKeyCodesCbx.getSelectionModel().getSelectedItem().substring(3) + ")");//no KC_ prefix
            }
        });
        FlowPane pn = new FlowPane();
        pn.getChildren().add(insert);
        pn.getChildren().add(down);
        pn.getChildren().add(up);
        pn.getChildren().add(validKeyCodesCbx);
        content.add(pn, 2, 1);

//        validKeyCodesCbx.getEditor().setText("KC_");
//        content.add(insert,2,1);

        macroContent1.focusedProperty().addListener((observable, oldValue, newValue) -> {
            focusedTF = macroContent1;
        });

        macroContent2.focusedProperty().addListener((observable, oldValue, newValue) -> {
            focusedTF = macroContent2;
        });
        content.add(new Label("Long press macro will issue different keys, depending on how long the key is pressed\nAttention: you need to 'undo' your held keys in the type phase.\nthis means, if you want to do SHIFT when held, type S if not, your config will look like this:\nholding key: DOWN(KC_LSFT)\ntyping part: U(KC_LSFT),TYPE(KC_S)"), 0, 4, 3, 1);


    }

    private void showLayerToggle(GridPane content) {
        content.getChildren().clear();
        content.add(new Label("layer toggle macro:"), 0, 0, 2, 1);
        layersCBX = createLayerCBX();
        content.add(new Label("layer:"), 0, 1);
        content.add(layersCBX, 1, 1);
        holdAndType = new CheckBox("hold and type");
        content.add(holdAndType, 0, 2);
        timeoutCBX = createTimeoutCBX();
        content.add(timeoutCBX, 1, 2);
        timeoutCBX.setVisible(false);
        holdAndType.addEventHandler(ActionEvent.ACTION, event -> {
            timeoutCBX.setVisible(!timeoutCBX.isVisible());
        });
    }

    private ComboBox<String> createLayerCBX() {
        ComboBox<String> ret = new ComboBox<>();
        for (String k : layout.getLayers().keySet()) {
            ret.getItems().add(k);
        }
        return ret;
    }

    private Macro getLayerToggleMacro() {
        Macro ret;
        if (holdAndType.isSelected()) {
            LayerToggleAndHoldMacro lth = new LayerToggleAndHoldMacro();
            lth.setLayer(layersCBX.getSelectionModel().getSelectedItem());
            lth.setTimeout(timeoutCBX.getSelectionModel().getSelectedItem());
            ret = lth;
        } else {
            LayerToggleMacro lt = new LayerToggleMacro();
            lt.setLayer(layersCBX.getSelectionModel().getSelectedItem());
            lt.setName(nameTF.getText());
            ret = lt;
        }
        ret.setName(nameTF.getText());
        return ret;
    }

    private void showTypeMacro(GridPane content) {
        content.getChildren().clear();
        content.add(new Label("type macro:"), 0, 0, 2, 1);

        macroContent1 = new TextField("");
        macroContent1.setPrefWidth(500);
        content.add(macroContent1, 0, 1);
        Button btn = new Button("Convert text to macro");
        content.add(btn, 0, 2);
        btn.addEventHandler(ActionEvent.ACTION, event -> {
            String txt = macroContent1.getText();
            String newTxt = macronifyString(txt);
            macroContent1.setText(newTxt);
        });
        content.add(new Label("Description: DOWN(KEYCODE) - simulate pressing key\nUP(KEYCODE) - Release key\nTYPE(KEYCODE) - Type key\nW(MILLIES) - wait milliseconds\nI(MILLIES) - set Interval to ms\nAttention: when adding a keycode that actually is a combination of modifier+key, it will not work in the macro!"), 0, 3, 2, 1);

    }

    private ComboBox<Integer> createTimeoutCBX() {
        ComboBox<Integer> cbx = new ComboBox<>();
        for (int i = 50; i < 250; i += 10) cbx.getItems().add(i);
        cbx.getSelectionModel().select(Integer.valueOf(150));
        return cbx;
    }

    private Macro getTypeMacro() {
        TypeMacro tm = new TypeMacro();
        tm.setName(nameTF.getText());
        try {
            tm.setActions(KeymapParser.parseActionList(macroContent1.getText().toUpperCase()));
            return tm;
        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Could not parse content! please fix:\n" + e.getMessage(), ButtonType.CLOSE);
            a.showAndWait();
            return null;
        }
    }

    private Macro getLongPressMacro() {
        LongPressAndTypeMacro lp = new LongPressAndTypeMacro();
        lp.setName(nameTF.getText());
        try {
            lp.setShortStrokes(KeymapParser.parseActionList(macroContent2.getText().toUpperCase()));
        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Could not parse type! please fix:\n" + e.getMessage(), ButtonType.CLOSE);
            a.showAndWait();
            return null;
        }
        try {
            lp.setLongPressKeys(KeymapParser.parseActionList(macroContent1.getText().toUpperCase()));
        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Could not parse hold! please fix:\n" + e.getMessage(), ButtonType.CLOSE);
            a.showAndWait();
            return null;
        }
        lp.setTimeout(timeoutCBX.getSelectionModel().getSelectedItem());
        return lp;
    }

    private String macronifyString(String txt) {
        if (txt.length() == 0) return txt;
        StringBuilder b = new StringBuilder();
        boolean shift = false;
        for (int i = 0; i < txt.length(); i++) {
            char c = txt.charAt(i);
            if (Character.isAlphabetic(c) && Character.isUpperCase(c)) {
                if (!shift) {
                    b.append("DOWN(KC_LSFT),");
                }
                b.append("TYPE(KC_").append(Character.toString(c)).append(")");
                shift = true;
            } else if (Character.isAlphabetic(c) && !Character.isUpperCase(c)) {
                if (shift) {
                    b.append("UP(KC_LSFT),");
                }
                b.append("TYPE(").append("KC_").append(Character.toString(c).toUpperCase()).append(")");
                shift = false;
            } else if (Character.isDigit(c)) {
                if (shift) {
                    b.append("UP(KC_LSFT),");
                }
                shift = false;
                b.append("TYPE(KC_" + Character.toString(c) + ")");
            } else if (Character.isSpaceChar(c)) {
                if (shift) {
                    b.append("UP(KC_LSFT),");
                }
                shift = false;
                b.append("TYPE(KC_SPC)");
            } else {
                if (shift) {
                    b.append("UP(KC_LSFT),");
                }
                shift = false;
                switch (c) {
                    case '!':
                        b.append("TYPE(KC_EXLM)");
                        break;
                    case ':':
                        b.append("TYPE(KC_COLN)");
                        break;
                    case '#':
                        b.append("TYPE(KC_HASH)");
                        break;
                    case ';':
                        b.append("TYPE(KC_SCLN)");
                        break;
                    case '$':
                        b.append("TYPE(KC_DLR)");
                        break;
                    case '-':
                        b.append("TYPE(KC_MINS)");
                        break;
                    case '(':
                        b.append("TYPE(KC_LBRC)");
                        break;
                    case ')':
                        b.append("TYPE(KC_RBRC)");
                        break;
                    case '{':
                        b.append("TYPE(KC_LCBRK)");
                        break;
                    case '}':
                        b.append("TYPE(KC_RCBRK)");
                        break;
                    default:
                        b.append("?");
                        b.append(Character.toString(c));
                        b.append("?");
                }
            }
            b.append(",");
        }
        b.setLength(b.length() - 1);
        return b.toString();
    }

    public Macro getTheMacro() {
        return theMacro;
    }

    public void setTheMacro(Macro theMacro) {
        this.theMacro = theMacro;
    }
}
