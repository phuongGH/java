package data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class logManager {

    public static void emptyLog() {
        try {
            FileOutputStream fos = new FileOutputStream("src/data/log.dat", false);
            PrintWriter pw = new PrintWriter(fos);
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
            Date date = new Date();
            pw.print(dateFormat.format(date) + "   ");
            pw.println("empty log");
            pw.close();
            System.out.println("empty log !");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(logManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void writeLog(Object obj) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("src/data/log.dat", true);
            PrintWriter pw = new PrintWriter(fos);
//            Calendar cal = Calendar.getInstance();
//            pw.print(cal.get(Calendar.DATE) + "");
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
            Date date = new Date();
            pw.print(dateFormat.format(date) + "   ");
            pw.println(obj);
            System.out.println("app log: " + dateFormat.format(date) + " " + obj);
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(logManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(logManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
