
import java.util.Scanner;

public class decToBin
{

    private static int counter = 0;
    private static int[] binaryArr = new int[20];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = 0, temp =0;

        System.out.print("Enter Number to convert to Binary: ");
        num = in.nextInt();
        in.nextLine();

        temp = num;
        getBinary(num);
        System.out.printf("%d converted to Binary is: ", temp);


        for(int i = counter-1; i >=0; i--){
            System.out.print(binaryArr[i]);
        }


    }

    static void getBinary(int num){

        while(num > 0){

            binaryArr[counter] = num % 2;
            num = num /2;
            counter++;
        }

    }
}
