package materials;

import javax.swing.JPanel;

public class marginRoad extends JPanel{

    public marginRoad() {
        this.setSize(200, 60);
        this.setLayout(null);
        this.setOpaque(false);
         Cell c1 = new Cell();
         c1.setLocation(0, 0);
         this.add(c1);
         
         Cell c2 = new Cell();
         c2.setLocation(0, 30);
         this.add(c2);
         Cell c3 = new Cell();
         c3.setLocation(0, 45);
         this.add(c3);
         
         
         Cell c4 = new Cell();
         c4.setLocation(185, 0);
         this.add(c4);
         
         Cell c5 = new Cell();
         c5.setLocation(185, 30);
         this.add(c5);
         Cell c6 = new Cell();
         c6.setLocation(185, 45);
         this.add(c6);
    }
    
}
