/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensd.fx.glyphs.weathericons;

import de.jensd.fx.glyphs.GlyphsDude;
import static de.jensd.fx.glyphs.GlyphsDude.WEATHER_ICONS_TTF_PATH;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconName;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Jens Deters (mail@jensd.de)
 */
public class WeatherIcon extends Text {

    static {
        Font.loadFont(GlyphsDude.class.getResource(WEATHER_ICONS_TTF_PATH).toExternalForm(), 10.0);
    }

    public WeatherIcon(WeatherIconName icon, String size, String style, String styleClass) {
        setText(icon.characterToString());
        getStyleClass().add("weather");
        if (styleClass != null && !styleClass.isEmpty()) {
            getStyleClass().add(styleClass);
        }
        size = (size == null || size.isEmpty()) ? "2em" : size;
        String stylePrefix = String.format("-fx-font-family: 'weather icons'; -fx-font-size: %s;", size);
        setStyle(stylePrefix + (style == null ? "" : style));
    }

    public WeatherIcon(String iconName, String size, String style, String styleClass) {
        this(WeatherIconName.valueOf(iconName), size, style, styleClass);
    }

    public WeatherIcon(String iconName, String size, String styleClass) {
        this(WeatherIconName.valueOf(iconName), size, null, styleClass);
    }

    public WeatherIcon(String iconName) {
        this(WeatherIconName.valueOf(iconName), "2em", null, null);
    }

    public WeatherIcon(String iconName, String size) {
        this(WeatherIconName.valueOf(iconName), size, null, null);
    }

    public WeatherIcon() {
        this(WeatherIconName.UMBRELLA, "2em", null, null);
    }

    private StringProperty size;

    public final StringProperty sizeProperty() {
        if (size == null) {
            size = new SimpleStringProperty("1em");
        }
        return size;
    }

    public final String getSize() {
        return sizeProperty().getValue();
    }

    public final void setSize(String size) {
        size = (size == null || size.isEmpty()) ? "1em" : size;
        setStyle(String.format("-fx-font-family: 'weather icons'; -fx-font-size: %s;", size));
        sizeProperty().setValue(size);
    }

    private StringProperty iconName;

    public final StringProperty iconNameProperty() {
        if (iconName == null) {
            iconName = new SimpleStringProperty(WeatherIconName.UMBRELLA.characterToString());
        }
        return iconName;
    }

    public final String getIconName() {
        return iconNameProperty().getValue();
    }

    public void setIconName(String iconName) {
        setText(WeatherIconName.valueOf(iconName).characterToString());
        iconNameProperty().setValue(iconName);
    }


}
