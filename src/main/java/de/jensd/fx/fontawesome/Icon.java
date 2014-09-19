/**
 * Copyright (c) 2014 Jens Deters http://www.jensd.de
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
package de.jensd.fx.fontawesome;

import static de.jensd.fx.fontawesome.AwesomeDude.FONT_AWESOME_TTF_PATH;
import javafx.beans.NamedArg;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 *
 * @author Jens Deters
 */
public class Icon extends Label {

    @FXML
    void initialize() {
    }

    static {
        Font.loadFont(AwesomeDude.class.getResource(FONT_AWESOME_TTF_PATH).toExternalForm(), 10.0);
    }

    public Icon(AwesomeIcon icon, String size, String style, String styleClass) {
        setText(icon.toString());
        // add least add "awesome"-class
        getStyleClass().add("awesome");
        if (styleClass != null && !styleClass.isEmpty()) {
            getStyleClass().add(styleClass);
        }
        size = (size == null || size.isEmpty()) ? "2em" : size;
        // make sure FontAwesome is assigned with propriate size:
        String stylePrefix = String.format("-fx-font-family: FontAwesome; -fx-font-size: %s;", size);
        setStyle(stylePrefix + style);
    }

    public Icon(@NamedArg("awesomeIcon") String awesomeIcon, @NamedArg("size") String size, @NamedArg("style") String style, @NamedArg("styleClass") String styleClass) {
        this(AwesomeIcon.valueOf(awesomeIcon), size, style, styleClass);
    }

    public Icon(@NamedArg("awesomeIcon") String awesomeIcon, @NamedArg("size") String size, @NamedArg("styleClass") String styleClass) {
        this(AwesomeIcon.valueOf(awesomeIcon), size, null, styleClass);
    }

    public Icon(@NamedArg("awesomeIcon") String awesomeIcon, @NamedArg("size") String size) {
        this(AwesomeIcon.valueOf(awesomeIcon), size, null, null);
    }

    public Icon(@NamedArg("awesomeIcon") String awesomeIcon) {
        this(AwesomeIcon.valueOf(awesomeIcon), "2em", null, null);
    }

    private Icon() {
        this(AwesomeIcon.STAR, "2em", null, null);
    }

    public static Icon create() {
        return new Icon();
    }

    public Icon icon(AwesomeIcon icon) {
        setText(icon.toString());
        return this;
    }

    public Icon size(String iconSize) {
        setStyle("-fx-font-size: " + iconSize + ";");
        return this;
    }

    public Icon style(String style) {
        setStyle(style);
        return this;
    }

    public Icon styleClass(String styleClass) {
        getStyleClass().add(styleClass);
        return this;
    }

}
