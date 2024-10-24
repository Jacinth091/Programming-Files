package main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class Main {


    public static void main(String[ ]args){
/*        JFrame app = new MainFrame();
        MainPanel mp = new MainPanel();
        JPanel panel = new JPanel();

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setResizable(true);
        app.setTitle("Activity 9???");

        System.out.println(mp.screenHeight);
        System.out.println(mp.screenWidth);
        app.setPreferredSize(new Dimension(mp.screenWidth + 100,mp.screenHeight + (mp.screenHeight/3)));


        panel.setPreferredSize(new Dimension(150,150));
        panel.add(mp, BorderLayout.CENTER);

        app.add(panel, BorderLayout.CENTER);




        app.pack();
        app.setLocationRelativeTo(null);
        app.setVisible(true);*/

//        mp.startThread();

        appStart();

    }


    public static void appStart(){
        Border greyBorder = BorderFactory.createLineBorder(Color.gray, 20);
        JFrame app = new JFrame();
//        app.setSize(width, height);
        app.setTitle("SF Lab. Act. #09");
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setResizable(false);
        app.setLayout(new GridLayout(1,1));




        MainPanel mp = new MainPanel();

        app.setPreferredSize(new Dimension(mp.screenWidth + 100,mp.screenHeight + (mp.screenHeight/3)));
        JPanel container = new JPanel();
        container.setBorder(greyBorder);


        container.setLayout(new BorderLayout());
        container.add(mp, BorderLayout.CENTER);

        app.add(container);
        app.pack();

        app.setLocationRelativeTo(null);
        app.setVisible(true);

    }
}
