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
package de.jensd.fx.glyphs.fontawesome.demo;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.fontawesome.utils.FontAwesomeIconFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Jens Deters
 */
public class FontAwesomeIconsDemoApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox buttonBox1 = new HBox();
        for (int i = 0; i < 10; i++) {
            ToggleButton toggle1 = new ToggleButton();
            FontAwesomeIconView iconView = new FontAwesomeIconView(FontAwesomeIcon.ANGELLIST);
            iconView.setGlyphSize(42.0);
            toggle1.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            toggle1.setGraphic(iconView);
            buttonBox1.getChildren().add(toggle1);
        }

        HBox buttonBox2 = new HBox();
        for (int i = 0; i < 10; i++) {
            ToggleButton toggle1 = FontAwesomeIconFactory.get().createIconToggleButton(FontAwesomeIcon.ANGELLIST, "", "2em");
            buttonBox2.getChildren().add(toggle1);
        }

        FlowPane iconsPane = new FlowPane(3, 3);
        iconsPane.getChildren().add(buttonBox1);
        iconsPane.getChildren().add(buttonBox2);
        for (FontAwesomeIcon icon : FontAwesomeIcon.values()) {
            iconsPane.getChildren().add(FontAwesomeIconFactory.get().createIcon(icon, "3em"));
        }
        Scene scene = new Scene(new ScrollPane(iconsPane), 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("FontAwesomeFX: FontAwesomeIcons Demo: " + FontAwesomeIcon.values().length + " Icons");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
