package main;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        App window = new App(500,700,"SF Lab. Act. #09",true,false, new BorderLayout(), JFrame.EXIT_ON_CLOSE);
        // Call pack() to size the frame to fit the preferred size
        window.pack();

        // Set visibility last to ensure everything is set up correctly
        window.setVisible(true);
        window.setLocationRelativeTo(null);

    }
}
