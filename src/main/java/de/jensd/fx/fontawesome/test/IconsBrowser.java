/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensd.fx.fontawesome.test;

import de.jensd.fx.fontawesome.AwesomeDude;
import de.jensd.fx.fontawesome.AwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author jdeters
 */
public class IconsBrowser extends VBox {

    @FXML
    private ResourceBundle resources;

    @FXML
    private FlowPane iconsBox;

    @FXML
    private HBox headerBox;
    @FXML
    private ScrollPane iconsScrollPane;

    public IconsBrowser() {
        init();
    }

    private void init() {
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n/messages");
            URL fxmlURL = getClass().getResource("/fxml/iconsbrowser.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, resourceBundle);
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(IconsBrowser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void initialize() {

        AwesomeIconNameComparator iconNameComparator = new AwesomeIconNameComparator();
        List list = Stream.of(AwesomeIcon.values()).sorted(iconNameComparator).map(i -> createIconButton(i, i.name())).collect(Collectors.toList());
        iconsBox.getChildren().addAll(list);
        iconsBox.prefWidthProperty().bind(iconsScrollPane.widthProperty().subtract(20.0));
    }

    private static Button createIconButton(final AwesomeIcon icon, final String text) {
        Tooltip tooltip = new Tooltip(String.format("%s: %s", icon.name(), icon.toUnicode()));
        Button b = AwesomeDude.createIconButton(icon, text, "2em", "0.8em", ContentDisplay.TOP);
        b.setTooltip(tooltip);
        b.setPrefWidth(180.0);
        b.setOnAction((ActionEvent t) -> {
            Clipboard clipboard = Clipboard.getSystemClipboard();
            final ClipboardContent content = new ClipboardContent();
            content.putString(icon.name());
            clipboard.setContent(content);
        });
        return b;
    }
}
