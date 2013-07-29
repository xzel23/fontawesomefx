package de.jensd.fx.fontawesome;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.text.Font;

/**
 *
 * @author Jens Deters
 */
public class AwesomeDude {
    
    public final static String FONT_AWESOME_TTF_PATH = "/font/fontawesome-webfont.ttf";
    public final static String DEFAULT_ICON_SIZE = "16.0";
    public final static String DEFAULT_FONT_SIZE = "12.0";
    
    static {
        Font.loadFont(AwesomeDude.class.getResource(FONT_AWESOME_TTF_PATH).toExternalForm(), 10.0);
    }
    
    public static Label createIconLabel(AwesomeIcon icon, String iconSize) {
        Label label = new Label(icon.toString());
        label.getStyleClass().add("awesome");
        label.setStyle("-fx-font-family: FontAwesome; -fx-font-size: " + iconSize + ";");
        return label;
    }
    
    public static Button createIconButton(AwesomeIcon icon) {
        return createIconButton(icon, "");
    }
    
    public static Button createIconButton(AwesomeIcon icon, String text) {
        Label label = createIconLabel(icon, DEFAULT_ICON_SIZE);
        Button button = new Button(text);
        button.setGraphic(label);
        return button;
    }
    
    public static Button createIconButton(AwesomeIcon icon, String text, String iconSize, String fontSize, ContentDisplay contentDisplay) {
        Label label = createIconLabel(icon, iconSize);
        Button button = new Button(text);
        button.setStyle("-fx-font-size: " + fontSize);
        button.setGraphic(label);
        button.setContentDisplay(contentDisplay);
        return button;
    }
    
    public static ToggleButton createIconToggleButton(AwesomeIcon icon, String text, String iconSize, ContentDisplay contentDisplay) {
        return createIconToggleButton(icon, text, iconSize, DEFAULT_FONT_SIZE, contentDisplay);
    }
    
    public static ToggleButton createIconToggleButton(AwesomeIcon icon, String text, String iconSize, String fontSize, ContentDisplay contentDisplay) {
        Label label = createIconLabel(icon, iconSize);
        ToggleButton button = new ToggleButton(text);
        button.setStyle("-fx-font-size: " + fontSize);
        button.setGraphic(label);
        button.setContentDisplay(contentDisplay);
        return button;
    }
    
    public static Label createIconLabel(AwesomeIcon icon) {
        return createIconLabel(icon, DEFAULT_ICON_SIZE);
    }
    
    public static void setIcon(Label label, AwesomeIcon icon) {
        setIcon(label, icon, DEFAULT_ICON_SIZE);
    }
    
    public static void setIcon(Label label, AwesomeIcon icon, String iconSize) {
        label.setText(icon.toString());
        label.getStyleClass().add("awesome");
        label.setStyle("-fx-font-family: FontAwesome; -fx-font-size: " + iconSize + ";");
    }
    
    public static void setIcon(Button button, AwesomeIcon icon, String fontSize, String iconSize, ContentDisplay contentDisplay) {
        Label label = createIconLabel(icon, iconSize);
        button.setStyle("-fx-font-size: " + fontSize);
        button.setGraphic(label);
        button.setContentDisplay(contentDisplay);
    }
    
    public static void setIcon(ToggleButton button, AwesomeIcon icon, String fontSize, String iconSize, ContentDisplay contentDisplay) {
        setIcon(button, icon, fontSize, iconSize, contentDisplay);
    }
}
