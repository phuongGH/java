/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package layout_managemer;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author BB
 */
public class Layout_Managemer extends JFrame{

    public Layout_Managemer() throws HeadlessException {
        JMenuBar mb = new JMenuBar();
        JMenu m = new JMenu("frame");
        JMenuItem miFL = new JMenuItem("FlowLayout");
        mb.add(m);
        m.add(miFL);
        add(mb);
        mb.setSize(90, 20);
        setSize(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        miFL.addActionListener((ActionEvent e) -> {
            fFlowLayout ffl = new fFlowLayout();
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Layout_Managemer lm = new Layout_Managemer();
        // TODO code application logic here
    }
    
}
