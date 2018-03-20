package de.jensd.fx.glyphs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.text.Font;

public class GlyphIconUtils {

    private static final double DEFAULT_SIZE = 12.0;

    private static final Pattern PATTERN = Pattern.compile("(?<number>([\\d]+(\\.\\d+)?))(?<unit>[a-z%]+)");

    public static Number convert(String sizeString, Font font) {
        if (sizeString.isEmpty()) {
            return DEFAULT_SIZE;
        }

        // extract number and unit
        Matcher matcher = PATTERN.matcher(sizeString);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("invlalid size string: '"+sizeString+"'");
        }

        String numberString = matcher.group("number");
        double sz = Double.parseDouble(numberString);

        String unit = matcher.group("unit");

        // do the conversion
        double baseSize = font.getSize();
        switch (unit) {
        case "em":
            return baseSize * sz;
        case "px":
            return sz;
        case "pt":
            return sz*16/12;
        case "%":
            return  baseSize * sz/100.0;
        default:
            // Maybe  this should be: throw new IllegalArgumentException("unknown size unit: '"+unit+"'");
            return DEFAULT_SIZE;
        }
    }
}
