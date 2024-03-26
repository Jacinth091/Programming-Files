// import com.sun.tools.javac.Main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
// import java.util.NumberFormatException;
import java.util.Scanner;

import static java.awt.Color.black;
import static java.awt.Color.lightGray;
import static java.awt.Color.white;


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
        new mainWindow();
        //        operationWindow operWind = new operationWindow("Testing", -1);
        // new operationWindow("Testing");


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
    String[] menuLogo = {"+", "-", "*", "/", "%", "-->", "-all-", "0"};
    public mainWindow(){


        // ************************ Button Titles, Button Containers, and Buttons Intializer ************************
        buttonTitles = new JLabel[mainMenu.length];
        buttonContainer = new JLabel[mainMenu.length];
        mainButtons = new JButton[mainMenu.length];
        for(byte  i = 0; i< mainMenu.length; i++){

            /*----------------- Main Buttons -----------------*/

            mainButtons[i] = new JButton("<html><p style='color: #353839; word-wrap: break-word;'>\n"+ mainMenu[i]  +"</p></html>");

            mainButtons[i].setHorizontalAlignment(JButton.LEFT);
            mainButtons[i].setFont(new Font("Calibri", Font.BOLD, 14));
            mainButtons[i].addActionListener(this);
            mainButtons[i].setFocusable(false);
            mainButtons[i].setBorder(BorderFactory.createEtchedBorder(1));

            /*----------------- Button Titles -----------------*/

            buttonTitles[i] = new JLabel(mainMenu[i], JLabel.LEFT);

//            buttonTitles[i].setOpaque(true);
            buttonTitles[i].setText("<html><p style='color: #353839; word-wrap: break-word; margin: 10px, 10px, 10px, 10px;'>\n" +"(" +menuLogo[i]+ ")  "+ mainMenu[i]  +"</p></html>");
            buttonTitles[i].setFont(new Font("Calibri", Font.PLAIN, 17));
//            buttonTitles[i].setBackground(Color.white);
//            buttonTitles[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));


            /*----------------- Button Containers -----------------*/


            buttonContainer[i] = new JLabel();

            buttonContainer[i].setHorizontalAlignment(JLabel.CENTER);
            // buttonContainer[i].setPreferredSize(new Dimension(150,200));
//            buttonContainer[i].setOpaque(true);
            // buttonContainer[i].setFont(new Font("Calibri", Font.PLAIN, 17));
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
        titleLabel.setFont(new Font("Calibri", Font.BOLD, 30));



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
        this.setSize(new Dimension(450,500));
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
            if (source == mainButtons[i]) {
                switch (i) {
                    case 0:
                        System.out.println("Addition");
                        dispose();
                        operWind = new operationWindow("Addition", (i+1));
                        

                        break;
                    case 1:
                        System.out.println("Subtraction");
                        dispose();
                        operWind = new operationWindow("Subtraction", (i+1));
                        
                        break;
                    case 2:
                        System.out.println("Multiplication");
                        dispose();
                        operWind = new operationWindow("Multiplication", (i+1));
                        break;
                    case 3:
                        System.out.println("Division");
                        dispose();
                        operWind = new operationWindow("Division", (i+1));
                        
                        break;
                    case 4:
                        System.out.println("Modulo");
                        dispose();
                        operWind = new operationWindow("Modulo", (i+1));
                        
                        break;
                    case 5:
                        System.out.println("Conversion");
                        dispose();
                        operWind = new operationWindow("Conversion");
                        
                        break;
                    case 6:
                        System.out.println("All Operations");
                        dispose();
                        operWind = new operationWindow("All Operations", (i+1));
                        
                        break;
                    case 7:
                        System.out.println("Exiting Program");
                        dispose();
                        JOptionPane.showMessageDialog(null, "Thank you! and Goodbye!! :D");
                        System.exit(0);
                        break;
                    default:
                        // Optional
                        break;
                }
                break;
            }
        }


    }
}




class operationWindow extends JFrame implements ActionListener{
    mainOperations operations = new mainOperations();
    JPanel mainPanelWrapper, headerPanel, bodyElementPanel, buttonsPanel;

    JLabel titleLabel, mainBodyLabel;
    JButton button, calculate, backButton;
    JLabel[] textFieldTitle;
    JTextField[] userInput;

