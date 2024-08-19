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

		int max = 0, min =0, num =0;

		int maxGrade =100, minGrade =70;

		Scanner in = new Scanner(System.in);

		System.out.println("This program will accept 5 grades, and will print the minimum, \nmaximum and the average grade.");

		numArr = getGrades(numArr.length, minGrade, maxGrade, in);

		in.close();

		// get Minimum value
		min = getMin(numArr);
		
		// get Maximum Value
		max = getMax(numArr);
		
		// get Average Grade
		ave = getAverage(numArr);
		

		displayResult(max, min, ave);

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
		System.out.printf("Min: %d \n", min);
		System.out.printf("Max: %d \n", max);
		System.out.printf("Average: %.2f\n", ave);
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