package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test extends JFrame {
    private JPanel bodyPanel;

    public test() {
        // Set up the main frame
        setTitle("Dynamic Panel Example");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.LIGHT_GRAY);
        headerPanel.add(new JLabel("Header"));

        // Create footer panel
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.LIGHT_GRAY);
        footerPanel.add(new JLabel("Footer"));

        // Initialize body panel (it will change dynamically)
        bodyPanel = new JPanel();
        bodyPanel.setBackground(Color.WHITE);
        bodyPanel.add(new JLabel("Welcome! Choose an option below."));

        // Add header, body, and footer to the main frame
        add(headerPanel, BorderLayout.NORTH);
        add(bodyPanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);

        // Add buttons to change content in body panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnPage1 = new JButton("Go to Page 1");
        JButton btnPage2 = new JButton("Go to Page 2");

        btnPage1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadBodyContent("Page 1");
            }
        });

        btnPage2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadBodyContent("Page 2");
            }
        });

        buttonPanel.add(btnPage1);
        buttonPanel.add(btnPage2);
        add(buttonPanel, BorderLayout.WEST);

        setVisible(true);
    }

    // Method to update body panel content dynamically
    private void loadBodyContent(String pageName) {
        bodyPanel.removeAll(); // Clear existing content

        if (pageName.equals("Page 1")) {
            bodyPanel.add(new JLabel("This is Page 1"));
            bodyPanel.setBackground(Color.CYAN); // Change background color for differentiation
        } else if (pageName.equals("Page 2")) {
            bodyPanel.add(new JLabel("This is Page 2"));
            bodyPanel.setBackground(Color.PINK);
        }

        bodyPanel.revalidate(); // Refresh the panel to show updated content
        bodyPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new test());
    }
}
