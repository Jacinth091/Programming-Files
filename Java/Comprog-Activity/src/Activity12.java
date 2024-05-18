/*
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

class Activity12 {
    public static void main(String[] args) {
        int noOfSandwiches = 5;
        String[][] ingred = {
                { "White", "Whole Wheat", "Rye", "Sourdough", "Multigrain", "Ciabatta", "Baguette" },
                { "Turkey", "Ham", "Chicken", "Roast Beef", "Salami", "Tuna", "Bacon" },
                { "Lettuce", "Tomato", "Onion", "Cucumber", "Olives", "Peppers", "Cheese" },
                { "Mayo", "Mustard", "Honey Mustard", "Ranch", "Chipotle", "BBQ", "Hummus" }
        };
        String[] sandwichTypes = { "Normal Sandwich", "Multiple Toppings Sandwich", "Layered Sandwich",
                "Multiple Toppings and Layered Sandwich", };

        Sandwich[] sandwiches = new Sandwich[noOfSandwiches];
        Random rand = new Random();
        Scanner in = new Scanner(System.in);

        displayHeader();
        codeDescrip(sandwichTypes);
        mainLoop(in, sandwiches, rand, ingred, sandwichTypes, noOfSandwiches);

    }

    /*---------------------------------------------- Main Logic Functions ----------------------------------------------*/

    static void mainLoop(Scanner in, Sandwich[] sandwiches, Random rand, String[][] ingred, String[] sandwichTypes, int noOfSandwiches) {
        boolean exitLoop = false;
        char choice;
        int count = 1;
        int attempts = 0;

        System.out.println();
        do {
            System.out.println("Press Y to Start, N to Stop.");
            System.out.print("---->: ");
            choice = in.next().toUpperCase().charAt(0);

            if (choice == 'Y') {
                initItems(sandwiches, rand, ingred, noOfSandwiches);
                System.out.println(
                        "*****************************************************************************************************\n");
                printByType(sandwiches, sandwichTypes);
                System.out.println(
                        "*****************************************************************************************************\n");

                attempts++;
                if (count == 10) {
                    System.out.printf("Attempts: %d\n", attempts);
                    System.out.println("You have reached the allowable limit.");
                    exitLoop = true;
                    System.out.println("Thank you for using the program! :D");
                }
            } else if (choice == 'N') {
                exitLoop = true;
                System.out.println("Thank you for using the program! :D");
            } else {
                System.out.println("\nInvalid Input, try again!\n");
                continue;
            }

            count++;
        } while (!exitLoop);
    }

    static void initItems(Sandwich[] sandwich, Random rand, String[][] ingred, int noOfSandwiches) {
        int[] randItems;
        for (int i = 0; i < noOfSandwiches; i++) {
            int randGen = rand.nextInt(4) + 1;
            String bread = ingred[0][rand.nextInt(ingred[0].length)];
            String meat = ingred[1][rand.nextInt(ingred[1].length)];
            String topping = ingred[2][rand.nextInt(ingred[2].length)];
            String sauce = ingred[3][rand.nextInt(ingred[3].length)];
            int noOfLayers = rand.nextInt((4 - 2) + 1) + 2;
            int noOfToppings = rand.nextInt((4 - 2) + 1) + 2;
            String[] multToppings = new String[noOfToppings];

            switch (randGen) {
                case 1:
                    // If the indicator is 1 it means it is a "Normal Sandwich"
                    sandwich[i] = new Sandwich(bread, meat, topping, sauce, randGen);
                    break;
                case 2:
                    // If the indicator is 2 it means it is a "Multi-Toppings Sandwich"
                    // Determine the unique random numbers in order to identify unique toppings
                    randItems = determineUniqueRandNum(ingred, rand, noOfToppings);
                    for (int j = 0; j < noOfToppings; j++) {
                        // getting the toppings based on the unique set "RandItems" and determining what
                        // topping corresponds to it
                        multToppings[j] = ingred[2][randItems[j]];
                    }
                    sandwich[i] = new Sandwich(bread, meat, multToppings, sauce, noOfToppings, randGen);

                    break;
                case 3:
                    // if the indicator is 3 it means it is a "Normal but Layered Sandwich"
                    // It determines the layers of the sandwich by the random number "noOfLayers"
                    sandwich[i] = new Sandwich(bread, meat, topping, sauce, noOfLayers, randGen);
                    break;
                case 4:
                    // If the indicator is 4 it means it is a "Multi-Layered and Multi-Toppings
                    // Sandwich"
                    // Determine the unique random numbers in order to identify unique toppings
                    randItems = determineUniqueRandNum(ingred, rand, noOfToppings);
                    for (int j = 0; j < noOfToppings; j++) {
                        // getting the toppings based on the unique set "RandItems" and determining what
                        // topping corresponds to it
                        multToppings[j] = ingred[2][randItems[j]];
                    }
                    // It passes the right values corresponding to a right constructor that takes
                    // the
                    // multiple toppings and the number og layers greater than 1
                    sandwich[i] = new Sandwich(bread, meat, multToppings, sauce, noOfToppings, noOfLayers, randGen);
                    break;
                default:
                    // In case something bad happens unexpectedly
                    System.out.println("Catastrophic Failure!");
                    break;
            }

        }

    }

    static int[] determineUniqueRandNum(String[][] ingred, Random rand, int noOfToppings) {
        int[] randItems = new int[noOfToppings];
        int count = 0;
        // Looping with a counter that takes the unique random numbers
        while (count < noOfToppings) {
            // Initializing a random number with a limit of ingred[2] items
            int randNum = rand.nextInt(ingred[2].length);
            // A boolean value to determine if the current number is unique or a repeat
            boolean isUnique = true;
            for (int j = 0; j < count; j++) {
                // Determines if the current number is unique or a repeat
                if (randItems[j] == randNum) {
                    // if it is a repeated number then, break out of this loop
                    // and restart from the main loop
                    isUnique = false;
                    break;
                }
            }
            // If it is Unique, then it is being added into "randItems"
            // whilst incrementing the count as well, in order to get all
            // the required random number
            if (isUnique) {
                randItems[count++] = randNum;
            }

        }
        // return the "randItems" items or the value
        return randItems;
    }

    /*---------------------------------------------- Print ----------------------------------------------*/
    static void printByType(Sandwich[] sandwiches, String[] sandwichTypes) {
        // Determines for each category of each sandwiches
        for (int i = 0; i < sandwichTypes.length; i++) {
            // boolean value that flags if the current category has any itmes or not
            boolean hasItems = false;
            System.out.println(
                    "-----------------------------------------------------------------------------------------------------");
            // prints the title or header of each category
            System.out.printf("%s\n\n", sandwichTypes[i]);
            for (Sandwich sw : sandwiches) {
                // it checks if the current indicator matches the current iteration
                if ((sw.getIndicator() - 1) == i) {
                    // passes the current iteration of "sw"
                    // to make sure it only prints the sandwiches in tthe current iteration of sw
                    // and its category
                    printSandwich(sw);
                    hasItems = true;
                }
            }
            // It labels any empty category "Out Of Order"
            if (!hasItems) {
                System.out.println("Out Of Order!");
            }
            System.out.println(
                    "-----------------------------------------------------------------------------------------------------");
            System.out.println();

        }
    }

    static void printSandwich(Sandwich sw) {
        // gets the toppings for the multiple toppings option
        String[] getToppings = sw.getMultToppings();
        // checks if the current indicator is in 2 or 4
        // it indicates the ones that requires "Multiple Toppings"
        if (sw.getIndicator() == 2 || sw.getIndicator() == 4) {
            // Creates a string builder to concat all toppings
            StringBuilder toppingsList = new StringBuilder();
            for (int j = 0; j < getToppings.length; j++) {
                // for every toppings in getToppings array, it will be concatenated in toppingList
                toppingsList.append(getToppings[j]);
                if (j < getToppings.length - 2) {
                    // adds a ", " separator
                    toppingsList.append(", ");
                } else if (j == getToppings.length - 2) {
                    // adds a " and " separator

                    toppingsList.append(" and ");

                }
            }
            System.out.printf("%d Layered Sandwich, with -%s- Bread, -%s- Meat, -%s- Toppings, and -%s- Sauce.\n",
                    sw.getLayers(), sw.getBread(), sw.getMeat(), toppingsList, sw.getSauce());
        } else {
            System.out.printf("%d Layered Sandwich, with -%s- Bread, -%s- Meat, -%s- Topping, and -%s- Sauce.\n",
                    sw.getLayers(), sw.getBread(), sw.getMeat(), sw.getToppings(), sw.getSauce());
        }
    }

    /*---------------------------------------------- Display ----------------------------------------------*/
    static void displayHeader() {
        System.out.print("\n**********************************************************************************\n");
        System.out.printf("%-17s  %s\n", " ", "Overloaded Constructors, Setters and Getters");
        System.out.printf("%-26s  %s\n", " ", "Barral, Jacinth Cedric C.");
        System.out.printf("%-33s  %s\n", " ", "Activity 12");
        System.out.print("**********************************************************************************\n");
    }

    static void codeDescrip(String[] sandwichTypes) {
        System.out.println("This is a Random-Generator Sandwich Maker, where each ingredients are randomly picked.");
        System.out.println("There are only FOUR Categories of sandwiches, namely:");
        int count = 1;
        for (String type : sandwichTypes) {
            System.out.printf("%-1d. %s\n", count++, type);
        }
    }

}

