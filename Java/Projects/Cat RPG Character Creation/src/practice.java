import java.util.Scanner;
public class practice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter the operation (+ - * /): ");
        char operation = scanner.next().charAt(0);

        double result =0;

        switch (operation){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if(num2 == 0 ){
                    System.out.println("Error, Division by zero is not allowed!");
                    return;
                }
                result = (double)num1 / num2;
                break;
            case '%':
                if(num2 == 0 ){
                    System.out.println("Error, Division by zero is not allowed!");
                    return;
                }
                result = (double)num1 % num2;
                break;
            default:
                System.out.println("Error: Invalid operation. Please enter a valid operation (+ - * /).");
                return;

        }
        System.out.printf("The result is: %.2f", result);

    }
}
