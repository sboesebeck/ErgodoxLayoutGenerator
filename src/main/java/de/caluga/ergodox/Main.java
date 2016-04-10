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

import de.caluga.ergodox.macros.LongPressAndTypeMacro;
import de.caluga.ergodox.macros.Macro;
import de.caluga.ergodox.macros.MacroAction;
import de.caluga.ergodox.macros.TypeMacro;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


/**
 * TODO: Add Documentation here
 **/
public class Main extends Application {
    public final int pixelWidth = 40;
    public final int pixelHeight = 25;
    public final int pixelOffsetX = 5;
    public final int pixelOffsetY = 5;

    public final int offsetX = 25;
    public final int offsetY = 75;
    private final File configFile = new File(System.getProperty("user.home") + "/.ergodoxgenerator.conf");
    private final String qmksourcedir = "qmksourcedir";

    public int rightHalfOffset = 400;
    private double scaleX = 1.0;
    private double scaleY = 1.0;

    private Label selectedGuiKey = null;

    private Button setSourceDir;
    private Label sourceDirLabel;
    private Button createKeymap;
    private Button openBtn;
    private Button saveBtn;
    private Button reopenBtn;
    private int initialWindowWidth;
    private int initialWindowHeight;
    private double currentWindowHeight;
    private double currentWindowWidth;
//    private ComboBox<String> macroCombo;

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
    private Properties applicationSettings;
    private String lastOpenedFile = "last_opened_file";


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {


        StackPane root = new StackPane();

//        Canvas c = new Canvas(800, 600);
//        c.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//            public void handle(MouseEvent event) {
//                double x = event.getX();
//                double y = event.getY();
//
//                boolean rightHalf=x>rightHalfOffset;
//                if (rightHalf){
//                    x-=rightHalfOffset;
//                }
//                int column=(int)((x-offsetX)/(pixelWidth +pixelOffset));
//                int row=(int)((y-offsetY)/(pixelHeight +pixelOffset));
//                System.out.println("Clicked! "+ x +"/"+ y+" == row: "+row+"  col: "+column);
//
//                int indexInLayout=0;
//                for (int i=0;i<row;i++){
//                    indexInLayout +=layers.getRowLength().get(i);
//                }
//                if (rightHalf) indexInLayout+=layers.keysOnHalf();
//                Key k=layers.getLayout().get(indexInLayout);
//                System.out.println("Got key; "+k.getWidth()+"x"+k.getHeight());
//
//            }
//        });
//        layout(c.getGraphicsCocntext2D());

        ergodoxLayout = new ErgodoxLayout();
        currentLayer = new ErgodoxLayoutLayer("base"); //base
        ergodoxLayout.getLayers().put(currentLayer.getName(), currentLayer);


        canvas = new Pane();
        canvas.setStyle("-fx-background-color: white;");
        initialWindowWidth = 800;
        initialWindowHeight = 500;
        this.currentWindowWidth = initialWindowWidth;
        this.currentWindowHeight = initialWindowHeight;
        rightHalfOffset = initialWindowWidth / 2;
        canvas.setPrefSize(initialWindowWidth, initialWindowHeight);
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!event.isConsumed()) {
                    unmarkKey();
                    selectedGuiKey = null;
                }
            }
        });
        root.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            // System.out.println("KEyEvent: "+event.getCode().impl_getCode()+" name: KC_"+event.getCode().getName());
