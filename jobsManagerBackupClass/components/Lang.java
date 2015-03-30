/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author BB
 * 
 * lớp hổ trợ đa ngôn ngữ thông qua file cấu trúc nằm trong thư mục language
 * 
 */
public class Lang {

    public static String getLanguage(String controlName, String lang) {
       String result="";
        try (BufferedReader br = new BufferedReader(new FileReader("src/Data/" + lang))) {
            String sTemp;
            while ((sTemp = br.readLine()) != null) {
                String [] parts = sTemp.split(" : ");
                if(controlName.equals(parts[0]) ){
                    result = parts[1];
                }
            }
        } catch (Exception e) {
        }
        return result;
    }
}
