/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensd.fx.glyphs.weathericons;

import de.jensd.fx.glyphs.GlyphIcon;
import de.jensd.fx.glyphs.GlyphsDude;
import static de.jensd.fx.glyphs.GlyphsDude.WEATHER_ICONS_TTF_PATH;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconName;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.text.Font;

/**
 *
 * @author Jens Deters (mail@jensd.de)
 */
public class WeatherIcon extends GlyphIcon {

    static {
        Font.loadFont(GlyphsDude.class.getResource(WEATHER_ICONS_TTF_PATH).toExternalForm(), 10.0);
    }

    public WeatherIcon() {
        setGlyphStyleClass("weather");
        setGlyphFontFamily("\'weather icons\'");
        setIcon(WeatherIconName.CLOUD);
    }

    @Override
    protected String lookupIconChar(String iconName) {
        return WeatherIconName.valueOf(iconName).characterToString();
    }

}