//            if (selectedGuiKey != null) {
//                currentLayer.getLayout().get(selectedKeyIndexInLayout).setValue(event.getCode().getName().toUpperCase());
//                unmarkKey();
//                selectedGuiKey = null;
//                layout(canvas);
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
            final Label label = new Label("");
            label.backgroundProperty().setValue(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(5), Insets.EMPTY)));
            label.setTextAlignment(TextAlignment.CENTER);
            label.borderProperty().setValue(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
            DropShadow ds = new DropShadow();
            ds.setOffsetY(3.0f);
            ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
            label.setEffect(ds);
            final int i = idx;
            MenuItem clearMI = new MenuItem("clear");
            clearMI.addEventHandler(ActionEvent.ACTION, event -> {
                currentLayer.getLayout().get(i).setValue("KC_TRNS");
                unmarkKey();
                selectedGuiKey = null;
                layout(canvas);

            });
            label.addEventHandler(ContextMenuEvent.CONTEXT_MENU_REQUESTED, event -> {
                if (selectedGuiKey != null) unmarkKey();
                markLabel(label);
                selectedGuiKey = label;
            });
            MenuItem assignKey = new MenuItem("Assign key");
            assignKey.addEventHandler(ActionEvent.ACTION, event -> {
                doAssignKey(currentLayer.getLayout().get(i));
                layout(canvas);
            });

            MenuItem assignMacro = new MenuItem("Assign Macro");
            assignMacro.addEventHandler(ActionEvent.ACTION, event -> {

            });
            MenuItem assignLayerToggle = new MenuItem("Assign Layertoggle");
            assignLayerToggle.addEventHandler(ActionEvent.ACTION, event -> {
                doAssingLayerToggle(currentLayer.getLayout().get(i));
                layout(canvas);
            });
            MenuItem assignLT = new MenuItem("Assign LayerToggle/Type");
            assignLT.addEventHandler(ActionEvent.ACTION, event -> {
                doAssignLT(currentLayer.getLayout().get(i));
                layout(canvas);
            });
            label.setContextMenu(new ContextMenu(clearMI, assignKey, assignLayerToggle, assignLT, assignMacro));
            label.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                event.consume();
                if (!event.getButton().equals(MouseButton.PRIMARY)) return;

                Key k1 = currentLayer.getLayout().get(i);
                System.out.println("Key at " + i + " " + k1.getWidth() + "x" + k1.getHeight() + " value: " + k1.getValue());
                if (selectedGuiKey != null) {
                    unmarkKey();
                }
                markLabel(label);

                keyDescription.setText(getKeyDescription(k1.getValue()));
                selectedGuiKey = label;
            });
            canvas.getChildren().add(label);
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
        saveImgBtn = new Button("Save img");
        saveImgBtn.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                saveAsPng();
            }
        });
        sourceDirLabel = new Label("...");
        createKeymap = new Button("create");

//        macroCombo = new ComboBox<>();
//        macroCombo.getItems().add("Smiley :-D");
//        macroCombo.getItems().add("Smiley :-(");
//        macroCombo.getItems().add("CTRL_SHIFT/#");

        layerCombo = new ComboBox<>();
        layerCombo.getItems().add("Base");
        layerCombo.getSelectionModel().select(0);
        layerCombo.addEventHandler(ActionEvent.ACTION, event -> {
            System.out.println("Selected!");
            if (layerCombo.getSelectionModel().getSelectedIndex() < 0) return;
            currentLayer = ergodoxLayout.getLayers().get(layerCombo.getSelectionModel().getSelectedItem());
            layout(canvas);
        });

        deleteLayer = new Button("delete layer");
        deleteLayer.addEventHandler(ActionEvent.ACTION, event -> {
            if (!ergodoxLayout.getLayers().containsKey(currentLayer.getName())) {
                System.err.println("Cannot delete base layer");
            } else {
                ergodoxLayout.getLayers().remove(currentLayer.getName());
                layerCombo.getItems().remove(currentLayer.getName());
                layerCombo.getSelectionModel().select(0);
                currentLayer = ergodoxLayout.getLayers().get(layerCombo.getSelectionModel().getSelectedItem());
                layout(canvas);
            }
        });
        createLayer = new Button("add layer");
        createLayer.addEventHandler(ActionEvent.ACTION, event -> {
            //TODO: Ask for Layer Name!
            ErgodoxLayoutLayer l = new ErgodoxLayoutLayer("Layer " + ergodoxLayout.getLayers().size());
            ergodoxLayout.getLayers().put(l.getName(), l);
            currentLayer = l;
            layerCombo.getItems().add(l.getName());
            layerCombo.getSelectionModel().select(layerCombo.getItems().size() - 1);
            layout(canvas);
        });

        renameLayer = new Button("rename layer");
        renameLayer.addEventHandler(ActionEvent.ACTION, event -> {
            //TODO: ask for layer name
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
            layout(canvas);
        });

        led2 = new Label("●");
        led2.setTextFill(Color.GRAY);
        led2.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            currentLayer.setLed2(!currentLayer.isLed2());
            layout(canvas);
        });

        led3 = new Label("●");
        led3.setTextFill(Color.GRAY);
        led3.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            currentLayer.setLed3(!currentLayer.isLed3());
            layout(canvas);
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
        Platform.runLater(() -> layout(canvas));
