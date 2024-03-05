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
    int playerSelect, playerResponse;
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
        for (byte i = 0; i < catValueList.size(); i++) {
            System.out.println("\n\t" + (i + 1) + ".  " + catValueList.get(i) + " ");
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
                playerResponse = in.nextInt();
//                System.out.println();
                if (playerResponse <= catValueList.size() && playerResponse >= 0) {
                    playerSelect = playerResponse;
//                    System.out.println(playerSelect);
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

    void determineCatValueList(String catValue){

        System.out.printf("\nPlayer SElect Value: %d\n", playerSelect);
        System.out.printf("\nPlayer Response Value: %d\n", playerResponse);


/*        int index = playerSelect - 1;

        if (index >= 0 && index < catValueList.size()) {
            buffer = catValueList.get(index).replace("None", catValue);
            System.out.printf("\nBuffer: %s\n", buffer);
            System.out.printf("\nCatValueList before: %s\n", catValueList.get(index));
            catValueList.set(index, buffer);
            System.out.printf("\nCatValueList after: %s\n", catValueList.get(index));

            buffer = "";
        } else {
            System.out.println("Invalid index, update failed");
        }*/

        for(byte i = 0; i< catValueList.size(); i++){
            if(playerResponse == i){
                buffer = catValueList.get(i).replace("None", catValue);
                System.out.printf("\n Buffer: %s\n", buffer);
                System.out.printf("\nCatValueList before: %s\n", catValueList.get(i));
                catValueList.set(i, buffer);
                System.out.printf("\nCatValueList after: %s\n", catValueList.get(i));
                break;
            }
            else{
                System.out.println("Balikaaaaa");
                break;
            }
        }




/*        for(byte i = 0; i < catValueList.size(); i++){
            System.out.printf("\nPlayerSelect: %d", playerSelect);
            if(playerSelect  == i+1 ){
                buffer = catValueList.get(i).replace("None", catValue);
                System.out.println(buffer + " buffer?");
                System.out.printf("\nList Array %d: %s\n",i+1, catValueList.get(i));
                catValueList.set(i, buffer);
                System.out.printf("CAtValueListArrList: %s", catValueList.get(i));


                break;
            }
            else{
                System.out.println("IDIIIOOOOOTTT!!!");
                break;
            }

        }
        buffer = " none";
        System.out.printf("buffer:?? %s", buffer);*/
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
                playerResponse = in.nextInt();
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
//        playerSelect = 0;
//        playerResponse = 0;
    }

}


public class CreateCatTwo {
    static Cat catOne = new Cat();
    static void initArrList(){


        for(byte i = 0; i < catOne.userOptions.length; i++){
            catOne.catValueList.add(i, catOne.userOptions[i]);
        }
    }
    public static void main(String[] args) {

        boolean isValid = false;
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

                        System.out.println(catOne.catGender + "Catvvalue");

                        catOne.determineCatValueList(catOne.catGender);
//                        catOne.updateArrList();


                    }
                    break;
                case 2:
                    if(!catOne.catEyeColor.isEmpty()){
                        System.out.println("This option already has a value: " + catOne.catEyeColor);
                        continue;
                    }
                    else{
                        catOne.determineTitle();
                        catOne.displayArr(catOne.eyeColorArr);
                        catOne.selectValue(catOne.eyeColorArr);
                        catOne.determineCatValue(catOne.eyeColorArr);
                        catOne.catEyeColor = catOne.catValue;

                        System.out.println(catOne.catEyeColor + "CAtValue");
                        catOne.determineCatValueList(catOne.catEyeColor);

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
                        System.out.println(catOne.catColor);
                        catOne.determineCatValueList(catOne.catColor);

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
                        System.out.println(catOne.catPattern);
                        catOne.determineCatValueList(catOne.catPattern);

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
                        System.out.println(catOne.catAge);
                        catOne.determineCatValueList(catOne.catAge);

                    }
                    break;
/*                case 6:
                    if(!catOne.catGender.isEmpty()){
                        System.out.println("This option already has a value: " + catOne.catEyeColor);
                        continue;
                    }
                    else{
                        catOne.determineTitle();
                        catOne.displayArr(catOne.eyeColorArr);
                        catOne.selectValue(catOne.eyeColorArr);
                        catOne.determineCatValue(catOne.eyeColorArr);
                        catOne.catEyeColor = catOne.catValue;
                        System.out.println(catOne.catEyeColor);
                        catOne.determineCatValueList(catOne.catEyeColor);

                    }
                    break;*/

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
