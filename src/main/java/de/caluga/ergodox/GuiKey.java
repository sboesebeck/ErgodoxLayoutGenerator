package de.caluga.ergodox;/**
 * Created by stephan on 14.04.16.
 */

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * TODO: Add Documentation here
 **/
public class GuiKey {
    private double x, y;
    private double width, height;

    private Rectangle outer;
    private Label inner;

    private boolean marked = false;

    public GuiKey() {
        outer = new Rectangle(200, 200, 50, 50);
        inner = new Label("");
        inner.setFont(Font.font(8));
    }

    public void setOuterColor(Color c) {
        outer.setFill(c);
        outer.setOpacity(100);
        outer.setStrokeWidth(1);
        outer.setStroke(Color.BLACK);
        outer.setArcHeight(5);
        outer.setArcWidth(5);
    }

    public void setInnerColor(Color c) {
        inner.setBackground(new Background(new BackgroundFill(c, new CornerRadii(4), Insets.EMPTY)));
        inner.setOpacity(100);
    }

    public void setFont(Font f){
        inner.setFont(f);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setText(String t) {
        inner.setText(t);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height * 0.6;
    }

    public void addToPane(Pane p) {
        p.getChildren().add(outer);
        p.getChildren().add(inner);
    }

    public void select() {
        marked = true;
    }

    public void deselect() {
        marked = false;
    }

    public void update() {
//        outer.relocate(x,y);
        outer.setX(x);
        outer.setY(y);
        outer.setWidth(width);
        outer.setHeight(height);

        double xoff = 3;
        double yoff = 3;
        double h = height - 8;
        double w = width - 6;
        inner.relocate(x + xoff, y + yoff);
        inner.setMaxHeight(h);
        inner.setMinHeight(h);
        inner.setPrefHeight(h);
        inner.setPrefWidth(w);
        inner.setMinWidth(w);
        inner.setMaxWidth(w);
        inner.setTextAlignment(TextAlignment.CENTER);


        if (marked) {
            outer.setStrokeWidth(5);
            outer.setStroke(Color.GREEN);
        } else {
            outer.setStrokeWidth(0.5);
            outer.setStroke(Color.BLACK);
        }
    }

    public Label getInner() {
        return inner;
    }
}
