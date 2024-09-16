/*
 * Name: Jacinth Cedric C. Barral
 * Date: Sept 16, 2024
 * Description: Lab.Act.#03 - Working with 2D Arrays - The objective of this activity is to
 *                              reinforce understanding of 2D arrays in Java and practice basic array traversal
 *                              and searching algorithms. By completing this activity,
 *                              students will gain proficiency in iterating over 2D arrays, accessing elements,
 *                              and identifying the maximum element along with its position in the array.
 * */

import java.util.Random;
import java.util.Scanner;
class ActThreeOOP {
    final static int numOfDishes = 3;
    final static int numOfCateg = 4;
    final static int numOfAttrib = 3;
    static Random rand = new Random();
    static int[] randomIndex;
    static String[][] perDishDescription;
    static DishAttributes dishAttributes = new DishAttributes();
    // Dish Attribute Class = contains the attributes for the dishes
    // The max scores, the location of row and col, the category names, and the dish's names
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        // a 3x4 array for dish Scores
        int[][] dishesScores = new int[numOfDishes][numOfCateg];
        perDishDescription = new String[numOfDishes][numOfCateg];



        int[][] perDishAtt = new int[numOfDishes][numOfAttrib];
        // per Dish Att is the per Dish Attributes
        // the Attiributes given by the user per dish,
        // example, the max given score PER DISH, the location of the max score PER DISH
        // 3 column for = row, col, maxNum
        
        int[] overAllAttrib = new int[numOfAttrib];
        // overAllAttrib is the array of the overall attributes out of all the dishes
        // The maximum score given out of al dishes, and the row and column location
        String[][] listOfAttributes;
        // Initializing the initial Random Index for the randomized dish names
        String exitKey = "Exit Program";
        String[] menuOptions = {
                "User Input (Input the values yourself).",
                "Automatic Input (Randomize Input Data).",
                "Test Data (Hard Coded Data).",
                exitKey,
        };
        String[][] dialogs;
        String[] dishNames, categNames, maxRowCol ;



        listOfAttributes = dishAttributes.getListOfAttributes(); // Initialize Value from dish Attributes class
        dialogs = dishAttributes.getDishDescription(); // Initialize Value from dish Attributes class
        dishNames = listOfAttributes[0]; // Initialize Value from dish Attributes class
        categNames = listOfAttributes[1]; // Initialize Value from dish Attributes class
        maxRowCol = listOfAttributes[2]; // Initialize Value from dish Attributes class

        displayHeader();
        // Handles all the logic and all other methods
        mainLogicMethod(in, dishesScores, perDishAtt, overAllAttrib, dialogs, menuOptions, dishNames,
                categNames, maxRowCol, exitKey);

        System.out.println("Thank you for using the program, see you again! :D");

