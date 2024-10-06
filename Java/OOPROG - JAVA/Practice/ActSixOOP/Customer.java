package ActSixOOP;


public class Customer {
    private VehicleData vhDB = VehicleData.getInstance();

    private String name;
    private String occupation;
    private String loyaltyStatus;
    private boolean hasRentedAVehicle = false;
    private VehicleManager[] rentHistory = new VehicleManager[vhDB.getObjectSize()*2];
    private VehicleManager[] currentRentedVehicles = new VehicleManager[vhDB.getObjectSize()];
    private int rentalDuration;
    private double totalRentalCost;
    private double rentCost;

    private int currentIndex =0;
    private int currentHistoryIndex =0;

    // Constructor
    public Customer(String name, String occupation, String loyaltyStatus) {
        this.name = name;
        this.occupation = occupation;
        this.loyaltyStatus = loyaltyStatus;



    }
    public Customer(int rentalDuration, double rentCost){
        this.rentalDuration = rentalDuration;
        this.rentCost = rentCost;
    }
    public Customer(){

    }


    public void viewCustomerStatus(){
        System.out.println("Your Profile Information");
        System.out.printf("Name: %s\n", name);
        System.out.printf("Occupation: %s\n", occupation);
        System.out.printf("Loyalty Status: %s\n", loyaltyStatus);

        System.out.println("Your Rent Vehicle History\n\n");

        viewVehicleStatus();

    }

    public void viewVehicleStatus(VehicleManager[] vhManager){
        int spacerLen = vhDB.getStrLen(vhManager);
        int headerSpacer = vhDB.getStrLen(vhDB.getRentStatusTitles());

        int finalLen = spacerLen > headerSpacer ? spacerLen : headerSpacer;
        finalLen += 5;
        for(String title : vhDB.getRentStatusTitles()){
            if(title.equals("Model")){
                System.out.printf("%-" +(finalLen)+"s", title);
            }
            else{
                System.out.printf("%-" +(finalLen)+"s", title);
            }
        }
        System.out.println("\n");
        for(int i =0; i < vhManager.length; i++){
            if (vhManager[i] != null) {  // Check if vhMan is not null
                vhManager[i].displayVhManagerInfo(finalLen);
            }
        }
    }
    public void viewVehicleStatus(){
        int spacerLen = vhDB.getStrLen(rentHistory);

        for(String title : vhDB.getVehicleStatusTitles()){
            if(title.equals("Model")){
                System.out.printf("%-" +(spacerLen + 5)+"s", title);
            }
            else{
                System.out.printf("%-" +(spacerLen)+"s", title);
            }
        }
        for(VehicleManager vhMan : rentHistory){
            vhMan.displayVhManagerInfo(spacerLen);
        }




    }
    public void addVehicle(VehicleManager vhM){
        if (vhM == null) {
            System.out.println("Error: Attempted to add a null vehicle.");
            return;
        }
 /*       else{
            System.out.println("Adding vehicle to currentRentedVehicles: " + vhM.getVehicle().getVehicleModel());
        }*/

        if(currentIndex == currentRentedVehicles.length ){
            System.out.println("Current Vehicle List is Full, Complete any rents to make space!");
        }
        else{
            currentRentedVehicles[currentIndex] = vhM;
            currentIndex++;

        }
    }
    public void addVehicleToHistory(VehicleManager vhM){

        if (vhM == null) {
            System.out.println("Error: Attempted to add a null vehicle.");
            return;
        }/*else{
            System.out.println("Adding vehicle to rentHistory: " + vhM.getVehicle().getVehicleModel());
        }*/

        if(currentHistoryIndex == rentHistory.length ){
            System.out.println("Current Vehicle List is Full, Complete any rents to make space!");
        }
        else{
            rentHistory[currentHistoryIndex] = vhM;
            currentHistoryIndex++;

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

    public String getLoyaltyStatus() {
        return loyaltyStatus;
    }

    public void setLoyaltyStatus(String loyaltyStatus) {
        this.loyaltyStatus = loyaltyStatus;
    }

    public double getTotalRentalCost() {
        return totalRentalCost;
    }

    public void setTotalRentalCost(double totalRentalCost) {
        this.totalRentalCost = totalRentalCost;
    }

    public double getRentCost() {
        return rentCost;
    }

    public void setRentCost(double rentCost) {
        this.rentCost = rentCost;
    }

    public VehicleManager[] getRentHistory() {
        return rentHistory;
    }

    public VehicleManager[] getCurrentRentedVehicles() {
        return currentRentedVehicles;
    }

    public boolean isHasRentedAVehicle() {
        return hasRentedAVehicle;
    }

    public void setHasRentedAVehicle(boolean hasRentedAVehicle) {
        this.hasRentedAVehicle = hasRentedAVehicle;
    }
}
