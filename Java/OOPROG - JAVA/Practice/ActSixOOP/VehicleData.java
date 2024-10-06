package ActSixOOP;

import java.util.Random;

public class VehicleData {

    public static VehicleData vhDataInstance;

    private Car[] cars;
    private Bus[] busses;
    private Truck[] trucks;
    private Bicycle[] bicycles;

    private VehicleManager[] availableVehicles;
    private VehicleManager[] rentedVehicles;

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

    private String[] rentStatusTitles = {"Model", "Type","Rent Cost", "Rent Status", "Remaining Days", "Rent Duration", "Date Rented"};
    private String[] vehicleStatusTitles = {"Model","Type", "Vehicle Status"};

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

    private int[] vhBaseRate = {
            150, // Bicycle
            700, // Truck
            500, // Bus
            250, // Car
    };



    // Example of double attributes (if needed)
    private final double[] doubleVhAttrib = {4.5, 5.0, 6.0}; // Length (Buses/Trucks in meters)};
    private final int vehicleMultp = 3;
    private final int objectSize = vehicleTypes.length * vehicleMultp;


    private VehicleData(){}


    public void initObjects(){
        availableVehicles = new VehicleManager[objectSize];
        rentedVehicles = new VehicleManager[objectSize];
        initVehicles();
        initAvailableVehicles();
    }




    public void initVehicles(){
        int size = objectSize / vehicleTypes.length;
//        System.out.println(size);
//        System.out.println(objectSize);
        cars = new Car[size];
        busses = new Bus[size];
        trucks = new Truck[size];
        bicycles = new Bicycle[size];

        String[][] modelName = {
                vehicleNames[0], // cars
                vehicleNames[1], // bus
                vehicleNames[2], // trucks
                vehicleNames[3], // Bicycles
        };

        for(int i =0; i < size; i++){

//            System.out.println(vhDB.getVehicleMaxSpeeds()[i]);

            cars[i] = new Car(modelName[0][genRandNum(modelName[0].length)],
                    vehicleTypes[0],
                    genRandNum(vhMaxSpeedHighLow[0][0], vhMaxSpeedHighLow[0][1]),
                    intVhAttrib[0][genRandNum(intVhAttrib[0].length)],
                    stringVhAttrib[1][genRandNum(stringVhAttrib[1].length)],
                    stringVhAttrib[0][genRandNum(stringVhAttrib[0].length)]);


            busses[i] = new Bus(modelName[1][genRandNum(modelName[1].length)],
                    vehicleTypes[1],
                    genRandNum(vhMaxSpeedHighLow[1][0], vhMaxSpeedHighLow[1][1]),
                    intVhAttrib[1][genRandNum(intVhAttrib[1].length)],
                    doubleVhAttrib[genRandNum(doubleVhAttrib.length)],
                    stringVhAttrib[0][genRandNum(stringVhAttrib[0].length)]);

            trucks[i] = new Truck(modelName[2][genRandNum(modelName[2].length)],
                    vehicleTypes[2],
                    genRandNum(vhMaxSpeedHighLow[2][0], vhMaxSpeedHighLow[2][1]),
                    intVhAttrib[2][genRandNum(intVhAttrib[2].length)],
                    intVhAttrib[3][genRandNum(intVhAttrib[3].length)],
                    stringVhAttrib[0][genRandNum(stringVhAttrib[0].length)]);

            bicycles[i] = new Bicycle(modelName[3][genRandNum(modelName[3].length)],
                    vehicleTypes[3],
                    genRandNum(vhMaxSpeedHighLow[3][0], vhMaxSpeedHighLow[3][1]),
                    intVhAttrib[4][genRandNum(intVhAttrib[4].length)],
                    stringVhAttrib[2][genRandNum(stringVhAttrib[2].length)],
                    stringVhAttrib[3][genRandNum(stringVhAttrib[3].length)]);
        }




    }

    public void initAvailableVehicles(){

        int index = 0;

        for(Car car : cars){
            if(car != null){
                availableVehicles[index++] = new VehicleManager(car, true);
            }
        }

        for(Bus bus : busses){
            if(bus != null){
                availableVehicles[index++] = new VehicleManager(bus, true);
            }
        }
        for(Truck truck : trucks){
            if(truck != null){
                availableVehicles[index++] = new VehicleManager(truck, true);
            }
        }
        for(Bicycle bicycle : bicycles){
            if(bicycle != null){
                availableVehicles[index++] = new VehicleManager(bicycle, true);
            }
        }




    }

    public int getStrLen(String[] orgStr){
        int len = 0;
        for(String str : orgStr){
            if(str.length() > len){
                len = str.length();
            }
        }

        return len;
    }

    public int getStrLen(Vehicle[] vehicles){
        int len = 0;
        for(Vehicle vh : vehicles){
            String vhStr = vh.getVehicleModel();
            if(vhStr != null && vhStr.length() > len){
                len = vhStr.length();
            }
        }

        return len;
    }
    public int getStrLen(Vehicle vh){
        int len = 0;
        String vhStr = vh.getVehicleModel();
        if(vhStr != null && vhStr.length() > len){
            len = vhStr.length();
        }


        return len;
    }

    public int getStrLen(VehicleManager[] vhMan){
        int len = 0;
        if(vhMan == null){
            System.out.println("Vehicle Manager is Null!");
        }
        else{
            for(VehicleManager vhM : vhMan){
                if(vhM != null){
                    Vehicle vh = vhM.getVehicle();
                    String vhStr = vh.getVehicleModel();
                    if(vhStr != null && vhStr.length() > len){
                        len = vhStr.length();
                    }
                }
            }
        }


        return len;
    }



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

    public int getVhBaseRate(String vhType){
        int baseRate =0;
        switch(vhType){
            case "Bicycle":
                baseRate = 150;
                break;
            case "Truck":
                baseRate = 700;
                break;
            case "Bus":
                baseRate = 500;
                break;
            case "Car":
                baseRate = 250;
                break;
            default:
                System.out.println("Invalid Vehicle Type!");
                break;
        }
        return baseRate;
    }



    public void echo(){
        System.out.println("Hi!, Hello!");
    }


    public int getObjectSize() {
        return objectSize;
    }


    public String[] getVehicleStatusTitles() {
        return vehicleStatusTitles;
    }

    public String[] getRentStatusTitles(){
        return rentStatusTitles;
    }


    public VehicleManager[] getAvailableVehicles(){return availableVehicles;}

    public VehicleManager[] getRentedVehicles() {
        return rentedVehicles;
    }

}
