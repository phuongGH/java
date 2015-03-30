/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasic.FileIO;

;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BB
 */


public class ReadWriteObject {

    private String path = "src/Data/";
    private String fName;
    private Object ojb;
    private static ReadWriteObject fw;

    private ReadWriteObject() {
    }

    public static ReadWriteObject getReadWrite() {
        if (fw == null) {
            fw = new ReadWriteObject();
        }
        return fw;
    }

    public void writeFile(Object object, String fileName) {
        try {
            FileOutputStream f = new FileOutputStream(path + fileName);
            ObjectOutputStream oOS = new ObjectOutputStream(f);
            oOS.writeObject(object);
            oOS.close();
            f.close();
        } catch (IOException e) {
            System.err.printf("khong the ghi");
        }
    }

    public Object readFile(String fileName) {
        try {
            FileInputStream f = new FileInputStream(path + fileName);
            ObjectInputStream oIS = new ObjectInputStream(f);
            ojb = oIS.readObject();

            oIS.close();
            f.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadWriteObject.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ReadWriteObject.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        return ojb;
    }
}
