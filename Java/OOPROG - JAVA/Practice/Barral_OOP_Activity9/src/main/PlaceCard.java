package main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class PlaceCard extends JPanel{
    private Helper helper = new Helper(); // HelperMethod Class
    private GridBagConstraints gbc;
    private JPanel pc_Container;
    private JButton pc_Butt;
    private JLabel pc_Label;
    private JLabel pc_ImgLabel;
    private ImageIcon pc_Image;

    private String placeTitle;
    private String placeDesc;
    private String placeType;
    private String placeAddress;
    private String suggestedVehicle;

    public PlaceCard(){

    }

    public PlaceCard(String placeTitle, String placeAddress, String placeDesc, String placeType, String suggestedVehicle, ImageIcon pc_Image) {
        this.suggestedVehicle = suggestedVehicle;
        this.placeAddress = placeAddress;
        this.placeType = placeType;
        this.placeDesc = placeDesc;
        this.placeTitle = placeTitle;
        this.pc_Image = pc_Image;
//        initScrollCardElements();
    }

    public void initScrollCardElements(){
//        setBackground(Color.pink);
        setOpaque(true);
        setVisible(true);
        setToolTipText("Item Card Parent Cont");
        setPreferredSize(new Dimension(200, 100));
        setLayout(new OverlayLayout(this));


        pc_Container = helper.createPanel(null, helper.setBorderLayout(5,5), new Dimension(this.getWidth(),200), true);
        pc_Container.setBorder(helper.createLineBorder(Color.WHITE, 5));



        pc_Butt= helper.createButton("0",null, null, Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pc_Butt.setLayout(new BorderLayout());
        pc_Butt.setFocusable(false);


        pc_ImgLabel = helper.createLabel(null);
        pc_ImgLabel.setIcon(pc_Image);
        pc_ImgLabel.setForeground(Color.WHITE);
        pc_ImgLabel.setHorizontalAlignment(JLabel.CENTER);
        pc_ImgLabel.setPreferredSize(new Dimension(100, pc_Butt.getHeight()));
        pc_ImgLabel.setBorder(helper.createEmptyBorder(5,5,5,5));


        pc_Label = helper.createLabel(placeTitle, placeAddress, placeType, Color.WHITE, Color.black, "left", 10);
        pc_Label.setBorder(helper.createEmptyBorder(5,15,5,5));




        pc_Container.add(pc_Butt, BorderLayout.CENTER);

        pc_Butt.add(pc_ImgLabel, BorderLayout.WEST);
        pc_Butt.add(pc_Label, BorderLayout.CENTER);


        add(pc_Container);



    }

    public void initDisplayCardElement(){

        System.out.println("Helllo");


        setBackground(Color.pink);
        setOpaque(true);
        setVisible(true);
        setToolTipText("Item Card Parent Cont");
        setPreferredSize(new Dimension(200, 100));
        setLayout(new OverlayLayout(this));


        pc_Container = helper.createPanel(null, helper.setBorderLayout(5,5), new Dimension(this.getWidth(),200), true);
        pc_Container.setBorder(helper.createLineBorder(Color.WHITE, 5));



        pc_Butt= helper.createButton("0",null, null, Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pc_Butt.setLayout(new BorderLayout());
        pc_Butt.setFocusable(false);


        pc_ImgLabel = helper.createLabel(null);
        pc_ImgLabel.setIcon(pc_Image);
        pc_ImgLabel.setForeground(Color.WHITE);
        pc_ImgLabel.setHorizontalAlignment(JLabel.CENTER);
        pc_ImgLabel.setPreferredSize(new Dimension(100, pc_Butt.getHeight()));
        pc_ImgLabel.setBorder(helper.createEmptyBorder(5,5,5,5));

        pc_Label= helper.createLabel(placeTitle, placeAddress, placeDesc, placeType,Color.WHITE, Color.black, "left", 12);
//        pc_Label = helper.createLabel(placeTitle, placeAddress, placeType, Color.WHITE, Color.black, "left", 10);
        pc_Label.setBorder(helper.createEmptyBorder(5,15,5,5));







        pc_Container.add(pc_Butt, BorderLayout.CENTER);

        pc_Butt.add(pc_ImgLabel, BorderLayout.CENTER);
        pc_Butt.add(pc_Label, BorderLayout.SOUTH);


        add(pc_Container);
    }
    @Override
    public void setBorder(Border border) {
        if (pc_Butt != null) {
            pc_Butt.setBorder(border);
        }
    }

    @Override
    public String toString() {
        return String.format(
                "\nPlace: %s%n" +        // Place name
                        "Address: %s%n" +      // Address
                        "Type: %s%n" +         // Type
                        "Description: %s%n" +  // Description
                        "Suggested Vehicle: %s", // Suggested Vehicle
                placeTitle, placeAddress, placeType, placeDesc, suggestedVehicle
        );
    }

    public void setActionCommand(String command) {
        pc_Butt.setActionCommand(command);
    }

    public void addActionListener(ActionListener listener) {
        pc_Butt.addActionListener(listener);
    }

    public JPanel getPc_Container() {
        return pc_Container;
    }
}
