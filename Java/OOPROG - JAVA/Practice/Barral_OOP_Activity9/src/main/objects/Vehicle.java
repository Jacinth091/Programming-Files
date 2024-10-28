package main.objects;

import javax.swing.*;

public interface Vehicle {

    void travelTo(String destination);
    String getVhName();
    String getVhType();
    int getVhSpeed();
    int getVhCapacity();

}
