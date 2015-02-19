/**
 * Copyright (c) 2013-2015 Jens Deters http://www.jensd.de
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 *
 */
package de.jensd.fx.glyphs;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconName;
import de.jensd.fx.glyphs.weathericons.WeatherIcon;
import de.jensd.fx.glyphs.weathericons.WeatherIconName;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TreeItem;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Jens Deters
 */
public class GlyphsDude {

    static {
        Font.loadFont(GlyphsDude.class.getResource(FontAwesomeIcon.TTF_PATH).toExternalForm(), 10.0);
        Font.loadFont(GlyphsDude.class.getResource(WeatherIcon.TTF_PATH).toExternalForm(), 10.0);
    }

    
    public static Text createIcon(GlyphIconName icon) {
        return GlyphsDude.createIcon(icon, GlyphIcon.DEFAULT_ICON_SIZE);
    }

    public static Text createIcon(GlyphIconName icon, String iconSize) {
        if(icon instanceof FontAwesomeIconName){
            return createIcon((FontAwesomeIconName)icon, iconSize);
        }else if(icon instanceof WeatherIconName){
            return createIcon((WeatherIconName)icon, iconSize);
        }
        return new Text("ICON NOT FOUND");
    }
    
    
    /*
     * Weather Icons stuff 
     *
     */
    public static Text createIcon(WeatherIconName icon) {
        return GlyphsDude.createIcon(icon, GlyphIcon.DEFAULT_ICON_SIZE);
    }

    public static Text createIcon(WeatherIconName icon, String iconSize) {
        Text text = new Text(icon.characterToString());
        text.getStyleClass().add("glyph-icon");
        text.setStyle(String.format("-fx-font-family: %s; -fx-font-size: %s;",icon.getFontFamily(), iconSize));
        return text;
    }

    /*
     * Font Awesome stuff 
     *
     */
    public static Text createIcon(FontAwesomeIconName icon) {
        return GlyphsDude.createIcon(icon, GlyphIcon.DEFAULT_ICON_SIZE);
    }

    public static Text createIcon(FontAwesomeIconName icon, String iconSize) {
        Text text = new Text(icon.characterToString());
        text.getStyleClass().add("glyph-icon");
        text.setStyle(String.format("-fx-font-family: %s; -fx-font-size: %s;", icon.getFontFamily(), iconSize));
        return text;
    }

    public static Label createIconLabel(FontAwesomeIconName icon, String text, String iconSize, String fontSize, ContentDisplay contentDisplay) {
        Text iconLabel = GlyphsDude.createIcon(icon, iconSize);
        Label label = new Label(text);
        label.setStyle("-fx-font-size: " + fontSize);
        label.setGraphic(iconLabel);
        label.setContentDisplay(contentDisplay);
        return label;
    }

    public static Button createIconButton(FontAwesomeIconName icon) {
        return createIconButton(icon, "");
    }

    public static Button createIconButton(FontAwesomeIconName icon, String text) {
        Text label = GlyphsDude.createIcon(icon, GlyphIcon.DEFAULT_ICON_SIZE);
        Button button = new Button(text);
        button.setGraphic(label);
        return button;
    }

    public static Button createIconButton(FontAwesomeIconName icon, String text, String iconSize, String fontSize, ContentDisplay contentDisplay) {
        Text label = GlyphsDude.createIcon(icon, iconSize);
        Button button = new Button(text);
        button.setStyle("-fx-font-size: " + fontSize);
        button.setGraphic(label);
        button.setContentDisplay(contentDisplay);
        return button;
    }

    public static ToggleButton createIconToggleButton(FontAwesomeIconName icon, String text, String iconSize, ContentDisplay contentDisplay) {
        return createIconToggleButton(icon, text, iconSize, GlyphIcon.DEFAULT_FONT_SIZE, contentDisplay);
    }

    public static ToggleButton createIconToggleButton(FontAwesomeIconName icon, String text, String iconSize, String fontSize, ContentDisplay contentDisplay) {
        Text label = GlyphsDude.createIcon(icon, iconSize);
        ToggleButton button = new ToggleButton(text);
        button.setStyle("-fx-font-size: " + fontSize);
        button.setGraphic(label);
        button.setContentDisplay(contentDisplay);
        return button;
    }


    /*
     * 
     * 
     * 
     */
    
    public static void setIcon(Tab tab, GlyphIconName icon) {
        setIcon(tab, icon, GlyphIcon.DEFAULT_ICON_SIZE);
    }

    public static void setIcon(Tab tab, GlyphIconName icon, String iconSize) {
        tab.setGraphic(GlyphsDude.createIcon(icon, iconSize));
    }

    public static void setIcon(Labeled labeled, GlyphIconName icon) {
        setIcon(labeled, icon, GlyphIcon.DEFAULT_ICON_SIZE);
    }

    public static void setIcon(Labeled labeled, GlyphIconName icon, ContentDisplay contentDisplay) {
        setIcon(labeled, icon, GlyphIcon.DEFAULT_ICON_SIZE, contentDisplay);
    }

    public static void setIcon(Labeled labeled, GlyphIconName icon, String iconSize) {
        setIcon(labeled, icon, iconSize, ContentDisplay.LEFT);
    }

    public static void setIcon(Labeled labeled, GlyphIconName icon, String iconSize, ContentDisplay contentDisplay) {
        if (labeled == null) {
            throw new IllegalArgumentException("The component must not be 'null'!");
        }
        labeled.setGraphic(GlyphsDude.createIcon(icon, iconSize));
        labeled.setContentDisplay(contentDisplay);
    }

    public static void setIcon(MenuItem menuItem, GlyphIconName icon) {
        setIcon(menuItem, icon, GlyphIcon.DEFAULT_FONT_SIZE, GlyphIcon.DEFAULT_ICON_SIZE);
    }

    public static void setIcon(MenuItem menuItem, GlyphIconName icon, String iconSize) {
        setIcon(menuItem, icon, GlyphIcon.DEFAULT_FONT_SIZE, iconSize);
    }

    public static void setIcon(MenuItem menuItem, GlyphIconName icon, String fontSize, String iconSize) {
        if (menuItem == null) {
            throw new IllegalArgumentException("The menu item must not be 'null'!");
        }
        Text label = GlyphsDude.createIcon(icon, iconSize);
        menuItem.setStyle("-fx-font-size: " + fontSize);
        menuItem.setGraphic(label);
    }

    public static void setIcon(TreeItem treeItem, FontAwesomeIconName icon) {
        setIcon(treeItem, icon, GlyphIcon.DEFAULT_ICON_SIZE);
    }

    public static void setIcon(TreeItem treeItem, FontAwesomeIconName icon, String iconSize) {
        if (treeItem == null) {
            throw new IllegalArgumentException("The tree item must not be 'null'!");
        }
        Text label = GlyphsDude.createIcon(icon, iconSize);
        treeItem.setGraphic(label);
    }

}
