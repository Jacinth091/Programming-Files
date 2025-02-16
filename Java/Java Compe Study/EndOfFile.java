import java.io.*;
import java.util.*;

public class EndOfFile {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        int count =1;
        
        while(in.hasNext()){
            String input = in.nextLine();
            System.out.printf("%d %s\n", count++, input);
        }
        in.close();
        
    }
}