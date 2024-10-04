package Vehicles;
public class Vehicle {
    String name;
    int maxSpeed;

    public Vehicle(String name, int maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    public void displayInfo() {
        System.out.println("Vehicle Name: " + name);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}
