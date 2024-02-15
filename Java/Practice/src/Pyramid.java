import java.util.Scanner;
public class Pyramid{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        int rows = 7, cols = 5;
        String symbol = "";
        
        
        for(int i = 0; i < rows; i++)
        {
            
            for(int s = 1; s <= rows - i; s++){
                System.out.print(" ");
            }
            
            for(int j = 1; j <= i * 2 + 1;  j++)
            {
                System.out.print("*");      
                
            }
            System.out.println();

        }        
        
        
    }
}