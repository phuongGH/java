/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jframewin;

/**
 *
 * @author BB
 */
import javax.swing.SwingUtilities;
 
/**
 *
 * @web http://java-buddy.blogspot.com/
 */
public class JavaTestSwing {
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(runJFrameLater);
    }
     
    static Runnable runJFrameLater = () -> {
        JFrameWin jFrameWindow = new JFrameWin();
        jFrameWindow.setVisible(true);
    };
}