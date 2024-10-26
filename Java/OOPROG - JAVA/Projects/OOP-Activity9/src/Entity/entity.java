package Entity;

import Events.KeyInput;
import Events.MouseInput;
import main.MainPanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class entity {

    protected String entityName;
    protected int worldXPos;
    protected int worldYPos;
    protected int velocity;
    protected String direction;
    protected int dirX, dirY;

    protected int spriteCounter =0;
    protected int spriteNum = 1;

    protected int runSpd;

    protected boolean collision = false;

    protected BufferedImage[] walking_sprites;
    protected Rectangle collider;


    protected MouseInput mI;
    protected KeyInput kI;
    protected MainPanel mp;

    public entity(){}

    public entity(MainPanel mp, MouseInput mI, KeyInput kI, String entityName){
        this.mp = mp;
        this.mI = mI;
        this.kI = kI;
        this.entityName = entityName;


    }


    public abstract void getSprites();

    public abstract void entityMove();

    public abstract void checkOutOfBounds();

    public abstract void getCoordinates();


}
