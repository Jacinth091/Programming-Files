package Entity;

import Events.KeyInput;
import Events.MouseInput;
import main.MainPanel;

import java.awt.*;

public class Motorcycle extends Entity implements Vehicle{

    public Motorcycle(MainPanel mp, MouseInput mI, KeyInput kI){
        super(mp, mI, kI);


        setDefaults();
    }


    @Override
    public void travel(String destination) {

    }

    @Override
    public void setLocation(int x, int y){
        worldXPos = x;
        worldYPos = y;
    }


    public void setDefaults(){
        worldXPos = (mp.screenWidth/2) - (mp.tileSize/2);
        worldYPos = ((mp.screenHeight / 2) - (mp.tileSize/2)) - (mp.screenHeight / 3);
        velocity = 10;
        runSpd =0;
        direction = "up";
    }





    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.BLUE);
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
