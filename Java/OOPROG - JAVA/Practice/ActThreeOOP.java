/*
 * Name: Jacinth Cedric C. Barral
 * Date: Sept 14, 2024
 * Description: Lab.Act.#03 - Working with 2D Arrays - The objective of this activity is to
 *                              reinforce understanding of 2D arrays in Java and practice basic array traversal
 *                              and searching algorithms. By completing this activity,
 *                              students will gain proficiency in iterating over 2D arrays, accessing elements,
 *                              and identifying the maximum element along with its position in the array.
 * */



// 2d Array with 3 x 4 dimensions

// Populate with 1 -100 (random) or user input

// Find Maximum element (out of all arrays or in a single array, x3 maximum)

// Print the row's and col's of the maximum element

// Print the 3x4 arrays with the corresponding row and columns, much like a table

// MUST HANDLE USER INPUT CORRECTLY
// ARRAY ELEMENTS DATA TYPE (integer or floating point?)
// IF USER IN, VALUE SHOULD BE IN A RANGE ( 1-100 OR 70 - 100)

// Colored Text??
//        System.out.printf("\n\033[1;36mElements of the array:\033[0m");


// The program is about the user being a chef, and he/she has to judge the
// dish based on the 4 categories
// 4 categories for the dish is
// Taste
// Presentation
// Texture
// Creativity

// The dishes are pre-written and stored in String array
// The dishes should be randomized every loop so that it has a unique taste
// Every dish has its own description, so that the user properly visualize and rate the dish
// Every dish, user can take back the rating and start again from the very beginning



import java.util.Random;
import java.util.Scanner;
class ActThreeOOP {
    final static int numOfDishes = 3;
    final static int numOfCateg = 4;
    final static int numOfAttrib = 3;

    static Random rand = new Random();
    static int[] randomIndex;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        // a 3x4 array for dish Scores
        int[][] dishesScores = new int[numOfDishes][numOfCateg];

        // Dish Attribute Class = contains the attributes for the dishes
        // The max scores, the location of row and col, the category names, and the dish's names
        DishAttributes dishAttributes;

        int[][] perDishAtt ;
        // per Dish Att is the per Dish Attributes
        // the Attiributes given by the user per dish,
        // example, the max given score PER DISH, the location of the max score PER DISH
        // 3 column for = row, col, maxNum
        
        int[] overAllAttrib;
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

        boolean exitLoop = false;


        displayHeader();

        // Setting Random Integer Elements
//        dishesScores = randArrElem(dishesScores);


        // Setting of Attributes
        // Must be after the array is populated with elements to avoid errors
        dishAttributes = setAttributes(dishesScores);

        listOfAttributes = dishAttributes.getListOfAttributes();
        randomIndex = getRandomIndex(listOfAttributes[0].length, 1, numOfAttrib);
//        displayOptions(menuOptions, exitKey);


        do{
            initializeArray(dishesScores);

            dispTitle();
            System.out.printf("\nEnter # (1 - %d) to continue, 0 to EXIT. \n", (menuOptions.length -1));
            displayOptions(menuOptions, exitKey);
            System.out.println();

            System.out.print("-->: ");
            int choice = checkValidIn(in, "-->");
            if(isInputvalid(in, menuOptions.length, choice)){
                continue;
            }



            // Switch for Events
            eventController(in, dishesScores,listOfAttributes[0],listOfAttributes[1], choice, exitLoop);

            String msg = "'Y' to restart, 'N' to exit the program.";
            exitLoop = askYesOrNo(in,msg );

//            break;
        }while(!exitLoop);


        System.out.println("Thank You!!");


//
//        System.out.println("\n");
//
//
//        // Displaying the dishes with their name and the category for rating
//        dispResults(dishesScores,listOfAttributes[0], listOfAttributes[1]);
//
//        // Getting and setting the overAllAttrib array from DishAttributes Class
//        overAllAttrib = dishAttributes.getOverAllAttrib();
//        System.out.println("\n");
//        System.out.printf("Overall Dish's Max Score: %d\n", overAllAttrib[overAllAttrib.length-1]);
//        System.out.printf("Row Location: %d\n", overAllAttrib[0]);
//        System.out.printf("Column Location: %d\n", overAllAttrib[1]);
//
//
//        // Getting and setting the perDishAttrib array from DishAttributes Class
//        perDishAtt = dishAttributes.getPerDishAttrib();
//        System.out.println("\n");
//        dispResults(perDishAtt, listOfAttributes[0], listOfAttributes[2]);
//

