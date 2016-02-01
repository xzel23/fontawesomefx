package de.jensd.fx.glyphs.control.skin;

import com.sun.javafx.scene.control.skin.CheckBoxSkin;
import de.jensd.fx.glyphs.GlyphIcon;
import de.jensd.fx.glyphs.control.GlyphCheckBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.SetChangeListener;
import javafx.css.PseudoClass;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Jens Deters (jens.deters@codecentric.de)
 */
public class GlyphCheckBoxSkin extends CheckBoxSkin {

    private final StackPane box;

    public GlyphCheckBoxSkin(GlyphCheckBox checkbox) {
        super(checkbox);
        box = (StackPane) getChildren().get(getChildren().size() - 1);
        box.getStyleClass().clear();
        box.getChildren().addAll(checkbox.getNotSelectedIcon());
        checkbox.armedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            handleState();
        });
        checkbox.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            handleState();
        });
        handleState();
    }

    private void handleState(){
        if (getSkinnable().isSelected()) {
            box.getChildren().setAll(((GlyphCheckBox)getSkinnable()).getSelectedIcon());
        } else {
            box.getChildren().setAll(((GlyphCheckBox)getSkinnable()).getNotSelectedIcon());
        }

    }
}
