/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package src;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author BB
 */
public class screen extends JFrame{

    public screen() throws HeadlessException {
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        initComponents();
    }
    
    private void initComponents(){
        JTextArea txt = new JTextArea();
        JButton btnOpen = new JButton("Open");
        JButton btnSave = new JButton("Save");
        JButton btnConvert = new JButton("Convert");
        JPanel panel = new JPanel();
        this.setLayout(null);
        txt.setSize(996, 500);
        txt.setLocation(2,5);
        this.add(txt);
        
        panel.setLayout(null);
        
        btnOpen.setSize(200, 40);
        btnOpen.setLocation(100,40);
        btnConvert.setSize(200, 40);
        btnConvert.setLocation(400,40);
        btnSave.setSize(200, 40);
        btnSave.setLocation(700,40);
        panel.add(btnOpen);
        panel.add(btnConvert);
        panel.add(btnSave);
        panel.setSize(990,80);
        panel.setLocation(2, 475);
        this.add(panel);
    }
    
    public static void main(String[] args) {
        new screen();
    }
    
}
