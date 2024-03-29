
import java.util.Scanner;
public class ArmstrongNumber
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int userInput, temp, digits = 0, total =0;
		int[] digitArr = new int[3];
		
		System.out.print("Input Input an Armstrong Number: ");
		userInput = in.nextInt();
		in.nextLine();
		
		temp = userInput;
		
		for(byte i =0; i< digitArr.length; i++){
		    if(temp > 0){
    		    digits = temp % 10;
    		  //  System.out.printf("Digits: %d\n", digits);
    		    digitArr[i] = digits;
    		    temp /= 10;
    		  //  System.out.printf("Temp: %d\n", temp);
		    }
		  //  System.out.print("\n");
		    total += cubeNumber(digitArr[i]);
		  //  System.out.printf("\ntotal: %d", total);
		}
        
		if(total == userInput){
            System.out.print("\nCondition: SATISFIED!\n");    // if true, it will display this block of code
            System.out.printf("Total value of %d is EQUAL to the Input number %d\n", total, userInput);
        }else {
            System.out.print("\nCondition: NOT SATISFIED!\n"); // If false, it will run this block of code
            System.out.printf("Total value of %d is NOT EQUAL to the input number %d\n", total, userInput);
        }

		
		
	}
	
	static int cubeNumber(int num){
	    return num * num * num;
	    
	}
}
