package de.jensd.fx.glyphs.materialstackicons;

import de.jensd.fx.glyphs.GlyphStackIcon;
import de.jensd.fx.glyphs.materialicons.MaterialIcon;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;

public class MaterialStackIconView extends GlyphStackIcon<MaterialStackIcons, MaterialIconView, MaterialIcon> {

    public MaterialStackIconView() {
    }

    public MaterialStackIconView(MaterialStackIcons materialStackIcons) {
        super(materialStackIcons);
    }

    public MaterialStackIconView(MaterialStackIcons materialStackIcons, double size) {
        super(materialStackIcons, size);
    }

    @Override
    public MaterialStackIcons getDefaultGlyph() {
        return MaterialStackIcons.FLASH_NOT_ALLOWED;
    }

    @Override
    protected MaterialIconView getGlyph(MaterialIcon glyphIcons, double size) {
        MaterialIconView materialIconView = new MaterialIconView(MaterialIcon.class.cast(glyphIcons));
        materialIconView.setGlyphSize(size);
        return materialIconView;
    }

}
