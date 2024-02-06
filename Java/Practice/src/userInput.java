import java.util.Scanner;

public class userInput {
    
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name? ");
        String name = scanner.nextLine();
        System.out.println("How old are you? ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("What is you Favorite Dessert? ");
        String favFood = scanner.nextLine();


        System.out.println("Hello!, " +name);
        System.out.println("You are " +age + " years old!");
        System.out.println("Your Favorite Dessert is " +favFood);



    }
}
