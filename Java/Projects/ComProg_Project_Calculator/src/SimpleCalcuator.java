import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SimpleCalcuator {
    public static void main(String[] args) {
//        startWindow start = new startWindow();

        MainMenu mainMenu = new MainMenu();

    }

}
class MainMenu extends JFrame implements ActionListener{
    JButton[] menuButtons;
    JLabel[] titleLabels, buttonLabels;
    JPanel[] bodyPanels;
    JLabel menuTitle;
    JPanel menuWrapperPanel, childHeaderPanel, childBodyPanel, childFooterPanel;
    String[] menuButtonTitles = {"Addition", "Subtraction", "Multiplication", "Division", "Conversion", "Exit" };


    public MainMenu(){

        menuButtons = new JButton[menuButtonTitles.length];

        for(byte i = 0; i < menuButtonTitles.length; i++){

            menuButtons[i] = new JButton("<html><p style='color: #353839; word-wrap: break-word;'>\n" + menuButtonTitles[i]  +"</p></html>");
            menuButtons[i].setFont(new Font("Calibri", Font.BOLD, 25));
            menuButtons[i].addActionListener(this);
//            menuButtons[i].setPreferredSize(new Dimension(200, 200));
            menuButtons[i].setFocusable(false);
//            menuButtons[i].setBorder(BorderFactory.createEtchedBorder());



        }


        titleLabels = new JLabel[menuButtonTitles.length];
        buttonLabels = new JLabel[menuButtonTitles.length];

        for(byte i =0; i < menuButtonTitles.length; i++){
            titleLabels[i] = new JLabel(menuButtonTitles[i]);

            titleLabels[i].setOpaque(true);
            titleLabels[i].setText("<html><p style='color: #353839; word-wrap: break-word; margin: 10px, 10px, 10px, 20px;'>\n" + menuButtonTitles[i]  +"</p></html>");
            titleLabels[i].setFont(new Font("Calibri", Font.BOLD, 25));
            titleLabels[i].setPreferredSize(new Dimension(100,100));
            titleLabels[i].setBackground(Color.white);
            titleLabels[i].setBorder(BorderFactory.createLineBorder(Color.black, 1));

            buttonLabels[i] = new JLabel();

            buttonLabels[i].setHorizontalAlignment(JLabel.CENTER);
            buttonLabels[i].setOpaque(true);
            buttonLabels[i].setFont(new Font("Calibri", Font.BOLD, 30));
            buttonLabels[i].setBackground(Color.white);
            buttonLabels[i].setLayout(new BorderLayout());
            buttonLabels[i].setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10,10,10,10), BorderFactory.createLineBorder(Color.black, 1) ));

            buttonLabels[i].add(menuButtons[i], BorderLayout.CENTER);



        }



        bodyPanels = new JPanel[2];

        for(byte i = 0; i < 2; i++){
            bodyPanels[i] = new JPanel();
            bodyPanels[i].setOpaque(true);
            bodyPanels[i].setLayout(new GridLayout(menuButtonTitles.length, 0 ));
            bodyPanels[i].setBackground(Color.lightGray);

            if(i==0){
                for(byte j = 0; j < menuButtonTitles.length; j++){
                    bodyPanels[0].add(titleLabels[j]);
                }
            }
            else{
                for(byte j = 0; j < menuButtonTitles.length; j++){
                    bodyPanels[1].add(buttonLabels[j]);
                }
            }
        }
        bodyPanels[0].setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(20,20,20,10), BorderFactory.createLineBorder(Color.black, 1) ));
        bodyPanels[1].setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(20,10,20,20), BorderFactory.createLineBorder(Color.black, 1) ));




        menuTitle = new JLabel();

        menuTitle.setHorizontalAlignment(JLabel.CENTER);
        menuTitle.setText("<html><p style='color: #353839; word-wrap: break-word;'>\nMain Menu</p></html>");
        menuTitle.setFont(new Font("Calibri", Font.BOLD, 70));
        menuTitle.setPreferredSize(new Dimension(100,100));




        childHeaderPanel = new JPanel();

        childHeaderPanel.setOpaque(true);
        childHeaderPanel.setPreferredSize(new Dimension(300, 150));
        childHeaderPanel.setBackground(Color.white);
        childHeaderPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(20,20,10,20), BorderFactory.createLineBorder(Color.black, 1) ));
        childHeaderPanel.setLayout(new BorderLayout(10,10));
        childHeaderPanel.setLayout(new BorderLayout());

        childHeaderPanel.add(menuTitle, BorderLayout.CENTER);




        childBodyPanel = new JPanel();

        childBodyPanel.setOpaque(true);
        childBodyPanel.setPreferredSize(new Dimension(300, 150));
        childBodyPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10,20,10,20), BorderFactory.createLineBorder(Color.black, 1) ));
        childBodyPanel.setBackground(Color.white);
        childBodyPanel.setLayout(new GridLayout(1,2));

        childBodyPanel.add(bodyPanels[0]);
        childBodyPanel.add(bodyPanels[1]);



        childFooterPanel = new JPanel();

        childFooterPanel.setOpaque(true);
        childFooterPanel.setPreferredSize(new Dimension(300, 150));
        childFooterPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10,20,20,20), BorderFactory.createLineBorder(Color.black, 1) ));
        childFooterPanel.setBackground(Color.white);
        childFooterPanel.setLayout(new BorderLayout(10,10));
        
        
        
        

        menuWrapperPanel = new JPanel();
        
        menuWrapperPanel.setOpaque(true);
        menuWrapperPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        menuWrapperPanel.setBackground(Color.lightGray);
        menuWrapperPanel.setLayout(new BorderLayout());

        menuWrapperPanel.add(childHeaderPanel, BorderLayout.NORTH);
        menuWrapperPanel.add(childBodyPanel, BorderLayout.CENTER);
        menuWrapperPanel.add(childFooterPanel, BorderLayout.SOUTH);
        

        // ************************ Main Menu ************************
        this.setTitle("Main Menu");
        this.setSize(new Dimension(600,800));
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

