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

import de.jensd.fx.glyphs.GlyphIcons;

/**
 *
 * Icon Enum based on Weather Icons v2.0
 *
 * @author Jens Deters (mail@jensd.de)
 * @version 2.0 (222 Icons)
 */
public enum AppleColorEmoji implements GlyphIcons {

    A("\uD83D\uDE05"),
    B("\uD83D\uDE00"),
    C("\u2602"),
    D("\u2623");

    private final String unicode;

    private AppleColorEmoji(String unicode) {
        this.unicode = unicode;
    }

    @Override
    public String unicode() {
        return unicode;
    }

    @Override
    public String fontFamily() {
        return "\'Apple Color Emoji\'";
    }

}
