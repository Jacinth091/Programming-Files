package ActSixOOP;

public class VehicleManager{

    private VehicleData vhDB = VehicleData.getInstance();

    // attrib
    private Vehicle vehicle;
    private String dateRented;
    private boolean isAvailable;
    private boolean rentStatus; // true = Active, false = Completed
    private int rentRemainingDays;
    private int rentalDuration;
    private double rentCost;



    public VehicleManager(Vehicle vehicle, String dateRented, int rentRemainingDays, int rentalDuration, double rentCost, boolean rentStatus) {
        this.vehicle = vehicle;
        this.dateRented = dateRented;
        this.rentRemainingDays = rentRemainingDays;
        this.rentalDuration = rentalDuration;
        this.rentCost = rentCost;
        this.rentStatus = rentStatus;
    }

    public VehicleManager(Vehicle vehicle, boolean isAvailable) {
        this.vehicle = vehicle;
        this.isAvailable = isAvailable;
    }


    // --------------------------------------- Display Methods ------------------------------

    public void displayVhManagerInfo(int spacerLen) {
        if (vehicle != null) {  // Check if vehicle is not null Debugging
            String modelName = vehicle.getVehicleModel();
            String vhType = vehicle.getVehicleType();
            String rentStatus = getRentStatus() ? "Active" : "Completed";

            System.out.printf(
                    "%-" + (spacerLen) + "s%-" + (spacerLen) + "s%-" + (spacerLen) + ".2f%-" + (spacerLen) + "s%-" + (spacerLen) + "d%-" + (spacerLen) + "d%-" + (spacerLen) + "s\n",
                    modelName.trim(),         // Vehicle model name (Model)
                    vhType.trim(),            // Vehicle type (Type)
                    rentCost,                // Total cost (Rent Cost,  2 decimal places)
                    rentStatus,               // Rent status (Active/Completed)
                    rentRemainingDays,        // Remaining days (Remaining Days)
                    rentalDuration,           // Rental duration (Rent Duration)
                    dateRented.trim()         // Date rented (Date Rented)
            );
            System.out.println();
        } else {
            System.out.println("Vehicle information is missing.");
        }
    }

    public void dispVHAvailStatus(int spacerLen) {
        if (vehicle != null) {  // Check if vehicle is not null
            String modelName = vehicle.getVehicleModel();
            String vhType = vehicle.getVehicleType();
            String isAvailable = getIsAvailable() ? "Available" : "Not Available";

            System.out.printf(
                    "%-" + (spacerLen) + "s%-" + (spacerLen) + "s%-" + (spacerLen) + "s\n",
                    modelName.trim(),     // Vehicle model name (Model)
                    vhType.trim(),        // Vehicle type (Type)
                    isAvailable.trim()    // Availability status
            );
        } else {
            System.out.println("Vehicle information is missing.");
        }
    }


    // --------------------------------------- Getters and Setters ------------------------------

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public boolean getRentStatus() {
        return rentStatus;
    }

}
