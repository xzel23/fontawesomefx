/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensd.fx.glyphs.testapps;

import com.sun.javafx.css.Size;
import com.sun.javafx.css.SizeUnits;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jens Deters (mail@jensd.de)
 */
public class CssParserTest {

    public static void main(String[] args) {
        List<String> sizes = new ArrayList<>();
        sizes.add("9em");
        sizes.add("10pt");
        sizes.add("11px");
        sizes.add("12pc");
        sizes.add("13");

        sizes.forEach(s -> {
            Size size = size(s);
            System.out.println(size);
        });

        
        
    }

    private static Size size(String sizeString) {
        final String sval = sizeString.trim();
        final int len = sval.length();
        int trim = 2;
        String suffix = sval.substring(len - trim);
        SizeUnits unit = SizeUnits.PX;
        switch (suffix) {
            case "em":
                unit = SizeUnits.EM;
                break;
            case "pt":
                unit = SizeUnits.PT;
                break;
            case "px":
                unit = SizeUnits.PX;
                break;
            case "pc":
                unit = SizeUnits.PC;
                break;
            default:
                trim = 0;
        }
        Double size = Double.parseDouble(sval.substring(0, len - trim));
        return new Size(size, unit);

    }

}
