/**
 * Copyright (c) 2013-2016 Jens Deters http://www.jensd.de
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
package de.jensd.fx.glyphs.materialdesignicons;

import de.jensd.fx.glyphs.GlyphIcon;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.Font;

/**
 *
 * @author Jens Deters (mail@jensd.de)
 */
public class MaterialDesignIconView extends GlyphIcon<MaterialDesignIcon> {

    public final static String TTF_PATH = "/de/jensd/fx/glyphs/materialdesignicons/materialdesignicons-webfont.ttf";

    static {
        try {
            Font.loadFont(MaterialDesignIconView.class.getResource(TTF_PATH).openStream(), 10.0d);
        } catch (IOException ex) {
            Logger.getLogger(MaterialDesignIconView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public MaterialDesignIconView(MaterialDesignIcon icon, String iconSize) {
        super(MaterialDesignIcon.class);
        setIcon(icon);
        setStyle(String.format("-fx-font-family: %s; -fx-font-size: %s;", icon.fontFamily(), iconSize));
    }

    public MaterialDesignIconView(MaterialDesignIcon icon) {
        this(icon, "1em");
    }
    
    public MaterialDesignIconView() {
        this(MaterialDesignIcon.ANDROID);
    }

    @Override
    public MaterialDesignIcon getDefaultGlyph() {
        return MaterialDesignIcon.ANDROID;
    }

}
