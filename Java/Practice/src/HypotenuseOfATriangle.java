import java.util.Scanner;
 
class HypotenuseOfATriangle
{
   public static void main(String[] args)
   {
      double sideA, sideB, sideC, result;
      Scanner input = new Scanner(System.in);
      
      System.out.print("Enter side A: ");
      sideA = Math.pow(input.nextDouble(), 2);
      input.nextLine();
      
      System.out.print("Enter side B: ");
      sideB = Math.pow(input.nextDouble(), 2);
      input.nextLine();
      
      sideC = Math.sqrt(sideA + sideB);
      
      System.out.println("The hypotenuse is: " +sideC);
      
      input.close();
      
      
   }
}