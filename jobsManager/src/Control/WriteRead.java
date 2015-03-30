/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author BB
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import DL.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author BB
 */
public class WriteRead {

    /*
     ***** constructor **********
     */
    private static WriteRead wr;

    private WriteRead() {
    }

    public static WriteRead getReadWrite() {
        if (wr == null) {
            wr = new WriteRead();
        }
        return wr;
    }

    
    
    
    
    /*
     *********** Language ****************
     */
    public String getLanguage(String controlName, String lang) {
        String result = "";
        try (BufferedReader br = new BufferedReader(new FileReader("src/Data/" + lang))) {
            String sTemp;
            while ((sTemp = br.readLine()) != null) {
                String[] parts = sTemp.split(" : ");
                if (controlName.equals(parts[0])) {
                    result = parts[1];
                }
            }
        } catch (Exception e) {
        }
        return result;
    }

    
    
    /*
    *************  Log ******************
    */
    public void writeLog(String string) {
        try {
            File file = new File(Data.logFile);
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("file log khong ton tai");
                System.out.println("tao moi file log");
            } 
            try (FileWriter fw = new FileWriter(file, true)) {
                BufferedWriter bw = new BufferedWriter(fw);
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
                Date date = new Date();
                bw.write("\n"+dateFormat.format(date)+" --> " + string);
                bw.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(WriteRead.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    

    /*
     ************* Job *****************
     */
    public void writeJobs(ArrayList<Job> jobs) {
        try {
            try (FileOutputStream f = new FileOutputStream(Data.JobsFile); ObjectOutputStream oOS = new ObjectOutputStream(f)) {
                for (Job job : jobs) {
                    oOS.writeObject(job);
                    writeLog("write Job " + job.toString());
                }
            }
        } catch (IOException e) {
            System.err.printf("khong the ghi");
        }
    }

    public ArrayList<Job> readJobs() {
        ArrayList<Job> jobs = new ArrayList<>();
        int n = UserManager.getUserManager().getUser().getJobNum();
        try {
            try (FileInputStream f = new FileInputStream(Data.JobsFile); ObjectInputStream oIS = new ObjectInputStream(f)) {
                for (int i = 0; i < n; i++) {
                    jobs.add((Job) oIS.readObject());
                    writeLog("Read Job " + jobs.get(i).toString());
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteRead.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(WriteRead.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        return jobs;
    }

    
    
    
    
    
    
    
    /*
     *************  Group ****************
     */
    public void writeGroup(ArrayList<JobGroup> group) {
        try {
            String id = String.valueOf(UserManager.getUserManager().getUser().getID());
            try (FileOutputStream f = new FileOutputStream(Data.systemData + id + ".gru"); ObjectOutputStream oOS = new ObjectOutputStream(f)) {
                for (JobGroup g : group) {
                    writeLog("Write group " + g.toString());
                    oOS.writeObject(g);
                }
            }
        } catch (IOException e) {
            System.err.printf("khong the ghi");
        }
    }
    
    
    
    public ArrayList<JobGroup> readGroup() {
        ArrayList<JobGroup> groups = new ArrayList<>();
        int n = UserManager.getUserManager().getUser().getGroupNum();
        try {
            try (FileInputStream f = new FileInputStream(Data.GroupFile); ObjectInputStream oIS = new ObjectInputStream(f)) {
                for (int i = 0; i < n; i++) {
                    groups.add((JobGroup) oIS.readObject());
                    writeLog("Read Job " + groups.get(i).toString());
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteRead.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(WriteRead.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        return groups;
    }
    
    
    
    
    

    /*
     *****************  User ***************
     */
    public int getUserID() {
        writeLog("getUserID");
        int result = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(Data.systemFile))) {
            String sTemp;
            while ((sTemp = br.readLine()) != null) {
                String[] parts = sTemp.split(" : ");
                if ("IDUser".equals(parts[0])) {
                    result = Integer.parseInt(parts[1]);
                }
            }
        } catch (Exception e) {
        }
        return result;
    }

    public void writeUser(User user) {
        try {
            try (FileOutputStream f = new FileOutputStream(Data.systemData + user.getID()); ObjectOutputStream oOS = new ObjectOutputStream(f)) {
                writeLog("Write user " + user.toString());
                oOS.writeObject(user);
            }
        } catch (IOException e) {
            System.err.printf("khong the ghi" + e);
        }
    }

    public User readUser(String fileUser) {

        User user = null;
        try {
            try (FileInputStream f = new FileInputStream(fileUser); ObjectInputStream oIS = new ObjectInputStream(f)) {
                user = (User) oIS.readObject();
                writeLog("read user "+ user.toString());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteRead.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(WriteRead.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        return user;
    }

}
