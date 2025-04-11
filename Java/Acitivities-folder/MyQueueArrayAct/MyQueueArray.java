
import java.util.Scanner;
import javax.swing.JOptionPane;

public class MyQueueArray
{
   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      String[] mainMenu = new String[]
      {
        "Create Queue Array",
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
     
     QueueArray queueArray;
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
                        int arraySize =0;
                        input = JOptionPane.showInputDialog(null, "Input the size of the Queue Array (5 - 10)","Input Size", JOptionPane.PLAIN_MESSAGE);
                        if(input == null){
                            JOptionPane.showMessageDialog(null,"Program is closing...", "Closing the progran", JOptionPane.WARNING_MESSAGE);
                            exitFlag = true;
                            break;
                        }
                        arraySize = ValidateDialog(input);
                        if(!getValidInput(arraySize, 15, 5)){
                            throw new Exception("Input is Out of Range!");
                        }
                        else{
                            queueArray = new QueueArray(arraySize);
                            StringBuilder subMenuStr = getStr(subMenu, "Queue Array Menu");
                            HandleQueueArrayOperations(queueArray,subMenu, subMenuStr.toString());
                        }



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
        subMenuStr.append(String.format("===================== %s =====================\n\n", title));
        for(int i = 0; i < Menu.length; i++){
            if(i == Menu.length -1)
                subMenuStr.append(String.format("%5d.) %s", 0, Menu[i]));
            else
                subMenuStr.append(String.format("%5d.) %s\n", (i+1), Menu[i]));
        }
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
    
    public static int ValidateDialog(String input) throws Exception {
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

    public static boolean HandleOperationRedirection(QueueArray queueArray, int choice) throws Exception{
       switch(choice){
           case 1:
                String input = JOptionPane.showInputDialog(null, "What Item you want to Enqueue?\n", "Enqueue Method", JOptionPane.QUESTION_MESSAGE);
                if(input == null){
                    throw new Exception("Going Back to Queue Array Menu");
                }else if(input.isEmpty()){
                    throw new Exception("Item cannot be Null / Empty!");
                }
                else{
                    boolean enqueue = queueArray.enqueue(input);
                    if(enqueue){
                        String item = String.format("Successfully Enqueued \n\t---> %s <---", input);
                        JOptionPane.showMessageDialog(null, item, "Successful Operation", JOptionPane.INFORMATION_MESSAGE );
//                        queueNode.enqueue(input);
                        JOptionPane.showMessageDialog(null, queueArray.toString(), "Current Items Queued", JOptionPane.PLAIN_MESSAGE);
                        System.out.println(queueArray.toString());
                        
                    }
                    else
                    {
                        throw new Exception("There was an error enqueueing the item " + input + "...");
                    }
                }
           break;
           case 2:
            JOptionPane.showMessageDialog(null, "Dequeue the first item\n", "Dequeue Method", JOptionPane.WARNING_MESSAGE);
 
              boolean dequeue = queueArray.dequeue();
              if(dequeue){
                  String item = String.format("Successfully Dequeued the First Item\n");
                  JOptionPane.showMessageDialog(null, item, "Successful Operation", JOptionPane.INFORMATION_MESSAGE );
                  JOptionPane.showMessageDialog(null, queueArray.toString(), "Current Items Queued", JOptionPane.PLAIN_MESSAGE);
               }
               else if(queueArray.isEmpty()){
                  throw new Exception("There was an error dequeing the first item, The Queue is Empty");
               }
           break;
           case 3:
                JOptionPane.showMessageDialog(null, "Displaying All Items Queued\n", "To String Method", JOptionPane.WARNING_MESSAGE);
                if(queueArray.isEmpty()){
                    throw new Exception("The Queue is Currently Empty!");
                }
                else{
                JOptionPane.showMessageDialog(null, queueArray.toString(), "Current Items Queued", JOptionPane.PLAIN_MESSAGE);
                }

           break;
           case 0:
               JOptionPane.showMessageDialog(null,"Going Back to Main Menu....", "Closing the progran", JOptionPane.WARNING_MESSAGE);
               return true;
//           break;
       }
       return false;
   }
   public static void HandleQueueArrayOperations(QueueArray queueArray, String[] subMenu, String subMenuStr){
       boolean exitFlag = false;
       int choice = 0 ;
        while(!exitFlag)
        {
            try{
                String input = JOptionPane.showInputDialog(null, subMenuStr,"Queue Array Menu", JOptionPane.PLAIN_MESSAGE);
                if(input == null){
                    JOptionPane.showMessageDialog(null,"Going Back to Main Menu....", "Closing the progran", JOptionPane.WARNING_MESSAGE);
                    exitFlag = true;
                    break;
                }
                else{
                    choice = ValidateDialog(input, subMenuStr, "Queue Array Menu", subMenu);
                    exitFlag = HandleOperationRedirection(queueArray, choice);
                }
            }catch(Exception ex){
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