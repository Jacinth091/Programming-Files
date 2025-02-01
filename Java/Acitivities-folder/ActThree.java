/*
    Name: Barral, Jacinth Cedric C.
    Date: Febuary 1 2025
    Description: Create a Java program that will allow the user to 
    enter 10 integer numbers, compute only the total sum 
    and product of all numbers 
    that are greater than 0. Display the total sum and product.


*/

import java.util.Scanner;

public class ActThree{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] num = new int[10];
        
        int sum =0, prod =1;
        System.out.println("Enter 10 numbers\n");
        
        for(int i =0; i< num.length; i++){
            System.out.print("Enter an integer: ");
            num[i] = in.nextInt();
        }
        
        for(int i =0; i < num.length; i++){
            if(num[i] > 0){
                sum += num[i];
                prod *= num[i];
                
            }
            
        }
        
        System.out.printf("\nSum total: %d\n", sum);
        System.out.printf("Product total: %d\n", prod);
        
        
        
        
    }
    
    
}