/*
 PARTIAL
 Name: Barral, Jacinth Cedric C.
 Date: May 16, 2024
 Description: Using the object you have selected on our Prelim Lab.Act.#02 on Classes and Objects,
                create a class of that object and implement a constructor (not less than 2 constructors).
            Use the constructor to initialize the properties of the class (instance variables). 
            Set the class properties (instance variables) to privateCreate getters and setters for each field.
            Write a main method to instantiate the selected object,
            set values using the constructor, modify values using setters,
                and print out the values using getters.
 */

import java.util.Random;
import java.util.Scanner;
class Acitivity12 {
    public static void main(String[] args){
        int noOfSandwiches = 5;

        String[][] ingred = {
                {"White", "Whole Wheat", "Rye", "Sourdough", "Multigrain", "Ciabatta", "Baguette"},
                {"Turkey", "Ham", "Chicken", "Roast Beef", "Salami", "Tuna", "Bacon"},
                {"Lettuce", "Tomato", "Onion", "Cucumber", "Olives", "Peppers", "Cheese"},
                {"Mayo", "Mustard", "Honey Mustard", "Ranch", "Chipotle", "BBQ", "Hummus"}
        };

        Sandwich[] sandwiches = new Sandwich[noOfSandwiches];
        Random rand = new Random();
        Scanner in = new Scanner(System.in);

        initItems(sandwiches, rand,ingred, noOfSandwiches);

//        System.out.println("\n");

//        for(Sandwich sw : sandwiches){
//            System.out.printf("Bread: %s, Meat: %s, Topping: %s, Sauce: %s\n", sw.getBread(), sw.getMeat(), sw.getToppings(), sw.getSauce());
//        }\

        displayHeader();
        
        







        









        

    }
    static void displayHeader(){
        System.out.print("\n**********************************************************************************\n");
        System.out.printf("%-25s  %s\n", " ", "Overloaded Constructors, Setters and Getters");
        System.out.printf("%-26s  %s\n", " ", "Barral, Jacinth Cedric C.");
        System.out.printf("%-33s  %s\n", " ", "Activity 12");
        System.out.print("**********************************************************************************\n");
    }
    static void initItems(Sandwich[] sandwich, Random rand ,String[][] ingred, int noOfSandwiches){

        int min = 0, max = ingred.length;
        for(int i =0; i < noOfSandwiches; i++){
            
            String bread = ingred[0][rand.nextInt(ingred[0].length)];
            String meat = ingred[1][rand.nextInt(ingred[1].length)];
            String topping = ingred[2][rand.nextInt(ingred[2].length)];
            String sauce = ingred[3][rand.nextInt(ingred[3].length)];

            sandwich[i] = new Sandwich(bread, meat, topping, sauce);

//            System.out.printf("\nAt Index: %d: %s, %s, %s, %s \n",i+1, bread, meat, topping, sauce);

        }


    }
    
}
class Sandwich{
    private String bread;
    private String meat;
    private String topping;

    private String[] toppings;
    private String sauce;
    private int layers = 1;
    private int noOfToppings = 1;

    Sandwich(){
        
    }
    Sandwich(String bread, String meat, String topping, String sauce){
        this.setBread(bread);
        this.setMeat(meat);
        this.setToppings(topping);
        this.setSauce(sauce);
    }
    Sandwich(String bread, String meat, String[] toppings, String sauce, int noOfToppings){
        this.setBread(bread);
        this.setMeat(meat);
        this.setMultToppings(toppings);
        this.setSauce(sauce);
        this.setNoOfTopp(noOfToppings);
    }

    Sandwich(String bread, String meat, String topping, String sauce, int layers){
        this.setBread(bread);
        this.setMeat(meat);
        this.setToppings(topping);
        this.setSauce(sauce);
        this.setLayers(layers);
    }
    Sandwich(String bread, String meat, String[] toppings, String sauce,int noOfToppings, int layers){
        this.setBread(bread);
        this.setMeat(meat);
        this.setMultToppings(toppings);
        this.setSauce(sauce);
        this.setLayers(layers);
    }


    public void setBread(String bread){
        this.bread = bread;
    }
    public String getBread(){
        return this.bread;
    }

    public void setMeat(String meat){
        this.meat = meat;
    }
    public String getMeat(){
        return this.meat;
    }

    public void setToppings(String topping){
        this.topping = topping;
    }

    public String getToppings(){
        return this.topping;
    }

    public void setMultToppings(String[] toppings){
        this.toppings = toppings;
    }
    public String[] getMultToppings(){
        return this.toppings;
    }


    public void setSauce(String sauce){
        this.sauce = sauce;
    }
    public String getSauce(){
        return this.sauce;
    }


    public void setLayers(int noOfLayers){
        this.layers = noOfLayers;
    }
    public int getLayers(){
        return this.layers;
    }


    public void setNoOfTopp(int noOfToppings){
        this.noOfToppings = noOfToppings;
    }
    public int getNoOfTopp(){
        return this.noOfToppings;
    }

}

