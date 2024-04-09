import java.util.Scanner;

public class Inheritance {

    public static void main(String[] args) {

        // inheritance = the process where one class acquires,
        // the attributes and methods of another

        Car car = new Car();

        car.go("Tesla");
        car.stop("Tesla");

        System.out.println();
        Bicycle bike = new Bicycle();

        bike.go("MTB-9256");
        bike.stop("MTB-9256");

    }
}

class Vehicle {
    double speed;

    void go(String name) {
        System.out.printf("\nThe %s is moving!\n", name);
    }

    void stop(String name) {
        System.err.printf("\nThe %s has stopped!", name);
    }
}

class Car extends Vehicle {

}

class Bicycle extends Vehicle {

}