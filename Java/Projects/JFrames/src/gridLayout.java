import javax.swing.*;
import java.awt.*;

public class gridLayout {
    public static void main(String[] args) {
        // Layout Manager = Defines the natural layout for components wihtin a container
        //
        // Grid Layout =    places components in a grid of cells
        //                  Each component takes all the available space within its cells,
        //                  and each cell is the same size.


        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setTitle("Grid Layout");
        frame.setLayout(new GridLayout(3,3, 10,10));

        for(byte i = 0; i < 9; i++){
            frame.add(new JButton(Integer.toString(i+1)));
        }


        frame.setVisible(true);

    }





}
