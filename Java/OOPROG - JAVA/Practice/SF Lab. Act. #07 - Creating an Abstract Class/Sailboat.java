import javax.swing.JOptionPane;
// import java.util.InputMismatchException;
public class Sailboat extends Vehicle{

   private int length;
   
   public Sailboat(){
      super("Wind", 0);
      setLength();

   }
   
   public void setLength(){

      length = getValidInput("Enter sailboat length in feet: ", "Invalid input for length!", "Input Sailboat Length");

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

      price = getValidInput("Enter sailboat price: ", "Invalid input for price!", "Input Sailboat Price");
      
      if(price > MAX){
         price = MAX;
      }   
   }

   @Override
   public String toString(){
      String notZero = "The " + getLength() +
              " foot sailboat is powered by " +
              getPowerSource() + " it has " +
              getWheels() + " wheels and costs $" +
              getPrice();
      String varIsZero =  "The user didn't want to buy a Sailboat\n";


      return (length ==0 || price ==0) ? varIsZero : notZero;
   
   }


   public int getValidInput(String showMsg, String showAlert, String paneTitle){
      int temp = 0;

      while(true){
         String input = JOptionPane.showInputDialog(null, showMsg, paneTitle, JOptionPane.QUESTION_MESSAGE);


         if(input == null){
            JOptionPane.showMessageDialog(null, "Option Pane Exited", "Warning", JOptionPane.WARNING_MESSAGE);
            break;
         }

         if(input.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Input a number to continue!", "Warning", JOptionPane.WARNING_MESSAGE);
            continue;
         }


         try{
            temp = Integer.parseInt(input);
            break;
         }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, showAlert, "Invalid Input", JOptionPane.ERROR_MESSAGE);
            continue;
         }


      }

      return temp;

   }


}