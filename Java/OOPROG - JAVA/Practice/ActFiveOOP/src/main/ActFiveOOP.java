package ActFiveOOP.src.main;

import java.util.Scanner;

class ActFiveOOP
{
   static CharacterData charData;
   public static void main(String[] args){
       setInstance();


     Scanner in = new Scanner(System.in);
//     String[] attribTmp = getAttrib(in);
     Character player1 = new Character();
     Character player2 = new Character();
     

        createCharacter(in);



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
       String[] attribNames = {"Name", "Race", "Gender", "Class", "Job"};
       String[][] attribOptions = {
               {}, // For Name
               charData.getCharAttrib()[0], // For Race options
               charData.getCharAttrib()[1], // For Gender options
               charData.getCharAttrib()[2], // For Class options
               {}  // For Job, base on the picked Class
       };
       String[] userAttrib = new String[5];
       String name = "", race = "", gender = "", job = "", charClass = "";
       int lastIndex = userAttrib.length-1;

       for(int i=0; i < attribOptions.length; i++){
           System.out.println(i);
            String attribName = attribNames[i];

            if(attribName.equals("Name")){
                System.out.print("Enter your character's name: ");
                name = in.nextLine();
                userAttrib[i] = name;
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

           if(i == 4){

               charClass = userAttrib[3];
               System.out.printf("\nNow pick a job base on your %s class.\n\n", userAttrib[3]);
               userAttrib[lastIndex] = getJobByClass(in, attribOptions[3], charData.getJobAttrib(), userAttrib[3]);
               job = userAttrib[lastIndex];
               System.out.printf("\nYou have picked \"%s\" as your \"%s\".\n",job, attribNames[lastIndex]);

           }


           System.out.println();


           System.out.println(i);


       }

//       for(String attrib : userAttrib){
//           System.out.println(attrib);
//       }

        player = new Character();




       return player;
   }
   public static String[] getAttrib(Scanner in){
      String[] attribName = {"Race", "Gender", "Class", "Job"};
      String[] userAttrib = new String[4];
      String[] charAtt;
      int lastIndex = userAttrib.length-1;

      String race, gender, charClass, job;

      for(int i =0; i < charData.getCharAttrib().length; i++){
         charAtt = charData.getCharAttrib()[i];
         System.out.printf("Choose %s\n\n", attribName[i]);
         
         dispAttrib(charData.getCharAttrib()[i]);
         
         System.out.print("\nInput number of your choosing: ");

         int choice = checkValidIn(in, "Input again!, ");
         if(!isInputvalid(in, charAtt.length, choice)){
            i--;
            continue;
        }

        System.out.println();

        System.out.printf("You have picked \"%s\" as your \"%s\".\n",charData.getCharAttrib()[i][choice-1], attribName[i]);
        userAttrib[i] = charData.getCharAttrib()[i][choice -1];


        if(i == charData.getCharAttrib().length -1){
            charClass = userAttrib[2];
            job = userAttrib[lastIndex];
            System.out.printf("\nNow pick a job base on your %s class.\n\n", charClass);
            userAttrib[lastIndex] = getJobByClass(in, charAtt, charData.getJobAttrib(), userAttrib[i]);
            System.out.printf("\nYou have picked \"%s\" as your \"%s\".\n",userAttrib[lastIndex], attribName[lastIndex]);

        }

         System.out.println();
      }
      
      return userAttrib;
      
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

   public static boolean checkInputRange(int num){

      //        if(num >= minGrade && num <= maxGrade){
      //            return true;
      //        }
      //        return false;
      
            //   return num >= minGrade && num <= maxGrade;
            return false;
      
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