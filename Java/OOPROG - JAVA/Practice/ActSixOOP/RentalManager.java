package ActSixOOP;

public class RentalManager {

    private VehicleData vhDB = VehicleData.getInstance();
    private Customer[] customerRentalList;
    private String[] loyaltyStatus = {"Bronze", "Silver", "Gold", "Platinum", "Diamond"};

    private int maxRentalDuration = 30;  // in days
    private double discountRate = 0.1;   // will be adjusted according to Customer's loyaltyStatus
    private double totalCost = 0.0;
    private double totalRentCost = 0.0;
    private final double taxPercentage = 0.12;


    public RentalManager() {
        // Initialize the lists
        vhDB.initObjects();
    }

    // --------------------------------------- "Display Available Vehicles" ------------------------------
    public void dispAvailableVehicles(boolean flag) {
        int spacerLen = vhDB.getStrLen(vhDB.getAvailableVehicles());
        int headerSpacer = vhDB.getStrLen(vhDB.getVehicleStatusTitles());
        int finalLen = spacerLen > headerSpacer ? spacerLen : headerSpacer;
        finalLen += 5;

        if (flag) {
            System.out.printf("%-" + (spacerLen - 5) + "s", "No.");
        }

        for (String title : vhDB.getVehicleStatusTitles()) {
            System.out.printf("%-" + (finalLen) + "s", title);
        }
        System.out.println("\n");

        for (int i = 0; i < vhDB.getAvailableVehicles().length; i++) {
            VehicleManager[] vhMan = vhDB.getAvailableVehicles();
            if (flag) {
                System.out.printf("%-" + (spacerLen - 5) + "d", i + 1);
            }
            vhMan[i].dispVHAvailStatus(finalLen);
        }
    }

    public void dispAvailableVehicles(VehicleManager[] vhManager) {
        int spacerLen = vhDB.getStrLen(vhManager);
        System.out.printf("%-" + (spacerLen - 5) + "s", "No.");
        for (String title : vhDB.getVehicleStatusTitles()) {
            System.out.printf("%-" + (spacerLen + 5) + "s", title);
        }

        System.out.println("\n");
        int index = 0;
        for (VehicleManager vhMan : vhManager) {
            Vehicle vh = vhMan.getVehicle();
            String modelName = vh.getVehicleModel();
            String vhType = vh.getVehicleType();
            String isAvailable = vhMan.getIsAvailable() ? "Available" : "Not Available";

            System.out.printf("%-" + (spacerLen - 5) + "d%-" + (spacerLen + 5) + "s%-" + (spacerLen) + "s%-" + (spacerLen) + "s", index + 1, modelName.trim(), vhType.trim(), isAvailable.trim());
            System.out.println();
            index++;
        }
    }

    // --------------------------------------- "Display Vehicle Attributes" ------------------------------
    public void dispVehicleAttributes(Vehicle vh) {
        vh.displayInfo();
    }

    public void dispVehicleAttributes(VehicleManager[] vhMan){
        for(VehicleManager vhM : vhMan){
            if(vhM != null){
                System.out.println("-------------------------------------------------------------------------");
                vhM.getVehicle().displayInfo();
                System.out.println("-------------------------------------------------------------------------");

            }
        }
    }

    // --------------------------------------- "Rent Vehicle" ------------------------------
    public void rentVehicle(Customer customer, Vehicle vehicle, int days) {
        for (int i = 0; i < vhDB.getAvailableVehicles().length; i++) {
            VehicleManager vhMan = vhDB.getAvailableVehicles()[i];
            if (vhMan != null) {
                Vehicle vh = vhMan.getVehicle();
                if (vh != null && vh.equals(vehicle)) {
                    // Calculate the Cost of the vehicle rent base on the Type of the vehicle and the loyalty status of the customer
                    totalCost = calculateTotalRentCost(customer.getLoyaltyStatus(), vh.getVehicleType(), days, discountRate);
                    vhMan = setAttributes(vhMan, vh, i, days, totalCost);
                    totalRentCost += totalCost;
                    customer = setCustomerSideAttributes(customer, vhMan, days, totalCost, totalRentCost);
                }
            }
        }
    }

