import java.util.ArrayList;
public class ArrayLIsts {
    public static void main(String[] args) {
        // ArrayList = a resizable array.
        //             elements can be added and removed after compilation phase
        //             store reference data types

        ArrayList<String> food = new ArrayList<String>();
        food.add("Pizza");
        food.add("hotdog");
        food.add("cookies");
        food.add("bread");

        food.set(0, "Sushi");
        food.remove(2);
        food.clear();

        for(int i =0; i < food.size(); i++){
            System.out.println(food.get(i));
        }

    }
}
