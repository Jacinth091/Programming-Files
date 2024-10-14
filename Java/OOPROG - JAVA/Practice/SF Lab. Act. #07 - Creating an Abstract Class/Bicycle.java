import javax.swing.JOptionPane;
public class Bicycle extends Vehicle{

   
   public Bicycle(){
      super("a person", 2);
   }
   
   @Override
   public void setPrice(){
      String input;
      final int MAX = 4000;
      
      input = JOptionPane.showInputDialog(null, "Enter bicycle price: ");
      price = Integer.parseInt(input);
      
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


}