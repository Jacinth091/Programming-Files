package Entity;

import java.awt.image.BufferedImage;

public abstract class Entity {

    protected int worldXPos;
    protected int worldYPos;
    protected int plyVelocity;
    protected String direction;
    protected int dirX, dirY;

    protected int spriteCounter =0;
    protected int spriteNum = 1;

    protected int runSpd;

    protected boolean collision = false;

    protected BufferedImage[] walking_sprites;



    public abstract void getSprites();

    public abstract void entityMove();

    public abstract void checkOutOfBounds();

    public abstract void getCoordinates();

}
