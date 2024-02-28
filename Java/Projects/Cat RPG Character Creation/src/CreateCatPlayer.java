import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;


class CreateCatPlayer {
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
        this.placeHolder = "none";
        this.userOptions = new String[]{"Gender: None" , "Eye-Colour: None ", "Color: None ","Pattern: None","Age: None", "Name: None"};
        this.catValueList = new ArrayList<String>();
        this.catGender= "";
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
    void setArrayList() {
//        catValueList.addAll(Arrays.asList(userOptions).subList(0, 6));
        for(byte i = 0; i < userOptions.length; i++){
            catValueList.add(i, userOptions[i]);
        }
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
            determineTitle();
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

    void dispAndSelect(String[] array){

        displayArray(array);
        playerSelect(array);
//        determineCatValue();
    }

    void determineCatValue(String[] array){
        for(byte i = 0; i < array.length; i++){
            if(response == (i + 1)){
               catValue = array[i];

            }
        }
        playerSelect = 0;
    }

    void displayArrayList(){
        for(byte i = 0; i < catValueList.size(); i++){
            System.out.println( "\t" + (i+1) + ".  " + catValueList.get(i) + " ");

        }
    }

    void selectArrayList(){
        playerSelect = 0;
        response = 0;
        do {

            try{
                determineTitle();
                System.out.println("\nEnter #" + "1 to " + "#" + catValueList.size() + " to Select, 0 to Cancel\n");
                System.out.print("---------> ::  ");
                response = in.nextByte();
//                System.out.println();
                if(response <= catValueList.size() && response >= 0 ){
                    playerSelect = response;
//                    System.out.println(playerSelect);
                    validInput = true;
                    break;

                }
                else{
                    System.out.println("=============================");
                    System.out.println("Invalid Input!, Try Again!");
                    System.out.println("=============================\n");
                    displayArrayList();
                }
            }
            catch (InputMismatchException e){
                System.out.println("=============================");
                System.out.println("Mismatch Input! Try Again!");
                System.out.println("=============================\n");
                in.nextLine();
                displayArrayList();

            }


        }while(!validInput);


    }

    void createAndAssign(String[] catValue){
        determineTitle();
        displayArray(catValue);
        playerSelect(catValue);
        displayArrayList();
//        dispAndSelect(catOption);
    }

/*    void gameLoop(String[] array, String catValue){
        for(byte i = 0; i < catValueList.size(); i++){
            // An attempt in looping when ever if you select and pick
            // it will loop back to the main menu and loops again
            // up until the user states if he/she is finish creating the character
            dispAndSelArrayList();
            determineCatValue(array, catValue);


        }
    }*/

/*    void dispAndSelArrayList() {
        displayArrayList();
        validInput = false; // Reset validInput
        do {
            selectArrayList();
        } while (!validInput);
    }*/

 /*   void dispAndSelArrayList(){
        displayArrayList();
        selectArrayList();
    }*/


   /* void gameState(){
        determineTitle();
        switch(playerSelect){
            case 1:

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
    }*/




}
