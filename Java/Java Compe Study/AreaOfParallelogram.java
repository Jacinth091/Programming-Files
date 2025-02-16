import java.io.*;
import java.util.*;

public class AreaOfParallelogram {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int area = 0, breadth = 0, height = 0;
        
        breadth = in.nextInt();
        height = in.nextInt();
        
        
        try{
            if(breadth <= 0 || height <= 0){
                throw new Exception("Breadth and height must be positive");
            }
            else{
                area = breadth * height;
                System.out.println(area);
            }
            
            
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
}