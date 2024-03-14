/*
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class testing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}

class MainFrame extends JFrame {
    final int windowWidth = 450;
    final int windowHeight = 450;

    MainFrame() {
        setTitle("My Simple Calculator");
        setSize(windowWidth, windowHeight);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel num1Label = new JLabel("Number 1:");
        JTextField num1Field = new JTextField();

        JLabel num2Label = new JLabel("Number 2:");
        JTextField num2Field = new JTextField();

        JLabel resultLabel = new JLabel("Result:");
        JTextField resultField = new JTextField();
        resultField.setEditable(false);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(num1Field.getText());
                    int num2 = Integer.parseInt(num2Field.getText());
                    int result = num1 + num2; // Change this calculation as needed
                    resultField.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    resultField.setText("Invalid input");
                }
            }
        });

        inputPanel.add(num1Label);
        inputPanel.add(num1Field);
        inputPanel.add(num2Label);
        inputPanel.add(num2Field);
        inputPanel.add(resultLabel);
        inputPanel.add(resultField);

        add(inputPanel, BorderLayout.CENTER);
        add(calculateButton, BorderLayout.SOUTH);
    }
}
*/
/*
import javax.swing.*;

public class testing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Placement Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding buttons directly to the content pane of the JFrame
        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        frame.getContentPane().add(addButton);
        frame.getContentPane().add(editButton);
        frame.getContentPane().add(deleteButton);

        // Alternatively, adding buttons to a JPanel
        JPanel buttonPanel = new JPanel();
        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        frame.getContentPane().add(buttonPanel);

        frame.pack();
        frame.setVisible(true);
    }
}
*/
/*import javax.swing.*;
import java.awt.*;

public class testing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,500));

        JPanel panel = new JPanel(new GridLayout(2, 2));

        // Create a button with text
        JButton button = new JButton("Button");

        // Create an empty border with specific insets to adjust the size of the button
        Insets insets = new Insets(10, 20, 10, 20); // Adjust insets as needed
        button.setBorder(BorderFactory.createEmptyBorder(insets.top, insets.left, insets.bottom, insets.right));

        // Add the button to the panel
        panel.add(button);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}*/

/*import javax.swing.*;
import java.awt.*;

public class testing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BoxLayout Example");
        frame.setPreferredSize(new Dimension(500,500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel to hold the components
        JPanel panel = new JPanel();

        // Set the layout manager of the panel to BoxLayout with vertical orientation
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create components (e.g., buttons)
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");

        // Add components to the panel
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        // Add the panel to the content pane of the JFrame
        frame.getContentPane().add(panel);

        // Pack the frame to fit its components
        frame.pack();

        // Make the frame visible
        frame.setVisible(true);
    }
}*/
import javax.swing.*;
import java.awt.*;

public class testing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FlowLayout.CENTER Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 500));

        // Create a JPanel to hold the components
        JPanel panel = new JPanel();

        // Set the layout manager of the panel to BoxLayout with vertical orientation
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create components (e.g., buttons)
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");

        // Add components to the panel
        panel.add(Box.createVerticalGlue()); // Add vertical glue to center-align components
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(Box.createVerticalGlue()); // Add vertical glue to center-align components

        // Add the panel to the content pane of the JFrame
        frame.getContentPane().add(panel);

        // Pack the frame to fit its components
        frame.pack();

        // Make the frame visible
        frame.setVisible(true);
    }
}



