package de.caluga.ergodox;/**
 * Created by stephan on 11.04.16.
 */

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import java.util.Optional;

/**
 * TODO: Add Documentation here
 **/
public class AssignLayerToggleDialog {
    private final ErgodoxLayout ergodoxLayout;

    public AssignLayerToggleDialog(ErgodoxLayout l) {
        this.ergodoxLayout = l;
    }

    public void show(Key k) {
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
        String assignedValue = k.getValue();
        if (assignedValue != null && assignedValue.startsWith("TG(")) {
            bx.getSelectionModel().select(assignedValue.substring(3, assignedValue.length() - 1));
        }
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

        result.ifPresent(btn -> {
            if (btn.getButtonData().equals(ButtonBar.ButtonData.CANCEL_CLOSE)) return;
            //Got selection ok
            String selectedItem = bx.getSelectionModel().getSelectedItem();
            k.setValue("TG(" + selectedItem + ")");
        });
    }
}
