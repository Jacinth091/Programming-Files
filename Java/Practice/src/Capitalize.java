import java.util.Scanner;
class Capitalize{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str;
        

        System.out.print("Enter a string: ");
        str = in.nextLine().trim();
        
        StringBuilder capStr = new StringBuilder(str.length());
       boolean capitalizeNext = true; // Flag to indicate whether the next character should be capitalized

        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);

            if (capitalizeNext && Character.isLetter(letter)) {
                capStr.append(Character.toUpperCase(letter));
                capitalizeNext = false;
            } else {
                capStr.append(letter);
            }

            if (Character.isWhitespace(letter)) {
                capitalizeNext = true;
            }
        }

        System.out.printf("Capitalized string: %s", capStr.toString());
        
        
    }
}
