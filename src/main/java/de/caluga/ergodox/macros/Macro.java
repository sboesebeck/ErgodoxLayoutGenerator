package de.caluga.ergodox.macros;

/**
 * User: Stephan Bösebeck
 * Date: 02.04.16
 * Time: 23:12
 * <p>
 * TODO: Add documentation here
 */
public abstract class Macro {
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract String getMacroText();

}