    int eventIndex;
    double[] numberInput;



    // ************************ Variables for the Conversion Window ************************

    JLabel[] labelElements, labelElementsTitle;

    JTextField[] resultFields;


    JTextField numberToConvert;
    JLabel ntc_Label, inputTitle, interactLabel;
    JButton convertButton;

    String[] conversionMenu = {"Decimal to Binary",  "Decimal to Hex", "Decimal to Octal" };
    String[] conversionTitle = {"Binary",  "Hex", "Octal" };




    /*-------------Operations Window -------------*/

    operationWindow(String operTitle, int event){
        // Indicator for what Operation to Use
        this.eventIndex = event;
        
        textFieldTitle = new JLabel[2];
        userInput = new JTextField[2];

        for(byte i = 0; i < 2; i++){

            textFieldTitle[i] = new JLabel("Input Number " + (i+1) + ": ");
            textFieldTitle[i].setHorizontalAlignment(JLabel.CENTER);

            userInput[i] = new JTextField();

            userInput[i].setPreferredSize(new Dimension(150, 150));
            userInput[i].setOpaque(true);
            userInput[i].setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(black,1) ,BorderFactory.createEmptyBorder(10, 10, 10, 10) ));

        }
        backButton = new JButton("Back to Menu");


        backButton.setHorizontalAlignment(JButton.CENTER);
        backButton.setFont(new Font("Calibri", Font.BOLD, 18));
        backButton.addActionListener(this);
        backButton.setFocusable(false);
        backButton.setBorder(BorderFactory.createEtchedBorder(1));

        calculate = new JButton("Calculate");


        calculate.setHorizontalAlignment(JButton.CENTER);
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
        bodyElementPanel.setLayout(new GridLayout(3,2,10,10));


        bodyElementPanel.add(textFieldTitle[0]);
        bodyElementPanel.add(textFieldTitle[1]);
        bodyElementPanel.add(userInput[0]);
        bodyElementPanel.add(userInput[1]);
        bodyElementPanel.add(calculate);
        bodyElementPanel.add(backButton);





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
    
    
    /*-------------Conversion Window -------------*/
    operationWindow(String operTitle){

        // ************************ Label Elements ************************

        labelElements = new JLabel[2];

        for(byte i=0; i < labelElements.length; i++){
            
            labelElements[i] = new JLabel();

            labelElements[i].setOpaque(true);
            // labelElements[i].setPreferredSize(new Dimension(150,100));
            // labelElements[i].setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            // labelElements[i].setBorder(BorderFactory.createLineBorder(black, 1));
        }
        labelElements[0].setPreferredSize(new Dimension(50,150));
        labelElements[0].setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        labelElements[0].setLayout(new GridLayout(3,2,5,5));
        

        // ************************ Items in the Label Elements index 0 (Top) ************************

        labelElementsTitle = new JLabel[3];
        resultFields = new JTextField[3];

        for(byte i =0; i < labelElementsTitle.length; i++){

            labelElementsTitle[i] = new JLabel();

            labelElementsTitle[i].setOpaque(true);
            labelElementsTitle[i].setBackground(white);
            labelElementsTitle[i].setText(conversionMenu[i]);
            labelElementsTitle[i].setBorder(BorderFactory.createEmptyBorder(10,10,10,10));


        // ************************ Result Fields ************************

            resultFields[i] = new JTextField();

            resultFields[i].setOpaque(true);
            resultFields[i].setBackground(lightGray);

            resultFields[i].setEditable(false);
            resultFields[i].setText(conversionTitle[i]);
            resultFields[i].setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(black,1) ,BorderFactory.createEmptyBorder(10, 10, 10, 10) ));





            labelElements[0].add(labelElementsTitle[i]);
            labelElements[0].add(resultFields[i]);
        }
        


        // ************************ Items in the Label Elements index 1 (Center) ************************


        // labelElements[1].setPreferredSize(new Dimension(50,50));
        labelElements[1].setLayout(new BorderLayout());
        
        inputTitle = new JLabel();

        inputTitle.setOpaque(true);
        inputTitle.setPreferredSize(new Dimension(100,50));
        inputTitle.setBackground(white);
        inputTitle.setText("<html><p style='color: #353839; word-wrap: break-word;'>Conversion</p></html>");
        inputTitle.setFont(new Font("Calibri", Font.BOLD, 25));
        inputTitle.setHorizontalAlignment(JLabel.CENTER);

        interactLabel = new JLabel();

        // interactLabel.setOpaque(true);
        // interactLabel.setBackground(white);




        // ************************ Items inside Interact Label ************************
        interactLabel.setPreferredSize(new Dimension(50,100));
        interactLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        interactLabel.setLayout(new GridLayout(2,2,10,10));


        numberToConvert = new JTextField();

        numberToConvert.setOpaque(true);
        numberToConvert.setBackground(white);
        numberToConvert.setText("Enter Number Here");
        numberToConvert.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(black,1) ,BorderFactory.createEmptyBorder(10, 10, 10, 10) ));


        ntc_Label = new JLabel();

        ntc_Label.setOpaque(true);
        ntc_Label.setBackground(white);
        ntc_Label.setText("Number to Convert");
        ntc_Label.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        
        backButton = new JButton("Back to Menu");

        backButton.setHorizontalAlignment(JButton.CENTER);
        backButton.setFont(new Font("Calibri", Font.BOLD, 18));
        backButton.addActionListener(this);
        backButton.setFocusable(false);
        // backButton.setBorder(BorderFactory.createEtchedBorder(1));


        convertButton = new JButton("Convert");

        convertButton.setHorizontalAlignment(JButton.CENTER);
        convertButton.setFont(new Font("Calibri", Font.BOLD, 18));
        convertButton.addActionListener(this);
        convertButton.setFocusable(false);
        // convertButton.setBorder(BorderFactory.createEtchedBorder(1));


        interactLabel.add(ntc_Label);
        interactLabel.add(numberToConvert);
        interactLabel.add(convertButton);
        interactLabel.add(backButton); 



        labelElements[1].add(inputTitle, BorderLayout.NORTH);
        labelElements[1].add(interactLabel, BorderLayout.CENTER);








        // ************************ Main Body Label in Body Element Panel ************************
        mainBodyLabel = new JLabel();

        mainBodyLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        mainBodyLabel.setLayout(new BorderLayout());

        mainBodyLabel.add(labelElements[0], BorderLayout.SOUTH);
        mainBodyLabel.add(labelElements[1], BorderLayout.CENTER);
        // mainBodyLabel.add(labelElements[2], BorderLayout.SOUTH);


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
        bodyElementPanel.setLayout(new BorderLayout());

        bodyElementPanel.add(mainBodyLabel, BorderLayout.CENTER);



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
        this.setSize(new Dimension(400,500));
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
        if(source == calculate){
            if(!userInput[0].getText().isEmpty() || !userInput[1].getText().isEmpty()){
                try{
                    operationEvent();
                }catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Invalid Input, try Again!");
                }
            }
            else
                JOptionPane.showMessageDialog(null, "Enter Numbers in the Specified Fields!");
        }
        else if(source == convertButton){
            JOptionPane.showMessageDialog(null, "Conversion AYYYYEEEE");
            // TODO : Convert Function 



        }
        else if(source == backButton){
            dispose();
            callBackMenu();
        }
    }
    public void conversionEvent(){
        // TODO: Create a function that takes the input, convert the input, and display the input.



    }



    public void operationEvent(){
        numberInput = new double[2];
        switch (eventIndex) {
            case 1:
                // Addition

//                JOptionPane.showMessageDialog(null, "Addition EYYY");
                for(byte i = 0; i < numberInput.length; i++){
                    numberInput[i] = Double.parseDouble(userInput[i].getText());
                }
                JOptionPane.showMessageDialog(null, "Result: " + operations.sumOfNum(numberInput));
                resetValue();
                break;
            case 2:
                // Subtraction

                // JOptionPane.showMessageDialog(null, "Subtraction EYYY");
                for(byte i = 0; i < numberInput.length; i++){
                    numberInput[i] = Double.parseDouble(userInput[i].getText());
                }
                JOptionPane.showMessageDialog(null, "Result: " + operations.diffOfNum(numberInput));
                resetValue();
                break;
            case 3:
                // Multiplication
                // JOptionPane.showMessageDialog(null, "Multiplication EYYY");
                for(byte i = 0; i < numberInput.length; i++){
                    numberInput[i] = Double.parseDouble(userInput[i].getText());
                }
                
                JOptionPane.showMessageDialog(null, "Result: " + operations.prodOfNum(numberInput));
                resetValue();
                break;
            case 4:
                // Division

                // JOptionPane.showMessageDialog(null, "Division EYYY");
                for(byte i = 0; i < numberInput.length; i++){
                    numberInput[i] = Double.parseDouble(userInput[i].getText());
                }
                if(numberInput[1] == 0){
                    JOptionPane.showMessageDialog(null, "Dividing By Zero is Not Allowed!, Try Again");
                    resetValue();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Result: " + operations.quotientOfNum(numberInput));
                    resetValue();
                }



                break;
            case 5:
                // Modulo

                // JOptionPane.showMessageDialog(null, "Modulo EYYY");
                for(byte i = 0; i < numberInput.length; i++){
                    numberInput[i] = Double.parseDouble(userInput[i].getText());
                }
                if(numberInput[1] == 0){
                    JOptionPane.showMessageDialog(null, "Dividing By Zero is Not Allowed!, Try Again");
                    resetValue();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Result: " + operations.moduloOfNum(numberInput));
                    resetValue();
                }

                break;
            case 7:
                // JOptionPane.showMessageDialog(null, "All Operations EYYY");
                for(byte i = 0; i < numberInput.length; i++){
                    numberInput[i] = Double.parseDouble(userInput[i].getText());
                }
                if(numberInput[1] == 0){
                    System.out.printf("Addition: %.2f\nSubtraction: %.2f\nMultiplication: %.2f\nDivision: Error!, dividing by zero is Invalid\nModulo: Error!, dividing by zero is Invalid", operations.sumOfNum(numberInput), operations.diffOfNum(numberInput), operations.prodOfNum(numberInput));
                    resetValue();
                }
                else {
                    System.out.printf("Addition: %.2f\nSubtraction: %.2f\nMultiplication: %.2f\nDivision: %.2f\nModulo: %.2f", operations.sumOfNum(numberInput), operations.diffOfNum(numberInput), operations.prodOfNum(numberInput), operations.quotientOfNum(numberInput), operations.moduloOfNum(numberInput));
                    resetValue();
                }

                break;
            default:
                JOptionPane.showMessageDialog(null, "Testing EYYY");
                // Default case (optional)
                break;
        }

    }

    public void callBackMenu(){
        new mainWindow();
    }
    public void resetValue(){
        userInput[0].setText("");
        userInput[1].setText("");
    }

}



