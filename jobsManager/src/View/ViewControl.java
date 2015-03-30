/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.JobManager;
import Control.Load;
import Control.WriteRead;
import DL.Job;
import java.awt.GraphicsDevice;
import static java.awt.GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSLUCENT;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author BB
 */
public class ViewControl {

    private static screen s;
    private final JPanel panelRoot;
    ArrayList<Job> jobs = new ArrayList();
    public ViewControl() {
        Load l = new Load();
        s = new screen();
        panelRoot = s.getPanelRoot();
        showGroup();
    }
    
    private void showGroup(){
        JobManager jm = JobManager.getJobManager();
        jobs = jm.getQueueJobsInGroup(jm.getGroupByID(1));
        System.out.println(jobs.get(0));
        System.out.println(jm.getGroupByID(1));
//        Job_V jv = new Job_V(jobs.get(0), jm.getGroupByID(1));
    }

    public static void main(String[] args) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        boolean isPerPixelTranslucencySupported
                = gd.isWindowTranslucencySupported(PERPIXEL_TRANSLUCENT);
        if (!isPerPixelTranslucencySupported) {
            WriteRead.getReadWrite().writeLog("Per-pixel translucency is not supported");
            System.exit(0);
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        WriteRead.getReadWrite().writeLog("***************  System running *************");
        ViewControl vc = new ViewControl();
    }
}
