/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/**
 *
 * @author BB
 */
public class GroupCellRenderer implements ListCellRenderer {

//    private int currIndex = -1;
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JobGroup jobs = (JobGroup) value;
        String title = jobs.getName();
        font_cus panelTitle = new font_cus();
        panelTitle.setFontSize(14);
        panelTitle.setStyle(1);
        panelTitle.setString(title);
//        panelTitle.setBackground(Color.red);
//        JPanel panel = new JPanel();
//        panel.setLayout(new BorderLayout());
//        JList list2 = new JList(jobs.getJobs());
//        list2.setCellRenderer(new JobCellRenderer());
//        list2.setVisibleRowCount(3);
//        list2.setFixedCellHeight(20);
//        JScrollPane scrPane = new JScrollPane(list2);
//        scrPane.getVerticalScrollBar().setUI(new ScrollBarUICus());
//        scrPane.setBorder(null);
//        list2.setBackground(varDefine.Color.translucent);
//        panel1.setBackground(varDefine.Color.translucent);
//        panel.add(scrPane, BorderLayout.CENTER);
//        panel.add(panel1, BorderLayout.NORTH);

        JPanel panelResult = new JPanel();
        BorderLayout borderLayout = new BorderLayout();
        panelResult.setLayout(borderLayout);
        panelResult.setBackground(varDefine.Color.translucent);
        JPanel contenPane = new JPanel();
        LineLayout lineLayout = new LineLayout();
        contenPane.setLayout(lineLayout);
        ArrayList<Job> allJob = jobs.getJobs();
        for (Job allJob1 : allJob) {
            JPanel innerPanel = new JPanel();
            innerPanel.setLayout(new BorderLayout());
            font_cus fc = new font_cus();
            fc.setString(allJob1.getJobName());
            fc.setBackground(Color.BLUE);
            innerPanel.add(fc,BorderLayout.CENTER);
            PanelImage panelImage = new PanelImage(allJob1.getImage());
            innerPanel.add(panelImage,BorderLayout.EAST);
            contenPane.add(innerPanel);
        }
        panelResult.add(panelTitle, BorderLayout.NORTH);
        panelResult.add(contenPane, BorderLayout.CENTER);
        return panelResult;
    }

}
