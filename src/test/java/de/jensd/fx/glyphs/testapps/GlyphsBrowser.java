/**
 * Copyright (c) 2015 Jens Deters http://www.jensd.de
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 */
package de.jensd.fx.glyphs.testapps;

import de.jensd.fx.glyphs.GlyphIcons;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialicons.MaterialIcon;
import de.jensd.fx.glyphs.octicons.OctIcon;
import de.jensd.fx.glyphs.weathericons.WeatherIcon;
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
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author Jens Deters
 */
public class GlyphsBrowser extends VBox {

    @FXML
    private FlowPane iconsBox;

    @FXML
    private Label numberOfIconsLabel;
    @FXML
    private ScrollPane iconsScrollPane;

    private List<Button> listAwesome;
    private List<Button> listWeather;
    private List<Button> listMaterial;
    private List<Button> listMaterialDesign;
    private List<Button> listOcticons;

    public GlyphsBrowser() {
        init();
    }

    private void init() {
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n/messages");
            URL fxmlURL = getClass().getResource("/fxml/glyphs_browser.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, resourceBundle);
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(GlyphsBrowser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void initialize() {
        final AwesomeIconNameComparator awesomeIconNameComparator = new AwesomeIconNameComparator();
        listAwesome = Stream.of(FontAwesomeIcon.values()).sorted(awesomeIconNameComparator).map(i -> createIconButton(i, i.name())).collect(Collectors.toList());
        
        final WeatherIconNameComparator weatherIconNameComparator = new WeatherIconNameComparator();
        listWeather = Stream.of(WeatherIcon.values()).sorted(weatherIconNameComparator).map(i -> createIconButton(i, i.name())).collect(Collectors.toList());
        
        final MaterialDesignIconNameComparator materialDesignIconNameComparator = new MaterialDesignIconNameComparator();
        listMaterialDesign = Stream.of(MaterialDesignIcon.values()).sorted(materialDesignIconNameComparator).map(i -> createIconButton(i, i.name())).collect(Collectors.toList());
        
        final MaterialIconNameComparator materialIconNameComparator = new MaterialIconNameComparator();
        listMaterial = Stream.of(MaterialIcon.values()).sorted(materialIconNameComparator).map(i -> createIconButton(i, i.name())).collect(Collectors.toList());
        
        final OctIconNameComparator octIconNameComparator = new OctIconNameComparator();
        listOcticons = Stream.of(OctIcon.values()).sorted(octIconNameComparator).map(i -> createIconButton(i, i.name())).collect(Collectors.toList());
        
        iconsBox.prefWidthProperty().bind(iconsScrollPane.widthProperty().subtract(20.0));
    }

    private void updateBrowser(List iconsList) {
        iconsBox.getChildren().clear();
        iconsBox.getChildren().addAll(iconsList);
        numberOfIconsLabel.setText(iconsList.size() + "");
        iconsScrollPane.setVvalue(0.0);
    }

    @FXML
    public void onShowAwesomeIcons() {
        updateBrowser(listAwesome);
    }

    @FXML
    public void onShowWeatherIcons() {
        updateBrowser(listWeather);
    }

    @FXML
    public void onShowMaterialIcons() {
        updateBrowser(listMaterial);
    }

    @FXML
    public void onShowMaterialDesignIcons() {
        updateBrowser(listMaterialDesign);
    }

    @FXML
    public void onShowOctIcons() {
        updateBrowser(listOcticons);
    }
    
    private static Button createIconButton(GlyphIcons icon, final String text) {
        final Tooltip tooltip = new Tooltip(String.format("%s: %s", icon.name(), icon.unicodeToString()));
        final Text iconText = GlyphsDude.createIcon(icon, "2em");
        final Button b = new Button(text);
        b.setContentDisplay(ContentDisplay.TOP);
        b.setGraphic(iconText);
        b.setTooltip(tooltip);
        b.setPrefWidth(180.0);
        b.setOnAction((ActionEvent t) -> {
            final Clipboard clipboard = Clipboard.getSystemClipboard();
            final ClipboardContent content = new ClipboardContent();
            content.putString(icon.name());
            clipboard.setContent(content);
        });
        return b;
    }
    
}
