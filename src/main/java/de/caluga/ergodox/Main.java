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

package de.caluga.ergodox; /**
 * Created by stephan on 29.03.16.
 */

import de.caluga.ergodox.macrodialog.MacroDialog;
import de.caluga.ergodox.macros.Macro;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.*;


/**
 * TODO: Add Documentation here
 **/
public class Main extends Application {
    public static final String BASELAYERNAME = "Base";
    public static final String VERSION = "ErgodoxLayoutGenerator V1.0BETA1";
    private static final File configFile = new File(System.getProperty("user.home") + "/.ergodoxgenerator.conf");
    public static Properties applicationSettings;
    public final int pixelWidth = 40;
    public final int pixelHeight = 25;
    public final int pixelOffsetX = 5;
    public final int pixelOffsetY = 5;
    public final int offsetX = 25;
    public final int offsetY = 75;
    private final String qmksourcedir = "qmksourcedir";
    public int rightHalfOffset = 400;
    private double scaleX = 1.0;
    private double scaleY = 1.0;
    private GuiKey selectedGuiKey = null;
    private Button setSourceDir;
    private Label sourceDirLabel;
    private Button createKeymap;
    private Button openBtn;
    private Button saveBtn;
    private Button reopenBtn;
    private int basicCalculationWith;
    private int basicCalculationHeight;
    private double currentWindowHeight;
    //    private ComboBox<String> macroCombo;
    private double currentWindowWidth;
    private ComboBox<String> layerCombo;
    private Button createLayer;
    private Button renameLayer;
    private Button deleteLayer;
    private ErgodoxLayoutLayer currentLayer;
    private Pane canvas;
    private File qmkSourceDir;
    private Label legendStandardKey;
    private Label legendLayerSwitch;
    private Label legendTempSwitch;
    private Label legendMacroCall;
    private Label legendModifierKey;
    private Label legendCombination;
    private Label legendHoldKey;
    private Label keyDescription;
    private Button saveImgBtn;
    private String currentKeymap;
    private Label ledDesc;
    private Label led1;
    private Label led2;
    private Label led3;
    private ErgodoxLayout ergodoxLayout;
    private String lastOpenedFile = "last_opened_file";

    private List<GuiKey> guiKeys = new ArrayList<>();
    private Button compileBtn;


    public static void main(String[] args) {
        launch(args);
    }

    public static Map<String, String> getPrefixDescriptionMap() {
        Map<String, String> prefixDescriptionByPrefix = new HashMap();
        prefixDescriptionByPrefix.put("ALL", "show all keys");
        prefixDescriptionByPrefix.put("KC", "Default keys / US layout");
        prefixDescriptionByPrefix.put("BL", "BL-Layout");
        prefixDescriptionByPrefix.put("BP", "BP-Layout");
        prefixDescriptionByPrefix.put("DE", "German keyboard layout");
        prefixDescriptionByPrefix.put("DE_OSX", "German keyboard layout for Mac OSX");
        prefixDescriptionByPrefix.put("DV", "DVORAK");
        prefixDescriptionByPrefix.put("ES", "Spanish layout");
        prefixDescriptionByPrefix.put("FR", "French layout");
        prefixDescriptionByPrefix.put("NEO", "German NEO2 layout");
        prefixDescriptionByPrefix.put("NO", "Norwegian layout");
        prefixDescriptionByPrefix.put("UK", "United Kingdom");
        return prefixDescriptionByPrefix;
    }

    public static List<String> getKeyCodesList() {
        List<String> choices = new ArrayList<>();
        for (ErgodoxKeyCode c : ErgodoxKeyCode.values()) {
            choices.add(c.name());
        }

        return choices;
    }

    public static void saveConfig() {
        try {
            applicationSettings.store(new FileWriter(configFile), "Ergodox Layout Generator");
        } catch (Exception e) {
            //ignore
        }
    }

    public static String getKeyDisplayText(String kval, Map<String, Macro> macros) {
        String ret = "";
        if (kval == null) return "";
        if (kval.equals("KC_TRNS")) {
            ret = "";
        } else if (kval.startsWith("TG(")) {
            ret = kval.substring(3).replaceAll("\\)", "");
        } else if (kval.startsWith("ALL_T(")) {
            String s = kval.substring(6).replaceAll("\\)", "");
            s = getKeyDisplayName(s.substring(s.lastIndexOf('_') + 1));
            ret = s + "\nHyper";
        } else if (kval.startsWith("MEH_T(")) {
            String s = kval.substring(6).replaceAll("\\)", "");
            s = getKeyDisplayName(s.substring(s.lastIndexOf('_') + 1));
            ret = s + "\nMeh";
        } else if (kval.startsWith("ALT_T(")) {
            String s = kval.substring(6).replaceAll("\\)", "");
            s = getKeyDisplayName(s.substring(s.lastIndexOf('_') + 1));
            ret = s + "\nALT";
        } else if (kval.startsWith("CTL_T(")) {
            String s = kval.substring(6).replaceAll("\\)", "");
            s = getKeyDisplayName(s.substring(s.lastIndexOf('_') + 1));
            ret = s + "\nCtrl";
        } else if (kval.startsWith("GUI_T(")) {
            String s = kval.substring(6).replaceAll("\\)", "");
            s = getKeyDisplayName(s.substring(s.lastIndexOf('_') + 1));
            ret = s + "\nCMD";
        } else if (kval.startsWith("LT(")) {
            String s = kval.substring(3).replaceAll("\\)", "");
            String lt[] = s.split(",");
            String layer = lt[0];
            String key = lt[1];
            ret = getKeyDisplayName(key.substring(key.lastIndexOf('_') + 1)) + "\n" + layer;
        } else if (kval.startsWith("LGUI(")) {
            String s = kval.substring(5).replaceAll("\\)", "");
            ret = "CMD+" + getKeyDisplayName(s.substring(s.lastIndexOf('_') + 1));
        } else if (kval.startsWith("LCTL(")) {
            String s = kval.substring(5).replaceAll("\\)", "");
            ret = "Ctrl+" + getKeyDisplayName(s.substring(s.lastIndexOf('_') + 1));
        } else if (kval.startsWith("LALT(")) {
            String s = kval.substring(5).replaceAll("\\)", "");
            ret = "ALT+" + getKeyDisplayName(s.substring(s.lastIndexOf('_') + 1));
        } else if (kval.startsWith("LSFT(")) {
            String s = kval.substring(5).replaceAll("\\)", "");
            ret = "Shift+" + getKeyDisplayName(s.substring(s.lastIndexOf('_') + 1));
        } else if (kval.startsWith("M(")) {
            ret = kval.substring(2);
            ret = ret.substring(0, ret.length() - 1);
            Macro macro = macros.get(ret);
            if (macro != null) ret = macro.getMacroGuiText();
            ret = getKeyDisplayName(ret);
        } else if (!kval.contains("_") || kval.contains("(")) {
            ret = kval;
        } else {
            try {
                ErgodoxKeyCode k = ErgodoxKeyCode.valueOf(kval.trim());
                if (k == null) {
                    //error
                    ret = "invalid";
                } else {
                    ret = getKeyDisplayName(kval.substring(kval.lastIndexOf('_') + 1));
                }
            } catch (IllegalArgumentException e) {
                ret = "invalid";
            }
        }

        return ret;
    }

