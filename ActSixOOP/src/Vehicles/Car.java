package Vehicles;

public class Car extends Vehicle{
    private String fuelType;
    private int numberOfDoors;
    private String transmissionType;
    private int horsepower;


    public Car(String name, int maxSpeed, int numberOfDoors, String transmissionType, int horsepower, String fuelType) {
        super(name, maxSpeed);
        this.fuelType =fuelType;
        this.numberOfDoors = numberOfDoors;
        this.transmissionType = transmissionType;
        this.horsepower = horsepower;
    }


    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Number of Doors: " + numberOfDoors + ".");
        System.out.println("Transmission Type: " + transmissionType + ".");
        System.out.println("Horse Power: " + horsepower + ".");
        System.out.println("Fuel Type: " + fuelType + ".");
    }
}
