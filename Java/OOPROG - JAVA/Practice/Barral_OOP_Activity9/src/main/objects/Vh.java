package main.objects;

import java.awt.image.BufferedImage;

public abstract class Vh {
    private String vhName;
    private String vhType;
    private BufferedImage vhSprite;
    private int vhSpeed;
    private int vhCapacity;


    public Vh(String vhName, String vhType, int vhSpeed, int vhCapacity) {
        this.vhName = vhName;
        this.vhType = vhType;
        this.vhSpeed = vhSpeed;
        this.vhCapacity = vhCapacity;
    }


    public abstract void getVehicleImage();
}
