package main;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {

//    private Color foreground = new Color(new Color());

    private Helper helper = new Helper(); // HelperMethod Class
    private PlaceData plData = PlaceData.getInstance();


    private JPanel parentPanel;
    private JPanel[] sectionPanels;

    private JPanel[] bodySectionPanels;
    private JPanel[] BC_Panels;
    private JLabel[] bodyCenterLabels;


    private JPanel touristSpotCont;
    private JScrollPane touristSpotScroll;
    private PlaceCard testCard;
    private PlaceCard[] touristSpotCard;




    public App(){

    }
    public App(int width, int height, String title, boolean isVisible, boolean isResizable, LayoutManager layout, int defCloseOper)
    {
        this.setPreferredSize(new Dimension(width, height));
        this.setTitle(title);
        this.setResizable(isResizable);
        this.setDefaultCloseOperation(defCloseOper);

        this.setLayout(layout);



        plData.initImages();
        initGui();
    }



    public void initGui(){

        // Parent Panle
        parentPanel = helper.createPanel(Color.white, helper.setBorderLayout(5,5),true);
        parentPanel.setBorder(helper.createEmptyBorder(5,5,5,5));

        // Section Panels (Head,Body, Footer)
        sectionPanels = new JPanel[3];
        for(int i = 0; i < sectionPanels.length; i++){
            sectionPanels[i] = helper.createPanel(Color.white, null, true); // Now each element in the array is set to a new JPanel
            sectionPanels[i].setBorder(helper.createLineBorder(Color.BLACK, 5));
        }
        sectionPanels[0].setPreferredSize(new Dimension(parentPanel.getWidth(),70));
        sectionPanels[1].setPreferredSize(new Dimension(parentPanel.getWidth(),200));
        sectionPanels[1].setLayout(helper.setBorderLayout(5,5));
        sectionPanels[2].setPreferredSize(new Dimension(parentPanel.getWidth(),100));
        //------------------------------------ Header ------------------------------------







        //------------------------------------ BODY ------------------------------------
        // Body Section Panels ( Body Center, Body Footer)
        bodySectionPanels = new JPanel[2];
        for(int i = 0; i < bodySectionPanels.length; i++){
            bodySectionPanels[i] = helper.createPanel(Color.lightGray, helper.setBorderLayout(5,5), new Dimension(parentPanel.getWidth(),50),true); // Now each element in the array is set to a new JPanel
            bodySectionPanels[i].setBorder(helper.createEmptyBorder(5,5,5,5));
        }
        bodySectionPanels[1].setPreferredSize(new Dimension(parentPanel.getWidth(), 100));


        // Body Center (BC Header, BC Body)
        BC_Panels = new JPanel[2];
        for(int i = 0; i < BC_Panels.length; i++){
            BC_Panels[i] = helper.createPanel(Color.white, helper.setBorderLayout(), new Dimension(parentPanel.getWidth(),50),true); // Now each element in the array is set to a new JPanel
            BC_Panels[i].setBorder(helper.createLineBorder(Color.BLACK, 5));
        }
        BC_Panels[0].setPreferredSize(new Dimension(parentPanel.getWidth(), 70));
        BC_Panels[1].setPreferredSize(new Dimension(parentPanel.getWidth(), 300));



        // BC Body (tourist Spots Card Component)

            // Container
        int n = plData.getTouristSpots().length;
        touristSpotCard = new PlaceCard[n];

        touristSpotCont = helper.createPanel(null, null, true);
        touristSpotCont.setLayout(new BoxLayout(touristSpotCont, BoxLayout.Y_AXIS));
        touristSpotCont.setPreferredSize(new Dimension(400, n * 100)); // Adjusted preferred size

            // Adding PlaceCards with spacing
        for (int i = 0; i < n; i++) {
            String placeTitle = plData.getTouristSpots()[i][0];
            String placeAddress = plData.getTouristSpots()[i][1];
            String placeDesc = plData.getTouristSpots()[i][2];
            String placeType = plData.getTouristSpots()[i][3];
            String suggestedVehicle = plData.getTouristSpots()[i][4];
            ImageIcon placeImage = null;

            touristSpotCard[i] = new PlaceCard(placeTitle, placeAddress, placeDesc, placeType, suggestedVehicle, placeImage);
            touristSpotCont.add(touristSpotCard[i]);
            touristSpotCont.add(Box.createRigidArea(new Dimension(0, 10))); // Adds spacing
        }

            // Scroll Pane
        touristSpotScroll = new JScrollPane(touristSpotCont);
        touristSpotScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        touristSpotScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        touristSpotScroll.setViewportView(touristSpotCont);



        //------------------------------------ Footer ------------------------------------






        // Adding of Components

            // BC Body
            addComponent(BC_Panels[1], touristSpotScroll);


        addComponent(bodySectionPanels[0], BC_Panels[0], BorderLayout.NORTH);
        addComponent(bodySectionPanels[0], BC_Panels[1], BorderLayout.CENTER);


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
    private void addComponentToFrame(JComponent comp, int constraint){
        this.add(comp, constraint);
    }

    private void addComponent(JComponent container, JComponent comp){
        container.add(comp);
    }
    private void addComponent(JComponent container, JComponent comp, String constraint){
        container.add(comp, constraint);
    }
    private void addComponent(JComponent container, JComponent comp, int constraint){
        container.add(comp, constraint);
    }

    private void addComponent(JComponent container, JComponent comp, GridBagConstraints gbc){
        container.add(comp, gbc);
    }

    private void loadScene(String scene){


    }





}