//        this.pack();
        this.add(menuWrapperPanel, BorderLayout.CENTER);
        this.setVisible(true);
        this.revalidate();
        this.repaint();

    }


    @Override
    public void actionPerformed(ActionEvent e){
        JButton source = (JButton) e.getSource();

        for (int i = 0; i < menuButtons.length; i++) {
            // Check if the source button matches the current menu button
            if (source == menuButtons[i]) {
                // Perform different actions based on the index i
                switch (i) {
                    case 0:
                        System.out.println("YAwaa1");
                        break;
                    case 1:
                        System.out.println("YAwaa2");
                        // Code for button 1
                        break;
                    case 2:
                        System.out.println("YAwaa3");
                        // Code for button 2
                        break;
                    case 3:
                        System.out.println("YAwaa4");
                        // Code for button 2
                        break;
                    case 4:
                        System.out.println("YAwaa5");
                        // Code for button 2
                        break;
                    case 5:
                        System.out.println("YAwaa6");
                        System.exit(0);
                        break;
                    // Add more cases for other buttons as needed
                    default:
                        // Default case (optional)
                        break;
                }
                // Exit the loop since we found the matching button
                break;
            }
        }
    }

}
class startWindow extends JFrame implements ActionListener {
    JPanel mainPanelWrapper, childPanelOne, childPanelTwo, startPanel, exitPanel;
    JLabel titleLabel, labelOne, labelTwo, buttonLabelOne, buttonLabelTwo;

    JTextArea textArea;

