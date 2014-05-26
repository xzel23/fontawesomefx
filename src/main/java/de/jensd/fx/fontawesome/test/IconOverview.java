/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensd.fx.fontawesome.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jdeters
 */
public class IconOverview extends Application {

    @Override
    public void start(Stage primaryStage) {
        IconsBrowser iconsBrowser = new IconsBrowser();
        Scene scene = new Scene(iconsBrowser, 800, 600);
        primaryStage.setTitle("FontAwesomeFX Icons-Overview");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
