package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener {

//    private Color foreground = new Color(new Color());

    private Helper helper = new Helper(); // HelperMethod Class
    private PlaceData plData = PlaceData.getInstance();

    private GridBagConstraints gbc;


    private JPanel parentPanel;
    private JPanel[] sectionPanels;

    private CardLayout cardLayout;
    private JPanel cardContainerPanel;
    private JPanel[] cardCont;

    // ------------------------------------ Main Panel Card Elements = Scrollable Card UI
    private JPanel[] bodySectionPanels;
    private JPanel[] BC_Panels;
    private JLabel[] bodyCenterLabels;

    private JPanel touristSpotCont;
    private JScrollPane touristSpotScroll;
    private PlaceCard testCard;
    private PlaceCard[] touristSpotCard;
    private int selectedIndex = -1;
    private int index;

    private JPanel bookLabelPanel, bookBtnPanel;
    private JLabel bookBtnLabel;
    private JButton bookBtn, cancelBookBtn;


    // ------------------------------------ Confirm Panel  = Display Card UI

    // Display Place Card Component

    private PlaceCard teest2;



    private JPanel confirmPanel;
    private JLabel confirmLabel;
    private JButton confirmBtn, backBtn;




    public App(){

    }
    public App(int width, int height, String title, boolean isVisible, boolean isResizable, LayoutManager layout, int defCloseOper) {
        this.setPreferredSize(new Dimension(width, height));
        this.setTitle(title);
        this.setResizable(isResizable);
        this.setDefaultCloseOperation(defCloseOper);

        this.setLayout(layout);
        plData.initImages();

    }



    public void initGui(){

        // Parent Panle
        parentPanel = helper.createPanel(Color.white, helper.setBorderLayout(5,5),true);
        parentPanel.setBorder(helper.createEmptyBorder(5,5,5,5));

        // Section Panels (Head,Body, Footer)
        sectionPanels = new JPanel[2];
        for(int i = 0; i < sectionPanels.length; i++){
            sectionPanels[i] = helper.createPanel(Color.white, null, true); // Now each element in the array is set to a new JPanel
            sectionPanels[i].setBorder(helper.createLineBorder(Color.BLACK, 5));
        }
        sectionPanels[0].setPreferredSize(new Dimension(parentPanel.getWidth(),70));
        sectionPanels[1].setPreferredSize(new Dimension(parentPanel.getWidth(),200));
        sectionPanels[1].setLayout(helper.setBorderLayout());
//        sectionPanels[1].setBorder(helper.createLineBorder(Color.BLACK, 20));
//        sectionPanels[2].setPreferredSize(new Dimension(parentPanel.getWidth(),100));
        //------------------------------------ Header ------------------------------------







        //------------------------------------ BODY ------------------------------------
//
//        private JPanel cardContainerPanel;
//        private JPanel[] cardCont;
        cardContainerPanel = helper.createPanel(null, new CardLayout(), true);
        cardLayout = (CardLayout)cardContainerPanel.getLayout();



        cardCont = new JPanel[2];
        for(int i = 0; i < cardCont.length; i++){
            cardCont[i] = helper.createPanel(null, helper.setBorderLayout(5,5), new Dimension(parentPanel.getWidth(),50),true); // Now each element in the array is set to a new JPanel
        }
        cardCont[0].setBackground(Color.pink);
        cardCont[1].setBackground(Color.blue);



        // cardCont[0] = "manPanel"

        initMainPanelCard();

        // cardCont[1] = "confirmPanel"

        JPanel testPnl = new JPanel();
        testPnl.setLayout(new BorderLayout());
        testPnl.setPreferredSize(new Dimension(200,300));



        String placeTitle = plData.getTouristSpots()[0][0];
        String placeAddress = plData.getTouristSpots()[0][1];
        String placeDesc = plData.getTouristSpots()[0][2];
        String placeType = plData.getTouristSpots()[0][3];
        String suggestedVehicle = plData.getTouristSpots()[0][4];
        ImageIcon placeImage = helper.resizeImageIcon(plData.getTouristSpotImages()[0], 200,200);

        testCard = new PlaceCard(placeTitle, placeAddress, placeDesc, placeType, suggestedVehicle, placeImage);
        testCard.initDisplayCardElement();



        addComponent(testPnl, testCard, BorderLayout.NORTH);

        addComponent(cardCont[1], testPnl, BorderLayout.CENTER);


/*        confirmationLabel = new JLabel("Are you sure you want to book this place?");
        confirmationLabel.setHorizontalAlignment(JLabel.CENTER);
        confirmationPanel.add(confirmationLabel, BorderLayout.CENTER);

        // Confirmation Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        confirmButton = new JButton("Confirm");
        backButton = new JButton("Back");

        confirmButton.addActionListener(this);
        backButton.addActionListener(this);

        buttonPanel.add(confirmButton);
        buttonPanel.add(backButton);

        confirmationPanel.add(buttonPanel, BorderLayout.SOUTH);*/














        //------------------------------------ Adding of Components ------------------------------------
        // order = (Container (where to Add) , Component To Add, Constraints)

//        addComponent(cardCont[1], c, BorderLayout.CENTER);





            // Adding of buttons to bodySectionPanels[1] south part
            addComponent(bookLabelPanel, bookBtnLabel);

            addComponent(bookBtnPanel, bookBtn);

            addComponent(bookBtnPanel, cancelBookBtn);



        addComponent(bodySectionPanels[1], bookBtnPanel, BorderLayout.EAST);
        addComponent(bodySectionPanels[1], bookLabelPanel, BorderLayout.CENTER);


            // BC Body
            addComponent(BC_Panels[1], touristSpotScroll);

        addComponent(bodySectionPanels[0], BC_Panels[0], BorderLayout.NORTH);
        addComponent(bodySectionPanels[0], BC_Panels[1], BorderLayout.CENTER);



        addComponent(cardCont[0], bodySectionPanels[0], BorderLayout.CENTER);
        addComponent(cardCont[0], bodySectionPanels[1], BorderLayout.SOUTH);

//        addComponent(cardContainerPanel, cardCont[0], "mainPanel");
//        addComponent(cardContainerPanel, cardCont[1], "confirmPanel");

        addComponent(cardContainerPanel, cardCont[1], "mainPanel");
        addComponent(cardContainerPanel, cardCont[0], "confirmPanel");


        addComponent(sectionPanels[1], cardContainerPanel);

//        addComponent(sectionPanels[1], bodySectionPanels[0], BorderLayout.CENTER);
//        addComponent(sectionPanels[1], bodySectionPanels[1], BorderLayout.SOUTH);


        addComponent(parentPanel, sectionPanels[0], BorderLayout.NORTH);
        addComponent(parentPanel, sectionPanels[1], BorderLayout.CENTER);
//        addComponent(parentPanel, sectionPanels[2], BorderLayout.SOUTH);


        addComponentToFrame(parentPanel, BorderLayout.CENTER);


    }

    private void initMainPanelCard(){
        // Body Section Panels ( Body Center, Body Footer)
        bodySectionPanels = new JPanel[2];
        for(int i = 0; i < bodySectionPanels.length; i++){
            bodySectionPanels[i] = helper.createPanel(null, helper.setBorderLayout(5,5), new Dimension(parentPanel.getWidth(),50),true); // Now each element in the array is set to a new JPanel
            //            bodySectionPanels[i].setBorder(helper.createEmptyBorder(5,5,5,5));
        }
        bodySectionPanels[1].setPreferredSize(new Dimension(parentPanel.getWidth(), 70));



        // Body Center (BC Header, BC Body)
        BC_Panels = new JPanel[2];
        for(int i = 0; i < BC_Panels.length; i++){
            BC_Panels[i] = helper.createPanel(Color.white, helper.setBorderLayout(), new Dimension(parentPanel.getWidth(),50),true); // Now each element in the array is set to a new JPanel
        }
        BC_Panels[0].setPreferredSize(new Dimension(parentPanel.getWidth(), 70));
        BC_Panels[1].setPreferredSize(new Dimension(parentPanel.getWidth(), 400));



        // BC Body (tourist Spots Card Component)
        // Putting data from the Place Data to the Place Card Component
        initalizeDataToCard();


        // BC Footer (Book Location Button)
        //            System.out.println(bodySectionPanels[1].getWidth() + " " +bodySectionPanels[1].getHeight() );
        initBookBtns();
    }

    private void initCondirmPanelCard(){

    }


    private void initalizeDataToCard(){
        int n = plData.getTouristSpots().length;
        touristSpotCard = new PlaceCard[n];


        touristSpotCont = helper.createPanel(null, null, true);
        touristSpotCont.setLayout(new BoxLayout(touristSpotCont, BoxLayout.Y_AXIS));

        // Adding PlaceCards with spacing
        for (int i = 0; i < n; i++) {
            String placeTitle = plData.getTouristSpots()[i][0];
            String placeAddress = plData.getTouristSpots()[i][1];
            String placeDesc = plData.getTouristSpots()[i][2];
            String placeType = plData.getTouristSpots()[i][3];
            String suggestedVehicle = plData.getTouristSpots()[i][4];
            ImageIcon placeImage = helper.resizeImageIcon(plData.getTouristSpotImages()[i], 100,100);

            touristSpotCard[i] = new PlaceCard(placeTitle, placeAddress, placeDesc, placeType, suggestedVehicle, placeImage);
            touristSpotCard[i].initScrollCardElements();
            touristSpotCard[i].addActionListener(this);
            touristSpotCard[i].setActionCommand("place " + i);
            touristSpotCont.add(touristSpotCard[i]);
            touristSpotCont.add(Box.createRigidArea(new Dimension(0, 10))); // Adds spacing

            touristSpotCard[i].repaint();
            touristSpotCard[i].revalidate();
        }

        // After adding all cards, call revalidate and repaint on touristSpotCont
        touristSpotCont.revalidate();
        touristSpotCont.repaint();

        // Set the preferred size of the panel based on the number of cards and spacing
        touristSpotCont.setPreferredSize(new Dimension(400, n * 110)); // Adjusted for spacing
        touristSpotCont.setMaximumSize(new Dimension(400, n * 110)); // Adjusted for spacing

        // Scroll Pane
        touristSpotScroll = new JScrollPane(touristSpotCont);
        touristSpotScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        touristSpotScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        touristSpotScroll.setViewportView(touristSpotCont);

    }

    private void initBookBtns(){
        bookBtnPanel = helper.createPanel(Color.pink,new GridLayout(1,2), true);

        bookLabelPanel = helper.createPanel(Color.blue,new BorderLayout(), true);

        bookBtnLabel = helper.createLabel("Book Now: ", Color.WHITE, Color.BLACK,15, true, "left");
        bookBtnLabel.setPreferredSize(new Dimension(100,20));

        bookBtnLabel.setHorizontalAlignment(JLabel.CENTER);

        bookBtn = helper.createButton(Color.GREEN, Color.WHITE, this, "book");
        bookBtn.setText(helper.formatText("Book",Color.WHITE, 13,true,"center"));
        bookBtn.setPreferredSize(new Dimension(100,50));


        cancelBookBtn = helper.createButton( Color.RED, Color.WHITE, this, "cancelBook");
        cancelBookBtn.setText(helper.formatText("Cancel Book",Color.WHITE, 13,true,"center"));
        cancelBookBtn.setPreferredSize(new Dimension(100,50));
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


    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCmd = e.getActionCommand();

        cardCompEventController(actionCmd);

//        if(actionCmd.contains("Panel")){
//            confirmBookEvents(actionCmd);
//        }


    }

    public void confirmBookEvents(String command){
        switch(command){
            case "mainPanel":

                break;
            case "confirmPanel":

                break;

        }
    }


    public void cardCompEventController(String command){
        if(command.contains("place")){
            index = Integer.parseInt(command.split("place ")[1]);
//            System.out.println(index);
            selectItem(index);

        }
        else if(command.contains("book") || command.contains("Back")){
            cardLayout.show(cardContainerPanel, "mainPanel");
            if(selectedIndex != -1){
                PlaceCard temp;

                temp= touristSpotCard[index];


                System.out.println(temp.toString());

                setDefaultBorder();
                selectedIndex = -1;
            }

        }
        else if(command.contains("cancelBook")){
            cardLayout.show(cardContainerPanel, "confirmPanel");

            if(selectedIndex != -1){

                setDefaultBorder();

                selectedIndex = -1;
            }
        }


    }

    private void selectItem(int index) {

        if (selectedIndex != -1) {
            setDefaultBorder();
        }
        selectedIndex = index;
        touristSpotCard[selectedIndex].getPc_Container().setBorder(helper.createLineBorder(Color.YELLOW, 5));

        // Highlight selected button
        touristSpotCont.revalidate();
        touristSpotCont.repaint();

    }


    public void setDefaultBorder(){
        touristSpotCard[selectedIndex].getPc_Container().setBorder(helper.defaultBorder);
    }

    public void startImageLoad(Runnable callback) {
        Thread imageLoader = new Thread(() -> {
            plData.initImages(); // Load images
            SwingUtilities.invokeLater(callback); // Notify UI on EDT after loading
        });
        imageLoader.start(); // Start the image loading thread

        // Wait for the image loader thread to finish
        try {
            imageLoader.join(); // This will block until the imageLoader thread has finished
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Now, invoke the callback on the EDT after images are loaded
        SwingUtilities.invokeLater(callback);
    }
}
