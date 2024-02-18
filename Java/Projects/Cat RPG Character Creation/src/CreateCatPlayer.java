//import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;


class CreateCatPlayer {
    Scanner in = new Scanner(System.in);
    static byte noOfLegs = 4;
    String[] genderArr;
    String[] colorArr;
    String[] patternArr;
    String[] ageArr;
    String[] eyeColorArr;
    String catGender, catColor, catPattern, catAge, catEyeColor;
    byte playerSelect, response;
    boolean validInput;

//    boolean hasTail, hasPatches;

    CreateCatPlayer(){
        this.in = new Scanner(System.in);
        this.genderArr = new String[]{"Male", "Female"};
        this.colorArr = new String[]{"Orange", "Black", "White", "Brown", "Red"};
        this.patternArr = new String[]{"Solid", "Tabby", "Tortoise", "Color-point", "Bi-colour", "Tricolour (Calico)", };
        this.ageArr = new String[]{"Teen", "Mid-teen", "Adult", "Mid-adult", "Old"};
        this.eyeColorArr = new String[]{"Hazel", "Brown", "Gold", "Green", "Blue"};

    }
    void displayArray(String[] array){
        for(byte i = 0; i < array.length; i++){
            System.out.println( "\t" + (i+1) + ".  " + array[i] + " ");
        }

    }
    void playerSelect(String[] array){
        playerSelect = 0;
        response = 0;
        do {

            try{
                System.out.println("\nEnter #" + "1 to " + "#" + array.length + " to Select, 0 to Cancel\n");
                System.out.print("---------> ::  ");
                response = in.nextByte();
//                System.out.println();
                if(response <= array.length && response >= 0 ){
                    playerSelect = response;
//                    System.out.println(playerSelect);
                    validInput = true;
                    break;

                }
                else{
                    System.out.println("=============================");
                    System.out.println("Invalid Input!, Try Again!");
                    System.out.println("=============================\n");
                    displayArray(array);
                }
            }
            catch (InputMismatchException e){
                System.out.println("=============================");
                System.out.println("Mismatch Input! Try Again!");
                System.out.println("=============================\n");
                in.nextLine();
                displayArray(array);

            }


        }while(!validInput);


    }





}
