/**
 * Copyright (c) 2015 Jens Deters http://www.jensd.de
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
package de.jensd.fx.glyphs.testapps;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import de.jensd.fx.glyphs.materialicons.MaterialIcon;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Jens Deters
 */
public class AppMaterialIconsVerification extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox root = new HBox();
        root.setSpacing(10.0);

        Button materialButton = new Button("MaterialIcon");
        Button materialDesignButton = new Button("MaterialDesignIcon");

        GlyphsDude.setIcon(materialButton, MaterialDesignIcon.ACCOUNT_CIRCLE,"1.2em");
        GlyphsDude.setIcon(materialDesignButton, MaterialIcon.ACCOUNT_CIRCLE, "1.2em");

        root.getChildren().addAll(materialButton, materialDesignButton);

        Scene scene = new Scene(root, 500, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Material demo");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
