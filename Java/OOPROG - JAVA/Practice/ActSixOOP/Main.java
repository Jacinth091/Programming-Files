package ActSixOOP;
import java.sql.SQLOutput;
import java.util.Scanner;
class Main{

    static VehicleData vhData;
    static RentalManager rManager = new RentalManager();
    static Customer customer1 = new Customer("John", "Engineer", "Gold");


    public static void main(String[] args) {
        setInstance();
        Scanner in = new Scanner(System.in);
        String[] opt = {"View Available Vehicles", "View Your Rented Vehicles", "Exit Program"};

        mainLogic(in, opt);


        in.close();

    }

    // ------------------------------------------------ Main Logic && Event Controller ------------------------------------------------
    public static void mainLogic(Scanner in, String[] opt){

        boolean exitLoop = false;

        do{
            int choice =0;

            System.out.println("\nWelcome to Vehicle Renting System!!\n\n");
            dispOpts(opt,opt[opt.length-1]);
            System.out.print("\n-->: ");
            choice = checkValidIn(in, "-->");
            if(!isInputvalid(in, opt.length-1,0, choice)){
                in.nextLine();
                continue;
            }
            if(choice == 2){
                if(!customer1.isHasRentedAVehicle()){
                    System.out.println("There is no Rented Vehicles on your list.");
                    continue;
                }
            }
            if(eventController(in, choice)){
                in.nextLine();
                continue;
            }

            System.out.println("\n");

            String msg = "'Y' to restart, 'N' to exit the program.";
            exitLoop = askYesOrNo(in,msg );
            System.out.println();


        }while(!exitLoop);
    }
    public static boolean eventController(Scanner in, int choice){
        boolean value = false;
        boolean exitLoop = false;
        switch(choice){
            case 1:
                String[] subOptOne = {"Rent a Vehicle", "Go Back"};
                do{
                    System.out.printf("%-20s\n\n", "\nHere are the current Available Vehicles");
                    rManager.dispAvailableVehicles(false);
                    dispOpts(subOptOne,subOptOne[subOptOne.length-1]);
                    System.out.print("\n-->: ");
                    choice = checkValidIn(in, "-->");
                    if(!isInputvalid(in, subOptOne.length-1,0, choice)){
//                            System.out.println("Agoi");
                        continue;
                    }

                    if(choice == 1){
                        customer1.setHasRentedAVehicle(true);
                        userRentingVehicle(in, choice);
                    }
                    System.out.println("Eyyy");

                    value = true;

                }while(!value);


                break;

            case 2:
                String[] subOptTwo = {"Check Status", "Go Back"};
                do{
                    System.out.printf("%-20s\n\n", "\nYour Rented Vehicle Details");
                    viewRentedVehicles(customer1.getCurrentRentedVehicles());

                    dispOpts(subOptTwo,subOptTwo[subOptTwo.length-1]);
                    System.out.print("\n-->: ");
                    choice = checkValidIn(in, "-->");

                    if(!isInputvalid(in, subOptTwo.length-1,0, choice)){
                        System.out.println("Agoi");
                        continue;

                    }

                    if(choice == 1){
                        checkRentedStatus(customer1);

                    }

                    pressKeytoCont(in);
                    value = true;

                }while(!value);

                break;
    /*            case 3:





                    System.out.println("Accounts Profile");
                    break;*/
            case 0:
                System.out.println("Thank you for using the program, Goodbye!\n");
                System.exit(0);
                break;

        }

        return value;
    }


    // ------------------------------------------------ Option 1 Functions ------------------------------------------------

    public static void userRentingVehicle(Scanner in,int choice){
        boolean exitLoop = false;
        do{
            Vehicle vh;
            System.out.println("renting vehicle....");

            vh = getUserVehicleIndex(in, choice);

            if(vh == null){
                System.out.println("Pick another vehicle! Current vehicle is Not Available at the moment.");
                System.out.println("Press any key to continue...");
                in.nextLine();
                continue;
            }


            System.out.println("\n-------------------------------------------------------------------------\n");
            rManager.dispVehicleAttributes(vh);
            System.out.println("\n-------------------------------------------------------------------------\n");

            System.out.println("\n-------------------------------------------------------------------------");
            String msg = "Press 'Y' to confirm vehicle, Press 'N' to Go Back.";
            if(askYesOrNo(in,msg)){
                System.out.println("Pick a vehicle you want to rent.");
                continue;
            }
            System.out.println("-------------------------------------------------------------------------\n");


            System.out.println();

            System.out.println("\n-------------------------------------------------------------------------");
            System.out.println("You have confirmed the vehicle.");
            userVHRentConfirmed(in, choice, vh);


            System.out.println("-------------------------------------------------------------------------");
            msg = "Press 'Y' to rent other vehicles, Press 'N' to stop.";
            exitLoop = askYesOrNo(in,msg);
            System.out.println("-------------------------------------------------------------------------\n");

            System.out.println();

        }while(!exitLoop);




    }

