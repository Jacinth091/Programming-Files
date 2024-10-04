package DB;

public class VehicleData {

    public static VehicleData vhDataInstance;



    String[][] vehicleNames = {
            {"Cars", "Honda Civic", "Toyota Corolla", "Ford Mustang", "Tesla Model 3", "BMW 3 Series", "Audi A4", "Chevrolet Camaro"},
            {"Bus", "Mercedes-Benz Sprinter", "Volvo B8R", "Blue Bird Vision", "Tata Starbus", "Scania Touring", "MAN Lion's City", "Setra TopClass"},
            {"Trucks", "Ford F-150", "Chevrolet Silverado", "Ram 1500", "GMC Sierra 1500", "Toyota Tundra", "Nissan Titan", "Jeep Gladiator"},
            {"Bicycles", "Giant Escape 3", "Trek FX 3", "Schwinn Discover", "Cannondale Quick 4", "Specialized Sirrus", "Bianchi C-Sport", "Cube SL Road"},
    };


    private VehicleData(){}

    public static VehicleData getInstance(){

        if(vhDataInstance == null){
            vhDataInstance = new VehicleData();
        }

        return vhDataInstance;
    }

    public void echo(){
        System.out.println("Hi!, Hello!");
    }


}
