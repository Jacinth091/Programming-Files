package Events;

import main.MainPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener, MouseMotionListener {

    protected int mouseX, mouseY;
    private boolean isDragging = false;
    private boolean isClicking = false;
    private boolean isMoving = false;

    protected MainPanel mp;

    public MouseInput(MainPanel mp) {
        this.mp = mp;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Handle mouse click event if needed
        isClicking = true; // Set clicking status to true
        System.out.println("CLicked at: (" + e.getX() + ", " + e.getY() + ")");

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Pressed at: (" + e.getX() + ", " + e.getY() + ")");
        isClicking = true; // Set clicking status to true
        isDragging = false; // Reset dragging status on press
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Released at: (" + e.getX() + ", " + e.getY() + ")");
        if (isClicking) {
            System.out.println("Mouse clicked!");
        }
        isClicking = false; // Reset clicking status
        isDragging = false; // Reset dragging status
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse has Entered!");
        mouseMoved(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse has Exited!");
        isMoving = false; // Reset moving status
        isDragging = false; // Reset dragging status when mouse exits
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        isDragging = true; // Set dragging status
//        System.out.println("Dragging at: (" + mouseX + ", " + mouseY + ")");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        isMoving = true; // Set moving status
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.white);
        String status = isDragging ? "Dragging" :
                isClicking ? "Clicking" :
                        isMoving ? "Moving" : "Idle";

        String format = String.format("Mouse x: %d Mouse Y: %d Status: %s", mouseX, mouseY, status);
        g2.drawString(format, 10, 20);
    }
}
