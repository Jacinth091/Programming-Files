import javax.swing.*;
import java.awt.*;

public class testing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Centered JLabel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JLabel with centered text using HTML formatting
        JLabel centeredLabel = new JLabel("<html><div style='text-align: center;'>Centered Text</div></html>");

        // Set horizontal alignment to center
        centeredLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Add the JLabel to the frame
        frame.getContentPane().add(centeredLabel);

        frame.pack();
        frame.setSize(new Dimension(420,420));
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
}
