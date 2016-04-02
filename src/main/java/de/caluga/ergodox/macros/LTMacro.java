package de.caluga.ergodox.macros;

import de.caluga.ergodox.KeyCode;

import java.util.List;

/**
 * User: Stephan Bösebeck
 * Date: 02.04.16
 * Time: 23:14
 * <p>
 * TODO: Add documentation here
 */
public class LTMacro extends Macro {
    private List<MacroAction> longPressKeys;
    private List<MacroAction> shortStrokes;
    private int timeout=150;

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public List<MacroAction> getLongPressKeys() {
        return longPressKeys;
    }

    public void setLongPressKeys(List<MacroAction> longPressKeys) {
        this.longPressKeys = longPressKeys;
    }

    public List<MacroAction> getShortStrokes() {
        return shortStrokes;
    }

    public void setShortStrokes(List<MacroAction> shortStrokes) {
        this.shortStrokes = shortStrokes;
    }

    @Override
    public String getMacroText() {
        return null;
    }
}