class mainOperations{
    final int ARRAY_SIZE = 20;

    int numToConvert, index;
    int[] digits;
    
    char[] hexaDecimal;

    double sumOfNum(double[] num){
        return num[0] + num[1];
    }
    double diffOfNum(double[] num){
        return num[0] - num[1];
    }
    double prodOfNum(double[] num){
        return num[0] * num[1];
    }

    double quotientOfNum(double[] num){
        if(num[1] == 0){
            return 0;
        }
        return num[0] / num[1];
    }
    double moduloOfNum(double[] num){
        if(num[1] == 0){
            return 0;
        }
        return num[0] % num[1];
    }

    void decToBin(int numData){
        digits  = new int[ARRAY_SIZE];
        index = 0;
        while (numData > 0) {
            digits[index] = numData % 2;
            numData /= 2;
            index++;
        }

    }

    void decToOctal(int numData) {
        digits = new int[ARRAY_SIZE];
        index = 0;

        while(numData > 0) {
            digits[index] = numData % 8;
            numData /= 8;
            index++;
        }
    }

    void decToHex(int numData){
        hexaDecimal = new char[ARRAY_SIZE];
        index =0;
        while(numData > 0){

            hexaDecimal[index] = (numData%16 == 10) ? 'A' : (numData%16 == 11) ? 'B' :
                    (numData%16 == 12) ? 'C' : (numData%16 == 13) ? 'D' :
                            (numData%16 == 14) ? 'E' : (numData%16 == 15) ? 'F' :
                                    (char) ((numData%16)+48);
            numData /= 16;
            index++;
        }
    }
    
}





/*
class Operations{
//    Scanner in = new Scanner(System.in);
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

}*/
