package ActSixOOP;

public class Truck extends Vehicle{

    private int cargoCapacity;
    private int towingCapacity;
    private String fuelType;


    public Truck(String vehicleModel, String vehicleType, int maxSpeed, int cargoCapacity, int towingCapacity, String fuelType) {
        super(vehicleModel, vehicleType, maxSpeed);
        this.cargoCapacity = cargoCapacity;
        this.towingCapacity = towingCapacity;
        this.fuelType = fuelType;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Cargo Capacity: " + cargoCapacity + ".");
        System.out.println("Towing Capacity: " + towingCapacity + ".");
        System.out.println("Fuel Type: " + fuelType + ".");
    }


}
