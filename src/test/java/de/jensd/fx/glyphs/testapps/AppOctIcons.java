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
package de.jensd.fx.glyphs.testapps;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.octicons.OctIcon;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author Jens Deters
 * @author Naoghuman (https://github.com/Naoghuman)
 */
public class AppOctIcons extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FlowPane root = new FlowPane(3, 3);
        for (OctIcon octicon : OctIcon.values()) {
//            root.getChildren().add(new OctIconView(octicon));
            root.getChildren().add(GlyphsDude.createIcon(octicon, "4em"));
        }

        Scene scene = new Scene(root, 500, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("FontAwesomeFX demo");
        primaryStage.show();

    }

    public static void main(String[] args) {
        System.setProperty("prism.lcdtext", "false");
        launch(args);
    }
}
