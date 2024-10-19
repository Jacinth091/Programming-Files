import javax.swing.JOptionPane;
public class Bicycle extends Vehicle{

   public Bicycle(){
      super("a person", 2);
   }

   @Override
   public void setPrice(){
      final int MAX = 4000;
      
//       input = JOptionPane.showInputDialog(null, "Enter bicycle price: ");
//       price = Integer.parseInt(input);
      
      price = getValidInput("Enter bicycle price: ", "Invalid input for price!", "Input Bicycle Price");
      if(price > MAX){
         price = MAX;
      }   
   }
   
   @Override
   public String toString(){
      String notZero = "The bicycle is powered by " +
              getPowerSource() + " it has " +
              getWheels() + " wheels and costs $" +
              getPrice();
      String varIsZero =  "The user didn't want to buy a Bicycle";


      return (price == 0) ? varIsZero : notZero;

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