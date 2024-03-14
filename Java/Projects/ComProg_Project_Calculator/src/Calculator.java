import java.awt.*;
import java.util.Scanner;
import javax.swing.*;


public class Calculator {
    public static void main(String[] args) {

        MainFrame myFrame = new MainFrame();
//        MAIN.frame.setVisible(true);
//        Scanner in = new Scanner(System.in);
//        char oper;
//        int num1, num2;
//        int result;
//
//        System.out.println("Input Integer 1: ");
//        num1 = in.nextInt();
//        in.nextLine();
//
//        System.out.println("Input Integer 2: ");
//        num2 = in.nextInt();
//        in.nextLine();
//
//        System.out.println("Input what Operation to use ( + - / *):  ");
//        oper = in.next().charAt(0);
//        in.nextLine();



    }
}
class MainFrame extends JFrame{
    final int windowWidth = 450;
    final int windowHeight = 450;
    int padding = 10;
//    JFrame mainFrame;
    JPanel mainPanelWrapper, childPanel;
    JLabel label;
    JButton button;

    MainFrame(){

        this.setTitle("My Simple Calculator");


        this.setSize(windowWidth, windowHeight);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1,1,10,10));
//        this.setResizable(false);
        this.setVisible(true);



        // Main Panel Wrapper
        this.mainPanelWrapper = new JPanel();


        this.mainPanelWrapper.setBackground(Color.lightGray);
        this.mainPanelWrapper.setOpaque(true);
        this.mainPanelWrapper.setBorder(BorderFactory.createLineBorder(Color.black));
        this.mainPanelWrapper.setBorder(BorderFactory.createEmptyBorder(padding,padding,padding,padding));
        this.mainPanelWrapper.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.mainPanelWrapper.setLayout(new GridLayout(1,1));
        
        
        // Child Panel
        this.childPanel = new JPanel();

        this.childPanel.setBackground(Color.blue);
        this.childPanel.setOpaque(true);


//        this.childPanel.setBounds(0, 0,windowWidth,250);
        this.childPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        this.childPanel.setBorder(BorderFactory.createEmptyBorder(padding,padding,padding,padding));
        this.childPanel.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.childPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        





//        this.label = new JLabel("Welcome to Simple Calculator ver.1");
//
//        this.label.setBorder(BorderFactory.createLineBorder(Color.red, 1));
//        this.label.setSize(new Dimension(windowWidth-15, 200));
//        this.label.setHorizontalAlignment(SwingConstants.CENTER);




        // ADD for mainFrames
        this.add(mainPanelWrapper);

        mainPanelWrapper.add(childPanel);


        // ADD for mainPanels
//        this.mainPanel.add(label);


    }



}
