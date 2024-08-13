package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, leftPressed, rightPressed, downPressed;

    @Override
    public void keyTyped(KeyEvent e) {
        // Not usually used
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        switch(code){
            case KeyEvent.VK_W:
//                System.out.print("You pressed \"W\"! \n");
                upPressed = true;
                break;

            case KeyEvent.VK_A:
//                System.out.print("You pressed \"A\"! \n");
                leftPressed = true;
                break;
            case KeyEvent.VK_S:
//                System.out.print("You pressed \"S\"! \n");
                downPressed = true;
                break;
            case KeyEvent.VK_D:
//                System.out.print("You pressed \"D\"! \n");
                rightPressed = true;
                break;

            default:
//                System.out.println("Not the right buttons!");
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        switch(code){
            case KeyEvent.VK_W:
//                System.out.print("You pressed \"W\"! \n");
                upPressed = false;
                break;

            case KeyEvent.VK_A:
//                System.out.print("You pressed \"A\"! \n");
                leftPressed = false;
                break;
            case KeyEvent.VK_S:
//                System.out.print("You pressed \"S\"! \n");
                downPressed = false;
                break;
            case KeyEvent.VK_D:
//                System.out.print("You pressed \"D\"! \n");
                rightPressed = false;
                break;

            default:
//                System.out.println("Not the right buttons!");
                break;
        }

    }
}
