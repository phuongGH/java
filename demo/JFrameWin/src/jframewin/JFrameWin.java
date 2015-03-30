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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
 
/**
 *
 * @web http://java-buddy.blogspot.com/
 */
public class JFrameWin extends JFrame{
     
    public JFrameWin(){
         
        final JPanel jPanel = new JPanel();
         
        this.setTitle("java-buddy.blogspot.com");
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
        JButton buttonExit = new JButton(" Exit ");
        buttonExit.addActionListener(new ActionListener(){
  
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
         
        final JRadioButton jRadioButtonA = new JRadioButton("NORMAL");
        final JRadioButton jRadioButtonB = new JRadioButton("POPUP");
        final JRadioButton jRadioButtonC = new JRadioButton("UTILITY");
 
        ActionListener radioButtonActionListener = new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent ae) {
                 
                String cmd = ae.getActionCommand();
 
                JFrame newFrame =new JFrame(); 
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setSize(300,200);
                newFrame.setTitle(cmd);
                 
                if(cmd == "NORMAL"){
                    newFrame.setType(Type.NORMAL);
                }else if(cmd == "POPUP"){
                    newFrame.setType(Type.POPUP);
                }else if(cmd == "UTILITY"){
                    newFrame.setType(Type.UTILITY);
                }
                 
                newFrame.setVisible(true);
 
            }
             
        };
         
        jRadioButtonA.addActionListener(radioButtonActionListener);
        jRadioButtonB.addActionListener(radioButtonActionListener);
        jRadioButtonC.addActionListener(radioButtonActionListener);
         
        ButtonGroup buttonGroup  = new ButtonGroup();
        buttonGroup.add(jRadioButtonA);
        buttonGroup.add(jRadioButtonB);
        buttonGroup.add(jRadioButtonC);
         
        Box verticalBox = Box.createVerticalBox();
        verticalBox.add(jRadioButtonA);
        verticalBox.add(jRadioButtonB);
        verticalBox.add(jRadioButtonC);
         
        jPanel.add(verticalBox);
        jPanel.add(buttonExit);
         
        this.add(jPanel);
         
    }
    
}