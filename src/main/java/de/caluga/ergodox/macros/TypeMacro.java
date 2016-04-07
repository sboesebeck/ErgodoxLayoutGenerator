package de.caluga.ergodox.macros;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Stephan Bösebeck
 * Date: 02.04.16
 * Time: 23:24
 * <p>
 * TODO: Add documentation here
 */
public class TypeMacro extends Macro {
    private List<MacroAction> actions;

    public List<MacroAction> getActions() {
        if (actions == null) actions = new ArrayList<>();

        return actions;
    }

    public void setActions(List<MacroAction> actions) {
        this.actions = actions;
    }

    @Override
    public String getMacroText() {
        return null;
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        for (MacroAction a : getActions()) {
            b.append(a.getAction().name());
            b.append(":   ");
            b.append("keycode: ");
            b.append(a.getCode());
            b.append("    wait: ");
            b.append(a.getWait());
        }
        return b.toString();
    }
}
