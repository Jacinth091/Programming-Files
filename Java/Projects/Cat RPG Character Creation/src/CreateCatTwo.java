import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

class Cat {

    Scanner in = new Scanner(System.in);
    ArrayList<String> catValueList;
    static byte noOfLegs = 4;
    String[] genderArr;
    String[] colorArr;
    String[] patternArr;
    String[] ageArr;
    String[] eyeColorArr;
    String[] userOptions;
    String catGender, catColor, catPattern, catAge, catEyeColor, catName;
    String placeHolder;
    String catValue;
    byte playerSelect, playerResponse;
    boolean validInput;

    Cat() {
        this.in = new Scanner(System.in);
        this.genderArr = new String[]{"Male", "Female"};
        this.colorArr = new String[]{"Orange", "Black", "White", "Brown", "Red"};
        this.patternArr = new String[]{"Solid", "Tabby", "Tortoise", "Color-point", "Bi-colour", "Tricolour (Calico)",};
        this.ageArr = new String[]{"Teen", "Mid-teen", "Adult", "Mid-adult", "Old"};
        this.eyeColorArr = new String[]{"Hazel", "Brown", "Gold", "Green", "Blue"};
        this.placeHolder = "None";
        this.userOptions = new String[]{"Gender: " + placeHolder, "Eye-Colour: " + placeHolder, "Color: " + placeHolder,
                "Pattern: " + placeHolder, "Age: " + placeHolder, "Name: " + placeHolder};
        this.catValueList = new ArrayList<String>();
        this.catGender = "";
        this.catColor = "";
        this.catAge = "";
        this.catName = "";
        this.catPattern = "";
        this.catEyeColor = "";
    }
    void determineTitle(){
        String stringBuffer;
        for(byte i = 0; i < userOptions.length; i++){
            if(playerSelect == (i + 1)){
                stringBuffer = userOptions[i];
                stringBuffer = userOptions[i].replace(": None", "").trim().toUpperCase();
                System.out.println("\n====================================================================");
                System.out.println("--------------------------" + stringBuffer + "---------------------------");
                System.out.println("====================================================================\n");
            }
        }
//        playerSelect = 0;
    }

    void displayArr(String[] array) {
        determineTitle();

        for (byte i = 0; i < array.length; i++) {
            System.out.println("\n\t" + (i + 1) + ".  " + array[i] + " ");
        }
    }

    void selectValue(String[] array) {
        playerSelect = 0;
        playerResponse = 0;
        do {

            try {

                System.out.println("\nEnter #" + "1 to " + "#" + array.length + " to Select, 0 to Cancel\n");
                System.out.print("---------> ::  ");
                playerResponse = in.nextByte();
//                System.out.println();
                if (playerResponse <= array.length && playerResponse >= 0) {
                    playerSelect = playerResponse;
//                    System.out.println(playerSelect);
                    validInput = true;

                    break;

                } else {
                    System.out.println("=============================");
                    System.out.println("Invalid Input!, Try Again!");
                    System.out.println("=============================\n");
                    displayArr(array);
                }
            } catch (InputMismatchException e) {
                System.out.println("=============================");
                System.out.println("Mismatch Input! Try Again!");
                System.out.println("=============================\n");
                in.nextLine();
                displayArr(array);

            }


        } while (!validInput);

    }

    void determineCatValue(String[] array){
        for(byte i = 0; i < array.length; i++){

            if(playerResponse == (i+1)){
                catValue = array[i];
            }

        }
        playerSelect = 0;
    }

}


public class CreateCatTwo {
    public static void main(String[] args) {

        boolean isValid = false;

        System.out.println("\n====================================================================");
        System.out.println("\t\t\t\tRPG Cat Character Creation ver. 2");
        System.out.println("====================================================================\n");

        System.out.println("\n====================================================================");
        System.out.println("--------------------------CREATE YOUR CAT---------------------------");
        System.out.println("====================================================================\n");

        Cat catOne = new Cat();

        catOne.displayArr(catOne.userOptions);
        catOne.selectValue(catOne.userOptions);

        do{
            if(catOne.playerSelect == 1){
                catOne.displayArr(catOne.genderArr);
                catOne.selectValue(catOne.genderArr);
                catOne.determineCatValue(catOne.genderArr);
                System.out.println(catOne.catValue);
                catOne.catValue = catOne.catGender;

            } else if (catOne.playerSelect == 2) {

                catOne.displayArr(catOne.eyeColorArr);
                catOne.selectValue(catOne.eyeColorArr);
                catOne.determineCatValue(catOne.eyeColorArr);
                System.out.println(catOne.catValue);
                catOne.catValue = catOne.catEyeColor;

            } else if (catOne.playerSelect == 3) {
                catOne.displayArr(catOne.colorArr);
                catOne.selectValue(catOne.colorArr);
                catOne.determineCatValue(catOne.colorArr);
                System.out.println(catOne.catValue);
                catOne.catValue = catOne.catColor;
            }
            else if (catOne.playerSelect == 4) {
                catOne.displayArr(catOne.patternArr);
                catOne.selectValue(catOne.patternArr);
                catOne.determineCatValue(catOne.patternArr);
                System.out.println(catOne.catValue);
                catOne.catValue = catOne.catPattern;
            }
            else if (catOne.playerSelect == 5) {
                catOne.displayArr(catOne.ageArr);
                catOne.selectValue(catOne.ageArr);
                catOne.determineCatValue(catOne.ageArr);
                System.out.println(catOne.catValue);
                catOne.catValue = catOne.catAge;
            }
        }while(!isValid);



    }
}
