/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layout_managemer;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author BB
 */
public class fFlowLayout extends JFrame {

    public fFlowLayout() throws HeadlessException {
        Container rootPanel = this.getContentPane();

        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        JPanel panelControl = new JPanel();
        panelControl.setBounds(0, 0, 100, 400);
        panelControl.setBackground(Color.GRAY);
        JPanel panelView = new JPanel();
        panelView.setBounds(100, 0, 400, 400);
        panelView.setBackground(Color.cyan);
        rootPanel.setLayout(null);
        rootPanel.add(panelControl);
        rootPanel.add(panelView);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.red);
        panel1.add(new JLabel("panel 1"));
        panel1.setPreferredSize(new Dimension(200, 50));

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);
        panel2.add(new JLabel("panel 2"));
        panel2.setPreferredSize(new Dimension(200, 50));

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.BLACK);
        panel3.add(new JLabel("panel 3"));
        panel3.setPreferredSize(new Dimension(100, 50));

        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.YELLOW);
        panel4.add(new JLabel("panel 4"));
        panel4.setPreferredSize(new Dimension(300, 50));

        JPanel panel5 = new JPanel();
        panel5.setBackground(Color.GRAY);
        panel5.add(new JLabel("panel 5"));
        panel5.setPreferredSize(new Dimension(400, 50));

        JPanel panel6 = new JPanel();
        panel6.setBackground(Color.GREEN);
        panel6.add(new JLabel("panel 6"));
        panel6.setPreferredSize(new Dimension(100, 50));

        JPanel panel7 = new JPanel();
        panel7.setBackground(Color.red);
        panel7.add(new JLabel("panel 7"));
        panel7.setPreferredSize(new Dimension(100, 50));

        JPanel panel8 = new JPanel();
        panel8.setBackground(Color.red);
        panel8.add(new JLabel("panel 8"));
        panel8.setPreferredSize(new Dimension(100, 50));

        FlowLayout fl = new FlowLayout();
        panelView.setLayout(fl);
        panelView.add(panel1);
        panelView.add(panel2);
        panelView.add(panel3);
        panelView.add(panel4);
        panelView.add(panel5);
        panelView.add(panel6);
        panelView.add(panel7);
        panelView.add(panel8);

        JButton btnLeft = new JButton("Left");
        JButton btnRight = new JButton("Right");
        JButton btnCenter = new JButton("Center");
        JButton btnLeading = new JButton("Leading");
        JButton btnTrailing = new JButton("Trailing");
        JButton btnLeftToRight = new JButton("left to right");
        JButton btnRightToLeft = new JButton("right to left");
        
        
        btnLeft.setBounds(10, 50, 80, 40);
        btnRight.setBounds(10, 100, 80, 40);
        btnCenter.setBounds(10, 150, 80, 40);
        btnLeading.setBounds(10, 200, 80, 40);
        btnTrailing.setBounds(10, 250, 80, 40);
        btnLeftToRight.setBounds(10, 300, 80, 40);
        btnRightToLeft.setBounds(10, 350, 80, 40);
        
        panelControl.setLayout(null);
        panelControl.add(btnLeft);
        panelControl.add(btnRight);
        panelControl.add(btnCenter);
        panelControl.add(btnLeading);
        panelControl.add(btnTrailing);
        panelControl.add(btnLeftToRight);
        panelControl.add(btnRightToLeft);

        btnLeft.addActionListener((ActionEvent e) -> {
            fl.setAlignment(FlowLayout.LEFT);
            panelView.setLayout(fl);
            rootPanel.revalidate();
            panelView.repaint();
        });

        btnRight.addActionListener((ActionEvent e) -> {
            fl.setAlignment(FlowLayout.RIGHT);
            panelView.setLayout(fl);
            rootPanel.revalidate();
            panelView.repaint();
        });

        btnLeading.addActionListener((ActionEvent e) -> {
            fl.setAlignment(FlowLayout.LEADING);
            panelView.setLayout(fl);
            rootPanel.revalidate();
            panelView.repaint();
        });

        btnCenter.addActionListener((ActionEvent e) -> {
            fl.setAlignment(FlowLayout.CENTER);
            panelView.setLayout(fl);
            rootPanel.revalidate();
            panelView.repaint();
        });

        btnTrailing.addActionListener((ActionEvent e) -> {
            fl.setAlignment(FlowLayout.TRAILING);
            panelView.setLayout(fl);
            rootPanel.revalidate();
            panelView.repaint();
        });
        
        btnLeftToRight.addActionListener((ActionEvent e) -> {
            panelView.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            rootPanel.revalidate();
            panelView.repaint();
        });
        
        btnRightToLeft.addActionListener((ActionEvent e) -> {
            panelView.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            rootPanel.revalidate();
            panelView.repaint();
        });
        
        for(int i =0 ; i < 10 ; i++)
        {
            JPanel newPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            newPanel.add(new JLabel("panel " + Integer.toString(i)));
            newPanel.setBackground(Color.ORANGE);
            panelView.add(newPanel);
        }
    }

}
