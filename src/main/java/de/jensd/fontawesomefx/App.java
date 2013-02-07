package de.jensd.fontawesomefx;

import de.jensd.fontawesomefx.utils.AwesomeFactory;
import de.jensd.fontawesomefx.utils.AwesomeIcons;
import de.jensd.fontawesomefx.utils.LayoutUtils;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
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

        ObservableList<Label> icons1 = FXCollections
                .observableArrayList();

        icons1.add(AwesomeFactory
                .createIconLabel(AwesomeIcons.ICON_PICTURE, 32));
        icons1.add(AwesomeFactory
                .createIconLabel(AwesomeIcons.ICON_TAGS, 32));
        icons1.add(AwesomeFactory
                .createIconLabel(AwesomeIcons.ICON_TASKS, 32));
        icons1.add(AwesomeFactory
                .createIconLabel(AwesomeIcons.ICON_THUMBS_UP, 32));
        icons1.add(AwesomeFactory
                .createIconLabel(AwesomeIcons.ICON_THUMBS_DOWN, 32));

        ObservableList<Label> icons2 = FXCollections
                .observableArrayList();

        icons2.add(AwesomeFactory
                .createIconLabel(AwesomeIcons.ICON_PICTURE, 32));
        icons2.add(AwesomeFactory
                .createIconLabel(AwesomeIcons.ICON_TAGS, 32));
        icons2.add(AwesomeFactory
                .createIconLabel(AwesomeIcons.ICON_TASKS, 32));
        icons2.add(AwesomeFactory
                .createIconLabel(AwesomeIcons.ICON_THUMBS_UP, 32));
        icons2.add(AwesomeFactory
                .createIconLabel(AwesomeIcons.ICON_THUMBS_DOWN, 32));


        Button button1 = AwesomeFactory
                .createIconButton(AwesomeIcons.ICON_REFRESH, "Reload");
        Button button2 = AwesomeFactory
                .createIconButton(AwesomeIcons.ICON_REFRESH, 24);
        button2.setTranslateX(100.0);

        ToolBar toolBarHorizontal = new ToolBar();
        toolBarHorizontal.getItems()
                .addAll(icons1);
        toolBarHorizontal.setTranslateY(40.0);

        ToolBar toolBarVertical = new ToolBar();
        toolBarVertical.setOrientation(Orientation.VERTICAL);
        toolBarVertical.getItems()
                .addAll(icons2);
        toolBarVertical.setTranslateY(90.0);

        root
                .setStyle("-fx-background-color: linear-gradient(to bottom, derive(white,-50%) 10%, derive(white,-80%) 80%);");
        root.getChildren()
                .addAll(button1, button2, toolBarHorizontal, toolBarVertical);

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
