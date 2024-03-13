import java.awt.*;
import java.util.Scanner;
import javax.swing.*;


public class Calculator {
    public static void main(String[] args) {

        mainFrame MAIN = new mainFrame();
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
class mainFrame {

    JFrame frame;
    JPanel panel;
    JLabel label;
    JButton button;

    mainFrame(){

        this.frame = new JFrame("My Simple Calculator");


        this.frame.setSize(new Dimension(450,450));
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setLayout(new GridLayout(2,1,10,10));
        this.frame.setResizable(false);
        this.frame.setVisible(true);




        this.panel = new JPanel();


        this.panel.setBackground(Color.gray);
        this.panel.setOpaque(true);
        this.panel.setBounds(100, 100,500,250);
        this.panel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        this.panel.setLayout(null);






        this.label = new JLabel("Welcome to Simple Calculator ver.1");

        this.label.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        this.label.setSize(new Dimension(500, 250));
        this.label.setHorizontalTextPosition(10);




        // ADD for Frames
        this.frame.add(panel);


        // ADD for Panels
        this.panel.add(label);


    }



}
