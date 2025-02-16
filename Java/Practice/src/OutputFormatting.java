import java.util.Scanner;

class Main{

   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      
         String[] inStr = new String[3];
         int[] inpNum = new int[3];
         
         for(int i =0; i < 3; i++){
            inStr[i] = in.next();
            inpNum[i] = in.nextInt();         
         } 
         
         System.out.println("================================");
        for(int i =0; i < 3; i++){
            
            String format = (inpNum[i] < 100 && inpNum[i] >= 10) ? "0" + inpNum[i] 
            : (inpNum[i] < 10) ? "00" + inpNum[i] 
            :  String.valueOf(inpNum[i]); 
            System.out.printf("%-15s%s\n",inStr[i], format);
            
        }   
        System.out.println("================================");
   
   
   }
   




}