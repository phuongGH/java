/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package abstractclass;

/**
 *
 * @author AA
 */
public class SchoolA extends School{

    @Override
    public String calculatePoint(int point) {
        if(point>85){
            return "A";
        }
        if(point>70){
            return "B";
        }
        if(point>55){
            return "C";
        }
        else
        {
            return "D";
        }
    }
    
}
