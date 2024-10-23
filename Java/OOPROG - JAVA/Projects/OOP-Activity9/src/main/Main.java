package main;

import javax.swing.JFrame;


public class Main {


    public static void main(String[ ]args){
        JFrame app = new JFrame();

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setResizable(false);
        app.setTitle("Activity 9???");

        MainPanel mainPanel = new MainPanel();
        app.add(mainPanel);
        app.pack();


        app.setLocationRelativeTo(null);
        app.setVisible(true);

        mainPanel.startThread();



    }

}
