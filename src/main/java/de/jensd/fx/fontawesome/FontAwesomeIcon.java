/**
 * Copyright (c) 2014 Jens Deters http://www.jensd.de
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 *
 */
package de.jensd.fx.fontawesome;

import static de.jensd.fx.fontawesome.AwesomeDude.FONT_AWESOME_TTF_PATH;
import de.jensd.weathericons.WeatherIconName;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Jens Deters
 */
public class FontAwesomeIcon extends Text {

    static {
        Font.loadFont(AwesomeDude.class.getResource(FONT_AWESOME_TTF_PATH).toExternalForm(), 10.0);
    }

    private static String ICON_STYLE_CLASS = "awesome";
    private static String ICON_STYLE_PREFIX = "-fx-font-family: FontAwesome;";
    private StringProperty size;
    private StringProperty iconName;

    @FXML
    public void init() {
    }

    public FontAwesomeIcon(AwesomeIconName icon, String size, String style, String styleClass) {
        setText(icon.characterToString());
        getStyleClass().add(ICON_STYLE_CLASS);
        if (styleClass != null && !styleClass.isEmpty()) {
            getStyleClass().add(styleClass);
        }
        size = (size == null || size.isEmpty()) ? "2em" : size;
        String stylePrefix = String.format("%s -fx-font-size: %s;", ICON_STYLE_PREFIX, size);
        setStyle(stylePrefix + (style == null ? "" : style));
    }

    public FontAwesomeIcon(String iconName, String size, String style, String styleClass) {
        this(AwesomeIconName.valueOf(iconName), size, style, styleClass);
    }

    public FontAwesomeIcon(String iconName, String size, String styleClass) {
        this(AwesomeIconName.valueOf(iconName), size, null, styleClass);
    }

    public FontAwesomeIcon(String iconName, String size) {
        this(AwesomeIconName.valueOf(iconName), size, null, null);
    }

    public FontAwesomeIcon(String iconName) {
        this(AwesomeIconName.valueOf(iconName), "2em", null, null);
    }

    public FontAwesomeIcon() {
        this(AwesomeIconName.SQUARE, "2em", null, null);
    }

    public static FontAwesomeIcon create() {
        return new FontAwesomeIcon();
    }

    public FontAwesomeIcon style(String style) {
        style = String.format("%s %s", ICON_STYLE_PREFIX, (style == null ? "" : style));
        setStyle(style);
        return this;
    }

    public FontAwesomeIcon styleClass(String styleClass) {
        getStyleClass().add(styleClass);
        return this;
    }

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
        setStyle(String.format("%s -fx-font-size: %s;", ICON_STYLE_PREFIX, size));
        sizeProperty().setValue(size);
    }

    public FontAwesomeIcon size(String iconSize) {
        setSize(iconSize);
        return this;
    }

    public final StringProperty iconNameProperty() {
        if (iconName == null) {
            iconName = new SimpleStringProperty(AwesomeIconName.UMBRELLA.characterToString());
        }
        return iconName;
    }

    public final String getIconName() {
        return iconNameProperty().getValue();
    }

    public void setIconName(String iconName) {
        setText(AwesomeIconName.valueOf(iconName).characterToString());
        iconNameProperty().setValue(iconName);
    }

    public FontAwesomeIcon icon(AwesomeIconName icon) {
        setIcon(icon);
        return this;
    }

    public void setIcon(AwesomeIconName icon) {
        setIconName(icon.name());
    }

}
