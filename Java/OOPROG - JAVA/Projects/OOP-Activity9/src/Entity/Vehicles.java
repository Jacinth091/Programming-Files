package Entity;

import Events.KeyInput;
import Events.MouseInput;
import main.MainPanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Vehicles extends entity {
    protected String vehicleType;
    protected BufferedImage vhSprite;
    protected int vehicleSpeed;
    protected int vehicleCapacity;

    protected MouseInput mI;
    protected KeyInput kI;
    protected MainPanel mp;

    public Vehicles(){}

    public Vehicles(MainPanel mp, MouseInput mI, KeyInput kI){
        this.mp = mp;
        this.mI = mI;
        this.kI = kI;


    }


    public abstract void setLocation(int x, int y);

    public abstract void update();
    public abstract void draw(Graphics2D g2);




}
