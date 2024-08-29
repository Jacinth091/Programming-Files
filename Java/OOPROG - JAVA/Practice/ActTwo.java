/*
* Name: Jacinth Cedric C. Barral
* Date: Aug 28, 2024
* Description: Prelim-Lab.Act.#02 - Working with arrays and sorting array elements
*        Demonstrate the use of arrays, sorting arrays and traverse an array.
* */
import java.util.Scanner;
class ActTwo {
//    static int arrSize =5;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int arrSize = 0;
        int[] gradeArr, sortArr;

        boolean sortProcess = false;
        String[] opt = {"Compute Grades and use Bubble Sort",
                "Compute Grades and use Selection Sort", "Enable Sort Process", "Disable Sort Process"};
        System.out.printf("Sort Process: (%s)\n", sortProcess);

        for(int i=0; i < opt.length; i ++){
            if(!sortProcess){
                System.out.printf("%d. %s.\n", (i+1), opt[i]);

            }
        }







        System.out.println("This program will ask the user the number of to process, \n" +
                "sort the array, prints the minimum, maximum and the average grade.");

        arrSize = askForArraySize(in);
        gradeArr = new int[arrSize];
        sortArr = new int[arrSize];





    }

    public static void mainLoop(Scanner in, int[] gradeArr, int[] sortArr, int arrSize){
        boolean exitLoop =false;
        int min =0, max =0;
        double ave =0;

        do{
            askForGrades(in, gradeArr, gradeArr.length);
            System.out.print("\nUnsorted => ");

            dispArray(gradeArr);
            System.out.println();


            sortArr = selectionSort(gradeArr);

            System.out.print("\nSorted? => ");
            dispArray(sortArr);

            ave = getAverage(sortArr, arrSize);
            min = sortArr[0];
            max = sortArr[arrSize -1];

            System.out.printf("Your Average: %.2f\n", ave );
            System.out.printf("Minimum Grade: %d\n", min);
            System.out.printf("Maximum Grade: %d\n", max);
        }while(exitLoop);
    }

    public static boolean checkYesOrNo(Scanner in){
        boolean value = false;
        do{
            char input;
            System.out.println("\"Y\" to start again, \"N\" to exit the program.");
            System.out.print("Your choice: ");

            input = in.next().toUpperCase().charAt(0);

            if(input == 'Y' || input == 'N'){
                if( input == 'N'){

                    value = true;
                }
                break;
            }
            else{

                System.out.println("\n-------------------------------------------------------\n");

                System.out.println("Input only Y and N to function, try again.");

                System.out.println("\n-------------------------------------------------------");
            }

        }while(true);

        return value;

    }

    public static int askForArraySize(Scanner in){
        int tempSize = 2, maxIn = 12, minIn = 2;
        System.out.println("\nEnter the number of grades to process.");
        System.out.printf("(Note: the default/Minimum size is %d, and the Max is %d).\n", minIn, maxIn);
        do{
            System.out.print("Input =>: ");
            tempSize = askForUserInput(in);
            if(tempSize == -100)
                System.out.println("\nInput only Integers only, try again!\n");
            else if(tempSize < minIn || tempSize > maxIn)
                System.out.printf("\nArray Size should be within range of %d - %d, try again!\n\n", minIn, maxIn);
            else
                break;
        }while(true);
        return tempSize;
    }

    public static double getAverage(int[]grdArr, int size){
        int total =0;

        for(int grade : grdArr){
            total += grade;
        }

        return (double) total / size;
    }
    public static int askForUserInput(Scanner in) {
//        boolean isValid = false;
        int numTemp ;

        if(!(in.hasNextInt())){
            in.next();
            numTemp = -100;

        }
        else{
            numTemp = in.nextInt();
        }
/*
        try{
            numTemp = in.nextInt();
//            isValid = true;
        }catch(NumberFormatException e){
            System.out.println("Input only Integers only, try again!");
            numTemp = -1;

        }
        catch(InputMismatchException e){
            System.out.println("Input only Numbers only, try again!");
            numTemp = -2;
        }*/

        return numTemp;
    }
    public static void askForGrades(Scanner in, int[] grdArr, int size){
        int maxIn = 100, minIn = 70;
        int input =0;
        for(int i =0; i < size; i++){
            System.out.printf("Enter grade #%d: ", (i+1) );
            input = askForUserInput(in);
            if(input >= minIn && input <= 100)
                grdArr[i] = input;
            else if(input == -100){
                i--;
                System.out.println("\nInput only Integers only, try again!\n");
            }
            else{
                i--;
                System.out.printf("\nInput grades only within %d to %d, try again!\n\n", minIn, maxIn);
            }
        }
    }
    public static void dispArray(int[] grdArr){
        System.out.print("[ ");
        for(int i =0; i< grdArr.length; i++){
            if(i == grdArr.length -1){
                System.out.printf("%d ]\n", grdArr[i]);
            }
            else{
                System.out.printf("%d, ", grdArr[i]);
            }
        }
    }
    public static int[] bubbleSort(int[] grdArr){
        int n = grdArr.length;
        boolean swapped;


        for (int i = 0; i < n -1; i++) {
            swapped = false;
            for (int j = 0; j < (n - i) -1 ; j++) {

                if (grdArr[j] > grdArr[j + 1]) {
                    int temp = grdArr[j];
                    grdArr[j] = grdArr[j + 1];
                    grdArr[j + 1] = temp;

                    swapped = true;
                }

            }
            if(!swapped){
                break;
            }
        }

        return grdArr;

    }

    public static int[] selectionSort(int[] grdArr){
        int minIndex =0;
        int n = grdArr.length;

        for(int  i=0; i < n -1; i++){
            minIndex =i;
            for(int j = i +1; j < n; j++){
                System.out.printf("i=%d, j=%d, mI=%d\n", i, j, minIndex);
                dispArray(grdArr);
//                dispArray(grdArr);
                if(grdArr[j] < grdArr[minIndex]){
                    minIndex =j;
                }
//                System.out.printf("After Swaping: i=%d, j=%d, mI=%d\n", i, j, minIndex);

            }
            int temp = grdArr[minIndex];
            grdArr[minIndex] = grdArr[i];
            grdArr[i] = temp;

//            System.out.printf("After swapping: i=%d, minIndex=%d\n", i, minIndex);
//            dispArray(grdArr);



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
