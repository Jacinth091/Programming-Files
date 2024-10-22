package main;

import javax.swing.JPanel;
import java.awt.*;

public class MainPanel extends JPanel implements Runnable{

    public int orgTileSize = 16;
    public final int tileSize = orgTileSize * 2;

    public final int screenWidth = tileSize * 20;
    public final int screenHeight = tileSize *10;

    private Thread mainThread;

    private final long nanoTime = 1000000000;

    private int FPS = 30;

    public MainPanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
//        this.addKeyListener(keyH);
        this.setFocusable(true);
    }


    @Override
    public void run() {
//        deltaTimeFPS();
    }

    public void startThread(){
        mainThread = new Thread(this);
        mainThread.start();
    }


    public void update(){

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

//        g2.drawImage(null, 0, 0 ,tileSize, tileSize, null);
        g2.setColor(Color.white);
        g2.setBackground(Color.white);
//        g2.fill(100, 100, tileSize, tileSize);
        g2.fillRect(100, 100, tileSize, tileSize);


        g2.dispose();
    }

    public void deltaTimeFPS(){
        double drawInterval = nanoTime/FPS;
        double delta =0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(mainThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime ) / drawInterval;

            lastTime = currentTime;

            if(delta >= 1){
                // UPDATE: Update information (Movement, Health, etc)
                update();

                // DRAW: Draw or Re-Draw the screen with the updated information
                repaint();

                delta--;
            }
        }
    }


}
