/*
* Name: Jacinth Cedric C. Barral
* Date: Sept 02, 2024
* Description: Prelim-Lab.Act.#02 - Working with arrays and sorting array elements
*        Demonstrate the use of arrays, sorting arrays and traverse an array.
* */
import java.util.Scanner;
class ActTwo {
//    static int arrSize =5;
    static boolean sortProcess;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("This program will ask for grades, sort the array, and display the minimum, maximum, and average grade.");
        System.out.println("The program will iterate between Bubble and Selection Sorting after each loop has finished.");
        System.out.println("(Sort Process Enabled -> Displays sorting steps, Disabled -> No sorting steps shown).\n");

        // Main program Loop
        // It handles the looping of the program
        // It holds the toggling of sort Process Boolean
        // The asking and setting of array size
        // The inputting of Student Grades
        // The iteration of sorting algorithms
        // Displaying of the Unsorted and Sorted Arrays
        // Displaying of the Average, Minimum Value, and the Maximum Value
        mainLoop(in);

        System.out.println("Goodbye, and thanks for using the program! :D");

        in.close();


    }
    // --------------------------------------- Main Function ---------------------------------------
    public static void mainLoop(Scanner in){
        boolean exitLoop;
        int iterate = 0;
        String msg;

        int[] gradeArr, sortArr;

        do{
            // Let the user toggle on or off the sort process
            toggleSortProcess(in);

            // Asking for the size of the arrays
            // Setting the size to the arrays
            int arrSize = askForArraySize(in);
//            gradeArr = new int[arrSize];
//            sortArr = new int[arrSize];


            // Asking the user for the grades for the students
            System.out.println("-------------------------------------------------------\n");
            System.out.println("Input for Student's Grades: ");
            gradeArr = askForGrades(in, arrSize);


            // Displays unsorted and sorted arrays
            System.out.println("-------------------------------------------------------\n");
            System.out.print("Unsorted -> ");
            dispArray(gradeArr);
            System.out.println();

            // Iterates between Bubble Sort to Selection Sort
            sortArr = setSortedArray(gradeArr, iterate);

            System.out.print("\nSorted -> ");
            dispArray(sortArr);

            // Getting the average based on the total of grades/ the size of the array
            // getting the min and max from the Sorted array
            // Displaying all values for the user
            dispValues(sortArr, arrSize);


            msg = "'Y' to restart, 'N' to exit the program.";
            exitLoop = askYesOrNo(in,msg );

            // Assign a value to the iterate count between 0 and 1 only
            iterate = iterate == 0 ? 1 : 0;
            System.out.println();


        }while(!exitLoop);
    }



    // --------------------------------------- User Input ---------------------------------------

    // Toggle sorting process display
    public static void toggleSortProcess(Scanner in) {
        System.out.println("Sort Process is currently " + (sortProcess ? "Enabled" : "Disabled"));
        sortProcess = !askYesOrNo(in, "Enter 'Y' to enable sort process, 'N' to disable.");
        System.out.println("Sort Process is now " + (sortProcess ? "Enabled\n" : "Disabled\n"));
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
                System.out.println("\n-------------------------------------------------------\n");
                System.out.println("Invalid input! Please enter 'Y' or 'N'.");
                System.out.println("\n-------------------------------------------------------");
            }


        }while(true);


        return value;

    }
    public static int askForArraySize(Scanner in){
        int maxIn = 12, minIn = 2;
        System.out.printf("Enter the number of grades to process (min: %d, max: %d)\n", minIn, maxIn);

        do{
            System.out.print("-->: ");
            int tempSize = askForUserInput(in, "\n-->");
            if(tempSize >= minIn && tempSize <= maxIn) {
                return tempSize;
            }
            else
                System.out.printf("\nArray Size should be within range of %d - %d, try again!\n\n", minIn, maxIn);

        }while(true);

    }
    public static int askForUserInput(Scanner in, String alertMsg) {
        while (!in.hasNextInt()) {
            System.out.println("Invalid input, try again!");
            System.out.printf("%s: ", alertMsg);
            in.next();
        }
        return in.nextInt();
    }
    public static int[] askForGrades(Scanner in,  int size){
        int maxIn = 100, minIn = 70;
        int input;
        int[] grdArr = new int[size];
        for(int i =0; i < size; i++){
            System.out.printf("Enter grade #%d: ", (i+1) );
            input = askForUserInput(in, "Enter grade #" + (i+1));
            if(input >= minIn && input <= maxIn) {
                grdArr[i] = input;
            }
            else{
                i--;
                System.out.println("Invalid input! Enter grades between 70 and 100 only.");
            }
        }

        return grdArr;
    }



    // --------------------------------------- Display ---------------------------------------
    public static void dispProcess(int[] numArr, int i, int j ){
        System.out.printf("Current Sorting Step (i=%d, j=%d): ", i, j);
        dispArray(numArr);
    }
    public static void dispValues(int[] sortArr, int arrSize){

        double ave = getAverage(sortArr, arrSize);
        int min = sortArr[0];
        int max = sortArr[arrSize -1];

        System.out.println("\n-------------------------------------------------------\n");
        System.out.printf("Your Average: %.2f \n", ave );
        System.out.printf("Minimum Grade: %d\n", min);
        System.out.printf("Maximum Grade: %d\n", max);
        System.out.println("\n-------------------------------------------------------");
    }

    public static void dispArray(int[] grdArr){
        System.out.print("[ ");
        for(int i =0; i< grdArr.length; i++){
            System.out.print(grdArr[i] + (i == grdArr.length - 1 ? " ]\n" : ", "));
        }
    }

    // --------------------------------------- Set and Get ---------------------------------------

    public static int[] setSortedArray(int[] gradeArr, int iterate ){
        if (iterate == 1) {
            System.out.println("Sorting using Selection Sort.");
            return selectSort(gradeArr);
        } else {
            System.out.println("Sorting using Bubble Sort.");
            return bubbleSort(gradeArr);
        }
    }

    public static double getAverage(int[]grdArr, int size){
        int total =0;

        for(int grade : grdArr){
            total += grade;
        }

        return (double) total / size;
    }


    // --------------------------------------- Sorting ---------------------------------------
    public static int[] bubbleSort(int[] grdArr){
        int n = grdArr.length;
        boolean swapped;
        for (int i = 0; i < n -1; i++) {
            swapped = false;
            for (int j = 0; j < (n - i) -1 ; j++) {
                if(sortProcess){
                    System.out.println("-----------------------------------------------");
                    dispProcess(grdArr, i,j);
                }
                if (grdArr[j] > grdArr[j + 1]) {
                    int temp = grdArr[j];
                    grdArr[j] = grdArr[j + 1];
                    grdArr[j + 1] = temp;

                    swapped = true;
                    if(sortProcess){
                        System.out.print("\nSwapped -> ");
                        dispArray(grdArr);
                    }
                }

            }
            if(!swapped){
                break;
            }
        }
        return grdArr;

    }

    public static int[] selectSort(int[] grdArr){
        int minIndex;
        int n = grdArr.length;

        for(int  i=0; i < n -1; i++){
            minIndex =i;
            for(int j = i +1; j < n; j++){
                if(sortProcess){
                    System.out.println("-----------------------------------------------");
                    dispProcess(grdArr, i, j);
                }
//                dispArray(grdArr);
                if(grdArr[j] < grdArr[minIndex]){
                    minIndex =j;
                }
//                System.out.printf("After Swaping: i=%d, j=%d, mI=%d\n", i, j, minIndex);

            }
            if(minIndex != i){
                int temp = grdArr[minIndex];
                grdArr[minIndex] = grdArr[i];
                grdArr[i] = temp;
            }



        }



        return grdArr;
    }







// i=0, j =1, m=0
//    [98, 70, 87, 81, 71, 93]
//    70, 98, 87, 81, 71, 93

//    i=0, j=2, mI = 1
//    70, 98, 87, 81, 71, 93
//    m =2
//    70, 87, 98, 81, 71, 93

//    i =0, j=2, m=2
//    70, 87, 98, 81, 71, 93
}
