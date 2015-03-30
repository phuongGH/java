/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;

/**
 *
 * @author BB
 */
public class LineLayout implements LayoutManager {
    
    private int PaddingTop = 2;
    private int Paddingleft = 2;
    private int Paddingright = 2;
    private int Paddingbotton = 2;
    
    public void setPaddingTop(int PaddingTop) {
        this.PaddingTop = PaddingTop;
    }


    public void setPaddingleft(int left) {
        this.Paddingleft = left;
    }

    public void setPaddingRight(int right) {
        this.Paddingright = right;
    }

    public void setPaddingBotton(int botton) {
        this.Paddingbotton = botton;
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        Insets insets = parent.getInsets();
        int height = PaddingTop;
        int width = parent.getWidth() - Paddingleft - Paddingright;
        Component[] children = parent.getComponents();
        Dimension compSize = null;
        for (Component child : children) {
            compSize = child.getPreferredSize();
            height += compSize.height + PaddingTop + Paddingleft;
//                width = Math.max(width, compSize.width + insets.left + insets.right + xInset * 2);
        }
        height += insets.bottom;
        return new Dimension(width, height);
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void layoutContainer(Container parent) {
//        Insets insets = parent.getInsets();
        Component[] children = parent.getComponents();
        Dimension compSize = null;
        int y = PaddingTop;
        for (Component child : children) {
            if (child.isVisible()) {
                compSize = child.getPreferredSize();
                child.setBounds(Paddingleft, y, parent.getWidth() - Paddingright - Paddingleft, compSize.height);
                y = y + PaddingTop + compSize.height + Paddingbotton;
            }
        }
    }

}
