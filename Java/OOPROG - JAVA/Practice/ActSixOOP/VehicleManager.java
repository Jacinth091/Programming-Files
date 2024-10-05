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

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean isRentStatus() {
        return rentStatus;
    }

    public int getRentRemainingDays() {
        return rentRemainingDays;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }
}
