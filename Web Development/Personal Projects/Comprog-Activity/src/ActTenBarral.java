
import java.util.Scanner;
import java.util.Random;
class ActTenBarral {
    private static int lRow = 0, lCol = 0;
    static Scanner in = new Scanner(System.in);
    static Random rand = new Random();
    public static void main(String[] args){


        int[][] numAr = new int[3][4];
        int row = numAr.length, col = numAr[0].length;
        int choice;

        String[] userOptions = {"Randomized Data", "Input Data", "Exit"};

        displayOptions(userOptions);
        System.out.println();
        choice = getValidInput(userOptions);

        switch(choice){
            case 1:
                System.out.println("\n-----------------------------------------------------------------------");
                System.out.println("Randomized Data\n");
                initializeArray(numAr, true); // passing boolean value of TRUE, because the user indicated to randomize
                break;
            case 2:
                System.out.println("\n-----------------------------------------------------------------------\n");
                initializeArray(numAr, false); // passing boolean value of FALSE, because the user indicated to Input data
                System.out.println("\n-----------------------------------------------------------------------\n");
                System.out.println("Input Data\n");
                break;
            case 0:
                System.out.println("Exiting....\n");
                System.exit(0);
                break;

        }

        displayArray(numAr);

//
//        System.out.println(getMax(numAR));
//        System.out.println(lRow);
//        System.out.println(lCol);


    }

    static void displayArray(int[][] array){

        System.out.print("      ");
        for (int col = 0; col < array[0].length; col++) {
            System.out.printf("%-7s", "COL " + (col + 1));
        }
        System.out.println("\n");

        for(int i= 0; i< array.length; i++) {
            System.out.printf("%-8s", "ROW " + (i + 1));
            for (int j = 0; j < array[0].length; j++) {
                System.out.printf("%-6d ", array[i][j]);
            }


            System.out.println("\n");
        }
    }

    static void initializeArray(int[][] array, boolean isRandom){
        int max = 100, min =0;
        for(int i =0; i< array.length; i++){
            for(int j = 0; j <array[0].length; j++){
                if(isRandom){
                    array[i][j] = rand.nextInt(max - min + 1) - min;
                }
                else{
                    array[i][j] = getValidInput(i,j, max, min);
                }
            }
        }

    }

    static int getValidInput(int i, int j, int max, int min){
        int numValue;
        do{
            System.out.printf("Enter number for row #%d and col #%d: ", (i+1), (j+1));
            if(in.hasNextInt()){
                numValue = in.nextInt();
                in.nextLine();

                if(numValue <= max && numValue > min){
                    break;
                }
                else{
                    System.out.println("\nOut of Range, try again!\n");
                }
            }
            else{
                System.out.println("\nInvalid Input, try again!\n");
                in.nextLine();
            }

        }while(true);
        return numValue;
    }

    static void displayOptions(String[] array){
        int arrayLength = array.length;

        for(int i = 0; i<arrayLength; i++) {
            if(array[i].equals("Exit")){
                System.out.println();
                System.out.printf("%-1d. %s\n", (arrayLength - i) - 1, array[i]);
            }
            else{
                System.out.printf("%-1d. %s\n", (i+1), array[i]);
            }
        }



    }
    static int getValidInput(String[] array){
        int arrayLength = array.length - 1; // Excluding the "Exit" Option
        int userIn;
        do{
            System.out.print("Your Choice: ");
            if(in.hasNextInt()){
                userIn = in.nextInt();
                in.nextLine();
                if(userIn  <= arrayLength && userIn >=0) {
                    break;
                }
                else{
                    System.out.println("\nNot in Range, try again!\n");
                    displayOptions(array);
                }
            }
            else{
                System.out.println("\nInvalid Input, Try Again!\n");
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
                if(max < array[i][j]){
                    max = (int)array[i][j];
                    lRow = (i+1);
                    lCol = (j+1);
                }
            }
        }
        return max;
    }

}

