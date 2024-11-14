/*@FunctionalInterface
interface Calculable{
    
    void calculate(int a, int b);

    
}


public class Main{
    public static void main(String[] args){
        
        int x = 20;
        int y = 30;
        
        // Calculable add = ((x, y) -> {
        //   @Override
        //   public void calculate(int x, int y){
        //       System.out.println("Result: " + (x+y));
              
        //   }
            
        // });
        
        Calculable add = (a,b) -> {
            
            System.out.println("Result: "+(a+b));
            
        };
        
        add.calculate(x,y);
        
        Calculable subtract = new Calculable(){
            @Override
            public void calculate(int x, int y){
                
                System.out.println("Result: "+(x-y));
                
            }
            
        };
        subtract.calculate(x,y);
        
    }
    
    
    
}*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

abstract class Animal{
    
    private String breed;
    private Runnable movement;
    
    public Animal(String breed, Runnable movement){
        this.breed = breed;
        this.movement = movement;
        
        
    }
    
    public void move(){
        
        movement.run();
        
    }
}

class Main{
    public static void main(String[] args){
        
        Runnable dogMove = () -> {
            
            System.out.println("Walking");
            
        };
        
        
        Animal dog = new Animal("Dog", () -> {
            
            System.out.println("Walking");
            
        }){};
        
        dog.move();
        
        
        Animal cat = new Animal("Cat", new Runnable(){
            
            @Override
            public void run(){
                System.out.println("The cat is jumping!");
                
                
            }
            
        }){};
        cat.move();
        
        List<Integer> array = new ArrayList(Arrays.asList(2,1,5,4,7,4));
        
        
        array.forEach(item -> {
            
            System.out.print(item + ", ");
            
            
        });
        
        
    }
    
    
    
}
