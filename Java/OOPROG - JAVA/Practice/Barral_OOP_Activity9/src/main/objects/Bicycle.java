package main.objects;

import javax.swing.*;

public class Bicycle extends Vh implements Vehicle{


    public Bicycle(String vhName, String vhType, int vhSpeed, int vhCapacity) {
        super(vhName, vhType, vhSpeed, vhCapacity);
    }



    // OVERRIDES!!

    @Override
    public void travelTo(String destination) {
        System.out.println("Travelling to " +destination+ " by " + super.getVhName());
    }



    @Override
    public String getVhName() {
        return super.getVhName();
    }

    @Override
    public String getVhType() {
        return super.getVhType();
    }

    @Override
    public int getVhSpeed() {
        return super.getVhSpeed();
    }

    @Override
    public int getVhCapacity() {
        return super.getVhCapacity();
    }
}
