/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author AA
 */
public class RegularExpressons {

    public static boolean containsTenDigits(String str) {
        Pattern patt = Pattern.compile(".*?[0-9]{10}.*");
        Matcher m = patt.matcher(str);
        return m.matches();
    }
}
