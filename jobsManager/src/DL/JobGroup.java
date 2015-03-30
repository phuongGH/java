/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DL;

import Control.Data;
import Control.WriteRead;
import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author BB
 */
public class JobGroup implements Serializable {

    private int ID;
    private String Name;
    private Color backgroundColor;
    private int maxLine;
    private String fontName;
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public JobGroup() {
        this.ID = -1;
        this.Name = WriteRead.getReadWrite().getLanguage("constructor_Job_Group", Data.language);
        backgroundColor = Color.CYAN;
        maxLine = 5;
        fontName = "TimesRoman";
        x=0;
        y=0;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getMaxLine() {
        return maxLine;
    }

    public void setMaxLine(int maxLine) {
        this.maxLine = maxLine;
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

}
