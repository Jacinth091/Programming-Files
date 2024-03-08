import java.util.Scanner;
import java.util.Arrays;

public class arrayOfObjects {
    public static void main(String[] args) {

        // Array Of Objects
        Scanner in = new Scanner(System.in);
        String userFood = "";
        Food[] refrigerator = new Food[3];

/*        Food foodOne = new Food("Pizza");
        Food foodTwo = new Food("Hamburger");
        Food foodThree = new Food("Hotdog");*/

/*        refrigerator[0] = foodOne;
        refrigerator[1] = foodTwo;
        refrigerator[2] = foodThree;*/

        for(byte i = 0; i < refrigerator.length; i++){
            System.out.print("Input Food: ");
            userFood = in.nextLine();
            refrigerator[i] = new Food(userFood);
        }
        Arrays.sort(refrigerator);
        System.out.println("\nFood Items");
        for(byte i = 0 ; i < refrigerator.length; i++){
            System.out.println("Food Item number " + (i+1) + ": " + refrigerator[i]);
        }




    }
}
class Food implements Comparable<Food>{

    String name;
    Food(String name){
        this.name = name;
    }
    @Override
    public int compareTo(Food other){
        return this.name.compareTo(other.name);
    }

    public String toString() {
        return name;
    }


}
