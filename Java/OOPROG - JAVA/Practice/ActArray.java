/******************************************************************************
 * Name: Barral.Jacinth Cedric C.
 * Date: August 19 2024
 * Description: Prelim-Lab.Act.#01 - Working with Arrays
 *

*******************************************************************************/

import java.util.Scanner;

class Main
{
	public static void main(String[] args) {

		int[] numArr = new int[5];
		double ave =0;

		int max = 0,
				min =0,
				num =0;

		final int maxGrade =100,
				minGrade =70;


		Scanner in = new Scanner(System.in);

		System.out.println("This program will accept 5 grades, and will print the minimum, \nmaximum and the average grade.");

		mainLoop(numArr, max, min, num, ave, minGrade, maxGrade, in);
		// Main Logic Loop

		in.close();
	}

	public static void mainLoop(int[] numArr, int max, int min, int num, double ave, int minGrade, int maxGrade, Scanner in){

		boolean exitLoop = false;
		int count =0;
		do{
			System.out.println("-------------------------------------------------------");

			System.out.printf("\nYou have looped --%d--!\n", count++ );

			System.out.println("Student's Grades\n");

			numArr = getGrades(numArr.length, minGrade, maxGrade, in);

			// get Minimum value
			min = getMin(numArr);

			// get Maximum Value
			max = getMax(numArr);

			// get Average Grade
			ave = getAverage(numArr);


			displayResult(max, min, ave);

			exitLoop = checkYesOrNo(in);


		}while(!exitLoop);

		System.out.println("\n-------------------------------------------------------\n");

		System.out.println("Thank you, come again :D");

		System.out.println("\n-------------------------------------------------------");
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
				System.out.println("Input only Y and N to function, try again.");
			}

		}while(true);

		return value;

	}

	public static int checkNum(Scanner in){
		int tempNum;

		if(in.hasNextInt()){
			tempNum = in.nextInt();

		}
		else{
			in.next();
			return -100;
		}
		return tempNum;
	}


	public static int[] getGrades(int size,int minGrade, int maxGrade, Scanner in){
		int[] tempArr = new int[size];
		int tempNum;

		for(int i= 0; i< size; i++){
			System.out.print("Enter grade #" + (i+1) + ": ");

			tempNum = checkNum(in);

			if(tempNum == -100){
				System.out.println("Invalid Input, try again!");
				i--;
            }
			else if(tempNum < minGrade || tempNum > maxGrade){
				System.out.println("Enter grades between 70 to 100 only.");
				i--;
            }
			else{
				tempArr[i] = tempNum;
			}


		}

		return tempArr;
	}



	public static void displayResult(int max, int min, double ave){
		System.out.println("-------------------------------------------------------");
		System.out.printf("Min: %d \n", min);
		System.out.printf("Max: %d \n", max);
		System.out.printf("Average: %.2f\n", ave);
		System.out.println("-------------------------------------------------------");
	}
	

	public static double getAverage(int[] numArr) {
        int total =0;
        
        for(int i =0; i< numArr.length; i++){
            total += numArr[i];
        }
		return (double) total /numArr.length;

	}

	public static int getMax(int[] numArr) {
		int temp = 0;

		for(int i =0; i< numArr.length; i++) {
			if(temp < numArr[i]) {
				temp = numArr[i];
			}
		}
		return temp;
	}

	public static int getMin(int[] numArr) {
		int temp = 100;

		for(int i =0; i< numArr.length; i++) {
			if(temp > numArr[i]) {
				temp = numArr[i];
			}
		}
		return temp;
	}
}