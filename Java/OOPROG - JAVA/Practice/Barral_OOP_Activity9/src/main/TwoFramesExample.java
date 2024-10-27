package main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TwoFramesExample {

    // Helper class for common GUI functions
    static class Helper {
        public JPanel createPanel(Color color, LayoutManager layout, boolean isVisible) {
            JPanel panel = new JPanel();
            panel.setBackground(color);
            panel.setLayout(layout);
            panel.setVisible(isVisible);
            return panel;
        }

        public BorderLayout setBorderLayout(int hgap, int vgap) {
            return new BorderLayout(hgap, vgap);
        }

        public EmptyBorder createEmptyBorder(int top, int left, int bottom, int right) {
            return new EmptyBorder(top, left, bottom, right);
        }
    }

    private static class MainFrame extends JFrame {
        private JPanel parentPanel;
        private Helper helper = new Helper();
        private SecondFrame secondFrame;

        public MainFrame() {
            setTitle("Main Frame");
            setSize(400, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            initGui(this);
        }

        // Method to initialize GUI
        public void initGui(JFrame frame) {
            // Create parent panel
            parentPanel = helper.createPanel(Color.white, helper.setBorderLayout(5, 5), true);
            parentPanel.setBorder(helper.createEmptyBorder(5, 5, 5, 5));

            // Create a button to open the second frame
            JButton openButton = new JButton("Open Second Frame");
            openButton.addActionListener(e -> {
                if (secondFrame == null) {
                    secondFrame = new SecondFrame(this); // Pass the main frame to the second frame
                }
                secondFrame.setVisible(true); // Show the second frame
                this.setVisible(false); // Hide the main frame
            });

            // Add components
            parentPanel.add(openButton, BorderLayout.CENTER);
            frame.add(parentPanel);
        }
    }

    private static class SecondFrame extends JFrame {
        private JPanel parentPanel;
        private Helper helper = new Helper();
        private MainFrame mainFrame;

        public SecondFrame(MainFrame mainFrame) {
            this.mainFrame = mainFrame; // Reference to the main frame
            setTitle("Second Frame");
            setSize(400, 200);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            initGui();
        }

        // Method to initialize GUI
        public void initGui() {
            parentPanel = helper.createPanel(Color.lightGray, helper.setBorderLayout(5, 5), true);
            parentPanel.setBorder(helper.createEmptyBorder(5, 5, 5, 5));

            // Create a label to display information
            JLabel label = new JLabel("This is the second frame.");
            parentPanel.add(label, BorderLayout.CENTER);

            // Create a back button to return to the first frame
            JButton backButton = new JButton("Back to Main Frame");
            backButton.addActionListener(e -> {
                this.setVisible(false); // Hide the second frame
                mainFrame.setVisible(true); // Show the main frame
            });

            parentPanel.add(backButton, BorderLayout.SOUTH); // Add back button at the bottom

            add(parentPanel);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
