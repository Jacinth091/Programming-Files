package main;

import javax.swing.*;
import java.awt.*;


public class Main {


    public static void main(String[ ]args){
        JFrame app = new MainFrame();
        MainPanel mp = new MainPanel();
        JPanel panel = new JPanel();

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setResizable(true);
        app.setTitle("Activity 9???");
        app.setPreferredSize(new Dimension(mp.screenWidth+100,mp.screenHeight + (mp.screenHeight /2)));


        System.out.println(mp.screenHeight);
        System.out.println(mp.screenWidth);
        panel.setPreferredSize(new Dimension(150,150));
        panel.add(mp);

        app.add(panel);
        app.pack();


        app.setLocationRelativeTo(null);
        app.setVisible(true);

//        mp.startThread();


    }



}
