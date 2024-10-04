/*
* Name: Barral, Jacinth Cedric C.
* Date: October 4, 2024
* Description: Lab.Act.#05 - Classes and Objects (Encapsulation and Abstraction) Part 1
*
*
*
* */

package ActivityFiveOOP;

import java.util.Scanner;

class ActFiveOOP
{
   static CharacterData charData;
   static Character[] players;
//   static Random rand;
   public static void main(String[] args){
       setInstance();
       Scanner in = new Scanner(System.in);
       String[] opt = {"Enter Character Attributes", "Character Randomizer", "Exit Program"};
       displayHeader();

       mainLoop(in, opt);
//       randomizePlayerArray(in, 5);
//       dispPlayersAttrib();
       System.out.println("Thank you for using the program, Goodbye! :D");
       in.close();

    }
    // **************************************** Main Logic ****************************************
    public static void mainLoop(Scanner in, String[] opt){
        boolean exitLoop = false;

        do{

            dispOpts(opt, opt[opt.length-1]);
            System.out.print("\n-->: ");
            int choice = checkValidIn(in, "-->");
            if(!isInputvalid(in, opt.length-1,0 , choice)){
                continue;
            }

            eventController(in, choice);

            dispPlayersAttrib();

            System.out.println("\n");

            String msg = "'Y' to restart, 'N' to exit the program.";
            exitLoop = askYesOrNo(in,msg );
            System.out.println();

        }while(!exitLoop);



    }

    public static void eventController(Scanner in, int choice){
        switch(choice){
            case 1:
                System.out.println("Welcome to Character Creator!\n");
                userInputAttributes(in);
                break;
            case 2:
                System.out.println("Welcome to Character Randomizer!\n");

                int size = getValidatedNum(in, "How many characters you want to create? (Maximum is 5)", 5, 1);
                randomizePlayerArray(in, size);
                break;
            case 0:
                System.out.println("Thank you for using the program, Goodbye!\n");
                System.exit(0);
                break;

        }
    }

    // **************************************** User Input ****************************************
    public static void userInputAttributes(Scanner in){
        int max =3, min =1;
        int choice = 0;

        choice = getValidatedNum(in, "How many characters do you want to create? (Maximum is 3)", max, min);

        players = new Character[choice];
        createPlayerArray(in);
        System.out.print("----------------------------------------------------------------------------------\n");


    }


    // **************************************** Display Output ****************************************
    public static void dispOpts(String[] array, String exitKey){

        System.out.printf("\nEnter # (1 - %d) to continue, 0 to EXIT. \n", (array.length -1));
        int arrayLength = array.length;
        for(int i = 0; i<arrayLength; i++) {
            if(array[i].equals(exitKey)){ // checks if the current iteration of the menu is "Exit" String
                System.out.println();
                System.out.printf("%-1d. %s.\n", 0, array[i]); // it will display 0, an indication to exit
            }
            else{// if the current iteration of the menu is not "Exit" String
                System.out.printf("%-1d. %s.\n", (i+1), array[i]);
            }
        }
    }
    public static void displayHeader(){
        System.out.print("\n**********************************************************************************\n");
        System.out.printf("%-13s  %s\n", " ", "Classes and Objects (Encapsulation and Abstraction)");
        System.out.printf("%-26s  %s\n", " ", "Barral, Jacinth Cedric C.");
        System.out.printf("%-28s  %s\n", " ", "Lab.Act.#05 - Part 1");
        System.out.print("**********************************************************************************\n");

        System.out.print("\n----------------------------------------------------------------------------------\n");
        System.out.printf("%-20s  %s\n", " ", "Welcome to Character Creation Program");
        System.out.printf("%-22s  %s\n", " ", "Simple character creator program.");
        System.out.printf("%-33s  %s\n", " ", "Version 2");
        System.out.print("----------------------------------------------------------------------------------\n");

    }
    public static void dispAttrib(String[] attArr){
        for(int i = 0; i < attArr.length ; i++){
            String attrib = attArr[i];
            System.out.printf("%-5s%d. %s\n"," ", (i+1), attrib);

        }
    }
    public static void dispPlayersAttrib(){
        System.out.println("\n\nYour Created Character Attributes\n");
        int charCount =1;
        for(Character player : players){
            System.out.printf("Character #%d\n", charCount);
            System.out.print("----------------------------------------------------------------------------------\n");
            player.dispAttrib();
            System.out.print("----------------------------------------------------------------------------------\n");
            charCount++;
        }
    }




