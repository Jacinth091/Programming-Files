package ActSixOOP;

public class VehicleManager{


    private String vehicleType;
    private String vehicleModel;
    private String dateRented;

    private boolean rentStatus; // true = Active, false = Completed
    private int rentRemainingDays;
    private int rentalDuration;

    public VehicleManager(String vehicleType, String vehicleModel){
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;

    }


    public VehicleManager(String vehicleType, String vehicleModel, String dateRented, int rentRemainingDays, int rentalDuration, boolean rentStatus) {
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;
        this.dateRented = dateRented;
        this.rentRemainingDays = rentRemainingDays;
        this.rentalDuration = rentalDuration;
        this.rentStatus = rentStatus;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getDateRented() {
        return dateRented;
    }

    public void setDateRented(String dateRented) {
        this.dateRented = dateRented;
    }

    public boolean isRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(boolean rentStatus) {
        this.rentStatus = rentStatus;
    }

    public int getRentRemainingDays() {
        return rentRemainingDays;
    }

    public void setRentRemainingDays(int rentRemainingDays) {
        this.rentRemainingDays = rentRemainingDays;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }


}
