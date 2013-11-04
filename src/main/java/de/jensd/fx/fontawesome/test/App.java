package de.jensd.fx.fontawesome.test;

import de.jensd.fx.fontawesome.AwesomeDude;
import de.jensd.fx.fontawesome.AwesomeIcon;
import de.jensd.fx.fontawesome.AwesomeStyle;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox root = new VBox();

        Label githubLabel = AwesomeDude.createIconLabel(AwesomeIcon.GITHUB);
        Label ambulanceLabel = AwesomeDude.createIconLabel(AwesomeIcon.AMBULANCE, "60.0");
        Button starButton = AwesomeDude.createIconButton(AwesomeIcon.STAR, "Nice!", "48.0", "20.0", ContentDisplay.TOP);
        Button cloudButton = AwesomeDude.createIconButton(AwesomeIcon.CLOUD, "Download");
        ToggleButton toggleButton = AwesomeDude.createIconToggleButton(AwesomeIcon.LOCK, "Lock", "60.0", ContentDisplay.TOP);

        root.getChildren().addAll(createMenubar(), githubLabel, ambulanceLabel, starButton, cloudButton, toggleButton);

        Scene scene = new Scene(root, 500, 500);
        //scene.getStylesheets().addAll(AwesomeStyle.BLUE.getStylePath());



        primaryStage.setScene(scene);
        primaryStage.setTitle("FontAwesomeFX demo");
        primaryStage.show();

    }

    private MenuBar createMenubar() {

        MenuBar menuBar = new MenuBar();

        MenuItem openItem = new MenuItem("Open");
        AwesomeDude.setIcon(openItem, AwesomeIcon.FILE);
        MenuItem saveItem = new MenuItem("Save");
        AwesomeDude.setIcon(saveItem, AwesomeIcon.DOWNLOAD);
        MenuItem saveAsItem = new MenuItem("Save As...");
        AwesomeDude.setIcon(saveAsItem, AwesomeIcon.DOWNLOAD);
        MenuItem exitItem = new MenuItem("Exit");
        AwesomeDude.setIcon(exitItem, AwesomeIcon.SIGN_OUT);

        Menu menuFile = new Menu("File");
        menuFile.getItems().add(openItem);
        menuFile.getItems().add(saveItem);
        menuFile.getItems().add(saveAsItem);
        menuFile.getItems().add(new SeparatorMenuItem());
        menuFile.getItems().add(exitItem);

        Menu menuEdit = new Menu("Edit");
        Menu menuView = new Menu("View");

        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);

        return menuBar;
    }

    public static void main(String[] args) {
        launch(args);

        System.out.println(AwesomeStyle.BLUE);

    }
}
