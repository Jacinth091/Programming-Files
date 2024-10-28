package main;

import javax.swing.*;
import java.awt.*;

public class tessst extends JFrame {
    public tessst(String userName, String selPlaceName, String selPlaceAddress, String selVhItem) {
        // Frame properties
        setTitle("Booking Status");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 1)); // 4 rows for each information field

        // Create panels for each information
        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel placePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel addressPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel vehiclePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Create and add labels for each information
        userPanel.add(new JLabel("Username: " + userName));
        placePanel.add(new JLabel("Place: " + selPlaceName));
        addressPanel.add(new JLabel("Address: " + selPlaceAddress));
        vehiclePanel.add(new JLabel("Selected Vehicle: " + selVhItem));

        // Add panels to the frame
        add(userPanel);
        add(placePanel);
        add(addressPanel);
        add(vehiclePanel);

        // Display the frame
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    public static void main(String[] args) {
        // Example data
        String userName = "Jacinth";
        String selPlaceName = "Mars";
        String selPlaceAddress = "Milky Way Galaxy";
        String selVhItem = "Spaceship";

        // Create and show the frame
        new tessst(userName, selPlaceName, selPlaceAddress, selVhItem);
    }
}