class Sandwich {
    private String bread;
    private String meat;
    private String topping;

    private String[] toppings;
    private String sauce;
    private int layers = 1;
    private int noOfToppings = 1;
    private int indicator;

    Sandwich() {

    }
    // For Normal Sandwich
    Sandwich(String bread, String meat, String topping, String sauce, int indicator) {
        this.setBread(bread);
        this.setMeat(meat);
        this.setToppings(topping);
        this.setSauce(sauce);
        this.setIndicator(indicator);
    }
    // For Multi-toppings Sandwich

    Sandwich(String bread, String meat, String[] toppings, String sauce, int noOfToppings, int indicator) {
        this.setBread(bread);
        this.setMeat(meat);
        this.setMultToppings(toppings);
        this.setSauce(sauce);
        this.setNoOfTopp(noOfToppings);
        this.setIndicator(indicator);
    }
    // For Normal and Layered Sandwich

    Sandwich(String bread, String meat, String topping, String sauce, int layers, int indicator) {
        this.setBread(bread);
        this.setMeat(meat);
        this.setToppings(topping);
        this.setSauce(sauce);
        this.setLayers(layers);
        this.setIndicator(indicator);
    }
    // For Multi-Layered and Multi-toppings Sandwich

    Sandwich(String bread, String meat, String[] toppings, String sauce, int noOfToppings, int layers, int indicator) {
        this.setBread(bread);
        this.setMeat(meat);
        this.setMultToppings(toppings);
        this.setNoOfTopp(noOfToppings);
        this.setSauce(sauce);
        this.setLayers(layers);
        this.setIndicator(indicator);
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public String getBread() {
        return this.bread;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public String getMeat() {
        return this.meat;
    }

    public void setToppings(String topping) {
        this.topping = topping;
    }

    public String getToppings() {
        return this.topping;
    }

    public void setMultToppings(String[] toppings) {
        this.toppings = toppings;
    }

    public String[] getMultToppings() {
        return this.toppings;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getSauce() {
        return this.sauce;
    }

    public void setLayers(int noOfLayers) {
        this.layers = noOfLayers;
    }

    public int getLayers() {
        return this.layers;
    }

    public void setNoOfTopp(int noOfToppings) {
        this.noOfToppings = noOfToppings;
    }

    public int getNoOfTopp() {
        return this.noOfToppings;
    }

    public void setIndicator(int indicator) {
        this.indicator = indicator;
    }

    public int getIndicator() {
        return this.indicator;
    }

}
