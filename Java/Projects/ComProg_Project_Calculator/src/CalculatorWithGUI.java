import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
// import java.util.NumberFormatExeception;
import java.util.Scanner;

import static java.awt.Color.black;


public class CalculatorWithGUI {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        boolean exitLoop = false;
        char choice;



        // do{
        //     System.out.println("Start Program (Y for yes, N for No): ");
        //     choice = in.next().charAt(0);
        //     choice = Character.toUpperCase(choice);

        //     in.nextLine();

        //     if(choice !='Y' && choice != 'N'){
        //         System.out.println("Invalid Input, try again!");
        //         continue;
        //     }
        //     else if(choice == 'Y'){
        //         callMainWindow();
        //         exitLoop = true;
        //     }
        //     else{
        //         exitLoop = true;
        //     }



        // }while(!exitLoop);
        /*DEbug*/
        
        callMainWindow();

    }

    static void callMainWindow(){
        mainWindow startWindow = new mainWindow();
        operationWindow operWind = new operationWindow("Testing");


    }
}

class mainWindow extends JFrame implements ActionListener {

    operationWindow operWind;
    
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
        buttonEventController(source);



    }

    public void buttonEventController(JButton source){

        for (int i = 0; i < mainMenu.length; i++) {
            // Check if the source button matches the current menu button
            if (source == mainButtons[i]) {
                // Perform different actions based on the index i
                switch (i) {
                    case 0:
                        System.out.println("Addition");
                        dispose();
                        operWind = new operationWindow("Addition");



                        break;
                    case 1:
                        System.out.println("Subtraction");
                        dispose();
                        operWind = new operationWindow("Subtraction");

                        break;
                    case 2:
                        System.out.println("Multiplication");
                        dispose();
                        operWind = new operationWindow("Multiplication");
                        // Code for button 2
                        break;
                    case 3:
                        System.out.println("Division");
                        dispose();
                        operWind = new operationWindow("Division");

                        // Code for button 2
                        break;
                    case 4:
                        System.out.println("Modulo");
                        dispose();
                        operWind = new operationWindow("Modulo");
                        // Code for button 2
                        break;
                    case 5:
                        System.out.println("Conversion");
                        dispose();
                        operWind = new operationWindow("Conversion");
                        // Code for button 2
                        break;
                    case 6:
                        System.out.println("All Operations");
                        dispose();
                        operWind = new operationWindow("All Operations");
                        // Code for button 2
                        break;
                    case 7:
                        System.out.println("Exiting Program");
                        dispose();
                        JOptionPane.showMessageDialog(null, "Thank you! and Goodbye!! :D");
                        System.exit(0);
                    
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


class operationWindow extends JFrame implements ActionListener{
    
    // JFrame operFrame = new JFrame();
    JPanel mainPanelWrapper, headerPanel, bodyElementPanel, buttonsPanel;

    JLabel titleLabel;
    JButton button, calculate;
    JLabel[] textFieldTitle;
    JTextField[] userInput;

    operationWindow(String operTitle){

        // button = new JButton();
        // button.setOpaque(true);
        // button.setText("Submit");
        // button.addActionListener(this);


        // textField = new JTextField();
        // textField.setOpaque(true);
        // // textField.

        textFieldTitle = new JLabel[2];
        userInput = new JTextField[2];

        for(byte i = 0; i < 2; i++){

            textFieldTitle[i] = new JLabel("Input Number " + (i+1) + ": ");
            textFieldTitle[i].setHorizontalAlignment(JLabel.CENTER);

            userInput[i] = new JTextField();

            userInput[i].setPreferredSize(new Dimension(150, 150));
            userInput[i].setOpaque(true);

        }

        calculate = new JButton("Calculate");


        calculate.setHorizontalAlignment(JButton.LEFT);
        calculate.setFont(new Font("Calibri", Font.BOLD, 18));
        calculate.addActionListener(this);
        calculate.setFocusable(false);
        calculate.setBorder(BorderFactory.createEtchedBorder(1));

        // ************************ Title Label ************************
        titleLabel = new JLabel();

        titleLabel.setHorizontalAlignment(JLabel.LEFT);
        titleLabel.setOpaque(true);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        titleLabel.setText("<html><p style='color: #353839; word-wrap: break-word;'>\n "+ "<b>"+operTitle+ "</b>"+": Press the CALCULATE Button for the Results"+" </p></html>");
        titleLabel.setFont(new Font("Calibri", Font.PLAIN, 16));
       
        
        
        // ************************ Header Panel ************************
        headerPanel = new JPanel();

        headerPanel.setOpaque(true);
        headerPanel.setPreferredSize(new Dimension(400,100));
        headerPanel.setBackground(Color.white);
        headerPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10,10,10,10), BorderFactory.createLineBorder(black, 1) ));
        headerPanel.setLayout(new BorderLayout(10,10));

        headerPanel.add(titleLabel, BorderLayout.CENTER);



        // ************************ Body Element Panel  ************************
        bodyElementPanel = new JPanel();

        bodyElementPanel.setOpaque(true);
        // bodyElementPanel.setPreferredSize(new Dimension(300, 150));
        bodyElementPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10,10,10,10), BorderFactory.createLineBorder(black, 1) ));
        bodyElementPanel.setBackground(Color.white);
        bodyElementPanel.setLayout(new GridLayout(3,2));


        bodyElementPanel.add(textFieldTitle[0]);
        bodyElementPanel.add(textFieldTitle[1]);
        bodyElementPanel.add(userInput[0]);
        bodyElementPanel.add(userInput[1]);
        bodyElementPanel.add(calculate);





        // bodyElementPanel.setLayout()

        // bodyElementPanel.add(textField);
        // bodyElementPanel.add(button);



        // ************************ Main Panel Wrapper ************************
        mainPanelWrapper = new JPanel();

        mainPanelWrapper.setOpaque(true);
        mainPanelWrapper.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        mainPanelWrapper.setBackground(new Color(246, 248, 255));
        mainPanelWrapper.setLayout(new BorderLayout());
        // mainPanelWrapper.setBorder(BorderFactory.createLineBorder(black,2));

        mainPanelWrapper.add(headerPanel, BorderLayout.NORTH);
        mainPanelWrapper.add(bodyElementPanel, BorderLayout.CENTER);





        // ************************ Main Window ************************
        this.setTitle(operTitle);
        this.setSize(new Dimension(400,300));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());


        this.add(mainPanelWrapper, BorderLayout.CENTER);
        this.setResizable(false);
        this.setVisible(true);
        this.revalidate();
        this.repaint();
        


    }

    @Override
    public void actionPerformed(ActionEvent e){
        JButton source = (JButton) e.getSource();

        eventController(source);


    }
    public void eventController(JButton source){
        int inputOne, inputTwo;
        // String inputOneStr = toString.userInput[0].getText();
        // String inputTwoStr = toString.userInput[1].getText();
        

        if(source == calculate){

            try{   
                inputOne = Integer.parseInt(userInput[0].getText());
                inputTwo = Integer.parseInt(userInput[1].getText());


                System.out.println("Result: " + (inputOne + inputTwo));

            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Input only Numbers");
            }



        }

    }




}

