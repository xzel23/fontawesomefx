/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jens Deters
 */
public class Test {

    public static void main(String[] args) {

        String ucStr1 = "U+1F600";
        String uc = toCode(ucStr1);
        System.out.println(uc);
        
        String ucStr2 = "U+1f478";
        String ucStr3 = "U+1f3fb";
        String uc2 = toCode(ucStr2, ucStr3);
        System.out.println(uc2);
    }

    public static String toCode(String uccodepoint) {
        int code = Integer.parseInt(uccodepoint.substring(2), 16);
        char[] chars = Character.toChars(code);
        return String.format("\\u%04x\\u%04x", (int)chars[0],(int)chars[1]);
    }
    public static String toCode(String cp1, String cp2) {
        return toCode(cp1).concat(toCode(cp2));
    }
}
