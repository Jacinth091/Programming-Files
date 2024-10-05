package ActSixOOP;

public class VehicleManager{

    private Vehicle vehicle;
    private String dateRented;
    private boolean isAvailable;
    private boolean rentStatus; // true = Active, false = Completed
    private int rentRemainingDays;
    private int rentalDuration;



    public VehicleManager(Vehicle vehicle, String dateRented, int rentRemainingDays, int rentalDuration, boolean rentStatus) {
        this.vehicle = vehicle;
        this.dateRented = dateRented;
        this.rentRemainingDays = rentRemainingDays;
        this.rentalDuration = rentalDuration;
        this.rentStatus = rentStatus;
//        this.isAvailable = isAvailable;
    }

    public VehicleManager(Vehicle vehicle, boolean isAvailable) {
        this.vehicle = vehicle;
        this.isAvailable = isAvailable;
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

    public boolean isRentStatus() {
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
}
