package main;

import main.objects.*;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        App window = new App(500, 700, "SF Lab. Act. #09", true, new BorderLayout(), JFrame.EXIT_ON_CLOSE);
        // Call pack() to size the frame to fit the preferred size
        window.pack();

        // Set visibility last to ensure everything is set up correctly
        window.setLocationRelativeTo(null);
        window.setVisible(true);


//        ConfirmFrame cf = new ConfirmFrame();
//        cf.setLayout(new BorderLayout());
//        cf.setPreferredSize(new Dimension(500,700));
//        cf.setVisible(true);
//        cf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        cf.initMain();
//
//
//        cf.pack();
//        cf.validate();
//        cf.setLocationRelativeTo(null);






        Vehicle[] vhObjs = {
                new Jeepney("Jeepney", "Land", 40, 20),
                new Motorcycle("Motorcycle", "Land", 80, 2),
                new Helicopter("Helicopter", "Air", 200, 5),
                new Sailboat("Sailboat", "Water", 30, 15),
                new Bicycle("Bicycle", "Land", 15, 1)
        };


        Student student = new Student("Jacinth", "Traveller");

        student.getVehicle(vhObjs[0]);
        student.travelTo("Mars");

    }


}
