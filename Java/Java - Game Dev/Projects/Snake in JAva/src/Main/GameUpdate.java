package Main;

import Entity.Player;

import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;
import java.awt.event.KeyListener;

public class GameUpdate extends JPanel implements Runnable{

    final int FPS = 30;
    public final int ORIG_TILE_SIZE =16;
    final int SCALE =3;
    public final int TILE_SIZE = ORIG_TILE_SIZE * SCALE; // 16 * 2 = 32 Tile Size

    public final int MAX_SCREEN_COL = 16;
    public final int MAX_SCREEN_ROW = 16;

    public final int SCREEN_WIDTH = MAX_SCREEN_COL * TILE_SIZE; // 576 pixels
    public final int SCREEN_HEIGHT = MAX_SCREEN_ROW * TILE_SIZE; // 576 pixels

    private Thread gameThread;

    private InputManager input;

    // Player

    public Player player;


    // DELTA TIME

//    public double delta =0;


    // Test Variables

    public int playerX = 100;
    public int playerY = 100;
    public int  speed = 2;

    public GameUpdate(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

        input = new InputManager();
        this.addKeyListener(input);
        this.setFocusable(true);

        player = new Player(this, input);

    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run(){

        gameLoopThread();

    }

    private void gameLoopThread(){
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
//                System.out.println("x Pos: " + player.worldX + " y Pos: " + player.worldY);

                System.out.println("FPS: " + drawCount);
                System.out.println("Hello");

                drawCount = 0;
                timer = 0;
            }
        }
    }


    public void update(){

    player.update();


    }


//    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        player.drawSprite(g2);

//        g2.setColor(Color.white);
//        g2.fillRect((playerX + speed ) + (int)delta,(playerY + speed ) + (int)delta, TILE_SIZE, TILE_SIZE );

        g2.dispose();

    }




}
