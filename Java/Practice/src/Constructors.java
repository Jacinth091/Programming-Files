public class Constructors {
    public static void main(String[] args) {
        // constructor = special method that is called when an object is instantiated

        Human humanOne  = new Human("Rick", 65, 70);
        Human humanTwo  = new Human("Morty", 16, 50);



        System.out.println(humanOne.name);
        humanOne.drink();
        System.out.println(humanTwo.name);
        humanTwo.eat();



    }
}
class Human{
    String name;
    int age;
    double weight;
    Human(String name, int age, double weight){
       this.name = name;
       this.age = age;
       this.weight = weight;
    }

    void eat(){
        System.out.println(this.name + " is eating.");
    }
    void drink(){
        System.out.println(this.name + " is drinking \"burp\" ");
    }
}
