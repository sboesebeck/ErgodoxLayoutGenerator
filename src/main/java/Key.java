/**
 * Created by stephan on 29.03.16.
 */

/**
 * TODO: Add Documentation here
 **/
public class Key {
    private int width;
    private int height;

    public Key(int width, int height) {
        this.width = width;
        this.height = height;
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



    public static class NullKey extends Key {
        public NullKey(int width, int height) {
            super(width, height);
        }
    }
}
