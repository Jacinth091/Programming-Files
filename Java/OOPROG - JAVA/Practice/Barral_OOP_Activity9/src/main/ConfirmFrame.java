package main;

import main.objects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ConfirmFrame extends JFrame implements ActionListener {

    //    private Color foreground = new Color(new Color());
    private App mainWindow;
    private Student student;
    private BookStatusFrame bookStatusWindow;
    private Helper helper = new Helper(); // HelperMethod Class
    private PlaceData plData = PlaceData.getInstance();


    private JPanel parentPanel;
    private JPanel sectionPanel;

    private int index;
    private int vehicleIndex;
    private String selItem, selItemType;


    private PlaceCard displayCard;

    private JPanel confirmPanel;
    private JPanel[] confirmPanelElements;

    private JPanel comboBoxParent, comboBoxPanel;
    private JLabel comboBoxLabel, comboBoxLabelTitle;
    private JComboBox<String> comboBox;


    private JPanel buttonsPanel;
    private JButton confirmBtn, backBtn;


    public ConfirmFrame() {
    }

    public ConfirmFrame(int index) {
        this.index = index;
    }

    public ConfirmFrame(App mainWindow, Student student, int index) {
        this.mainWindow = mainWindow;
        this.student = student;
        this.index = index;
        this.setPreferredSize(new Dimension(mainWindow.getWidth(), mainWindow.getHeight()));
        this.setTitle(mainWindow.getTitle());
        this.setResizable(mainWindow.isResizable());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(mainWindow.getLayout());
        initMain();
    }

    public void initMain() {

        // Parent Panle
        parentPanel = helper.createPanel(Color.white, helper.setBorderLayout(), true);
        parentPanel.setBorder(helper.createEmptyBorder(5, 5, 5, 5));

        // Section Panels (Head,Body, Footer)
        sectionPanel = helper.createPanel(Color.white, null, true);
        sectionPanel.setLayout(helper.setBorderLayout());

        //------------------------------------ BODY ------------------------------------

        initConfirmPanel();



        //------------------------------------ Adding of Components ------------------------------------


        addComponent(comboBoxPanel, comboBoxLabel);
        comboBoxPanel.add(Box.createVerticalStrut(10));
        comboBoxPanel.add(Box.createVerticalGlue()); // Adds space before comboBox
        addComponent(comboBoxPanel, comboBox);
        comboBoxPanel.add(Box.createVerticalGlue()); // Adds space after comboBox



        addComponent(comboBoxParent, comboBoxPanel, BorderLayout.CENTER);
        addComponent(comboBoxParent, comboBoxLabelTitle, BorderLayout.NORTH);


        addComponent(buttonsPanel, confirmBtn, BorderLayout.WEST);
        addComponent(buttonsPanel, backBtn, BorderLayout.WEST);


        addComponent(confirmPanelElements[0], displayCard, BorderLayout.CENTER);
        addComponent(confirmPanelElements[1], comboBoxParent, BorderLayout.CENTER);
        addComponent(confirmPanelElements[1], buttonsPanel, BorderLayout.SOUTH);


        addComponent(confirmPanel, confirmPanelElements[0]);
        confirmPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Adds spacing
        addComponent(confirmPanel, confirmPanelElements[1]);

        addComponent(sectionPanel, confirmPanel, BorderLayout.CENTER);


        addComponent(parentPanel, sectionPanel, BorderLayout.CENTER);

        addComponentToFrame(parentPanel, BorderLayout.CENTER);

        pack();
        validate();
        setLocationRelativeTo(null);

    }


    private void initConfirmPanel() {

        // Confirm Panel Parent
        confirmPanel = helper.createPanel(null, true, true);
        confirmPanel.setBackground(null);
        confirmPanel.setLayout(new BoxLayout(confirmPanel, BoxLayout.Y_AXIS));

        // Confirm Panel Elements
        confirmPanelElements = new JPanel[2];
        for (int i = 0; i < confirmPanelElements.length; i++) {
            confirmPanelElements[i] = helper.createPanel(null, helper.setBorderLayout(), true);
            confirmPanelElements[i].setBorder(helper.createCompoundBorder(Color.BLACK, 5, 5,5,5,5));

        }
        confirmPanelElements[0].setPreferredSize(new Dimension(100, 350));
        confirmPanelElements[1].setPreferredSize(new Dimension(100, 150));
        confirmPanelElements[1].setLayout(new BorderLayout(5, 5));
        confirmPanelElements[1].setBackground(Color.WHITE);


        // Display Card Component
        displayCard = initPlaceCardData(index);

        // JComboBox Section Initialization

        initJComboSection();


        // Buttons and Buttons Panel
        initButtons();


        confirmPanel.revalidate();
        confirmPanel.repaint();

        confirmPanelElements[1].revalidate();
        confirmPanelElements[1].repaint();

    }
    private void initJComboSection(){

        // JComboBox Panel Parent
        comboBoxParent = helper.createPanel(null, new BorderLayout(5,5), true);
        comboBoxParent.setPreferredSize(new Dimension(0, 150));
//        comboBoxPanelTitle.setBorder(helper.createEmptyBorder(5,5,5,5));


        // JComboBox JLabel Title
        comboBoxLabelTitle = helper.createLabel("Mode Of Transportation", null, Color.black, 15, false, "center");
        comboBoxLabelTitle.setHorizontalAlignment(JLabel.CENTER);


        // JComboBox Elements Container
        comboBoxPanel = helper.createPanel(null, null, true);
        comboBoxPanel.setLayout(new BoxLayout(comboBoxPanel, BoxLayout.X_AXIS));
        comboBoxPanel.setPreferredSize(new Dimension(0, 150));

        // JCombo Box Label Element
        comboBoxLabel = helper.createLabel("Choose Vehicle", null, Color.black, 15, true, "center");
        comboBoxLabel.setHorizontalAlignment(JLabel.CENTER);
//        comboBoxLabel.setMaximumSize(new Dimension(300, 100));

        comboBox = helper.createComboBox(plData.getVehicleNames(),
                new Dimension(270, 30),
                false,
                Color.white,
                Color.BLACK,
                new Font("Arial", Font.PLAIN, 14)
        );
        comboBox.setOpaque(false);
        comboBox.setMaximumSize(new Dimension(270, 50));
        comboBox.setAlignmentX(JComponent.CENTER_ALIGNMENT);
//        comboBox.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        comboBox.addActionListener(this);
        comboBox.setActionCommand("comboBox");
    }
    private void initButtons() {
        // Buttons Panel

        buttonsPanel = helper.createPanel(null, new GridLayout(1, 2, 10, 10), true);
        buttonsPanel.setPreferredSize(new Dimension(0, 50));


        // Confirm and Back Buttons
        confirmBtn = helper.createButton(helper.formatText("Confirm", Color.WHITE, 13, true, "center"), Color.WHITE, null, Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        confirmBtn.setBorder(helper.createLineBorder(Color.BLACK, 1));
        confirmBtn.setBackground(new Color(105, 232, 86));
        confirmBtn.addActionListener(this);
        confirmBtn.setActionCommand("confirm");


        backBtn = helper.createButton(helper.formatText("Back", Color.WHITE, 13, true, "center"), Color.WHITE, null, Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backBtn.setBorder(helper.createLineBorder(Color.BLACK, 1));
        backBtn.setBackground(new Color(232, 86, 108));
        backBtn.addActionListener(this);
        backBtn.setActionCommand("back");
    }

    private PlaceCard initPlaceCardData(int i) {
        PlaceCard temp = new PlaceCard();
        String placeTitle = plData.getTouristSpots()[i][0];
        String placeAddress = plData.getTouristSpots()[i][1];
        String placeDesc = plData.getTouristSpots()[i][2];
        String placeType = plData.getTouristSpots()[i][3];
        String suggestedVehicle = plData.getTouristSpots()[i][4];
        ImageIcon placeImage = null;

        try {
            ImageIcon tempImg = plData.getTouristSpotImages()[i];

            if (tempImg == null) {
                throw new NullPointerException("Image from the database is null!");
            }

            placeImage = helper.resizeImageIcon(tempImg, 500, 300);

            if (placeImage.getImageLoadStatus() != MediaTracker.COMPLETE) {
                throw new IOException("Image failed to load after resizing.");
            }

        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
            System.out.println("Error loading or resizing image: " + e.getMessage());
        }

        temp = new PlaceCard(placeTitle, placeAddress, placeDesc, placeType, suggestedVehicle, placeImage);

        temp.initDisplayCardElement();

        return temp;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCmd = e.getActionCommand();

        cardCompEvent(actionCmd);

    }

    public void cardCompEvent(String command) {
        switch (command) {
            case "confirm":
                if (bookStatusWindow == null) {
                    this.dispose();
                    mainWindow.dispose();
                    String placeTitle = plData.getTouristSpots()[index][0];
                    String placeAddress = plData.getTouristSpots()[index][1];
                    bookStatusWindow = new BookStatusFrame(student, index, vehicleIndex, selItem, selItemType, placeAddress, placeTitle, student.getStudName());

                    bookStatusWindow.displayBookingDetails();

                    System.out.println();


                }
                break;
            case "back":
                mainWindow.setVisible(true);
                resetIndex();
                this.setVisible(false);
                break;
            case "comboBox":
                // Always update the selected item and index
                selItem = String.valueOf(comboBox.getSelectedItem());
                vehicleIndex = comboBox.getSelectedIndex();
                selItemType = plData.getVhArray()[vehicleIndex].getVhType();
                break;
        }
    }

    public void resetIndex() {
        index = -1;
    }


    private void addComponentToFrame(JComponent comp) {
        this.add(comp);
    }

    private void addComponentToFrame(JComponent comp, String constraint) {
        this.add(comp, constraint);
    }

    private void addComponentToFrame(JComponent comp, int constraint) {
        this.add(comp, constraint);
    }

    private void addComponent(JComponent container, JComponent comp) {
        container.add(comp);
    }

    private void addComponent(JComponent container, JComponent comp, String constraint) {
        container.add(comp, constraint);
    }

    private void addComponent(JComponent container, JComponent comp, int constraint) {
        container.add(comp, constraint);
    }

    private void addComponent(JComponent container, JComponent comp, GridBagConstraints gbc) {
        container.add(comp, gbc);
    }


}
