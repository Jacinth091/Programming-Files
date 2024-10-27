package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test2 extends JFrame {
    private JPanel cardContainer;
    private CardLayout cardLayout;

    public test2() {
        setTitle("Dynamic CardLayout Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize CardLayout and container panel
        cardLayout = new CardLayout();
        cardContainer = new JPanel(cardLayout);

        // Initialize panels
        JPanel mainPanel = createMainPanel();
        JPanel confirmPanel = createConfirmPanel();

        // Add panels to the card container
        cardContainer.add(mainPanel, "MainPanel");
        cardContainer.add(confirmPanel, "ConfirmPanel");

        add(cardContainer);
        cardLayout.show(cardContainer, "MainPanel");
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Select an item and click 'Confirm':");
        JButton confirmButton = new JButton("Confirm");
        JComboBox<String> itemComboBox = new JComboBox<>(new String[]{"Item A", "Item B", "Item C"});

        mainPanel.add(label, BorderLayout.NORTH);
        mainPanel.add(itemComboBox, BorderLayout.CENTER);
        mainPanel.add(confirmButton, BorderLayout.SOUTH);

        // Confirm button action
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get selected item
                String selectedItem = (String) itemComboBox.getSelectedItem();

                // Pass data to confirm panel
                updateConfirmPanel(selectedItem);

                // Show the confirm panel
                cardLayout.show(cardContainer, "ConfirmPanel");
            }
        });

        return mainPanel;
    }

    private JPanel createConfirmPanel() {
        JPanel confirmPanel = new JPanel();
        confirmPanel.setLayout(new BorderLayout());

        JLabel confirmLabel = new JLabel();
        confirmLabel.setHorizontalAlignment(SwingConstants.CENTER);
        confirmLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JButton backButton = new JButton("Back");

        confirmPanel.add(confirmLabel, BorderLayout.CENTER);
        confirmPanel.add(backButton, BorderLayout.SOUTH);

        // Back button action to return to the main panel
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardContainer, "MainPanel");
            }
        });

        // Store the label in the panel's client properties so it can be updated
        confirmPanel.putClientProperty("confirmLabel", confirmLabel);

        return confirmPanel;
    }

    private void updateConfirmPanel(String selectedItem) {
        // Retrieve the confirm panel and label component
        JPanel confirmPanel = (JPanel) cardContainer.getComponent(1);
        JLabel confirmLabel = (JLabel) confirmPanel.getClientProperty("confirmLabel");

        // Update the label text with the selected item data
        confirmLabel.setText("You selected: " + selectedItem);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            test2 frame = new test2();
            frame.setVisible(true);
        });
    }
}
