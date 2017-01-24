/**
 * Copyright (c) 2013-2016 Jens Deters http://www.jensd.de
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
package de.jensd.fx.glyphs.icons525;

import de.jensd.fx.glyphs.GlyphIcon;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.Font;

/**
 *
 * @author Jens Deters (mail@jensd.de)
 */
public class Icons525View extends GlyphIcon<Icons525> {

    public final static String TTF_PATH = "/de/jensd/fx/glyphs/icons525/525icons.ttf";

    static {
        try {
            Font.loadFont(Icons525View.class.getResource(TTF_PATH).openStream(), 10.0d);
        } catch (IOException ex) {
            Logger.getLogger(Icons525View.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Icons525View(Icons525 icon) {
        super(Icons525.class);
        setFont(new Font("525icons", DEFAULT_ICON_SIZE));
        setIcon(icon);
        getStyleClass().add("glyph-icon");
        setStyle(String.format("-fx-font-family: %s;", icon.getFontFamily()));
    }

    public Icons525View() {
        this(Icons525.ACCESS);
    }

    @Override
    public Icons525 getDefaultGlyph() {
        return Icons525.ACCESS;
    }

}
