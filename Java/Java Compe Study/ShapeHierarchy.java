import java.util.Scanner;

class Main{
   public static void main(String[] args){
      
      Scanner in = new Scanner(System.in);
      
      Shape circle = new Circle();
      Shape rect = new Rectangle();
      Shape tria = new Triangle();
      
      
      
      System.out.println("Enter shape type (Circle/Rectangle/Triangle): ");
      String input = in.nextLine().toUpperCase().trim();
      
      switch(input){
         case "CIRCLE":
            System.out.println("Enter radius: ");
            double rad = in.nextDouble();
            System.out.printf("%.2f\n", circle.calculate(rad));
         break;
         case "RECTANGLE":
            System.out.println("Enter length: ");
            double length = in.nextDouble();
            
            System.out.println("Enter height: ");
            double height = in.nextDouble();
            System.out.printf("%.2f\n", rect.calculate(length, height));
         break;
         case "TRIANGLE":
            System.out.println("Enter Base: ");
            double base = in.nextDouble();
            
            System.out.println("Enter height: ");
            double h = in.nextDouble();
            System.out.printf("%.2f\n", tria.calculate(base, h));
         break;
            
         default:
            break;
      
      }
   
   }
 

}

abstract class Shape{

   abstract double calculate(double a);
   
   abstract double calculate(double a, double b);
   

   
}

class Circle extends Shape{

   final double PI = 3.14159;
   @Override
   double calculate(double a){
      return PI * (a * a) ;
   
   }
   
   @Override
   double calculate(double a, double b){
      return 0.0;
   
   }


}

class Rectangle extends Shape{

   @Override
   double calculate(double a){
      return 0.0;
   
   }
   @Override
   double calculate(double a, double b){
      return a * b;
   
   }
   
   


}
class Triangle extends Shape{
   @Override
   double calculate(double a){
      return 0.0;
   
   }
   
   @Override
   double calculate(double a, double b){
      return (a * b)/2 ;
   
   }
   
   


}

