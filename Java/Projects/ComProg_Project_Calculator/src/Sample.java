import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Sample {
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
    JFrame mainFrame;
    JPanel mainPanelWrapper, childPanel, buttonsPanelWrapper, startButtonPanel, exitButtonPanel;
    JLabel titleLabel, startButtonLabel, exitButtonLabel;
    JButton startButton, exitButton;
//     JOptionPane messagePane;

    MainFrame(){

        this.setTitle("My Simple Calculator");


        this.setSize(windowWidth, windowHeight);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1,1,10,10));
        this.setResizable(false);
        this.setVisible(true);



        // Main Panel Wrapper
        mainPanelWrapper = new JPanel();

        mainPanelWrapper.setBackground(Color.lightGray);
        mainPanelWrapper.setOpaque(true);
        mainPanelWrapper.setBorder(BorderFactory.createLineBorder(Color.black));
        mainPanelWrapper.setBorder(BorderFactory.createEmptyBorder(padding,padding,padding,padding));
        mainPanelWrapper.setPreferredSize(new Dimension(windowWidth, windowHeight));
        mainPanelWrapper.setLayout(new GridLayout(1,1));
        
        
        
        // Child Panel
        childPanel = new JPanel();

        childPanel.setBackground(Color.gray);
        childPanel.setOpaque(true);


//        childPanel.setBounds(0, 0,windowWidth,250);
        childPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        childPanel.setBorder(BorderFactory.createEmptyBorder(padding,padding,padding,padding));
        childPanel.setPreferredSize(new Dimension(windowWidth, windowHeight));
        childPanel.setLayout(new GridLayout(2, 1));
        





        titleLabel = new JLabel("<html><div style='border:none;'><p style='" +
                "color: white; " +
                "word-wrap: break-word; " +
                "text-align: center;" +
                "padding: 10px; " +
                "font-size: 30px;" +
                "" +
                "'>" +
                "Simple Calculator <b>version. 1</p></div></html>");

        titleLabel.setOpaque(true);
//        titleLabel.setBackground(Color.black);
        titleLabel.setForeground(Color.white);
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.red, 1));
        titleLabel.setSize(new Dimension(windowWidth-15, 200));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Calibri",Font.BOLD, 20)); 

        // Buttons Panel Wrapper
        buttonsPanelWrapper = new JPanel();

        buttonsPanelWrapper.setOpaque(true);
        buttonsPanelWrapper.setBackground(Color.white);
//        buttonsPanelWrapper.setBorder(BorderFactory.createLineBorder(Color.red, 20));
        buttonsPanelWrapper.setBorder(BorderFactory.createEmptyBorder(padding,padding,padding,padding));
        buttonsPanelWrapper.setLayout(new GridLayout(1,2, 10,0));
        

        startButtonPanel = new JPanel();

        startButtonPanel.setOpaque(true);
        startButtonPanel.setBackground(Color.DARK_GRAY);
        startButtonPanel.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
        startButtonPanel.setBorder(BorderFactory.createEmptyBorder(padding*3,padding,padding*3,padding));
        startButtonPanel.setLayout(new BorderLayout());

        exitButtonPanel = new JPanel();

        exitButtonPanel.setOpaque(true);
        exitButtonPanel.setBackground(Color.DARK_GRAY);
        exitButtonPanel.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
        exitButtonPanel.setBorder(BorderFactory.createEmptyBorder(padding*3,padding,padding*3,padding));
        exitButtonPanel.setLayout(new BorderLayout());




        startButtonLabel = new JLabel();

        startButtonLabel.setText("<html><div style='border:1px solid black;'><p style='color: black; " +
                "word-wrap: break-word; " +
                "text-align: center;" +
                "padding: 10px; " +
                "font-size: 12px;" +
                "" +
                "'>" +
                "Press the Start Button to Start the Program</p></div></html>");
        startButtonLabel.setOpaque(true);
//        startButtonLabel.setBounds(0,0,100,100);
        startButtonLabel.setForeground(Color.white);
        startButtonLabel.setBorder(BorderFactory.createLineBorder(Color.red, 1));
        startButtonLabel.setFont(new Font("Calibri",Font.BOLD, 20));


        exitButtonLabel = new JLabel();


        exitButtonLabel.setText("<html><div style='border:1px solid black;'><p style='color: black; " +
                "word-wrap: break-word; " +
                "text-align: center; " +
                "padding: 10px; " +
                "font-size: 12px;" +
                "" +
                "'>" +
                "Press the Exit Button to Exit the Program</p>" +
                "</div></html>");
        exitButtonLabel.setOpaque(true);
        exitButtonLabel.setForeground(Color.white);
        exitButtonLabel.setBorder(BorderFactory.createLineBorder(Color.red, 1));
        exitButtonLabel.setFont(new Font("Calibri",Font.BOLD, 20));




        startButton = new JButton("Start Program");

        startButton.setBounds(20,100,150,30);
        startButton.setFocusable(false);
        startButton.setForeground(Color.black);
        startButton.setBackground(Color.white);
//        startButton.addActionListener(this);
        

        exitButton = new JButton("Exit Program");

        exitButton.setBounds(0,0,150,30);
        exitButton.setFocusable(false);
        exitButton.setForeground(Color.black);
        exitButton.setBackground(Color.white);
//        exitButton.addActionListener(this);
        



        // ADD for mainFrames
        add(mainPanelWrapper);
        // Main Panel Wrapper
        mainPanelWrapper.add(childPanel);

        // Child Panel
        childPanel.add(titleLabel);
        childPanel.add(buttonsPanelWrapper);


        buttonsPanelWrapper.add(startButtonPanel);
        buttonsPanelWrapper.add(exitButtonPanel);


        startButtonPanel.add(startButtonLabel, BorderLayout.NORTH);
        startButtonPanel.add(startButton, BorderLayout.SOUTH);

        exitButtonPanel.add(exitButtonLabel, BorderLayout.NORTH);
        exitButtonPanel.add(exitButton, BorderLayout.SOUTH);



        revalidate();
        repaint();
        pack();
    }

   @Override
   public void actionPerformed(ActionEvent e){
        if(e.getSource() == startButton){
            System.out.println("Hellow!");
            JOptionPane.showMessageDialog(null, "Hello!!");
//            repaint();

        }
        if(e.getSource() == exitButton){
            System.out.println("byeeee!");
//            dispose();
            JOptionPane.showMessageDialog(null, "Byeee!!");


        }
   
   }

}



