// Math Class

public class MathClass 
{
   public static void main(String[] args)
   {
      double x = 3.14;
      double y = 10;
      
      double z = Math.max(x,y); // Compares the value of the two variables
                                // then results a Greater value 
                                
      double a = Math.abs(y);   // Converts negative numbers to positive 
      double sqr = Math.sqrt(y); // Calculate the Square Root of the variable
      double round = Math.round(x); // Rounds off the variable
      double ceil = Math.ceil(x);  // Always Round UP
      double floor = Math.floor(x); // Always round DOWN
      double pow = Math.pow(y,2);
      
      System.out.println("Greater value between " +x+ " and " +y+ " is: " + z);
      System.out.println("Absolute value of " +y+ " is: " +a );
      System.out.println("The Square Root of " +y+ " is: " +sqr );
      System.out.println( x + " rounded-off is: " + round );
      System.out.println( x + " rounded UP is: " + ceil );
      System.out.println( x + " rounded DOWN is: " + floor );
      System.out.println( y + " raised to the power of 2 is: " + pow );
      
   
   }
}
