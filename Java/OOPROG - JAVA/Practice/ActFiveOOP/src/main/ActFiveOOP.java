package src.main;

import java.util.Scanner;

class ActFiveOOP
{
   static CharacterData charData;
   public static void main(String[] args){
   
     setInstance();


     Scanner in = new Scanner(System.in);
     String[] attribTmp;
     
     
     
      getAttrib(in);
//       
//       dispAttrib(0);
//       dispAttrib(1);
//       dispAttrib(2);
    }
    
    
    public static void dispAttrib(String[] attArr){
       String[] charAtt = attArr;
   
      for(int i = 0; i < charAtt.length ; i++){
         String attrib = charAtt[i];

         System.out.printf("%-5s%d. %s\n"," ", (i+1), attrib);

         
         
      }
    }

   
   
   public static String[] getAttrib(Scanner in){
      String[] attribName = {"Race", "Gender", "Class", "Job"};
      String[] userAttrib = new String[4];
      String[] charAtt;

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

            System.out.printf("%s\n",charData.getCharAttrib()[i][choice -1]);
            userAttrib[i] = charData.getCharAttrib()[i][choice -1];

         if(i == charData.getCharAttrib().length -1){
            getJobByClass(charAtt, charData.getJobAttrib(), userAttrib[i]);
         }




         System.out.println();
         
        
               
      }
      
      return userAttrib;
      
   }

   public static String getJobByClass(String[] classAttrib, String[][] jobArray, String jobByClass){
      String jobTemp = " ";

      // System.out.printf("%s\n",charData.getCharAttrib()[i][choice -1]);
      // userAttrib[i] = charData.getCharAttrib()[i][choice -1];
      // do{

      //    dispAttrib(charData.getJobAttrib()[choice - 1]);

      //    choice = checkValidIn(in, "Input again!, ");
      //    if(!isInputvalid(in, charData.getJobAttrib()[i- 1].length, choice)){
      //       continue;
      //    }  
      //    else{
      //       break;
      //    }


      // }while(true);
      
      for (int i = 0; i < classAttrib.length; i++) {
         if (classAttrib[i].equals(jobByClass)) {
            dispAttrib(jobArray[i]);
            
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
       charData.sayHello(); 
   
   
   
   
   }

}