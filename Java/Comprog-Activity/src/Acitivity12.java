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
class Acitivity12 {
    public static void main(String[] args){
        int noOfSandwiches = 5;
        Sandwich[] sandwiches = new Sandwich[noOfSandwiches];
        Random rand = new Random();

        initItems(sandwiches, rand, noOfSandwiches);


        









        

    }
    static void initItems(Sandwich[] sandwich, Random rand,int noOfSandwiches){
        Storage storage = new Storage();
        int min = 0;
        for(int i=0; i < noOfSandwiches; i++){
            int random = rand.nextInt(noOfSandwiches) + min;
            System.out.printf("%d\n",rand);
            // sandwich[i] = new Sandwich(storage.breads[]);
        }


    }
    
}
class Storage{

    String[] breads = {"White", "Whole Wheat", "Rye", "Sourdough", "Multigrain", "Ciabatta", "Baguette"};
    String[] meats = {"Turkey", "Ham", "Chicken", "Roast Beef", "Salami", "Tuna", "Bacon"};
    String[] toppings = {"Lettuce", "Tomato", "Onion", "Cucumber", "Olives", "Peppers", "Cheese"};
    String[] sauces = {"Mayo", "Mustard", "Honey Mustard", "Ranch", "Chipotle", "BBQ", "Hummus"};

    String[] menu = {"Create Your Own Sandwich", "View Sandwiches (Pre-Created)"};

}


class Sandwich{
    private String bread;
    private String meat;
    private String toppings;
    private String sauce;
    private int layers;
    private int noOfToppings;

    Sandwich(){
        
    }
    Sandwich(String bread, String meat, String toppings, String sauce){
        this.setBread(bread);
        this.setMeat(meat);
        this.setToppings(toppings);
        this.setSauce(sauce);
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


    public void setToppings(String toppings){
        this.toppings = toppings;
    }
    public String getToppings(){
        return this.bread;
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