    private static String getKeyDisplayName(String ret) {
        ret = ret.replaceAll("LSFT", "Shift")
                .replaceAll("RSFT", "Shift")
                .replaceAll("LSHIFT", "Shift")
                .replaceAll("RSHIFT", "Shift")
                .replaceAll("KC_NO", "None")
                .replaceAll("KC_", "");
        ret = ret.replaceAll("^AE", "Ä");
        ret = ret.replaceAll("^OE", "Ö");
        ret = ret.replaceAll("^UE", "Ü");
        ret = ret.replaceAll("^SS", "ß");
        ret = ret.replaceAll("^LESS", "<");
        ret = ret.replaceAll("^MORE", ">");
        ret = ret.replaceAll("^PIPE", "|");
        ret = ret.replaceAll("^TILDE", "~");
        ret = ret.replaceAll("^TILD", "~");
        ret = ret.replaceAll("^EXLM", "!");
        ret = ret.replaceAll("^CIRC", "°");
        ret = ret.replaceAll("^DLR", "\\$");
        ret = ret.replaceAll("^QST", "?");
        ret = ret.replaceAll("^DOT", ".");
        ret = ret.replaceAll("^COMMA", ",");
        ret = ret.replaceAll("^COMM", ",");
        ret = ret.replaceAll("^SLSH", "/");
        ret = ret.replaceAll("^BSLS", "\\\\");
        ret = ret.replaceAll("^PERC", "%");
        ret = ret.replaceAll("^SLASH", "/");
        ret = ret.replaceAll("^HASH", "#");
        ret = ret.replaceAll("^LPRN", "(");
        ret = ret.replaceAll("^RPRN", ")");
        ret = ret.replaceAll("^PLUS", "+");
        ret = ret.replaceAll("^COLN", ":");
        ret = ret.replaceAll("^SCLN", ";");
        ret = ret.replaceAll("^MINS", "-");
        ret = ret.replaceAll("^EQL", "=");
        ret = ret.replaceAll("^LCBR", "{");
        ret = ret.replaceAll("^RCBR", "}");
        ret = ret.replaceAll("^LBRC", "[");
        ret = ret.replaceAll("^RBRC", "]");
        ret = ret.replaceAll("^UNDS", "_");
        ret = ret.replaceAll("^AT", "@");
        ret = ret.replaceAll("^EURO", "€");
        ret = ret.replaceAll("^AMPR", "&");
        ret = ret.replaceAll("^PARA", "§");
        ret = ret.replaceAll("^DQUOT", "\"");
        ret = ret.replaceAll("^QUOT", "'");
        ret = ret.replaceAll("^ASTR", "*");
        ret = ret.replaceAll("^GRV", "`");
        ret = ret.replaceAll("^ACCUT", "");
        ret = ret.replaceAll("^SQ2", "²");
        ret = ret.replaceAll("^SQ3", "³");
        ret = ret.replaceAll("LCTL", "Ctrl");
        ret = ret.replaceAll("LCTRL", "Ctrl");
        ret = ret.replaceAll("LALT", "Alt");
        ret = ret.replaceAll("RALT", "Alt");

        //osx vs. windows vs linux?
        ret = ret.replaceAll("LGUI", "Cmd");
        ret = ret.replaceAll("RGUI", "Cmd");
        return ret;
    }

    public void start(Stage primaryStage) throws Exception {


        StackPane root = new StackPane();

        newLayout();

        canvas = new Pane();
        canvas.setStyle("-fx-background-color: white;");
        basicCalculationWith = 800;
        basicCalculationHeight = 500;
        this.currentWindowWidth = basicCalculationWith;
        this.currentWindowHeight = basicCalculationHeight;
        rightHalfOffset = basicCalculationWith / 2;
        canvas.setPrefSize(1000, 700);
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!event.isConsumed()) {
                    if (selectedGuiKey == null) return;
                    selectedGuiKey.deselect();
                    selectedGuiKey = null;
                    layout();
                }
            }
        });
        root.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            // System.out.println("KEyEvent: "+event.getCode().impl_getCode()+" name: KC_"+event.getCode().getName());
