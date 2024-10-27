package main.objects;

import javax.swing.*;
import java.awt.*;

public class test2 extends JPanel {
    private JPanel bodyPanel;  // Body panel with CardLayout to switch content
    private CardLayout cardLayout;

    public test2() {
        setLayout(new BorderLayout());

        // Create header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.LIGHT_GRAY);
        headerPanel.add(new JLabel("Header"));

        // Create footer panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.LIGHT_GRAY);
        footerPanel.add(new JLabel("Footer"));

        // Initialize body panel with CardLayout
        cardLayout = new CardLayout();
        bodyPanel = new JPanel(cardLayout);

        // Add different content panels to the bodyPanel
        bodyPanel.add(createPagePanel("Welcome! Choose an option below."), "Welcome");
        bodyPanel.add(createPagePanel("This is Page 1"), "Page 1");
        bodyPanel.add(createPagePanel("This is Page 2"), "Page 2");

        // Add header, body, and footer to MainPanel
        add(headerPanel, BorderLayout.NORTH);
        add(bodyPanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);

        // Add navigation buttons to control the displayed card in bodyPanel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnPage1 = new JButton("Go to Page 1");
        JButton btnPage2 = new JButton("Go to Page 2");

        btnPage1.addActionListener(e -> showPage("Page 1"));
        btnPage2.addActionListener(e -> showPage("Page 2"));

        buttonPanel.add(btnPage1);
        buttonPanel.add(btnPage2);
        add(buttonPanel, BorderLayout.WEST);
    }

    // Helper method to create individual page panels
    private JPanel createPagePanel(String labelText) {
        JPanel panel = new JPanel();
        panel.add(new JLabel(labelText));
        return panel;
    }

    // Method to switch between cards in the body panel
    private void showPage(String pageName) {
        cardLayout.show(bodyPanel, pageName);
    }

    // Main method to display MainPanel in a JFrame for testing
    public static void main(String[] args) {
        JFrame frame = new JFrame("Main Panel with Dynamic Body Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.add(new test2());
        frame.setVisible(true);
    }
}
