package main;

import javax.swing.*;
import java.awt.*;

public class t{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(t::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Tourist Spots in Cebu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Create a panel to hold the tourist spots
        JPanel touristSpotPanel = new JPanel();
        touristSpotPanel.setLayout(new BoxLayout(touristSpotPanel, BoxLayout.Y_AXIS)); // Vertical layout

        // Sample data for 10 tourist spots
        for (int i = 0; i < 10; i++) {
            String placeTitle = "Tourist Spot " + (i + 1);
            String placeDesc = "Description for " + placeTitle;
            String placeType = "Type: Park";
            String placeAddress = "Address: Location " + (i + 1);
            String suggestedVehicle = "Suggested Vehicle: Car";
            ImageIcon placeImage = new ImageIcon("src/assets/places/" + i + ".jpg"); // Assuming images are named 0.jpg, 1.jpg, etc.

            // Create a PlaceCard (or similar component) and add it to the panel
            PlaceCard placeCard = new PlaceCard(suggestedVehicle, placeAddress, placeType, placeDesc, placeTitle, placeImage);
            touristSpotPanel.add(placeCard);
        }

        // Create a JScrollPane and add the panel to it
        JScrollPane scrollPane = new JScrollPane(touristSpotPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Always show vertical scrollbar

        // Add the JScrollPane to the frame
        frame.add(scrollPane);
        frame.setVisible(true);
    }
}
