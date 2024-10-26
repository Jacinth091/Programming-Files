package Entity;

import Events.KeyInput;
import Events.MouseInput;
import main.MainPanel;

import java.awt.*;

public class Jeepney extends entity implements Vehicle {



    public Jeepney(MainPanel mp, MouseInput mI, KeyInput kI, String entityName){
        super(mp, mI, kI, entityName);
        setDefaults();
    }


    @Override
    public void travel(String destination) {
        System.out.println("Travelling to " +destination+ " by " + entityName);
    }

    @Override
    public void setLocation(int x, int y){
        worldXPos = x;
        worldYPos = y;
    }

    public void setDefaults(){

        worldXPos = (mp.screenWidth/2) - (mp.tileSize/2);
        worldYPos = ((mp.screenHeight / 2) - (mp.tileSize/2)) - (mp.screenHeight / 3);
        collider = new Rectangle(worldXPos,worldYPos,mp.tileSize, mp.tileSize);
        velocity = 10;
        runSpd =0;
        direction = "up";
    }
    @Override
    public void update() {
        System.out.println(mp.screenWidth);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.RED);
        g2.fillRect(worldXPos, worldYPos, mp.tileSize, mp.tileSize);
    }



    @Override
    public void getSprites() {

    }

    @Override
    public void entityMove() {

    }

    @Override
    public void checkOutOfBounds() {

    }

    @Override
    public void getCoordinates() {

    }
}
