package de.jensd.fontawesomefx;

import de.jensd.fontawesomefx.utils.IconFactory;
import de.jensd.fontawesomefx.utils.Icons;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        AnchorPane root = new AnchorPane();

        Font.loadFont(App.class.getResource("/fonts/awesome.ttf")
                .toExternalForm(), 12);

        Label icon1 = IconFactory
                .createIconLabel(Icons.ICON_AMBULANCE, "icon-white");
        icon1.setTranslateX(250);
        icon1.setTranslateY(250);

        Label icon2 = IconFactory
                .createIconLabel(Icons.ICON_AMBULANCE, "icon-dark");
        icon2.setTranslateX(250);
        icon2.setTranslateY(180);

        root
                .setStyle("-fx-background-color: linear-gradient(to bottom, derive(white,20%) 10%, derive(white,-20%) 80%);");
        root.getChildren()
                .addAll(icon1, icon2);

        Scene scene = new Scene(root, 500, 500);
        scene.getStylesheets()
                .addAll("/styles/icons.css");

        primaryStage.setScene(scene);
        primaryStage.setTitle("FontAwesome for JavaFX DEMO");
        primaryStage.show();




    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
