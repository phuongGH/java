/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author BB
 */
public class PanelImage extends JPanel {

    private Image img;
    public PanelImage(Image img) {
        this.img = img;
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, WIDTH, WIDTH, this);
    }

}
