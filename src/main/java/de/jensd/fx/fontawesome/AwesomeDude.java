package de.jensd.fx.fontawesome;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.text.Font;

/**
 *
 * @author Jens Deters
 */
public class AwesomeDude {

    public final static String FONT_AWESOME_TTF_PATH = "/font/fontawesome-webfont.ttf";
    public final static double DEFAULT_FONT_SIZE = 16.0;
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
                Font.loadFont(AwesomeDude.class.getResource(FONT_AWESOME_TTF_PATH).toExternalForm(), DEFAULT_FONT_SIZE);

    }

    public Font getFontAwesome() {
        return fontAwesome;
    }

    public Label createIconLabel(AwesomeIcon icon, double iconSize) {
        Label label = new Label(icon.toString());
        label.getStyleClass().add("awesome");
        label.setStyle("-fx-font-family: FontAwesome; -fx-font-size: " + iconSize + "px;");
        return label;
    }

    public Button createIconButton(AwesomeIcon icon) {
        return createIconButton(icon, "", DEFAULT_FONT_SIZE);
    }

    public Button createIconButton(AwesomeIcon icon, String text) {
        return createIconButton(icon, text, DEFAULT_FONT_SIZE);
    }

    public Button createIconButton(AwesomeIcon icon, double iconSize) {
        return createIconButton(icon, "", iconSize);
    }

    public Button createIconButton(AwesomeIcon icon, String text, double iconSize) {
        Label label = createIconLabel(icon);
        Button button = new Button(text);
        button.setGraphic(label);
        return button;
    }

    public Label createIconLabel(AwesomeIcon icon) {
        return createIconLabel(icon, 16);
    }

}
