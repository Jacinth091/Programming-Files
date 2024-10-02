
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
    
    
    public static void dispAttrib(int index){
       String tmp;
   
      for(int i = 0; i < charData.charAttrib[index].length; i++){
         String attrib = charData.charAttrib[index][i];

         System.out.printf("%d. %s\n", (i+1), attrib);

         
         
      }
    }

   
   
   public static String[] getAttrib(Scanner in){
      String[] attribName = {"Race", "Gender", "Class"};
      String[] userAttrib = {};

      for(int i =0; i < charData.charAttrib.length; i++){
         String tmp;
         
         System.out.printf("Choose %s\n\n", attribName[i]);
         
         dispAttrib(i);
         
         System.out.println("Input number of your choosing: ");
         
         int choice = checkValidIn(in, "Input again!, ");
         if(!isInputvalid(in, charData.charAttrib[i].length, choice)){
            i--;
            continue;
        }
         System.out.println();
         
        
               
      }
      
      return null;
      
   }

   public static boolean isInputvalid(Scanner in, int size, int choice){
      if( choice > size || choice <= 0){
          in.nextLine();
          System.out.println("Index number is not within the given options, try again!\n");
          System.out.print("Press ENTER key to continue...");
          in.nextLine();
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