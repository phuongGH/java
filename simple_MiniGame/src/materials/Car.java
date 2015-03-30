package materials;

import javax.swing.JPanel;

public class Car extends JPanel{

    public Car() {
        this.setSize(47, 62);
        this.setOpaque(false);
        this.setLayout(null);
        
        Cell c1 = new Cell();
        c1.setLocation(15, 0);
        this.add(c1);
        
        Cell c2 = new Cell();
        c2.setLocation(0, 15);
        this.add(c2);
        Cell c3 = new Cell();
        c3.setLocation(15, 15);
        this.add(c3);
        Cell c4 = new Cell();
        c4.setLocation(30, 15);
        this.add(c4);
        
        Cell c5 = new Cell();
        c5.setLocation(15, 30);
        this.add(c5);
        
        Cell c6 = new Cell();
        c6.setLocation(0, 45);
        this.add(c6);
        Cell c8 = new Cell();
        c8.setLocation(30, 45);
        this.add(c8);
        
        
    }
    
    public boolean hitTestObject(Car c)
    {
        if(this.getLocation().x >=c.getLocation().x)
        {
            if(this.getLocation().y >=c.getLocation().y)
            {
                if(this.getHeight()>(this.getLocation().y - c.getLocation().y) && c.getWidth()>(this.getLocation().x - c.getLocation().x))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                if(c.getHeight()>(c.getLocation().y - this.getLocation().y) && c.getWidth()>(this.getLocation().x - c.getLocation().x))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return c.hitTestObject(this);
        }
//        System.out.println(c.getLocation());
//        System.out.println(this.getLocation());
//        return false;
    }
    
//    public void paint(Graphics g) {
//        g.setColor(Color.black);
//        g.drawRect(15, 0, 13, 13);
//        g.fillRect(17, 2, 10, 10);
//        
//        g.drawRect(0, 15, 13, 13);
//        g.drawRect(15, 15, 13, 13);
//        g.drawRect(30, 15, 13, 13);
//        g.fillRect(2, 17, 10, 10);
//        g.fillRect(17, 17, 10, 10);
//        g.fillRect(32, 17, 10, 10);
//        
//        g.drawRect(15, 30, 13, 13);
//        g.fillRect(17, 32, 10, 10);
//        
//        g.drawRect(0, 45, 13, 13);
//        g.drawRect(30, 45, 13, 13);
//        g.fillRect(2, 47, 10, 10);
//        g.fillRect(32, 47, 10, 10);
//
//  }
    
}
