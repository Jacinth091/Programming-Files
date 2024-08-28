/*
* Name: Jacinth Cedric C. Barral
* Date: Aug 28, 2024
* Description: Prelim-Lab.Act.#02 - Working with arrays and sorting array elements
*        Demonstrate the use of arrays, sorting arrays and traverse an array.
* */



import java.util.Scanner;


class ActTwo {
    static int arrSize =5;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int[] gradeArr = new int[5];
        int[] sortArr;

        System.out.println("This program will ask the user the number of to process, \n" +
                "sort the array, prints the minimum, maximum and the average grade.");

        System.out.println("Enter the number of grades to process:\n");

/*        askForGrades(in, gradeArr, gradeArr.length);

        dispArray(gradeArr, "Unsorted");

        sortArr = bubbleSort(gradeArr);

        dispArray(sortArr, "Sorted?");*/
//            checkValidity(in);
//            askForUserInput(in);




    }
    public static double getAverage(int[]grdArr, int size){
        int total =0;

        for(int grade : grdArr){
            total += grade;
        }

        return (double) total / size;
    }
    public static int askForUserInput(Scanner in){
        return checkValidity(in);
    }
    public static int checkValidity(Scanner in) {
//        boolean isValid = false;
        int numTemp ;

        if(!(in.hasNextInt())){
            in.next();
            numTemp = -1;

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
            if(input >= minIn && input <= 100){

                grdArr[i] = input;
            }
            else if(input == -1){
                i--;
                System.out.println("\nInput only Integers only, try again!\n");
            }
            else{
                i--;
                System.out.printf("\nInput grades only within %d to %d, try again!\n\n", minIn, maxIn);
            }

        }

    }

    public static void dispArray(int[] grdArr, String title){
        System.out.printf("%s => [ ", title);
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

}