//        layout(canvas);

        root.getChildren().add(canvas);
//        Circle circle = new Circle(50,Color.BLUE);
//        circle.relocate(20, 20);
//        Rectangle rectangle = new Rectangle(100,100,Color.RED);
//        rectangle.relocate(70,70);
//        canvas.getChildren().addAll(circle,rectangle);


        Scene scene = new Scene(root, initialWindowWidth, initialWindowHeight);

        primaryStage.setTitle("ErgodoxLayoutGenerator");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.widthProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("New width: " + newValue.toString());
            currentWindowWidth = newValue.doubleValue();
            if (currentWindowWidth > initialWindowWidth) {
                scaleX = currentWindowWidth / (double) initialWindowWidth;
                rightHalfOffset = (int) (currentWindowWidth / 2);
//                    System.out.println("Drawing with new scale of "+scaleX);
                layout(canvas);

            }
        });
        scene.heightProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("New height: " + newValue.toString());
            currentWindowHeight = newValue.doubleValue();
            if (currentWindowHeight > initialWindowHeight) {
                scaleY = currentWindowHeight / (double) initialWindowHeight;
                layout(canvas);

            }
        });

        //Read in config

        readConfig();

    }

    private void doAssingLayerToggle(Key k) {
        // Create the custom dialog.
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Choose Layer");
        dialog.setHeaderText("available layers");

        ButtonType assignButtonType = new ButtonType("Assign toggle", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(assignButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        ComboBox<String> bx = new ComboBox<>();
        for (String layerName : ergodoxLayout.getLayers().keySet()) {
            bx.getItems().add(layerName);
        }
        bx.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().equals("ENTER")) {
                k.setValue("TG(" + bx.getSelectionModel().getSelectedItem() + ")");
                dialog.close();
            }
        });

        grid.add(new Label("Layer:"), 0, 0);
        grid.add(bx, 1, 0);

// Enable/Disable login button depending on whether a username was entered.
        Node assignButton = dialog.getDialogPane().lookupButton(assignButtonType);
        assignButton.setDisable(true);

        bx.addEventHandler(ActionEvent.ACTION, event -> {
            assignButton.setDisable(false);
        });

        dialog.getDialogPane().setContent(grid);

// Request focus on the username field by default.
        Platform.runLater(() -> bx.requestFocus());


        Optional<ButtonType> result = dialog.showAndWait();

        result.ifPresent(selectedKeyCode -> {
            //Got selection ok
            String selectedItem = bx.getSelectionModel().getSelectedItem();
            k.setValue("TG(" + selectedItem + ")");
        });

    }

    private void doAssignLT(Key k) {
        List<String> choices = getKeyCodesList();
        String def = k.getValue();
        if (def == null || def.contains("(")) {
            def = "KC_TRNS";
        }
        //describing choices
        Map<String, String> prefixDescriptionByPrefix = getPrefixDescriptionMap();

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

        ComboBox<String> bx = new ComboBox<>();
        for (String prfx : prefixDescriptionByPrefix.keySet()) {
            bx.getItems().add(prfx + " - " + prefixDescriptionByPrefix.get(prfx));
        }

        ComboBox<String> keyCBX = new ComboBox<>();
        keyCBX.setEditable(true);
        keyCBX.getItems().addAll(choices);
        ComboBoxAutocompleter autocompleterForKeys = new ComboBoxAutocompleter(keyCBX);
        keyCBX.getSelectionModel().select(def);
        String lastKey = applicationSettings.getProperty("last_key_prefix");
        if (lastKey != null) {
            bx.getSelectionModel().select(lastKey);
            if (def.equals("KC_TRNS")) {
                keyCBX.getEditor().setText(((String) lastKey).substring(0, lastKey.indexOf(" - ")));
                Platform.runLater(() -> {
                    autocompleterForKeys.updateSelection();
                });
            }
        } else {
            bx.getSelectionModel().select("ALL - " + prefixDescriptionByPrefix.get("ALL"));
        }
        ComboBox<String> layerCBX = new ComboBox<>();
        layerCBX.setEditable(true);
        if (ergodoxLayout.getLayers() == null) {
            return;
        } else {
            layerCBX.getItems().addAll(ergodoxLayout.getLayers().keySet());
        }
        ComboBoxAutocompleter autocompleterForLayers = new ComboBoxAutocompleter(layerCBX);
        layerCBX.getSelectionModel().select(def);


        bx.addEventHandler(ActionEvent.ACTION, event -> {
            String selectedItem = bx.getSelectionModel().getSelectedItem();
            if (selectedItem.startsWith("ALL - ")) {
                keyCBX.getEditor().setText("");
            } else {
                keyCBX.getEditor().setText(selectedItem.substring(0, selectedItem.indexOf(" - ")));
            }
            autocompleterForLayers.updateSelection();
            Node assignButton = dialog.getDialogPane().lookupButton(assignButtonType);
            assignButton.setDisable(true);
            applicationSettings.setProperty("last_key_prefix", selectedItem);
            saveConfig();
        });

        keyCBX.addEventHandler(ActionEvent.ACTION, event -> {
            Node assignButton = dialog.getDialogPane().lookupButton(assignButtonType);
            assignButton.setDisable(false);
        });

        layerCBX.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().equals("ENTER")) {
                k.setValue(keyCBX.getSelectionModel().getSelectedItem());
                dialog.close();
            }
        });


        grid.add(new Label("Prefix:"), 0, 0);
        grid.add(bx, 1, 0);
        grid.add(new Label("Key typed:"), 0, 2);
        grid.add(keyCBX, 1, 2);
        grid.add(new Label("Layer when held:"), 0, 1);
        grid.add(layerCBX, 1, 1);

