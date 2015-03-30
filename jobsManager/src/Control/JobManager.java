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
import java.util.Collections;

/**
 *
 * @author BB
 */
public class JobManager {

    private ArrayList<Job> Jobs = new ArrayList<>();
    private ArrayList<JobGroup> groups = new ArrayList<>();
    private static JobManager jm = null;

    private JobManager() {
        LoadJobs();
        LoadGroup();
    }


    public static JobManager getJobManager() {
        if (jm == null) {
            jm = new JobManager();
             WriteRead.getReadWrite().writeLog("constructor JobManager");
        }
        return jm;
    }
    
    /*
        *******Job****************
    */
     private void LoadJobs() {
        WriteRead wr = WriteRead.getReadWrite();
        Jobs = wr.readJobs();
        WriteRead.getReadWrite().writeLog("-JobManager- LoadJobs");
    }
    
    public void addJobs(Job j) {
        WriteRead.getReadWrite().writeLog("-JobManager- addJob");
        User u = UserManager.getUserManager().getUser();
        int i = u.getJobNum();
        i++;
        u.setJobNum(i);
        Jobs.add(j);
        WriteRead wr = WriteRead.getReadWrite();
        wr.writeUser(u);
        wr.writeJobs(Jobs);
    }
    
     public Job getJobByID(int ID) {
        WriteRead.getReadWrite().writeLog("-JobManager- getJobByID " + ID);
        for (Job job : Jobs) {
            if (job.getID() == ID) {
                return job;
            }
        }
        return null;
    }
     
      public ArrayList getJobsByName(String name) {
        WriteRead.getReadWrite().writeLog("-JobManager- getJobsByName " + name);
        ArrayList<Job> result = new ArrayList<>();
        Jobs.stream().filter((job) -> (job.getName().equals(name))).forEach((job) -> {
            result.add(job);
        });
        return result;
    }
    
    public ArrayList getAllJobs() {
        WriteRead.getReadWrite().writeLog("-JobManager- getAllJobs");
        return Jobs;
    }
    
    
    public ArrayList getAllJobsInGroup(JobGroup g) {
        WriteRead.getReadWrite().writeLog("-JobManager- getAllJobsInGroup " + g.getID());
        ArrayList<Job> result = new ArrayList<>();
        Jobs.stream().filter((job) -> (job.getGroupID() == g.getID())).forEach((job) -> {
            result.add(job);
        });
        return result;
    }

    public ArrayList<Job> getQueueJobs() {
        WriteRead.getReadWrite().writeLog("-JobManager- getQueueJobs");
        sort();
        ArrayList<Job> result = new ArrayList();
        Jobs.stream().filter((j) -> (j.getPriority() >= 0)).forEach((j) -> {
            result.add(j);
        });
        return result;
    }
    
      public ArrayList getQueueJobsInGroup(JobGroup g) {
        WriteRead.getReadWrite().writeLog("-JobManager- getQueueJobsInGroup " + g.getID());
        ArrayList<Job> result = new ArrayList<>();
        ArrayList<Job> source = new ArrayList<>();
        source = getAllJobsInGroup(g);
        for (Job j : source) {
            if (j.getPriority() >= 0) {
                result.add(j);
            }
        }
        return result;
    }

    private void sort() {
        Collections.sort(Jobs);
    }

    
    /*
        *********Group*********
    */
        private void LoadGroup() {
        WriteRead wr = WriteRead.getReadWrite();
        groups = wr.readGroup();
        WriteRead.getReadWrite().writeLog("-JobManager- LoadGroup");
    }
    
    public void addGroup() {
        WriteRead.getReadWrite().writeLog("-JobManager- ađGroup");
        JobGroup jg1 = new JobGroup();
        jg1.setID(1);
        jg1.setName("Group 1");
        JobGroup jg2 = new JobGroup();
        jg2.setID(2);
        jg2.setName("Group 2");
        JobGroup jg3 = new JobGroup();
        jg3.setID(3);
        jg3.setName("Group 3");

//        ArrayList<JobGroup> group = new ArrayList<>();
//        group.add(jg1);
//        group.add(jg2);
//        group.add(jg3);
        WriteRead wr = WriteRead.getReadWrite();
//        wr.write(groups);
    }
        
    public JobGroup getGroupByID(int ID){
        WriteRead.getReadWrite().writeLog("-JobManager- getGroupByID " + ID);
        JobGroup result = null;
        for(JobGroup jg: groups){
            if(jg.getID() == ID)
            {
                result = jg;
            }
        }
        return result;
    } 
    
    public ArrayList getAllGroup() {
         WriteRead.getReadWrite().writeLog("-JobManager- getAllGroup");
        return groups;
    }

}
