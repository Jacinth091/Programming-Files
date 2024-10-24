package Events;

import main.MainPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener , MouseMotionListener {

    protected int mouseX, mouseY;
    protected int x,y;
    private boolean isDragging =false;
    private boolean isMoving =false;
/*
    private boolean isClicking = false;
    private boolean isPressing = false;
    private boolean isReleased = false;
    private boolean isReleased = false;
*/


    protected MainPanel mp;

    public MouseInput(MainPanel mp){
        this.mp = mp;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        System.out.println("clicked");

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("pressed");

        if(isMoving){
            isDragging = true;
            mouseDragged(e);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("released");
        isDragging = false;

    }


    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse has Entered!");
        mouseMoved(e);
    }
    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse has Exited!");
        isMoving =false;
    }






    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        isMoving =true;
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public void pointedObject(){




    }



    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        String status = isMoving && !isDragging ? "Moving" :
                isMoving && isDragging ? "Dragging" :
                        "Mouse exited";
        String format = String.format("Mouse x: %d Mouse Y: %d Status: %s", mouseX, mouseY,status );



        g2.drawString(format, 10, 20);


    }
}
