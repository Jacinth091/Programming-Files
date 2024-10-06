package ActSixOOP;

// --------------------------------------- Customer Class ------------------------------

public class Customer {

    private VehicleData vhDB = VehicleData.getInstance();

    private String name;
    private String occupation;
    private String loyaltyStatus;
    private boolean hasRentedAVehicle = false;


    // Storaing for rented vehicles
    private VehicleManager[] rentHistory = new VehicleManager[vhDB.getObjectSize() * 2];
    private VehicleManager[] currentRentedVehicles = new VehicleManager[vhDB.getObjectSize()];

    private int rentalDuration;
    private double totalRentalCost;
    private double rentCost;

    // Index For the rentHistory and currentRentedVehicle arrays
    private int currentIndex = 0;
    private int currentHistoryIndex = 0;



    public Customer(String name, String occupation, String loyaltyStatus) {
        this.name = name;
        this.occupation = occupation;
        this.loyaltyStatus = loyaltyStatus;
    }

    public Customer(int rentalDuration, double rentCost) {
        this.rentalDuration = rentalDuration;
        this.rentCost = rentCost;
    }

    public Customer() {}


    // --------------------------------------- View Methods ------------------------------

    public void viewCustomerStatus() {
        System.out.println("Your Profile Information");
        System.out.printf("Name: %s\n", name);
        System.out.printf("Occupation: %s\n", occupation);
        System.out.printf("Loyalty Status: %s\n", loyaltyStatus);

        System.out.println("Your Rent Vehicle History\n\n");
        viewVehicleStatus();
    }

    public void viewVehicleStatus(VehicleManager[] vhManager) {
        int spacerLen = vhDB.getStrLen(vhManager);
        int headerSpacer = vhDB.getStrLen(vhDB.getRentStatusTitles());
        int finalLen = spacerLen > headerSpacer ? spacerLen : headerSpacer;
        finalLen += 5;

        // Display headers
        for (String title : vhDB.getRentStatusTitles()) {
            System.out.printf("%-" + finalLen + "s", title);
        }
        System.out.println("\n");

        // Display vehicle manager info
        for (VehicleManager vhMan : vhManager) {
            if (vhMan != null) {  // Check if not null
                vhMan.displayVhManagerInfo(finalLen);
            }
        }
    }

    public void viewVehicleStatus() {
        int spacerLen = vhDB.getStrLen(rentHistory);

        // Display headers
        for (String title : vhDB.getVehicleStatusTitles()) {
            System.out.printf("%-" + (spacerLen + 5) + "s", title);
        }
        System.out.println();

        // Display rent history vehicle info
        for (VehicleManager vhMan : rentHistory) {
            if (vhMan != null) {
                vhMan.displayVhManagerInfo(spacerLen);
            }
        }
    }


    // --------------------------------------- Add/Remove Vehicle Methods ------------------------------

    public void addVehicle(VehicleManager vhM) {
        if (vhM == null) {
            System.out.println("Error: Attempted to add a null vehicle.");
            return;
        }

        if (currentIndex == currentRentedVehicles.length) {
            System.out.println("Current Vehicle List is Full, Complete any rents to make space!");
        } else {
            currentRentedVehicles[currentIndex] = vhM;
            currentIndex++;
        }
    }

    public void addVehicleToHistory(VehicleManager vhM) {
        if (vhM == null) {
            System.out.println("Error: Attempted to add a null vehicle.");
            return;
        }

        if (currentHistoryIndex == rentHistory.length) {
            System.out.println("Rent history is full, complete any rents to make space!");
        } else {
            rentHistory[currentHistoryIndex] = vhM;
            currentHistoryIndex++;
        }
    }

   /* public void removeVehicle(Vehicle vehicle) {
        int len = currentRentedVehicles.length;

        for (int i = 0; i < len; i++) {
            VehicleManager vhMan = currentRentedVehicles[i];

            if (vhMan != null && vhMan.getVehicle() != null && vhMan.getVehicle().equals(vehicle)) {
                currentRentedVehicles[i] = null;
            }
        }
    }*/


    // --------------------------------------- Getters and Setters ------------------------------

    public String getLoyaltyStatus() {
        return loyaltyStatus;
    }


    public double getTotalRentalCost() {
        return totalRentalCost;
    }

    public void setTotalRentalCost(double totalRentalCost) {
        this.totalRentalCost = totalRentalCost;
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
