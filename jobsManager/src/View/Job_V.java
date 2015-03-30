/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import DL.Job;
import DL.JobGroup;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author BB
 */
public class Job_V extends JPanel{
    private Job job;
    private JobGroup jobGroup;
    private JPanel panelTitle;
    private JPanel panelContent;
    
    public Job_V(Job job, JobGroup jobGroup) {
        this.job = job;
        this.jobGroup = jobGroup;
        this.setSize(300, 300);
        this.setLocation(jobGroup.getX(), jobGroup.getY());
        this.setLayout(new BorderLayout());
        showTitle();
    }
    
    private void showTitle()
    {
        panelTitle = new JPanel();
        FontPaint txtTitle = new FontPaint(jobGroup.getFontName());
        panelTitle.setLayout(new BorderLayout());
        panelTitle.add(txtTitle,BorderLayout.CENTER);
        panelContent.add(panelTitle,BorderLayout.NORTH);
    }
    
}
