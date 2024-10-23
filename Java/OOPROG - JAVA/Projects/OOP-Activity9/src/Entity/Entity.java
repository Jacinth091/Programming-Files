package Entity;

import java.awt.image.BufferedImage;

public class Entity {

    protected int worldXPos;
    protected int worldYPos;
    protected int walkSpd;
    protected String direction;

    protected int spriteCounter =0;
    protected int spriteNum = 1;

    protected int runSpd;

    protected boolean collision = false;

    protected BufferedImage[] walking_sprites;


}
