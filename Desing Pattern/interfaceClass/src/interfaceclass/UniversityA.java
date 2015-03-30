/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaceclass;

/**
 *
 * @author AA
 */
public class UniversityA implements University{

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
