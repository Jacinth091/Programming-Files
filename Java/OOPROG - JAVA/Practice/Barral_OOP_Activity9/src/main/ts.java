package main;
import javax.swing.*;
import java.awt.*;

public class ts {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridBagConstraints Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // Create a button and set its preferred size
        JButton button1 = new JButton("Button 1");
//        button1.setPreferredSize(new Dimension(150, 50));
        gbc.gridx = 0; // Column 0
        gbc.gridy = 0; // Row 0
        gbc.weightx = 1.0; // Take extra horizontal space
        gbc.weighty = 0.0; // No extra vertical space
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
        frame.add(button1, gbc);

        // Create another button
        JButton button2 = new JButton("Button 2");
        button2.setPreferredSize(new Dimension(100, 50));
        gbc.gridx = 1; // Column 1
        gbc.gridy = 0; // Row 0
        gbc.weightx = 1.0; // Take extra horizontal space
        gbc.weighty = 0.0; // No extra vertical space
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
        frame.add(button2, gbc);

        // Finalize frame setup
        frame.pack(); // Pack to preferred sizes
        frame.setVisible(true);
    }
}
