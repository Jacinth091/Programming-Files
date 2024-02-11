import java.util.Scanner;
public class Arrays {
    public static void main(String []args){
        Scanner input = new Scanner(System.in);
/*        // array = used to store multiple values in a single variable

        String[] desserts = {"Mango-Float", "Ice-Cream", "Fruit Salad", "Macaroni Salad" };
        
        // desserts[0] = "Snowbear";

        System.out.println(desserts[1]);*/

        // Declaration of an empty array

        String[] food = new String[3];

        System.out.println("Enter your 3 favorite foods!\n");
        for(int i = 0; i < food.length; i++){
            String userFood = "";
            System.out.print("Enter " + (i + 1) + ": " );
            userFood = input.nextLine();
            food[i] = userFood;

        }
        System.out.println();
        System.out.println("Here are your favorite foods!\n");
        for(int i = 0; i < food.length; i++){
            System.out.println("Favorite Food # " + (i + 1) + ": " + food[i] );

        }


        

    }
}
