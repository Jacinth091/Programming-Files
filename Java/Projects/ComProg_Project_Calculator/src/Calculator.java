import java.util.Scanner;


public class Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char oper;
        int num1, num2;
        int result;

        System.out.println("Input Integer 1: ");
        num1 = in.nextInt();
        in.nextLine();

        System.out.println("Input Integer 2: ");
        num2 = in.nextInt();
        in.nextLine();

        System.out.println("Input what Operation to use ( + - / *):  ");
        oper = in.next().charAt(0);
        in.nextLine();



    }
}
