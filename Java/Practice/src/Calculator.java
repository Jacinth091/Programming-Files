import java.util.Scanner;

public class Calculator {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        do{
            
            double num1 = 0, num2 = 0, result = 0;
            char operat, response;
    
            System.out.print("\nEnter Num 1: ");
            num1 = input.nextDouble(); 
    
            System.out.print("Enter what operation to use (+ - * /): ");
            operat = input.next().charAt(0);

    
            System.out.print("Enter Num 2: ");
            num2 = input.nextDouble();
    
            switch (operat) {
                case '+':
                    result = num1 + num2;
                    System.out.println("\nResult: "+result);
                break;
                case '-':
                    result = num1 - num2;
                    System.out.println("\nResult: "+result);
    
                break;
                case '*':
                    result = num1 * num2;
                    System.out.println("\nResult: "+result);
                break;
                case '/':
                    result = (num2 != 0 ) ? num1 / num2 : 0;
                    System.out.println((result == 0) ? "Undefined" : "\nResult is: " + result);
                break;
            
                default:
                    System.out.println("Error");
                    break;
            }

                System.out.print("\nAgain? (y/n): ");
            response = input.next().toUpperCase().charAt(0);
            if(response == 'N' ){
                break;
            }
            else if (response != 'Y'){
                System.out.println("Invalid Response!");
                continue;
            }
        }while(true);
        System.out.println("GoodBye!");
        input.close();
        

    }
}
