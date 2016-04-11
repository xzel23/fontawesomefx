package de.jensd.fx.glyphs.testapps;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
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
        sizes.add("0.5em");
        sizes.add("0.6em");
        sizes.add("0.7em");
        sizes.add("0.8em");
        sizes.add("0.9em");
        sizes.add("1em");
        sizes.add("1.1em");
        sizes.add("1.2em");
        sizes.add("1.3em");
        sizes.add("1.4em");
        sizes.add("1.5em");
        sizes.add("1.6em");
        sizes.add("1.7em");
        sizes.add("1.8em");
        sizes.add("1.9em");
        sizes.add("2em");

        FontAwesomeIconView icon = new FontAwesomeIconView();
        
        sizes.forEach(s -> {
            Object size = icon.convert(s);
            System.out.println(size);
        });
    }


}