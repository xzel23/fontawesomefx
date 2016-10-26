package de.jensd.fx.glyphs.fontawesome.demo;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FontTestFX extends Application {

    private void loadFont(String fileName) {
        try {
            FileInputStream fontFile = new FileInputStream(new File(fileName));
            Font.loadFont(fontFile, 16);
        } catch (FileNotFoundException ex) {
        }
    }

    @Override
    public void start(Stage primaryStage) {
        String fileName = FontAwesomeIconView.TTF_PATH;
        loadFont(fileName);
        loadFont(fileName);
        Platform.exit();
    }

    public static void main(String[] args) {
        launch(args);
    }
}