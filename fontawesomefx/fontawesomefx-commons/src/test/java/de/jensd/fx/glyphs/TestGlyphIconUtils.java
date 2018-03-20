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
    public void testSizeConverterPC(){
        String em ="1pc";
        Number sizeNumber =  GlyphIconUtils.convert(em, new Text().getFont());
        assertTrue(sizeNumber.doubleValue() == 16.0);
    }

    @Test
    public void testSizeConverterPercent(){
        String em ="50%";
        Number sizeNumber =  GlyphIconUtils.convert(em, new Text().getFont());
        assertTrue(sizeNumber.doubleValue() == 6.5);
    }

    @Test
    public void testConverterInvalidSizeString(){
        String em ="3xxx";
        Number sizeNumber =  GlyphIconUtils.convert(em, new Text().getFont());
        assertTrue(sizeNumber.doubleValue() == 12.0);
    }

}
