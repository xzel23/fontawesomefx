package de.jensd.fx.glyphs.materialstackicons;

import de.jensd.fx.glyphs.GlyphStackIcons;
import de.jensd.fx.glyphs.materialicons.MaterialIcon;

public enum MaterialStackIcons implements GlyphStackIcons<MaterialIcon> {

    FLASH_NOT_ALLOWED(MaterialIcon.BRIGHTNESS_1, MaterialIcon.FLASH_ON, MaterialIcon.BLOCK),
    MUSIC_NOT_ALLOWED(MaterialIcon.BRIGHTNESS_1, MaterialIcon.AUDIOTRACK, MaterialIcon.BLOCK),
    CAR_NOT_ALLOWED(MaterialIcon.BRIGHTNESS_1, MaterialIcon.DIRECTIONS_CAR, MaterialIcon.BLOCK),
    LIGHT(MaterialIcon.CHECK_BOX_OUTLINE_BLANK, MaterialIcon.WB_INCANDESCENT),
    WC(MaterialIcon.BRIGHTNESS_1, MaterialIcon.WC);

    private final MaterialIcon[] materialIcons;

    MaterialStackIcons(MaterialIcon... materialIcons) {
        this.materialIcons = materialIcons;
    }

    @Override
    public MaterialIcon[] getGlyphs() {
        return materialIcons;
    }

}
