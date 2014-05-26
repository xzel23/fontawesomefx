/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.jensd.fx.fontawesome.test;

import de.jensd.fx.fontawesome.AwesomeDude;
import de.jensd.fx.fontawesome.AwesomeIcon;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author jdeters
 */
public class IconOverview extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        FlowPane iconsPane = new FlowPane();
        List list = Stream.of(AwesomeIcon.values()).map(i->AwesomeDude.createIconButton(i, i.name(), "2em", "0.8em", ContentDisplay.TOP )).collect(Collectors.toList());
        iconsPane.getChildren().addAll(list);
        iconsPane.setVgap(4);
        iconsPane.setHgap(4);
        Scene scene = new Scene(new ScrollPane(iconsPane), 800, 600);
        iconsPane.prefWidthProperty().bind(scene.widthProperty());
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
