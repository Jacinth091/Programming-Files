import java.util.Random;

public class VariableScope {
    public static void main(String[] args) {
        // Local  = declared inside a method
        //          visible only to that method

        //Global =  declared outside a method, but within a class
        //          visible to all parts of a class

        diceRoller diceRoller = new diceRoller();



    }
}
// Variables are declared Locally and being passed through as arguments
/*class diceRoller{
    diceRoller(){
        Random random = new Random();
        int number  = 0;
        roll(random, number);
    }
    void roll(Random random, int number){
        number = random.nextInt(6)+1;
        System.out.println(number);
    }
}*/

// random and number variables are declared globally inside but within the class
class diceRoller{

    Random random;
    int number;
    diceRoller(){
        random = new Random();
        roll();
    }
    void roll(){
        number = random.nextInt(6)+1;
        System.out.println(number);
    }
}
