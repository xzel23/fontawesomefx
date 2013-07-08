package de.jensd.javafx.fontawesome;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.text.Font;

/**
 *
 * @author Jens Deters
 * @since 15.02.2013
 * @version 1.0
 */
public class AwesomeDude {

    public static final String FONT_AWESOME_TTF = "/META-INF/resources/webjars/font-awesome/3.2.1/font/fontawesome-webfont.ttf";
    public static final int DEFAULT_FONT_SIZE = 16;
    public static final Font FONT_AWESOME =
            Font.loadFont(AwesomeDude.class.getResource(FONT_AWESOME_TTF).toExternalForm(), DEFAULT_FONT_SIZE);

    public static Button createIconButton(AwesomeIcons icon) {
        return createIconButton(icon, "", DEFAULT_FONT_SIZE);
    }

    public static Button createIconButton(AwesomeIcons icon, String text) {
        return createIconButton(icon, text, DEFAULT_FONT_SIZE);
    }

    public static Button createIconButton(AwesomeIcons icon, int iconSize) {
        return createIconButton(icon, "", iconSize);
    }

    public static Button createIconButton(AwesomeIcons icon, String text, int iconSize) {
        Label label = createIconLabel(icon);
        label.setStyle("-fx-font-size: " + iconSize + "px;");
        return ButtonBuilder.create()
                .text(text)
                .graphic(label)
                .build();
    }

    public static Label createIconLabel(AwesomeIcons icon, String style) {
        return LabelBuilder.create()
                .text(icon.toString())
                .font(FONT_AWESOME)
                .style(style)
                .build();
    }

    public static Label createIconLabel(AwesomeIcons icon) {
        return createIconLabel(icon, 16);
    }

    public static Label createIconLabel(AwesomeIcons icon, int iconSize) {
        return LabelBuilder.create()
                .text(icon.toString())
                .font(FONT_AWESOME)
                .styleClass("icons")
                .style("-fx-font-size: " + iconSize + "px;")
                .build();
    }
}
