package de.jensd.javafx.dudes;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;

/**
 *
 * @author Jens Deters
 * @since 15.02.2013
 * @version 1.0
 */
public class StyleDude
{

    private static final Logger LOGGER = Logger.
            getLogger(StyleDude.class.getName());

    public static MenuItem createMenuItem(String label, final Scene scene, String... cssFileNames)
    {
        MenuItem menuItem = new MenuItem(label);
        ObservableList<String> cssStyles = FXCollections.observableArrayList();
        for (String cssFileName : cssFileNames)
        {
            cssStyles.addAll(loadSkin(cssFileName));
        }
        menuItem.setOnAction(createSkinFormAction(cssStyles, scene));
        return menuItem;
    }

    public static ObservableList<String> loadSkin(String cssFileName)
    {
        LOGGER.log(Level.INFO, "Attempt to load css: {0}", cssFileName);
        ObservableList<String> cssStyles = FXCollections.observableArrayList();
        cssStyles.addAll(StyleDude.class.getResource(cssFileName)
                .toExternalForm());
        return cssStyles;
    }

    public static EventHandler<ActionEvent> createSkinFormAction(final ObservableList<String> cssStyle, final Scene scene)
    {
        return new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent t)
            {
                scene.getStylesheets()
                        .addAll(cssStyle);
            }
        };
    }
}
