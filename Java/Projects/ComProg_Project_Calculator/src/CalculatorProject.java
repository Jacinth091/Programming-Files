/*
import java.util.InputMismatchException;
import java.util.Scanner;
public class CalculatorProject {
    static UserMenu userMenu = new UserMenu();
    static Operations operation = new Operations();
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        boolean exitLoop = false;
        char response;
//        int userChoice;
        float result;

        do{
            result =0;
            response='0';
            System.out.println("**********************************");
            System.out.println("\t    Simple Calculator");
            System.out.println("**********************************\n");
            userMenu.displayArray(userMenu.mainMenu);
            userMenu.getInputFromMenu(userMenu.mainMenu);

            switch(userMenu.userChoice){
                case 1:
                    operation.getNumbersArray();
                    result = operation.sumOfNum(operation.numbers);

                    break;
                case 2:
                    operation.getNumbersArray();
                    result = operation.diffOfNum(operation.numbers);

                    break;
                case 3:
                    operation.getNumbersArray();
                    result = operation.prodOfNum(operation.numbers);

                    break;
                case 4:
                    operation.getNumbersArray();
                    result = operation.quotientOfNum(operation.numbers);

                    break;
                case 5:
                    operation.getNumbersArray();
                    result = operation.moduloOfNum(operation.numbers);

                    break;
                case 6:
                        conversionControler(userMenu, operation);
                    continue;
                case 7:
                    System.out.println("ALL Operations");
                    break;
                case 0:
                    System.out.println("\n**********************************");
                    System.out.println("\t\t     Goodbye!!");
                    System.out.println("**********************************\n");
                    System.exit(0);
                    break;
            }
            if(operation.numbers[1] == 0){
                System.out.println("\nDividing By Zero is Not Allowed!\n");
                continue;
            }
            else
                System.out.printf("Result: %.2f\n", result);
            do{
                System.out.print("Again? (Y for yes, N for No): " );
                response = in.next().charAt(0);
                response = Character.toUpperCase(response);
                in.nextLine();

                if(response != 'Y' && response != 'N'){
                    System.out.println("Invalid Input, try again!");
                }
                else if(response == 'Y'){
                    break;
                }
                else{
                    exitLoop = true;
                    break;
                }

            }while(true);
        }while(!exitLoop);
    }

    static void conversionControler(UserMenu userMenu, Operations operation){
        char choice;
        boolean exitLoop = false;
        do{
            choice='0';
            System.out.println("\n**********************************");
            System.out.println("\t   Number Conversion");
            System.out.println("**********************************\n");
            userMenu.displayArray(userMenu.conversionMenu);
            userMenu.getInputFromMenu(userMenu.conversionMenu);

            switch(userMenu.userChoice){
                case 1:
                    operation.getValue();
                    operation.decToBin(operation.numData);
                    System.out.printf("The number %d converted to BINARY is: ", operation.numData);
                    operation.conversDispNumb(operation.digits);
                    System.out.println();
                    continue;
                case 2:
                    operation.getValue();
                    operation.decToHex(operation.numData);
                    System.out.printf("The number %d converted to HEXADECIMAL is: ", operation.numData);
                    operation.conversDispChar(operation.hex);
                    System.out.println("\n");
                    break;
                case 3:
                    operation.getValue();
                    operation.decToOctal(operation.numData);
                    System.out.printf("The number %d converted to OCTAL is: ", operation.numData);
                    operation.conversDispNumb(operation.digits);
                    System.out.println("\n");
                    break;
                case 0:
                    System.out.println("\n**********************************");
                    System.out.println("\t\t     Goodbye!!");
                    System.out.println("**********************************\n");
                    System.exit(0);
                    break;
                case -1:
                    exitLoop = true;
                    break;
            }
            if(!exitLoop){
                do{
                    System.out.print("Again? (Y for yes, N for No): " );
                    choice = in.next().charAt(0);
                    choice = Character.toUpperCase(choice);
                    in.nextLine();

                    if(choice != 'Y' && choice != 'N'){
                        System.out.println("Invalid Input, try again!");
                    }
                    else if(choice == 'Y'){
                        break;
                    }
                    else{
                        exitLoop = true;
                        break;
                    }
                }while(true);
            }

        }while(!exitLoop);

    }
}


class UserMenu {
    Scanner in = new Scanner(System.in);
    static byte initChoice, userChoice;
    static boolean exitLoop;

    String[] mainMenu = {"Addtion", "Subtraction", "Multiplication", "Division", "Modulo", "Conversion", "All Operations?", "Exit Program"};
    String[] conversionMenu = {"Decimal to Binary",  "Decimal to Hex", "Decimal to Octal", "Back to the Main Menu", "Exit Program" };

    void getInputFromMenu(String[] array){
        exitLoop = false;
        initChoice =0;
        userChoice = 0;

        */
