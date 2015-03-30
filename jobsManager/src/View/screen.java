/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.Data;
import Control.JobManager;
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;

/**
 *
 * @author BB
 */
public class screen extends JFrame {

    static TrayIcon trayIcon;
    JobManager jm = JobManager.getJobManager();
    private JPanel panelRoot;
    public screen() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setBackground(Data.ColorTranslucent);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panelRoot = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                if (g instanceof Graphics2D) {
                    final int R = 240;
                    final int G = 240;
                    final int B = 240;

                    g.setColor(new Color(R, G, B, 0));
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                }
            }
        };

        this.setLayout(new BorderLayout());
        add(panelRoot, BorderLayout.CENTER);
        ShowTrayIcon();
    }

    public JPanel getPanelRoot() {
        return panelRoot;
    }

    public static void ShowTrayIcon() {
        if (!SystemTray.isSupported()) {
            System.out.println("error, your pc sucks");
            System.exit(0);
        }
        trayIcon = new TrayIcon(CreateIcon("/images/icon16.png", "Tray Icon"));
        final PopupMenu popup = new PopupMenu();
        final SystemTray tray = SystemTray.getSystemTray();
//        MenuItem trayShow = new MenuItem("Hide");
//        popup.add(trayShow);
//        MenuItem trayOption = new MenuItem("Options");
//        popup.add(trayOption);
        MenuItem trayExit = new MenuItem("Exit");
        popup.add(trayExit);
        trayIcon.setPopupMenu(popup);
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {

        }
//
        trayExit.addActionListener((ActionEvent e) -> {
//            int reply = JOptionPane.showConfirmDialog(null, "Really Quit?", "Exit", JOptionPane.YES_NO_OPTION);
//            if (reply == JOptionPane.YES_OPTION) {
            System.exit(0);
//            }
        });
//
//        trayShow.addActionListener((ActionEvent e) -> {
//            if (f.isShowing()) {
//                f.hide();
//                trayShow.setLabel("Show");
//            } else {
//                f.show();
//                trayShow.setLabel("Hide");
//            }
//
//        });
//
//        trayOption.addActionListener((ActionEvent e) -> {
//            fo.show();
//        });
    }

    protected static Image CreateIcon(String path, String desc) {
        URL imageURL = screen.class.getResource(path);
        return (new ImageIcon(imageURL, desc).getImage());
    }
}
