// Random Number Generator
import java.util.Random;

public class RandomNumbers
{
   public static void main(String[] args)
   {
      Random randNum = new Random(); 
      
//       int x = randNum.nextInt(6)+1; // Generates pseudo-random numbers

      // double y = randNum.nextDouble(); // Generates Numbers between 0 and 1
      boolean z = randNum.nextBoolean(); // Generate random instances, either True or False
      
      
      System.out.print(z);
   
   }
}