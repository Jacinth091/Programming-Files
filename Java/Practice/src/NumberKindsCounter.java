import java.util.Scanner;

class Main{

   public static void main(String[] args){
      
      Scanner in = new Scanner(System.in);
      
       int[] numArr = new int[10];
//       int[] numArr = new int[]{1,2,3,5,-2,-51,-21,0,22,0,0,0};
      int evenCount =0, oddCount =0, posCount =0, negCount =0, zeroCount =0;
      
      
       for(int i = 0; i < numArr.length; i++)
       {
          System.out.printf("Enter an integer: ");
          numArr[i] = in.nextInt();
          in.nextLine();
          
       
       }
      
      for(int i =0; i< numArr.length; i++){
      int num = numArr[i];
         if(num > 0 && num != 0){
            posCount++;
         
         }
         else if(num < 0){
            negCount++;
         
         }
         else{
            zeroCount++;
         
         }
         
         if(num % 2 == 0){
            evenCount++;
         
         }
         else {
            oddCount++;
         }
      
      
      }
      
      System.out.println("Number of Even Number: " + evenCount);
      System.out.println("Number of Odd Number: " + oddCount);
      System.out.println("Number of Positive Number: " + posCount);
      System.out.println("Number of Negative Number: " + negCount);
      System.out.println("Number of Zero Number: " + zeroCount);
   
   }
 

}