//            if (selectedGuiKey != null) {
//                currentLayer.getLayout().get(selectedKeyIndexInLayout).setValue(event.getCode().getName().toUpperCase());
//                unmarkKey();
//                selectedGuiKey = null;
//                layout();
//            } else {
//            }
            if (event.getCode().getName().equals("O")) {
                openDialog(primaryStage);
            } else if (event.getCode().getName().equals("K")) {
                openKeymap(primaryStage);
            }
        });
        int idx = 0;
        for (Key k : currentLayer.getLayout()) {
//            Button btn=new Button("");
            if (k instanceof Key.NullKey) {
                idx++;
                continue;
            }
            final GuiKey gk = new GuiKey();

//            label.backgroundProperty().setValue(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(5), Insets.EMPTY)));
//            label.setTextAlignment(TextAlignment.CENTER);
//            label.borderProperty().setValue(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
//            DropShadow ds = new DropShadow();
//            ds.setOffsetY(3.0f);
//            ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
//            label.setEffect(ds);
            final int i = idx;
            MenuItem clearMI = new MenuItem("clear");
            clearMI.addEventHandler(ActionEvent.ACTION, event -> {
                currentLayer.getLayout().get(i).setValue("KC_TRNS");
                selectedGuiKey.deselect();
                selectedGuiKey = null;
                Platform.runLater(() -> layout());
            });
            gk.getInner().addEventHandler(ContextMenuEvent.CONTEXT_MENU_REQUESTED, event -> {
                if (selectedGuiKey != null) selectedGuiKey.deselect();
                gk.select();
                selectedGuiKey = gk;
                layout();
            });
            MenuItem assignKey = new MenuItem("Assign key");
            assignKey.addEventHandler(ActionEvent.ACTION, event -> {
                doAssignKey(currentLayer.getLayout().get(i));
                Platform.runLater(() -> layout());
            });

            MenuItem assignMacro = new MenuItem("Assign Macro");
            assignMacro.addEventHandler(ActionEvent.ACTION, event -> {
                doAssignMacro(currentLayer.getLayout().get(i));
                Platform.runLater(() -> layout());
            });
            MenuItem assignLayerToggle = new MenuItem("Assign Layertoggle");
            assignLayerToggle.addEventHandler(ActionEvent.ACTION, event -> {
                doAssingLayerToggle(currentLayer.getLayout().get(i));
                Platform.runLater(() -> layout());
            });
            MenuItem assignLT = new MenuItem("Assign LayerToggle/Type");
            assignLT.addEventHandler(ActionEvent.ACTION, event -> {
                doAssignLT(currentLayer.getLayout().get(i));
                Platform.runLater(() -> layout());
            });
            gk.getInner().setContextMenu(new ContextMenu(clearMI, assignKey, assignLayerToggle, assignLT, assignMacro));
            gk.getInner().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                event.consume();
                if (!event.getButton().equals(MouseButton.PRIMARY)) return;
                Key k1 = currentLayer.getLayout().get(i);

                if (event.getClickCount() > 1) {
//                    gk.getInner().getContextMenu().show(gk.getInner(), Side.TOP,10,10);return;
                    if (k1.getValue() == null) {
                        doAssignKey(k1);
                    } else if (k1.getValue().startsWith("M(")) {
                        doAssignMacro(k1);
                    } else if (k1.getValue().startsWith("LT(")) {
                        doAssignLT(k1);
                    } else if (k1.getValue().startsWith("TG(")) {
                        doAssingLayerToggle(k1);
                    } else {
                        doAssignKey(k1);
                    }
                    Platform.runLater(() -> layout());
                    return;
                }

                System.out.println("Key at " + i + " " + k1.getWidth() + "x" + k1.getHeight() + " value: " + k1.getValue());
                if (selectedGuiKey != null) {
                    selectedGuiKey.deselect();
                }
                gk.select();

                keyDescription.setText(getKeyDescription(k1.getValue()));
                selectedGuiKey = gk;
                layout();
            });
            gk.addToPane(canvas);
            guiKeys.add(gk);
//            canvas.getChildren().add(new Rectangle(100,100,100,100));
            idx++;
        }

        setSourceDir = new Button("Set qmk-SourceDir");
        setSourceDir.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                openDialog(primaryStage);

            }
        });
        openBtn = new Button("open");
        openBtn.addEventHandler(ActionEvent.ACTION, event -> {
            openKeymap(primaryStage);
        });
        reopenBtn = new Button("reopen last");
        reopenBtn.addEventHandler(ActionEvent.ACTION, event -> {
            String f = applicationSettings.getProperty(lastOpenedFile);
            if (f == null) return;
            File file = new File(f);
            try {
                readKeymapFile(primaryStage, file);
            } catch (Exception e) {
                //TODO: Implement Handling
                throw new RuntimeException(e);
            }
        });

        saveBtn = new Button("save");
        saveBtn.addEventHandler(ActionEvent.ACTION, event -> {
            saveKeymap();
        });
        saveImgBtn = new Button("Save img");
        saveImgBtn.addEventHandler(ActionEvent.ACTION, event -> saveAsPng());
        sourceDirLabel = new Label("...");
        createKeymap = new Button("create");
        createKeymap.addEventHandler(ActionEvent.ACTION, event -> {
            newLayout();
            primaryStage.setTitle("*new layout");
            layout();
        });
        compileBtn = new Button("compile");
        compileBtn.addEventHandler(ActionEvent.ACTION, event -> {
            doCompile();
        });
