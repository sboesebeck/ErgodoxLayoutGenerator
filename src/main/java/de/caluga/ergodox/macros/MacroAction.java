package de.caluga.ergodox.macros;

import de.caluga.ergodox.KeyCode;

/**
 * User: Stephan Bösebeck
 * Date: 02.04.16
 * Time: 23:22
 * <p>
 * TODO: Add documentation here
 */
public class MacroAction {
    private KeyCode code;
    private int wait;
    private boolean down;

    public KeyCode getCode() {
        return code;
    }

    public void setCode(KeyCode code) {
        this.code = code;
    }

    public int getWait() {
        return wait;
    }

    public void setWait(int wait) {
        this.wait = wait;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }
}
