/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabasic;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AA
 */
public class backupMysql {

    public void backupAllDb() throws IOException {
        String LinkFile = "C:\\Users\\AA\\Desktop\\text.sql";
        String LinkMysqldump = "C:\\xampp\\mysql\\bin\\mysqldump";
        String dbUser = "root";
        String dbPass = "root";

        String executeCmd = LinkMysqldump + " -u " + dbUser + " -p" + dbPass
                + " test --result-file=" + LinkFile;

        System.out.println("executeCmd " + executeCmd);
        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
        int processComplete = 0;
        try {
            processComplete = runtimeProcess.waitFor();
            System.out.println("processComplete " + processComplete);
            if (processComplete == 0) {
                System.out.println("success");
            } else {
                System.out.println("restore failure");
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(StringBuliderDemo.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public void backupDbBame(String DBName) throws IOException {
        String LinkFile = "C:/Users/AA/Desktop/text.sql";
        String LinkMysqldump = "C:/xampp/mysql/bin/mysqldump";
        String USerName = "root";
        String dbPass = "root";

        String executeCmd = LinkMysqldump + " -u " + USerName + " -p "
                + DBName + " > " + LinkFile;
        System.out.println("executeCmd " + executeCmd);

        //Process runtimeProcess = Runtime.getRuntime().exec("C:\\");
        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
        int processComplete = 0;
        try {

            processComplete = runtimeProcess.waitFor();
            System.out.println("processComplete " + processComplete);
            if (processComplete == 0) {
                System.out.println("success");
            } else {
                System.out.println("restore failure");
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(StringBuliderDemo.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
}
