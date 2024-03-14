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
