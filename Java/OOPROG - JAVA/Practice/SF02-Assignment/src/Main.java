/*
   Name: Barral, Jacinth Cedric C.
   Date: November 11, 2024
   Description: You are required to design and implement a simulation that models the movement behavior of different animals using interfaces and abstract classes. Specifically:

    Define an interface called Movable with a method doMove(), which will be implemented by different movement behaviors for each animal.

    Define an abstract class called Animal that contains:
    Two properties: species and breed.
    A Movable type field that holds the movement behavior of the animal.
    A method move() that prints the species name and invokes the movement behavior.
    Create different animals in the Main class:
    Use anonymous inner classes or lambda expressions to define the movement behavior for each animal (e.g., walking for a dog, swimming for a fish, crawling for a turtle).
    The move() method of each animal should be called to simulate and display the behavior.

 */
public class Main {

    public static void main(String[] args){

        Animal[] animals = {
                new Animal("Dog", "German Shepherd", "walking", (movement) -> System.out.println(movement)) {},
                new Animal("Cat", "Bengal", "walking", (movement) -> System.out.println(movement)) {},
                new Animal("Fish", "Koi", "swimming", (movement) -> System.out.println(movement)) {},
                new Animal("Shark", "Great White Shark", "swimming", (movement) -> System.out.println(movement)) {},
                new Animal("Turtle", "Green Sea Turtle", "crawling", (movement) -> System.out.println(movement)) {},
                new Animal("Fish", "Goldfish", "swimming",new Movable() {
                    @Override
                    public void doMove(String movement) {
                        System.out.println(movement);
                    }
                }) {},

                new Animal("Snake", "Python", "slithering",new Movable() {
                    @Override
                    public void doMove(String movement) {
                        System.out.println(movement);
                    }
                }) {},

                new Animal("Bird", "Bald Eagle", "flying", new Movable() {
                    @Override
                    public void doMove(String movement) {
                        System.out.println(movement);
                    }
                }) {},

                new Animal("Cat", "Siamese", "walking",new Movable() {
                    @Override
                    public void doMove(String movement) {
                        System.out.println(movement);
                    }
                }) {},

                new Animal("Dog", "Dachshund", "walking", new Movable() {
                    @Override
                    public void doMove(String movement) {
                        System.out.println(movement);
                    }
                }) {}
        };

        for(Animal animal : animals){
            animal.move();
//            System.out.println();
        }
    }





}
