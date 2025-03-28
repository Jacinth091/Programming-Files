/*
   Name: Barral, Jacinth Cedric C,
   Date: March 28 2025
   Description: MyStackArray Partial

*/



import java.util.Scanner;
class MyStackArrayMenu
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
     
     MyStackArray myStack = new MyStackArray();
     
     while(!exitFlag){
         System.out.println("MyStackArray Menu\n");
                 
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
               while(true)
               {
                 System.out.print("\nEnter size of the Stack Array: ");
                  if(!in.hasNextInt()){
                     in.nextLine();
                     System.out.println("\nInvalid Input, Integer Only!\n");
                     continue;
                  }else{
                  
                     userSize = in.nextInt();
                     in.nextLine();
                     break;
                  }
               }
               myStack = createStackArray(userSize);
                 mainMenu(myStack, subMenu, in);
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
     
       public static MyStackArray createStackArray(int size){
       
           return new MyStackArray(size);
       }
       
       public static boolean isInputAnInt(Scanner in)
       {
         return in.hasNextInt();
       }
    


       public static void mainMenu(MyStackArray myStack ,String[] array, Scanner in){
           boolean exitFlag = false;
           int choice =0;
           Object value = new Object();
           
           while(!exitFlag){
               System.out.println("\nStack Array Menu\n");
               System.out.printf("Current Stack: \n%s\n", myStack.toString() + "\n");
               System.out.println("Current Item Count of Stack: " + myStack.getCount()+"\n");
               
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
                     System.out.printf("Enter how many items to push (%d/%d):", myStack.getCount(), myStack.getSize());
                     userCount =in.nextInt();
                     System.out.println();
                     in.nextLine();
                     if(userCount + myStack.getCount() <= myStack.getSize() && userCount <= myStack.getSize())
                     {
                        for(int i =0; i<userCount; i++)
                        {
                           System.out.printf("Enter Object to push #%d: ", (i+1));
                           value = in.nextLine();
                           myStack.push(value);
                           
                        }
                        
                     }
                     else{
                        System.out.println("Error: Size is too large!");
                     }
                   break;
                   case 2:
                     if(myStack.peak() == null)
                     {
                        System.out.println("You are peaking nothing\n");
                     }
                     else
                     {
                        System.out.println("Peaking the stack array ==>" + myStack.peak() +"<==.\n");
                     }
                   break;
                   
                   case 3:
                     if(!myStack.pop())
                     {
                        System.out.println("Failed to pop an item from the stack\n");
                     }
                     else
                     {
                        System.out.println("Successfully popped an item from the stack\n");
                        System.out.printf("Current Stack: \n%s\n", myStack.toString() + "\n");
                     }
                   
                     
                   break;
                   
                   case 4:
                   
                     System.out.printf("Current Stack: \n%s\n", myStack.toString() + "\n");
                     
                   break;
                   case 0:
                       System.out.println("Going Back to Main Menu");
                       exitFlag =true;
                   break;
               }
           }
           
           
           
       }      
}