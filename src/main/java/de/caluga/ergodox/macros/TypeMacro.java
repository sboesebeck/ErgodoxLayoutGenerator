package de.caluga.ergodox.macros;

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
        return actions;
    }

    public void setActions(List<MacroAction> actions) {
        this.actions = actions;
    }

    @Override
    public String getMacroText() {
        return null;
    }
}
