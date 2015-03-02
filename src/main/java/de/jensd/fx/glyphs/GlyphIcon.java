/**
 * Copyright (c) 2015 Jens Deters http://www.jensd.de
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 */
package de.jensd.fx.glyphs;

import java.lang.reflect.ParameterizedType;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

    private StringProperty size;
    private StringProperty glyphStyle; // needed as setStyle() is final in javafx.scene.text.Text 
    private StringProperty glyphName;
    public final Class<T> typeOfT;

    @FXML
    public void init() {
    }

    public GlyphIcon() {
        this.typeOfT = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
        getStyleClass().addAll("root", "glyph-icon");
        
        sizeProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            updateStyle();
        });
        glyphStyleProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            updateStyle();
        });
        glyphNameProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            updateStyle();
        });
        
        setIcon(getDefaultGlyph());
    }

    // convenience method
    public final GlyphIcon setStyleClass(String styleClass) {
        getStyleClass().add(styleClass);
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
    }

    public final StringProperty glyphNameProperty() {
        if (glyphName == null) {
            glyphName = new SimpleStringProperty("");
        }
        return glyphName;
    }

    public final String getGlyphName() {
        return glyphNameProperty().getValue();
    }

    public final void setGlyphName(String glyphName) {
        glyphNameProperty().setValue(glyphName);
    }

    public final void setIcon(T glyph) {
        setGlyphName(glyph.name());
    }

    abstract public T getDefaultGlyph();

    private void updateStyle() {
        GlyphIcons icon = (GlyphIcons) getDefaultGlyph();
        try {
            icon = ((GlyphIcons) Enum.valueOf(typeOfT, getGlyphName()));
        } catch (Exception e) {
            String msg = String.format("Icon '%s' not found. Using '%s' (default) instead", getGlyphName(), getDefaultGlyph());
            Logger.getLogger(GlyphIcon.class.getName()).log(Level.SEVERE, msg);
        }
        setText(icon.characterToString());
        String style = String.format("-fx-font-family: %s; -fx-font-size: %s; %s", icon.getFontFamily(), getSize(), getGlyphStyle());
        setStyle(style);
    }

}
