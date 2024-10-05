package ActSixOOP;
import java.util.Scanner;
class Main{

    static VehicleData vhData;

    public static void main(String[] args) {
        setInstance();
        Scanner in = new Scanner(System.in);
        String[] opt = {"View Available Vehicles", "View Rented Vehicles","Account Profile", "Exit"};
        String[] optViewAvailable = {"Rent a Vehicle", "Go Back"};

        Customer customer1 = new Customer("John", "Engineer", "Gold");
        RentalManager rManager = new RentalManager();

        rManager.dispAvailableVehicles();
        System.out.println("Pick a vehicle to Rent.");
//        System.out.print("--> : ");
        int choice = getValidatedNum(in, "-->", vhData.getAvailableVehicles().length, 1);


        rManager.rentVehicle(customer1, rManager.searchVehicle(choice-1), 20);

        rManager.dispAvailableVehicles();















    }

    public static int getValidatedNum(Scanner in,String msg, int max, int min){
        int choice =0;
        do {
            System.out.printf("%s\n",msg);
            System.out.print("--> : ");
            choice = checkValidIn(in, "--> ");
            boolean isValid = checkInputRange(choice, max, min); // returns true if valid, false if not

            if (!isValid) {
                System.out.printf("Maximum characters is %d, try again!\n", max);
//               in.nextLine();
                continue;
            }
//            in.nextLine();
            break;
        }while(true);

        return choice;

    }

    public static boolean checkInputRange(int num, int max, int min){
        return num >= min && num <= max;
    }

    public static boolean isInputvalid(Scanner in, int size, int min, int choice){
        if( choice > size || choice < min){
            in.nextLine();
            System.out.println("Index number is not within the given options, try again!\n");
            //  System.out.print("Press ENTER key to continue...");
            //  in.nextLine();
            return false;

        }
        return true;
    }

    public static int checkValidIn(Scanner in, String alert){
        while(!in.hasNextInt()){
            System.out.println("Input only integers, try again!");
            System.out.print(alert + ": ");
            in.next();

        }
        return in.nextInt();


    }

    public static void setInstance(){
        vhData = VehicleData.getInstance();
        // Test
//        vhData.echo();

    }




}