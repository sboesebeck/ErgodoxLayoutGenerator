package de.caluga.ergodox.macros;/**
 * Created by stephan on 19.04.16.
 */

import java.util.regex.Pattern;

/**
 * TODO: Add Documentation here
 **/
public class LayerToggleAndHoldMacro extends Macro {
    public final static Pattern pattern = Pattern.compile("if\\(record->event.pressed\\)\\{start=timer_read\\(\\);layer_state\\^=\\(1<<([0-9A-Za-z_]+)\\);layer_state&=\\([^;]+\\);\\}else\\{if\\(timer_elapsed\\(start\\)>([0-9]+)\\)\\{layer_state\\^=\\([^;]+\\);layer_state&=\\([^;]+\\);\\}\\}returnMACRO_NONE;");
    private String layer;
    private int timeout = 150;

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }


    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public String getMacroGuiText() {
        return "Hold or toggle\nLayer " + layer + "";
    }

    @Override
    public String getDescription() {
        StringBuilder b = new StringBuilder();

        b.append("Macro ").append(getName());
        b.append("\n");
        b.append("toggle or hold layer: ");
        b.append(layer);
        b.append("\n");
        b.append("Timeout: " + getTimeout());
        return b.toString();
    }
}
