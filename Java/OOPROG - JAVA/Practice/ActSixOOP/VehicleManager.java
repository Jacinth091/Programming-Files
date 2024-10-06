package ActSixOOP;

public class VehicleManager{

    private VehicleData vhDB = VehicleData.getInstance();
    private Vehicle vehicle;
    private String dateRented;
    private boolean isAvailable;
    private boolean rentStatus; // true = Active, false = Completed
    private int rentRemainingDays;
    private int rentalDuration;
    private double rentCost;



    public VehicleManager(Vehicle vehicle, String dateRented, int rentRemainingDays, int rentalDuration,double rentCost, boolean rentStatus) {
        this.vehicle = vehicle;
        this.dateRented = dateRented;
        this.rentRemainingDays = rentRemainingDays;
        this.rentalDuration = rentalDuration;
        this.rentCost = rentCost;
        this.rentStatus = rentStatus;
//        this.isAvailable = isAvailable;
    }

    public VehicleManager(Vehicle vehicle, boolean isAvailable) {
        this.vehicle = vehicle;
        this.isAvailable = isAvailable;
    }

    public void displayVhManagerInfo(int spacerLen){
        if (vehicle != null) {  // Check if vehicle is not null
            String modelName = vehicle.getVehicleModel();
            String vhType = vehicle.getVehicleType();
            String rentStatus = getRentStatus() ? "Active" : "Completed";

            System.out.printf(
                    "%-" + (spacerLen) + "s%-" + (spacerLen) + "s%-" + (spacerLen) + ".2f%-" + (spacerLen) + "s%-" + (spacerLen) + "d%-" + (spacerLen) + "d%-" + (spacerLen) + "s\n",
                    modelName.trim(),         // Vehicle model name (Model)
                    vhType.trim(),            // Vehicle type (Type)
                    rentCost,                // Total cost (Rent Cost, formatted to 2 decimal places)
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



    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getDateRented() {
        return dateRented;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }

    public boolean getRentStatus() {
        return rentStatus;
    }
    public void setRentStatus(boolean rentStatus){
        this.rentStatus = rentStatus;
    }

    public int getRentRemainingDays() {
        return rentRemainingDays;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public void setDateRented(String dateRented) {
        this.dateRented = dateRented;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }



    public void setRentRemainingDays(int rentRemainingDays) {
        this.rentRemainingDays = rentRemainingDays;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public double getRentCost() {
        return rentCost;
    }

    public void setRentCost(double rentCost){
        this.rentCost = rentCost;
    }
}
