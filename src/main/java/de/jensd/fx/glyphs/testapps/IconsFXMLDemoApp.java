/**
 * Copyright (c) 2013,2014 Jens Deters http://www.jensd.de
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
package de.jensd.fx.glyphs.testapps;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Jens Deters
 */
public class IconsFXMLDemoApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        IconsFXMLDemo iconsFXMLDemo = new IconsFXMLDemo();
        Scene scene = new Scene(iconsFXMLDemo, 800, 600);
        scene.getStylesheets().add("/styles/iconsbrowser.css");
        primaryStage.setTitle("FontAwesomeFX Icons-FXML-Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}