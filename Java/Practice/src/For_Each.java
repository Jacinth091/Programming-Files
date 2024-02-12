import java.lang.reflect.Array;
import java.util.ArrayList;

public class For_Each {
    public static void main(String[] args) {
        String[] colors = {"Red", "Blue", "Yellow", "Green"};

        for(String items : colors){
            System.out.println("Color: " + items);
        }
        System.out.println();
        System.out.println("ArrayList - For Each");
        System.out.println();
        ArrayList<String> shirtSize = new ArrayList<String>();

        shirtSize.add("Small");
        shirtSize.add("Medium");
        shirtSize.add("Large");
        shirtSize.add("Xtra-Large");
        shirtSize.add("Double XL");
        shirtSize.add("Triple XL");


        for(String items : shirtSize){
            System.out.println("Shirt Size: " + items);
        }
    }

}

