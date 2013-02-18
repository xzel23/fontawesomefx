package de.jensd.javafx.dudes;

import java.util.List;
import javafx.scene.Node;

/**
 *
 * @author Jens Deters
 * @since 15.02.2013
 * @version 1.0
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