/*Selecting Value from Array*//*


        do{
            try{
                System.out.print("\nInput -->::  ");
                initChoice = in.nextByte();
                in.nextLine();

                if(initChoice <= array.length && initChoice >= -1){
                    userChoice = initChoice;
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

    void displayArray(String[] array){
        */
/*Display Array*//*

        for(byte  i = 0; i < array.length; i++){

            if(array[i] == "Back to the Main Menu"){
                System.out.printf("\n-1). %s", array[i]);
            }else if(i == array.length-1){
                System.out.printf("\n 0). %s\n", array[i]);
            }
            else{
                System.out.printf(" %d). %s\n", (i+1), array[i]);
            }

        }
    }
}

class Operation{
    Scanner in = new Scanner(System.in);
    final int size = 20;
    float[] numbers;
    int temp, numData;
//    float result;


    // For Conversion
    int[] digits;
    char[] hex;
    byte index;


    boolean exitLoop;


    void getNumbersArray(){
        numbers = new float[2];
        System.out.println();
        do{
            for(byte i = 0; i < numbers.length; i++){
                System.out.printf("Input Value %d: ", (i+1));
                numbers[i] = in.nextFloat();
                in.nextLine();
            }

        }while(numbers.length != 2);
    }

    // Operations
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
        return num[0] / num[1];
    }
    float moduloOfNum(float[] num){
        if(num[1] == 0){
            return 0;
        }
        return num[0] % num[1];
    }


    // Conversion

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

    void decToBin(int num){
        digits  = new int[size];
        index = 0;
        while (num > 0) {
            digits[index] = num % 2;
            num /= 2;
            index++;
        }

    }

    void decToOctal(int num) {
        digits = new int[size];
        index = 0;

        while(num > 0) {
            digits[index] = num % 8;
            num /= 8;
            index++;
        }
    }

    void decToHex(int num){
        hex = new char[size];
        index =0;
        while(num > 0){

            hex[index] = (num%16 == 10) ? 'A' : (num%16 == 11) ? 'B' :
                    (num%16 == 12) ? 'C' : (num%16 == 13) ? 'D' :
                            (num%16 == 14) ? 'E' : (num%16 == 15) ? 'F' :
                                    (char) ((num%16)+48);
            num /= 16;
            index++;
        }
    }

    void conversDispNumb(int[] array){
        for( int  i = index -1; i >= 0; i--)
            System.out.printf("%d", array[i]);
    }
    void conversDispChar(char[] array){
        for( int  i = index -1; i >= 0; i--)
            System.out.printf("%c", array[i]);
    }

}












*/
/*//*
/        operation.numData = 20;
        operation.getValue();
        System.out.println("Num Data: " + operation.numData);
        System.out.printf("Temp: %d\n", operation.temp);

        System.out.printf("%d converted to Binary: \n", operation.temp);
        operation.deciToBin(operation.numData);

        for(int i = operation.index -1; i >= 0; i--){
            System.out.printf("%d ", operation.digits[i]);
        }*//*



//        int num =1000000000;*/
