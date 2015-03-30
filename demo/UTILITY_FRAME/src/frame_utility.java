
import java.awt.Dimension;
import java.awt.HeadlessException;
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
public class frame_utility extends JFrame{

    public frame_utility() throws HeadlessException {
        initComponent();
    }
    
    private void initComponent(){
        setMinimumSize(new Dimension(600,400));
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setType(Type.UTILITY);
//        setUndecorated(true);
//        setDefaultLookAndFeelDecorated(true);
    }
}
