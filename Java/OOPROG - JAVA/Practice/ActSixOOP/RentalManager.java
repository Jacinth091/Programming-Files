package ActSixOOP;

import java.util.ArrayList;
import java.util.List;

public class RentalManager {

    private VehicleData vhDB = VehicleData.getInstance();
    private Customer[] customerRentalList;
//    private Vehicle[] listOfVehicles;
    private String[] loyaltyStatus = {"Bronze","Silver","Gold","Platinum","Diamond"};

    private int maxRentalDuration = 30;  // in days
    private double discountRate = 0.1; // will be adjusted according to Customer's loyaltyStatus
    private double totalRevenue = 0.0;
    private double totalCost = 0.0;
    private double totalRentCost = 0.0;
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

                    //TODO: create a function in calculating total cost of the rented vehicle with right discount and right classifictaions

                    totalCost = calculateTotalRentCost(customer.getLoyaltyStatus(), vh.getVehicleType(), days, discountRate);
                    vhMan = setAttributes(vhMan, vh, i, days, totalCost);

                    System.out.printf("Total Cost for %s -> %s: $%.2f\n",vh.getVehicleType(),vh.getVehicleModel(), totalCost);
                    totalRentCost += totalCost;
                    System.out.printf("Your total Rent Cost: $%.2f\n", totalRentCost);

                    customer = setCustomerSideAttributes(customer, vhMan, days, totalRentCost);


                }
//                System.out.println("Agoi");

            }

        }

    }

    public double calculateTotalRentCost(String loyaltyStatus, String vhType, int days, double discountRate){
        // loyalty status indicates the right discounted amount to the total cost,
        // Loyalty Status = Bronze, Silver, Gold, Platinum, Diamond
        // Loyalty Status = 0.1,    0.2,    0.4,  0.8,      1.0

        // To calculate total rental cost we first have to identify what vehicle type
        // Formula will be (Flat Cost per day * days) + Tax
        // Car = flat cost per day = 300;
        // Bus = flat cost per day = 500;
        // Truck = flat cost per day = 700;
        // Bicycle = flat cost per day = 150;
//        int baseRate =  vhType.equals("Car") ? 300 :
//                        vhType.equals("Bus") ? 500 :
//                        vhType.equals("Truck") ? 700 :
//                                150; // Bicycle

        int baseRate = 0;
        double totalCost = 0.0;
        final double taxPercentage = 0.12;
        System.out.println("\nLoyalty Status: " + loyaltyStatus + ".");
        System.out.println("Vehicle Type: " + vhType + ".\n");

        discountRate = getCustomerDiscount(loyaltyStatus);
        baseRate = vhDB.getVhBaseRate(vhType);


        totalCost = ((baseRate * days) - (baseRate * discountRate)) * (1 + taxPercentage);

        return totalCost;
    }

    public double getCustomerDiscount(String loyaltyStatus){
        double discount =0.0;
        switch(loyaltyStatus){
            case "Diamond":
                discount = 1.0;
                break;
            case "Platinum":
                discount =0.8;

                break;
            case "Gold":
                discount = 0.4;

                break;
            case "Silver":
                discount = 0.2;

                break;
            case "Bronze":
                discount = 0.1;
                break;
            default:
                System.out.println("Invalid Loyalty Status!");
                break;
        }

        return discount;
    }

    public Customer setCustomerSideAttributes(Customer customer, VehicleManager vhMan, int days, double totalRentCost){
        // Putting the vhManager to the customer side list of current Rented Vehicles and rent History;
        customer.addVehicle(vhMan);
        customer.addVehicleToHistory(vhMan);


        return new Customer(days, totalRentCost);
    }


    public VehicleManager setAttributes(VehicleManager vhMan,Vehicle vh, int i, int days, double rentCost){
        int randMonth = vhDB.genRandNum(12, 1);
        int randDate = randMonth == 4 || randMonth == 6 || randMonth == 9 || randMonth == 11 ? vhDB.genRandNum(30, 1) :
                randMonth == 2 ? vhDB.genRandNum(28, 1) :
                        vhDB.genRandNum(31, 1);
        String yyddmm = "2024-" + randDate + "-" +randMonth+ "";
        int remainingDays = (maxRentalDuration - days);
        vhDB.getRentedVehicles()[i] = vhMan;
        vhMan.setIsAvailable(false);

        return new VehicleManager(vh, yyddmm, remainingDays, days,rentCost, true);
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
