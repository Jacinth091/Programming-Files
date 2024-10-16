import javax.swing.JOptionPane;
// import java.util.InputMismatchException;
public class Sailboat extends Vehicle{

   private int length;
   
   public Sailboat(){
      super("Wind", 0);
      setLength();

   }
   
   public void setLength(){

      length = getValidInput("Enter sailboat length in feet: ", "Invalid input for length!");

   }
   public int getLength(){
      return length;
   }
  
  
   @Override
   public void setPrice(){
      String input;
      final int MAX = 100000;
//       
//       input = JOptionPane.showInputDialog(null, "Enter sailboat price: ");
//       price = Integer.parseInt(input);

      price = getValidInput("Enter sailboat price: ", "Invalid input for price!");
      
      if(price > MAX){
         price = MAX;
      }   
   }

   @Override
   public String toString(){
   
      return(
          "The " + getLength() + 
         " foot sailboat is powered by " +
         getPowerSource() + " it has " +
         getWheels() + " wheels and costs $" +
         getPrice()
         );
   
   }
   
      
   public int getValidInput(String showMsg, String showAlert){
      int temp;
         
      while(true){
      
         String input;
         input = JOptionPane.showInputDialog(null, showMsg, "Input Price", JOptionPane.OK_CANCEL_OPTION);
         
         try{

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