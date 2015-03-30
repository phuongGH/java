/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/**
 *
 * @author BB
 */
public class JobCellRenderer implements ListCellRenderer {


    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Job job = (Job) value;
        JPanel panel = new JPanel() {

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (job != null) {
                    g.setColor(Color.black);
                    g.setFont(new Font("TimesRoman", 0, 12));
                    g.drawString(job.getJobName(), 10, 20);
                    g.drawImage(job.getImage(), 150, 0, this);
                }

            }
        };
        panel.setBackground(varDefine.Color.translucent);
        return panel;
    }

}
