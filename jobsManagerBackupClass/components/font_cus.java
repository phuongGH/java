/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author BB
 */
public class font_cus extends JPanel {
    
    private String string;
    private Color colorString;
    private Color backgroundColor = new Color(255, 255, 255, 0);
    private int fontSize = 12;
    private String fontName = "TimesRoman";
    private int style = 0; //Font.PLAIN
    private int paddingTop = 0;
    private int paddingLeft = 0;
    private int paddingRight = 0;
    private int paddingBotton = 0;

    public void setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
    }

    public void setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
    }

    public void setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
    }

    public void setPaddingBotton(int paddingBotton) {
        this.paddingBotton = paddingBotton;
    }
    
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
        this.setPreferredSize(new Dimension(0,fontSize+paddingTop+paddingBotton + ((fontSize*2)/10)));
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

    public font_cus() {
        this.string = "";
        colorString = Color.BLACK;
        PreferredSize();
    }
 
    

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(colorString);
        setBackground(backgroundColor);
        g.setFont(new Font(fontName, style, fontSize));
        g.drawString(string, paddingLeft, fontSize);
        
    }
}

