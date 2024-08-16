package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManager implements KeyListener {
    public boolean upPressed, downPressed, rightPressed, leftPressed;

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used, can be left empty
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        boolean eventValue = true;
        keyEvents(eventValue, keyCode);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        boolean eventValue = false;
        keyEvents(eventValue, keyCode);

    }

    public void keyEvents(boolean eventValue, int keyCode){
        switch (keyCode) {
            case KeyEvent.VK_W:
                upPressed = eventValue;
                break;
            case KeyEvent.VK_S:
                downPressed = eventValue;
                break;
            case KeyEvent.VK_A:
                leftPressed = eventValue;
                break;
            case KeyEvent.VK_D:
                rightPressed = eventValue;
                break;
        }
    }
}
