/**
 * Copyright (c) 2013,2014 Jens Deters http://www.jensd.de
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
package de.jensd.fx.fontawesome.test;

import de.jensd.fx.fontawesome.AwesomeDude;
import de.jensd.fx.fontawesome.AwesomeIcon;
import de.jensd.fx.fontawesome.AwesomeIconsStack;
import de.jensd.fx.fontawesome.AwesomeStyle;
import de.jensd.fx.fontawesome.Icon;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Jens Deters
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox root = new VBox();
        root.setSpacing(10.0);

        Label githubLabel = AwesomeDude.createIconLabel(AwesomeIcon.GITHUB);
        Label ambulanceLabel = AwesomeDude.createIconLabel(AwesomeIcon.PLUS_SQUARE_ALT, "60.0");
        Button starButton = AwesomeDude.createIconButton(AwesomeIcon.STAR, "Nice!", "48.0", "20.0", ContentDisplay.TOP);
        Button cloudButton = AwesomeDude.createIconButton(AwesomeIcon.CLOUD, "Download");
        ToggleButton toggleButton = AwesomeDude.createIconToggleButton(AwesomeIcon.LOCK, "Lock", "60.0", ContentDisplay.TOP);

        Region stackedIcon1 = AwesomeIconsStack.create().add(Icon.create());

        Region stackedIcon2 = AwesomeIconsStack.create()
                .add(Icon.create()
                        .icon(AwesomeIcon.SQUARE)
                        .size("3em")
                        .styleClass("stack-base"))
                .add(Icon.create()
                        .icon(AwesomeIcon.STAR)
                        .size("2em")
                        .styleClass("stack-top")
                );

        Region stackedIcon3 = AwesomeIconsStack.create()
                .add(Icon.create()
                        .icon(AwesomeIcon.SQUARE)
                        .style("-fx-font-size: 4em; -fx-text-fill: yellowgreen;"))
                .add(Icon.create()
                        .icon(AwesomeIcon.APPLE)
                        .style("-fx-font-size: 3em; -fx-text-fill: white;")
                );

        Region stackedIcon4 = AwesomeIconsStack.create()
                .add(Icon.create()
                        .icon(AwesomeIcon.SQUARE)
                        .style("-fx-font-size: 4em; -fx-text-fill: yellowgreen;"))
                .add(Icon.create()
                        .icon(AwesomeIcon.APPLE)
                        .style("-fx-font-size: 3em; -fx-text-fill: black;")
                );

        Region stackedIcon5 = AwesomeIconsStack.create()
                .add(Icon.create()
                        .icon(AwesomeIcon.BUG)
                        .style("-fx-font-size: 2em; -fx-text-fill: black;"))
                .add(Icon.create()
                        .icon(AwesomeIcon.BAN)
                        .style("-fx-font-size: 4em; -fx-text-fill: red; -fx-opacity: 0.5;")
                );

        Region stackedIcon6 = AwesomeIconsStack.create()
                .add(Icon.create()
                        .icon(AwesomeIcon.CIRCLE)
                        .style("-fx-font-size: 8em; -fx-text-fill: linear-gradient(#70b4e5 0%, #247cbc 70%, #2c85c1 85%);"))
                .add(Icon.create()
                        .icon(AwesomeIcon.TWITTER)
                        .style("-fx-font-size: 4em; -fx-text-fill: white;")
                );

        Region stackedIcon7 = AwesomeIconsStack.create()
                .add(Icon.create()
                        .icon(AwesomeIcon.CIRCLE)
                        .style("-fx-font-size: 12em; -fx-text-fill: linear-gradient(#70b4e5 0%, #247cbc 70%, #2c85c1 85%);"))
                .add(Icon.create()
                        .icon(AwesomeIcon.BITBUCKET)
                        .style("-fx-font-size: 6em; "
                                + "-fx-text-fill: linear-gradient(#ffffff, #d2d2d2); "
                                + "-fx-effect: dropshadow( one-pass-box , rgba(0,0,0,0.8) , 4 , 0.0 , 1 , 1 );")
                );

        HBox stackIconBox = new HBox();
        stackIconBox.setSpacing(5.0);
        stackIconBox.getChildren().addAll(stackedIcon1, stackedIcon2, stackedIcon3, stackedIcon4, stackedIcon5, stackedIcon6, stackedIcon7);

        Region iconStack1 = AwesomeIconsStack.create()
                .add(Icon.create()
                        .icon(AwesomeIcon.CIRCLE)
                        .style("-fx-font-size: 12em; -fx-text-fill: linear-gradient(#70b4e5 0%, #247cbc 70%, #2c85c1 85%);"))
                .add(Icon.create()
                        .icon(AwesomeIcon.BITBUCKET)
                        .style("-fx-font-size: 6em; "
                                + "-fx-text-fill: linear-gradient(#ffffff 0%, #d2d2d2); "
                                + "-fx-effect: dropshadow( one-pass-box , rgba(0,0,0,0.8) , 4 , 0.0 , 1 , 1 );"))
                .add(new Icon(AwesomeIcon.BAN, null, "-fx-font-size: 12em; -fx-text-fill: red; -fx-opacity: 0.5;", null));

        HBox stackIconBox2 = new HBox();
        stackIconBox2.setSpacing(5.0);
        stackIconBox2.getChildren().addAll(iconStack1);

        root.getChildren().addAll(createMenubar(), githubLabel, ambulanceLabel, starButton, cloudButton, toggleButton, stackIconBox, stackIconBox2);

        Scene scene = new Scene(root, 500, 800);
        scene.getStylesheets().addAll(AwesomeStyle.PLAIN.getStylePath());

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
        System.setProperty("prism.lcdtext", "fasle");
        launch(args);
    }
}
