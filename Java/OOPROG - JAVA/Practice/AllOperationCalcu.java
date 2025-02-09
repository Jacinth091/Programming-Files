import java.util.Scanner;

class Main{

   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      
      int sumTotal =0, diffTotal =0, prodTotal =1;
      double quoTotal =1;

      int[] numArr = new int[20];
      
      
       for(int i = 0; i < numArr.length; i++)
       {
          System.out.printf("Enter an integer: ");
          numArr[i] = in.nextInt();
          in.nextLine();
          
       
       }
       
       for(int i=0; i<numArr.length; i++){
          sumTotal += numArr[i];
          
          diffTotal -= numArr[i];
          
          if(numArr[i] != 0) prodTotal *= numArr[i];
          
          if(numArr[i] == 0 ){
             continue;
          }   
          else{
             quoTotal /= numArr[i];   
          }
       
       }
        
            
      System.out.println("Sum Total: " + sumTotal);
      System.out.println("Difference Total: " + diffTotal);
      System.out.println("Product Total: " + prodTotal);
      System.out.println("Quotient Total: " + quoTotal);
   
   }



}