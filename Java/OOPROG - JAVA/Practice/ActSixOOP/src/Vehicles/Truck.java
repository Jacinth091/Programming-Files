package Vehicles;

public class Truck extends Vehicle{

    private int cargoCapacity;
    private double bedLength;
    private int towingCapacity;
    private String fuelType;


    public Truck(String name, int maxSpeed, int cargoCapacity, double bedLength, int towingCapacity, String fuelType) {
        super(name, maxSpeed);
        this.cargoCapacity = cargoCapacity;
        this.bedLength = bedLength;
        this.towingCapacity = towingCapacity;
        this.fuelType = fuelType;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Cargo Capacity: " + cargoCapacity + ".");
        System.out.println("Bed Length: " + bedLength + ".");
        System.out.println("Towing Capacity: " + towingCapacity + ".");
        System.out.println("Fuel Type: " + fuelType + ".");
    }


}
