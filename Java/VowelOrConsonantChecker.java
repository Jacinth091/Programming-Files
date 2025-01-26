import java.util.Scanner;

class Main{
   public static void main(String[] args){
   
      Scanner in = new Scanner(System.in);
      
      String text = "";
      String temp = "";

      char[] textArr;
      int vowelCounter =0, consoCount =0;
      
      
      System.out.print("Input a text: ");
      text = in.nextLine().trim();
      
      temp = text;
      
      temp = temp.toUpperCase();
      
      textArr = text.toCharArray();
      
      for(int i =0; i < textArr.length; i++){
         System.out.println(textArr[i]);
         if(isCharVowel(textArr[i])){
            vowelCounter++;
         
         }
         else{
            consoCount++;
         }
      
      }
      
      System.out.println("Number of Vowels: " + vowelCounter);
      System.out.println("Number of Consonants: " + consoCount);
      
      
   
   
   
   }

   public static boolean isCharVowel(char charac){
   
      return charac == 'A' || charac == 'E' || charac == 'I' || charac == 'O' || charac == 'U';
   
   
   }
}