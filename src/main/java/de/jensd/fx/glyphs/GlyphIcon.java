/**
 * Copyright (c) 2015 Jens Deters http://www.jensd.de
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 *
 */
package de.jensd.fx.glyphs;

import java.lang.reflect.ParameterizedType;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 * A GlyphIcon represents an Icon Node.
 *
 * @author Jens Deters
 * @param <T> The type of GlyphIcons enum.
 */
public abstract class GlyphIcon<T extends Enum<T>> extends Text {

    public final static String DEFAULT_ICON_SIZE = "16.0";
    public final static String DEFAULT_FONT_SIZE = "1em";

    private StringProperty glyphStyleClass;
    private StringProperty size;
    private StringProperty glyphStyle;
    private StringProperty iconName;
    public final Class<T> typeOfT;

    @FXML
    public void init() {

    }

    public GlyphIcon() {
        this.typeOfT = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
        setGlyphStyleClass("glyph-icon");
    }

    public final StringProperty glyphStyleClassProperty() {
        if (glyphStyleClass == null) {
            glyphStyleClass = new SimpleStringProperty();
        }
        return glyphStyleClass;
    }

    public final String getGlyphStyleClass() {
        return glyphStyleClassProperty().getValue();
    }

    public final void setGlyphStyleClass(String styleClass) {
        glyphStyleClassProperty().setValue(styleClass);
        getStyleClass().setAll(styleClass, "glyph-icon");
    }

    public final GlyphIcon glyphStyleClass(String styleClass) {
        setGlyphStyleClass(styleClass);
        return this;
    }

    public final StringProperty glyphStyleProperty() {
        if (glyphStyle == null) {
            glyphStyle = new SimpleStringProperty("");
        }
        return glyphStyle;
    }

    public final String getGlyphStyle() {
        return glyphStyleProperty().getValue();
    }

    public final void setGlyphStyle(String style) {
        glyphStyleProperty().setValue(style);
        updateStyle();
    }

    public final GlyphIcon style(String style) {
        setGlyphStyle(style);
        return this;
    }

    private GlyphIcons getGlyphIconName() {
        return ((GlyphIcons) Enum.valueOf(typeOfT, getIconName()));
    }

    private void updateStyle() {
        setText(getGlyphIconName().characterToString());
        String style = String.format("-fx-font-family: %s; -fx-font-size: %s; %s", getGlyphIconName().getFontFamily(), getSize(), getGlyphStyle());
        setStyle(style);
    }

    public final StringProperty sizeProperty() {
        if (size == null) {
            size = new SimpleStringProperty(DEFAULT_FONT_SIZE);
        }
        return size;
    }

    public final String getSize() {
        return sizeProperty().getValue();
    }

    public final void setSize(String size) {
        size = (size == null || size.isEmpty()) ? DEFAULT_FONT_SIZE : size;
        sizeProperty().setValue(size);
        updateStyle();
    }

    public final GlyphIcon size(String iconSize) {
        setSize(iconSize);
        return this;
    }

    public final StringProperty iconNameProperty() {
        if (iconName == null) {
            iconName = new SimpleStringProperty("");
        }
        return iconName;
    }

    public final String getIconName() {
        return iconNameProperty().getValue();
    }

    public final void setIconName(String iconName) {
        iconNameProperty().setValue(iconName);
        updateStyle();
    }

    public final void setIcon(T icon) {
        setIconName(icon.name());
    }

}
