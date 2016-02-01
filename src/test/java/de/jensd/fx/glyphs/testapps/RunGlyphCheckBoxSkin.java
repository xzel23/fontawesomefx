/* 
 * Copyright 2016 Jens Deters.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.jensd.fx.glyphs.testapps;

import de.jensd.fx.glyphs.GlyphIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.control.GlyphCheckBox;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Jens Deters (www.jensd.de)
 * @version 1.0.0
 * @since 12-01-2016
 */
public class RunGlyphCheckBoxSkin extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        GlyphIcon selectedIcon = new FontAwesomeIconView(FontAwesomeIcon.TOGGLE_ON);
        selectedIcon.setSize("2em");
        GlyphIcon notSelectedIcon = new FontAwesomeIconView(FontAwesomeIcon.TOGGLE_OFF);
        notSelectedIcon.setSize("2em");

        GlyphCheckBox glyphCheckBoxDefault = new GlyphCheckBox();
        GlyphCheckBox glyphCheckBox = new GlyphCheckBox(notSelectedIcon, selectedIcon, " linked");


        glyphCheckBox.setSelected(true);

        Parent root = new HBox(glyphCheckBoxDefault, glyphCheckBox);
        Scene scene = new Scene(root);
        stage.setTitle("GlyphCheckBoxSkin Demo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
