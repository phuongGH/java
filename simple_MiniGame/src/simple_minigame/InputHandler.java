package simple_minigame;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class InputHandler implements KeyListener {

    @Override
    public void keyTyped(KeyEvent kt) {
        System.out.println(kt.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent kp) {
        System.out.println("kp");
    }

    @Override
    public void keyReleased(KeyEvent kr) {
        System.out.println(kr.getKeyChar());
    }
}
