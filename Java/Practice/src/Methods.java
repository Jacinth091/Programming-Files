public class Methods {
    // Void Methods
/*    public static void main(String[] args) {
         // METHODS -  a block of code that is executed whenever it is called upon
        String name = "Jacinth";
        int age = 20;
        hello();
        user(name, age );
    }

    static void hello(){
        System.out.print("Hello");
    }
    static void user(String name, int age){
        System.out.println(", " + name + "!");
        System.out.println("You are " + age + "years old!");
    }*/


    // Return Methods
    public static void main(String[] args) {
        int x = 20;
        int y =12;

        System.out.println("Result: " + addNumbers(x, y));
    }
    static int addNumbers(int x, int y){
        return x+y;
    }
}