//        macroCombo = new ComboBox<>();
//        macroCombo.getItems().add("Smiley :-D");
//        macroCombo.getItems().add("Smiley :-(");
//        macroCombo.getItems().add("CTRL_SHIFT/#");

        layerCombo = new ComboBox<>();
        layerCombo.getItems().add(BASELAYERNAME);
        layerCombo.getSelectionModel().select(0);
        layerCombo.addEventHandler(ActionEvent.ACTION, event -> {
            System.out.println("Selected!");
            if (layerCombo.getSelectionModel().getSelectedIndex() < 0) return;
            currentLayer = ergodoxLayout.getLayers().get(layerCombo.getSelectionModel().getSelectedItem());
            Platform.runLater(() -> layout());
        });

        deleteLayer = new Button("delete layer");
        deleteLayer.addEventHandler(ActionEvent.ACTION, event -> {
            if (!ergodoxLayout.getLayers().containsKey(currentLayer.getName())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Cannot delete layer");
                alert.setContentText("Internal error - layer to delete is unknown!");

            } else if (layerCombo.getItems().size() == 1) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Cannot delete layer");
                alert.setContentText("An ergodox layour needs at least one layer!");

                alert.showAndWait();
            } else {
                ergodoxLayout.getLayers().remove(currentLayer.getName());
                layerCombo.getItems().remove(currentLayer.getName());
                layerCombo.getSelectionModel().select(0);
                currentLayer = ergodoxLayout.getLayers().get(layerCombo.getItems().get(0));
                Platform.runLater(() -> layout());
            }
        });
        createLayer = new Button("add layer");
        createLayer.addEventHandler(ActionEvent.ACTION, event -> {
            String layerName = "Layer_" + ergodoxLayout.getLayers().size();
            while (true) {
                layerName = askForLayerName(layerName);
                if (layerName == null) return;
                if (ergodoxLayout.getLayers().get(layerName) != null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Layer name not unique");
                    alert.setContentText("layer names need to be unique! A layer with name " + layerName + " already exists!");

                    alert.showAndWait();
                } else {
                    break;
                }
            }
            ErgodoxLayoutLayer l = new ErgodoxLayoutLayer(layerName);
            ergodoxLayout.getLayers().put(l.getName(), l);
            currentLayer = l;
            layerCombo.getItems().add(l.getName());
            layerCombo.getSelectionModel().select(layerCombo.getItems().size() - 1);
            Platform.runLater(() -> layout());
        });

        renameLayer = new Button("rename layer");
        renameLayer.addEventHandler(ActionEvent.ACTION, event -> {
            String layerName = askForLayerName(currentLayer.getName());
            if (layerName != null) {
                layerCombo.getItems().remove(currentLayer.getName());
                currentLayer.setName(layerName);
                layerCombo.getItems().add(layerName);
                layerCombo.getSelectionModel().select(layerName);
                Platform.runLater(() -> layout());
            }
        });

        legendStandardKey = new Label("std key");
        layoutLabel(legendStandardKey, Color.LIGHTGRAY);
        legendLayerSwitch = new Label("layer toggle");
        layoutLabel(legendLayerSwitch, Color.LIGHTCORAL);
        legendTempSwitch = new Label("key\ntemp layer");
        layoutLabel(legendTempSwitch, Color.LIGHTGREEN);
        legendMacroCall = new Label("Macro call");
        layoutLabel(legendMacroCall, Color.LIGHTYELLOW);
        legendModifierKey = new Label("Modifier");
        layoutLabel(legendModifierKey, Color.LIGHTBLUE);
        legendCombination = new Label("Combinations");
        layoutLabel(legendCombination, Color.LIGHTCYAN);
        legendHoldKey = new Label("Type Key \n hold key");
        layoutLabel(legendHoldKey, Color.LIGHTSKYBLUE);

        keyDescription = new Label("");

        ledDesc = new Label("LEDs:");
        led1 = new Label("●");
        led1.setTextFill(Color.GRAY);
        led1.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            currentLayer.setLed1(!currentLayer.isLed1());
            Platform.runLater(() -> layout());
        });

        led2 = new Label("●");
        led2.setTextFill(Color.GRAY);
        led2.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            currentLayer.setLed2(!currentLayer.isLed2());
            Platform.runLater(() -> layout());
        });

        led3 = new Label("●");
        led3.setTextFill(Color.GRAY);
        led3.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            currentLayer.setLed3(!currentLayer.isLed3());
            Platform.runLater(() -> layout());
        });

//        canvas.getChildren().add(macroCombo);
        canvas.getChildren().add(setSourceDir);
        canvas.getChildren().add(openBtn);
        canvas.getChildren().add(reopenBtn);
        canvas.getChildren().add(saveBtn);
        canvas.getChildren().add(saveImgBtn);
        canvas.getChildren().add(sourceDirLabel);
        canvas.getChildren().add(createKeymap);
        canvas.getChildren().add(createLayer);
        canvas.getChildren().add(deleteLayer);
        canvas.getChildren().add(renameLayer);
        canvas.getChildren().add(layerCombo);
        canvas.getChildren().add(legendLayerSwitch);
        canvas.getChildren().add(legendMacroCall);
        canvas.getChildren().add(legendModifierKey);
        canvas.getChildren().add(legendStandardKey);
        canvas.getChildren().add(legendTempSwitch);
        canvas.getChildren().add(legendCombination);
        canvas.getChildren().add(legendHoldKey);
        canvas.getChildren().add(ledDesc);
        canvas.getChildren().add(led1);
        canvas.getChildren().add(led2);
        canvas.getChildren().add(led3);
        canvas.getChildren().add(keyDescription);
        canvas.getChildren().add(compileBtn);
        Platform.runLater(() -> layout());
//        layout();

        root.getChildren().add(canvas);
