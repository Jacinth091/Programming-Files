package Main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args){
        JFrame windowApp = new JFrame();
        windowApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        window.setSize(300,300);
//        windowApp.setResizable(false);
        windowApp.setTitle("SNEK GEEMs");


        GameUpdate gu = new GameUpdate();
        windowApp.add(gu);
        gu.startGameThread();



        windowApp.pack();

        windowApp.setLocationRelativeTo(null);
        windowApp.setVisible(true);



    }
}
