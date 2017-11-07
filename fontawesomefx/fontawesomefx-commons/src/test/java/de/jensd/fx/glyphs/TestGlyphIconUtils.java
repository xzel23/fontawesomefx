package de.jensd.fx.glyphs;

import javafx.scene.text.Text;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TestGlyphIconUtils {

    @Test
    public void testSizeConverterEM(){
        String em ="3em";
        Number sizeNumber =  GlyphIconUtils.convert(em, new Text().getFont());
        assertTrue(sizeNumber.doubleValue() == 39.0);
    }

    @Test
    public void testSizeConverterPX(){
        String em ="3px";
        Number sizeNumber =  GlyphIconUtils.convert(em, new Text().getFont());
        assertTrue(sizeNumber.doubleValue() == 3.0);
    }

    @Test
    public void testSizeConverterPT(){
        String em ="3pt";
        Number sizeNumber =  GlyphIconUtils.convert(em, new Text().getFont());
        assertTrue(sizeNumber.doubleValue() == 4.0);
    }

    @Test
    public void testConverterInvalidSizeString(){
        String em ="3xxx";
        Number sizeNumber =  GlyphIconUtils.convert(em, new Text().getFont());
        assertTrue(sizeNumber.doubleValue() == 12.0);
    }

}
