package ActSixOOP;
public class Vehicle {
    private String vehicleModel;
    private String vehicleType;
    private int maxSpeed;

    public Vehicle(String vehicleModel,String vehicleType) {
        this.vehicleModel = vehicleModel;
        this.vehicleType =vehicleType;
    }

    public Vehicle(){}

    public Vehicle(String vehicleModel,String vehicleType, int maxSpeed) {
        this.vehicleModel = vehicleModel;
        this.vehicleType =vehicleType;
        this.maxSpeed = maxSpeed;
    }



    public void displayInfo() {
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Vehicle Name: " + vehicleModel);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
