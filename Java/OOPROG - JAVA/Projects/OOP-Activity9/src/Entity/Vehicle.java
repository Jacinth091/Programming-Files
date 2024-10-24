package Entity;

import Events.MouseInput;
import main.MainPanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Vehicle {
    protected String vehicleType;
    protected BufferedImage vhSprite;
    protected int vehicleSpeed;
    protected int vehicleCapacity;

    protected MouseInput mI;
    protected MainPanel mp;

    public Vehicle(){}

    public Vehicle(MainPanel mp, MouseInput mI){
        this.mp = mp;
        this.mI = mI;
    }


    public abstract void update();
    public abstract void draw(Graphics2D g2);

}
