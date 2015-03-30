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
public class UniversityB implements University{

    @Override
    public String calculatePoint(int point) {
        return Integer.toString(Math.round(point/(float)10.0));
    }
    
}
