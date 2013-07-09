package de.jensd.fx.fontawesome;

/**
 * @author Jens
 */
public enum AwesomeStyle {

    PLAIN("/styles/awesome.css"),
    DARK("/styles/awesome_dark.css"),
    LIGHT("/styles/awesome_light.css"),
    BLUE("/styles/awesome_blue.css"),
    RED("/styles/awesome_red.css");
    private final String stylePath;

    private AwesomeStyle(String stylePath) {
        this.stylePath = stylePath;
    }

    public String getStylePath() {
        return stylePath;
    }

    @Override
    public String toString() {
        return stylePath;
    }
}
