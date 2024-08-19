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
		Scanner in = new Scanner(System.in);

		System.out.println("This program will accept 5 grades, and will print the minumum, \nmaximum and the average grade.");

		for(int i =0; i< numArr.length; i++) {
			System.out.print("Enter grade #" + (i+1) + ": ");
		    
		    // num = in.nextInt(); 
		    if(in.hasNextInt()){
            num = in.nextInt();
             if(num <= 70 || num >= 100){
     			   System.out.println("Enter grades between 70 to 100 only.");
     			   i--;
     			   continue;
    			}
    			else{
    			    numArr[i] = num;
    			}
		    }
		    else{
		        System.out.println("Wrong input, only whole numbers!!");
		        in.next();
		        i--;
		    }

           
		}
		// get Mininmum value
		min = getMin(numArr);
		
		// get Maximum Value
		max = getMax(numArr);
		
		// get Average Grade
		ave = getAverage(numArr);
		
		
		System.out.printf("Min: %d \n", min);
		System.out.printf("Max: %d \n", max);
		System.out.printf("Average: %.2f\n", ave);

	}
	

	public static double getAverage(int numArr[]) {
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