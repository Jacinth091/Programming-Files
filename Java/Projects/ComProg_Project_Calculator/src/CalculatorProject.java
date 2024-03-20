import java.util.InputMismatchException;
import java.util.Scanner;
public class CalculatorProject {
    static UserMenu userMenu = new UserMenu();
    static Operations operation = new Operations();
    public static void main(String[] args) {


/*//        operation.numData = 20;
        operation.getValue();
        System.out.println("Num Data: " + operation.numData);
        System.out.printf("Temp: %d\n", operation.temp);

        System.out.printf("%d converted to Binary: \n", operation.temp);
        operation.deciToBin(operation.numData);

        for(int i = operation.index -1; i >= 0; i--){
            System.out.printf("%d ", operation.digits[i]);
        }*/


        int num =1000000000;
        char[] hex = new char[20];
        int index =0;

        while(num > 0){

            hex[index] = (num%16 == 10) ? 'A' : (num%16 == 11) ? 'B' :
                         (num%16 == 12) ? 'C' : (num%16 == 13) ? 'D' :
                         (num%16 == 14) ? 'E' : (num%16 == 15) ? 'F' :
                          (char) ((num%16)+48);
            num /= 16;
/*            digits[i] = (num%16)*/
            index++;
        }

        System.out.println();
        for(int i = index -1; i >= 0; i--){
            System.out.print(hex[i]);
        }


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
    void getInputFromMenu(String[] array){
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
    int[] digits;
    byte index;
    int temp, numData;
    boolean exitLoop;
    float result;
    void getNumbersArray(){
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


    void getValue(){
        numData = 0;
        temp = 0;
        exitLoop = false;
        do{
            System.out.println("--------Enter Number to Convert--------\n");
            try{
                System.out.print("Number -->::  ");
                numData = in.nextInt();
                in.nextLine();
                temp = numData;
                exitLoop = true;
            }catch (InputMismatchException e){
                System.out.println("---------------------------------------");
                System.out.println("\t   Invalid Input, try again!");
                System.out.println("---------------------------------------");
                in.nextLine();
                System.out.println();
            }
        }while(!exitLoop);
    }


    void deciToBin(int num){
        digits  = new int[20];
        index = 0;

        while (num > 0) {
            digits[index] = num % 2;
            num /= 2;
//                System.out.printf("%d ", num);
            index++;
        }

    }

}
