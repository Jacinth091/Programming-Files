/*
Name: Barral, Jacinth Cedric C
Date: April 22, 2024
Description: Create a 2d array and populate it with numbers
, find the maximum element inside the array
and display the location (row and col) of the maximum element to the user

*/
import java.util.Scanner;
import java.util.Random;
class test {
    private static int lRow = 0, lCol = 0; // Static lRow and LCol to be used and be overwritten by the methods, getMax()
    static Scanner in = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args){

        boolean exitLoop = false;
        String[] userOptions = {"Hard-Code Data (Only for 3 x 4 array size!)", "Input Data", "Truly Random Data", "Custom Row and Col Size", "Reset Row and Col Back to DEFAULT SIZE","Exit"};
        int defRow =3, defCol = 4, choice, attempts = 1;
        int[][] numAr = new int[defRow][defCol];

        do{
            // display Header
            displayHeader(attempts, numAr.length, numAr[0].length);

            // User Ask Event
            System.out.printf("\nEnter # (1 - %d) to continue, 0 to EXIT. \n", (userOptions.length -1));
            displayOptions(userOptions); // Display Menu
            System.out.println();
            choice = getUserChoice(userOptions); // Get valid input based on the length of the menu

            switch(choice){
                case 1: // Hardcoded Option
                    if(numAr.length == 3 && numAr[0].length == 4){
                        optionOne(numAr);
                    }
                    else{
                        System.out.print("\n---------------------------------------------------------------\n");
                        System.out.printf("\t\t\t\t\t\t   %s\n", "Error!");
                        System.out.printf("\t\t\t  %s\n", "Array Size should be 3 x 4 to proceed!");
                        System.out.print("---------------------------------------------------------------\n");
                        waitKeyPress();
                        continue;

                    }
                    break;
                case 2: // Input option
                    optionTwo(numAr);
                    break;
                case 3: // Truly Random Option
                    optionThree(numAr);
                    break;
                case 4: // Set Custom Size of Row and Column
                    numAr = optionFour();
                    continue;
                case 5: // Reset Size back to DEFAULT
                    numAr = optionFive(defRow, defCol);
                    continue;
                case 0: //Exit
                    System.out.println("\nThank you for using the program, come again :D!\n");
                    System.exit(0);
                    break;

            }
            // Get the data of the array and display it
            displayArray(numAr);
            // Display The Maximum Element and the Location
            displayMaxAndLocation(numAr);

            System.out.print("---------------------------------------------------------------\n");

            // Asks the user to try again
            if(!askYesOrNo()) { // Checks if the returned value is FALSE to exit the program
                System.out.println("\nThank you for using the program, come again :D!\n");
                exitLoop = true;
            }
            //Increment attempts by 1
            attempts++;

        }while(!exitLoop); // Checks if the exitLoop == TRUE to exit the program

        in.close();
    }



    //------------------------------------------ UserInputs ------------------------------------------
    static int getValidInput(int min, int max){
        int errMsg;

        if(in.hasNextInt()){
            int temp = in.nextInt();
            in.nextLine();
            if(temp >= min && temp <=max){
                errMsg = temp;

            }else{
                errMsg = -2; // Indicates Out of Range Error Message
            }
        }
        else{
            in.nextLine();
            errMsg = -1; // Indicates Invalid or Illegal Input
        }

        return errMsg;
    }

    static int getUserChoice(String[] array){
        int max = array.length - 1, min = 0; // Excluding the "Exit" Option
        int userIn;
        do{
            System.out.print("Your Choice: ");
            userIn = getValidInput(min, max);

            if(userIn == -1){
                System.out.println("\nInvalid Input, Try Again!\n");
                System.out.printf("Enter # (1 - %d) to continue, 0 to EXIT. \n", max);
                displayOptions(array);
            }
            else if(userIn == -2){
                System.out.println("\nOut of Range, Try Again!\n");
                System.out.printf("Enter # (1 - %d) to continue, 0 to EXIT. \n", max);
                displayOptions(array);

            }
            else{
                break;
            }


        }while(true);

        return userIn;
    }

    static int getInputData(int i, int j, int max, int min){
        int inData;
        do{
            if((j+1) == 1){ //checks if J is on 1 to print the row title
                System.out.printf("--------------------- ROW #%-1d ---------------------\n", (i+1));
            }
            System.out.printf("Input (1-100) integers in ROW #%-1d and COL #%-1d: ", (i+1), (j+1));

            inData = getValidInput(min, max);

            if(inData == -1){
                System.out.println("\nInvalid Input, Try Again!\n");
            }
            else if(inData == -2){
                System.out.println("\nOut of Range, Try Again!\n");

            }
            else{
                break;
            }
        }while(true);
        // return inData
        return inData;
    }

    static boolean askYesOrNo(){
        // Boolean Return Method, returns true or false whenever the user inputs either 'Y' or 'N'
        boolean valueFlag = false;
        do{
            System.out.println("\nTry Again? (Y/N): ");
            System.out.print("Your Choice: ");
            String inputBuffer = in.nextLine().trim();

            if(inputBuffer.isEmpty()){ // Input buffer is empty, ask again
                System.out.println("\nEmpty Input, try again!");
                continue;
            }
            // It is either Yes, No and Y, N, proceed with the statements
            if(inputBuffer.equalsIgnoreCase("Y") || inputBuffer.equalsIgnoreCase("N") || inputBuffer.equalsIgnoreCase("Yes") || inputBuffer.equalsIgnoreCase("No")){
                if(inputBuffer.equalsIgnoreCase("yes") || inputBuffer.equalsIgnoreCase("Y")){ // If it is "yes" or "Y", automatically be TRUE
                    valueFlag = true;
                } // If it is not "yes" or "Y", automatically be FALSE
                break;// Get out of the loop

            }
            else{
                // If the input is neither Y, N, Yes and No
                System.out.println("\nInput Y, Yes OR N, No, try again!");
            }
        }while(true);
        // return boolean value
        return valueFlag;
    }


    //------------------------------------------ Display Or Print ------------------------------------------

    static void displayOptions(String[] array){
        int arrayLength = array.length;
        for(int i = 0; i<arrayLength; i++) {
            if(array[i].equals("Exit")){ // checks if the current iteration of the menu is "Exit" String
                System.out.println();
                System.out.printf("%-1d. %s\n", (arrayLength - i) - 1, array[i]); // it will display 0, an indication to exit
            }
            else{// if the current iteration of the menu is not "Exit" String
                System.out.printf("%-1d. %s\n", (i+1), array[i]);
            }
        }



    }

    static void displayArray(int[][] array){

        System.out.print("       "); // print the space
        for (int col = 0; col < array[0].length; col++) {
            // print the COL headers
            String formatSpecifier = (array[0].length >= 10) ? "%5s %-4d" : "%4s %-2d  ";
            System.out.printf(formatSpecifier, "COL", (col + 1));
        }
        System.out.println("\n");
        for(int i= 0; i< array.length; i++) {
            // print the ROW title
            System.out.printf(" %s%-2d ", "ROW ", (i + 1));
            for (int j = 0; j < array[0].length; j++) {
                String formatSpecifier = (array[0].length >= 10) ? "%5d     " : "%4d     ";
                System.out.printf(formatSpecifier, array[i][j]);
            }
            System.out.println("\n");

        }
    }

    static void displayMaxAndLocation(int[][] array){
        // Get the return data from the getMax() method and prints it out
        System.out.printf("The Maximum Element: %-1d\n", getMax(array));
        // Get the LRow data from the getMax() method and prints it out
        System.out.printf("At ROW #: %-1d\n", lRow);
        // Get the lCol data from the getMax() method and prints it out
        System.out.printf("At COL #: %-1d\n", lCol);
    }

    static void displayHeader(int attempts,int rowLen, int colLen){
        System.out.print("\n***************************************************************\n");
        System.out.printf("\t\t\t  %s\n", "2 Dimensional Arrays - Activity 10");
        System.out.printf("\t\t\t\t   %s\n", "Barral, Jacinth Cedric C.");
        System.out.printf("\t\t\t\t\t    %s - %-1d\n", "Attempt/s", attempts);
        System.out.print("***************************************************************\n");
        System.out.println("NOTE: The DEFAULT array size is 3X4 based on the instructions");
        System.out.printf("Current Row Size: %d\n", rowLen);
        System.out.printf("Current Col Size: %d\n", colLen);
    }

    static void waitKeyPress(){
        System.out.print("\nPress ENTER to continue: ");
        in.nextLine();
    }


    //------------------------------------------ Initialize or DO Something------------------------------------------

    static void initializeArray(int[][] array, boolean isRandom){
        int max = 100, min =1;
        for(int i =0; i< array.length; i++){
            for(int j = 0; j <array[0].length; j++){
                if(isRandom){ // checks if the isRandom == TRUE, then it will give random integers from 1-100
                    array[i][j] = rand.nextInt(max)+min;
                }
                else{ // if isRandom == FALSE, user Input will be put inside the array[][]
                    array[i][j] = getInputData(i,j, max, min);
                }
            }
        }

    }


    //------------------------------------------ Get Value ------------------------------------------

    static int getRowAndCol(String title){
        int value, min =1, max = 15;

        do {
            System.out.printf("Enter New %s Size (1 - 15) Only!\n", title);
            System.out.print("Input -->: ");
            value = getValidInput(min, max); // checks the value for it's validity

            if(value == -1){ // if the value is equals -1, it indicates an illegal or invalid input
                System.out.println("\nInvalid Input, Try Again!\n");
            }
            else if(value == -2){ // if the value is equals -2, it indicates an OUT OF RANGE input
                System.out.println("\nOut of Range, Try Again!\n");

            }
            else{ // If all goes well, exit out of the loop
                break;
            }

        }while(true);

        return value;

    }

    static int getMax(int[][] array){
        int max = 0;
        for(byte i =0; i< array.length; i++){
            for(int j =0; j < array[0].length; j++){
                if(max < array[i][j]){ // checks if the current iteration of the array[][] is greater than 100
                    max = array[i][j]; // assigns the max value to the new value
                    lRow = (i+1); // fetch the current ROW data and assigns it into lRow variable
                    lCol = (j+1); // fetch the current COL data and assigns it into lCol variable
                }
            }
        }
        return max;
    }


    //------------------------------------------ Options ------------------------------------------

    static void optionOne(int[][] array){
        System.out.print("\n---------------------------------------------------------------\n");
        System.out.printf("\t\t\t\t   %s\n", "Hard-Coded Data - Data Table");
        System.out.print("---------------------------------------------------------------\n\n");

        // Hard coded Data  I don't know if this is required
        array[0][0] = 9;
        array[0][1] = 4;
        array[0][2] = 4;
        array[0][3] = 10;

        array[1][0] = 78;
        array[1][1] = 56;
        array[1][2] = 20;
        array[1][3] = 45;


        array[2][0] = 17;
        array[2][1] = 13;
        array[2][2] = 98;
        array[2][3] = 36;
    }

    static void optionTwo(int[][] array){
        System.out.print("\n***************************************************************\n");
        System.out.printf("\t\t\t\t\t   %s\n", "Input your Data");
        System.out.print("***************************************************************\n\n");
        initializeArray(array, false); // passing boolean value of FALSE, because the user indicated to Input data
        System.out.print("\n---------------------------------------------------------------\n");
        System.out.printf("\t\t\t\t   %s\n", "Inputted Data - Data Table");
        System.out.print("---------------------------------------------------------------\n\n");
    }

    static void optionThree(int[][] array ){
        System.out.print("\n---------------------------------------------------------------\n");
        System.out.printf("\t\t\t\t   %s\n", "Randomized Data - Data Table");
        System.out.print("---------------------------------------------------------------\n\n");
        initializeArray(array, true); // passing boolean value of TRUE, because the user indicated to randomize
    }

    static int[][] optionFour(){
        int newRow, newCol;
        System.out.print("\n---------------------------------------------------------------\n");
        System.out.printf("\t\t\t   %s\n", "Set Custom Row and Column Size");
        System.out.print("---------------------------------------------------------------\n\n");

        newRow = getRowAndCol("Row");
        newCol = getRowAndCol("Column");

        System.out.print("\n---------------------------------------------------------------\n");
        System.out.printf("\t\t\t   %s\n", "Operation Successfully Complete!!");
        System.out.print("---------------------------------------------------------------\n");

        waitKeyPress();

        return new int[newRow][newCol];
    }

    static int[][] optionFive(int defRow, int defCol){
        System.out.print("\n---------------------------------------------------------------\n");
//        System.out.printf("\t\t\t   %s\n", "Operation Successfully Complete!!");
        System.out.printf("   %s\n", "Resetting array size to DEFAULT Successfully Complete!");
        System.out.print("---------------------------------------------------------------\n");
        waitKeyPress();
        return new int[defRow][defCol];
    }

}
