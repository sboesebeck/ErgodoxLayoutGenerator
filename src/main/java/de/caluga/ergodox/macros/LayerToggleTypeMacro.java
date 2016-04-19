package de.caluga.ergodox.macros;/**
 * Created by stephan on 18.04.16.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * TODO: Add Documentation here
 **/
public class LayerToggleTypeMacro extends Macro {
    public final static Pattern pattern = Pattern.compile("if\\(record->event.pressed\\)\\{start=timer_read\\(\\);layer_state\\^=\\(1<<([0-9A-Za-z_]+)\\);layer_state&=\\(1<<[0-9A-Za-z_]+\\);returnMACRO_NONE;\\}else\\{layer_state\\^=\\(1<<[0-9A-Za-z_]+\\);layer_state&=\\(1<<[0-9A-Za-z_]+\\);if\\(timer_elapsed\\(start\\)>([0-9]+)\\)\\{returnMACRO_NONE;\\}else\\{returnMACRO\\(([0-9A-Za-z(),_]+),END\\);\\}\\}");
    private String layer;
    private List<MacroAction> actionsOnType = new ArrayList<>();
    private int timeout = 150;

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public List<MacroAction> getActionsOnType() {
        if (actionsOnType == null) actionsOnType = new ArrayList<>();
        return actionsOnType;
    }

    public void setActionsOnType(List<MacroAction> actionsOnType) {
        this.actionsOnType = actionsOnType;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public String getMacroGuiText() {
        return "Type\nToggle " + layer + "";
    }

    @Override
    public String getDescription() {
        StringBuilder b = new StringBuilder();

        b.append("Macro ").append(getName());
        b.append("\n");
        b.append("Hold Key: Toggles ");
        b.append(layer);
        b.append("\n");
        b.append("Type key: ");
        b.append(getMacroActionListString(getActionsOnType()));
        b.append("\n");
        b.append("Timeout: " + getTimeout());
        return b.toString();
    }
}
