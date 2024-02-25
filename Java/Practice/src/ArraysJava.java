import java.util.Scanner;
import java.util.Arrays;
class ArraysJava{
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("How many students are there in your class? Input here: ");
        String[] arrOfStudents = new String[Integer.parseInt(in.nextLine())];
        // in.nextLine();
        
        
        System.out.println("Please input the name of the students here: ");
        
        for(int i = 0;  i < arrOfStudents.length; i++ ){
            
            arrOfStudents[i] = in.nextLine();
        }
        Arrays.sort(arrOfStudents);
        System.out.println("\nHere are the students in alphabetical order: \n");
        
        for(int i = 0; i < arrOfStudents.length; i++){
            System.out.printf("%d. %s\n\n", (i + 1), arrOfStudents[i]);
        }
        
        
        
    }
}