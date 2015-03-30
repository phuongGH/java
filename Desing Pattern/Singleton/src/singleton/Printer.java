/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package singleton;

public class Printer {
    
    private static Printer pt;
    private Printer() {
    }
    
    public static Printer getPt(){
        if(pt == null)
        {
            pt = new Printer();
        }
        return pt;
    }
    
    public void connect(){
        
    }
    

    public static void main(String[] args) {
       Printer p = Printer.getPt();
       p.connect();
    }
    
}
