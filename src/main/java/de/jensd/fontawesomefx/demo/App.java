package de.jensd.fontawesomefx.demo;

import de.jensd.fontawesomefx.AwesomeFactory;
import de.jensd.fontawesomefx.AwesomeIcons;
import de.jensd.javafx.dudes.CircleDude;
import de.jensd.javafx.dudes.StyleDude;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
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
                .createIconButton(AwesomeIcons.ICON_REFRESH, "Reload Dummy");
        Button button2 = AwesomeFactory
                .createIconButton(AwesomeIcons.ICON_REFRESH, 256);
        button2.setTranslateY(150.0);
        button2.setTranslateX(100.0);

        ToolBar toolBarHorizontal = new ToolBar();
        toolBarHorizontal.getItems()
                .addAll(icons1);
        toolBarHorizontal.getItems()
                .addAll(button1);
        toolBarHorizontal.setTranslateY(20.0);

        ToolBar toolBarVertical = new ToolBar();
        toolBarVertical.setOrientation(Orientation.VERTICAL);
        toolBarVertical.getItems()
                .addAll(icons2);
        toolBarVertical.setTranslateY(80.0);



        MenuButton styleChooser = new MenuButton("Choose Style");
        styleChooser
                .setEffect(new DropShadow(BlurType.GAUSSIAN, Color.YELLOWGREEN, 5, 1.0, 0, 0));

        AnchorPane.setTopAnchor(styleChooser, Double.MIN_VALUE);
        AnchorPane.setRightAnchor(styleChooser, Double.MIN_VALUE);



        root.getChildren()
                .addAll(button2, toolBarHorizontal, toolBarVertical, styleChooser);

        Scene scene = new Scene(root, 500, 500);
        scene.getStylesheets()
                .addAll("/styles/icons.css");

        MenuItem stylePlain = StyleDude
                .createMenuItem("Plain", scene, "/styles/icons.css");
        MenuItem styleDark = StyleDude
                .createMenuItem("Dark", scene, "/styles/icons_dark.css");
        MenuItem styleLight = StyleDude
                .createMenuItem("Light", scene, "/styles/icons_light.css");
        styleChooser.getItems()
                .clear();
        styleChooser.getItems()
                .addAll(stylePlain, styleLight, styleDark);


        primaryStage.setScene(scene);
        primaryStage.setTitle("FontAwesome for JavaFX DEMO");
        primaryStage.show();




    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
