
import java.util.Scanner;

class ActFiveOOP
{
   static CharacterData charData;
   public static void main(String[] args){
   
     setInstance();


     Scanner in = new Scanner(System.in);
     String[] attribTmp;
     
     
     
      getAttrib();
//       
//       dispAttrib(0);
//       dispAttrib(1);
//       dispAttrib(2);
    }
    
    
    public static String dispAttrib(int index){
       String tmp;
   
      for(int i = 0; i < charData.charAttrib[index].length; i++){
         String attrib = charData.charAttrib[index][i];

         System.out.printf("%d. %s\n", (i+1), attrib);
      }
      return null;
    }
   
   
   public static String[] getAttrib(){
      String[] attribName = {"Race", "Gender", "Class"};
      // String[] userAttrib = {};

      for(int i =0; i < charData.charAttrib.length; i++){
         String tmp;
         
         System.out.printf("Choose %s\n\n", attribName[i]);
         
         dispAttrib(i);
         System.out.println();
         
        
               
      }
      
      return null;
      
   }
   
   public static void setInstance(){
   
   
      charData = CharacterData.getInstance();
       charData.sayHello(); 
   
   
   
   
   }

}