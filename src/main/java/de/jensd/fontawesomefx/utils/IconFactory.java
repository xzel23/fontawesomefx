/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensd.fontawesomefx.utils;

import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;

/**
 *
 * @author Jens Deters
 */
public class IconFactory
{

    public static Label createIconLabel(String iconName, String... styleClasses)
    {
        return LabelBuilder.create()
                .text(iconName)
                .styleClass(styleClasses)
                .build();
    }
}
