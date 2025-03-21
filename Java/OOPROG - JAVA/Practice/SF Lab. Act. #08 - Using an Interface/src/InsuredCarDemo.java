/*
   Name: Barral, Jacinth Cedric C.
   Date: October 19, 2024
   Description: SF Lab. Act. #08 - Creating an Interface

*/
import javax.swing.JOptionPane;

public class InsuredCarDemo{
   public static void main(String[] args){

      displayHeader("Creating an Interface", "Barral, Jacinth Cedric C.", "SF Lab. Act. #08", 73);

      // Event Controller (Switch)
      // getAndSetVehicleDetails function (book activity)
      mainLogic();

   }


   public static void mainLogic(){

      int code =0;
      String msg   = "Press \"Yes\" to Proceed, \"No\" to Exit program";
      int actionFlag = JOptionPane.showConfirmDialog(null, msg, "Confirm Action", JOptionPane.YES_NO_OPTION);


      do{
         code = eventCont(actionFlag);
         if(code ==0){
            getAndSetVehicleDetails();
         }


         msg = "Press \"Yes\" to Restart, \"No\" to Exit program";
         actionFlag = JOptionPane.showConfirmDialog(null, msg, "Confirm Action", JOptionPane.YES_NO_OPTION);
         code = eventCont(actionFlag);

      }while(code == JOptionPane.YES_OPTION);

      msg = "Thank you for using the program :D!";
      JOptionPane.showMessageDialog(null, msg, "Thank You <3", JOptionPane.INFORMATION_MESSAGE);
   }

   public static int eventCont(int actionFlag){
      String msg = "";
      int code =0;
      switch (actionFlag){
         case -1:
         case 1: // No
            msg = "Thank you, come again :D!";
            JOptionPane.showMessageDialog(null, msg, "Goodbye...", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
            break;
         case 0: // Yes
            code =0;
            break;
         default:
            System.out.println("Error!?");
            break;
      }
      return code;
   }
   public static String centerText(String text, int headerLineLen){
      int padding = (headerLineLen - text.length()) / 2;
      StringBuilder sb = new StringBuilder();

      for(int i =0; i < padding; i++){
         sb.append(" ");
      }
      sb.append(text);
      return sb.toString();
   }
   public static void displayHeader(String actTitle, String studName, String actNum, int lineLen){
      StringBuilder header = new StringBuilder();
//      int astCount = 73;
      StringBuilder asterisk = new StringBuilder();
      for(int i = 0; i < lineLen; i++ ){
         asterisk.append("*");
      }
      String title = centerText(actTitle, asterisk.length());
      String name = centerText(studName, asterisk.length());
      String labNum = centerText(actNum, asterisk.length());

      header.append(asterisk).append("\n")
              .append(title).append("\n")
              .append(name).append("\n")
              .append(labNum).append("\n")
              .append(asterisk);


      JOptionPane.showMessageDialog(null, header, labNum, JOptionPane.INFORMATION_MESSAGE);
   }

   public static void getAndSetVehicleDetails(){
      Vehicle[] vhs = {
              new InsuredCar(),
              new InsuredSailboat(),
              new InsuredBicycle()
//              new Sailboat(),
//              new Bicycle()
      };

      StringBuilder sb = new StringBuilder();

      for(Vehicle vh : vhs){
         sb.append(vh.toString()).append("\n");
      }

      JOptionPane.showMessageDialog(null, "Vehicle Descriptions:\n" + sb, "Vehicle Information System v1.1", JOptionPane.INFORMATION_MESSAGE);

   }
}