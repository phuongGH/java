package javabasic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class systeamDateTimeDemo {
    public static void show()
    {
        
        long lStart = System.currentTimeMillis();
        delay(1);
        long lEnd = System.currentTimeMillis();
        long lscope =lEnd - lStart;
        System.out.println("current time Millis while to sleep(100) is " 
                + lscope);
        
        lStart = System.nanoTime();
        lEnd = System.nanoTime();
        lscope =lEnd - lStart;
        System.out.println("nano time nonstop is "+ lscope);
        
        
        DateFormat df = new SimpleDateFormat("dd-MM-YYYY");
        Date date = new Date();
        String day = df.format(date);
        System.out.println("current Date : " + day);
    }
    
    
    private static void delay(long time){
         for(int i =0; i< 100; i++){
            try {
                Thread.sleep(time);
            } catch (InterruptedException ex) {
                Logger.getLogger(systeamDateTimeDemo.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        }
    }

}
