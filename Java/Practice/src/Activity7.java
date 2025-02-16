/*

    Name: Barral, Jacinth Cedric C.
    Date: Febuary 14, 2025  - Hearts Day <3<3
    Description: Activity 7 Duplicate Checker

*/

import java.util.Scanner;

public class Activity7
{    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int[] num = new int[10];

        boolean isArrayHasDupe =false;
        
        System.out.println("Enter 10 integers\n");
        
        for(int i =0; i < num.length; i++){
            System.out.printf("Enter number %d: ", (i+1));
            num[i] = in.nextInt();
        }
        
        System.out.println("\n");

        for(int i=0; i< num.length; i++){
            for(int j =i+1; j <num.length ; j++){
                if(num[i] == num[j]){
                    isArrayHasDupe = true;
                    break;
                }
            }
        }

        if(!isArrayHasDupe){
            System.out.println("======= No duplicates found in the array! ======="); 
        }
        else{
            System.out.println("Has duplication (Removed the duplicates): ");
            for(int i=0; i< num.length; i++){
                boolean duplicateFlag = false;
                for(int j =0; j < i; j++){
                    if(num[i] == num[j]){
                        duplicateFlag = true;
                        break;
                    }
                }
                if(!duplicateFlag){
                    System.out.printf("%d ", num[i]);
                }
            }
        }
    }
    
    
}
