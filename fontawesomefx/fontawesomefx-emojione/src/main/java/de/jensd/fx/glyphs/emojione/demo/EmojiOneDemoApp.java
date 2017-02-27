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
package de.jensd.fx.glyphs.emojione.demo;

import de.jensd.fx.glyphs.emojione.EmojiOne;
import de.jensd.fx.glyphs.emojione.EmojiOneView;
import de.jensd.fx.glyphs.emojione.utils.EmojiOneFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author Jens Deters
 */
public class EmojiOneDemoApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {        
        
        FlowPane iconsPane = new FlowPane(3, 3);
        for (EmojiOne icon : EmojiOne.values()) {
            iconsPane.getChildren().add(new EmojiOneView(icon, "3em"));
        }
        Scene scene = new Scene(new ScrollPane(iconsPane), 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("FontAwesomeFX: Apple Color Emoji Demo");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
