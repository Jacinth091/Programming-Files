import java.util.Scanner;
public class Try {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String [] array = {"Array1", "Array2", "Array 3"};
        String [] arrayTwo = {"1", "2", "3",};
        byte response =0, userValue = 0;
        displayArray(array);
        userIn(response, userValue, array);
//        arrayLoop(response);

    }
    static void displayArray(String[] array){
        for(byte i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }

    }
    static void userIn(byte response, byte userValue, String[] array){
        do{
            System.out.print("Input: ");
            response = in.nextByte();
            if(response <= array.length && response > 0 ){
                userValue = response;
                break;
            }
            else{
                System.out.println("Invalid Input! ");
            }
        }while(true);
    }

/*    static void determineOpt(){
        do{

        }while();
    }*/
/*    static void arrayLoop(byte response){
        response = 0;
        do{

        }while();
    }*/
}
