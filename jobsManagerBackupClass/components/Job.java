/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author BB
 */
public class Job {

    private String jobName;
    private String jobGroup;
    private int status;
    private Image image;
//    private boolean isSet = false;

//    public boolean isIsSet() {
//        return isSet;
//    }
//
//    public void setIsSet(boolean isSet) {
//        this.isSet = isSet;
//    }
    
    public Job(String name, String group, int status) {
        jobName = name;
        jobGroup = group;
        this.status = status;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Image  getImage() {
        if (image == null) {
            if(status==0)
            {
                image = Toolkit.getDefaultToolkit().getImage("src/images/uncheck.png");
            }
            else
            {
                image = Toolkit.getDefaultToolkit().getImage("src/images/check.png");
            }
        }
        return image;
    }
}
