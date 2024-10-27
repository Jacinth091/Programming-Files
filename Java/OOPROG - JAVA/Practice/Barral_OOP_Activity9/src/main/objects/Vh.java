package main.objects;

//import javax.swing.*;
import javax.swing.ImageIcon;

public abstract class Vh {
    private String vhName;
    private String vhType;
    private ImageIcon vhIcon;
    private int vhSpeed;
    private int vhCapacity;


    public Vh(String vhName, String vhType, int vhSpeed, int vhCapacity) {
        this.vhName = vhName;
        this.vhType = vhType;
        this.vhSpeed = vhSpeed;
        this.vhCapacity = vhCapacity;
    }


    public abstract void getVehicleImage();


    public String getVhName() {
        return vhName;
    }

    public String getVhType() {
        return vhType;
    }

    public ImageIcon getVhIcon() {
        return vhIcon;
    }

    public int getVhSpeed() {
        return vhSpeed;
    }

    public int getVhCapacity() {
        return vhCapacity;
    }
}
