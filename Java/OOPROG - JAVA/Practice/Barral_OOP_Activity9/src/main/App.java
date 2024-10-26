package main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class App extends JFrame {

//    private Color foreground = new Color(new Color());



    private JPanel parentPanel;
    private JPanel[] sectionPanels;
    private JPanel[] bodySectionPanels;

    private JPanel[] bodyPanels;
    private JLabel[] bodyLabels;




    public App(){

    }
    public App(int width, int height, String title, boolean isVisible, boolean isResizable, LayoutManager layout, int defCloseOper)
    {
        this.setPreferredSize(new Dimension(width, height));
        this.setTitle(title);
        this.setResizable(isResizable);
        this.setDefaultCloseOperation(defCloseOper);

        this.setLayout(layout);




        initGui();
    }



    public void initGui(){


        parentPanel = createPanel(Color.white, setBorderLayout(5,5),true);
        parentPanel.setBorder(createCompoundBorder(Color.white, 5, 5,5,5,5));


        sectionPanels = new JPanel[3];
        for(int i = 0; i < sectionPanels.length; i++){
            sectionPanels[i] = createPanel(Color.white, null, true); // Now each element in the array is set to a new JPanel
            sectionPanels[i].setBorder(null);
        }
        sectionPanels[0].setPreferredSize(new Dimension(parentPanel.getWidth(),100));
        sectionPanels[1].setPreferredSize(new Dimension(parentPanel.getWidth(),200));
        sectionPanels[1].setLayout(setBorderLayout(10,10));
        sectionPanels[2].setPreferredSize(new Dimension(parentPanel.getWidth(),100));



        bodySectionPanels = new JPanel[2];
        for(int i = 0; i < bodySectionPanels.length; i++){
            bodySectionPanels[i] = createPanel(Color.lightGray, setBorderLayout(10,10), new Dimension(parentPanel.getWidth(),50),true); // Now each element in the array is set to a new JPanel
            bodySectionPanels[i].setBorder(createEmptyBorder(5,5,5,5));
        }
        bodySectionPanels[1].setPreferredSize(new Dimension(parentPanel.getWidth(), 100));



        bodyPanels = new JPanel[2];
        for(int i = 0; i < bodyPanels.length; i++){
            bodyPanels[i] = createPanel(Color.white, setBorderLayout(), new Dimension(parentPanel.getWidth(),50),true); // Now each element in the array is set to a new JPanel
            bodyPanels[i].setBorder(createEmptyBorder(5,5,5,5));
        }
        bodyPanels[0].setPreferredSize(new Dimension(parentPanel.getWidth(), 70));
        bodyPanels[1].setPreferredSize(new Dimension(parentPanel.getWidth(), 400));





        // Adding of Components

        addComponent(bodySectionPanels[0], bodyPanels[0], BorderLayout.NORTH);
        addComponent(bodySectionPanels[0], bodyPanels[1], BorderLayout.CENTER);


        addComponent(sectionPanels[1], bodySectionPanels[0], BorderLayout.CENTER);
        addComponent(sectionPanels[1], bodySectionPanels[1], BorderLayout.SOUTH);


        addComponent(parentPanel, sectionPanels[0], BorderLayout.NORTH);
        addComponent(parentPanel, sectionPanels[1], BorderLayout.CENTER);
        addComponent(parentPanel, sectionPanels[2], BorderLayout.SOUTH);


        addComponentToFrame(parentPanel, BorderLayout.CENTER);

    }




    private void addComponentToFrame(JComponent comp){
        this.add(comp);
    }
    private void addComponentToFrame(JComponent comp, String constraint){
        this.add(comp, constraint);
    }

    private void addComponent(JComponent container, JComponent comp){
        container.add(comp);
    }
    private void addComponent(JComponent container, JComponent comp, String constraint){
        JComponent cont = container;
        cont.add(comp, constraint);
    }

    private void addComponent(JComponent container, JComponent comp, GridBagConstraints gbc){
        container.add(comp, gbc);
    }

    private BorderLayout setBorderLayout(int vGap, int hGap){
        return new BorderLayout(vGap, hGap);
    }
    private BorderLayout setBorderLayout(){
        return new BorderLayout();
    }



    private Border createLineBorder(Color lineColor, int thickness){
        return BorderFactory.createLineBorder(lineColor, thickness);
    }


    private Border createEmptyBorder(int top, int left, int bottom, int right){
        return BorderFactory.createEmptyBorder(top, left, bottom, right);
    }


    private static Border createCompoundBorder(Color lineColor, int thickness, int top, int left, int bottom, int right) {
        Border lineBorder = BorderFactory.createLineBorder(lineColor, thickness);
        Border emptyBorder = BorderFactory.createEmptyBorder(top, left, bottom, right);
        return BorderFactory.createCompoundBorder(lineBorder, emptyBorder);
    }

    private JPanel createPanel(Color backgroundColor, LayoutManager layout, boolean opaque) {
        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor);
        panel.setLayout(layout);
        panel.setOpaque(opaque);
        return panel;
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
