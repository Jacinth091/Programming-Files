
import java.util.Scanner;

class ActFiveOOP
{
   static CharacterData charData;
   public static void main(String[] args){
   
     setInstance();


     Scanner in = new Scanner(System.in);
     String[] attribTmp;
     
     
     
     getAttrib();
      
     
   
         
   
   }
   
   
   public static void getAttrib(){

      for(int i =0; i < charData.charAttrib.length; i++){
         String tmp;
      
         for(int j =0; j < charData.charAttrib[i].length; j++){
            
         
//             System.out.printf("%s\n", charData.charAttrib[i][j]); 

         System.out.println("");


         
         
         }
         System.out.println(); 
      
      }
      
   
   }
   
   public static void setInstance(){
   
   
      charData = CharacterData.getInstance();
       charData.sayHello(); 
   
   
   
   
   }

}