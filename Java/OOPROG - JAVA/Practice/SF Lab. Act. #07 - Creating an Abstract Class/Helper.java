import java.util.Scanner;
import javax.swing.JOptionPane;
public class Helper{

   public Helper(){}
   
   public int getValidInput(String showMsg, String showAlert){
      int temp;
         
      while(true){
      
          
            try{
               String input;
               input = JOptionPane.showInputDialog(null, showMsg);
               temp = Integer.parseInt(input);
               
            }catch(NumberFormatException e){
               JOptionPane.showMessageDialog(null, showAlert);
               continue;
            }
            break;

      }
      
      return temp;
   
   }
 
   

}