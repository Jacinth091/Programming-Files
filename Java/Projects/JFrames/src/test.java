import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class test extends JFrame {
    private JButton[] buttons;

    public test() {
        super("Multiple Buttons Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Number of buttons to create
        int numButtons = 5;

        // Initialize the array of buttons
        buttons = new JButton[numButtons];

        // Layout manager for the frame
        setLayout(new FlowLayout());

        // Create and add buttons using a for loop
        for (int i = 0; i < numButtons; i++) {
            buttons[i] = new JButton("Button " + (i + 1)); // Create button
            buttons[i].addActionListener(new ButtonActionListener()); // Add action listener
            add(buttons[i]); // Add button to frame
        }
        buttons[1].setBackground(Color.green);

        setSize(300, 200);
        setVisible(true);
    }

    // Action listener for buttons
    private class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource(); // Get the button that triggered the event
            // Perform different actions based on which button was clicked
            if (source == buttons[0]) {
                // Code for button 1
                System.out.println("Button 1 clicked");
            } else if (source == buttons[1]) {
                // Code for button 2
                System.out.println("Button 2 clicked");
            }else if (source == buttons[2]) {
                // Code for button 2
                System.out.println("BOBO");
            }else if (source == buttons[3]) {
                // Code for button 2
                System.out.println("TANGA");
            }else if (source == buttons[4]) {
                // Code for button 2
                System.out.println("INUTIL");
            }
            // Add more conditions for other buttons as needed
        }
    }

    public static void main(String[] args) {
        new test();
//        SwingUtilities.invokeLater(() -> new test());
    }
}