    // **************************************** Get And Set ****************************************
    public static void randomizePlayerArray(Scanner in, int size){
        players = new Character[size];
        for(int i = 0; i < players.length; i++){
            players[i] = charRandomizer();
        }
    }
 /*   public static Character charRandomizer(){
        String[][] attribOptions = {
                charData.getCharAttrib()[0],
                charData.getCharAttrib()[1], // For Race options
                charData.getCharAttrib()[2], // For Gender options
                charData.getCharAttrib()[3], // For Class options
                {}, // For Job
        };
        String name = "", race = "", gender = "", charClass = "", job = "";

        for(int i =0; i< attribOptions.length; i++){
            String attribName = charData.getAttribNames()[i];
            switch(attribName){
                case "Name":
                    name = attribOptions[i][genRandNum(attribOptions[i].length)];
                    break;
                case "Race":
                    race = attribOptions[i][genRandNum(attribOptions[i].length)];
                    break;
                case "Gender":
                    gender = attribOptions[i][genRandNum(attribOptions[i].length)];
                    break;
                case "Class":
                    charClass = attribOptions[i][genRandNum(attribOptions[i].length)];
//                    System.out.println(charClass);
                    job = getRandJobByClass(charData.getJobAttrib(), charClass);
                    break;

            }
        }

//        System.out.printf("%s\n", name);
//        System.out.printf("%s\n", race);
//        System.out.printf("%s\n", gender);
//        System.out.printf("%s\n", charClass);
//        System.out.printf("%s\n", job);


        return new Character(name, race, gender, charClass, job);
    }*/

    public static Character charRandomizer() {
        String[][] attribOptions = {
                charData.getCharAttrib()[0], // Name options
                charData.getCharAttrib()[1], // Race options
                charData.getCharAttrib()[2], // Gender options
                charData.getCharAttrib()[3], // Class options
        };

        Character player = new Character();
        player.randomizeCharacterAttributes(attribOptions, charData);

        return player;
    }

/*    public static String getRandJobByClass(String[][] jobArray, String pickedClass){
        String[] classList = charData.getCharAttrib()[charData.getCharAttrib().length-1];
        String job = "";

        for (int i = 0; i < classList.length; i++) {
            if (classList[i].equals(pickedClass)) {
                String[] jobsForClass = jobArray[i];
                job = jobsForClass[genRandNum(jobsForClass.length)]; // Pick a random job from the matching class
                break;
            }
        }
        return job;
    }*/
    public static int getValidatedNum(Scanner in,String msg, int max, int min){
        int choice =0;
        do {
            System.out.printf("%s\n",msg);
            System.out.print("--> : ");
            choice = checkValidIn(in, "--> ");
            boolean isValid = checkInputRange(choice, max, min); // returns true if valid, false if not

            if (!isValid) {
                System.out.printf("Maximum characters is %d, try again!\n", max);
//               in.nextLine();
                continue;
            }
//            in.nextLine();
            break;
        }while(true);

        return choice;

    }
    public static String getJobByClass(Scanner in, String[] classAttrib, String[][] jobArray, String pickedClass){
        String jobTemp = " ";

        for (int i = 0; i < classAttrib.length; i++) {
            if (classAttrib[i].equals(pickedClass)) {

                dispAttrib(jobArray[i]);
                System.out.print("\nInput number of your choosing: ");
                int choice = checkValidIn(in, "Input again!, ");

                if(!isInputvalid(in, jobArray[i].length, 1, choice)){
                    i--;
                    continue;
                }

                choice--;
                // Display the valid choice and assign jobTemp
//             System.out.printf("%d\n", choice);
                jobTemp = jobArray[i][choice];
//             System.out.printf("%s\n", jobTemp);
                break; // Exit the loop once a valid job is found

            }



        }

        //   System.out.println("Invalid Character Class");

        return jobTemp;

    }

