package de.jensd.fx.glyphs;

/**
 *
 * @author Jens Deters (mail@jensd.de)
 */
public interface GlyphIconName {

    String characterToString();

    String unicodeToString();

    String name();

    char getChar();

    String getFontFamily();
    
    String getFontPath();

}
