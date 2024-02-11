import java.util.Scanner;
public class Strings {
    public static void main(String[] args){
        // String = a reference data type that can stpre one or more characters
        //           reference data types have access to useful methods
        Scanner input = new Scanner(System.in);

        String userName = "Jacinth";

        boolean result = userName.equals("JAcinth");
        // equals() method checks if it is equal or the same

//        boolean result = userName.equalsIgnoreCase("JacinTh");
        // equalsIgnoreCase() method ignores any iteration of the defined string

//        int result = userName.length();
        // length() will return the length of the defined variable

//        char result = userName.charAt(0);
        // charAt() will return the character at the index to which you specified

//        int result = userName.indexOf("n");
        // indexOf() will return the index of the character

//        boolean result = userName.isEmpty();
        // isEmpty() will return true or false regarding if the variabel is empty or not

//        String result = userName.toUpperCase();
        // toUpperCase() will return the Upper case version of the string

//        String result = userName.toLowerCase();
        // toLowerCase() will return the Lower case version of the string

//        String result = userName.trim();
        // trim() method will remove any unwanted spaces in the string
        // before and after the opposite enpoints of the string

//        String result = userName.replace("c", "s");
        // replace() method will replace the specified character with another

        System.out.println(result);

    }
}
