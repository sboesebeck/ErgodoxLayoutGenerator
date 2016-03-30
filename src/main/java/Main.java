/**
 * Created by stephan on 29.03.16.
 */

import com.sun.corba.se.impl.orbutil.graph.Graph;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * TODO: Add Documentation here
 **/
public class Main extends Application {
    public final int width = 25;
    public final int height = 25;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {


        StackPane root = new StackPane();

        Canvas c = new Canvas(800, 600);
        c.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                double x = event.getX();
                double y = event.getY();
                System.out.println("Clicked! "+ x +"/"+ y);
            }
        });
        drawKeys(c.getGraphicsContext2D());

        root.getChildren().add(c);

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void drawKeys(GraphicsContext g) {
        ErgodoxLayout l = new ErgodoxLayout();
        int row = 0;
        int x = 25;
        int y = 25;
        int idx = 0;
        int xoff = 0;

        g.setStroke(Color.BLACK);
        for (Key k : l.getLayout()) {
            idx++;
            if (k != null && !(k instanceof Key.NullKey)) {
                g.setFill(Color.DARKGRAY);
                g.fillRoundRect(x+2, y+2, k.getWidth() * width, k.getHeight() * height, 10, 10);
                g.setFill(Color.GRAY);
                g.fillRoundRect(x, y, k.getWidth() * width, k.getHeight() * height, 10, 10);
                g.strokeRoundRect(x, y, k.getWidth() * width, k.getHeight() * height, 10, 10);
                g.strokeText(idx + "/" + row, x, y + 15);
            }
            if (k instanceof Key.NullKey) idx--;
            if (idx >= l.getRowLength().get(row)) {

                row++;

                if (row >= l.getRowLength().size()) {
                    y = 25;
                    xoff = 400;
                    row = 0;
                    idx = 0;
                } else {
                    y += height * 1.2;
                    idx = 0;
                }
                x = xoff + 25;
            } else {
                if (k != null) {
                    x += width * 1.2 * k.getWidth();
                } else {
                    x += width * 1.2;
                }
            }
        }
    }
}
