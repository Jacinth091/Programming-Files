import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

class Cat {

    Scanner in;
    ArrayList<String> catValueList = new ArrayList<String>();
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
    String buffer;
    byte playerSelect, playerResponse;
    boolean validInput;



    Cat() {
        this.in = new Scanner(System.in);
        this.genderArr = new String[]{"Male", "Female"};
        this.colorArr = new String[]{"Orange", "Black", "White", "Brown", "Red"};
        this.patternArr = new String[]{"Solid", "Tabby", "Tortoise", "Color-point", "Bi-colour", "Tricolour (Calico)",};
        this.ageArr = new String[]{"Teen", "Mid-teen", "Adult", "Mid-adult", "Old"};
        this.eyeColorArr = new String[]{"Hazel", "Brown", "Gold", "Green", "Blue"};
//        this.placeHolder = "None";
        this.catGender = "";
        this.catColor = "";
        this.catAge = "";
        this.catName = "";
        this.catPattern = "";
        this.catEyeColor = "";
        this.buffer = "";
        this.catValue="";
        this.userOptions = new String[]{"Gender: ", "Eye-Colour: ", "Color: " ,
                "Pattern: ", "Age: " , "Name: "};
    }

    void displayArrList(){
        System.out.println();
        for (byte i = 0; i < catValueList.size(); i++) {
            System.out.println("\t" + (i + 1) + ".  " + catValueList.get(i) + " ");
        }
    }
    void viewAndSelectArrList(){
        playerSelect = 0;
        playerResponse = 0;

        do {
            displayArrList();
            try {

                System.out.println("\nEnter #" + "1 to " + "#" + catValueList.size() + " to Select, 0 to EXIT\n");
                System.out.print("---------> ::  ");
                playerResponse = in.nextByte();
//                System.out.println();
                if (playerResponse <= catValueList.size() && playerResponse >= 0) {
                    playerSelect = playerResponse;

                    validInput = true;

                    break;

                } else {
                    System.out.println("=============================");
                    System.out.println("Invalid Input!, Try Again!");
                    System.out.println("=============================");
                    viewAndSelectArrList();

                }
            } catch (InputMismatchException e) {
                System.out.println("=============================");
                System.out.println("Mismatch Input! Try Again!");
                System.out.println("=============================");
                in.nextLine();
                viewAndSelectArrList();


            }


        } while (!validInput);

    }


    void determineTitle(){
        String stringBuffer;
        for(byte i = 0; i < userOptions.length; i++){
            if(playerSelect == (i + 1)){
//                stringBuffer = userOptions[i];
                stringBuffer = userOptions[i].replace(": ", "").trim().toUpperCase();
                System.out.println("\n====================================================================");
                System.out.println("--------------------------" + stringBuffer + "---------------------------");
                System.out.println("====================================================================");
            }
        }
//        playerSelect = 0;
    }


    void displayArr(String[] array) {
        System.out.println();
        for (byte i = 0; i < array.length; i++) {
            System.out.println("\t" + (i + 1) + ".  " + array[i] + " ");
        }
    }

    void selectValue(String[] array) {
        System.out.printf("\nSelect Value() In ---- Player Select: %d \n", playerSelect);
        System.out.printf("Select Value() In ---- Player Response: %d \n", playerResponse);
        playerSelect = 0;
        playerResponse = 0;
        do {

            try {

                System.out.println("\nEnter #" + "1 to " + "#" + array.length + " to Select, 0 to EXIT\n");
                System.out.print("---------> ::  ");
                playerResponse = in.nextByte();

//                System.out.println();
                if (playerResponse <= array.length && playerResponse >= 0) {
                    System.out.printf("\nSelect Value() Between ---- Player Select: %d \n", playerSelect);
                    System.out.printf("Select Value() Between ---- Player Response: %d \n", playerResponse);
                    playerSelect = playerResponse;
//                    System.out.println(playerSelect);
                    validInput = true;

                    break;

                } else {
                    System.out.println("=============================");
                    System.out.println("Invalid Input!, Try Again!");
                    System.out.println("=============================");
                    displayArr(array);
                    selectValue(array);
                }
            } catch (InputMismatchException e) {
                System.out.println("=============================");
                System.out.println("Mismatch Input! Try Again!");
                System.out.println("=============================");
                in.nextLine();
                displayArr(array);
                selectValue(array);


            }


        } while (!validInput);
        System.out.printf("\nSelect Value() Out ---- Player Select: %d \n", playerSelect);
        System.out.printf("Select Value() Out ---- Player Response: %d \n", playerResponse);
    }

