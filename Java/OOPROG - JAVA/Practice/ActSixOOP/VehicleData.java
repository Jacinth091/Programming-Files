package ActSixOOP;

import java.util.Random;

public class VehicleData {

    public static VehicleData vhDataInstance;


    private final Random rand = new Random();
    private final String[][] vehicleNames = {
            {"Honda Civic", "Toyota Corolla", "Ford Mustang", "Tesla Model 3", "BMW 3 Series", "Audi A4", "Chevrolet Camaro"}, // Cars
            {"Mercedes-Benz Sprinter", "Volvo B8R", "Blue Bird Vision", "Tata Starbus", "Scania Touring", "MAN Lion's City", "Setra TopClass"}, // Bus
            {"Ford F-150", "Chevrolet Silverado", "Ram 1500", "GMC Sierra 1500", "Toyota Tundra", "Nissan Titan", "Jeep Gladiator"}, // Trucks
            {"Giant Escape 3", "Trek FX 3", "Schwinn Discover", "Cannondale Quick 4", "Specialized Sirrus", "Bianchi C-Sport", "Cube SL Road"}, // Bicycle
    };

    private final String[] vehicleTypes = {"Car", "Bus", "Truck", "Bicycle"};


    private final String[][] stringVhAttrib = {
            {"Petrol", "Diesel", "Electric"}, // Fuel Type = Car, Bus, Truck
            {"Automatic", "Manual"},           // Transmission Type = Car
            {"Aluminum", "Steel", "Carbon Fiber"}, // Frame Materials = Bicycle
            {"Disc", "Rim"}                    // Brake Type = Bicycle
    };

    private final int[][] intVhAttrib = {
            {2, 4, 5},       // Number of Doors (Cars)

            {10, 20, 50},    // Passenger Capacity (Buses)

            {15, 30, 50},    // Cargo Capacity (Trucks)
            {1000, 2000, 3000}, // Towing Capacity (Trucks)

            {1, 7, 21}       // Number of Gears (Bicycles)

    };
    private final int[][] vhMaxSpeedHighLow = {
            {350, 180}, // Cars
            {120, 80},  // Bus
            {140, 100}, // Trucks
            {70,  30}  // Bicycles
    };

    private int[] vehicleMaxSpeeds = {
            genRandNum(vhMaxSpeedHighLow[0][0], vhMaxSpeedHighLow[0][1]), // cars
            genRandNum(vhMaxSpeedHighLow[1][0], vhMaxSpeedHighLow[1][1]), // Bus
            genRandNum(vhMaxSpeedHighLow[2][0], vhMaxSpeedHighLow[2][1]), // Trucks
            genRandNum(vhMaxSpeedHighLow[3][0], vhMaxSpeedHighLow[3][1]), // Bicycles
    };


    // Example of double attributes (if needed)
    private final double[] doubleVhAttrib = {4.5, 5.0, 6.0}; // Length (Buses/Trucks in meters)};
    private final int objectSize = 20;

    private VehicleData(){}

    public static VehicleData getInstance(){

        if(vhDataInstance == null){
            vhDataInstance = new VehicleData();
        }

        return vhDataInstance;
    }






    public  int genRandNum(int max) {
        return rand.nextInt(max);
    }

    public  int genRandNum(int max, int min) {
        return rand.nextInt(max - min) + min;
    }





    public void echo(){
        System.out.println("Hi!, Hello!");
    }

    public String[][] getVehicleNames() {
        return vehicleNames;
    }

    public String[] getVehicleTypes() {
        return vehicleTypes;
    }

    public Random getRand() {
        return rand;
    }

    public int getObjectSize() {
        return objectSize;
    }


    public String[][] getStringVhAttrib() {
        return stringVhAttrib;
    }

    public int[][] getIntVhAttrib() {
        return intVhAttrib;
    }

    public double[] getDoubleVhAttrib() {
        return doubleVhAttrib;
    }

    public int[] getVehicleMaxSpeeds() {
        return vehicleMaxSpeeds;
    }

    public int[][] getVhMaxSpeedHighLow() {
        return vhMaxSpeedHighLow;
    }
}
