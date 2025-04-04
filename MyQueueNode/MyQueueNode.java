import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.util.Scanner;

class MyQueueNode
{
   public static void main(String[] args)
   {
      // JFrame frame = new Jframe(); 
      Scanner in = new Scanner(System.in);
      String[] mainMenu = new String[]
      {
         "Create Queue Node",
         "Exit",
      };
      
      String[] subMenu = new String[]
      {
         "Enqueue",
         "Dequeue",
         "toString",
         "Go Back"
     };
     
          
     int choice =0;
     boolean exitFlag =false;
     
     QueueNode queueNode;
     StringBuilder sb = new StringBuilder();
     for(int i =0; i < mainMenu.length; i++){
       if(i == mainMenu.length -1)
           sb.append(String.format("0. " + mainMenu[i]));
       else
         sb.append(String.format("%d. %s\n", (i+1), mainMenu[i]));
      }
       while(!exitFlag){
         String input = JOptionPane.showInputDialog(null,sb,"Main Menu",JOptionPane.PLAIN_MESSAGE);
         if(input == null)
         {
            JOptionPane.showMessageDialog(null,"Program is closing...", "Closing the progran", JOptionPane.WARNING_MESSAGE);
            exitFlag = true;
            break;
         }   
         else
         {
         choice = ValidateInput(input);  
         if(!getValidInput(choice, mainMenu.length, 1)){
            JOptionPane.showMessageDialog(null,"Error: Input is out of range, try again...", "Warning", JOptionPane.ERROR_MESSAGE);
             continue;
           }

         JOptionPane.showMessageDialog(null, choice);  

         switch(choice){
                case 1:
                  JOptionPane.showMessageDialog(null,"Queue Node Successfully Created", "Success", JOptionPane.INFORMATION_MESSAGE);
                break;
                
                case 0:
                    System.out.println("Now exiting...");
                    exitFlag = true;
                break;
            }  
          }         
      }

   }
    public static boolean getValidInput(int input, int max, int min){
        return (input >=min && input <= max);
      }
         
   public static int ValidateInput(String input)
   {
      int validInput;
      try {
         validInput = Integer.parseInt(input);
      }
      catch (NumberFormatException e) {
         validInput = -2;
      }
      
      return validInput;
      
   }       
}