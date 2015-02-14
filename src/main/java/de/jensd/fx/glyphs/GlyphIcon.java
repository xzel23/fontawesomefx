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
package de.jensd.fx.glyphs;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 *
 * @author Jens Deters
 */
public abstract class GlyphIcon extends Text {

    private StringProperty glyphStyleClass;
    private StringProperty glyphFontFamily;
    private StringProperty size;
    private StringProperty glyphStyle;
    private StringProperty iconName;

    @FXML
    public void init() {

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
        getStyleClass().add(styleClass);
    }

    public StringProperty glyphFontFamilyProperty() {
        if (glyphFontFamily == null) {
            glyphFontFamily = new SimpleStringProperty();
        }
        return glyphFontFamily;
    }

    public String getGlyphFontFamily() {
        return glyphFontFamilyProperty().getValue();
    }

    public void setGlyphFontFamily(String glyphFontFamily) {
        glyphFontFamilyProperty().setValue(glyphFontFamily);
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

    private void updateStyle() {
        setText(lookupIconChar(getIconName()));
        String style = String.format("-fx-font-family: %s; -fx-font-size: %s; %s", getGlyphFontFamily(), getSize(), getGlyphStyle());
        setStyle(style);
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

    public final void setIcon(GlyphIconName icon) {
        setIconName(icon.name());
    }

    protected abstract String lookupIconChar(String iconName);

}
