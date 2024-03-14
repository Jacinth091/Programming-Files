import java.awt.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



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
class MainFrame extends JFrame implements ActionListener{
    final int windowWidth = 450;
    final int windowHeight = 450;
    int padding = 10;
//    JFrame mainFrame;
    JPanel mainPanelWrapper, childPanel;
    JLabel label, labelTwo;
    JButton buttonOne, buttonTwo;
//     JOptionPane messagePane;

    MainFrame(){

        this.setTitle("My Simple Calculator");


        this.setSize(windowWidth, windowHeight);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1,1,10,10));
//         this.setResizable(false);
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

        this.childPanel.setBackground(Color.gray);
       
        this.childPanel.setOpaque(true);


//        this.childPanel.setBounds(0, 0,windowWidth,250);
        this.childPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        this.childPanel.setBorder(BorderFactory.createEmptyBorder(padding,padding,padding,padding));
        this.childPanel.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.childPanel.setLayout(new GridLayout(2, 1));
        





        label = new JLabel("Simple Calculator ver.1");

        label.setOpaque(true);
        label.setBackground(Color.black);
        label.setForeground(Color.white);
        label.setBorder(BorderFactory.createLineBorder(Color.red, 1));
        label.setSize(new Dimension(windowWidth-15, 200));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Calibri",Font.BOLD, 20)); 


        labelTwo = new JLabel();
        labelTwo.setOpaque(true);
        labelTwo.setBackground(Color.white);
        labelTwo.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
        labelTwo.setLayout(new GridLayout(1,2));
        
        
        
        buttonOne = new JButton("start");
        
        
//         button.setBounds(120,100, 250,100);// 
//         button.setBounds(0,50, 100, 50);
        buttonOne.setFocusable(false);
        buttonOne.setForeground(Color.black);
        buttonOne.setBackground(Color.black);
        buttonOne.addActionListener(this);
        
        
        buttonTwo = new JButton("Exit");
        
        
//         button.setBounds(120,100, 250,100);// 
//         buttonTwo.setBounds(0,50, 100, 50);
        buttonTwo.setFocusable(false);
        buttonTwo.setForeground(Color.black);
        buttonTwo.setBackground(Color.black);
        buttonTwo.addActionListener(this);
        



        // ADD for mainFrames
        this.add(mainPanelWrapper);

        mainPanelWrapper.add(childPanel);
        
        
        childPanel.add(label);
        childPanel.add(labelTwo);
        
        
        
        labelTwo.add(buttonOne);
        labelTwo.add(buttonTwo);


        // ADD for mainPanels
//        this.mainPanel.add(label);


    }

   @Override
   public void actionPerformed(ActionEvent e){
        if(e.getSource() == buttonOne){
         System.out.println("Hellow!");
         JOptionPane.showMessageDialog(null, "Hello!!");
        
        }
        if(e.getSource() == buttonTwo){
         System.out.println("byeeee!");
         JOptionPane.showMessageDialog(null, "Byeee!!");
        
        }
   
   }

}



