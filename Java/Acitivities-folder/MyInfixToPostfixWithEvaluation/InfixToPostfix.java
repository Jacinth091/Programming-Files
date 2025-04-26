
import javax.swing.JOptionPane;


public class InfixToPostfix
{
    public static void main(String[] args)
    {
        String[] mainMenu = new String[]
        {
           "Create Stack Node",
           "Exit",
        };
        
        String[] subMenu = new String[]
        {
           "Enter Expression to convert to Postfix",
           "Go Back"
        };
       
            
       int choice =0;
       boolean exitFlag =false;
       StackNode stackNode;
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
                            JOptionPane.showMessageDialog(null,"Stack Node Successfully Created", "Success", JOptionPane.INFORMATION_MESSAGE);
                            stackNode = new StackNode();
                            StringBuilder subMenuStr = getStr(subMenu, "Infix to Postfix Menu");
                            HandleQueueNodeOperations(stackNode,subMenu, subMenuStr.toString());

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

    public static String ConvertToPostFix(StackNode stackNode, String expression)
    {
        StackNode postFix = stackNode;
        String result ="";
        
        for(int i =0; i<expression.length(); i++)
        {
            
            char ch=expression.charAt(i); 
            if(ch =='(')
            {
                postFix.push(ch);
            }
            else if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch >='0' && ch<= '9')) 
            {
                result += ch;
            } 
            else if( ch == ')')
            {
                while(!postFix.isEmpty())
                {
                    if(postFix.peek().equals('('))
                    {
                        break;
                    }
                    String op = postFix.peek().toString();
                    postFix.pop();
                    result += op;
                }
                // result += postFix.peek();
                postFix.pop(); // pop '(' from stack. 

            }
            else if (ch =='+' || ch =='-' || ch == '*' || ch == '/'){
                while(postFix.getCount() > 0 && !postFix.peek().equals('(') && precedence(ch) <= precedence(postFix.peek().toString().charAt(0))) 
                {
                    String op = postFix.peek().toString();
                    postFix.pop();
                    result += op; 
                } 
                postFix.push(ch);   
            }


        }

        while(postFix.getCount() > 0)
        {
            String op = postFix.peek().toString();
            postFix.pop();
            result += op;
        }



        return result;
    }

    public static String EvaluatePostfix(StackNode stackNode, String expression)
    {
        StackNode postFix = stackNode;
        String result = "";

        for(int i =0; i<expression.length(); i++)
        {
            
            char ch=expression.charAt(i); 
            
            if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch >='0' && ch<= '9'))
            {
                postFix.push(ch);
            }
            else if(ch =='+' || ch =='-' || ch == '*' || ch == '/')
            {
                String second = postFix.peek().toString();
                postFix.pop();

                String first = postFix.peek().toString();
                postFix.pop();
                
                int valueResult = 0;

                switch(ch)
                {
                    case '+':
                    valueResult = Integer.parseInt(first) + Integer.parseInt(second);
                    break;  
                    case '-':
                    valueResult = Integer.parseInt(first) - Integer.parseInt(second);
                    break;  
                    case '*':
                    valueResult = Integer.parseInt(first) * Integer.parseInt(second);
                    break;  
                    case '/':
                    valueResult = Integer.parseInt(first) / Integer.parseInt(second);
                    break;  

                }
                postFix.push(valueResult);
            }


        }

        while(postFix.getCount() > 0)
        {
            String op = postFix.peek().toString();
            postFix.pop();
            result += op;
        }



        return result;


    }
    public static int precedence(char ch)
    {
        if(ch=='+' || ch=='-')
            return 1;

        else if(ch=='*' || ch=='/')
            return 2;

        return 0;
    }

    private static StringBuilder getStr(String[] Menu, String title) {
        StringBuilder subMenuStr = new StringBuilder();
        subMenuStr.append(String.format("===================== %s =====================\n\n", title));
        for(int i = 0; i < Menu.length; i++){
            if(i == Menu.length -1)
                subMenuStr.append(String.format("%20d.) %s", 0, Menu[i]));
            else
                subMenuStr.append(String.format("%20d.) %s\n", (i+1), Menu[i]));
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

    public static boolean HandleOperationRedirection(StackNode stackNode, int choice) throws Exception
    {
       switch(choice){
           case 1:
                String input = JOptionPane.showInputDialog(null, "Enter an expression\n", "Infix to Postfix", JOptionPane.QUESTION_MESSAGE);
                if(input == null){
                    throw new Exception("Going Back to Main Menu");
                }else if(input.isEmpty()){
                    throw new Exception("Expression cannot be Empty!");
                }
                else{
                    String postFixResult = ConvertToPostFix(stackNode, input);
                    String evaluatedResult = EvaluatePostfix(stackNode, postFixResult);
                    String res = String.format("Result Postfix \n--------> %s <--------", evaluatedResult);
                    JOptionPane.showMessageDialog(null,res, "Postfix Result", JOptionPane.INFORMATION_MESSAGE);
                }
           break;
           
           case 0:
               JOptionPane.showMessageDialog(null,"Going Back to Main Menu....", "Closing the progran", JOptionPane.WARNING_MESSAGE);
               return true;
//           break;
       }
       return false;
   }
    public static void HandleQueueNodeOperations(StackNode stackNode, String[] subMenu, String subMenuStr){
       boolean exitFlag = false;
       int choice = 0 ;
        while(!exitFlag)
        {
            try{
                String input = JOptionPane.showInputDialog(null, subMenuStr,"Infix to Postfix Menu", JOptionPane.PLAIN_MESSAGE);
                if(input == null){
                    JOptionPane.showMessageDialog(null,"Going Back to Main Menu....", "Closing the progran", JOptionPane.WARNING_MESSAGE);
                    exitFlag = true;
                    break;
                }
                else{
                    choice = ValidateDialog(input, subMenuStr, "Infix to Postfix Menu", subMenu);
                    exitFlag = HandleOperationRedirection(stackNode, choice);
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