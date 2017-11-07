package de.jensd.fx.glyphs;

public class TestGlyphIcon {



    private class GlyphIconTest extends GlyphIcon{

        public GlyphIconTest(){
            this(null);
        }

        @Override
        public Enum getDefaultGlyph() {
            return null;
        }
    }
}
