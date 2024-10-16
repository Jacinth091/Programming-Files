/*
   Name: Barral, Jacinth Cedric C.
   Date: October 14, 2024
   Description: SF Lab. Act. #07 - Creating an Abstract Class

*/

import javax.swing.JOptionPane;

public class Main{
   public static void main(String[] args){
      Vehicle[] vhs = {
              new Sailboat(),
              new Bicycle()
      };
/*
      StringBuilder sb = new StringBuilder();

      for(Vehicle vh : vhs){
         sb.append(vh.toString() + "\n");
      }*/

      String sb = "";

      for(Vehicle vh : vhs){
         sb += (vh.toString() + "\n");
      }

      JOptionPane.showMessageDialog(null, "\nVehicle Descriptions:\n" +
                                           sb);
   }
   

}