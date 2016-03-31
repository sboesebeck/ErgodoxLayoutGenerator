/**
 * Created by stephan on 29.03.16.
 */

import com.sun.javafx.scene.layout.region.BorderImageSliceConverter;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


/**
 * TODO: Add Documentation here
 **/
public class Main extends Application {
    public final int pixelWidth = 40;
    public final int pixelHeight = 25;
    public final int pixelOffsetX=5;
    public final int pixelOffsetY=5;

    public final int offsetX=25;
    public final int offsetY=25;

    public int rightHalfOffset=400;
    private double scaleX =1.0;
    private double scaleY =1.0;

    private Label selectedKey=null;

    private ErgodoxLayout l = new ErgodoxLayout();


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
//                    indexInLayout +=l.getRowLength().get(i);
//                }
//                if (rightHalf) indexInLayout+=l.keysOnHalf();
//                Key k=l.getLayout().get(indexInLayout);
//                System.out.println("Got key; "+k.getWidth()+"x"+k.getHeight());
//
//            }
//        });
//        drawKeys(c.getGraphicsCocntext2D());



        final Pane canvas = new Pane();
        canvas.setStyle("-fx-background-color: white;");
        final int windowWidth = 800;
        final int windowHeight = 500;
        rightHalfOffset=windowWidth/2;
        canvas.setPrefSize(windowWidth, windowHeight);

        //canvas.getChildren().addAll(b);
        for (int i=0;i<l.keysOnHalf()*2;i++) {
//            Button btn=new Button("");
            final Label btn=new Label("");
            btn.backgroundProperty().setValue(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(5), Insets.EMPTY)));
            btn.setTextAlignment(TextAlignment.CENTER);
            btn.borderProperty().setValue(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(5),new BorderWidths(1))));
            DropShadow ds = new DropShadow();
            ds.setOffsetY(3.0f);
            ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
            btn.setEffect(ds);

            final int idx=i;
            btn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    Key k=l.getLayout().get(idx);
                    System.out.println("Key at "+idx+" "+k.getWidth()+"x"+k.getHeight());
                    if (selectedKey!=null){
                        selectedKey.borderProperty().setValue(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(5),new BorderWidths(1))));
                        DropShadow ds = new DropShadow();
                        ds.setOffsetY(3.0f);
                        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
                        selectedKey.setEffect(ds);
                    }
                    btn.setEffect(null);
                    btn.borderProperty().setValue(new Border(new BorderStroke(Color.GREEN,BorderStrokeStyle.SOLID,new CornerRadii(5),new BorderWidths(2))));
                    selectedKey=btn;
                }
            });
            canvas.getChildren().add(btn);
        }
        drawKeys(canvas);

        root.getChildren().add(canvas);
//        Circle circle = new Circle(50,Color.BLUE);
//        circle.relocate(20, 20);
//        Rectangle rectangle = new Rectangle(100,100,Color.RED);
//        rectangle.relocate(70,70);
//        canvas.getChildren().addAll(circle,rectangle);

        Scene scene = new Scene(root, windowWidth, windowHeight);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.widthProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("New width: "+newValue.toString());
                double width=newValue.doubleValue();
                if (width> windowWidth){
                    scaleX =width/(double)windowWidth;
                    rightHalfOffset= (int) (width/2);
                    System.out.println("Drawing with new scale of "+scaleX);
                    drawKeys(canvas);

                }
            }
        });
        scene.heightProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("New height: "+newValue.toString());
                double height=newValue.doubleValue();
                if (height> windowHeight){
                    scaleY  =height/(double)windowHeight;
                    drawKeys(canvas);

                }
            }
        });
    }

    public void drawKeys(Pane canvas) {
        int row = 0;
        int x = (int)(offsetX*scaleX);
        int y = (int)(offsetY*scaleY);
        int idx = 0;
        int xoff = 0;
        int canvasIdx=0;
        for (Key k : l.getLayout()) {
            idx++;
            if (k != null && !(k instanceof Key.NullKey)) {
                Label b= (Label) canvas.getChildren().get(canvasIdx++);
                b.setText(row+"/"+idx);
                b.setFont(Font.font(12));
                b.setMaxWidth(k.getWidth()*pixelWidth*scaleX);
                b.setPrefWidth(k.getWidth()*pixelWidth*scaleX);
                b.setMinWidth(k.getWidth()*pixelWidth*scaleX);

                b.setMaxHeight(k.getHeight()*pixelHeight*scaleY);
                b.setPrefHeight(k.getHeight()*pixelHeight*scaleY);
                b.setMinHeight(k.getHeight()*pixelHeight*scaleY);
                b.relocate(x,y);

//                g.setFill(Color.DARKGRAY);
//                g.fillRoundRect(x+4, y+4, k.getWidth() * pixelWidth, k.getHeight() * pixelHeight, 10, 10);
//                g.setFill(Color.GRAY);
//                g.fillRoundRect(x, y, k.getWidth() * pixelWidth, k.getHeight() * pixelHeight, 10, 10);
//                g.strokeRoundRect(x, y, k.getWidth() * pixelWidth, k.getHeight() * pixelHeight, 10, 10);
//                g.strokeText(idx + "/" + row, x, y + 15);
            }
            if (k instanceof Key.NullKey) idx--;
            if (idx >= l.getRowLength().get(row)) {

                row++;

                if (row >= l.getRowLength().size()) {
                    //switch to right half
                    y = (int)(offsetY*scaleY);
                    xoff = rightHalfOffset;
                    row = 0;
                    idx = 0;
                } else {
                    y += pixelHeight*scaleY +pixelOffsetY;
                    idx = 0;
                }
                x = xoff + (int)(offsetX*scaleX);
            } else {
                if (k != null) {
                    x += pixelWidth * k.getWidth()*scaleX+pixelOffsetX;
                } else {
                    x += pixelWidth +pixelOffsetX;
                }
            }
        }
    }
}
