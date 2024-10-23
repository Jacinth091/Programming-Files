package main;

import Entity.Player;
import Events.KeyInput;

import javax.swing.JPanel;
import java.awt.*;

public class MainPanel extends JPanel implements Runnable{

    final int origTileSize = 16; // 16x16 tile
    final int scale =3;

    final public int tileSize = origTileSize * scale; // 48x48 tile size displayed on screen

    // 4 x 3 screen size
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;


    // Screen Width and Height Settings
    public final int screenWidth = tileSize * maxScreenCol; // 48 * 16 = 768 screen width
    public final int screenHeight = tileSize * maxScreenRow; // 48 * 12 = 576 screen height

    private Thread mainThread;

    private final long nanoTime = 1000000000;

    private int FPS = 30;

    private KeyInput kPut = new KeyInput();
    private Player player = new Player(kPut, this);


    public MainPanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(kPut);
        this.setFocusable(true);
    }


    @Override
    public void run() {
        deltaTimeFPS();
    }

    public void startThread(){
        mainThread = new Thread(this);
        mainThread.start();
    }


    public void update(){
        player.update();
//        System.out.println("Player x: " + player.worldXPos);
//        System.out.println("Player y: " + player.worldYPos);

    }



    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;



        player.draw(g2);


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
