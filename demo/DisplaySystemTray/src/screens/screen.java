/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package screens;

import components.DisplayTrayIcon;
import java.awt.HeadlessException;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author BB
 */
public class screen extends JFrame implements ActionListener{

    JButton btnError = new JButton("Error");
    JButton btnWarning = new JButton("Warning");
    JButton btnInfo = new JButton("Info");
    JButton btnNormal = new JButton("Normal");
    DisplayTrayIcon DTI = new DisplayTrayIcon();
    
    public screen() throws HeadlessException {
        setSize(440, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        initComponets();
        initActionlistenal();
    }
    
    private void initComponets(){
        this.setLayout(null);
        btnError.setBounds(40, 40, 150, 40);
        btnWarning.setBounds(230, 40, 150, 40);
        btnInfo.setBounds(40, 120, 150, 40);
        btnNormal.setBounds(230, 120, 150, 40);
        add(btnError);
        add(btnWarning);
        add(btnInfo);
        add(btnNormal);
    }
    
    private void initActionlistenal(){
        btnError.addActionListener(this);
        btnWarning.addActionListener(this);
        btnInfo.addActionListener(this);
        btnNormal.addActionListener(this);
    }
    
    public static void main(String[] args) {
        screen s = new screen();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnError)
        {
            DisplayTrayIcon.trayIcon.displayMessage("System Error", "Message Error content", TrayIcon.MessageType.ERROR);
        }
        if(e.getSource() == btnWarning)
        {
            DisplayTrayIcon.trayIcon.displayMessage("System Warning", "Message Warning content", TrayIcon.MessageType.WARNING);
        }
        if(e.getSource() == btnNormal)
        {
            DisplayTrayIcon.trayIcon.displayMessage("System Normal", "Message Normal content", TrayIcon.MessageType.NONE);
        }
        if(e.getSource() == btnInfo)
        {
            DisplayTrayIcon.trayIcon.displayMessage("System Info", "Message Info content", TrayIcon.MessageType.INFO);
        }
          
    }
    
}
