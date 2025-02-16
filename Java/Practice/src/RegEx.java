import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class RegEx
{
	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
        
        int num;
        String inBuffer;
        
        Pattern pattern = Pattern.compile("[0-9]");
        
        boolean isMatched;
        
        do{
            
            System.out.print("Input num: ");
            inBuffer = in.nextLine().trim();
            Matcher matcher = pattern.matcher(inBuffer);
            isMatched = matcher.find();

            if(!isMatched){
                System.out.println("\nInvalid Input, try again!\n");
                continue;
            }
            else if(inBuffer.isEmpty()){
                System.out.println("\nEmpty Input, try again!\n");
                continue;
            }
            else{
                num = Integer.parseInt(inBuffer);
                break;
            }

            
        }while(true);
        
        System.out.printf("%s\n", num + 20);
        
        
        
	}
}
