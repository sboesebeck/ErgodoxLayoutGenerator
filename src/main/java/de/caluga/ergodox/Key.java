package de.caluga.ergodox; /**
 * Created by stephan on 29.03.16.
 */

/**
 * TODO: Add Documentation here
 **/
public class Key {
    private int width;
    private int height;

    private int yOffset=0;
    private int xOffset=0;

    private String value;

    public Key(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getyOffset() {
        return yOffset;
    }

    public Key setyOffset(int yOffset) {
        this.yOffset = yOffset;
        return this;
    }

    public int getxOffset() {
        return xOffset;
    }

    public Key setxOffset(int xOffset) {
        this.xOffset = xOffset;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public static Key w1h1() { return new Key(1,1);}
    public static Key w2h1() { return new Key(2,1);}
    public static Key w1h2() { return new Key(1,2);}

    public static Key nw1h1() { return new NullKey(1,1);}
    public static Key nw1h2() { return new NullKey(1,2);}
    public static Key nw2h1() { return new NullKey(2,1);}

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static class NullKey extends Key {
        public NullKey(int width, int height) {
            super(width, height);
        }
    }
}
