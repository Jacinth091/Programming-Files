/*
* Name: Barral, Jacinth Cedric C.
* Date: October 3, 2024
* Description: Lab.Act.#05 - Classes and Objects (Encapsulation and Abstraction) Part 1
*
*
*
* */

package ActFiveOOP.src.main;

import java.util.Scanner;

class ActFiveOOP
{
   static CharacterData charData;
   static Character[] players;
   public static void main(String[] args){
       setInstance();
       Scanner in = new Scanner(System.in);
       String[] opt = {"Enter Character Attributes", "Character Randomizer"};
       displayHeader();




       mainLoop(in);



       in.close();

    }
    public static void charRandomizer(){





    }
    public static void mainLoop(Scanner in){
       boolean exitLoop = false;

       do{
           System.out.println("Welcome to Character Creator!\n");
           System.out.println("\nHow many characters do you want to create?");
           System.out.print("--> : ");
           int choice = checkValidIn(in, "--> ");
           boolean isValid = checkInputRange(choice, 3, 1);
           if(!isValid){
               System.out.printf("Maximum characters is %d, try again!", 3);
               continue;
           }
//           in.nextLine();

           players = new Character[choice];

//           System.out.println();

           createPlayerArray(in);

           System.out.print("----------------------------------------------------------------------------------\n");

           dispPlayersAttrib();

            System.out.println();
           String msg = "'Y' to restart, 'N' to exit the program.";
           exitLoop = askYesOrNo(in, msg);
           System.out.println();

       }while(!exitLoop);


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
    public static void dispPlayersAttrib(){
        System.out.println("\n\nYour Created Character Attributes");
        int charCount =1;
        for(Character player : players){
            System.out.print("----------------------------------------------------------------------------------\n");
            System.out.printf("Character #%d\n\n", charCount);
            player.dispAttrib();
            System.out.print("----------------------------------------------------------------------------------\n");
            charCount++;
        }
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
    public static boolean checkInputRange(int num, int max, int min){
        return num >= min && num <= max;
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
       String[] charAtt = attArr;
   
      for(int i = 0; i < charAtt.length ; i++){
         String attrib = charAtt[i];
         System.out.printf("%-5s%d. %s\n"," ", (i+1), attrib);

      }
    }


   public static Character createCharacter(Scanner in){

       Character player;
       String[][] attribOptions = {
               {}, // For Name
               charData.getCharAttrib()[0], // For Race options
               charData.getCharAttrib()[1], // For Gender options
               charData.getCharAttrib()[2], // For Class options
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
           if(!isInputvalid(in, attribOptions[i].length, choice)){
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
   public static String getJobByClass(Scanner in, String[] classAttrib, String[][] jobArray, String jobByClass){
      String jobTemp = " ";

      for (int i = 0; i < classAttrib.length; i++) {
         if (classAttrib[i].equals(jobByClass)) {

            dispAttrib(jobArray[i]);
             System.out.print("\nInput number of your choosing: ");
             int choice = checkValidIn(in, "Input again!, ");

             if(!isInputvalid(in, jobArray[i].length, choice)){
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


   public static boolean isInputvalid(Scanner in, int size, int choice){
      if( choice > size || choice <= 0){
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
   
   public static void setInstance(){
      charData = CharacterData.getInstance();
//       charData.sayHello();

   }

}