    public static Vehicle getUserVehicleIndex(Scanner in, int choice){
        Vehicle vh;

        System.out.printf("%-20s\n\n", "\nHere are the current Available Vehicles");
        rManager.dispAvailableVehicles(true);

        System.out.println();
        choice = getValidatedNum(in, "Pick a vehicle, the details will display after.", vhData.getAvailableVehicles().length, 1);
        vh = rManager.searchVehicle(choice-1);
        in.nextLine();

        return vh;

    }

    public static void userVHRentConfirmed(Scanner in, int choice, Vehicle vh){
        System.out.println();
        choice = getValidatedNum(in, "For how many days you want to rent the vehicle? (Maximum = 30 days)", rManager.getMaxRentalDuration(), 1);
        int rentDuration = choice;



        rManager.rentVehicle(customer1,vh, rentDuration);
        System.out.printf("%-20s\n\n", "\nHere are your Current Rented Vehicles");
        rManager.dispAvailableVehicles(true);

        rManager.dispCostAndTotal(customer1.getLoyaltyStatus(), vh.getVehicleType(), vh.getVehicleModel());

        System.out.println();
    }


    // ------------------------------------------------ Option 2 Functions ------------------------------------------------
    public static void viewRentedVehicles(VehicleManager[] vhMan){
        for(VehicleManager vhM : vhMan){
            if(vhM != null && vhM.getVehicle() != null){
                System.out.println("\n-------------------------------------------------------------------------");
                rManager.dispVehicleAttributes(vhM.getVehicle());
                System.out.println("-------------------------------------------------------------------------\n");
            }
        }

    }
    public static void checkRentedStatus(Customer customer){

        System.out.printf("%-20s\n\n", "\nHere are your Current Rented Vehicles");
        customer.viewVehicleStatus(customer.getCurrentRentedVehicles());

        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("Total Rent cost for all rented vehicles : $%.2f\n", customer.getTotalRentalCost());
        System.out.println("-------------------------------------------------------------------------\n");


    }


    // ------------------------------------------------ Display / View ------------------------------------------------

    public static void dispOpts(String[] array, String exitKey){

        System.out.printf("\nEnter # (1 - %d) to continue, 0 to EXIT. \n", (array.length -1));
        int arrayLength = array.length;
        for(int i = 0; i<arrayLength; i++) {
            if(array[i].equals(exitKey)){ // checks if the current iteration of the menu is "Exit" String
                System.out.println();
                System.out.printf("%-1d. %s.\n", 0, array[i]); // it will display 0, an indication to exit
            }
            else{// if the current iteration of the menu is not "Exit" String
                System.out.printf("%-1d. %s.\n", (i+1), array[i]);
            }
        }
    }


    // ------------------------------------------------ get && set ------------------------------------------------

    public static void setInstance(){
        vhData = VehicleData.getInstance();
        // Test
//        vhData.echo();

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



    // ------------------------------------------------ User Input ------------------------------------------------
    public static void pressKeytoCont(Scanner in){
        System.out.println("Press any key to continue...");
        in.nextLine();

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

    public static boolean askYesOrNo(Scanner in, String msg){
        boolean value;
        do{
            System.out.printf("%s.\n", msg);
            System.out.print("Your choice: ");
            char input = in.next().toUpperCase().charAt(0);
            if(input == 'Y' || input == 'N'){
                value = input == 'N';
                break;
            }
            else{
                System.out.println("-------------------------------------------------------");
                System.out.println("Invalid input! Please enter 'Y' or 'N'.");
                System.out.println("-------------------------------------------------------");
            }

        }while(true);
        return value;

    }
    public static boolean checkInputRange(int num, int max, int min){
        return num >= min && num <= max;
    }


}