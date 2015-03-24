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

import de.jensd.fx.glyphs.GlyphsStyle;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Jens Deters
 */
public class CssTestApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox root = new VBox();
        root.setSpacing(10.0);

        FontAwesomeIcon.getClassCssMetaData().forEach(m -> {
            System.out.println(m.toString());
        });

         FontAwesomeIcon styledIcon = new FontAwesomeIcon();
        styledIcon.setStyleClass("styled-icon");
        styledIcon.setSize("16em");
        

        HBox basicIconBox = new HBox();
        basicIconBox.setAlignment(Pos.CENTER);
        basicIconBox.setSpacing(20.0);
        basicIconBox.getChildren().addAll(styledIcon);
        
        root.getChildren().addAll(basicIconBox);

        Scene scene = new Scene(root, 500, 800);
        scene.getStylesheets().addAll(GlyphsStyle.DEFAULT.getStylePath());

        primaryStage.setScene(scene);
        primaryStage.setTitle("FontAwesomeFX demo");
        primaryStage.show();

    }

    public static void main(String[] args) {
        System.setProperty("prism.lcdtext", "false");
        launch(args);
    }
}
