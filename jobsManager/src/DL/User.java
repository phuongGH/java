/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DL;

import Control.WriteRead;
import java.io.Serializable;

/**
 *
 * @author BB
 */
public class User implements Serializable {

    private final int ID;
    private String Name;
    private String Password;
    private int jobNum;
    private int groupNum;

    public int getID() {
        return ID;
    }

    public User(String name, String password) {
        this.Name = name;
        this.Password = password;
        WriteRead wr = WriteRead.getReadWrite();
        this.ID = wr.getUserID();
        this.jobNum = 0;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getJobNum() {
        return jobNum;
    }

    public void setJobNum(int jobNum) {
        this.jobNum = jobNum;
    }

    public int getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(int groupNum) {
        this.groupNum = groupNum;
    }

}
