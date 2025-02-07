import java.util.Scanner;
class Exer3{
   public static void main(String[] args){
   
      Scanner in = new Scanner(System.in);
      
      String text = "";
      String temp = "";
      char[] textArr;
      int vowelCount =0, consoCount =0, numberCount =0, specialChar = 0, whiteSpaces =0;
      
      
      System.out.print("Input a text: ");
      text = in.nextLine().trim();
      
      temp = text;
      
      temp = temp.toUpperCase();
      
      textArr = temp.toCharArray();
      
      for(int i =0; i < textArr.length; i++){
         char charac = textArr[i];
         
         if(isVowel(charac)){
             vowelCount++;
         }
         else if(isNumber(charac)){
            numberCount++;
         }
         else if(isCharSpecial(charac)){
            consoCount++;
         }
         else if(charac == ' '){
            whiteSpaces++;
         }
         else{
            specialChar++;
         }
      
      }
            
      System.out.println("\n\nOriginal Text: \"" + text + "\".\n\n");
      System.out.println("Number of Vowels: " + vowelCount);
      System.out.println("Number of Consonants: " + consoCount);
      System.out.println("Number of Digit Characters: " + numberCount);
      System.out.println("Number of Special Characters: " + specialChar);
      System.out.println("Number of White Spaces: " + whiteSpaces);
      
   
   
   
   }
   public static boolean isVowel(char c){
      return  c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
   
   }
   
   public static boolean isNumber (char c){
      return  c >= '0' && c <= '9';        
   
   }
   
   public static boolean isCharSpecial (char c){
      return c >= 'A' && c <= 'Z';        
   
   }
   
   
   
}
