/*
*   Name: Barral, Jacinth Cedric C.
*   Date: October 29, 2024
*   Description: SF Lab. Act. #09 - Decoupling and Dependency Injection in Java OOP: The Traveling Student
*
*
* */



package main;

import main.objects.*;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Student studentOne = new Student("Jacinth", "Traveller");

        App window = new App(studentOne,500, 700, "SF Lab. Act. #09", true, new BorderLayout(), JFrame.EXIT_ON_CLOSE);
        // Call pack() to size the frame to fit the preferred size
        window.pack();

        // Set visibility last to ensure everything is set up correctly
        window.setLocationRelativeTo(null);
        window.setVisible(true);

//        window.getUsername(studentOne.getStudName());
//        window.setStudentClass(studentOne);


    }


}
