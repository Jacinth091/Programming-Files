import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import static java.awt.Color.black;


public class CalculatorWithGUI {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Start Program? ");
        char choice = in.next().charAt(0);

        if(choice == 'y'){
            System.out.println("Please Wait....");
            callMainWindow();
        }


    }

    static void callMainWindow(){
        mainWindow startWindow = new mainWindow();

    }
}

class mainWindow extends JFrame implements ActionListener {
    
    JPanel mainPanelWrapper, headerPanel, bodyElementPanel, buttonsPanel;
    JPanel[] elementContainer;
    JLabel titleLabel;
    JLabel[] buttonTitles, buttonContainer;
    JButton[] mainButtons;


    // ************************ Button Lists ************************
    String[] mainMenu = {"Addition", "Subtraction", "Multiplication", "Division", "Modulo", "Conversion", "All Operations?", "Exit Program"};
    String[] menuLogo = {"+", "-", "*", "/", "%", "<-->", "--all--", "0"};
    String[] conversionMenu = {"Decimal to Binary",  "Decimal to Hex", "Decimal to Octal", "Back to the Main Menu", "Exit Program" };
    public mainWindow(){


        // ************************ Button Titles, Button Containers, and Buttons Intializer ************************
        buttonTitles = new JLabel[mainMenu.length];
        buttonContainer = new JLabel[mainMenu.length];
        mainButtons = new JButton[mainMenu.length];
        for(byte  i = 0; i< mainMenu.length; i++){

            mainButtons[i] = new JButton("<html><p style='color: #353839; word-wrap: break-word;'>\n" +"( " +menuLogo[i]+ " )     "+ mainMenu[i]  +"</p></html>");

            mainButtons[i].setHorizontalAlignment(JButton.LEFT);
            mainButtons[i].setFont(new Font("Calibri", Font.BOLD, 18));
            mainButtons[i].addActionListener(this);
            mainButtons[i].setFocusable(false);
            mainButtons[i].setBorder(BorderFactory.createEtchedBorder(1));

            buttonTitles[i] = new JLabel(mainMenu[i], JLabel.LEFT);

//            buttonTitles[i].setOpaque(true);
            buttonTitles[i].setText("<html><p style='color: #353839; word-wrap: break-word; margin: 10px, 10px, 10px, 10px;'>\n" +(i+1)+ ").    "+ mainMenu[i]  +"</p></html>");
            buttonTitles[i].setFont(new Font("Calibri", Font.PLAIN, 25));
//            buttonTitles[i].setBackground(Color.white);
//            buttonTitles[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));

            buttonContainer[i] = new JLabel();

            buttonContainer[i].setHorizontalAlignment(JLabel.CENTER);
//            buttonContainer[i].setOpaque(true);
            buttonContainer[i].setFont(new Font("Calibri", Font.PLAIN, 30));
//            buttonContainer[i].setBackground(Color.white);
            buttonContainer[i].setLayout(new BorderLayout());
            buttonContainer[i].setBorder(BorderFactory.createEmptyBorder(5,15,5,15) );

            buttonContainer[i].add(mainButtons[i]);
        }   




        // ************************ Elements Container ************************
        elementContainer = new JPanel[2];
        for(byte  i = 0; i < 2; i++){
            elementContainer[i] = new JPanel();

            elementContainer[i].setOpaque(true);
            elementContainer[i].setBackground(Color.WHITE);
            elementContainer[i].setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            elementContainer[i].setLayout(new GridLayout(mainMenu.length, elementContainer.length));

        }
        // ************************ ADD items to Element container ************************
        for(byte j = 0; j < mainMenu.length; j++){
            elementContainer[0].add(buttonTitles[j]);
            elementContainer[1].add(buttonContainer[j]);
        }




        // ************************ Title Label ************************
        titleLabel = new JLabel();

        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setOpaque(true);
        titleLabel.setText("<html><p style='color: #353839; word-wrap: break-word;'>\nSimple Calculator</p></html>");
        titleLabel.setFont(new Font("Calibri", Font.BOLD, 50));



        // ************************ Header Panel ************************
        headerPanel = new JPanel();

        headerPanel.setOpaque(true);
        headerPanel.setPreferredSize(new Dimension(300, 150));
        headerPanel.setBackground(Color.white);
        headerPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(20,20,10,20), BorderFactory.createLineBorder(black, 1) ));
        headerPanel.setLayout(new BorderLayout(10,10));

        headerPanel.add(titleLabel, BorderLayout.CENTER);



        // ************************ Body Element Panel  ************************
        bodyElementPanel = new JPanel();

        bodyElementPanel.setOpaque(true);
        bodyElementPanel.setPreferredSize(new Dimension(300, 150));
        bodyElementPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10,20,10,20), BorderFactory.createLineBorder(black, 1) ));
        bodyElementPanel.setBackground(Color.white);
        bodyElementPanel.setLayout(new GridLayout(1,2));

        bodyElementPanel.add(elementContainer[0]);
        bodyElementPanel.add(elementContainer[1]);




        // ************************ Main Panel Wrapper ************************

        mainPanelWrapper = new JPanel();

        mainPanelWrapper.setOpaque(true);
        mainPanelWrapper.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        mainPanelWrapper.setBackground(new Color(246, 248, 255));
        mainPanelWrapper.setLayout(new BorderLayout());

        mainPanelWrapper.add(headerPanel, BorderLayout.NORTH);
        mainPanelWrapper.add(bodyElementPanel, BorderLayout.CENTER);




        // ************************ Main Window ************************
        this.setTitle("Simple Calculator");
        this.setSize(new Dimension(600,600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());


        this.add(mainPanelWrapper, BorderLayout.CENTER);
        this.setResizable(false);
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();

        for (int i = 0; i < mainMenu.length; i++) {
            // Check if the source button matches the current menu button
            if (source == mainButtons[i]) {
                // Perform different actions based on the index i
                switch (i) {
                    case 0:
                        System.out.println("Addition");

                        break;
                    case 1:
                        System.out.println("Subtraction");

                        break;
                    case 2:
                        System.out.println("Multiplication");

                        // Code for button 2
                        break;
                    case 3:
                        System.out.println("Division");

                        // Code for button 2
                        break;
                    case 4:
                        System.out.println("Modulo");
                        // Code for button 2
                        break;
                    case 5:
                        System.out.println("Conversion");
                        // Code for button 2
                        break;
                    case 6:
                        System.out.println("All Operations");
                        // Code for button 2
                        break;
                    case 7:
                        System.out.println("Exiting Program");
                        // Code for button 2
                        break;
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
