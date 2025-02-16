import java.util.Scanner;
import java.util.ArrayList;

public class Ecommerce{
   public static void main(String[] args){
      
      Product laptop = new Electronics("120381209381", "HP Probook", 1200.00, 2, 12);
      Product intramsShirt = new Clothing("123awda123", "CCS Short", 25.00, 5,'M');
      Customer customer = new Customer("23784994", "Jims", "anton@gmail.com");
      
      
      System.out.println("Customer : " + customer.custName);
      customer.addToCart(laptop);
      customer.addToCart(intramsShirt);
      customer.checkout();
      System.out.printf("Total Amount : $%.2f\n", customer.totalAmount);
      System.out.println("Order placed successfully!");
      
      
      
      
      
      
   
   
   }
}
class Customer{
   String custID, custName, custEmail;
   ArrayList<Product> cart;
   
   double totalAmount;
   
   
   public Customer(String custID, String custName, String custEmail){
      this.custID = custID;
      this.custName = custName;
      this.custEmail = custEmail;
      cart =  new ArrayList<>();
      this.totalAmount =0.0;
   
   
   }
   
   public void addToCart(Product product){
      cart.add(product);
      System.out.println("Added " + product.prodName + " to cart");
   }
   
   public void removeFromCart(Product product){
      cart.remove(product);
   }
   
   public void checkout(){
      System.out.println("Checkout Summary: ");
      for(int i= 0; i < cart.size(); i++){
         System.out.println(" - " + cart.get(i).prodName + ": $" + cart.get(i).prodPrice);
         totalAmount += cart.get(i).prodPrice;
      }
   }


}

abstract class Product{
   String prodId, prodName;
   double prodPrice;
   int stockQuant;
   
   public Product(String prodId, String prodName, double prodPrice, int stockQuant){
      this.prodId = prodId;
      this.prodName = prodName;
      this.prodPrice = prodPrice;
      this.stockQuant = stockQuant;
   
   }

   public void getProductDetails(){
      
   
   }

      
   
} 

class Electronics extends Product{

    int warrantyPeriod;
   
   public Electronics(String prodId, String prodName, double prodPrice, int stockQuant, int warrantyPeriod){
      super(prodId, prodName, prodPrice, stockQuant);
      this.warrantyPeriod = warrantyPeriod;
   }   
   
   

}  

class Clothing extends Product{

    char size;
   
   public Clothing(String prodId, String prodName, double prodPrice, int stockQuant, char size){
      super(prodId, prodName, prodPrice, stockQuant);
      this.size = size;
   }   
   
   

}
  
   
   
   

