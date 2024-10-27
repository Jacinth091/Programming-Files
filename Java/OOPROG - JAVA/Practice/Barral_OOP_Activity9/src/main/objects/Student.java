package main.objects;

public class Student {

    private String studName;
    private String studStatus;


    private Vehicle rideVehicle;


    public void getVehicle(Vehicle vehicle){
        rideVehicle = vehicle;
    }


    public Student(String studName, String studStatus){
        this.studName = studName;
        this.studStatus = studStatus;
    }

    public void travelTo(String destination){
        rideVehicle.travelTo(destination);
    }

}
