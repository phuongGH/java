/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 *
 * @author BB
 */
public class DisplayTrayIcon {

    public static TrayIcon trayIcon;

    public DisplayTrayIcon() {

        if (!SystemTray.isSupported()) {
            System.out.println("Systeam isn't support tray icon");
            System.exit(0);
        }
        trayIcon = new TrayIcon(CreateIcon("/images/trayIcon.png", "Tray Icon"));
        final SystemTray tray = SystemTray.getSystemTray();
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
        }
        trayIcon.setToolTip("demo tray icon");
        
        /*
         //        set popup menu default of TrayIcon
        { 
            PopupMenu popup = new PopupMenu();
            MenuItem item1 = new MenuItem("Item1");
            MenuItem item2 = new MenuItem("Item2");
            MenuItem item3 = new MenuItem("Item3");
            popup.add(item1);
            popup.addSeparator();
            popup.add(item2);
            popup.addSeparator();
            popup.add(item3);
            trayIcon.setPopupMenu(popup);
        }
         */
        
//        setpopup menu custom 
        {
            JPopupMenu popup = new JPopupMenu();
            JMenuItem item1 = new JMenuItem("Item1",new ImageIcon("src/images/icon1.png"));
            JMenuItem item2 = new JMenuItem("Item2",new ImageIcon("src/images/icon2.png"));
            JMenuItem item3 = new JMenuItem("about",new ImageIcon("src/images/icon3.png"));
            JMenuItem itemExit = new JMenuItem("Exit",new ImageIcon("src/images/exit.png"));
            popup.add(item1);
            popup.addSeparator();
            popup.add(item2);
            popup.addSeparator();
            popup.add(item3);
            popup.addSeparator();
            popup.add(itemExit);
//        trayIcon.setPopupMenu(popup);

            trayIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        popup.setInvoker(popup);
                        popup.setVisible(true);
                        popup.setLocation(e.getX(), e.getY() - popup.getHeight());
                    }
                }
            });
            
            item3.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "about me");
                }
            });
            
            itemExit.addActionListener((ActionEvent e) -> {
                tray.remove(trayIcon);
                System.exit(0);
            });
            
            Menu menu = new Menu("Menu");
            MenuItem ErrorItem = new MenuItem("Error Trigger");
            MenuItem WarningItem = new MenuItem("Warning Trigger");
            MenuItem NormalItem = new MenuItem("Normal Trigger");
            MenuItem InfoItem = new MenuItem("Info Trigger");
            
            menu.add(ErrorItem);
            menu.add(WarningItem);
            menu.add(NormalItem);
            menu.add(InfoItem);
        }
    }
    
    

    private Image CreateIcon(String path, String desc) {
        URL imageUrl = DisplayTrayIcon.class.getResource(path);
        return (new ImageIcon(imageUrl, desc).getImage());
    }

}
