package materials;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Cell extends JPanel {


    public Cell() {
        this.setLayout(null);
        this.setSize(15, 15);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(0, 0, 13, 13);
        g.fillRect(2, 2, 10, 10);
    }

}
