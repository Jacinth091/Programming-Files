/*
 * Barral. Jacinth Cedric C.
 * May 9 202h
 * Datastruct
*/
import java.util.Scanner;
import javax.swing.JOptionPane;

public class MyQueueNode
{
   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      String[] mainMenu = new String[]
      {
         "Create Queue Node",
         "Exit",
      };
      
      String[] subMenu = new String[]
      {
         "Enqueue (Add Items Only Integer)",
         "Dequeue (Remove First Item in Queue)",
         "Display Queue (Display All Items In the Queue)",
         "Destroy Queue (Destroy All Items In the Queue)",
         "Go Back To Main Menu"
     };
     
          
     int choice =0;
     boolean exitFlag =false;
     
     QueueNode queueNode;

     StringBuilder menuStr = getStr(mainMenu, "Main Menu");
       while(!exitFlag){
           try
           {
               String input = JOptionPane.showInputDialog(null, menuStr,"Main Menu", JOptionPane.PLAIN_MESSAGE);
               if(input == null){
                   JOptionPane.showMessageDialog(null,"Program is closing...", "Closing the progran", JOptionPane.WARNING_MESSAGE);
                   exitFlag = true;
                   break;
               }
               else{
                   choice = ValidateDialog(input,menuStr.toString(), "Main Menu", mainMenu);
                   switch(choice){
                       case 1:
                           JOptionPane.showMessageDialog(null,"Queue Node Successfully Created", "Success", JOptionPane.INFORMATION_MESSAGE);
                           queueNode = new QueueNode();
                           StringBuilder subMenuStr = getStr(subMenu, "Queue Node Menu");
                           HandleQueueNodeOperations(queueNode,subMenu, subMenuStr.toString());

                           break;
                       case 0:
                           JOptionPane.showMessageDialog(null,"Program is closing...", "Closing the progran", JOptionPane.WARNING_MESSAGE);
                           System.out.println("Now exiting...");
                           exitFlag = true;
                           break;
                   }
               }
           }
           catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
           }
       }
   }

    private static StringBuilder getStr(String[] Menu, String title) {
        StringBuilder subMenuStr = new StringBuilder();
        subMenuStr.append(String.format("==============================================\n"));
        subMenuStr.append(String.format("Developed By: Barral, Jacinth Cedric C.\n"));
        subMenuStr.append(String.format("==============================================\n"));
        subMenuStr.append(String.format("%s:\n", title));
        for(int i = 0; i < Menu.length; i++){
            if(i == Menu.length -1)
                subMenuStr.append(String.format("%10d.) %s", 0, Menu[i]));
            else
                subMenuStr.append(String.format("%10d.) %s\n", (i+1), Menu[i]));
        }
        subMenuStr.append(String.format("\n==============================================", title));
        return subMenuStr;
    }
    
    public static int ValidateDialog(String input, String dialogStr, String dialogTitle, String[] dialogArray) throws Exception {
       int choice = 0;
       if (input.isEmpty()) {
           throw new Exception("You must input a value!, Try again");
       } else {
           choice = ValidateInput(input);
           if (choice == -1) {
               throw new Exception("Invalid Input!, Try Again");
           } else {
               if (!getValidInput(choice, dialogArray.length - 1, 0)) {
                   throw new Exception("Input is out of range, try again...");
               }
           }
       }
       return choice;
   }
    public static int ValidateDialog(String input, String dialogStr, String dialogTitle) throws Exception {
        int choice = 0;
        if (input.isEmpty()) {
            throw new Exception("You must input a value!, Try again");
        } else {
            choice = ValidateInput(input);
            if (choice == -1) {
                throw new Exception("Invalid Input!, Try Again");
            }
        }
        return choice;
    }

    public static boolean HandleOperationRedirection(QueueNode queueNode, int choice) throws Exception
    {
       switch(choice){
           case 1:
                String input = JOptionPane.showInputDialog(null, "What Item you want to Enqueue?\n", "Enqueue Method", JOptionPane.QUESTION_MESSAGE);
                if(input == null){
                    throw new Exception("Going Back to Queue Node Menu");
                }else if(input.isEmpty()){
                    throw new Exception("Item cannot be Null / Empty!");
                }
                else{

                    int numInput = Integer.parseInt(input);

                    if(queueNode.searchQueue(input)){
                        throw new Exception("This item => " + input.toString() + " <= is already in the Queue.");
                    }

                    boolean enqueue = queueNode.enqueue(numInput);
                    if(enqueue){
                        String item = String.format("Successfully Enqueued \n\t---> %s <---", input);
                        JOptionPane.showMessageDialog(null, item, "Successful Operation", JOptionPane.INFORMATION_MESSAGE );
//                        queueNode.enqueue(input);
                        JOptionPane.showMessageDialog(null, queueNode.toString(), "Current Items Queued", JOptionPane.PLAIN_MESSAGE);
                        System.out.println(queueNode.toString());
                        
                    }
                    else
                    {
                        throw new Exception("There was an error enqueueing the item " + input + "...");
                    }
                }
           break;
           case 2:
            JOptionPane.showMessageDialog(null, "Dequeue the first item\n", "Dequeue Method", JOptionPane.WARNING_MESSAGE);
 
              boolean dequeue = queueNode.dequeue();
              if(dequeue){
                  String item = String.format("Successfully Dequeued the First Item\n");
                  JOptionPane.showMessageDialog(null, item, "Successful Operation", JOptionPane.INFORMATION_MESSAGE );
                  JOptionPane.showMessageDialog(null, queueNode.toString(), "Current Items Queued", JOptionPane.PLAIN_MESSAGE);
               }
               else if(queueNode.isEmpty()){
                    throw new Exception("The Queue is Currently Empty!");
               }
           break;
           case 3:
                JOptionPane.showMessageDialog(null, "Displaying All Items Queued\n", "To String Method", JOptionPane.WARNING_MESSAGE);
                if(queueNode.isEmpty()){
                    throw new Exception("The Queue is Currently Empty!");
                }
                else{
                JOptionPane.showMessageDialog(null, "Current Queue: => " + queueNode.toString(), "Current Items Queued", JOptionPane.PLAIN_MESSAGE);
                }

           break;
           case 4:
           JOptionPane.showMessageDialog(null, "Destroying Current Items Queued\n", "Destroy Queue Method", JOptionPane.WARNING_MESSAGE);
           if(queueNode.isEmpty()){
               throw new Exception("The Queue is Currently Empty!");
           }
           else if(queueNode.destroyQueue()){
                JOptionPane.showMessageDialog(null, "Successfully Destroyed Queue Items", "Destroy Queue Items", JOptionPane.INFORMATION_MESSAGE);
           }

            break;
           case 0:
               JOptionPane.showMessageDialog(null,"Going Back to Main Menu....", "Closing the progran", JOptionPane.WARNING_MESSAGE);
               return true;
//           break;
       }
       return false;
   }
   public static void HandleQueueNodeOperations(QueueNode queueNode, String[] subMenu, String subMenuStr){
       boolean exitFlag = false;
       int choice = 0 ;
        while(!exitFlag)
        {
            try{
                String input = JOptionPane.showInputDialog(null, subMenuStr,"Queue Node Menu", JOptionPane.PLAIN_MESSAGE);
                if(input == null){
                    JOptionPane.showMessageDialog(null,"Going Back to Main Menu....", "Closing the progran", JOptionPane.WARNING_MESSAGE);
                    exitFlag = true;
                    break;
                }
                else{
                    choice = ValidateDialog(input, subMenuStr, "Queue Node Menu", subMenu);
                    exitFlag = HandleOperationRedirection(queueNode, choice);
                }

            }catch(NumberFormatException numEx){
                JOptionPane.showMessageDialog(null, "Input Only Integers, try again.\n" + numEx.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
   }

    public static boolean getValidInput(int input, int max, int min){
        return (input >=min && input <= max);
    }

   public static int ValidateInput(String input) {
      int validInput;
      try {
         validInput = Integer.parseInt(input);
      }
      catch (NumberFormatException e) {
            validInput = -1;
      }

      return validInput;

   }
}