package Events;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

    int keyCode;

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyCode = e.getKeyCode();

        switch(keyCode){
            case KeyEvent.VK_W:
                upPressed = true;
//                System.out.println("You pressed W!");
                break;
            case KeyEvent.VK_A:
                leftPressed = true;
//                System.out.println("You pressed A!");
                break;
            case KeyEvent.VK_S:
                downPressed = true;
//                System.out.println("You pressed S!");
                break;
            case KeyEvent.VK_D:
                rightPressed = true;
//                System.out.println("You pressed D!");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyCode = e.getKeyCode();

        switch(keyCode){
            case KeyEvent.VK_W:
                upPressed = false;
//                System.out.println("You released key W!");
                break;
            case KeyEvent.VK_A:
                leftPressed = false;

//                System.out.println("You released key A!");
                break;
            case KeyEvent.VK_S:
                downPressed = false;

//                System.out.println("You released key S!");
                break;
            case KeyEvent.VK_D:
                rightPressed = false;

//                System.out.println("You released key D!");
                break;
        }
    }
}
