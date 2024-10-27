package main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class Helper {

    protected Border defaultBorder = createLineBorder(Color.WHITE, 5);


    public Helper(){

    }





    public Border createLineBorder(Color lineColor, int thickness){
        return BorderFactory.createLineBorder(lineColor, thickness);
    }


    public Border createEmptyBorder(int top, int left, int bottom, int right){
        return BorderFactory.createEmptyBorder(top, left, bottom, right);
    }


    public static Border createCompoundBorder(Color lineColor, int thickness, int top, int left, int bottom, int right) {
        Border lineBorder = BorderFactory.createLineBorder(lineColor, thickness);
        Border emptyBorder = BorderFactory.createEmptyBorder(top, left, bottom, right);
        return BorderFactory.createCompoundBorder(lineBorder, emptyBorder);
    }

    public JPanel createPanel(LayoutManager layout, boolean opaque, boolean isVisible) {
        JPanel panel = new JPanel();
        panel.setVisible(isVisible);
        panel.setLayout(layout);
        panel.setOpaque(opaque);
        return panel;
    }

    public JPanel createPanel(Color backgroundColor, LayoutManager layout, boolean opaque) {
        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor);
        panel.setLayout(layout);
        panel.setOpaque(opaque);
        return panel;
    }


    public JPanel createPanel(Color backgroundColor, LayoutManager layout, Dimension preferredSize, boolean opaque) {
        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor);
        panel.setLayout(layout);
        panel.setPreferredSize(preferredSize);
        panel.setOpaque(opaque);
        return panel;
    }


    public JButton createButton(String text, Color bgColor, Border border, Cursor cursor) {
        JButton button = new JButton(text);
        button.setOpaque(true);
        button.setFocusable(false);
        button.setVisible(true);
        button.setBackground(bgColor);
        button.setBorder(border != null ? border : BorderFactory.createEmptyBorder());
        button.setCursor(cursor != null ? cursor : Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setHorizontalAlignment(JButton.CENTER);
        button.setVerticalAlignment(JButton.CENTER);
        button.setFont(new Font("Arial", Font.BOLD, 12));  // Adjust font as necessary

        return button;
    }


    // Base method for creating a JButton
    public JButton createButton(Color backgroundColor, Color foregroundColor, ActionListener actionListener, String actionCommand) {
        JButton button = new JButton();
        button.setBackground(backgroundColor);
        button.setForeground(foregroundColor);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);
        button.setFocusable(false);
        button.addActionListener(actionListener);
        button.setActionCommand(actionCommand);
        return button;
    }

    public JLabel createLabel( Color backgroundColor) {

        JLabel label = new JLabel();
//        label.setText("<html><p style='color: " + toHexColor(textColor) + "; font-weight: " + (isBold ? "bold" : "normal") + "; font-size: " + fontSize + "px; text-align: center;'>" + text + "</p></html>");
        label.setOpaque(true);
        label.setBackground(backgroundColor);
        return label;
    }
    // Base method for creating a JLabel
    public JLabel createLabel(String text, Color backgroundColor, Color textColor, int fontSize, boolean isBold, String position) {
        JLabel label = new JLabel();
        label.setText("<html><p style='color: " + toHexColor(textColor) + "; font-weight: " + (isBold ? "bold" : "normal") + "; font-size: " + fontSize + "px;  text-align: " + position + ";'>" + text + "</p></html>");
        label.setOpaque(true);
        label.setBackground(backgroundColor);
        return label;
    }

    public JLabel createLabel(String place,String address, String type, Color backgroundColor, Color textColor, String position, int fontSize) {
        JLabel label = new JLabel();
        label.setText("<html>" +
                "<p style='color: " + toHexColor(textColor) + "; font-weight: normal; font-size: " + fontSize + "px; text-align: " + position + ";'>" +
                "Place: <span style='font-weight: bold;'>" + place + "</span><br>" + // Place name in bold using span
                "Address: " + address + "<br>" + // Regular text for address
                "Type: " + type + // Regular text for type
                "</p>" +
                "</html>");
        label.setOpaque(true);
        label.setBackground(backgroundColor);
        return label;
    }

    // Helper method to convert Color to hex string
    public String toHexColor(Color color) {
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }

    // Base method for creating an Inset
    public Insets setInsets(int top, int left, int bottom, int right){
        return new Insets(top,left,bottom,right);
    }
    // Base method for creating a GridBagConstraint
    public GridBagConstraints setGbc(int gridx, int gridy, String anchorLocation, Insets insets){
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
//        gbc.weightx = weightx;
//        gbc.weighty = weighty;
        gbc.insets = insets;

        return gbc;
    }

    public  ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage(); // Get the image from the ImageIcon
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Resize the image
        return new ImageIcon(resizedImage); // Create a new ImageIcon with the resized image
    }

    public BorderLayout setBorderLayout(int vGap, int hGap){
        return new BorderLayout(vGap, hGap);
    }
    public BorderLayout setBorderLayout(){
        return new BorderLayout();
    }

    public String formatText( String text, Color textColor, int fontSize, boolean isBold, String position){

        return ("<html><p style='color: " + toHexColor(textColor) + "; font-weight: " + (isBold ? "bold" : "normal") + "; font-size: " + fontSize + "px;  text-align: " + position + ";'>" + text + "</p></html>");
    }


}