        in.close();

    }

    // **************************************** Main Logic ****************************************
    public static void mainLogicMethod(Scanner in, int[][] dishesScores, int[][] perDishAtt, int[] overAllAttrib,
                                       String[][] dialogs, String[] menuOptions, String[] dishNames,
                                       String[] categNames, String[] maxRowCol, String exitKey){

        boolean exitLoop = false;

        do{
            dispTitle();
            // Re-initialize the array size of the Dish Scores
            initArray(dishesScores);

            // initialize perDishDesc String array
            initDialogs(dialogs);

            // initialize array of random index for option 2
            randomIndex = getRandomIndex(dishNames.length, 1, numOfAttrib);


            System.out.printf("\nEnter # (1 - %d) to continue, 0 to EXIT. \n", (menuOptions.length -1));
            displayOptions(menuOptions, exitKey);
            System.out.println();

            System.out.print("-->: ");
            int choice = checkValidIn(in, "-->");
            if(!isInputvalid(in, menuOptions.length, choice)){
                continue;
            }

            // Switch Controller for Events
            dishesScores = eventController(in, dishesScores, dishNames, categNames, choice);

            System.out.println("Current active: " + menuOptions[choice-1]);
            System.out.print("*****************************************************************************************\n");

            System.out.printf("%-28s  %s\n\n", " ", "The Table of Truth");
            dispResults(dishesScores, dishNames, categNames);
            // initialize dishAttributes with values with already populated dishScores array


            dishAttributes = setAttributes(dishesScores);

            // Get the overall values ( max num, row Loc, and col Loc)
            overAllAttrib = dishAttributes.getOverAllAttrib();
            // Get the values per dish ( max num, row Loc, and col Loc)
            perDishAtt = dishAttributes.getPerDishAttrib();


            dispAttribValue(overAllAttrib, perDishAtt, dishNames, maxRowCol);
            System.out.print("*****************************************************************************************\n");


            String msg = "'Y' to restart, 'N' to exit the program.";
            exitLoop = askYesOrNo(in,msg );


        }while(!exitLoop);
    }


    // **************************************** Logic ****************************************
    public static boolean isInputvalid(Scanner in, int menuSize, int choice){
        if( choice > menuSize || choice < 0){
            in.nextLine();
            System.out.println("Index number is not within the given options, try again!\n");
            System.out.print("Press ENTER key to continue...");
            in.nextLine();
            return false;
        }
        return true;
    }
    public static int checkValidIn(Scanner in, String alertMsg) {
        while (!in.hasNextInt()) {
            System.out.println("\nInput only integers Chef, try again.");
            System.out.printf("%s: ", alertMsg);
            in.next();
        }
        return in.nextInt();
    }
    public static int[][] getRandomNum(int[][] dishesScores){
        int max = 100, min =1;
        for(int i =0 ; i < numOfDishes; i++){
            for(int j =0; j < numOfCateg; j++){
                dishesScores[i][j] = rand.nextInt(((max - min) + 1));
            }
        }
        return dishesScores;
    }


    // **************************************** Get and Set ****************************************
    public static int[] getRandomIndex(int max, int min, int size){
        int[] randTemp = new int[size];
        int[] tempBuffer = new int[size * 3]; // size * 3 to ensure that a lot of unique integers can be picked
        for(int i =0; i< tempBuffer.length; i++){
            tempBuffer[i] = rand.nextInt((max - min) +1);
        }
        for(int i =0; i < size; i++){
            int randInd;
            boolean isUnique;
            do{
                randInd = rand.nextInt(tempBuffer.length);
                isUnique = true;
                for(int j =0; j < i ; j++){
                    if(randTemp[j] == tempBuffer[randInd]){
                        isUnique = false;
                        break;
                    }
                }
            }while(!isUnique);
            randTemp[i] = tempBuffer[randInd];
//            System.out.println(randTemp[i]);
        }


        return randTemp;
    }
    public static DishAttributes setAttributes(int[][] dishScores){
        int maxScore = 0,
                LRow =0,
                LCol =0;
        int[] overAll = new int[numOfAttrib];
        int[][] perDish = new int[numOfDishes][numOfAttrib];

        for(int i =0; i< numOfDishes; i++){

            maxScore = 0;
            for(int j =0; j < numOfCateg; j++){
                if(maxScore < dishScores[i][j]){ // checks if the current iteration of the array[][] is less than 0
                    maxScore = dishScores[i][j]; // assigns the max value to the new value
                    LRow = (i+1); // fetch the current ROW data and assigns it into lRow variable
                    LCol = (j+1); // fetch the current COL data and assigns it into lCol variable
                }
            }
            perDish[i][0] = LRow;
            perDish[i][1] = LCol;
            perDish[i][perDish[i].length -1] = maxScore;
        }

        maxScore = 0;
        for (int i = 0; i < numOfDishes; i++) {
            for (int j = 0; j < numOfCateg; j++) {
                if (maxScore < dishScores[i][j]) {
                    maxScore = dishScores[i][j];
                    LRow = i + 1;
                    LCol = j + 1;
                }
            }
        }
        overAll[0] = LRow;
        overAll[1] = LCol;
        overAll[overAll.length - 1] = maxScore;


        return new DishAttributes(overAll, perDish);


    }


    // **************************************** Events ****************************************

    public static int[][] eventController(Scanner in, int[][] dishesScores,
                                       String[] dishNames, String[] categNames ,int choice){
//        int[][] tempArr = new int[numOfDishes][numOfCateg];
        switch(choice){
            case 1:
                System.out.print("\n***************************************************************\n");
                System.out.println("Instructions: You are the Main Chef/Judge,\n" +
                        "You now have the power to judge the dishes presented to you.\n");
                System.out.println("Rate every dish to your liking, but only within (1-100)!");
                System.out.print("***************************************************************\n");

                dishesScores = askForInput(in, dishNames, categNames);
                break;
            case 2:
                dishesScores = getRandomNum(dishesScores);
//                dispResults(tempArr,dishNames, categNames);
                break;
            case 3:
                dishesScores = initHardCode(dishesScores);
//                dispResults(tempArr,dishNames, categNames);
                break;
            case 0:
                System.out.println("\nThank you for using the program, come again :D!\n");
                System.exit(0);
                break;
        }
        return  dishesScores;
    }

    // **************************************** Initialize ****************************************
    public static void initDialogs(String[][] dialogs){
        int[] tempRand = new int[dialogs[0].length];

        // Loop through each dish
        for (int i = 0; i < numOfDishes; i++) {
            // Loop through each category (taste, texture, creativity, presentation)
            for (int j = 0; j < numOfCateg; j++) {
                tempRand[j] = rand.nextInt(dialogs[j].length); // Generate random index for each category from dialogs
                perDishDescription[i][j] = dialogs[j][tempRand[j]]; // Store the selected value in the new array
            }
        }

    }
    public static void initArray(int[][] dishesScores){
        for (int i = 0; i < dishesScores.length; i++) {
            for (int j = 0; j < dishesScores[i].length; j++) {
                dishesScores[i][j] = 0; // Set default value or some initialization logic
            }
        }
    }

    public static int[][] initHardCode(int[][] dishesScores){
//        int[][] dishesScores = new int[3][4];
        // Hard coded Data  I don't know if this is required
        dishesScores[0][0] = 91;
        dishesScores[0][1] = 74;
        dishesScores[0][2] = 90;
        dishesScores[0][3] = 100;

        dishesScores[1][0] = 89;
        dishesScores[1][1] = 56;
        dishesScores[1][2] = 20;
        dishesScores[1][3] = 10;


        dishesScores[2][0] = 17;
        dishesScores[2][1] = 13;
        dishesScores[2][2] = 98;
        dishesScores[2][3] = 20;

        return  dishesScores;
//        return dishesScores;
    }

    // **************************************** User Input ****************************************
    public static int[][] askForInput(Scanner in, String[] dishName, String[] categNames){
        // Max dishes value is a static
        // Max categories value is a static
        int maxInput = 100, minInput =1;
        int[][] tempArr = new int[numOfDishes][numOfCateg];


        for(int i =0; i < numOfDishes; i++){
            int inp =0;
//            System.out.println("Dish number " + (i+1) + " ");
            System.out.printf("******************************* Dish #%-1d *******************************\n", (i+1));
            System.out.printf("\nCurrent Dish -> %10s \n", dishName[randomIndex[i]]);

            for(int j = 0; j < numOfCateg; j++){
                if(j != 0){
                    System.out.printf("\nCurrent Dish -> %10s \n", dishName[randomIndex[i]]);

                }
                System.out.print("\n---------------------------------------------------------------\n");
                System.out.printf("%-10s  %s\n", " ", perDishDescription[i][j]);
                System.out.print("---------------------------------------------------------------\n");

                System.out.printf("Rate in terms of %s: ", categNames[j]);
                inp = checkValidIn(in,"\nRate in terms of " + categNames[j]);
                System.out.print("***************************************************************\n");

                if(inp >= minInput && inp <= maxInput){
                    tempArr[i][j] = inp;
                }
                else{
                    j--;
                    System.out.println("\nNot the score we were expecting chef, let's try again.");
                    System.out.println("\nOnly 1-100!");
                }
            }
            System.out.println();
        }
        return tempArr;
    }
    public static boolean askYesOrNo(Scanner in, String msg){
        boolean value;
        do{
            System.out.printf("%s.\n", msg);
            System.out.print("Your choice: ");
            char input = in.next().toUpperCase().charAt(0);

            if(input == 'Y' || input == 'N'){
                value = input == 'N';
                break;
            }
            else{
                System.out.println("\n-------------------------------------------------------\n");
                System.out.println("Invalid input! Please enter 'Y' or 'N'.");
                System.out.println("\n-------------------------------------------------------");
            }


        }while(true);


        return value;

    }

    // **************************************** Display ****************************************

    public static void dispAttribValue(int[] overAllAttrib, int[][] perDishAtt,
                                       String[] dishNames, String[] attribNames){
//     Getting and setting the overAllAttrib array from DishAttributes Class
        System.out.println("Overall:");
        System.out.printf("Overall Dish's Max Score: %d\n", overAllAttrib[overAllAttrib.length-1]);
        System.out.printf("Row Location: %d\n", overAllAttrib[0]);
        System.out.printf("Column Location: %d\n", overAllAttrib[1]);

        // Getting and setting the perDishAttrib array from DishAttributes Class
        System.out.print("*****************************************************************************************\n");
        System.out.printf("%-20s  %s\n\n", " ", "Per Dish's MAX Scores and row and col Location");
        dispResults(perDishAtt, dishNames, attribNames);
    }

    public static void displayOptions(String[] array, String exitKey){
        int arrayLength = array.length;
        for(int i = 0; i<arrayLength; i++) {
            if(array[i].equals(exitKey)){ // checks if the current iteration of the menu is "Exit" String
                System.out.println();
                System.out.printf("%-1d. %s\n", (arrayLength - i) - 1, array[i]); // it will display 0, an indication to exit
            }
            else{// if the current iteration of the menu is not "Exit" String
                System.out.printf("%-1d. %s\n", (i+1), array[i]);
            }
        }
    }

    public static void dispResults(int[][] dishScores, String[] dishNames, String[] categName) {
        int columnPerCateg = 0;
        int dishNameLen = 0;
        int categNameLen = 0;

        // Calculating the maximum length of the categories to apply padding
        for (String name : dishNames) {
            if (name.length() > dishNameLen) {
                dishNameLen = name.length();
            }
        }
        // Calculating the maximum length of the categories to apply padding
        for (String category : categName) {
            if (category.length() > categNameLen) {
                categNameLen = category.length();
            }
        }

        // Spaces for each of the categories
        columnPerCateg = categNameLen + 3;

        // Print the category headers
        System.out.print(paddingToRight("Dishes", dishNameLen + 2)); // Adjust spacing for dish names
        for(String columnTitle : categName){
            System.out.printf("%-" + columnPerCateg + "s", columnTitle);
        }

        System.out.println("\n");


        // Print the dishes and their scores
        for (int i = 0; i < numOfDishes; i++) {

            // To randomize the Names of the dishes

            // Print the dish's individual names
            System.out.printf("%-" + (dishNameLen + 2) + "s", dishNames[randomIndex[i]]); // Adjust length for dish names

            // Print the scores of the individual dishes
            for (int scores : dishScores[i]) {
                System.out.printf(" %-" + columnPerCateg + "d", scores); // Adjust column width
            }
            System.out.println("\n");
        }
    }

    public static String paddingToRight(String origStr, int length) {
        // If the length of the original string is in the desired length
        // Don't append spaces and return the string
        if (origStr.length() >= length) {
            return origStr;
        }

        // Append spaces to the string to ensure the right length is reached
        StringBuilder newStr = new StringBuilder(length);
        newStr.append(origStr);

        while (newStr.length() < length) {
            newStr.append(' ');
        }
        return newStr.toString();
    }

    public static void displayHeader(){
        System.out.print("\n\t**********************************************************************************\n");
        System.out.printf("%-32s  %s\n", " ", "Working with 2D Arrays ");
        System.out.printf("%-31s  %s\n", " ", "Barral, Jacinth Cedric C.");
        System.out.printf("%-35s  %s\n", " ", "Lab - Activity 3");
        System.out.print("\t**********************************************************************************\n");



    }

    public static void dispTitle(){

        System.out.println("\n");
        System.out.printf("%s", "*****************************");
        System.out.printf("%-5s  %s", " ", " Heaven's Kitchen ");
        System.out.printf("%-5s  %s", " ", "*****************************\n");
    }


}
class DishAttributes{

