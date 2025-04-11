/*
     Name: Barral, Jacinth Cedric C.
     Date: April 5, 2025
     Description: Activity  (Parenthesis Checker)

*/

import javax.swing.JOptionPane;

public class ParenthesisChecker {
    public static void main(String[] args) {
        StackNode stackNode = new StackNode();
        StringBuilder expression = new StringBuilder();

        String outMessage = "";
        int matcherFlag;

//        System.out.print("Input: ");

        String input = JOptionPane.showInputDialog(null, "Input: ", "Parenthesis Checker", JOptionPane.PLAIN_MESSAGE);
        if(input == null){
            JOptionPane.showMessageDialog(null,"Program is closing", "Closing", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }

        for(int i =0; i< input.length(); i++){
            if(!(input.charAt(i) == ' ')){
                expression.append(input.charAt(i));
            }

        }
        matcherFlag =  AnalyzeExpression(stackNode, expression);
        outMessage = matcherFlag == 0 ? "Balanced!" :
                matcherFlag == 1 ? "Not Balanced!" : "No Parenthesis Found!";

        System.out.print("Output: " + outMessage);
        JOptionPane.showMessageDialog(null,outMessage, "Parenthesis Checker Result", JOptionPane.INFORMATION_MESSAGE);

    }
    public static int AnalyzeExpression(StackNode stackNode, StringBuilder expression)
    {
        int matched =0;
        boolean hasParenthesis = false;
        for(int i =0; i<expression.length(); i++)
        {
            char currentChar = expression.charAt(i);
            if(currentChar == '(' || currentChar == ')'){
                hasParenthesis = true;
                if( currentChar == '('){
                    stackNode.push(currentChar);
                }
                else if(currentChar == ')')
                {
                    if(!stackNode.isEmpty())
                    {
                        stackNode.pop();
                        matched++;
                    }
                    else{
                        return 1;
                    }
                }
            }
        }

        if(!hasParenthesis){
            return -1;
        }
        else if(stackNode.isEmpty()){
            return 0;
        }
        else {
            return 1;
        }
    }
}
