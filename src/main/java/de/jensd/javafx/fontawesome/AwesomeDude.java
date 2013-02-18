package de.jensd.javafx.fontawesome;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;

/**
 *
 * @author Jens Deters
 * @version 1.0
 */
public class AwesomeDude
{

    public static Button createIconButton(AwesomeIcons icon)
    {
        return createIconButton(icon, "", 16);
    }

    public static Button createIconButton(AwesomeIcons icon, String text)
    {
        return createIconButton(icon, text, 16);
    }

    public static Button createIconButton(AwesomeIcons icon, int iconSize)
    {
        return createIconButton(icon, "", iconSize);
    }

    public static Button createIconButton(AwesomeIcons icon, String text, int iconSize)
    {
        Label label = createIconLabel(icon);
        label.setStyle("-fx-font-size: " + iconSize + "px;");
        return ButtonBuilder.create()
                .text(text)
                .graphic(label)
                .build();
    }

    public static Label createIconLabel(AwesomeIcons icon, String style)
    {
        return LabelBuilder.create()
                .text(icon.toString())
                .style(style)
                .build();
    }

    public static Label createIconLabel(AwesomeIcons icon)
    {
        return createIconLabel(icon, 16);
    }

    public static Label createIconLabel(AwesomeIcons icon, int iconSize)
    {
        return LabelBuilder.create()
                .text(icon.toString())
                .styleClass("icons")
                .style("-fx-font-size: " + iconSize + "px;")
                .build();
    }
}
