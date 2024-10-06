package ActSixOOP;

public class Bus extends Vehicle{

    private int passengerCapacity;
    private double length;
    private String fuelType;

    public Bus(String vehicleModel, String vehicleType, int maxSpeed, int passengerCapacity, double length, String fuelType) {
        super(vehicleModel, vehicleType, maxSpeed);
        this.passengerCapacity = passengerCapacity;
        this.length = length;
        this.fuelType = fuelType;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Passenger Capacity: " + passengerCapacity + " passengers.");
        System.out.println("Bus Length: " + length + " meters");
        System.out.println("Fuel Type: " + fuelType + "");
    }


}
