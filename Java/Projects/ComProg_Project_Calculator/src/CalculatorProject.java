import java.util.InputMismatchException;
import java.util.Scanner;
public class CalculatorProject {
    static UserMenu userMenu = new UserMenu();
    static Operations operation = new Operations();
    public static void main(String[] args) {
//        Operations oper = new Operations();
        int i = 0;

/*        userMenu.displayArray(userMenu.mainMenu);
        userMenu.getInputFromArray(userMenu.mainMenu);*/

        do{

            // Addition
            operation.getDataFromUser();
            System.out.printf("Result: %.2f", operation.sumOfNum(operation.numbers));
            System.out.println("\n");

            // Subtraction
            operation.getDataFromUser();
            System.out.printf("Result: %.2f", operation.diffOfNum(operation.numbers));
            System.out.println("\n");
            i++;

        }while(i < 10);


        // Multiplication
        operation.getDataFromUser();
        System.out.printf("Result: %.2f", operation.prodOfNum(operation.numbers));
        System.out.println("\n");

        // Division
        operation.getDataFromUser();
        System.out.printf("Result: %.2f", operation.quotientOfNum(operation.numbers));
        System.out.println("\n");

        // Modulo
        operation.getDataFromUser();
        System.out.printf("Result: %.2f", operation.moduloOfNum(operation.numbers));
        System.out.println("\n");

    }
}
class UserMenu {
    Scanner in = new Scanner(System.in);
    static byte responseOne, responseTwo;
    static boolean exitLoop;

    String[] mainMenu = {"Addtion", "Subtraction", "Multiplication", "Division", "Modulo", "Conversion"};
    String[] conversionMenu = {"Decimal to Binary",  "Decimal to Hex", "Decimal to Octal" };

    void displayArray(String[] array){

        /*Display Array*/

        for(byte  i = 0; i < array.length; i++){
            System.out.printf("%d.) %s\n", (i+1), array[i]);
        }
    }
    void getInputFromArray(String[] array){
        exitLoop = false;
        responseOne =0;
        responseTwo = 0;

        /*Selecting Value from Array*/

        do{
            try{
                System.out.print("Choice -->::  ");
                responseOne = in.nextByte();
                in.nextLine();

                if(responseOne <= array.length && responseOne >= 0){
                    responseTwo = responseOne;
                    System.out.printf("ResponseOne: %d\n", responseOne);
                    System.out.printf("ResponseTwo: %d\n", responseTwo);
                    exitLoop = true;
                    break;


                }
                else{
                    System.out.println("---------------------------------------");
                    System.out.println("\t   Invalid Input, Try again!");
                    System.out.println("---------------------------------------");
                    displayArray(array);
                }
            }catch(InputMismatchException e){
                System.out.println("---------------------------------------");
                System.out.println("\t   Invalid Input, try again!");
                System.out.println("---------------------------------------");
                in.nextLine();
                displayArray(array);
            }

        }while(!exitLoop);
    }

}
class Operations{
    Scanner in = new Scanner(System.in);
    float[] numbers;
    float result;
    void getDataFromUser(){
        numbers = new float[2];
        do{
            for(byte i = 0; i < numbers.length; i++){
                System.out.printf("Input Value %d: ", (i+1));
                numbers[i] = in.nextFloat();
                in.nextLine();
            }

        }while(numbers.length != 2);

    }

    float sumOfNum(float[] num){
        return num[0] + num[1]; // Assuming only two numbers are provided
    }
    float diffOfNum(float[] num){
        return num[0] - num[1]; // Assuming only two numbers are provided
    }

    float prodOfNum(float[] num){
        return num[0] * num[1]; // Assuming only two numbers are provided
    }

    float quotientOfNum(float[] num){
        if(num[1] == 0){
            return 0;
        }
        else{
            result = num[0] / num[1]; // Assuming only two numbers are provided
            System.out.printf("Result: %.2f\n", result);
        }
        return result;
    }
    float moduloOfNum(float[] num){
        if(num[1] == 0){
            return 0;
        }
        else{
            result = num[0] % num[1]; // Assuming only two numbers are provided
            System.out.printf("Result: %.2f\n", result);
        }
        return result;
    }

}
