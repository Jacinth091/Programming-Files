// GUI Program - Graphical User Interface

import javax.swing.JOptionPane;

public class SimpleGUI_Application {
   public static void main (String[] args) 
   {
      String name = JOptionPane.showInputDialog("Enter your name : ");
      JOptionPane.showMessageDialog(null, "Hello " +name);
      
      int age = Integer.parseInt(JOptionPane.showInputDialog("How old are you? "));
      
      JOptionPane.showMessageDialog(null, "You are " +age+ " years old!");
            
      double height = Double.parseDouble(JOptionPane.showInputDialog("Enter your height:  "));
      
      JOptionPane.showMessageDialog(null, "You are " +height+ " cm!");
      
      
      
   }


}


