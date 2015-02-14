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
package de.jensd.fx.glyphs.fontawesome;

import de.jensd.fx.glyphs.GlyphIcon;
import de.jensd.fx.glyphs.GlyphsDude;
import static de.jensd.fx.glyphs.GlyphsDude.FONT_AWESOME_TTF_PATH;
import javafx.scene.text.Font;

/**
 *
 * @author Jens Deters
 */
public class FontAwesomeIcon extends GlyphIcon {

    static {
        Font.loadFont(GlyphsDude.class.getResource(FONT_AWESOME_TTF_PATH).toExternalForm(), 10.0);
    }

    public FontAwesomeIcon() {
        setGlyphStyleClass("awesome");
        setGlyphFontFamily("FontAwesome");
        setIcon(FontAwesomeIconName.ANCHOR);
    }

    @Override
    protected String lookupIconChar(String iconName) {
        return FontAwesomeIconName.valueOf(iconName).characterToString();
    }

}
