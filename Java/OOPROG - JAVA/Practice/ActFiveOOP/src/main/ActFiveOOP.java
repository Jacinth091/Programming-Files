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
   public static void main(String[] args){
       setInstance();
       Scanner in = new Scanner(System.in);
//       Character player1 = createCharacter(in);
//       player1.dispAttrib();

//       System.out.println("Welcome to Character Creation Program!");

//       displayHeader();
//
//       String msg = "Press 'Y' to start, 'N' to exit";
//       if(!askYesOrNo(in, msg)){
//
//
//
//
//
//       }

        createCharacter(in);




       in.close();

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