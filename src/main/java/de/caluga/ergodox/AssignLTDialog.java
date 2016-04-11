package de.caluga.ergodox;/**
 * Created by stephan on 11.04.16.
 */

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * TODO: Add Documentation here
 **/
public class AssignLTDialog {

    private final ErgodoxLayout ergodoxLayout;

    public AssignLTDialog(ErgodoxLayout l) {
        this.ergodoxLayout = l;
    }

    public void show(Key k) {
        List<String> choices = Main.getKeyCodesList();
        String def = k.getValue();
        if (def == null || def.contains("(")) {
            def = "KC_TRNS";
        }
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

        ComboBox<String> bx = new ComboBox<>();
        for (String prfx : prefixDescriptionByPrefix.keySet()) {
            bx.getItems().add(prfx + " - " + prefixDescriptionByPrefix.get(prfx));
        }

        ComboBox<String> keyCBX = new ComboBox<>();
        keyCBX.setEditable(true);
        keyCBX.getItems().addAll(choices);
        ComboBoxAutocompleter autocompleterForKeys = new ComboBoxAutocompleter(keyCBX);
        keyCBX.getSelectionModel().select(def);
        String lastKey = Main.applicationSettings.getProperty("last_key_prefix");
        if (lastKey != null) {
            bx.getSelectionModel().select(lastKey);
            if (def.equals("KC_TRNS")) {
                keyCBX.getEditor().setText(lastKey.substring(0, lastKey.indexOf(" - ")));
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
//        layerCBX.setEditable(true);
//        ComboBoxAutocompleter autocompleterForLayers = new ComboBoxAutocompleter(layerCBX);


        bx.addEventHandler(ActionEvent.ACTION, event -> {
            String selectedItem = bx.getSelectionModel().getSelectedItem();
            if (selectedItem.startsWith("ALL - ")) {
                keyCBX.getEditor().setText("");
            } else {
                keyCBX.getEditor().setText(selectedItem.substring(0, selectedItem.indexOf(" - ")));
            }
            autocompleterForKeys.updateSelection();
            Node assignButton = dialog.getDialogPane().lookupButton(assignButtonType);
            assignButton.setDisable(true);
            Main.applicationSettings.setProperty("last_key_prefix", selectedItem);
            Main.saveConfig();
        });

        keyCBX.addEventHandler(ActionEvent.ACTION, event -> {
            Node assignButton = dialog.getDialogPane().lookupButton(assignButtonType);
            assignButton.setDisable(false);
        });

//        layerCBX.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
//            if (event.getCode().equals("ENTER")) {
//                k.setValue(keyCBX.getSelectionModel().getSelectedItem());
//                dialog.close();
//            }
//        });
//

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

        result.ifPresent(btn -> {
            //Got selection ok
            if (btn.getButtonData().equals(ButtonBar.ButtonData.CANCEL_CLOSE)) return;
            String selectedItem = keyCBX.getSelectionModel().getSelectedItem();
            String selectedItem2 = layerCBX.getSelectionModel().getSelectedItem();
            k.setValue("LT(" + selectedItem + "," + selectedItem2 + ")");
        });
    }
}