    void determineCatValue(String[] array){

        for(byte i = 0; i < array.length; i++){

            if(playerSelect   == (i+1)){
                System.out.printf("\nDetermineCatValue() In ---- Player Select: %d \n", playerSelect);
                System.out.printf("DetermineCatValue() In ---- Player Response: %d \n", playerResponse);
                catValue = array[i];
                break;
            }

        }
//        playerSelect = 0;
        playerResponse = 0;

        System.out.printf("\nDetermineCatValue() Out ---- Player Select: %d \n", playerSelect);
        System.out.printf("DetermineCatValue() Out ---- Player Response: %d \n", playerResponse);

    }

    void updateCatValueList(int index, String catValue){
        String catValueBuffer = String.format("-------- %s --------", catValue);

        catValueList.set(index, userOptions[index] + catValueBuffer);
    }


}


public class CreateCatTwo {
    static Cat catOne = new Cat();
    static Scanner in = new Scanner(System.in);

    static byte indexOfAttributes = 0;
    static boolean isValid = false;
    static boolean toQuit = false;
    static char choice = '0';
    static void initArrList(){


        for(byte i = 0; i < catOne.userOptions.length; i++){
            catOne.catValueList.add(i, catOne.userOptions[i] + "None");
        }
    }
    public static void main(String[] args) {


        System.out.println("\n====================================================================");
        System.out.println("\t\t\t\tRPG Cat Character Creation ver. 2");
        System.out.println("====================================================================\n");

        // Initialization of the array List;
        initArrList();
        gameLoop();

        System.out.println("Helloooowww");

    }
    static String catAttributes(String[] catAttArray){
        catOne.determineTitle();
        catOne.displayArr(catAttArray);
        catOne.selectValue(catAttArray);
        catOne.determineCatValue(catAttArray);
        String catOneValue = catOne.catValue;

        System.out.printf("\nCat Value: --------------- %s ---------------\n", catOneValue);


        return catOneValue;
    }
    static String editCatAttribute(String catAttribute,String[] catAttrArray, int index){
        if(!catAttribute.isEmpty()){
            System.out.printf("This has a current value of ------ %s ------, would you like to change it? (Yes / No)\n", catAttribute);
            do{
                System.out.print("Change it (Y/N)? \n");
                System.out.print("---------> ::  ");
                choice = in.next().charAt(0);
                in.nextLine();
                choice = Character.toUpperCase(choice);
                if(choice == 'Y'){
                    catAttribute = catAttributes(catAttrArray);
                    catOne.updateCatValueList(index, catAttribute);
//                    indexOfAttributes++;
                    System.out.printf("Cat Gender New Value: %s\n", catAttribute);
                    System.out.printf("Cat Value List at Index %d New Value: %s\n", index ,catOne.catValueList.get(index));

                    break;
                }
                else if(choice == 'N'){
                    toQuit = true;
                }
                else{
                    System.out.println("Invalid Input, Try Again!");
                }

            }while(!toQuit);

        }
        else{
            catAttribute = catAttributes(catAttrArray);
            catOne.updateCatValueList(index, catAttribute);
            indexOfAttributes++;

        }
        return catAttribute;
    }
    static void gameLoop() {
//        int userChoice;
        while (!isValid) {

            if(indexOfAttributes == 6){
                System.out.println("\n====================================================================");
                System.out.println("--------------------------YOUR CAT---------------------------");
                System.out.println("====================================================================");
                catOne.displayArrList();

                System.out.println("\nDo you want to save?");


                do{
                    System.out.println("(Y = yes, N = No)");
                    System.out.print("---------> ::  ");
                    choice = in.next().charAt(0);
                    choice = Character.toUpperCase(choice);
                    in.nextLine();

                    if(choice == 'Y'){
                        System.out.println("SAVING........");
                        isValid = true;
                        break;
                    }
                     else if (choice == 'N') {

                        break;
                    }
                     else {
                        System.out.print("Invalid Input, try again! \n");
                     }
                }while(!toQuit);


            }else{
                System.out.println("\n====================================================================");
                System.out.println("--------------------------CREATE YOUR CAT---------------------------");
                System.out.println("====================================================================");
                System.out.printf("Index of Attributes: %s\n", indexOfAttributes);
                catOne.viewAndSelectArrList();
                System.out.printf("\nMain Method In ---- Player Select: %d \n", catOne.playerSelect);
                System.out.printf("Main Method In ---- Player Response: %d \n", catOne.playerResponse);

                switch (catOne.playerSelect) {
                    case 1:
                        catOne.catGender = editCatAttribute(catOne.catGender, catOne.genderArr, 0);
                        break;
                    case 2:
                        catOne.catEyeColor = editCatAttribute(catOne.catEyeColor, catOne.eyeColorArr, 1);
                    break;
                    case 3:
                        catOne.catColor = editCatAttribute(catOne.catColor, catOne.colorArr, 2);
                        break;
                    case 4:
                        catOne.catPattern = editCatAttribute(catOne.catPattern, catOne.patternArr, 3);
                        break;
                    case 5:
                        catOne.catAge = editCatAttribute(catOne.catAge, catOne.ageArr, 4);
                        break;
                    case 6:
                        if(!catOne.catName.isEmpty()){
                            System.out.printf("This has a current value of ------ %s ------, would you like to change it? (Yes / No)\n", catOne.catName);
                            do{
                                System.out.print("Change it (Y/N)? \n");
                                System.out.print("---------> ::  ");
                                choice = in.next().charAt(0);
                                choice = Character.toUpperCase(choice);
                                        in.nextLine();
                                if(choice == 'Y'){
                                    catOne.determineTitle();
                                    System.out.println("Enter Your Desired Name for Your Cat\n");
                                    System.out.print("---------> ::  ");
                                    catOne.catName = in.nextLine();
                                    catOne.updateCatValueList(5, catOne.catName);
//                                    indexOfAttributes++;

                                    System.out.printf("Cat Gender New Value: %s\n", catOne.catName);
                                    System.out.printf("Cat Value List at Index %d New Value: %s\n", 5,catOne.catValueList.get(5));

                                    break;
                                }
                                else if(choice == 'N'){
                                    toQuit = true;
                                }
                                else{
                                    System.out.println("Invalid Input, Try Again!");
                                }

                            }while(!toQuit);
                        }
                        else{
                            catOne.determineTitle();
                            System.out.println("Enter Your Desired Name for Your Cat\n");
                            System.out.print("---------> ::  ");
                            catOne.catName = in.nextLine();

                            System.out.printf("\nCat Value: --------------- %s ---------------\n", catOne.catName);
                            catOne.updateCatValueList(5, catOne.catName);
                            indexOfAttributes++;

                        }
                        break;

                    case 0:
                        do {
                            System.out.print("Are you sure you want to exit? (Y / N): \n");
                            System.out.print("---------> ::  ");
                            choice = in.next().charAt(0);
                            choice = Character.toUpperCase(choice);
                            in.nextLine();
                            System.out.printf("Choice %c\n", choice);

                            if (choice == 'Y') {
                                System.out.printf("Choice in Y == %c\n", choice);
                                System.out.print("GoodBye!!!\n");
                                isValid = true;
                                System.exit(0);
//                                break;
                            } else if (choice == 'N') {
                                System.out.printf("Choice in N == %c\n", choice);
                                indexOfAttributes = (byte)Math.max(0, indexOfAttributes - 1);
                                toQuit = true;
                                break; // Exit the loop and return to the main loop
                            } else {
                                System.out.printf("Choice if not N and not Y == %c\n", choice);
                                System.out.print("Invalid Input, try again! \n");
                            }
                        } while (!toQuit);
                    break;
                }
            }
        }
    }


}
