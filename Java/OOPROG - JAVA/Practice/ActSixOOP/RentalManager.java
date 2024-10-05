package ActSixOOP;

import java.util.ArrayList;
import java.util.List;

public class RentalManager {

    private VehicleData vhDB = VehicleData.getInstance();
    private Customer[] customerRentalList;
//    private Vehicle[] listOfVehicles;

    private int maxRentalDuration = 30;  // in days
    private double discountRate = 0.1; // will be adjusted according to Customer's loyaltyStatus
    private double totalRevenue = 0.0;
    private double totalCost = 0.0;
    private double rentalRate = 10.0;




    // Constructor
    public RentalManager() {
        // Initialize the lists
        vhDB.initObjects();

    }

    public void dispAvailableVehicles(){

        int spacerLen = vhDB.getStrLen(vhDB.getAvailableVehicles());
        System.out.printf("%-" +(spacerLen - 5)+"s", "No.");
        for(String title : vhDB.getVehicleStatusTitles()){
            if(title.equals("Model")){
                System.out.printf("%-" +(spacerLen + 5)+"s", title);

            }
            else{
                System.out.printf("%-" +(spacerLen)+"s", title);

            }
        }

        System.out.println("\n");
        int index =0;
        for(VehicleManager vhMan : vhDB.getAvailableVehicles()){
            Vehicle vh = vhMan.getVehicle();
            String modelName = vh.getVehicleModel();
            String vhType = vh.getVehicleType();
            String isAvailable = vhMan.getIsAvailable() ? "Available" : "Not Available";


            System.out.printf("%-"+(spacerLen -5)+"d%-" +(spacerLen + 5)+"s%-" +(spacerLen)+ "s%-" +(spacerLen)+ "s",index+1, modelName.trim(), vhType.trim(), isAvailable.trim());
            System.out.println();
            index++;

        }


    }

    public void dispAvailableVehicles(VehicleManager[] vhManager){

        int spacerLen = vhDB.getStrLen(vhManager);
        System.out.printf("%-" +(spacerLen - 5)+"s", "No.");
        for(String title : vhDB.getVehicleStatusTitles()){
            if(title.equals("Model")){
                System.out.printf("%-" +(spacerLen + 5)+"s", title);

            }
            else{
                System.out.printf("%-" +(spacerLen)+"s", title);

            }
        }

        System.out.println("\n");
        int index =0;
        for(VehicleManager vhMan : vhManager){
            Vehicle vh = vhMan.getVehicle();
            String modelName = vh.getVehicleModel();
            String vhType = vh.getVehicleType();
            String isAvailable = vhMan.getIsAvailable() ? "Available" : "Not Available";


            System.out.printf("%-"+(spacerLen -5)+"d%-" +(spacerLen + 5)+"s%-" +(spacerLen)+ "s%-" +(spacerLen)+ "s",index+1, modelName.trim(), vhType.trim(), isAvailable.trim());
            System.out.println();
            index++;

        }


    }

    public void dispVehicleAttributes(Vehicle vh){
//        int spacerLen = vhDB.getStrLen(vh);
        vh.displayInfo();

    }
    public void rentVehicle(Customer customer, Vehicle vehicle, int days){

        for(int i =0; i < vhDB.getAvailableVehicles().length; i++){
            VehicleManager vhMan =vhDB.getAvailableVehicles()[i];
            if(vhMan != null){
                Vehicle vh = vhMan.getVehicle();

                if(vh != null && vh.equals(vehicle)){
//                    System.out.println("Entered!");

                    int randMonth = vhDB.genRandNum(12, 1);
                    int randDate = randMonth == 4 || randMonth == 6 || randMonth == 9 || randMonth == 11 ? vhDB.genRandNum(30, 1) :
                            randMonth == 2 ? vhDB.genRandNum(28, 1) :
                                    vhDB.genRandNum(31, 1);
                    String yyddmm = "2024-" + randDate + "-" +randMonth+ ".";
                    int remainingDays = (days - maxRentalDuration);
                    vhDB.getRentedVehicles()[i] = vhMan;
                    vhMan.setIsAvailable(false);
                    vhMan = new VehicleManager(vh, yyddmm, remainingDays, days, true);

                    //TODO: create a function in calculating total cost of the rented vehicle with right discount and right classifictaions
                }
//                System.out.println("Agoi");

            }

        }

    }

    public Vehicle searchVehicle(int index){
        Vehicle vh = new Vehicle();
        int len = vhDB.getAvailableVehicles().length;
        for(int i =0; i< len; i++){
            VehicleManager vhMan = vhDB.getAvailableVehicles()[i];
            if(i == index){
                if(!vhMan.getIsAvailable()){
                    return  null;
                }
                else{
                    vh = vhMan.getVehicle();
                }
            }
        }
        return vh;
    }

    public int getMaxRentalDuration() {
        return maxRentalDuration;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getRentalRate() {
        return rentalRate;
    }
}
