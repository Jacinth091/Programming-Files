import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;



public class ArrayLists_Multi_Dimensional {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int max = 3;
        ArrayList<ArrayList<String>> shoppingCart = new ArrayList<ArrayList<String>>();
        ArrayList<String> bread = new ArrayList<String>();
        ArrayList<String> meat = new ArrayList<String>();
        ArrayList<String> drinks = new ArrayList<String>();


        for(byte i = 0; i < max; i++ ){
//            System.out.print("Bread: ");
            String userResponse = "bread " + (i+1);
            bread.add(i, userResponse);
            if(bread.size() == max){
                shoppingCart.add(bread);
                break;
            }

        }
        for(byte i = 0; i < max; i++ ){
//            System.out.print("Meat: ");
            String userResponse = "meat " + (i+1);
            meat.add(i, userResponse);
            if(meat.size() == max){
                shoppingCart.add(meat);
                break;
            }
        }
        for(byte i = 0; i < max; i++ ){
//            System.out.print("Drinks: ");
            String userResponse = "drink " + (i+1);
            drinks.add(i, userResponse);
            if(drinks.size() == max){
                shoppingCart.add(drinks);
                break;
            }
        }

        System.out.println("Cart Items: \n");
        for(byte i = 0; i < shoppingCart.size(); i++ ){
            String[] title = {"Bread", "Meat", "Drinks"};
/*            System.out.printf("%s: %s\n",title[i], shoppingCart.get(i));*/
            System.out.printf("%s: ", title[i]);
            for(byte j = 0; j < shoppingCart.get(i).size(); j++){
                System.out.printf("%s", shoppingCart.get(i).get(j));
                if(j < shoppingCart.size() - 1){
                    System.out.print(", ");
                }
            }

            System.out.println();



        }

    }
}