// Enable/Disable login button depending on whether a username was entered.
        Node assignButton = dialog.getDialogPane().lookupButton(assignButtonType);
        assignButton.setDisable(true);


        dialog.getDialogPane().setContent(grid);

// Request focus on the username field by default.
        Platform.runLater(() -> keyCBX.requestFocus());


        Optional<ButtonType> result = dialog.showAndWait();

        result.ifPresent(selectedKeyCode -> {
            //Got selection ok
            String selectedItem = keyCBX.getSelectionModel().getSelectedItem();
            String selectedItem2 = layerCBX.getSelectionModel().getSelectedItem();
            k.setValue("LT(" + selectedItem + "," + selectedItem2 + ")");
        });

    }

    private void doAssignKey(Key k) {
        List<String> choices = getKeyCodesList();

        String def = k.getValue();
        if (def == null || def.contains("(")) {
            def = "KC_TRNS";
        }
        //describing choices
        Map<String, String> prefixDescriptionByPrefix = getPrefixDescriptionMap();

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

        ComboBox<String> bx = new ComboBox<>();
        for (String prfx : prefixDescriptionByPrefix.keySet()) {
            bx.getItems().add(prfx + " - " + prefixDescriptionByPrefix.get(prfx));
        }

        ComboBox<String> bx2 = new ComboBox<>();
        bx2.setEditable(true);
        bx2.getItems().addAll(choices);
        ComboBoxAutocompleter ac = new ComboBoxAutocompleter(bx2);
        bx2.getSelectionModel().select(def);
        String lastKey = applicationSettings.getProperty("last_key_prefix");
        if (lastKey != null) {
            bx.getSelectionModel().select(lastKey);
            bx2.getEditor().setText(((String) lastKey).substring(0, lastKey.indexOf(" - ")));
            Platform.runLater(() -> {
                ac.updateSelection();
            });
        } else {
            bx.getSelectionModel().select("ALL - " + prefixDescriptionByPrefix.get("ALL"));
        }

        bx.addEventHandler(ActionEvent.ACTION, event -> {
            String selectedItem = bx.getSelectionModel().getSelectedItem();
            if (selectedItem.startsWith("ALL - ")) {
                bx2.getEditor().setText("");
            } else {
                bx2.getEditor().setText(selectedItem.substring(0, selectedItem.indexOf(" - ")));
            }
            ac.updateSelection();
            Node assignButton = dialog.getDialogPane().lookupButton(assignButtonType);
            assignButton.setDisable(true);
            applicationSettings.setProperty("last_key_prefix", selectedItem);
            saveConfig();
        });

        bx2.addEventHandler(ActionEvent.ACTION, event -> {
            Node assignButton = dialog.getDialogPane().lookupButton(assignButtonType);
            assignButton.setDisable(false);

        });
        bx2.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().equals("ENTER")) {
                k.setValue(bx2.getSelectionModel().getSelectedItem());
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
        Pane p = new FlowPane();
        for (CheckBox cbx : checkBoxes) {
            p.getChildren().add(cbx);
        }
        Map<CheckBox, ErgodoxKeyCode> modifierByCBox = new HashMap();
        modifierByCBox.put(shiftCbx, ErgodoxKeyCode.KC_LSFT);
        modifierByCBox.put(ctrlCbx, ErgodoxKeyCode.KC_LCTL);
        modifierByCBox.put(altCbx, ErgodoxKeyCode.KC_LALT);
        modifierByCBox.put(cmdCbx, ErgodoxKeyCode.KC_LGUI);

        grid.add(new Label("Prefix:"), 0, 0);
        grid.add(bx, 1, 0);
        grid.add(new Label("Key:"), 0, 1);
        grid.add(bx2, 1, 1);
        grid.add(p, 0, 2, 2, 1);
        grid.add(combinationLT, 0, 3, 2, 1);
        grid.add(desc, 0, 4, 2, 1);

// Enable/Disable login button depending on whether a username was entered.
        Node assignButton = dialog.getDialogPane().lookupButton(assignButtonType);
        assignButton.setDisable(true);


        dialog.getDialogPane().setContent(grid);

// Request focus on the username field by default.
        Platform.runLater(() -> bx2.requestFocus());


        Optional<ButtonType> result = dialog.showAndWait();

        result.ifPresent(selectedKeyCode -> {
            int cnt = 0;
            for (CheckBox b : checkBoxes) {
                if (b.isSelected()) cnt++;
            }

            String selectedItem = bx2.getSelectionModel().getSelectedItem();
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

    private Map<String, String> getPrefixDescriptionMap() {
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

    private List<String> getKeyCodesList() {
        List<String> choices = new ArrayList<>();
        for (ErgodoxKeyCode c : ErgodoxKeyCode.values()) {
            choices.add(c.name());
        }

        return choices;
    }

    private void markLabel(Label label) {
        label.setEffect(null);
        label.borderProperty().setValue(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));

        keyDescription.borderProperty().setValue(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(1))));
    }

    public void saveAsPng() {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(qmkSourceDir.getPath() + "/keyboard/ergodox_ez/keymaps/" + currentKeymap));
        fc.setInitialFileName(currentKeymap + "_highres.png");
        File file = fc.showSaveDialog(null);
        if (file == null) return;

        unmarkKey();
        layerCombo.getSelectionModel().select(0);
        WritableImage image = canvas.snapshot(new SnapshotParameters(), null);

        int snapshowHeight = (int) (image.getHeight() - 65);
        BufferedImage img = new BufferedImage((int) image.getWidth(), snapshowHeight * layerCombo.getItems().size(), BufferedImage.TYPE_INT_RGB);
        createLayer.setVisible(false);
        deleteLayer.setVisible(false);
        keyDescription.setVisible(false);
        for (int i = 0; i < layerCombo.getItems().size(); i++) {
            layerCombo.getSelectionModel().select(i);
            image = canvas.snapshot(new SnapshotParameters(), null);
            img.getGraphics().drawImage(SwingFXUtils.fromFXImage(image, null), 0, i * snapshowHeight, null);
        }


        try {
            ImageIO.write(img, "png", file);
        } catch (IOException e) {
            // TODO: handle exception here
        }
        createLayer.setVisible(true);
        deleteLayer.setVisible(true);
        keyDescription.setVisible(true);
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

    private void saveConfig() {
        try {
            applicationSettings.store(new FileWriter(configFile), "Ergodox Layout Generator");
        } catch (Exception e) {
            //TODO: Implement Handling
            throw new RuntimeException(e);
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
            DirectoryChooser fc = new DirectoryChooser();
            if (qmkSourceDir == null) {
                fc.setInitialDirectory(new File(System.getProperty("user.home")));
            } else {
                fc.setInitialDirectory(new File(qmkSourceDir.getPath() + "/keyboard/ergodox_ez/keymaps"));
            }
            fc.setTitle("Choose ergodox-keymap directory");
            File selected = fc.showDialog(primaryStage);
            if (selected == null) return;

            readKeymapFile(primaryStage, selected);


            applicationSettings.setProperty(lastOpenedFile, selected.getAbsolutePath());
            saveConfig();

        } catch (Exception e) {
            //TODO: Implement Handling
            throw new RuntimeException(e);
        }
    }

    private void readKeymapFile(Stage primaryStage, File selected) throws Exception {
        KeymapParser parser = new KeymapParser();
        ergodoxLayout = parser.parse(selected.getAbsolutePath() + "/keymap.c");
        layerCombo.getItems().clear();
        for (String k : ergodoxLayout.getLayers().keySet()) {
            layerCombo.getItems().add(0, k);
        }
        layerCombo.getSelectionModel().select(0);
        currentLayer = ergodoxLayout.getLayers().get(layerCombo.getSelectionModel().getSelectedItem());


        layout(canvas);
        primaryStage.setTitle(selected.getName());
        currentKeymap = selected.getName();
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

    private void unmarkKey() {
        if (selectedGuiKey == null) return;
        selectedGuiKey.borderProperty().setValue(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
        selectedGuiKey.setEffect(ds);
        keyDescription.setText("");
        keyDescription.borderProperty().setValue(null);
    }

    public void layout(Pane canvas) {
        int row = 0;
        int x = (int) (offsetX * scaleX);
        int y = (int) (offsetY * scaleY);
        int idx = 0;
        int xoff = 0;
        int canvasIdx = 0;
        for (Key k : currentLayer.getLayout()) {
            idx++;
            if (k != null && !(k instanceof Key.NullKey)) {
                Label b = (Label) canvas.getChildren().get(canvasIdx++);
                String kval = k.getValue() != null ? k.getValue() : "";
                if (kval.endsWith("SFT") || kval.endsWith("CTL") || kval.endsWith("ALT") || kval.endsWith("GUI")) {
                    b.backgroundProperty().setValue(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5), Insets.EMPTY)));
                } else if (kval.startsWith("LT(")) {
                    b.backgroundProperty().setValue(new Background(new BackgroundFill(Color.LIGHTGREEN, new CornerRadii(5), Insets.EMPTY)));
                } else if (kval.startsWith("M(")) {
                    b.backgroundProperty().setValue(new Background(new BackgroundFill(Color.LIGHTYELLOW, new CornerRadii(5), Insets.EMPTY)));
                } else if (kval.startsWith("TG(")) {
                    b.backgroundProperty().setValue(new Background(new BackgroundFill(Color.LIGHTCORAL, new CornerRadii(5), Insets.EMPTY)));
                } else if (kval.contains("_T(")) {
                    b.backgroundProperty().setValue(new Background(new BackgroundFill(Color.LIGHTSKYBLUE, new CornerRadii(5), Insets.EMPTY)));
                } else if (kval.contains("(")) {
                    b.backgroundProperty().setValue(new Background(new BackgroundFill(Color.LIGHTCYAN, new CornerRadii(5), Insets.EMPTY)));

                } else {
                    b.backgroundProperty().setValue(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(5), Insets.EMPTY)));
                }
                b.setText(getKeyDisplayText(kval));
                b.setFont(Font.font(8));
                b.setAlignment(Pos.CENTER);
                b.setTextAlignment(TextAlignment.CENTER);
                b.setContentDisplay(ContentDisplay.CENTER);
                b.setMaxWidth(k.getWidth() * pixelWidth * scaleX);
                b.setPrefWidth(k.getWidth() * pixelWidth * scaleX);
                b.setMinWidth(k.getWidth() * pixelWidth * scaleX);

                b.setMaxHeight(k.getHeight() * pixelHeight * scaleY);
                b.setPrefHeight(k.getHeight() * pixelHeight * scaleY);
                b.setMinHeight(k.getHeight() * pixelHeight * scaleY);

                b.relocate(x + k.getxOffset() * scaleX, y + k.getyOffset() * scaleY);

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

    private String getKeyDisplayText(String kval) {
        String ret = "";
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
            Macro macro = ergodoxLayout.getMacros().get(ret);
            if (macro != null) ret = macro.getMacroGuiText();
            ret = getKeyDisplayName(ret);
        } else if (!kval.contains("_") || kval.contains("(")) {
            ret = kval;
        } else {
            ErgodoxKeyCode k = ErgodoxKeyCode.valueOf(kval);
            if (k == null) {
                //error
                ret = "invalid";
            } else {
                ret = getKeyDisplayName(kval.substring(kval.lastIndexOf('_') + 1));
            }
        }

        return ret;
    }

    private String getKeyDisplayName(String ret) {
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
}
