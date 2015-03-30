package simple_minigame;

import data.fileManager;
import data.logManager;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;
import materials.circleButton;

public class gamesManager extends JFrame implements ActionListener {

    private final JPanel screen = new JPanel();
    private final JLabel lblBg = new JLabel();
    private final JButton btnUp = new circleButton();
    private final JButton btnDown = new circleButton();
    private final JButton btnLeft = new circleButton();
    private final JButton btnRight = new circleButton();
    private final JButton btnOK = new circleButton();
    private gamesControl game;
//    private Timer timer;
    private static gamesManager gm;

    private gamesManager() {
        init();
    }

    public static gamesManager getGamesManager() {
        if (gm == null) {
            logManager.emptyLog();
            logManager.writeLog("create game mameger");
            gm = new gamesManager();
        }
        return gm;
    }
    
    private JLabel lblHighCode = new JLabel();
    private JLabel lblLevel = new JLabel();
    private JLabel lblLevelValue = new JLabel();
    private JLabel lblRanking = new JLabel();
    private JLabel lblRankingValue = new JLabel();
    private JLabel lblCode = new JLabel();
    private JLabel lbllive = new JLabel();
    private JLabel lblliveValue = new JLabel();
    /*
     *  key action
     *
     */
    Action actionKeyUp = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            game.upClick();
        }
    };

    Action actionKeyDown = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            game.downClick();
        }
    };

    Action actionKeyLeft = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            game.leftClick();
        }
    };

    Action actionKeyRight = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            game.rightClick();
        }
    };

    Action actionKeyEnter = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            game.okClick();
        }
    };

    /*
     *   contructor gui game
     */
    private void init() {

        this.getContentPane().setLayout(null);
        this.setTitle("mini game");
        this.setSize(410, 638);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                logManager.writeLog("\n close game!\n\n\n\n");
                System.exit(0);
            }
        });
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        setbutton();
        setBg();
        addAction();

    }

    /*
     *   set background of ui
     */
    private synchronized void setBg() {
        try {
            lblBg.setIcon(new ImageIcon(ImageIO.read(new File("src\\images\\bg.png"))));
        } catch (IOException ex) {
            Logger.getLogger(gamesManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblBg.setLocation(2, 4);
        lblBg.setSize(400, 600);
        this.getContentPane().add(lblBg);
    }

    /*
     *   create buttons control
     */
    private synchronized void setbutton() {
        btnUp.setSize(45, 45);
        btnUp.setBackground(Color.YELLOW);
        btnUp.setLocation(90, 465);
        this.getContentPane().add(btnUp);

        btnDown.setSize(45, 45);
        btnDown.setBackground(Color.YELLOW);
        btnDown.setLocation(90, 545);
        this.getContentPane().add(btnDown);

        btnLeft.setSize(45, 45);
        btnLeft.setBackground(Color.YELLOW);
        btnLeft.setLocation(40, 505);
        this.getContentPane().add(btnLeft);

        btnRight.setSize(45, 45);
        btnRight.setBackground(Color.YELLOW);
        btnRight.setLocation(140, 505);
        this.getContentPane().add(btnRight);

        btnOK.setSize(65, 55);
        btnOK.setBackground(Color.YELLOW);
        btnOK.setLocation(280, 495);
        this.getContentPane().add(btnOK);

        screen.setSize(210, 350);
        screen.setLocation(60, 74);
        screen.setBorder(new LineBorder(Color.black, 4, false));
        screen.setOpaque(false);
        screen.setLayout(null);
        //screen.setBackground(new Color(0,0,0,0));
        this.getContentPane().add(screen);

        createGame();

    }

    public void changeInfo() {
        lblHighCode.setText("HIGH CODE "+ String.valueOf(game.getHighCode()));
        lblCode.setText("CODE "+String.valueOf(game.getCode()));
        lblRankingValue.setText(String.valueOf(game.getRanking()));
        lblliveValue.setText(String.valueOf(game.getLive()));
        lblLevelValue.setText(String.valueOf(game.getLevel()));
    }

    private void setInfo() {
        
        
        lblHighCode.setText("HIGH CODE "+ String.valueOf(game.getHighCode()));
        lblHighCode.setForeground(Color.black);
        lblHighCode.setSize(120, 50);
        lblHighCode.setLocation(140, 20);
        this.getContentPane().add(lblHighCode);
        
        lblCode.setText("CODE "+String.valueOf(game.getCode()));
        lblCode.setForeground(Color.black);
        lblCode.setSize(80, 50);
        lblCode.setLocation(270, 20);
        this.getContentPane().add(lblCode);

        lbllive.setText("LIVE");
        lbllive.setSize(80, 50);
        lbllive.setLocation(290, 110);
        this.getContentPane().add(lbllive);

        lblliveValue.setText("");
        lblliveValue.setSize(80, 50);
        lblliveValue.setLocation(300, 130);
        this.getContentPane().add(lblliveValue);

        lblRanking.setText("RANKING");
        lblRanking.setSize(80, 50);
        lblRanking.setLocation(290, 200);
        this.getContentPane().add(lblRanking);

        lblRankingValue.setText("");
        lblRankingValue.setSize(80, 50);
        lblRankingValue.setLocation(300, 220);
        this.getContentPane().add(lblRankingValue);

        lblLevel.setText("LEVEL");
        lblLevel.setSize(80, 50);
        lblLevel.setLocation(290, 290);
        this.getContentPane().add(lblLevel);

        lblLevelValue.setText("");
        lblLevelValue.setSize(80, 50);
        lblLevelValue.setLocation(300, 310);
        this.getContentPane().add(lblLevelValue);
    }

    //create new game
    private void createGame() {
//        fileManager fm = new fileManager();
//        fm.writeInfo();

        game = new race();
        screen.add((Component) game);
        setInfo();
    }

    private void addAction() {
        btnLeft.addActionListener((ActionListener) this);
        btnRight.addActionListener((ActionListener) this);
        btnOK.addActionListener((ActionListener) this);
        btnDown.addActionListener((ActionListener) this);
        btnUp.addActionListener((ActionListener) this);

        JPanel content = (JPanel) this.getContentPane();
        InputMap inputMap = content.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

        KeyStroke down = KeyStroke.getKeyStroke("DOWN");
        inputMap.put(down, "KEY_DOWN");
        inputMap.put(KeyStroke.getKeyStroke("S"), "KEY_DOWN");
        content.getActionMap().put("KEY_DOWN", actionKeyDown);

        inputMap.put(KeyStroke.getKeyStroke("UP"), "KEY_UP");
        inputMap.put(KeyStroke.getKeyStroke("W"), "KEY_UP");
        content.getActionMap().put("KEY_UP", actionKeyUp);

        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "KEY_LEFT");
        inputMap.put(KeyStroke.getKeyStroke("A"), "KEY_LEFT");
        content.getActionMap().put("KEY_LEFT", actionKeyLeft);

        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "KEY_RIGHT");
        inputMap.put(KeyStroke.getKeyStroke("D"), "KEY_RIGHT");
        content.getActionMap().put("KEY_RIGHT", actionKeyRight);

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "KEY_OK");
        content.getActionMap().put("KEY_OK", actionKeyEnter);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnLeft)) {
            game.leftClick();
        }
        if (e.getSource().equals(btnRight)) {
            game.rightClick();
        }
        if (e.getSource().equals(btnOK)) {
            game.okClick();
        }
        if (e.getSource().equals(btnDown)) {
            game.downClick();
        }
        if (e.getSource().equals(btnUp)) {
            game.upClick();
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        gm = gamesManager.getGamesManager();

    }

}
