package de.jensd.fx.glyphs.test;


import javafx.css.CssParser;
import javafx.css.Stylesheet;

/*
 * Copyright 2017 Jens Deters.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 *
 * @author Jens Deters
 */
public class TestParser {

    public static void main(String[] args) {
        CssParser CSS_PARSER = new CssParser();
        String sizeString = "3em";
        String styleSheetText = "{-fx-font-size: " + sizeString + ";}";
        System.out.println("styleSheetText: " + styleSheetText);
        
        
        Stylesheet stylesheet = CSS_PARSER.parse(styleSheetText);
        System.out.println(stylesheet.getRules().get(0));
        
        System.out.println(stylesheet.getRules().get(0).getDeclarations().get(0).getParsedValue());

    }

}
