import javax.swing.JOptionPane;
public class Bicycle extends Vehicle{

   
   public Bicycle(){
      super("a person", 2);
   }
   
   
   @Override
   public void setPrice(){
      String input;
      final int MAX = 4000;
      
//       input = JOptionPane.showInputDialog(null, "Enter bicycle price: ");
//       price = Integer.parseInt(input);
      
      price = getValidInput("Enter bicycle price: ", "Invalid input for price!");
      
      if(price > MAX){
         price = MAX;
      }   
   }
   
   @Override
   public String toString(){
      
      return(
      
          "The bicycle is powered by " +
         getPowerSource() + " it has " +
         getWheels() + " wheels and costs $" +
         getPrice()
         
         );
   
   
   }
   
   public int getValidInput(String showMsg, String showAlert){
      int temp;
         
      while(true){
      
            String input;
            input = JOptionPane.showInputDialog(null, showMsg);
            try{

               temp = Integer.parseInt(input);
               
            }catch(NumberFormatException e){
               JOptionPane.showMessageDialog(null,showAlert,"Alert",JOptionPane.WARNING_MESSAGE);     
               continue;
            }
            break;

      }
      
      return temp;
   
   }

}