import java.util.Scanner;

public class BinarySearch{

   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      
      int[] numbers = {0,1,2,5,6,8,9,11,22,65,78,90};
      int arrLen = numbers.length;
      
      int target = 65;
      
      int mid = arrLen / 2;
      int low = arrLen - arrLen;
      int high = arrLen -1;
      
      while(true){
      
         if(target > numbers[mid]){
            arrLen = arrLen - (mid+1);
            low += (mid +1);
            high = arrLen -1;
         
         }
         else if(target < mid){
            arrLen = arrLen - (mid+1);
            low += (mid +1);
            high = arrLen -1;
            
         }
      
      
      
      }
   
   }
}