package de.jensd.fx.glyphs.materialstackicons.demo;

import de.jensd.fx.glyphs.materialstackicons.MaterialStackIconView;
import de.jensd.fx.glyphs.materialstackicons.MaterialStackIcons;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class StackDemo extends Application {

    private Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        TilePane root = new TilePane();
        root.getChildren().addAll(new MaterialStackIconView(MaterialStackIcons.FLASH_NOT_ALLOWED),
                new MaterialStackIconView(MaterialStackIcons.MUSIC_NOT_ALLOWED),
                new MaterialStackIconView(MaterialStackIcons.CAR_NOT_ALLOWED),
                new MaterialStackIconView(MaterialStackIcons.LIGHT),
                new MaterialStackIconView(MaterialStackIcons.WC));
        scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MaterialStackIcons Demo");
        primaryStage.show();
        scene.getStylesheets().add(StackDemo.class.getResource("materialIcons.css").toExternalForm());
    }
}