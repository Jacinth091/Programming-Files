package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class App extends JFrame {

    private JPanel outerPanel;




    public App(){

    }
    public App(int width, int height, String title, boolean isVisible, boolean isResizable, LayoutManager layout, int defCloseOper)
    {
        this.setPreferredSize(new Dimension(width, height));
        this.setTitle(title);
        this.setResizable(isResizable);
        this.setDefaultCloseOperation(defCloseOper);

        this.setLayout(layout);

        // Call pack() to size the frame to fit the preferred size
        this.pack();

        // Set visibility last to ensure everything is set up correctly
        this.setVisible(isVisible);
    }



    public void initGui(){






    }










    private JPanel createPanel(Color backgroundColor, LayoutManager layout, Dimension preferredSize, boolean opaque) {
        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor);
        panel.setLayout(layout);
        panel.setPreferredSize(preferredSize);
        panel.setOpaque(opaque);
        return panel;
    }

    // Base method for creating a JButton
    private JButton createButton(String text, Color backgroundColor, Color foregroundColor, ActionListener actionListener, String actionCommand) {
        JButton button = new JButton(text);
        button.setBackground(backgroundColor);
        button.setForeground(foregroundColor);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);
        button.setFocusable(false);
        button.addActionListener(actionListener);
        button.setActionCommand(actionCommand);
        return button;
    }

    // Base method for creating a JLabel
    private JLabel createLabel(String text, Color backgroundColor, Color textColor, int fontSize, boolean isBold) {
        JLabel label = new JLabel();
        label.setText("<html><p style='color: " + toHexColor(textColor) + "; font-weight: " + (isBold ? "bold" : "normal") + "; font-size: " + fontSize + "px; text-align: center;'>" + text + "</p></html>");
        label.setOpaque(true);
        label.setBackground(backgroundColor);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

    // Helper method to convert Color to hex string
    private String toHexColor(Color color) {
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }

    // Base method for creating an Inset
    private Insets setInsets(int top, int left, int bottom, int right){
        return new Insets(top,left,bottom,right);
    }
    // Base method for creating a GridBagConstraint
    private GridBagConstraints setGbc(int gridx, int gridy, String anchorLocation, double weightx, double weighty, Insets insets){
        GridBagConstraints gbc = new GridBagConstraints();

        anchorLocation = anchorLocation.toUpperCase();
        int direction;

        switch (anchorLocation.toUpperCase()) {
            case "NORTHWEST":
                direction = GridBagConstraints.NORTHWEST;
                break;
            case "NORTH":
                direction = GridBagConstraints.NORTH;
                break;
            case "NORTHEAST":
                direction = GridBagConstraints.NORTHEAST;
                break;
            case "WEST":
                direction = GridBagConstraints.WEST;
                break;
            case "EAST":
                direction = GridBagConstraints.EAST;
                break;
            case "SOUTHWEST":
                direction = GridBagConstraints.SOUTHWEST;
                break;
            case "SOUTH":
                direction = GridBagConstraints.SOUTH;
                break;
            case "SOUTHEAST":
                direction = GridBagConstraints.SOUTHEAST;
                break;
            default:
                direction = GridBagConstraints.CENTER;
                break;
        }

        gbc.anchor = direction;
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.insets = insets;

        return gbc;
    }




}
