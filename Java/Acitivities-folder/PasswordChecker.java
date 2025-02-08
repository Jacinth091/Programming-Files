/*

    Name: Barral, Jacinth Cedric C.
    Date:Febuary 8 2025
    Description: Create a java program that will allow the user to enter a password should match the given cirteria
    * At least 8 Characters
    * Must contain at least 1 Number
    * Must contain at least 1 letter
    * Must contain at least 1 Special Character


*/

import java.util.Scanner;

class PasswordChecker{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String pwd = "";
        String temp = "";
        int counter =0;
        boolean exitLoop = false;
        char[] pwdArr ;
        boolean lenFlag, numFlag, speChFlag, letterFlag, validFlag;
        System.out.println("Password Checker Program by [Barral, Jacinth Cedric C]\n");
        do{
            counter++;
            System.out.print("\nInput password: ");
            pwd = in.nextLine().toUpperCase().trim();
            
            System.out.println();
    
       
            lenFlag = pwdIsDesiredLen(pwd);
            numFlag = pwdHasDigits(pwd);
            speChFlag = pwdHasSpecialChars(pwd);
            letterFlag = pwdHasLetter(pwd);
            
            validFlag = (!lenFlag) && numFlag && speChFlag && letterFlag;
            
            if(validFlag){
                System.out.println("VALID!");
                
                break;
            }
            else{
                System.out.println("INVALID!");

                
                if(lenFlag){
                    System.out.println("- Password must contain atleast 8 Characters!");
                }
                
                if(!numFlag){
                    System.out.println("- No Number");
                }
                
                if(!speChFlag){
                    System.out.println("- No Special Chaaracters!");
                }
                
                if(!letterFlag){
                    System.out.println("- No Letters");
                }
                
                System.out.println("\nInput a VALID PASSWORD!");
                System.out.println("Current Tries: " + counter + ".");
            }

            
            if(counter == 5){
                System.out.println("\nCurrent Tries has exceed the limit. Now exiting...");
                break;
            }
        }while(!exitLoop);

        System.out.println("\nThank you for using the program!");
        
    }
    public static boolean pwdIsDesiredLen(String pwd){
        return pwd.length() < 8;
    }   
    
    
    public static boolean pwdHasDigits(String pwd){
        char[] pwdArr = pwd.toCharArray();
        int count =0;
        for(int i =0; i< pwdArr.length; i++){
            if(pwdArr[i] >= '0' && pwdArr[i] <= '9'){
                count++;
            }
        }
        return count > 0;
 
    }
    
    public static boolean pwdHasSpecialChars(String pwd){
        char[] pwdArr = pwd.toCharArray();
        int count =0;
        for(int i =0; i< pwdArr.length; i++){
            if(!(pwdArr[i] >= 'A' && pwdArr[i] <= 'Z') && !(pwdArr[i] >= '0' && pwdArr[i] <= '9') ){
                count++;
            }
        }
        return count > 0;
 
    }
    
    public static boolean pwdHasLetter(String pwd){
        char[] pwdArr = pwd.toCharArray();
        int count =0;
        for(int i =0; i< pwdArr.length; i++){
            if((pwdArr[i] >= 'A' && pwdArr[i] <= 'Z') ){
                count++;
            }
        }
        return count > 0;
 
    }
}
