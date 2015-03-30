/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import DL.Job;
import DL.JobGroup;
import DL.User;
import java.util.ArrayList;

/**
 *
 * @author BB
 */
public class Load {
    UserManager um;
    JobManager jm;
    public Load() {
       WriteRead.getReadWrite().writeLog("Load variable develop "+ Data.isDev);
       if(Data.isDev)
       {
           ResetDB();
       }
       nomalLoad();
           
    }
    
    private void nomalLoad(){
        WriteRead.getReadWrite().writeLog("nomalLoad...........");
        um = UserManager.getUserManager();
        jm = JobManager.getJobManager();
    }
    
    private void ResetDB(){
        WriteRead.getReadWrite().writeLog("reset DB");
        
        WriteRead wr = WriteRead.getReadWrite();
        User u = new User("user 1", "123456");
        u.setJobNum(3);
        u.setGroupNum(3);
        wr.writeUser(u);
        
        
        Job j1 = new Job();
        j1.setID(1);
        j1.setName("job 1");
        j1.setGroupID(1);
        j1.setPriority(1);
        
        Job j2 = new Job();
        j2.setID(2);
        j2.setName("job 2");
        j2.setGroupID(1);
        j2.setPriority(2);
        
        Job j3 = new Job();
        j3.setID(3);
        j3.setName("job 3");
        j3.setGroupID(1);
        j3.setPriority(3);
        
        ArrayList<Job> jobs = new ArrayList<>();
        jobs.add(j1);
        jobs.add(j2);
        jobs.add(j3);
        
        wr.writeJobs(jobs);   

        JobGroup jg1 = new JobGroup();
        jg1.setID(1);
        JobGroup jg2 = new JobGroup();
        jg2.setID(2);
        JobGroup jg3 = new JobGroup();
        jg3.setID(3);
        
        ArrayList<JobGroup> jobGroups = new ArrayList<>();
        jobGroups.add(jg1);
        jobGroups.add(jg2);
        jobGroups.add(jg3);
        wr.writeGroup(jobGroups);
    }
    
}