    private int[] overAllAttrib;
    private int[][] perDishAttrib;

    private String[][] listOfAttributes =
            {
                    {
                            "Spaghetti Carbonara", "Chicken Parmesan", "Beef Wellington", "Sushi Roll",
                            "Pad Thai", "Tacos al Pastor", "Margherita Pizza", "Butter Chicken",
                            "Lobster Thermidor", "Biryani", "Pho", "Lasagna", "Moussaka",
                            "Paella", "Ratatouille", "Fish and Chips", "Ramen", "Fried Chicken",
                            "Eggplant Parmesan", "Shrimp Scampi", "Coq au Vin", "Pulled Pork Sandwich",
                            "Fettuccine Alfredo", "Chicken Tikka Masala", "Vegetable Stir Fry"
                    },
                    {
                            "Taste", "Texture", "Creativity", "Presentation"
                    },
                    {
                            "Row", "Column", "Max Score"
                    },
            };

    private String[][] dishDescription =
            {
                    // Taste
                    {"You tasted the dish, and it tasted Exquisite.\nYou were delighted!",
                            "You tasted the dish, and it tasted Delicious.\nYou feel Enjoyment!",
                            "You tasted the dish, and it tasted Average.\nYou feel Content.",
                            "You tasted the dish, and it tasted Bland.\nYou feel Disappointed."},

                    // Texture
                    {"The texture of the dish is Smooth.\nYou feel Satisfied.",
                            "The texture of the dish is Tender.\nYou feel Comfortable.",
                            "The texture of the dish is Chewy.\nYou feel Unsure.",
                            "The texture of the dish is Grainy.\nYou feel Unsettled."},

                    // Creativity
                    {"The creativity is Innovative.\nYou feel Amazed!",
                            "The creativity is Impressive.\nYou feel Excited!",
                            "The creativity is Standard.\nYou feel Neutral.",
                            "The creativity is Unimaginative.\nYou feel Underwhelmed."},

                    // Presentation
                    {"The presentation is Elegant.\nYou feel Impressed!",
                            "The presentation is Neat.\nYou feel Satisfied.",
                            "The presentation is Plain.\nYou feel Indifferent.",
                            "The presentation is Messy.\nYou feel Frustrated."}
            };


    public DishAttributes(int[] overAllAttrib, int[][] perDishAttrib){
        setOverAllAttrib(overAllAttrib);
        setPerDishAttrib(perDishAttrib);
    }

    public DishAttributes(){

    }
    
    public void setOverAllAttrib(int[] overAllAttrib){
        this.overAllAttrib = overAllAttrib;
    }

    public int[] getOverAllAttrib(){
        return overAllAttrib;
    }

    public void setPerDishAttrib(int[][] perDishAttrib){
        this.perDishAttrib = perDishAttrib;
    }

    public int[][] getPerDishAttrib(){
        return perDishAttrib;
    }

    public String[][] getListOfAttributes(){
        return listOfAttributes;
    }

    public String[][] getDishDescription(){
        return dishDescription;
    }

}
