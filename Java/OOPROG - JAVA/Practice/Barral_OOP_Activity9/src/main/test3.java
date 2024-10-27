import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test3 {

    // Main frame
    public static class MainFrame extends JFrame {
        private JTextField inputField;
        private JButton openButton;

        public MainFrame() {
            setTitle("Main Frame");
            setSize(300, 150);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new FlowLayout());

            inputField = new JTextField(15);
            openButton = new JButton("Open Second Frame");

            add(new JLabel("Enter some text:"));
            add(inputField);
            add(openButton);

            // Action listener for the button
            openButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String inputText = inputField.getText();
                    SecondFrame secondFrame = new SecondFrame(inputText);
                    secondFrame.setVisible(true); // Show the second frame
                }
            });
        }
    }

    // Second frame
    public static class SecondFrame extends JFrame {
        public SecondFrame(String text) {
            setTitle("Second Frame");
            setSize(300, 100);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLayout(new FlowLayout());

            JLabel displayLabel = new JLabel("You entered: " + text);
            add(displayLabel);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
