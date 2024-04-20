/*
Name: Barral, Jacinth Cedric C
Date: April 20, 2024
Description:

*/
import java.util.Scanner;
import java.util.Random;
class ActTenBarral {
    private static int lRow = 0, lCol = 0; // Static lRow and LCol to be used and be overwritten by the methods, getMax()
    static Scanner in = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args){
        boolean exitLoop = false;

        int[][] numAr;
        int choice;
        int attempts = 1;
        String[] userOptions = {"Hard-Code Data", "Input Data", "Truly Random Data", "Custom Number or Rows and Columns", "Exit"};

        do{
            numAr  = new int[3][4]; // initialize the size of the numAr at the beginning of the loop inorder to prevent unwanted errors
            System.out.print("\n***************************************************************\n");
            System.out.printf("\t\t\t  %s\n", "2 Dimensional Arrays - Activity 10");
            System.out.printf("\t\t\t\t   %s\n", "Barral, Jacinth Cedric C.");
            System.out.printf("\t\t\t\t\t    %s - %-1d\n", "Attempt/s", attempts);
            System.out.print("***************************************************************\n");
            System.out.println("NOTE: The array size is 3X4 based on the instructions");


            System.out.printf("\nEnter # (1 - %d) to continue, 0 to EXIT. \n", (userOptions.length -1));
            displayOptions(userOptions); // Display Menu
            System.out.println();
            choice = getValidInput(userOptions); // Get valid input based on the length of the menu

            switch(choice){
                case 1: // Hardcoded Option
                    optionOne(numAr);
                    break;
                case 2: // Input option
                    optionTwo(numAr);
                    break;
                case 3: // Truly Random Option
                    optionThree(numAr);
                    break;
                case 0: //Exit
                    System.out.println("\nExiting.... :(\n");
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

    static void optionThree(int[][] array){
        System.out.print("\n---------------------------------------------------------------\n");
        System.out.printf("\t\t\t\t   %s\n", "Randomized Data - Data Table");
        System.out.print("---------------------------------------------------------------\n\n");
        initializeArray(array, true); // passing boolean value of TRUE, because the user indicated to randomize
    }


    static void displayMaxAndLocation(int[][] array){
        // Get the return data from the getMax() method and prints it out
        System.out.printf("The Maximum Element: %-1d\n", getMax(array));
        // Get the LRow data from the getMax() method and prints it out
        System.out.printf("At ROW #: %-1d\n", lRow);
        // Get the lCol data from the getMax() method and prints it out
        System.out.printf("At COL #: %-1d\n", lCol);
    }

    static boolean askYesOrNo(){
        // Boolean Return Method, returns true or false whenever the user inputs either 'Y' or 'N'
        boolean valueFlag = false;
        boolean isValid;
        char choice;
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
               choice = inputBuffer.charAt(0);
               choice = Character.toUpperCase(choice);

               if( choice == 'Y'){ // Returns TRUE value if 'Y', want to try again
                   valueFlag = true;
               }
               // If it is not 'Y', automatically be FALSE
               break; // Get out of the loop
           }
           else{
               // If the input is neither Yes and No or Y and N
               System.out.println("\nInput Y or Yes, N or No, try again!");
           }

        }while(true);
        // return boolean value
        return valueFlag;
    }
    static void displayArray(int[][] array){

        System.out.print("      "); // print the space
        for (int col = 0; col < array[0].length; col++) {
            // print the COL headers
            System.out.printf("%7s", "COL " + (col + 1));
        }
        System.out.println("\n");
        for(int i= 0; i< array.length; i++) {
            // print the ROW title
            System.out.printf("%s", "ROW " + (i + 1));
            for (int j = 0; j < array[0].length; j++) {
                System.out.printf("%6d ", array[i][j]);
            }
            System.out.println("\n");
        }
    }
    static void initializeArray(int[][] array, boolean isRandom){
        int max = 100, min =1;
        for(int i =0; i< array.length; i++){
            for(int j = 0; j <array[0].length; j++){
                if(isRandom){ // checks if the isRandom == TRUE, then it will give random integers from 1-100
                    array[i][j] = rand.nextInt(max)+min;
                }
                else{ // if isRandom == FALSE, user Input will be put inside the array[][]
                    array[i][j] = getValidInput(i,j, max, min);
                }
            }
        }

    }

    static int getValidInput(int i, int j, int max, int min){
        int numValue;
        do{
            if((j+1) == 1){ //checks if J is on 1 to print the row title
                System.out.printf("--------------------- ROW #%-1d ---------------------\n", (i+1));
            }
            System.out.printf("Input (1-100) integers in ROW #%-1d and COL #%-1d: ", (i+1), (j+1));
            if(in.hasNextInt()){ // checks if user inputted an type INT value
                numValue = in.nextInt();
                in.nextLine();

                if(numValue <= max && numValue >= min){
                    break;
                }
                else{
                    System.out.println("\nOut of Range, try again!\n");
                }
            }
            else{ // If the user inputted a NON type INT value
                System.out.println("\nInvalid Input, try again!\n");
                in.nextLine();
            }

        }while(true);
        // return numVAlue
        return numValue;
    }

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
    static int getValidInput(String[] array){
        int arrayLength = array.length - 1; // Excluding the "Exit" Option
        int userIn;
        do{
            System.out.print("Your Choice: ");
            if(in.hasNextInt()){ // checks if user inputted an type INT value
                userIn = in.nextInt();
                in.nextLine();
                if(userIn  <= arrayLength && userIn >=0) { // checks if the input is within range of the length of the arrayLength
                    break;
                }
                else{ // if it is not in range
                    System.out.println("\nNot in Range, try again!\n");
                    System.out.printf("Enter # (1 - %d) to continue, 0 to EXIT. \n", (arrayLength));
                    displayOptions(array);
                }
            }
            else{ // if the user inputted a non-INT type value
                System.out.println("\nInvalid Input, Try Again!\n");
                System.out.printf("Enter # (1 - %d) to continue, 0 to EXIT. \n", arrayLength);
                displayOptions(array);
                in.nextLine();
            }

        }while(true);

        return userIn;
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

}

