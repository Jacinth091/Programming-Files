package Main;

import javax.swing.JFrame;
public class Main {
    public static void main(String[] args){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        window.setSize(300,300);
        window.setResizable(false);
        window.setTitle("Eric's Adventure");

        // Game Panels
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        gamePanel.startGameThread();


        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
