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
    public final static String DEFAULT_FONT_SIZE = "1.2em";
    public Font fontAwesome;
    private static AwesomeDude me;

    private AwesomeDude() {
    }

    public static AwesomeDude get() {
        if (me == null) {
            me = new AwesomeDude();
        }
        return me;
    }

    public void loadFontAwesome() {
        fontAwesome =
                Font.loadFont(AwesomeDude.class.getResource(FONT_AWESOME_TTF_PATH).toExternalForm(), 10.0);
    }

    public Font getFontAwesome() {
        return fontAwesome;
    }

    public Label createIconLabel(AwesomeIcon icon, String iconSize) {
        Label label = new Label(icon.toString());
        label.getStyleClass().add("awesome");
        label.setStyle("-fx-font-family: FontAwesome; -fx-font-size: " + iconSize + ";");
        return label;
    }

    public Button createIconButton(AwesomeIcon icon) {
        return createIconButton(icon, "");
    }

    public Button createIconButton(AwesomeIcon icon, String text) {
        return createIconButton(icon, text);
    }

    public Button createIconButton(AwesomeIcon icon, String text, String iconSize, String fontSize, ContentDisplay contentDisplay) {
        Label label = createIconLabel(icon, iconSize);
        Button button = new Button(text);
        button.setStyle("-fx-fone-size: 0.8em;");
        button.setGraphic(label);
        button.setContentDisplay(contentDisplay);
        return button;
    }

    public ToggleButton createIconToggleButton(AwesomeIcon icon, String text, String iconSize, ContentDisplay contentDisplay) {
        Label label = createIconLabel(icon, iconSize);
        ToggleButton button = new ToggleButton(text);
        button.setGraphic(label);
        button.setContentDisplay(contentDisplay);
        return button;
    }

    public Label createIconLabel(AwesomeIcon icon) {
        return createIconLabel(icon, DEFAULT_FONT_SIZE);
    }
}