        in.close();

    }

    public static boolean isInputvalid(Scanner in, int menuSize, int choice){
        if( choice  > menuSize || choice < 1){
            in.nextLine();
            System.out.println("Index number is not within the given options, try again!\n");
            System.out.print("Press ENTER key to continue...");
            in.nextLine();
            return true;
        }
        return false;
    }
    public static void eventController(Scanner in, int[][] dishesScores, String[] dishNames, String[] categNames ,int choice, boolean exitLoop){

        switch(choice){

            case 1:
                System.out.println("Instructions: You are the Main Chef/Judge,\n" +
                        "You have now the power to judge the dishes presented to you.\n");
                System.out.println("Rate every dish to your liking, but only within (1-100)!\n\n");

                askUserForScores(in);


                break;

            case 2:
                dishesScores = randArrElem(dishesScores);
                dispResults(dishesScores,dishNames, categNames);

                break;
            case 3:
                testValues(dishesScores);
                dispResults(dishesScores,dishNames, categNames);
                break;


            case 0:
                System.out.println("\nThank you for using the program, come again :D!\n");
                System.exit(0);
                break;
        }

    }

    public static void initializeArray(int[][] dishesScores){
        dishesScores = new int[numOfDishes][numOfCateg];
    }

    public static int[] getRandomIndex(int max, int min, int size){
        int[] randTemp = new int[size];
        int[] tempBuffer = new int[size * 4]; // size * 4 to ensure that a lot of unique integers can be picked
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
    public static int checkValidIn(Scanner in, String alertMsg) {
        while (!in.hasNextInt()) {
            System.out.println("Input only integers Chef, try again.");
            System.out.printf("%s: ", alertMsg);
            in.nextLine();
        }
        return in.nextInt();
    }
    public static int[][] askUserForScores(Scanner in){
        // Max dishes value is a static
        // Max categories value is a static

        int maxInput = 100, minInput =1;

        int[][] tempArr = new int[numOfDishes][numOfCateg];


        for(int i =0; i < numOfDishes; i++){
            int inp =0;
            System.out.println("Dish number " + (i+1) + " ");
            for(int j = 0; j < numOfCateg; j++){

                System.out.print("Your Score ->: ");

                inp = checkValidIn(in,"\nYour Score ->: ");

                if(inp >= minInput && inp <= maxInput){
                    tempArr[i][j] = inp;
                }
                else{
                    j--;
                    System.out.println("\nNot the score we were expecting chef, let's try again.\n");
                }
            }
        }




        return tempArr;
    }

    public static DishAttributes setAttributes(int[][] dishes){
        int maxScore = 0,
                LRow =0,
                LCol =0;
        int[] overAll = new int[numOfAttrib];
        int[][] perDish = new int[numOfDishes][numOfAttrib];

        for(int i =0; i< numOfDishes; i++){

            maxScore = 0;
            LRow =0;
            LCol =0;

            for(int j =0; j < numOfCateg; j++){
                if(maxScore < dishes[i][j]){ // checks if the current iteration of the array[][] is less than 0
                    maxScore = dishes[i][j]; // assigns the max value to the new value
                    LRow = (i+1); // fetch the current ROW data and assigns it into lRow variable
                    LCol = (j+1); // fetch the current COL data and assigns it into lCol variable
                }
            }
            if( maxScore != 0 || LRow <= 1 || LCol <= 1){

                perDish[i][0] = LRow;
                perDish[i][1] = LCol;
                perDish[i][perDish.length -1 ] = maxScore;

            }
        }

        maxScore = 0;
        for (int i = 0; i < numOfDishes; i++) {
            for (int j = 0; j < numOfCateg; j++) {
                if (maxScore < dishes[i][j]) {
                    maxScore = dishes[i][j];
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

    static int[][] randArrElem(int[][] dishScores){
        int max = 100, min =1;
        for(int i =0 ; i < numOfDishes; i++){
            for(int j =0; j < numOfCateg; j++){
                dishScores[i][j] = rand.nextInt(((max - min) + 1));
            }
        }
        return dishScores;
    }


    public static void testValues(int[][] dishesScores){
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

//        return dishesScores;
    }
    static void waitKeyPress(Scanner in){
        System.out.print("\nPress ENTER to continue: ");
        in.nextLine();
    }


    // --------------------------------------- Display ---------------------------------------
    static void displayOptions(String[] array, String exitKey){
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

    static void dispResults(int[][] dishScores, String[] dishNames, String[] categories) {
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
        for (String category : categories) {
            if (category.length() > categNameLen) {
                categNameLen = category.length();
            }
        }
        
        // Spaces for each of the categories
        columnPerCateg = categNameLen + 3;
        
        // Print the category headers
        System.out.print(paddingToRight("Dishes", dishNameLen + 2)); // Adjust spacing for dish names
        for(String columnTitle : categories){
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

    static String paddingToRight(String origStr, int length) {
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
        System.out.print("\n\t\t**********************************************************************************\n");
        System.out.printf("%-37s  %s\n", " ", "Working with 2D Arrays ");
        System.out.printf("%-36s  %s\n", " ", "Barral, Jacinth Cedric C.");
        System.out.printf("%-40s  %s\n", " ", "Lab - Activity 3");
        System.out.print("\t\t**********************************************************************************\n");



    }

    public static void dispTitle(){

        System.out.println("\n");
        System.out.printf("%s", "*****************************");
        System.out.printf("%-10s  %s", " ", " Heaven's Kitchen ");
        System.out.printf("%-10s  %s", " ", "*****************************\n");

        System.out.printf("%s", "*****************************");
        System.out.printf("%-8s  %s", " ", " Dish Rating Program ");
        System.out.printf("%-9s  %s", " ", "*****************************\n");
    }

    static int[] getOverallAttrib(int[][] dishes){
        int overAllMax =0, overAllRow =0,overAllCol =0;
        int[] tempArr = new int[numOfAttrib];
        for(byte i =0; i< numOfDishes; i++){
            for(int j =0; j < numOfCateg; j++){
                if(overAllMax < dishes[i][j]){ // checks if the current iteration of the array[][] is less than 0
                    overAllMax = dishes[i][j]; // assigns the max value to the new value
                    overAllRow = (i+1); // fetch the current ROW data and assigns it into lRow variable
                    overAllCol = (j+1); // fetch the current COL data and assigns it into lCol variable

                    if( overAllMax != 0 || overAllRow <= 1 || overAllCol <= 1){
                        tempArr[0] = overAllRow;
                        tempArr[1] = overAllCol;
                        tempArr[tempArr.length -1 ] = overAllMax;
                    }
                }
            }
        }
        return tempArr;
    }
    static int[][] getPerDishAttrib(int[][] perDishes){
        int maxPerDish =0,
                rowPerDish =0,
                colPerDish =0;
        int[][] tempArr = new int[numOfDishes][numOfAttrib];

        for(int i =0; i< numOfDishes; i++){
            for(int j =0; j < numOfCateg; j++){
                if(maxPerDish < perDishes[i][j]){ // checks if the current iteration of the array[][] is less than 0
                    maxPerDish = perDishes[i][j]; // assigns the max value to the new value
                    rowPerDish = (i+1); // fetch the current ROW data and assigns it into rowPerDish variable
                    colPerDish = (j+1); // fetch the current COL data and assigns it into colPerDish variable


                }
            }
            if( maxPerDish != 0 || rowPerDish <= 1 || colPerDish <= 1){
                tempArr[i][0] = rowPerDish;
                tempArr[i][1] = colPerDish;
                tempArr[i][tempArr.length -1 ] = maxPerDish;
            }
        }

        return tempArr;
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
                    {"st", "nd", "rd", "th"},
            };


    private String[][] dialogs =
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



}
