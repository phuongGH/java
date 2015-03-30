/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package components;

import java.util.ArrayList;

/**
 *
 * @author BB
 */
public class JobGroup {
//    private Job[] jobs;
//    private Job []jobs = new Job[10];
    private ArrayList<Job> jobs = new ArrayList<Job>();
    private String name;
    int lenght = 0;

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public JobGroup(String name) {
        this.name = name;
    }
     public void add(Job job){
         jobs.add(job);
     }
    
//    public void add(Job job){
//        int length = jobs.length;
//        jobs[lenght] = job;
//        lenght++;
//    }
//    
//    public void remove(Job job){
//        jobs.remove(job);
//    }
//    
//    public Job getIndex(int index){
//        return jobs.get(index);
//    }
//    
//    public int size(){
//        return jobs.size();
//    }
    
    
    
}
