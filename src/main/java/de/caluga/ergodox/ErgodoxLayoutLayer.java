package de.caluga.ergodox; /**
 * Created by stephan on 29.03.16.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Add Documentation here
 **/
public class ErgodoxLayoutLayer {

    private List<Key> layout=new ArrayList();
    private List<Integer> rowLength=new ArrayList<Integer>();

    private String name;

    public ErgodoxLayoutLayer(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Key getKey(int idx) {
        int i=0;
        for (Key k: layout){
            if (k instanceof Key.NullKey) continue;
            if (i==idx)return k;
             i++;
        }
        return null;
    }

    public ErgodoxLayoutLayer(){
        //first row
        layout.add(Key.w2h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());

        //2nd row
        //left half
        layout.add(Key.w2h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h2());
        //3rd row
        //left half
        layout.add(Key.w2h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());

        //4th row
        //left half
        layout.add(Key.w2h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h2());

        //5th row (bottom)
        layout.add(Key.nw1h1());
        layout.add(Key.nw1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());

        //left thumb
        layout.add(Key.nw1h1());
        layout.add(Key.nw1h1());
        layout.add(Key.nw1h1());
        layout.add(Key.nw1h1());
        layout.add(Key.nw1h1());

        layout.add(Key.nw1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        //lowest keys
        layout.add(Key.nw1h1());
        layout.add(Key.nw1h1());
        layout.add(Key.nw1h1());
        layout.add(Key.nw1h1());
        layout.add(Key.nw1h1());

        layout.add(Key.nw1h1());
        layout.add(Key.nw1h1());
        layout.add(Key.w1h1());
        //big thumb keys
        layout.add(Key.nw1h1());
        layout.add(Key.nw1h1());
        layout.add(Key.nw1h1());
        layout.add(Key.nw1h1());
        layout.add(Key.nw1h1());

        layout.add(Key.w1h2().setyOffset(-25));
        layout.add(Key.w1h2().setyOffset(-25));
        layout.add(Key.w1h1());


        ///////////////////////////////////
        //1st row
        //right half
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w2h1());

        //2nd row
        //right half
        layout.add(Key.w1h2());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w2h1());
        
        //3rd row
        //right half
        layout.add(Key.nw1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w2h1());

       //4th row
        //right half
        layout.add(Key.w1h2());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w2h1());


        //5th row
        //right
        layout.add(Key.nw1h1());
        layout.add(Key.nw1h1());
        layout.add(Key.nw1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());


        //right thumbblock
        //right
        layout.add(Key.w1h1());
        layout.add(Key.w1h1());

        layout.add(Key.w1h1());
        //big thumbkeys
        //right
        layout.add(Key.w1h1());
        layout.add(Key.w1h2().setyOffset(-25));
        layout.add(Key.w1h2().setyOffset(-25));
        //lowest


        rowLength.add(7);
        rowLength.add(7);
        rowLength.add(6);
        rowLength.add(7);
        rowLength.add(0);
        rowLength.add(5);

        //thumb blocks
        rowLength.add(2);
        rowLength.add(1);
        rowLength.add(3);
    }
    public int keysOnHalf(){return 38;}
    public List<Key> getLayout() {
        return layout;
    }

    public List<Integer> getRowLength() {
        return rowLength;
    }
}


