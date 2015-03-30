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
public abstract class School {
    public void displayNote(){
        System.out.println("Please pay tuition fee before stating new semester.");
    }
    
    public abstract String calculatePoint(int point);
}
