package de.jensd.fx.glyphs.control;

import de.jensd.fx.glyphs.GlyphIcon;
import de.jensd.fx.glyphs.control.skin.GlyphCheckBoxSkin;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Skin;

/**
 * @author Jens Deters (jens.deters@codecentric.de)
 */
public class GlyphCheckBox extends CheckBox {

    private ObjectProperty<GlyphIcon> notSelectedIcon;
    private ObjectProperty<GlyphIcon> selectedIcon;

    public GlyphCheckBox() {
        super("");
    }

    public GlyphCheckBox(GlyphIcon notSelectedIcon, GlyphIcon selectedIcon, String text) {
        super(text);
        setNotSelectedIcon(notSelectedIcon);
        setSelectedIcon(selectedIcon);
    }

    @Override
    protected Skin createDefaultSkin() {
        return new GlyphCheckBoxSkin(this);
    }

    public final ObjectProperty<GlyphIcon> notSelectedIconProperty() {
        if (notSelectedIcon == null) {
            notSelectedIcon = new SimpleObjectProperty<>();
        }
        return notSelectedIcon;
    }

    public final GlyphIcon getNotSelectedIcon() {
        return notSelectedIconProperty().get();
    }

    public final void setNotSelectedIcon(GlyphIcon icon) {
        notSelectedIconProperty().set(icon);
    }

    public final ObjectProperty<GlyphIcon> selectedIconProperty() {
        if (selectedIcon == null) {
            selectedIcon = new SimpleObjectProperty<>();
        }
        return selectedIcon;
    }

    public final GlyphIcon getSelectedIcon() {
        return selectedIconProperty().get();
    }

    public final void setSelectedIcon(GlyphIcon icon) {
        selectedIconProperty().set(icon);
    }
}
