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
        this.userOptions = new String[]{"Gender: None", "Eye-Colour: None", "Color: None" ,
                "Pattern: None", "Age: None" , "Name: None"};
    }

/*    void initArrList(){
        for(byte i = 0; i < userOptions.length; i++){
            catValueList.add(i, userOptions[i]);
        }
    }*/
//    void updateArrList(){
//        for(byte i = 0; i < 6; i++){
//            catValueList.set(i, userOptions[i]);
//        }
//    }
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

                System.out.println("\nEnter #" + "1 to " + "#" + catValueList.size() + " to Select, 0 to Cancel\n");
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
                    System.out.println("=============================\n");
//                    displayArrList();

                }
            } catch (InputMismatchException e) {
                System.out.println("=============================");
                System.out.println("Mismatch Input! Try Again!");
                System.out.println("=============================\n");
                in.nextLine();
//                displayArrList();


            }


        } while (!validInput);


    }


    void determineTitle(){
        String stringBuffer;
        for(byte i = 0; i < userOptions.length; i++){
            if(playerSelect == (i + 1)){
//                stringBuffer = userOptions[i];
                stringBuffer = userOptions[i].replace(": None", "").trim().toUpperCase();
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

                System.out.println("\nEnter #" + "1 to " + "#" + array.length + " to Select, 0 to Cancel\n");
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
                    System.out.println("=============================\n");
                    displayArr(array);
                    selectValue(array);
                }
            } catch (InputMismatchException e) {
                System.out.println("=============================");
                System.out.println("Mismatch Input! Try Again!");
                System.out.println("=============================\n");
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



}


public class CreateCatTwo {
    static Cat catOne = new Cat();
    static Scanner in = new Scanner(System.in);
    static void initArrList(){


        for(byte i = 0; i < catOne.userOptions.length; i++){
            catOne.catValueList.add(i, catOne.userOptions[i]);
        }
    }
    public static void main(String[] args) {

        boolean isValid = false;
        String catValueBuffer = "";
//        boolean hasValue = false;

        System.out.println("\n====================================================================");
        System.out.println("\t\t\t\tRPG Cat Character Creation ver. 2");
        System.out.println("====================================================================\n");

/*        System.out.println("\n====================================================================");
        System.out.println("--------------------------CREATE YOUR CAT---------------------------");
        System.out.println("====================================================================");*/

//        Cat catOne = new Cat();
        // Initialization of the array List;
        initArrList();



        do{
            System.out.println("\n====================================================================");
            System.out.println("--------------------------CREATE YOUR CAT---------------------------");
            System.out.println("====================================================================");
/*            catOne.displayArr(catOne.userOptions);
            catOne.selectValue(catOne.userOptions);*/

            catOne.viewAndSelectArrList();
            System.out.printf("\nMain Method In ---- Player Select: %d \n", catOne.playerSelect);
            System.out.printf("Main Method In ---- Player Response: %d \n", catOne.playerResponse);
            switch(catOne.playerSelect){
                case 1:
                    if(!catOne.catGender.isEmpty()){
                        System.out.println("This option already has a value: " + catOne.catGender);
                        continue;
                    }
                    else{
                        catOne.determineTitle();
                        catOne.displayArr(catOne.genderArr);
                        catOne.selectValue(catOne.genderArr);
                        catOne.determineCatValue(catOne.genderArr);
                        catOne.catGender = catOne.catValue;

                        System.out.printf("\nCat Value: --------------- %s ---------------\n", catOne.catGender);
                        catValueBuffer = catOne.catValueList.get(0).replace("None", "--------- " +  catOne.catGender + " ---------");
                        catOne.catValueList.set(0, catValueBuffer);



//                        catOne.determineCatValueList();
//                        catOne.updateArrList();


                    }
                    break;
                case 2:
                    if(!catOne.catEyeColor.isEmpty  ()){
                        System.out.println("This option already has a value: " + catOne.catEyeColor);
                        continue;
                    }
                    else{
                        catOne.determineTitle();
                        catOne.displayArr(catOne.eyeColorArr);
                        catOne.selectValue(catOne.eyeColorArr);
                        catOne.determineCatValue(catOne.eyeColorArr);
                        catOne.catEyeColor = catOne.catValue;

                        System.out.printf("\nCat Value: --------------- %s ---------------\n", catOne.catEyeColor);
                        catValueBuffer = catOne.catValueList.get(1).replace("None", "--------- " +  catOne.catEyeColor+ " ---------");
                        catOne.catValueList.set(1, catValueBuffer);

//                        catOne.determineCatValueList();

                    }
                    break;
                case 3:
                    if(!catOne.catColor.isEmpty()){
                        System.out.println("This option already has a value: " + catOne.catColor);
                        continue;
                    }
                    else{
                        catOne.determineTitle();
                        catOne.displayArr(catOne.colorArr);
                        catOne.selectValue(catOne.colorArr);
                        catOne.determineCatValue(catOne.colorArr);
                        catOne.catColor = catOne.catValue;
                        System.out.printf("\nCat Value: --------------- %s ---------------\n", catOne.catColor);
                        catValueBuffer = catOne.catValueList.get(2).replace("None", "--------- " +  catOne.catColor+ " ---------");
                        catOne.catValueList.set(2, catValueBuffer);

//                        catOne.determineCatValueList();

                    }
                    break;
                case 4:
                    if(!catOne.catPattern.isEmpty()){
                        System.out.println("This option already has a value: " + catOne.catPattern);
                        continue;
                    }
                    else{
                        catOne.determineTitle();
                        catOne.displayArr(catOne.patternArr);
                        catOne.selectValue(catOne.patternArr);
                        catOne.determineCatValue(catOne.patternArr);
                        catOne.catPattern = catOne.catValue;
                        System.out.printf("\nCat Value: --------------- %s ---------------\n", catOne.catPattern);
                        catValueBuffer = catOne.catValueList.get(3).replace("None", "--------- " +  catOne.catPattern+ " ---------");
                        catOne.catValueList.set(3, catValueBuffer);

//                        catOne.determineCatValueList();

                    }
                    break;
                case 5:
                    if(!catOne.catAge.isEmpty()){
                        System.out.println("This option already has a value: " + catOne.catAge);
                        continue;
                    }
                    else{
                        catOne.determineTitle();
                        catOne.displayArr(catOne.ageArr);
                        catOne.selectValue(catOne.ageArr);
                        catOne.determineCatValue(catOne.ageArr);
                        catOne.catAge = catOne.catValue;
                        System.out.printf("\nCat Value: --------------- %s ---------------\n", catOne.catAge);
                        catValueBuffer = catOne.catValueList.get(4).replace("None", "--------- " +  catOne.catAge   + " ---------");
                        catOne.catValueList.set(4, catValueBuffer);

//                        catOne.determineCatValueList();

                    }
                    break;
                case 6:
                    if(!catOne.catName.isEmpty()){
                        System.out.println("This option already has a value: " + catOne.catName);
                        continue;
                    }
                    else{
                        catOne.determineTitle();
                        System.out.println("Enter Your Desired Name for Your Cat\n");
                        System.out.print("---------> ::  ");
                        catOne.catName = in.nextLine();

                        System.out.printf("\nCat Value: --------------- %s ---------------\n", catOne.catName);
                        catValueBuffer = catOne.catValueList.get(5).replace("None", "--------- " +  catOne.catName+ " ---------");
                        catOne.catValueList.set(5, catValueBuffer);
/*
                        catOne.catEyeColor = catOne.catValue;
                        System.out.println(catOne.catEyeColor);*/


                    }
                    break;

            }




















            /*if(catOne.playerSelect == 1){
                if (!catOne.catGender.isEmpty()) {
                    System.out.println("This option already has a value: " + catOne.catGender);
                    continue; // Skip the current iteration and go back to the beginning of the loop
                }
                else {
                    catOne.displayArr(catOne.genderArr);
                    catOne.selectValue(catOne.genderArr);
                    catOne.determineCatValue(catOne.genderArr);
                    catOne.catGender = catOne.catValue;
                    System.out.println(catOne.catGender);
                }

            } else if (catOne.playerSelect == 2) {

                catOne.displayArr(catOne.eyeColorArr);
                catOne.selectValue(catOne.eyeColorArr);
                catOne.determineCatValue(catOne.eyeColorArr);
                System.out.println(catOne.catValue);


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
            }*/
        }while(!isValid);




    }
}