class Operations{
    Scanner in = new Scanner(System.in);
    final int size = 20;
    float[] numbers;
    int temp, numData;
//    float result;

    // For Conversion
    int[] digits;
    char[] hex;
    byte index;

    boolean exitLoop;

    void getNumbersArray(){
        numbers = new float[2];
        System.out.println();
        do{
            for(byte i = 0; i < numbers.length; i++){
                System.out.printf("Input Value %d: ", (i+1));
                numbers[i] = in.nextFloat();
                in.nextLine();
            }

        }while(numbers.length != 2);
    }

    // Operations
    float sumOfNum(float[] num){
        return num[0] + num[1]; // Assuming only two numbers are provided
    }
    float diffOfNum(float[] num){
        return num[0] - num[1]; // Assuming only two numbers are provided
    }
    float prodOfNum(float[] num){
        return num[0] * num[1]; // Assuming only two numbers are provided
    }

    float quotientOfNum(float[] num){
        if(num[1] == 0){
            return 0;
        }
        return num[0] / num[1];
    }
    float moduloOfNum(float[] num){
        if(num[1] == 0){
            return 0;
        }
        return num[0] % num[1];
    }


    // Conversion

    void getValue(){
        numData = 0;
        temp = 0;
        exitLoop = false;
        do{
            System.out.println("--------Enter Number to Convert--------\n");
            try{
                System.out.print("Number -->::  ");
                numData = in.nextInt();
                in.nextLine();
                temp = numData;
                exitLoop = true;
            }catch (InputMismatchException e){
                System.out.println("---------------------------------------");
                System.out.println("\t   Invalid Input, try again!");
                System.out.println("---------------------------------------");
                in.nextLine();
                System.out.println();
            }
        }while(!exitLoop);
    }

    void decToBin(int num){
        digits  = new int[size];
        index = 0;
        while (num > 0) {
            digits[index] = num % 2;
            num /= 2;
            index++;
        }

    }

    void decToOctal(int num) {
        digits = new int[size];
        index = 0;

        while(num > 0) {
            digits[index] = num % 8;
            num /= 8;
            index++;
        }
    }

    void decToHex(int num){
        hex = new char[size];
        index =0;
        while(num > 0){

            hex[index] = (num%16 == 10) ? 'A' : (num%16 == 11) ? 'B' :
                    (num%16 == 12) ? 'C' : (num%16 == 13) ? 'D' :
                            (num%16 == 14) ? 'E' : (num%16 == 15) ? 'F' :
                                    (char) ((num%16)+48);
            num /= 16;
            index++;
        }
    }

    void conversDispNumb(int[] array){
        for( int  i = index -1; i >= 0; i--)
            System.out.printf("%d", array[i]);
    }
    void conversDispChar(char[] array){
        for( int  i = index -1; i >= 0; i--)
            System.out.printf("%c", array[i]);
    }

}