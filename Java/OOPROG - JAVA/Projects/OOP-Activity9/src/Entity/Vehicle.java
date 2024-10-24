package Entity;

import java.awt.*;

public interface Vehicle{


    void travel(String destination);
    void setLocation(int x, int y);
    void update();
    void draw(Graphics2D g2);



}
