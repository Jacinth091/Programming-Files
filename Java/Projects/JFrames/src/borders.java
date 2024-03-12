import javax.swing.*;
import java.awt.*;


public class borders {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setTitle("Border Layouting!!!");
        frame.setLayout(new BorderLayout(10, 10));
        frame.setVisible(true);

        /*----------------MAIN PANELS----------------*/

        JPanel panelOne = new JPanel();
        JPanel panelTwo = new JPanel();
        JPanel panelThree = new JPanel();
        JPanel panelFour = new JPanel();
        JPanel panelFive = new JPanel();

        panelOne.setBackground(Color.red);
        panelTwo.setBackground(Color.green);
        panelThree.setBackground(Color.yellow);
        panelFour.setBackground(Color.magenta);
        panelFive.setBackground(Color.blue);

        panelFive.setLayout(new BorderLayout());

        panelOne.setPreferredSize(new Dimension(100,100));
        panelTwo.setPreferredSize(new Dimension(100,100));
        panelThree.setPreferredSize(new Dimension(100,100));
        panelFour.setPreferredSize(new Dimension(100,100));
        panelFive.setPreferredSize(new Dimension(100,100));

        /*----------------SUB PANELS----------------*/

        JPanel subPanel1 = new JPanel();
        JPanel subPanel2 = new JPanel();
        JPanel subPanel3 = new JPanel();
        JPanel subPanel4 = new JPanel();
        JPanel subPanel5 = new JPanel();

        subPanel1.setBackground(Color.black);
        subPanel2.setBackground(Color.darkGray);
        subPanel3.setBackground(Color.gray);
        subPanel4.setBackground(Color.lightGray);
        subPanel5.setBackground(Color.white);

        subPanel1.setPreferredSize(new Dimension(50,50));
        subPanel2.setPreferredSize(new Dimension(50,50));
        subPanel3.setPreferredSize(new Dimension(50,50));
        subPanel4.setPreferredSize(new Dimension(50,50));
        subPanel5.setPreferredSize(new Dimension(50,50));

        panelFive.add(subPanel1, BorderLayout.NORTH);
        panelFive.add(subPanel2, BorderLayout.EAST);
        panelFive.add(subPanel3, BorderLayout.WEST);
        panelFive.add(subPanel4, BorderLayout.SOUTH);
        panelFive.add(subPanel5, BorderLayout.CENTER);
        /*----------------SUB PANELS----------------*/




        frame.add(panelOne, BorderLayout.NORTH);
        frame.add(panelTwo, BorderLayout.EAST);
        frame.add(panelThree, BorderLayout.WEST);
        frame.add(panelFour, BorderLayout.SOUTH);
        frame.add(panelFive, BorderLayout.CENTER);



    }
}
