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

import java.util.Arrays;
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
        System.out.println();


//        System.out.println("\n");

        for(Sandwich sw : sandwiches){
            String[] getToppings = sw.getMultToppings();
            switch(sw.getIndicator()){
                case 1:
                System.out.println("Normal Sandwich");
                    break;
                case 2:
                    System.out.println("Multiple Toppings Sandwich");
                    break;
                case 3:
                    System.out.println("Normal but Layered Sandwich");
                    break;
                case 4:
                    System.out.println("Multiple Toppings and Layered Sandwich");
                    break;
            }
            if(sw.getIndicator() != 2 && sw.getIndicator() != 4){
                System.out.printf("%d Layered Sandwich, with %s Bread, %s Meat, %s Topping, and %s Sauce.\n", sw.getLayers(), sw.getBread(), sw.getMeat(), sw.getToppings(), sw.getSauce());
            }
            else{

                StringBuilder userToppings = new StringBuilder();
                for(int j = 0; j < getToppings.length; j++){
                    userToppings.append(getToppings[j]);
                    if(j < getToppings.length - 2){
                        userToppings.append(", ");
                    }
                    else if(j == getToppings.length -2 ){
                        userToppings.append(" and ");
                    }
                }
//                System.out.printf("User Toppings: %s\n", userToppings);
                System.out.printf("%d Layered Sandwich, with %s Bread, %s Meat, %s Toppings, and %s Sauce.\n", sw.getLayers(), sw.getBread(), sw.getMeat(), userToppings, sw.getSauce());

            }

        }

//        displayHeader();
        
        







        









        

    }
    static void displayHeader(){
        System.out.print("\n**********************************************************************************\n");
        System.out.printf("%-15s  %s\n", " ", "Overloaded Constructors, Setters and Getters");
        System.out.printf("%-26s  %s\n", " ", "Barral, Jacinth Cedric C.");
        System.out.printf("%-33s  %s\n", " ", "Activity 12");
        System.out.print("**********************************************************************************\n");
    }
    static void initItems(Sandwich[] sandwich, Random rand ,String[][] ingred, int noOfSandwiches){

        int min = 0, max = ingred.length;
        int[] randItems;
        for(int i =0; i < noOfSandwiches; i++){
            int randGen = rand.nextInt(4)+1;

            System.out.printf("%d: ", randGen);
            
            String bread = ingred[0][rand.nextInt(ingred[0].length)];
            String meat = ingred[1][rand.nextInt(ingred[1].length)];
            String topping = ingred[2][rand.nextInt(ingred[2].length)];
            String sauce = ingred[3][rand.nextInt(ingred[3].length)];
            int noOfLayers = rand.nextInt((4-2)+1)+2;
            int noOfToppings = rand.nextInt((4-2)+1)+2;
            String[] multToppings = new String[noOfToppings];

            switch(randGen){
                case 1:
                    System.out.println("Normal Sandwich");
                    sandwich[i] = new Sandwich(bread, meat, topping, sauce, randGen);
                    break;
                case 2:
                    System.out.println("Multiple Toppings Sandwich");
                    System.out.printf("No Of Toppings: %d\n", noOfToppings);
                    randItems = determineUniqueRandNum(ingred, rand, noOfToppings);
                    for(int j =0; j < noOfToppings; j++){
                        multToppings[j] = ingred[2][randItems[j]];
                    }
                    System.out.println();
                    sandwich[i] = new Sandwich(bread, meat, multToppings, sauce, noOfToppings, randGen);

                    break;
                case 3:
                    System.out.println("Normal but Layered Sandwich");

                    sandwich[i] = new Sandwich(bread, meat, topping, sauce, noOfLayers, randGen);

                    break;
                case 4:
                    System.out.println("Multiple Toppings and Layered Sandwich");
                    System.out.printf("No Of Toppings: %d\n", noOfToppings);

                    randItems = determineUniqueRandNum(ingred, rand, noOfToppings);
                    for(int j =0; j < noOfToppings; j++){
                        multToppings[j] = ingred[2][randItems[j]];
                    }

                    sandwich[i] = new Sandwich(bread, meat, multToppings, sauce, noOfToppings, noOfLayers, randGen);
                    break;
                default:
                    System.out.println("Catastrophc Failure!");
                    break;
            }


        }



    }
    static int[] determineUniqueRandNum(String[][] ingred, Random rand,int noOfToppings){
        int[] randItems = new int[noOfToppings];
        int count = 0;
        while(count < noOfToppings){
            int randNum = rand.nextInt(ingred[2].length);
            boolean isUnique = true;
            for(int j =0; j < count; j++){
                if(randItems[j] == randNum){
                    isUnique = false;
                    break;
                }
            }
            if(isUnique) {
                randItems[count++] = randNum;
            }

        }

        return randItems;
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
    private int indicator;

    Sandwich(){
        
    }
    Sandwich(String bread, String meat, String topping, String sauce, int indicator){
        this.setBread(bread);
        this.setMeat(meat);
        this.setToppings(topping);
        this.setSauce(sauce);
        this.setIndicator(indicator);
    }
    Sandwich(String bread, String meat, String[] toppings, String sauce, int noOfToppings, int indicator){
        this.setBread(bread);
        this.setMeat(meat);
        this.setMultToppings(toppings);
        this.setSauce(sauce);
        this.setNoOfTopp(noOfToppings);
        this.setIndicator(indicator);
    }

    Sandwich(String bread, String meat, String topping, String sauce, int layers, int indicator){
        this.setBread(bread);
        this.setMeat(meat);
        this.setToppings(topping);
        this.setSauce(sauce);
        this.setLayers(layers);
        this.setIndicator(indicator);
    }
    Sandwich(String bread, String meat, String[] toppings, String sauce,int noOfToppings, int layers, int indicator){
        this.setBread(bread);
        this.setMeat(meat);
        this.setMultToppings(toppings);
        this.setNoOfTopp(noOfToppings);
        this.setSauce(sauce);
        this.setLayers(layers);
        this.setIndicator(indicator);
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

    public void setIndicator(int indicator){
        this.indicator = indicator;
    }
    public int getIndicator(){
        return this.indicator;
    }

}

