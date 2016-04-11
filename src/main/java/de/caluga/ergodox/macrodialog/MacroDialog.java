package de.caluga.ergodox.macrodialog;/**
 * Created by stephan on 11.04.16.
 */

import de.caluga.ergodox.ErgodoxLayout;
import de.caluga.ergodox.Key;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import java.util.Optional;

/**
 * TODO: Add Documentation here
 **/
public class MacroDialog {

    private final ErgodoxLayout ergodoxLayout;

    public MacroDialog(ErgodoxLayout layout) {
        this.ergodoxLayout = layout;
    }

    public void show(Key k) {
        // Create the custom dialog.
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Choose Macro");
        dialog.setHeaderText("available Macros");

        ButtonType assignButtonType = new ButtonType("Assign macro", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(assignButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));


        ComboBox<String> bx = new ComboBox<>();
        for (String macroName : ergodoxLayout.getMacros().keySet()) {
            bx.getItems().add(macroName);
        }
        String assignedValue = k.getValue();
        if (assignedValue != null && assignedValue.startsWith("M(")) {
            //old macro
            bx.getSelectionModel().select(assignedValue.substring(2, assignedValue.length() - 1));
        }
        bx.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode().equals("ENTER")) {
                k.setValue("M(" + bx.getSelectionModel().getSelectedItem() + ")");
                dialog.close();
            }
        });

        Label macroDescription = new Label("Macro description");
        grid.add(new Label("Macro:"), 0, 0);
        grid.add(bx, 1, 0);
        grid.add(macroDescription, 0, 1, 2, 1);

        Button newMacro = new Button("New macro");
        Button delMacro = new Button("Del macro");
        Button editMacro = new Button("Edit macro");

        FlowPane pn = new FlowPane();
        pn.setOrientation(Orientation.VERTICAL);
        pn.setVgap(10);
        pn.getChildren().add(newMacro);
        pn.getChildren().add(delMacro);
        pn.getChildren().add(editMacro);

        grid.add(pn, 2, 0, 1, 3);

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
            k.setValue("M(" + selectedItem + ")");
        });

    }
}
