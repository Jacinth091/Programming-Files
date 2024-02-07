// If-Statements in Java
import javax.swing.JOptionPane;
public class IfStatement
{
   public static void main(String[] args)
   {
      
      // if statement = performs a block of code if it's condition evaluates to be true
      
      int age = 19;
      
      if(age >= 18)
      {
         // JOptionPane.showMessageDialog(null, "You are an Adult!");
         System.out.println("You are an Adult!");

      }
      else {
         System.out.println("You are not an Adult!");
         // JOptionPane.showMessageDialog(null, "You are not an Adult!");

      }
      
   }
}