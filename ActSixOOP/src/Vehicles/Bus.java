package Vehicles;

public class Bus extends Vehicle{

    private int passengerCapacity;
    private int numberOfAxles;
    private double length;
    String fuelType;

    public Bus(String name, int maxSpeed, int passengerCapacity, int numberOfAxles, double length, String fuelType) {
        super(name, maxSpeed);
        this.passengerCapacity = passengerCapacity;
        this.numberOfAxles = numberOfAxles;
        this.length = length;
        this.fuelType = fuelType;

    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Passenger Capacity: " + passengerCapacity + ".");
        System.out.println("Number of Axles: " + numberOfAxles + ".");
        System.out.println("Bus Length: " + length + ".");
        System.out.println("Fuel Type: " + fuelType + ".");
    }


}