    public static void setInstance(){
        charData = CharacterData.getInstance();
//       charData.sayHello();

    }


    // **************************************** Generate / Create ****************************************

//    public static int genRandNum(int max){
//        rand = new Random();
//        return rand.nextInt(max);
//
//    }
    public static Character createCharacter(Scanner in){

        Character player;
        String[][] attribOptions = {
                {}, // For Name
                charData.getCharAttrib()[1], // For Race options
                charData.getCharAttrib()[2], // For Gender options
                charData.getCharAttrib()[3], // For Class options
                {}, // For Job
        };
        String[] userAttrib = new String[5];
        int lastIndex = userAttrib.length-1;

        for(int i=0; i < attribOptions.length -1; i++){
//           System.out.println(i);
            String attribName = charData.getAttribNames()[i];

            if(attribName.equals("Name")){
                System.out.print("Enter your character's name: ");
                userAttrib[i] = in.nextLine();
                continue;

            }

            System.out.printf("Choose %s\n\n", attribName);

            dispAttrib(attribOptions[i]);

            System.out.print("\nInput number of your choosing: ");

            int choice = checkValidIn(in, "Input again!, ");
            if(!isInputvalid(in, attribOptions[i].length, 1, choice)){
                i--;
                continue;
            }

            System.out.println();

            System.out.printf("You have picked \"%s\" as your \"%s\".\n",attribOptions[i][choice-1], attribName);
            userAttrib[i] = attribOptions[i][choice -1];

            if(attribName.equals("Class")){
                System.out.printf("\nNow pick a job base on your %s class.\n\n", userAttrib[3]);
                userAttrib[lastIndex] = getJobByClass(in, attribOptions[3], charData.getJobAttrib(), userAttrib[3]);
                System.out.printf("\nYou have picked \"%s\" as your \"%s\".\n",userAttrib[lastIndex], charData.getAttribNames()[lastIndex]);
            }
            System.out.println();


        }

        String name = userAttrib[0],
                race = userAttrib[1],
                gender = userAttrib[2],
                charClass = userAttrib[3],
                job = userAttrib[4];

        player = new Character(name, race, gender, charClass, job);




        return player;
    }
    public static void createPlayerArray(Scanner in){

        for(int i = 0; i < players.length; i++){
            in.nextLine();
            players[i] = new Character();
            System.out.println("\n----------------------------------------------------------------------------------");
            System.out.printf("For Character number #%d.\n\n", i+1);
            players[i] = createCharacter(in);


            System.out.print("----------------------------------------------------------------------------------\n");
            players[i].dispAttrib();
            System.out.print("----------------------------------------------------------------------------------\n");

            String msg = "Press 'Y' to confirm, 'N' to discard all.";
            if(askYesOrNo(in, msg)){
                System.out.println("\n\nDiscarding all, re-enter attributes.");
                System.out.println("Press any key to continue...");
                in.nextLine();
                i--;
                continue;
            }


        }
    }




    // **************************************** Check / Validate ****************************************

    public static boolean checkInputRange(int num, int max, int min){
        return num >= min && num <= max;
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
                System.out.println("\n-------------------------------------------------------");
                System.out.println("Invalid input! Please enter 'Y' or 'N'.");
                System.out.println("-------------------------------------------------------");
            }


        }while(true);


        return value;

    }

    public static boolean isInputvalid(Scanner in, int size, int min, int choice){
        if( choice > size || choice < min){
            in.nextLine();
            System.out.println("Index number is not within the given options, try again!\n");
            //  System.out.print("Press ENTER key to continue...");
            //  in.nextLine();
            return false;

        }
        return true;
    }

    public static int checkValidIn(Scanner in, String alert){
        while(!in.hasNextInt()){
            System.out.println("Input only integers, try again!");
            System.out.print(alert + ": ");
            in.next();

        }
        return in.nextInt();


    }



}