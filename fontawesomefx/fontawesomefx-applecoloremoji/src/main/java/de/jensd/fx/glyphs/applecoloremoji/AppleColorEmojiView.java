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
package de.jensd.fx.glyphs.applecoloremoji;

import de.jensd.fx.glyphs.GlyphIcon;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.Font;

/**
 *
 * @author Jens Deters (mail@jensd.de)
 */
public class AppleColorEmojiView extends GlyphIcon<AppleColorEmoji> {

    public final static String TTF_PATH = "/de/jensd/fx/glyphs/applecoloremoji/AppleColorEmoji.ttf";

    static {
        try {
            Font.loadFont(AppleColorEmojiView.class.getResource(TTF_PATH).openStream(), 10.0d);
        } catch (IOException ex) {
            Logger.getLogger(AppleColorEmojiView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public AppleColorEmojiView(AppleColorEmoji icon) {
        super(AppleColorEmoji.class);
        setFont(new Font("Apple Color Emoji", DEFAULT_ICON_SIZE));
        setIcon(icon);
        setStyle(String.format("-fx-font-family: '%s';", icon.fontFamily()));
    }

    public AppleColorEmojiView() {
        this(AppleColorEmoji.A);
    }

    @Override
    public AppleColorEmoji getDefaultGlyph() {
        return AppleColorEmoji.A;
    }

}
