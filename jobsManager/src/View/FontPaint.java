/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author BB
 */
public class FontPaint extends JPanel{
    
     
    private String string;
    private Color colorString = Color.BLACK;;
    private Color backgroundColor = new Color(255, 255, 255, 0);
    private int fontSize = 12;
    private String fontName = "TimesRoman";
    private int style = 0; //Font.PLAIN
    
    public void setString(String str) {
        this.string = str;
        
    }
    public void setFontName(String name){
        this.fontName = name;
    }

    public void setFontSize(int size) {
        this.fontSize = size;
        PreferredSize();
    }
    
    private void PreferredSize()
    {
        this.setPreferredSize(new Dimension(0,fontSize + ((fontSize*2)/10)));
    }

    public void setStyle(int style) {
        this.style = style;
    }
    public void setColorString(Color colorString) {
        this.colorString = colorString;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public FontPaint(String str) {
        this.string = str;
//        PreferredSize();
    }
 
    

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(colorString);
        setBackground(backgroundColor);
        g.setFont(new Font(fontName, style, fontSize));
        g.drawString(string, 0, fontSize);
        
    }
    
}
