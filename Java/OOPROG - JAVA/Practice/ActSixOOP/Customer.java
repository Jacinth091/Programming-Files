package ActSixOOP;

import java.util.List;
import java.util.ArrayList;

public class Customer {
    private VehicleData vhDB = VehicleData.getInstance();

    private String name;
    private String occupation;
    private String loyaltyStatus;
    private boolean hasRentedAVehicle = false;

    private VehicleManager[] rentHistory;
    private VehicleManager[] currentRentedVehicles
    private int rentalDuration;
    private double totalRentalCost;

    private int currentIndex =0;

    // Constructor
    public Customer(String name, String occupation, String loyaltyStatus) {
        this.name = name;
        this.occupation = occupation;
        this.loyaltyStatus = loyaltyStatus;

    }
    public Customer(String name, String occupation, String loyaltyStatus, int rentalDuration, double totalRentalCost){
        this.name = name;
        this.occupation = occupation;
        this.loyaltyStatus = loyaltyStatus;
        this.rentHistory = new VehicleManager[vhDB.getObjectSize()*2];
        this.currentRentedVehicles = new VehicleManager[vhDB.getObjectSize()];
        this.rentalDuration = rentalDuration;
        this.totalRentalCost = totalRentalCost;
    }
    public Customer(){

    }


    public void viewCustomerStatus(){
        System.out.println("Your Profile Information");
        System.out.printf("Name: %s\n", name);
        System.out.printf("Occupation: %s\n", occupation);
        System.out.printf("Loyalty Status: %s\n", loyaltyStatus);

        System.out.println("Your Rent Vehicle History\n\n");

        viewVehicleHistory();

    }

    public void viewVehicleHistory(){

        int spacerLen = vhDB.getStrLen(rentedVehicles);

        for(String title : vhDB.getVehicleStatusTitles()){
            if(title.equals("Model")){
                System.out.printf("%-" +(spacerLen + 5)+"s", title);

            }
            else{
                System.out.printf("%-" +(spacerLen)+"s", title);

            }
        }

        System.out.println("\n");

        for(VehicleManager vhMan : vhDB.getAvailableVehicles()){
            Vehicle vh = vhMan.getVehicle();
            String modelName = vh.getVehicleModel();
            String vhType = vh.getVehicleType();
            String isAvailable = vhMan.getIsAvailable() ? "Available" : "Not Available";


            System.out.printf("%-" +(spacerLen + 5)+"s%-" +(spacerLen)+ "s%-" +(spacerLen)+ "s", modelName.trim(), vhType.trim(), isAvailable.trim());
            System.out.println();

        }


    }

    public void addVehicle(VehicleManager vhM){

        if(currentIndex == currentRentedVehicles.length ){
            System.out.println("Current Vehicle List is Full, Complete any rents to make space!");
        }
        else{
            currentRentedVehicles[currentIndex] = vhM;
            currentIndex++;

        }
    }

    public void removeVehicle(Vehicle vehicle){
        int len = currentRentedVehicles.length;
        for(int i =0; i < len; i++){
            VehicleManager vhMan =currentRentedVehicles[i];
            if(vhMan != null){
                Vehicle vh = vhMan.getVehicle();

                if(vh != null && vh.equals(vehicle)){
                    vhMan = null;
                }

            }

        }
    }







}
