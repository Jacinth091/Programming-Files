package ActSixOOP;
public class Car extends Vehicle{
    private String fuelType;
    private int numberOfDoors;
    private String transmissionType;


    public Car(String vehicleModel, String vehicleType, int maxSpeed, int numberOfDoors, String transmissionType, String fuelType) {
        super(vehicleModel, vehicleType, maxSpeed);
        this.numberOfDoors = numberOfDoors;
        this.transmissionType = transmissionType;
        this.fuelType = fuelType;
    }


    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Number of Doors: " + numberOfDoors + " doors");
        System.out.println("Transmission Type: " + transmissionType + " transmission");
        System.out.println("Fuel Type: " + fuelType);
    }
}