//        Circle circle = new Circle(50,Color.BLUE);
//        circle.relocate(20, 20);
//        Rectangle rectangle = new Rectangle(100,100,Color.RED);
//        rectangle.relocate(70,70);
//        canvas.getChildren().addAll(circle,rectangle);

        updateWindowWidth(800);
        updateWindowHeight(800);
        Scene scene = new Scene(root, 800, 800);

        primaryStage.setTitle("ErgodoxLayoutGenerator");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.widthProperty().addListener((observable, oldValue, newValue) -> {
//            System.out.println("New width: " + newValue.toString());

            updateWindowWidth(newValue.doubleValue());
        });
        scene.heightProperty().addListener((observable, oldValue, newValue) -> {
//            System.out.println("New height: " + newValue.toString());
            updateWindowHeight(newValue.doubleValue());
        });

        //Read in config

        readConfig();

    }

    private void doCompile() {
        if (qmkSourceDir == null || !qmkSourceDir.exists()) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Cannot compile if QMK-Sourcedir is not set!", ButtonType.CLOSE);
            a.showAndWait();
            return;
        }
        if (currentKeymap == null) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Please store keymap first!", ButtonType.CLOSE);
            a.showAndWait();
            return;
        }

        StringWriter wr = new StringWriter();
        try {
            if (execCommand(wr, "make clean") != 0) throw new RuntimeException("Make clean failed!");
            if (execCommand(wr, "make") != 0) throw new RuntimeException("Compilation failed");
            showLongContent("Compilation sucessful", wr.toString());
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Shall I copy the resulting .hex-file to the corresponding layout dir?", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> res = a.showAndWait();
            if (res.isPresent()) {
                if (res.get().equals(ButtonType.YES)) {
                    try {
                        Path source = FileSystems.getDefault().getPath(qmkSourceDir.getAbsolutePath(), "keyboard", "ergodox_ez", "ergodox_ez.hex");
                        Path dest = FileSystems.getDefault().getPath(qmkSourceDir.getAbsolutePath(), "keyboard", "ergodox_ez", "keymaps", currentKeymap, currentKeymap + ".hex");
                        Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        showErrorMessage("Could not copy hex file", e);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(new PrintWriter(wr));
            showLongContent("Compilation failed", wr.toString());
        }
    }

    private int execCommand(final Writer wr, String cmd) throws Exception {
        String pth = System.getenv("PATH");
        pth += ":/usr/local/bin";
        wr.write("---------------------->        Running command: " + cmd + "\n");
        Process p = Runtime.getRuntime().exec(cmd, new String[]{"PATH=" + pth, "KEYMAP=" + currentKeymap}, new File(qmkSourceDir.getAbsolutePath() + "/keyboard/ergodox_ez/"));


        new Thread() {
            public void run() {
                String l = null;
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                try {
                    while ((l = br.readLine()) != null) {
                        wr.write(l);
                        wr.write("\n");
                        System.out.println(l);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();

        new Thread() {
            public void run() {
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String l = null;
                try {
                    while ((l = br.readLine()) != null) {
                        wr.write(l);
                        wr.write("\n");
                        System.out.println(l);
                    }
                } catch (IOException e) {
                    //TODO: Implement Handling
                    throw new RuntimeException(e);
                }
            }
        }.start();


        p.waitFor();
        return p.exitValue();


    }

    private void newLayout() {
        ergodoxLayout = new ErgodoxLayout();
        currentLayer = new ErgodoxLayoutLayer(BASELAYERNAME); //base
        ergodoxLayout.getLayers().put(currentLayer.getName(), currentLayer);
    }

    private void updateWindowHeight(double newValue) {
        currentWindowHeight = newValue;
        if (currentWindowHeight >= basicCalculationHeight) {
            scaleY = currentWindowHeight / (double) basicCalculationHeight;
            Platform.runLater(() -> layout());

        }
    }

    private void updateWindowWidth(double newValue) {
        currentWindowWidth = newValue;
        if (currentWindowWidth >= basicCalculationWith) {
            scaleX = currentWindowWidth / (double) basicCalculationWith;
            rightHalfOffset = (int) (currentWindowWidth / 2);
//                    System.out.println("Drawing with new scale of "+scaleX);
            Platform.runLater(() -> layout());

        }
    }

    private String askForLayerName(String o) {
        while (true) {
            TextInputDialog dialog;
            if (o != null) {
                dialog = new TextInputDialog(o);
            } else {
                dialog = new TextInputDialog("");
            }
            dialog.setTitle("Choose your layer name");
            dialog.setHeaderText("Layer name");

            Optional<java.lang.String> result = dialog.showAndWait();
            if (result.isPresent()) {
                o = result.get();
                if (!o.matches("^[a-zA-Z0-9_]+$")) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Layername malformed");
                    alert.setContentText("A layername must only contains a-z, A-Z, 0-9 and _!");

                    alert.showAndWait();
                    continue;
                }
                return o;
            }

            return null;
        }
    }

    private void doAssignMacro(Key k) {
        try {
            MacroDialog dlg = new MacroDialog(ergodoxLayout);
            dlg.show(k);
        } catch (Exception e) {
            showErrorMessage("Could not assign macro", e);
        }
    }

    private void doAssingLayerToggle(Key k) {
        try {
            AssignLayerToggleDialog dlg = new AssignLayerToggleDialog(ergodoxLayout);
            dlg.show(k);
        } catch (Exception e) {
            showErrorMessage("could not assign layertoggle", e);
        }

    }

    private void doAssignLT(Key k) {
        try {
            AssignLTDialog dlg = new AssignLTDialog(ergodoxLayout);
            dlg.show(k);
        } catch (Exception e) {
            showErrorMessage("Could not assign LT", e);
        }

    }

    private void doAssignKey(Key k) {
        try {
            AssignKeyDialog ak = new AssignKeyDialog(ergodoxLayout);
            ak.show(k);
        } catch (Exception e) {
            showErrorMessage("could not assign key", e);
        }

    }

    public void saveKeymap() {
        try {
            FileChooser fc = new FileChooser();
            File startFile = new File(qmkSourceDir.getPath() + "/keyboard/ergodox_ez/keymaps/" + currentKeymap + "/keymap.c");
            if (!startFile.exists()) {
                startFile = new File(currentKeymap);
            }
            if (!startFile.exists()) {
                startFile = new File(qmkSourceDir.getPath() + "/keyboard/ergodox_ez/keymaps");
            }
            if (startFile.isDirectory()) {
                fc.setInitialDirectory(startFile);

            } else {
                fc.setInitialDirectory(startFile.getParentFile());
            }
            fc.setInitialFileName("keymap.c");


            File selected = fc.showSaveDialog(null);
            if (selected == null) return;

            if (!selected.getAbsolutePath().startsWith(qmkSourceDir.getAbsolutePath())) {
                Alert a = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO);
                a.setTitle("Warning");
                a.setContentText("Directory is not within the QMK-Source - you won't be able to compile it. Proceed?");
                a.setHeaderText("Directory location");

                Optional<ButtonType> result = a.showAndWait();
                if (result.get() != ButtonType.YES) {
                    saveKeymap();
                    return;
                }
            }
            if (!selected.getName().equals("keymap.c")) {
                Alert a = new Alert(Alert.AlertType.WARNING, "", ButtonType.YES, ButtonType.NO);
                a.setTitle("Warning");
                a.setContentText("File is not named keymap.c - you won't be able to compile. Proceed?");
                a.setHeaderText("Filename not ok");

                Optional<ButtonType> result = a.showAndWait();
                if (result.get() != ButtonType.YES) {
                    saveKeymap();
                    return;
                }
            }

            KeymapWriter writer = new KeymapWriter();
            writer.writeKeymapFile(ergodoxLayout, new File(selected.getAbsolutePath()));

            applicationSettings.setProperty(lastOpenedFile, selected.getAbsolutePath());
            saveConfig();

        } catch (Exception e) {
            showErrorMessage("Could not write keymap", e);
        }
    }

    private void showLongContent(String msg, String longContent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Info");
        alert.setContentText(msg);


// Create expandable Exception.
        Label label = new Label("Detailed info:");

        TextArea textArea = new TextArea(longContent);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

// Set expandable Exception into the dialog pane.
        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }

    private void showErrorMessage(String msg, Exception ex) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error during execution");
        alert.setHeaderText("There was an error");
        alert.setContentText(msg);


// Create expandable Exception.
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

// Set expandable Exception into the dialog pane.
        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }

    private void saveAsPng() {
        try {
            FileChooser fc = new FileChooser();
            File startFile = new File(qmkSourceDir.getPath() + "/keyboard/ergodox_ez/keymaps/" + currentKeymap);
            if (!startFile.exists()) {
                startFile = new File(currentKeymap);
            }
            if (!startFile.exists()) {
                startFile = new File(qmkSourceDir.getPath() + "/keyboard/ergodox_ez/keymaps");
            }
            fc.setInitialDirectory(startFile);
            fc.setInitialFileName(currentKeymap + "_highres.png");
            File file = fc.showSaveDialog(null);
            if (file == null) return;
            double width = canvas.getWidth();
            double height = canvas.getHeight();

//        canvas.setPrefHeight(1080);
//        canvas.setPrefWidth(1920);
            updateWindowHeight(1280);
            updateWindowWidth(720);
            layout();
            if (selectedGuiKey != null)
                selectedGuiKey.deselect();
            layerCombo.getSelectionModel().select(0);
            WritableImage image = canvas.snapshot(new SnapshotParameters(), null);

            int snapshotHeight = (int) (image.getHeight() - 65);
            int macroDescHeight = 50;
            for (String macroName : ergodoxLayout.getMacros().keySet()) {
                Macro macro = ergodoxLayout.getMacros().get(macroName);
                String description = macro.getDescription();

                int cnt = 0;
                int lidx = 0;
                while (description.indexOf('\n', lidx) > 0) {
                    cnt++;
                    lidx = description.indexOf('\n', lidx) + 1;
                }
                macroDescHeight += 40 + 30 * cnt;
            }
            BufferedImage img = new BufferedImage((int) image.getWidth(), snapshotHeight * layerCombo.getItems().size() + macroDescHeight, BufferedImage.TYPE_INT_RGB);
            createLayer.setVisible(false);
            deleteLayer.setVisible(false);
            keyDescription.setVisible(false);
            renameLayer.setVisible(false);


            for (int i = 0; i < layerCombo.getItems().size(); i++) {
                layerCombo.getSelectionModel().select(i);
                currentLayer = ergodoxLayout.getLayers().get(layerCombo.getItems().get(i));
                layout();
                image = canvas.snapshot(new SnapshotParameters(), null);
                img.getGraphics().drawImage(SwingFXUtils.fromFXImage(image, null), 0, i * snapshotHeight, null);
            }

            int x = 50;
            int y = 60;
            Canvas c = new Canvas(img.getWidth(), macroDescHeight);
            c.getGraphicsContext2D().setFont(Font.font(35));
            c.getGraphicsContext2D().fillText("Macro Descriptions:", 50, 25);
            c.getGraphicsContext2D().setFont(Font.font(20));
            for (String macroName : ergodoxLayout.getMacros().keySet()) {
                Macro macro = ergodoxLayout.getMacros().get(macroName);
                String description = macro.getDescription();
                c.getGraphicsContext2D().fillText(description, x, y);
                int cnt = 0;
                int lidx = 0;
                while (description.indexOf('\n', lidx) > 0) {
                    cnt++;
                    lidx = description.indexOf('\n', lidx) + 1;
                }
                y += 40 + 30 * cnt;
                c.getGraphicsContext2D().strokeLine(x - 10, y - 30, img.getWidth() - 10, y - 30);
            }

            image = c.snapshot(new SnapshotParameters(), null);
            img.getGraphics().drawImage(SwingFXUtils.fromFXImage(image, null), 0, layerCombo.getItems().size() * snapshotHeight, null);

            ImageIO.write(img, "png", file);
            Platform.runLater(() -> {
                layerCombo.getSelectionModel().select(0);
                updateWindowHeight(height);
                updateWindowWidth(width);
                //            canvas.setPrefHeight(height);
                //            canvas.setPrefWidth(width);

                //            layout();
            });
        } catch (Exception e) {
            showErrorMessage("Could not write png", e);
        } finally {

            createLayer.setVisible(true);
            deleteLayer.setVisible(true);
            keyDescription.setVisible(true);
            renameLayer.setVisible(true);
        }
    }

    private void readConfig() {
        File properties = configFile;
        if (properties.exists()) {
            try {
                applicationSettings = new Properties();
                applicationSettings.load(new FileInputStream(properties));
                qmkSourceDir = new File(applicationSettings.getProperty(qmksourcedir));
                sourceDirLabel.setText(qmkSourceDir.getPath());
            } catch (Exception e) {
                //ignore
            }
        }
        if (applicationSettings == null) {
            applicationSettings = new Properties();
        }
    }

    private void layoutLabel(Label l, Color c) {
        l.backgroundProperty().setValue(new Background(new BackgroundFill(c, new CornerRadii(5), Insets.EMPTY)));
        l.borderProperty().setValue(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
        l.setFont(Font.font(12));
        l.setAlignment(Pos.CENTER);
        l.setTextAlignment(TextAlignment.CENTER);
        l.setContentDisplay(ContentDisplay.CENTER);
    }

    private void openKeymap(Stage primaryStage) {
        try {
            FileChooser fc = new FileChooser();
            if (qmkSourceDir != null) {
                fc.setInitialDirectory(new File(qmkSourceDir.getPath() + "/keyboard/ergodox_ez/keymaps/"));
            } else {
                fc.setInitialDirectory(new File(System.getProperty("user.home")));
            }
            FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Keymap-Files", "keymap.c", "*.c");
            fc.getExtensionFilters().add(filter);
            fc.setSelectedExtensionFilter(filter);

            File file = fc.showOpenDialog(null);
            if (file == null) return;
            readKeymapFile(primaryStage, file);


            applicationSettings.setProperty(lastOpenedFile, file.getAbsolutePath());
            saveConfig();

        } catch (Exception e) {
            //TODO: Implement Handling
            throw new RuntimeException(e);
        }
    }

    private void readKeymapFile(Stage primaryStage, File selected) throws Exception {
        try {
            KeymapParser parser = new KeymapParser();
            ergodoxLayout = parser.parse(selected.getAbsolutePath());
            layerCombo.getItems().clear();
            for (String k : ergodoxLayout.getLayers().keySet()) {
                layerCombo.getItems().add(k);
            }
            layerCombo.getSelectionModel().select(0);
            currentLayer = ergodoxLayout.getLayers().get(layerCombo.getSelectionModel().getSelectedItem());


            Platform.runLater(() -> layout());
            primaryStage.setTitle(selected.getName());
            currentKeymap = selected.getParentFile().getName();
        } catch (Exception e) {
            showErrorMessage("Could not parse keymap file", e);
        }
    }

    private void openDialog(Stage primaryStage) {
        DirectoryChooser fc = new DirectoryChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        fc.setTitle("Choose qmk-source dir");
        qmkSourceDir = fc.showDialog(primaryStage);
        if (qmkSourceDir == null) return;
//                if (!qmkSourceDir.isDirectory()) {
//                    Alert alert=new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("No dir");
//                    alert.setContentText("the selected file is not a directory!");
//                    alert.show();
//                    return;
//                }
        sourceDirLabel.setText(qmkSourceDir.getPath());

        applicationSettings.setProperty(qmksourcedir, qmkSourceDir.getPath());
        saveConfig();
    }

    public void layout() {

        int row = 0;
        int x = (int) (offsetX * scaleX);
        int y = (int) (offsetY * scaleY);
        int idx = 0;
        int xoff = 0;
        int canvasIdx = 0;

        for (Key k : currentLayer.getLayout()) {

            idx++;
            if (k != null && !(k instanceof Key.NullKey)) {
                GuiKey b = guiKeys.get(canvasIdx++);
                Color bgcol = Color.LIGHTGRAY.darker();
                String kval = k.getValue() != null ? k.getValue() : "";
                if (kval.endsWith("SFT") || kval.endsWith("CTL") || kval.endsWith("ALT") || kval.endsWith("GUI")) {
                    bgcol = Color.LIGHTBLUE.darker();

                } else if (kval.startsWith("LT(")) {
                    bgcol = Color.LIGHTGREEN.darker();
                } else if (kval.startsWith("M(")) {
                    bgcol = Color.LIGHTYELLOW.darker();
                } else if (kval.startsWith("TG(")) {
                    bgcol = Color.LIGHTCORAL.darker();
                } else if (kval.contains("_T(")) {
                    bgcol = Color.LIGHTSKYBLUE.darker();
                } else if (kval.contains("(")) {
                    bgcol = Color.LIGHTCYAN.darker();
                }
                b.setInnerColor(bgcol.brighter());
                b.setOuterColor(bgcol);
//                b.backgroundProperty().setValue(new Background(new BackgroundFill(bgcol, new CornerRadii(5), Insets.EMPTY)));
                b.setText(getKeyDisplayText(kval, ergodoxLayout.getMacros()));
//                b.setFont(Font.font(8));
//                b.setAlignment(Pos.CENTER);
//                b.setTextAlignment(TextAlignment.CENTER);
//                b.setContentDisplay(ContentDisplay.CENTER);
                b.setWidth(k.getWidth() * pixelWidth * scaleX);
                b.setHeight(k.getHeight() * pixelWidth * scaleY);
//                b.setMaxWidth(k.getWidth() * pixelWidth * scaleX);
//                b.setPrefWidth(k.getWidth() * pixelWidth * scaleX);
//                b.setMinWidth(k.getWidth() * pixelWidth * scaleX);
//
//                b.setMaxHeight(k.getHeight() * pixelHeight * scaleY);
//                b.setPrefHeight(k.getHeight() * pixelHeight * scaleY);
//                b.setMinHeight(k.getHeight() * pixelHeight * scaleY);

                b.setX(x + k.getxOffset() * scaleX);
                b.setY(y + k.getyOffset() * scaleY);
                b.update();
//                g.setFill(Color.DARKGRAY);
//                g.fillRoundRect(x+4, y+4, k.getWidth() * pixelWidth, k.getHeight() * pixelHeight, 10, 10);
//                g.setFill(Color.GRAY);
//                g.fillRoundRect(x, y, k.getWidth() * pixelWidth, k.getHeight() * pixelHeight, 10, 10);
//                g.strokeRoundRect(x, y, k.getWidth() * pixelWidth, k.getHeight() * pixelHeight, 10, 10);
//                g.strokeText(idx + "/" + row, x, y + 15);
            }
            if (k instanceof Key.NullKey) idx--;
            if (idx >= currentLayer.getRowLength().get(row)) {

                row++;

                if (row >= currentLayer.getRowLength().size()) {
                    //switch to right half
                    y = (int) (offsetY * scaleY);
                    xoff = rightHalfOffset;
                    row = 0;
                    idx = 0;
                } else {
                    y += pixelHeight * scaleY + pixelOffsetY;
                    idx = 0;
                }
                x = xoff + (int) (offsetX * scaleX);
            } else {
                if (k != null) {
                    x += pixelWidth * k.getWidth() * scaleX + pixelOffsetX;
                } else {
                    x += pixelWidth + pixelOffsetX;
                }
            }

        }

//        macroCombo.relocate(currentWindowWidth / 2, currentWindowHeight - 100);
        setSourceDir.relocate(25, currentWindowHeight - 30);
        sourceDirLabel.relocate(25, currentWindowHeight - 60);
        createKeymap.relocate(currentWindowWidth - 100, currentWindowHeight - 30);
        saveBtn.relocate(currentWindowWidth / 2, currentWindowHeight - 60);
        saveImgBtn.relocate(currentWindowWidth / 2 + 50, currentWindowHeight - 60);
        openBtn.relocate(currentWindowWidth / 2, currentWindowHeight - 30);
        reopenBtn.relocate(currentWindowWidth / 2 + 50, currentWindowHeight - 30);
        compileBtn.relocate(currentWindowWidth - 200, currentWindowHeight - 30);

        layerCombo.relocate(5, 20);
        double cx = layerCombo.getWidth();
        renameLayer.relocate(cx + 20, 20);
        createLayer.relocate(cx + 120, 20);
        deleteLayer.relocate(cx + 200, 20);

        legendLayerSwitch.relocate(20, currentWindowHeight - 100);
        legendMacroCall.relocate(20, currentWindowHeight - 120);
        legendModifierKey.relocate(20, currentWindowHeight - 140);
        legendTempSwitch.relocate(currentWindowWidth - 100, currentWindowHeight - 100);
        legendCombination.relocate(currentWindowWidth - 100, currentWindowHeight - 120);
        legendStandardKey.relocate(currentWindowWidth - 100, currentWindowHeight - 140);

        legendHoldKey.relocate(currentWindowWidth - 200, currentWindowHeight - 100);

        ledDesc.relocate(currentWindowWidth - 200, 50);
        led1.relocate(currentWindowWidth - 150, 45);
        led2.relocate(currentWindowWidth - 135, 45);
        led3.relocate(currentWindowWidth - 120, 45);
        led1.setFont(Font.font(24));
        led2.setFont(Font.font(24));
        led3.setFont(Font.font(24));
        if (currentLayer.isLed1()) led1.setTextFill(Color.web("#FF0000"));
        else led1.setTextFill(Color.GRAY);
        if (currentLayer.isLed2()) led2.setTextFill(Color.web("#00FF00"));
        else led2.setTextFill(Color.GRAY);
        if (currentLayer.isLed3()) led3.setTextFill(Color.web("#8080FF"));
        else led3.setTextFill(Color.GRAY);

        keyDescription.relocate(currentWindowWidth / 2 - 100, currentWindowHeight - 150);
//        canvas.getChildren().add();
    }

    private String getKeyDescription(String kval) {
        if (kval == null) return "";
        String ret = "";
        if (kval.equals("KC_TRNS")) {
            ret = "Transparent key - fall back base layer";
        } else if (kval.startsWith("TG(")) {
            ret = "Toggle layer " + kval.substring(3).replaceAll("\\)", "");
        } else if (kval.startsWith("ALL_T(")) {
            String s = kval.substring(6).replaceAll("\\)", "");
            s = getKeyDisplayName(s);
            ret = "Type key: " + s + "\nHolding key: Hyper (=CMD+Ctrl+Shift+Alt)";
        } else if (kval.startsWith("MEH_T(")) {
            String s = kval.substring(6).replaceAll("\\)", "");
            s = getKeyDisplayName(s);
            ret = "Type key: " + s + "\nHolding key: Meh (=ALT+Ctrl+Shift)";
        } else if (kval.startsWith("ALT_T(")) {
            String s = kval.substring(6).replaceAll("\\)", "");
            s = getKeyDisplayName(s);
            ret = "Type key: " + s + "\nHoliding key: ALT";
        } else if (kval.startsWith("CTL_T(")) {
            String s = kval.substring(6).replaceAll("\\)", "");
            s = getKeyDisplayName(s);
            ret = "type key: " + s + "\nHolding key: Ctrl";
        } else if (kval.startsWith("GUI_T(")) {
            String s = kval.substring(6).replaceAll("\\)", "");
            s = getKeyDisplayName(s);
            ret = "Type key: " + s + "\nHolding key: CMD";
        } else if (kval.startsWith("LT(")) {
            String s = kval.substring(3).replaceAll("\\)", "");
            String lt[] = s.split(",");
            String layer = lt[0];
            String key = lt[1];
            ret = "Type key: " + getKeyDisplayName(key) + "\nLayer " + layer + " when held";
        } else if (kval.startsWith("ALL(")) {
            String s = kval.substring(5).replaceAll("\\)", "");
            ret = "Holds hyper keys and " + getKeyDisplayName(s);
        } else if (kval.startsWith("MEH(")) {
            String s = kval.substring(5).replaceAll("\\)", "");
            ret = "Holds meh keys and " + getKeyDisplayName(s);
        } else if (kval.startsWith("LGUI(")) {
            String s = kval.substring(5).replaceAll("\\)", "");
            ret = "Holds both CMD and " + getKeyDisplayName(s);
        } else if (kval.startsWith("LCTL(")) {
            String s = kval.substring(5).replaceAll("\\)", "");
            ret = "holds both Ctrl and " + getKeyDisplayName(s);
        } else if (kval.startsWith("LALT(")) {
            String s = kval.substring(5).replaceAll("\\)", "");
            ret = "holds both ALT and " + getKeyDisplayName(s);
        } else if (kval.startsWith("LSFT(")) {
            String s = kval.substring(5).replaceAll("\\)", "");
            ret = "holds both Shift and " + getKeyDisplayName(s);
        } else if (kval.startsWith("M(")) {
            ret = kval.substring(2);
            ret = ret.substring(0, ret.length() - 1);
            Macro macro = ergodoxLayout.getMacros().get(ret);
            if (macro != null) ret = macro.getDescription();
        } else if (!kval.contains("_") || kval.contains("(")) {
            ret = "Function call: " + kval;
        } else {
            //SAnity check:
            ErgodoxKeyCode k = ErgodoxKeyCode.valueOf(kval);
            if (k == null) {
                ret = "Invalid key " + ret;
            } else {
                ret = "Key: " + getKeyDisplayName(kval);
            }
        }

        return ret;
    }
}
