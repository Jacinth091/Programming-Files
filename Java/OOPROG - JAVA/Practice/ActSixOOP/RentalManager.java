package ActSixOOP;

import java.util.ArrayList;
import java.util.List;

public class RentalManager {

    private VehicleData vhDB = VehicleData.getInstance();
    private Customer[] customerRentalList;
    private Vehicle[] availableVehicles;
    private Vehicle[] rentedVehicles;
    private VehicleManager[] vhManager;

    private Car[] cars;
    private Bus[] busses;
    private Truck[] trucks;
    private Bicycle[] bicycles;

    private int maxRentalDuration = 30;  // in days
    private double discountRate = 0.1; // will be adjusted according to Customer's loyaltyStatus
    private double totalRevenue = 0.0;
    private double totalCost = 0.0;
    private double rentalRate = 10.0;

    // Constructor
    public RentalManager() {
        // Initialize the lists
        customerRentalList = new Customer[vhDB.getObjectSize()];
        availableVehicles = new Vehicle[vhDB.getObjectSize()];
        rentedVehicles = new Vehicle[vhDB.getObjectSize()];
        initVehicles();
        initAvailableVehicles();
    }



    public void initVehicles(){
        int size = vhDB.getObjectSize() / vhDB.getVehicleTypes().length;
        cars = new Car[size];
        busses = new Bus[size];
        trucks = new Truck[size];
        bicycles = new Bicycle[size];

        String[][] modelName = {
                vhDB.getVehicleNames()[0], // cars
                vhDB.getVehicleNames()[1], // bus
                vhDB.getVehicleNames()[2], // trucks
                vhDB.getVehicleNames()[3], // Bicycles
        };

        for(int i =0; i < size; i++){

//            System.out.println(vhDB.getVehicleMaxSpeeds()[i]);

            cars[i] = new Car(modelName[0][vhDB.genRandNum(modelName[0].length)],
                    vhDB.getVehicleTypes()[0],
                    vhDB.genRandNum(vhDB.getVhMaxSpeedHighLow()[0][0], vhDB.getVhMaxSpeedHighLow()[0][1]),
                    vhDB.getIntVhAttrib()[0][vhDB.genRandNum(vhDB.getIntVhAttrib()[0].length)],
                    vhDB.getStringVhAttrib()[1][vhDB.genRandNum(vhDB.getStringVhAttrib()[1].length)],
                    vhDB.getStringVhAttrib()[0][vhDB.genRandNum(vhDB.getStringVhAttrib()[0].length)]);


            busses[i] = new Bus(modelName[1][vhDB.genRandNum(modelName[1].length)],
                    vhDB.getVehicleTypes()[1],
                    vhDB.genRandNum(vhDB.getVhMaxSpeedHighLow()[1][0], vhDB.getVhMaxSpeedHighLow()[1][1]),
                    vhDB.getIntVhAttrib()[1][vhDB.genRandNum(vhDB.getIntVhAttrib()[1].length)],
                    vhDB.getDoubleVhAttrib()[vhDB.genRandNum(vhDB.getDoubleVhAttrib().length)],
                    vhDB.getStringVhAttrib()[0][vhDB.genRandNum(vhDB.getStringVhAttrib()[0].length)]);

            trucks[i] = new Truck(modelName[2][vhDB.genRandNum(modelName[2].length)],
                    vhDB.getVehicleTypes()[2],
                    vhDB.genRandNum(vhDB.getVhMaxSpeedHighLow()[2][0], vhDB.getVhMaxSpeedHighLow()[2][1]),
                    vhDB.getIntVhAttrib()[2][vhDB.genRandNum(vhDB.getIntVhAttrib()[2].length)],
                    vhDB.getIntVhAttrib()[3][vhDB.genRandNum(vhDB.getIntVhAttrib()[3].length)],
                    vhDB.getStringVhAttrib()[0][vhDB.genRandNum(vhDB.getStringVhAttrib()[0].length)]);

            bicycles[i] = new Bicycle(modelName[3][vhDB.genRandNum(modelName[3].length)],
                    vhDB.getVehicleTypes()[3],
                    vhDB.genRandNum(vhDB.getVhMaxSpeedHighLow()[3][0], vhDB.getVhMaxSpeedHighLow()[3][1]),
                    vhDB.getIntVhAttrib()[4][vhDB.genRandNum(vhDB.getIntVhAttrib()[4].length)],
                    vhDB.getStringVhAttrib()[2][vhDB.genRandNum(vhDB.getStringVhAttrib()[2].length)],
                    vhDB.getStringVhAttrib()[3][vhDB.genRandNum(vhDB.getStringVhAttrib()[3].length)]);
        }




    }



    public void initAvailableVehicles(){

        int index = 0;

        for(Car car : cars){
            if(car != null){
                availableVehicles[index++] = car;
            }
        }
        for(Bus bus : busses){
            if(bus != null){
                availableVehicles[index++] = bus;
            }
        }
        for(Truck truck : trucks){
            if(truck != null){
                availableVehicles[index++] = truck;
            }
        }
        for(Bicycle bicycle : bicycles){
            if(bicycle != null){
                availableVehicles[index++] = bicycle;
            }
        }




    }


    public void displayAvailableVehicles(){

        for(Vehicle vh : availableVehicles){
            System.out.println();
        }


    }

    public int getStrLen(Vehicle[] vehicles){
        int len = 0;
        for(Vehicle vh : vehicles){
//            String vhStr = vh.
//
//
//            if(str.length() > len){
//                len = str.length();
//            }
        }

        return len;
    }


    public Car[] getCars() {
        return cars;
    }

    public Bus[] getBusses() {
        return busses;
    }

    public Truck[] getTrucks() {
        return trucks;
    }

    public Bicycle[] getBicycles() {
        return bicycles;
    }

    public Vehicle[] getAvailableVehicles(){
        return availableVehicles;
    }
}
