import java.util.ArrayList;

public class ArrayLists_Multi_Dimensional {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> shoppingCart = new ArrayList<ArrayList<String>>();

        ArrayList<String> bread = new ArrayList<String>();
        bread.add("Dairy-Free");
        bread.add("White-Bread");
        bread.add("Wheat Bread");

        ArrayList<String> meat = new ArrayList<String>();
        meat.add("Chicken");
        meat.add("Beef");
        meat.add("Pork");

        ArrayList<String> drinks = new ArrayList<String>();
        drinks.add("Soda");
        drinks.add("Juice");
        drinks.add("Water");

        shoppingCart.add(bread);
        shoppingCart.add(meat);
        shoppingCart.add(drinks);

        System.out.println(shoppingCart);


    }
}
