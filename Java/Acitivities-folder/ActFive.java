/*
    Name: Barral, Jacinth Cedric C.
    Date: Febuary 1 2025
    Description: Create a java program that will allow the user to 
    enter 10 integer numbers, and display all 
    odd and even numbers in columns:


*/


import java.util.Scanner;

public class ActFive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] num = new int[10]; 
        // int[] num = new int[]{5, 3, 0, 4, 2, 7, 2, 8, 1, 10};
        int evenCount = 0, oddCount = 0;
        

        int[] evenArr = new int[num.length];
        int[] oddArr = new int[num.length];
        

        for (int i = 0; i < num.length; i++) {
            System.out.print("Enter an integer: ");
            num[i] = in.nextInt();
            
            int input = num[i];
            

            if (input % 2 == 0) {
                evenArr[evenCount++] = input;
            } else {
                oddArr[oddCount++] = input;
            }
        }
        
        System.out.println("\n\nOutput: \n");

        System.out.printf("%-15s%-15s\n", "Even", "Odd");


         for (int i = 0; i < evenCount; i++) {
             System.out.printf("%-15d", evenArr[i]);
             if (i < oddCount) {
                 System.out.printf("%-15d", oddArr[i]);
             }
             System.out.println();
         }

    }
}
