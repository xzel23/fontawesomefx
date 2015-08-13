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
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.materialicons.MaterialIcon;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import de.jensd.fx.glyphs.weathericons.WeatherIconView;
import de.jensd.fx.glyphs.weathericons.WeatherIcon;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Jens Deters
 */
public class AppMaterialIcons extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox root = new VBox();
        root.setSpacing(10.0);

        Text star = GlyphsDude.createIcon(MaterialIcon.STAR, "4em");
        Text label1 = GlyphsDude.createIcon(MaterialIcon.LABEL, "4em");
        Text label2 = GlyphsDude.createIcon(MaterialIcon.LABEL_ALT, "4em");
        Text label3 = GlyphsDude.createIcon(MaterialIcon.LABEL_ALT_OUTLINE, "4em");

        MaterialIconView defaultIcon = new MaterialIconView();
        
        root.getChildren().addAll(star, label1, label2,label3,defaultIcon);

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
