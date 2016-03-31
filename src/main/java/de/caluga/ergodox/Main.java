package de.caluga.ergodox; /**
 * Created by stephan on 29.03.16.
 */

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
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


/**
 * TODO: Add Documentation here
 **/
public class Main extends Application {
    public final int pixelWidth = 40;
    public final int pixelHeight = 25;
    public final int pixelOffsetX=5;
    public final int pixelOffsetY=5;

    public final int offsetX=25;
    public final int offsetY=75;

    public int rightHalfOffset=400;
    private double scaleX =1.0;
    private double scaleY =1.0;

    private Label selectedGuiKey =null;
    private int selectedKeyIndexInLayout=0;

    private List<ErgodoxLayoutLayer> layers = new ArrayList<ErgodoxLayoutLayer>();

    private Button setSourceDir;
    private Label sourceDirLabel;
    private Button createKeymap;
    private Button openBtn;
    private Button saveBtn;
    private int initialWindowWidth;
    private int initialWindowHeight;
    private double currentWindowHeight;
    private double currentWindowWidth;
    private ComboBox<String> macroCombo;

    private ComboBox<String> layerCombo;
    private Button createLayer;
    private Button deleteLayer;

    private ErgodoxLayoutLayer currentLayer;
    private Pane canvas;


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


        layers.add(new ErgodoxLayoutLayer("base"));
        currentLayer =layers.get(0); //base


        canvas = new Pane();
        canvas.setStyle("-fx-background-color: white;");
        initialWindowWidth = 800;
        initialWindowHeight = 500;
        this.currentWindowWidth=initialWindowWidth;
        this.currentWindowHeight=initialWindowHeight;
        rightHalfOffset= initialWindowWidth /2;
        canvas.setPrefSize(initialWindowWidth, initialWindowHeight);

        root.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                System.out.println("KEyEvent: "+event.getCode().impl_getCode()+" name: KC_"+event.getCode().getName());
                if (selectedGuiKey !=null){
                    currentLayer.getLayout().get(selectedKeyIndexInLayout).setValue(event.getCode().getName().toUpperCase());
                    unmarkKey();
                    selectedGuiKey =null;
                    layout(canvas);
                }
            }
        });
        int idx=0;
        for (Key k: currentLayer.getLayout()) {
//            Button btn=new Button("");
            if (k instanceof Key.NullKey) {
                idx++;
                continue;
            }
            final Label label=new Label("");
            label.backgroundProperty().setValue(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(5), Insets.EMPTY)));
            label.setTextAlignment(TextAlignment.CENTER);
            label.borderProperty().setValue(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,new CornerRadii(5),new BorderWidths(1))));
            DropShadow ds = new DropShadow();
            ds.setOffsetY(3.0f);
            ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
            label.setEffect(ds);
            final int i=idx;
            label.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    Key k= currentLayer.getLayout().get(i);
                    selectedKeyIndexInLayout=i;
                    System.out.println("Key at "+i+" "+k.getWidth()+"x"+k.getHeight());
                    if (selectedGuiKey !=null){
                        unmarkKey();
                    }
                    label.setEffect(null);
                    label.borderProperty().setValue(new Border(new BorderStroke(Color.GREEN,BorderStrokeStyle.SOLID,new CornerRadii(5),new BorderWidths(2))));
                    selectedGuiKey =label;
                }
            });
            canvas.getChildren().add(label);
            idx++;
        }

        setSourceDir=new Button("Set qmk-SourceDir");
        openBtn=new Button("open");
        saveBtn=new Button("save");
        sourceDirLabel=new Label("...");
        createKeymap=new Button("create");

        macroCombo = new ComboBox<String>();
        macroCombo.getItems().add("Smiley :-D");
        macroCombo.getItems().add("Smiley :-(");
        macroCombo.getItems().add("CTRL_SHIFT/#");

        layerCombo=new ComboBox<String>();
        layerCombo.getItems().add("Base");
        layerCombo.getSelectionModel().select(0);
        layerCombo.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("Selected!");
                currentLayer=layers.get(layerCombo.getSelectionModel().getSelectedIndex());
                layout(canvas);
            }
        });

        deleteLayer=new Button("delete layer");
        deleteLayer.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (layers.indexOf(currentLayer)==0){
                    System.err.println("Cannot delete base layer");
                } else {
                    layers.remove(currentLayer);
                    layerCombo.getItems().remove(currentLayer.getName());
                    currentLayer=layers.get(0);
                    layerCombo.getSelectionModel().select(0);
                    layout(canvas);
                }
            }
        });
        createLayer=new Button("add layer");
        createLayer.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                ErgodoxLayoutLayer l = new ErgodoxLayoutLayer("Layer " + layers.size());
                layers.add(l);
                currentLayer=l;
                layerCombo.getItems().add(l.getName());
                layerCombo.getSelectionModel().select(layerCombo.getItems().size()-1);
                layout(canvas);
            }
        });

        canvas.getChildren().add(macroCombo);
        canvas.getChildren().add(setSourceDir);
        canvas.getChildren().add(openBtn);
        canvas.getChildren().add(saveBtn);
        canvas.getChildren().add(sourceDirLabel);
        canvas.getChildren().add(createKeymap);
        canvas.getChildren().add(createLayer);
        canvas.getChildren().add(deleteLayer);
        canvas.getChildren().add(layerCombo);
        layout(canvas);

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

        scene.widthProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("New width: "+newValue.toString());
                currentWindowWidth=newValue.doubleValue();
                if (currentWindowWidth> initialWindowWidth){
                    scaleX =currentWindowWidth/(double) initialWindowWidth;
                    rightHalfOffset= (int) (currentWindowWidth/2);
//                    System.out.println("Drawing with new scale of "+scaleX);
                    layout(canvas);

                }
            }
        });
        scene.heightProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("New height: "+newValue.toString());
                currentWindowHeight=newValue.doubleValue();
                if (currentWindowHeight> initialWindowHeight){
                    scaleY  =currentWindowHeight/(double) initialWindowHeight;
                    layout(canvas);

                }
            }
        });
    }

    private void unmarkKey() {
        selectedGuiKey.borderProperty().setValue(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,new CornerRadii(5),new BorderWidths(1))));
        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
        selectedGuiKey.setEffect(ds);
    }

    public void layout(Pane canvas) {
        int row = 0;
        int x = (int)(offsetX*scaleX);
        int y = (int)(offsetY*scaleY);
        int idx = 0;
        int xoff = 0;
        int canvasIdx=0;
        for (Key k : currentLayer.getLayout()) {
            idx++;
            if (k != null && !(k instanceof Key.NullKey)) {
                Label b= (Label) canvas.getChildren().get(canvasIdx++);
                b.setText(k.getValue()!=null?k.getValue():"");
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
            if (idx >= currentLayer.getRowLength().get(row)) {

                row++;

                if (row >= currentLayer.getRowLength().size()) {
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

        macroCombo.relocate(currentWindowWidth/2,currentWindowHeight-100);
        setSourceDir.relocate(25,currentWindowHeight-30);
        sourceDirLabel.relocate(250,currentWindowHeight-30);
        createKeymap.relocate(currentWindowWidth-100,currentWindowHeight-30);
        saveBtn.relocate(currentWindowWidth/2,currentWindowHeight-60);
        openBtn.relocate(currentWindowWidth/2,currentWindowHeight-30);

        layerCombo.relocate(5,20);
        createLayer.relocate(150,5);
        deleteLayer.relocate(150,40);
    }
}
