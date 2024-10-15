public abstract class Vehicle{

   private String powerSource;
   private int wheels;
   protected int price;
  
   
   // public abstract void display();
   public Vehicle(String powerSource, int wheels){
      setPowerSource(powerSource);
      setWheels(wheels);
      setPrice();
   }
   
   public String getPowerSource(){
      return powerSource;
   }
   public void setPowerSource(String powerSource){
      this.powerSource = powerSource;
   }
   
   
   public int getWheels(){
      return wheels;
   }
   public void setWheels(int wheels){
      this.wheels = wheels;
   }
   
   
   
   public int getPrice(){
      return price;
   }
   public abstract void setPrice();

}