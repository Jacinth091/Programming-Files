package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmFrame extends JFrame implements ActionListener {

//    private Color foreground = new Color(new Color());
    private App mainWindow;
    private Helper helper = new Helper(); // HelperMethod Class
    private PlaceData plData = PlaceData.getInstance();


    private JPanel parentPanel;
    private JPanel[] sectionPanels;


    private JPanel touristSpotCont;
    private JScrollPane touristSpotScroll;
    private PlaceCard[] touristSpotCard;
    private int selectedIndex = -1;
    private int index;

    private JPanel bookLabelPanel, bookBtnPanel;
    private JLabel bookBtnLabel;
    private JButton bookBtn, cancelBookBtn;




    private PlaceCard teest2;
    private PlaceCard displayCard;

    private JPanel confirmPanel;
    private JPanel[] confirmPanelElements;


    private JLabel confirmLabel;
    private JButton confirmBtn, backBtn;



    public ConfirmFrame(){
//        loadImgs();
    }
    public ConfirmFrame(App mainWindow, int index) {
        this.mainWindow = mainWindow;
        this.index = index;
        this.setPreferredSize(new Dimension(mainWindow.getWidth(), mainWindow.getHeight()));
        this.setTitle(mainWindow.getTitle());
        this.setResizable(mainWindow.isResizable());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(mainWindow.getLayout());

//        initMain(new App( mainWindow.getWidth(), mainWindow.getWidth(),  mainWindow.getTitle(), mainWindow.isVisible(),  mainWindow.isResizable(), mainWindow.getLayout(), mainWindow.getDefaultCloseOperation()));
        initMain(mainWindow);
        pack();
        validate();
        setLocationRelativeTo(null);

    }
    public void loadImgs()
    {
        plData.initImages();
    }


    public void initMain(JFrame mainWindow){

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
        sectionPanels[1].setLayout(helper.setBorderLayout(5,5));
        //------------------------------------ Header ------------------------------------







        //------------------------------------ BODY ------------------------------------

        initConfirmPanel();


        //------------------------------------ Adding of Components ------------------------------------


        addComponent(confirmPanelElements[0], displayCard, BorderLayout.CENTER);
        addComponent(confirmPanelElements[2], confirmBtn, BorderLayout.WEST);
        addComponent(confirmPanelElements[2], backBtn, BorderLayout.EAST);


        for (JPanel panel : confirmPanelElements) {
            confirmPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Adds spacing

            addComponent(confirmPanel, panel);
        }
        confirmPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Adds spacing


        addComponent(sectionPanels[1], confirmPanel, BorderLayout.CENTER);


        addComponent(parentPanel, sectionPanels[0], BorderLayout.NORTH);
        addComponent(parentPanel, sectionPanels[1], BorderLayout.CENTER);


        addComponentToFrame(parentPanel, BorderLayout.CENTER);


    }


  private void initConfirmPanel(){

      confirmPanel = helper.createPanel(null, true, true);
      confirmPanel.setLayout(new BoxLayout(confirmPanel, BoxLayout.Y_AXIS));

      confirmPanelElements = new JPanel[3];
      for(int i =0; i < confirmPanelElements.length; i++){
          confirmPanelElements[i] = helper.createPanel(Color.blue, helper.setBorderLayout(), true);
      }
      confirmPanelElements[0].setPreferredSize(new Dimension(100, 350));
      confirmPanelElements[1].setPreferredSize(new Dimension(100, 100));
      confirmPanelElements[2].setPreferredSize(new Dimension(100, 50));
      confirmPanelElements[2].setLayout(new GridLayout(1,2,5,5));
      confirmPanelElements[2].setBorder(helper.createEmptyBorder(5,5,5,5));

      displayCard = initPlaceCardData(index);


      confirmBtn = helper.createButton(helper.formatText("Confirm",Color.BLACK,13, true, "center"), Color.WHITE, null, Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      confirmBtn.addActionListener(e -> {

          this.setVisible(false);
          this.dispose();


      });


      backBtn = helper.createButton(helper.formatText("Back",Color.BLACK,13, true, "center"), Color.WHITE, null, Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      backBtn.addActionListener(e -> {
          mainWindow.setVisible(true);
          resetIndex();
          this.setVisible(false);



      });




      confirmPanel.revalidate();
      confirmPanel.repaint();



      confirmPanelElements[1].revalidate();
      confirmPanelElements[1].repaint();

  }

    private PlaceCard initPlaceCardData(int i){
        int n = plData.getTouristSpots().length;
        PlaceCard temp = new PlaceCard();


        String placeTitle = plData.getTouristSpots()[i][0];
        String placeAddress = plData.getTouristSpots()[i][1];
        String placeDesc = plData.getTouristSpots()[i][2];
        String placeType = plData.getTouristSpots()[i][3];
        String suggestedVehicle = plData.getTouristSpots()[i][4];
        ImageIcon placeImage = placeImage = helper.resizeImageIcon(plData.getTouristSpotImages()[i], 455,300);;


        temp = new PlaceCard(placeTitle, placeAddress, placeDesc, placeType, suggestedVehicle, placeImage);

        temp.initDisplayCardElement();
//        temp.addActionListener(this);
//        temp.setActionCommand("place " + i);

        return temp;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCmd = e.getActionCommand();

        cardCompEvent(actionCmd);

    }

    public void cardCompEvent(String command){

        if(command.contains("place")){
            index = Integer.parseInt(command.split("place ")[1]);
            System.out.println(index);
            selectItem(index);

        }else{
            switch(command){
                case "book":
                    if(selectedIndex != -1){
                        PlaceCard temp;

                        temp= touristSpotCard[index];


                        System.out.println(temp.toString());

                        setDefaultBorder();
                        selectedIndex = -1;
                    }
                    break;
                case "cancelBook":

                    if(selectedIndex != -1){

                        setDefaultBorder();

                        selectedIndex = -1;
                    }
                    break;

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


    public void updateIndex(){
        this.index = mainWindow.getIndex();
    }

    public void resetIndex(){
       index = -1;
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
}
