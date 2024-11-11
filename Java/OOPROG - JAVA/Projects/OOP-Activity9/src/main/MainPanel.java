package main;

import Entity.*;
import Events.KeyInput;
import Events.MouseInput;

import javax.swing.JPanel;
import java.awt.*;

public class MainPanel extends JPanel implements Runnable{

    final int origTileSize = 16; // 16x16 tile
    final int scale =2;

    final public int tileSize = origTileSize * scale; // 48x48 tile size displayed on screen

    // 4 x 3 screen size
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 10;


    // Screen Width and Height Settings
    public final int screenWidth = tileSize * maxScreenCol; // 48 * 20 = 960 screen width
    public final int screenHeight = tileSize * maxScreenRow; // 48 * 10 = 480 screen height

    private Thread mainThread;

    private final long nanoTime = 1000000000;

    private int FPS = 24;

    private KeyInput kPut = new KeyInput();
    private MouseInput mouseIn = new MouseInput(this);

    private Student student = new Student(this, mouseIn, kPut, "player");
/*    private Vehicle jeepney = new Jeepney(this, mouseIn, kPut);
    private Vehicle motorcycle = new Motorcycle(this, mouseIn, kPut);
    private Vehicle heli = new Helicopter(this, mouseIn, kPut);*/

    private Vehicle[] vhObjs ={
            new Jeepney(this, mouseIn, kPut, "jeepney"),
            new Motorcycle(this, mouseIn, kPut,"jeepney"),
            new Helicopter(this, mouseIn, kPut, "jeepney")
    };


    public MainPanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);

        // Listeners

        this.addKeyListener(kPut);
        this.addMouseListener(mouseIn);
        this.addMouseMotionListener(mouseIn);

        startThread();
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
    public void startThread(){
        mainThread = new Thread(this);
        mainThread.start();
    }




    @Override
    public void run() {
        deltaTimeFPS();
    }

    public void update(){
        student.update();
//        mouseIn.update();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;



        drawVehicle(g2);
        student.draw(g2);

        mouseIn.draw(g2);

        g2.dispose();
    }





    public void drawVehicle(Graphics2D g2) {
        int numVehicles = vhObjs.length;
        int sectionWidth = screenWidth / numVehicles; // Divide screen width into equal sections
        // Fixed Y-position (same for all vehicles, adjust as needed)
        int yPosition = ((screenHeight / 2) - (tileSize / 2)) - (screenHeight / 3);
        for (int i = 0; i < vhObjs.length; i++) {
            // Calculate X position for each vehicle
            int xPosition = (sectionWidth * i) + (sectionWidth / 2) - (tileSize / 2);
            // Set vehicle's worldXPos and worldYPos
            vhObjs[i].setLocation(xPosition, yPosition);

            // Draw the vehicle at the calculated position
            vhObjs[i].draw(g2);
        }
    }




}
