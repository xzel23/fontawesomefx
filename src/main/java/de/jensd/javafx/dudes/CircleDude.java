/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensd.javafx.dudes;

import java.util.List;
import javafx.scene.Node;

/**
 *
 * @author Jens Deters
 */
public class CircleDude
{

    public static void layoutInCircle(List<? extends Node> nodes, double centerX, double centerY, double radius)
    {
        double angle = 0;
        double angleStep = 360 / nodes.size();
        for (Node node : nodes)
        {
            node.setLayoutX(150.0 * Math.cos(Math
                    .toRadians(angle)) + centerX);
            node.setLayoutY(150.0 * Math.sin(Math
                    .toRadians(angle)) + centerY);
            angle += angleStep;
        }
    }
}
