package de.jensd.fx.glyphs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.text.Font;

public class GlyphIconUtils {

    private static final double DEFAULT_SIZE = 12.0;

    private static final Pattern PATTERN = Pattern.compile("(?<number>([\\d]+(\\.\\d+)?))(?<unit>[a-z]*|%)");

    public static Number convert(String sizeString, Font font) {
    		/*
    		 * CSS absolute scaling values
    		 * 
    		 * source: https://drafts.csswg.org/css-fonts-3/
    		 * 
    		 * CSS absolute-size values | xx-small |  x-small |    small |   medium |    large |  x-large | xx-large |          |
    		 * scaling factor           |      3/5 |      3/4 |      8/9 |        1 |      6/5 |      3/2 |      2/1 |      3/1 |
    		 */
    		switch (sizeString) {
    		/*
    		 * CSS absolute scaling values
    		 * 
    		 * source: https://drafts.csswg.org/css-fonts-3/
    		 * 
    		 * CSS absolute-size values | xx-small |  x-small |    small |   medium |    large |  x-large | xx-large |          |
    		 * scaling factor           |      3/5 |      3/4 |      8/9 |        1 |      6/5 |      3/2 |      2/1 |      3/1 |
    		 */
    		case "":
	           return DEFAULT_SIZE;
    		case "xx-small":
    			return DEFAULT_SIZE * 3/5;
    		case "x-small":
    			return DEFAULT_SIZE * 3/4;
    		case "small":
    			return DEFAULT_SIZE * 8/9;
    		case "medium":
    			return DEFAULT_SIZE;
    		case "large":
    			return DEFAULT_SIZE * 6/5;
    		case "x-large":
    			return DEFAULT_SIZE * 3/2;
    		case "xx-large":
    			return DEFAULT_SIZE * 2;
    		/*
    		 * relative sizes are computed relative to the supplied refernce font.
    		 * values are taken from the same specification as above.
    		 */
    		case "smaller":
    			return font.getSize() * 8/9;
    		case "larger":
    			return font.getSize() * 6/5;
    		/*
    		 * Relative sizes with different length units are parsed accordingly.
    		 */
    		default:
    			return parseRelativeSize(sizeString, font);
    	    }
    }

    private static Number parseRelativeSize(String sizeString, Font font) {
    		// get size of base font
		double baseSize = font.getSize();
	    
        // extract number and unit
        Matcher matcher = PATTERN.matcher(sizeString);

        if (!matcher.matches()) {
        		return DEFAULT_SIZE;
        }

        String numberString = matcher.group("number");
        double sz = Double.parseDouble(numberString);

        String unit = matcher.group("unit");

        // do the conversion
        switch (unit) {
        case "em":
            return baseSize * sz;        // relative to base font size
        case "%":
        		return  baseSize * sz/100.0; // relative to base font size (percent)
        case "":                         // treat as px
        case "px":
            return sz;                   // absolute
        case "pt":
            return sz*16/12;             // 1 pt = 1/72 inch - the exact factor depends on display resolution!
        case "pc":
            return sz*16;                // 1 pica is 12 points
        default:
            // Maybe  this should be: throw new IllegalArgumentException("unknown size unit: '"+unit+"'");
            return DEFAULT_SIZE;
        }
    }
}
