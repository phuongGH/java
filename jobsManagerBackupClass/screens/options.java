/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import components.Lang;
import components.LineLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author BB
 *
 * form giúp cho việc điều kiển thay đổi hiển thị thêm thông tin hiển thị cho
 * form chính.
 *
 */
public class options extends JFrame {

    private JPanel panel;
    private JPanel HeadPanel;       //thanh tiêu đề
    private JPanel ContentPanel;    //phần chứa nội dung
    private JTabbedPane wrap = new JTabbedPane();
    private JPanel panelFont;

    public options() throws HeadlessException {
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        initComponent();

    }

    private synchronized void initComponent() {
        List<Image> icons = new ArrayList<>();
        icons.add(new ImageIcon("src/images/icon16.png").getImage());
        icons.add(new ImageIcon("src/images/icon32.png").getImage());
        this.setIconImages(icons);
        panel = new JPanel();
//        panel.setBackground(Color.BLUE);
        panel.setLayout(new BorderLayout());
        HeadPanel = new JPanel();
        HeadPanel.setBackground(Color.red);
        HeadPanel.setPreferredSize(new Dimension(100, 30));
        HeadPanel.setLayout(new BorderLayout());
        JButton btnClose = new JButton(Lang.getLanguage("btnClose", "eng.txt"));
        HeadPanel.add(btnClose, BorderLayout.EAST);
        panel.add(HeadPanel, BorderLayout.NORTH);
        setLayout(new BorderLayout());
        add(panel);
        ContentPanel = new JPanel();
        panel.add(ContentPanel, BorderLayout.CENTER);
        panelFont = new JPanel();
        wrap.addTab(Lang.getLanguage("font_tab", "eng.txt"), panelFont);
        ContentPanel.setLayout(new BorderLayout());
        ContentPanel.add(wrap, BorderLayout.CENTER);

//        panelFont
        BorderLayout bl = new BorderLayout();
        panelFont.setLayout(bl);
        JPanel panelFontView = new JPanel();
        panelFontView.setBackground(Color.GREEN);
        JPanel panelFontOption = new JPanel();
        panelFontOption.setBackground(Color.BLUE);
        panelFont.add(panelFontView, BorderLayout.WEST);
        panelFont.add(panelFontOption, BorderLayout.CENTER);
        panelFontView.setPreferredSize(new Dimension(150, 20));
        String[] str = {"title 1", "title2", "title 3"};
        JList list = new JList(str);
        JScrollPane scrPane = new JScrollPane(list);
        scrPane.setPreferredSize(new Dimension(150, 400));
        panelFontView.add(scrPane);

//        for(int i=0; i< 4; i++)
//        {
//            JPanel panel1 = new JPanel();
//            JLabel lbl = new JLabel("Title " + (i+1));
//            JLabel lbl1 = new JLabel("Content 1");
//            JLabel lbl2 = new JLabel("Content 2");
//            JLabel lbl3 = new JLabel("Content 3");
//            JLabel lbl4 = new JLabel("Content 4");
//            panel1.setLayout(new BorderLayout());
//            panel1.add(lbl,BorderLayout.NORTH);
//            panel1.add(lbl1,BorderLayout.CENTER);
//            panel1.add(lbl2,BorderLayout.CENTER);
//            panel1.add(lbl3,BorderLayout.CENTER);
//            panel1.add(lbl4,BorderLayout.CENTER);
//            panelFontView.add(panel1);
//        }
//        panelFontOption
//        JPanel panelShow = new JPanel();
//        panelShow.setLayout(new LineLayout());
//        JLabel lblShowTitle = new JLabel("Title");
//        JLabel lblShowContent1 = new JLabel("content 1");
//        JLabel lblShowContent2 = new JLabel("content 2");
//        JLabel lblShowContent3 = new JLabel("content 3");
//      
        JPanel panelInfo = new JPanel();
        JPanel panelTitle = new JPanel();
        JPanel panelContent = new JPanel();
        JLabel lblTitleInfo = new JLabel("Title 1");

        panelFontOption.setLayout(new LineLayout());
        panelFontOption.add(panelInfo);
        panelFontOption.add(panelTitle);
        panelFontOption.add(panelContent);

        panelInfo.add(lblTitleInfo);

//        panelTitle
        JLabel lblTitle = new JLabel("Title");
        JLabel lblFontCode = new JLabel("Font");
        String[] fonts = {"Arial", "Times New Roman"};
        JComboBox cbFont = new JComboBox(fonts);
        JLabel lblFontSize = new JLabel("Font Size");
        String[] fontSize = {"8", "9", "10", "11", "12", "14", "16", "18", "24", "36", "72"};
        JComboBox cbFontSize = new JComboBox(fontSize);
        JLabel lblFontStyle = new JLabel("Font Style");
        String[] fontStyle = {"Regular", "Bold", "Italic"};
        JComboBox cbFontStyle = new JComboBox(fontStyle);
        JLabel lblFontColor = new JLabel("Font Color");
        JButton btnChoseColor = new JButton("Chose Color");
//        JColorChooser cc = new JColorChooser();

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        panelTitle.setLayout(new GridBagLayout());
        gridBagConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new Insets(3, 10, 3, 10);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panelTitle.add(lblTitle, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panelTitle.add(lblFontCode, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        panelTitle.add(cbFont, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        panelTitle.add(lblFontSize, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        panelTitle.add(cbFontSize, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        panelTitle.add(lblFontStyle, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        panelTitle.add(cbFontStyle, gridBagConstraints);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        panelTitle.add(lblFontColor, gridBagConstraints);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        panelTitle.add(btnChoseColor, gridBagConstraints);

        
        JLabel lblContent = new JLabel("Content");
        panelContent.setLayout(new GridBagLayout());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panelContent.add(lblContent, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panelContent.add(lblFontCode, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        panelContent.add(cbFont, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        panelContent.add(lblFontSize, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        panelContent.add(cbFontSize, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        panelContent.add(lblFontStyle, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        panelContent.add(cbFontStyle, gridBagConstraints);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        panelContent.add(lblFontColor, gridBagConstraints);

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        panelContent.add(btnChoseColor, gridBagConstraints);
        
        
        btnChoseColor.addActionListener((ActionEvent e) -> {
            Color bgColor
                    = JColorChooser.showDialog(this,"Choose Background Color",
                            getBackground());
            if(bgColor!=null)
            {
                System.out.println(bgColor);
            }
        });

        btnClose.addActionListener((ActionEvent e) -> {
//            this.hide();
            System.exit(0);
        });
//        setUndecorated(true);
    }

}
