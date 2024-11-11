import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimatedPanelExample extends JPanel {
    private float deltaTime = 0.016f; // Assuming ~60 FPS
    JLabel label;

    public AnimatedPanelExample() {
//         setDoubleBuffered(true);// 

        // Add a JLabel as an example component on top
        label = new JLabel("I am on top!");
        add(label);

        // Timer to simulate the delta time updates
        Timer timer = new Timer((int)(deltaTime * 1000), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAnimation(); // Update animation logic here
                repaint();         // Repaint panel
            }
        });
        timer.start();
    }

    private void updateAnimation() {
        // Animation or position update logic goes here
        label.setBackground(Color.green);
        label.setBackground(Color.blue);
        label.setBackground(Color.white);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Custom drawing here based on delta time
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Delta Time Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new AnimatedPanelExample());
        frame.setVisible(true);
    }
}