    JButton startButton, exitButton;
    public startWindow(){

        // ************************ Start and Exit Buttons ************************

        startButton = new JButton("Start");

        startButton.setVisible(true);
        startButton.setPreferredSize(new Dimension(70, 50));
        startButton.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        startButton.addActionListener(this);

        exitButton = new JButton("Exit");

        exitButton.setVisible(true);
        exitButton.setPreferredSize(new Dimension(70, 50));
        exitButton.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        exitButton.addActionListener(this);


        // ************************ Container for Each Buttons ************************

        buttonLabelOne = new JLabel();

        buttonLabelOne.setOpaque(true);
        buttonLabelOne.setBackground(new Color(0,56,34));
        buttonLabelOne.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        buttonLabelOne.setLayout(new BorderLayout());

        buttonLabelOne.add(startButton, BorderLayout.CENTER);

        buttonLabelTwo = new JLabel();

        buttonLabelTwo.setOpaque(true);
        buttonLabelTwo.setBackground(new Color(0,56,34));
        buttonLabelTwo.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        buttonLabelTwo.setLayout(new BorderLayout());

        buttonLabelTwo.add(exitButton, BorderLayout.CENTER);



        // ************************ Labels for the Title Buttons ************************

        labelOne = new JLabel("<html><p style='color: #353839; word-wrap: break-word;'>" +
                "Start Program</p></html>", JLabel.CENTER);
        labelOne.setFont(new Font("SansSerif", Font.BOLD, 17));
        labelOne.setOpaque(true);
        labelOne.setBackground(new Color(0,191,255));
        labelOne.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        labelOne.setForeground(Color.black);


        labelTwo = new JLabel("<html><p style='color: #353839; word-wrap: break-word;'>" +
                "Exit Program</p></html>", JLabel.CENTER);
        labelTwo.setFont(new Font("SansSerif", Font.BOLD, 17));
        labelTwo.setOpaque(true);
        labelTwo.setBackground(new Color(0,191,255));
        labelTwo.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        labelTwo.setForeground(Color.black);


        // ************************ Panels For Each Buttons ************************

        startPanel = new JPanel();

        startPanel.setOpaque(true);
        startPanel.setPreferredSize(new Dimension(500, 260));
        startPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        startPanel.setBackground(Color.white);
        startPanel.setLayout(new GridLayout(2,1,3,0));

        startPanel.add(labelOne);
        startPanel.add(buttonLabelOne);


        exitPanel = new JPanel();

        exitPanel.setOpaque(true);
        exitPanel.setPreferredSize(new Dimension(500, 260));
        exitPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        exitPanel.setBackground(Color.lightGray);
        exitPanel.setLayout(new GridLayout(2,1,3,0));

        exitPanel.add(labelTwo);
        exitPanel.add(buttonLabelTwo);


        // ************************ Main Title Label ************************


        titleLabel = new JLabel("<html><div style='text-align: center; padding: 20px; border:none;'>" +
                "<p style='color: #353839; word-wrap: break-word; font-size: 25px; margin-bottom: 10px;'>Simple Calculator</p>" +
                "<br>" + // Add a line break for gap
                "<p style='color: #353839;'>By: Jacinth</p></div></html>", JLabel.CENTER);

        titleLabel.setFont(new Font("Verdana", Font.BOLD, 16));
        titleLabel.setOpaque(true);
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.black, 2));


        // ************************ Two Child Panel Containers ************************

        childPanelOne = new JPanel();

        childPanelOne.setOpaque(true);
        childPanelOne.setPreferredSize(new Dimension(500, 260));
        childPanelOne.setBorder(BorderFactory.createEmptyBorder(20,20,10,20));
//        childPanelOne.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        childPanelOne.setBackground(Color.white);
        childPanelOne.setLayout(new BorderLayout(10,10));

        childPanelOne.add(titleLabel, BorderLayout.CENTER);


        childPanelTwo = new JPanel();

        childPanelTwo.setOpaque(true);
        childPanelTwo.setPreferredSize(new Dimension(500, 240));
        childPanelTwo.setBorder(BorderFactory.createEmptyBorder(10,40,10,40));
        childPanelTwo.setBorder(BorderFactory.createLineBorder(Color.red, 2));
        childPanelTwo.setLayout(new GridLayout(1,2));

        childPanelTwo.add(startPanel);
        childPanelTwo.add(exitPanel);

        // ************************ Main Panel Wrapper for the child Panels ************************

        mainPanelWrapper = new JPanel();

        mainPanelWrapper.setOpaque(true);
        mainPanelWrapper.setBorder(BorderFactory.createEmptyBorder(20,30,20,30));
        mainPanelWrapper.setLayout(new BorderLayout());

        mainPanelWrapper.add(childPanelOne, BorderLayout.NORTH);
        mainPanelWrapper.add(childPanelTwo, BorderLayout.CENTER);


        // ************************ Main Window Frame ************************
        this.setTitle("Simple Calculator");
        this.setSize(new Dimension(450,500));
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1,0));

//        this.pack();
        this.add(mainPanelWrapper);
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == startButton){
            JOptionPane.showMessageDialog(null, "The Program is starting...");
        }
        else if (e.getSource() == exitButton){
            dispose();
            JOptionPane.showMessageDialog(null, "GoodBye!");
        }


    }

}



