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
        initCard();
    }

    public PlaceCard(String placeTitle, String placeAddress, String placeDesc, String placeType, String suggestedVehicle, ImageIcon pc_Image) {
        this.suggestedVehicle = suggestedVehicle;
        this.placeAddress = placeAddress;
        this.placeType = placeType;
        this.placeDesc = placeDesc;
        this.placeTitle = placeTitle;
        this.pc_Image = pc_Image;
        initCard();
    }

    public void initCard(){
        setBackground(Color.pink);
        setOpaque(true);
        setVisible(true);
        setToolTipText("Item Card Parent Cont");
        setPreferredSize(new Dimension(395, 100));
        setLayout(new OverlayLayout(this));


        pc_Container = helper.createPanel(null, helper.setBorderLayout(5,5), new Dimension(this.getWidth(),200), true);
//        pc_Container.setBorder(helper.createLineBorder(Color.BLACK, 1));

        pc_Butt= helper.createButton("0",Color.WHITE, null, Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        pc_Butt.setBorder(helper.createEmptyBorder(5,5,5,5));
        pc_Butt.setLayout(new BorderLayout());


        pc_ImgLabel = helper.createLabel(Color.BLACK);
        pc_ImgLabel.setText("Image");
        pc_ImgLabel.setIcon(pc_Image);
        System.out.println(pc_Image);
        pc_ImgLabel.setForeground(Color.WHITE);
//        pc_ImgLabel.setBorder(helper.createLineBorder(Color.green, 5));
        pc_ImgLabel.setHorizontalAlignment(JLabel.CENTER);
        pc_ImgLabel.setPreferredSize(new Dimension(100, pc_Butt.getHeight()));

        // Test
//        String name = "University of Cebu Main Campus", address = "Sanciangko St, Cebu City, 6000 Cebu", type = "School";

        pc_Label = helper.createLabel(placeTitle, placeAddress, placeType, Color.WHITE, Color.black, "left", 10);
        pc_Label.setBorder(helper.createEmptyBorder(5,5,5,5));








        pc_Container.add(pc_Butt, BorderLayout.CENTER);

        pc_Butt.add(pc_ImgLabel, BorderLayout.WEST);
        pc_Butt.add(pc_Label, BorderLayout.CENTER);


        add(pc_Container);






    }

    @Override
    public void setBorder(Border border) {
        if (pc_Butt != null) {
            pc_Butt.setBorder(border);
        }
    }
    public void setActionCommand(String command) {
        pc_Butt.setActionCommand(command);
    }

    public void addActionListener(ActionListener listener) {
        pc_Butt.addActionListener(listener);
    }


}
