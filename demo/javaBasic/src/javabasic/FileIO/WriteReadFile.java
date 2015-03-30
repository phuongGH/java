package javabasic.FileIO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteReadFile {

    private static WriteReadFile wrf;

    private WriteReadFile() {

    }

    public static WriteReadFile getWriteReadFile() {
        if (wrf == null) {
            wrf = new WriteReadFile();
            try {
                File file = new File("src/logs/log.log");
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                try (FileWriter fw = new FileWriter(file, true)) {
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write("wwwwwwwww");
                    bw.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(WriteReadFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return wrf;
    }

    public void writeFile() {
        try {
            File file = new File("src/logs/log.log");
            if (!file.exists()) {
                file.createNewFile();
                System.err.println("file khong ton tai");
            } else {
                System.err.println("file ton tai");
            }
            try (FileWriter fw = new FileWriter(file, true)) {
                BufferedWriter bw = new BufferedWriter(fw);
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
                Date date = new Date();
                System.out.println(dateFormat.format(date));
                bw.write("\nwwwwwwwww");
                bw.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(WriteReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
