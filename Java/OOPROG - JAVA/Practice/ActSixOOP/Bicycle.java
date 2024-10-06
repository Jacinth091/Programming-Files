package ActSixOOP;

public class Bicycle extends Vehicle{

    private int numberOfGears;
    private String frameMaterial;
    private String brakeType;


    public Bicycle(String vehicleModel, String vehicleType, int maxSpeed, int numberOfGears, String frameMaterial, String brakeType) {
        super(vehicleModel, vehicleType, maxSpeed);
        this.numberOfGears = numberOfGears;
        this.frameMaterial = frameMaterial;
        this.brakeType = brakeType;
    }


    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Number of Gears: " + numberOfGears + " gears");
        System.out.println("Frame Material: " + frameMaterial);
        System.out.println("Brake Type: " + brakeType + " brakes");
    }
}
