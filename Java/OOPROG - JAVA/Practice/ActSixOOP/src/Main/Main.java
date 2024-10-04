package Main;
import DB.VehicleData;
import Vehicles.*;
class Main{

    static VehicleData vhData;

    public static void main(String[] args) {
        setInstance();


    }

    public static void setInstance(){
        vhData = VehicleData.getInstance();
        // Test
        vhData.echo();

    }

}