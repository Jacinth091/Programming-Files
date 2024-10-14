import javax.swing.JOptionPane;
public class Sailboat extends Vehicle{

   private int length;
   
   public Sailboat(){
      super("Wind", 0);
      setLength();
   
   }
   
   public void setLength(){
      String input;
      input = JOptionPane.showInputDialog(null, "Enter sailboat length in feet: ");
      length = Integer.parseInt(input);
   }
   public int getLength(){
      return length;
   }
  
   @Override
   public void setPrice(){
      String input;
      final int MAX = 100000;
      
      input = JOptionPane.showInputDialog(null, "Enter sailboat price: ");
      price = Integer.parseInt(input);
      
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


}