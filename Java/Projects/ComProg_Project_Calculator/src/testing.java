/*
import javax.swing.*;
import java.util.Scanner;
class testing{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int userIn, temp;
        boolean isNegative;
        String userInSTR, tempSTR;

        System.out.print("Enter Number: ");
        userIn = in.nextInt();
        in.nextLine();

        userInSTR = String.valueOf(userIn);

        isNegative = userInSTR.contains("-");




        System.out.printf("%s", userInSTR);


    }
}*/
import javax.swing.*;

public class testing {
    public static void main(String[] args) {
        // Create JFrame and JTextField
        JFrame frame = new JFrame("Number Converter");
        JTextField textField = new JTextField(10);

        // Add JTextField to JFrame
        frame.getContentPane().add(textField);
        frame.pack();
        frame.setVisible(true);

        // Wait for user to input a number
        JOptionPane.showMessageDialog(frame, "Enter a number and press OK");

        // Get input from JTextField
        String input = textField.getText();

        // Check if the input is negative
        boolean isNegative = input.startsWith("-");

        // Remove negative sign if present and limit input to maximum 7 characters
        if (isNegative) {
            input = input.substring(1); // Remove negative sign
            input = input.substring(0, Math.min(input.length(), 7)); // Limit to maximum 7 characters
        } else {
            input = input.substring(0, Math.min(input.length(), 7)); // Limit to maximum 7 characters
        }

        // Convert input string to integer
        int num = Integer.parseInt(input);

        // Proceed with conversion logic as before
        int positiveNum = Math.abs(num); // Convert to positive number

        // Perform your desired conversion here, for example, let's convert to hexadecimal
        String convertedString = Integer.toHexString(positiveNum);

        // Convert the result back to integer if needed
        int convertedNum = Integer.parseInt(convertedString, 16);

        // Reattach the negative sign if the original number was negative
        int result = isNegative ? -convertedNum : convertedNum;

        // Display result
        JOptionPane.showMessageDialog(frame, "Original number: " + num + "\nConverted number: " + result);

        // Close JFrame
        frame.dispose();
    }
}
