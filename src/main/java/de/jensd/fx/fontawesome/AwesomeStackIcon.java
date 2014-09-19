/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensd.fx.fontawesome;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/**
 *
 * @author jdeters
 */
public class AwesomeStackIcon extends StackPane {

    private Label baseLabel;
    private Label topLabel;

    private AwesomeStackIcon() {
        init();
    }

    private void init() {
        baseLabel = new Label(AwesomeIcon.SQUARE.toString());
        baseLabel.getStyleClass().add("stack-base");
        topLabel = new Label(AwesomeIcon.STAR.toString());
        topLabel.getStyleClass().add("stack-top");
        getChildren().addAll(baseLabel, topLabel);
    }
    
    public static AwesomeStackIcon create(){
        return new AwesomeStackIcon();
    }
    

    public AwesomeStackIcon baseIcon(AwesomeIcon icon) {
        baseLabel.setText(icon.toString());
        return this;
    }

    public AwesomeStackIcon baseIconSize(String baseIconSize) {
        baseLabel.setStyle("-fx-font-size: " + baseIconSize + ";");
        return this;
    }

    public AwesomeStackIcon baseIconStyle(String baseIconStyle) {
        baseLabel.setStyle(baseIconStyle);
        return this;
    }

    public AwesomeStackIcon baseIconStyleClass(String baseIconStyleClass) {
        baseLabel.getStyleClass().add(baseIconStyleClass);
        return this;
    }

    public AwesomeStackIcon topIcon(AwesomeIcon icon) {
        topLabel.setText(icon.toString());
        return this;
    }

    public AwesomeStackIcon topIconSize(String topIconSize) {
        topLabel.setStyle("-fx-font-size: " + topIconSize + ";");
        return this;
    }

    public AwesomeStackIcon topIconStyle(String topIconStyle) {
        topLabel.setStyle(topIconStyle);
        return this;
    }

    public AwesomeStackIcon topIconStyleClass(String topIconStyleClass) {
        topLabel.getStyleClass().add(topIconStyleClass);
        return this;
    }
}
