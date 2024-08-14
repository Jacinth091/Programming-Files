package Main;

import Entity.Player;
import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    // SCREEN SETTINGS
    final int originalTileSize = 16; //16x16 size
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; // 48x48
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;

    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    // FPS (Frame Per Second) to run the game

    final int FPS =60;

    // Game CLock (Game Update)
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    // Player

    Player player = new Player(this, keyH);

    // Player Positions

    int playerXPos = 100;
    int playerYPos = 100;

    int playerSpd = 5;


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.lightGray);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
 /*   @Override
    public void run() {
        // Game Loop
        while(gameThread != null){

            // Current time
            double drawInterval = 1000000000/FPS;
            double nextDrawTime = System.nanoTime() + drawInterval;


            // UPDATE : update information (character position)
            update();

            // DRAW : draw the information on to the SCREEN
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 100000;

                if(remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }*/


    @Override
    public void run(){

        // Delta Time Method

        double drawInterval = 1000000000/FPS;
        double delta =0;
        long lastTime = System.nanoTime();
        long currentTime;

        long timer = 0;
        long drawCount = 0;

        while(gameThread != null){

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);

//            System.out.println("Before : Delta Time: " + delta);

            lastTime = currentTime;
//            System.out.println("Delta Time: " + delta);

            if(delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000){
                System.out.println("x Pos: " + player.x + " y Pos: " + player.y);

//                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update(){
        player.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        player.draw(g2);

        g2.dispose();

    }
}
