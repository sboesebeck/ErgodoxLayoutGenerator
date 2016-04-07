package de.caluga.ergodox;/**
 * Created by stephan on 07.04.16.
 */

import de.caluga.ergodox.macros.Macro;

import java.util.Map;

/**
 * Data Model representing an Ergodox layout
 * containing both layers, leds and macros
 **/
public class ErgodoxLayout {
    private Map<String, ErgodoxLayoutLayer> layers;
    private Map<String, Macro> macros;

    public Map<String, ErgodoxLayoutLayer> getLayers() {
        return layers;
    }

    public void setLayers(Map<String, ErgodoxLayoutLayer> layers) {
        this.layers = layers;
    }

    public Map<String, Macro> getMacros() {
        return macros;
    }

    public void setMacros(Map<String, Macro> macros) {
        this.macros = macros;
    }
}
