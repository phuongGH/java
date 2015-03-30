/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package composite;

/**
 *
 * @author AA
 */
public class student implements Education{
    //subClass 1
    private float math;
    private float physic;

    public student(float math, float physic) {
        super();
        this.math = math;
        this.physic = physic;
    }
    
    
    @Override
    public float calculatePoint() {
       return (math+physic)/2;
    }
    
}
