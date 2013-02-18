package de.jensd.javafx.fontawesome.app;

import de.jensd.javafx.fontawesome.AwesomeDude;
import de.jensd.javafx.fontawesome.AwesomeIcons;
import de.jensd.javafx.dudes.StyleDude;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
 *
 * @author Jens Deters
 * @since 15.02.2013
 * @version 1.0
 */
public class DemoApp extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        AnchorPane root = new AnchorPane();

        Font.loadFont(DemoApp.class
                .getResource("/META-INF/resources/webjars/font-awesome/3.0.0/font/fontawesome-webfont.ttf")
                .toExternalForm(), 12);

        ObservableList<Label> icons1 = FXCollections
                .observableArrayList();

        icons1.add(AwesomeDude
                .createIconLabel(AwesomeIcons.ICON_ENVELOPE, 32));
        icons1.add(AwesomeDude
                .createIconLabel(AwesomeIcons.ICON_TAGS, 32));
        icons1.add(AwesomeDude
                .createIconLabel(AwesomeIcons.ICON_TASKS, 32));

        Label up = AwesomeDude
                .createIconLabel(AwesomeIcons.ICON_THUMBS_UP, 32);
        up.setDisable(true);
        Label down = AwesomeDude
                .createIconLabel(AwesomeIcons.ICON_THUMBS_DOWN, 32);
        down.setDisable(true);

        icons1.add(up);
        icons1.add(down);

        ObservableList<Label> icons2 = FXCollections
                .observableArrayList();

        icons2.add(AwesomeDude
                .createIconLabel(AwesomeIcons.ICON_PICTURE, 32));

        Label tags = AwesomeDude
                .createIconLabel(AwesomeIcons.ICON_TAGS, 32);
        tags.setDisable(true);
        Label tasks = AwesomeDude
                .createIconLabel(AwesomeIcons.ICON_TASKS, 32);
        tasks.setDisable(true);

        icons2.add(tags);
        icons2.add(tasks);
        icons2.add(AwesomeDude
                .createIconLabel(AwesomeIcons.ICON_THUMBS_UP, 32));
        icons2.add(AwesomeDude
                .createIconLabel(AwesomeIcons.ICON_THUMBS_DOWN, 32));


        Button button1 = AwesomeDude
                .createIconButton(AwesomeIcons.ICON_REFRESH, "Button Dummy");
        Button button2 = AwesomeDude
                .createIconButton(AwesomeIcons.ICON_REFRESH, 256);
        button2.setTranslateY(150.0);
        button2.setTranslateX(100.0);

        MenuButton styleChooser = new MenuButton("Choose Style");
        styleChooser
                .setEffect(new DropShadow(BlurType.GAUSSIAN, Color.YELLOWGREEN, 5, 1.0, 0, 0));

        ToolBar toolBarHorizontal = new ToolBar();
        toolBarHorizontal.getItems()
                .addAll(icons1);
        toolBarHorizontal.getItems()
                .addAll(button1);
        toolBarHorizontal.getItems()
                .addAll(styleChooser);
        AnchorPane.setTopAnchor(toolBarHorizontal, Double.MIN_VALUE);
        AnchorPane.setRightAnchor(toolBarHorizontal, Double.MIN_VALUE);
        AnchorPane.setLeftAnchor(toolBarHorizontal, Double.MIN_VALUE);

        ToolBar toolBarVertical = new ToolBar();
        toolBarVertical.setOrientation(Orientation.VERTICAL);
        toolBarVertical.getItems()
                .addAll(icons2);
        toolBarVertical.setTranslateY(80.0);


        root.getChildren()
                .addAll(button2, toolBarHorizontal, toolBarVertical);

        Scene scene = new Scene(root, 500, 500);
        scene.getStylesheets()
                .addAll("/styles/icons.css");

        MenuItem stylePlain = StyleDude
                .createMenuItem("Plain", scene, "/styles/icons.css");
        MenuItem styleDark = StyleDude
                .createMenuItem("Dark", scene, "/styles/icons_dark.css");
        MenuItem styleLight = StyleDude
                .createMenuItem("Light", scene, "/styles/icons_light.css");
        MenuItem styleBlue = StyleDude
                .createMenuItem("Blue", scene, "/styles/icons_blue.css");
        MenuItem styleRed = StyleDude
                .createMenuItem("Red", scene, "/styles/icons_red.css");
        styleChooser.getItems()
                .clear();
        styleChooser.getItems()
                .addAll(stylePlain, styleLight, styleDark, styleBlue, styleRed);

        primaryStage.setScene(scene);
        primaryStage.setTitle("FontAwesomeFX DEMO");
        primaryStage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
