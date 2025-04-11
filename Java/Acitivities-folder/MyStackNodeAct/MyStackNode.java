/*
   Name: Barral, Jacinth Cedric C,
   Date: March 31 2025
   Description: My Stack Node Menu

*/


package MyStackNodeAct;
import java.util.Scanner;
class MyStackNode
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      String[] mainMenu = new String[]
      {
         "Create Array",
         "Exit",
      };
      
      String[] subMenu = new String[]
      {
         "Push (Object value)",
         "Peak",
         "Pop",
         "toString",
         "Go Back"
     };
     
          
     int choice =0;
     boolean exitFlag =false;
     
     StackNode stackNode;
     
     while(!exitFlag){
         System.out.println("My Stack Node Menu\n");
                 
         for(int i =0; i < mainMenu.length; i++){
             if(i == mainMenu.length -1)
                 System.out.println("0. " + mainMenu[i]);
             else
               System.out.printf("%d. %s\n", (i+1), mainMenu[i]);
         }
         
         System.out.print("\nEnter choice: ");
         if(!in.hasNextInt()){
            System.out.println("\nInvalid Input, Integer Only!\n");
            in.nextLine();
            continue;
         }
         choice = in.nextInt();
         
         
         
         if(!getValidInput(choice, mainMenu.length, 0)){
             System.out.println("Error: Input is out of range, try again...");
             continue;
         }
         
         switch(choice){
             case 1:
               int userSize = 0;
               System.out.print("\nStack Node Created");
               stackNode = new StackNode();
               mainMenu(stackNode, subMenu, in);
             break;
             
             case 0:
                 System.out.println("Now exiting...");
                 exitFlag = true;
             break;
         }   
     }
   }
   
      public static boolean getValidInput(int input, int max, int min){
        return (input >=min && input <= max);
      }
         
       public static boolean isInputAnInt(Scanner in)
       {
         return in.hasNextInt();
       }
    


       public static void mainMenu(StackNode stackNode ,String[] array, Scanner in){
           boolean exitFlag = false;
           int choice =0;
           Object value = new Object();
           
           while(!exitFlag){
               System.out.println("\nStack Node Menu\n");
               System.out.printf("Current Stack: \n%s\n", stackNode.toString() + "\n");
               
               for(int i =0; i < array.length; i++){
                   if(i == array.length -1)
                       System.out.println("0. " + array[i]);
                   else
                       System.out.printf("%d. %s\n", (i+1), array[i]);
               }
               System.out.print("\nEnter choice: ");
               
               if(!in.hasNextInt()){
                  System.out.println("\nInvalid Input, Integer Only!\n");
                  in.nextLine();
                  continue;
               }
               choice = in.nextInt();
               
               if(!getValidInput(choice, array.length, 1) && choice != 0){
                   System.out.println("Error: Input is out of range, try again...");
                   continue;
               }
               
               in.nextLine();
               System.out.println();
               
               switch(choice){
                   case 1:
                     int userCount =0;
                     int max = 10;
                     System.out.printf("Enter how many items to push (Max :15)");
                     userCount =in.nextInt();
                     in.nextLine();
                     if(userCount + stackNode.getCount() <= max && userCount <= max)
                     {
                     
                        for(int i =0; i<userCount; i++)
                        {
                           System.out.printf("Enter Object to push #%d: ", (i+1));
                           value = in.nextLine();
                           stackNode.push(value);
                           
                        }
                     }


                     else{
                        System.out.println("Error: Size is too large!");
                     }
                   break;
                   case 2:
                     if(stackNode.peek() == null)
                     {
                        System.out.println("You are peaking nothing\n");
                     }
                     else
                     {
                        System.out.println("Peaking the stack array ==>" + stackNode.peek() +"<==.\n");
                     }
                   break;
                   
                   case 3:
                     if(!stackNode.pop())
                     {
                        System.out.println("Failed to pop an item from the stack\n");
                     }
                     else
                     {
                        System.out.println("Successfully popped an item from the stack\n");
                        System.out.printf("Current Stack: \n%s\n", stackNode.toString() + "\n");
                     }
                   
                     
                   break;
                   
                   case 4:
                     System.out.println("To String Method");
                     System.out.printf("Current Stack: \n%s\n", stackNode.toString() + "\n");
                     
                   break;
                   case 0:
                       System.out.println("Going Back to Main Menu");
                       exitFlag =true;
                   break;
               }
           }
           
           
           
       }      
}