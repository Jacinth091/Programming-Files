package Vehicles;

public class Bicycle extends Vehicle{

    private int numberOfGears;
    private String frameMaterial;
    private String brakeType;
    private String tireType;


    public Bicycle(String name, int maxSpeed, int numberOfGears, String frameMaterial, String brakeType, String tireType) {
        super(name, maxSpeed);
        this.numberOfGears = numberOfGears;
        this.frameMaterial = frameMaterial;
        this.brakeType = brakeType;
        this.tireType = tireType;

    }


    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Number of Gears: " + numberOfGears + ".");
        System.out.println("Frame Material: " + frameMaterial + ".");
        System.out.println("Brake Type: " + brakeType + ".");
        System.out.println("Tire Type: " + tireType + ".");
    }
}
