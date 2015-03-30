/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DL;

import Control.Data;
import Control.WriteRead;
import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;

/**
 *
 * @author BB
 */
public class Job implements Serializable,Comparable  {

    private int ID;
    private String Name;
    private int Status;
    private String FontNane;
    private int Size;
    private Color color;
    private int Style;
    private int GroupID;
    private int priority;
    
    
    public Job() {
        this.ID = -1;
        this.Name = WriteRead.getReadWrite().getLanguage("constructor_Job_name", Data.language);
        this.Status = 0;
        this.FontNane = "Arial";
        this.Size = 12;
        this.Style = Font.PLAIN;
        this.color = Color.BLACK;
        
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

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getFontNane() {
        return FontNane;
    }

    public void setFontNane(String FontNane) {
        this.FontNane = FontNane;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int Size) {
        this.Size = Size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getStyle() {
        return Style;
    }

    public void setStyle(int Style) {
        this.Style = Style;
    }

    public int getGroupID() {
        return GroupID;
    }

    public void setGroupID(int GroupID) {
        this.GroupID = GroupID;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(Object o) {
        return priority;
    }
}
