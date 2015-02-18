/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensd.fx.glyphs.weathericons;

import de.jensd.fx.glyphs.Glyph;
import javafx.scene.text.Font;

/**
 *
 * @author Jens Deters (mail@jensd.de)
 */
public class WeatherIcon extends Glyph<WeatherIconName> {

    public final static String TTF_PATH = "/de/jensd/fx/glyphs/weathericons/weathericons-regular-webfont.ttf";
    public final static String FONT_FAMILY = "\'weather icons\'";

    static {
        Font.loadFont(WeatherIcon.class.getResource(TTF_PATH).toExternalForm(), 10.0);
    }

    public WeatherIcon() {
        this(WeatherIconName.UMBRELLA, "1em");
    }

    public WeatherIcon(WeatherIconName iconName, String size) {
        setIcon(WeatherIconName.CLOUD);
    }
}
