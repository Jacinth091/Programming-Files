package ActSixOOP;

class Main{

    static VehicleData vhData;

    public static void main(String[] args) {
        setInstance();

        RentalManager rManager = new RentalManager();














    }

    public static void setInstance(){
        vhData = VehicleData.getInstance();
        // Test
        vhData.echo();

    }




}