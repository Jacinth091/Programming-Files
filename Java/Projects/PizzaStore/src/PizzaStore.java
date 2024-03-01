import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;


public class PizzaStore {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] breadArr = {"Gluten-Free", "French", "New York Style", "Neopolitan", "Sourdough"};
        String[] cheeseArr = {"Mozzarella", "Provolone", "Fontina", "Muenster", "Cheddar"};
        String[] sauceArr = {"Marinara", "Pesto", "Alfredo", "Spicy Red", "Barbeque"};
        String[] toppingArr = {"Pepperoni", "Supreme", "Barbeque", "Hawaiian", "Capriccosa"};

        String title = "";

        char choice;
        boolean isDone;


        System.out.println("\n\n---------------------- Pizza Store ----------------------\n\n");

        do{
            System.out.print("Start the Game? (Y/N): ");
            choice = in.next().charAt(0);
            choice = Character.toUpperCase(choice);

            if(choice == 'N'){
                break;
            }

        }while(choice == 'Y');
        System.out.println("Bye!!");



    }
    void userFunc(String[] array, String title){
        for(byte i= 0; i < array.length; i++){
            System.out.println("  " + (i+1) + ": " + array[i] + title);
        }
    }
}

class Pizza
{
    String bread, cheese, sauce, toppings;
    Random random = new Random();
    byte rand = (byte) (random.nextInt(6)+1);

    Pizza(String bread){
        this.bread = bread;
    }
    Pizza(String bread, String sauce){

    }
    Pizza(String bread, String cheese, String sauce){
        this.bread = bread;
    }
    Pizza(String bread, String cheese, String sauce, String toopings){
        this.bread = bread;
    }

}