    // --------------------------------------- "Display Cost and Total" ------------------------------
    public void dispCostAndTotal(String lStatus, String vhType, String vhModel) {
        System.out.println("\n-------------------------------------------------------------------------");
        System.out.println("Loyalty Status: " + lStatus + ".");
        System.out.println("Vehicle Type: " + vhType + ".");
        System.out.println("-------------------------------------------------------------------------");

        System.out.printf("Total Cost for %s -> %s: $%.2f\n", vhType, vhModel, totalCost);
        System.out.printf("Your total Rent Cost: $%.2f\n", totalRentCost);
        System.out.println("-------------------------------------------------------------------------\n");
    }

    // --------------------------------------- "Calculate Total Rent Cost" ------------------------------
    public double calculateTotalRentCost(String loyaltyStatus, String vhType, int days, double discountRate) {
        int baseRate = 0;
        double totalCost = 0.0;

        discountRate = getCustomerDiscount(loyaltyStatus);
        baseRate = vhDB.getVhBaseRate(vhType);

        totalCost = ((baseRate * days) - (baseRate * discountRate)) * (1 + taxPercentage);
        return totalCost;
    }

    // --------------------------------------- "Get Customer Discount" ------------------------------
    public double getCustomerDiscount(String loyaltyStatus) {
        double discount = 0.0;
        switch (loyaltyStatus) {
            case "Diamond":
                discount = 1.0;
                break;
            case "Platinum":
                discount = 0.8;
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

    // --------------------------------------- "Set Customer Attributes" ------------------------------
    public Customer setCustomerSideAttributes(Customer customer, VehicleManager vhMan, int days, double rentCost, double totalRentCost) {
        customer.addVehicle(vhMan); // adding the vehicleManager to the customer side of list of current rented vehicles
        customer.addVehicleToHistory(vhMan); // adding the vehicleManager to the customer side of list of rental history
        customer.setTotalRentalCost(totalRentCost); // manually setting the total Rent Cost (the total of all costs)
        return new Customer(days, rentCost);
    }

    // --------------------------------------- "Set Vehicle Manager Attributes" ------------------------------
    public VehicleManager setAttributes(VehicleManager vhMan, Vehicle vh, int i, int days, double rentCost) {
        int randMonth = vhDB.genRandNum(12, 1); // Getting Random Months
        int randDate = randMonth == 4 || randMonth == 6 || randMonth == 9 || randMonth == 11 ? vhDB.genRandNum(30, 1) :// Getting random date if month don't have a 31
                randMonth == 2 ? vhDB.genRandNum(28, 1) : // getting date if monthe is Febuary
                        vhDB.genRandNum(31, 1); // The default option
        String yyddmm = "2024-" + randDate + "-" + randMonth; // Using the random Date and random Month to create a year
        int remainingDays = (maxRentalDuration - days); // Not Cohesive and not the correct calc of the remainingDays
        vhDB.getRentedVehicles()[i] = vhMan; // Adding the acquired vehicle to the list of rentedVehicles
        vhMan.setIsAvailable(false); // Setting the availability of the vehicle to false, so that it won't get picked again

        return new VehicleManager(vh, yyddmm, remainingDays, days, rentCost, true); // returning a new instance of Vehicle Manager with the right parameters

    }

    // --------------------------------------- "Search Vehicle" ------------------------------
    public Vehicle searchVehicle(int index) {
        Vehicle vh = new Vehicle();
        int len = vhDB.getAvailableVehicles().length;
        for (int i = 0; i < len; i++) {
            VehicleManager vhMan = vhDB.getAvailableVehicles()[i];
            if (i == index) {
                if (!vhMan.getIsAvailable()) {
                    return null;
                } else {
                    vh = vhMan.getVehicle();
                }
            }
        }
        return vh;
    }

    // --------------------------------------- "Getters" ------------------------------
    public int getMaxRentalDuration() {
        return maxRentalDuration;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public double getTotalCost() {
        return totalCost;
    }
}
