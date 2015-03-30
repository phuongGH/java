
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BB
 */
public class frameMain extends JFrame{

    public frameMain() throws HeadlessException {
        initComponent();
    }
    
    private void initComponent(){
        setMinimumSize(new Dimension(400,300));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        JButton btn = new JButton("Show frame");
        btn.setBounds(getWidth()/2-60,getHeight()/2-40,120,40);
        add(btn);
        btn.addActionListener((ActionEvent e)->{
            frame_utility fu = new frame_utility();
        });
    }
    
    public static void main(String[] args) {
        frameMain f = new frameMain();
    }
    
}
