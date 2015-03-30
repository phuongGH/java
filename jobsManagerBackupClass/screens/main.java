/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import components.GroupCellRenderer;
import components.Job;
import components.JobGroup;
import components.varDefine;
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import static java.awt.GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSLUCENT;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author BB
 *
 * form chính hiển thị các thông tin lịch làm việc hằng ngày.
 *
 */
public class main extends JFrame {

    static TrayIcon trayIcon;
    static private main f;
    static private options fo;
//    private Component component = this.getContentPane();
//    Container contentpane;

    public main() {
        this.setSize(300, 300);
        setBackground(varDefine.Color.translucent);
//        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        setType(Type.UTILITY);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponent();
        initActionListener();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        setLocation(screenSize.width - this.getWidth(), 0);

    }

    // khởi tạo các thành phần của form chính.
    private void initComponent() {
        ShowTrayIcon();
        JPanel panelRoot = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                if (g instanceof Graphics2D) {
                    final int R = 240;
                    final int G = 240;
                    final int B = 240;

                    g.setColor(new Color(R, G, B, 100));
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                }
            }
        };

        JPopupMenu RLPopup = new JPopupMenu("right click");
        JMenuItem rlExit = new JMenuItem("Exit");
        JMenuItem rlMove = new JMenuItem("Move");
        RLPopup.add(rlMove);
        RLPopup.add(rlExit);

        rlExit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });

        panelRoot.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    RLPopup.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        this.setLayout(new BorderLayout());
        add(panelRoot, BorderLayout.CENTER);
        
        Job job1 = new Job("viec 1", "group 1", 1);
        Job job2 = new Job("viec 2", "group 1", 1);
        Job job3 = new Job("viec 3", "group 1", 0);
        Job job4 = new Job("viec 4", "group 2", 0);
        Job job5 = new Job("viec 5", "group 2", 0);
        Job job6 = new Job("viec 6", "group 2", 0);
         Job job7 = new Job("Tiếng việt", "group 2", 0);
        JobGroup jg1 = new JobGroup("group 1");
        jg1.add(job7);
        jg1.add(job2);
        jg1.add(job3);
        jg1.add(job4);
        jg1.add(job5);
        jg1.add(job5);
        jg1.add(job5);
        jg1.add(job5);
        JobGroup jg2 = new JobGroup("group 2");
        jg2.add(job4);
        jg2.add(job5);
        jg2.add(job6);
        JobGroup jg3 = new JobGroup("group 3");
        jg3.add(job2);
        jg3.add(job4);
        jg3.add(job6);
        Object[] ljg = {jg1, jg2,jg3};

        JList list = new JList(ljg);
        list.setCellRenderer(new GroupCellRenderer());
        list.setVisibleRowCount(5);
//        list.setFixedCellHeight(100);
        JScrollPane scrPane = new JScrollPane(list);
        panelRoot.setLayout(new BorderLayout());
        list.setBackground(varDefine.Color.translucent);
//        ListSelectionListener[] ls = list.getListSelectionListeners();
//        for (int i = 0; i < ls.length; i++) {
//            list.removeListSelectionListener(ls[i]);
//        }

//        scrPane.setBackground(Color.GREEN);
        scrPane.setBorder(null);
        panelRoot.add(scrPane, BorderLayout.CENTER);
        panelRoot.setSize(this.getSize());
    }

    private void initActionListener() {

    }

    // hiển thị tray icon và các chức năng điều kiển của tray icon
    public static void ShowTrayIcon() {
        if (!SystemTray.isSupported()) {
            System.out.println("error, your pc sucks");
            System.exit(0);
        }
        trayIcon = new TrayIcon(CreateIcon("/images/icon16.png", "Tray Icon"));
        final PopupMenu popup = new PopupMenu();
        final SystemTray tray = SystemTray.getSystemTray();
        MenuItem trayShow = new MenuItem("Hide");
        popup.add(trayShow);
        MenuItem trayOption = new MenuItem("Options");
        popup.add(trayOption);
        MenuItem trayExit = new MenuItem("Exit");
        popup.add(trayExit);
        trayIcon.setPopupMenu(popup);
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {

        }

        trayExit.addActionListener((ActionEvent e) -> {
            int reply = JOptionPane.showConfirmDialog(null, "Really Quit?", "Exit", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        trayShow.addActionListener((ActionEvent e) -> {
            if (f.isShowing()) {
                f.hide();
                trayShow.setLabel("Show");
            } else {
                f.show();
                trayShow.setLabel("Hide");
            }

        });

        trayOption.addActionListener((ActionEvent e) -> {
            fo.show();
        });
    }

    // trả về hình ảnh khi truyền vào tham số đường dẫn và chú thích
    protected static Image CreateIcon(String path, String desc) {
        URL imageURL = main.class.getResource(path);
        return (new ImageIcon(imageURL, desc).getImage());
    }

    // hàm chính chạy chương trình
//    public static void main(String[] args) {
//        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//        GraphicsDevice gd = ge.getDefaultScreenDevice();
//        boolean isPerPixelTranslucencySupported
//                = gd.isWindowTranslucencySupported(PERPIXEL_TRANSLUCENT);
//        //If translucent windows aren't supported, exit.
//        if (!isPerPixelTranslucencySupported) {
//            System.out.println(
//                    "Per-pixel translucency is not supported");
//            System.exit(0);
//        }
//        JFrame.setDefaultLookAndFeelDecorated(true);
//        f = new main();
//        fo = new options();
//        f.show();
//    }

}
