import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;


class CreateCatPlayer {
    Scanner in = new Scanner(System.in);
    ArrayList<String> catValueList = new ArrayList<String>();
    static byte noOfLegs = 4;
    String[] genderArr;
    String[] colorArr;
    String[] patternArr;
    String[] ageArr;
    String[] eyeColorArr;
    String[] userOptions;
    String catGender, catColor, catPattern, catAge, catEyeColor, catName;
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
        this.userOptions = new String[]{"Gender: None", "Eye-Colour: None ", "Color: None ","Pattern: None","Age: None", "Name: None"};
    }
    void setArrayList(){
        for(byte i = 0; i <= userOptions.length; i++){
            catValueList.set((i+1), userOptions[i]);
        }
    }
    void displayArray(String[] array){
        for(byte i = 0; i < array.length; i++){
            System.out.println( "\t" + (i+1) + ".  " + array[i] + " ");
        }

    }

    void determineTitle(){
        String stringBuffer = "";
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

    void playerSelect(String[] array){
        playerSelect = 0;
        response = 0;
        do {

            try{
                determineTitle();
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


    void dispAndSelect(String[] array){

        displayArray(array);
        playerSelect(array);

    }

    void determineCatValue(String[] array, String catValue){
        for(byte i = 0; i < array.length; i++){
            if(playerSelect == (i + 1)){
                catValue = array[i];
                System.out.println("\n\n" + catValue);

            }
        }
//        playerSelect = 0;
    }
    void gameLoop(){
        for(byte i = 0; i < userOptions.length; i++){
            // An attempt in looping when ever if you select and pick
            // it will loop back to the main menu and loops again
            // up until the user states if he/she is finish creating the character
        }
    }
    void gameState(){
        determineTitle();
        switch(playerSelect){
            case 1:

                dispAndSelect(genderArr);
                determineCatValue(genderArr, catGender);
                displayArray(userOptions);

                break;
            case 2:
                dispAndSelect(eyeColorArr);
                determineCatValue(eyeColorArr, catEyeColor);
                break;
            case 3:
                dispAndSelect(colorArr);
                determineCatValue(colorArr, catColor);
                break;
            case 4:
                dispAndSelect(patternArr);
                determineCatValue(patternArr, catPattern);
                break;
            case 5:
                dispAndSelect(ageArr);
                determineCatValue(ageArr, catAge);
                break;
            case 6:

                break;
            case 0:
                System.out.println("Bye!");

                break;



        }
    }




}
