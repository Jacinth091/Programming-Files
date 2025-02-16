import java.util.*;

public class ParkingSystem{
   public static void main(String[] args){
      
   
   
   
   }
}

class ParkingSlot{
   int slotNumber;
   boolean isOccupied;
   Vehicle vehicle;
   
   

}

class ParkingLot{
   int totalSlots;
   int availbleSlots;
   ArrayList<ParkingSlot> slotList = new ArrayList<>();


}

abstract class Vehicle{
   String licensePlate, vehicleType, color;
   int entryTime;
   
   public Vehicle(String licensePlate, String vehicleType, String color){
      this.licensePltae = licensePlate;
      this.vehicleType = vehicleType;
      this.color = color;
      
   }
   
   abstract double calculateParkingFee(int hours);
   
   void getVehicleDetails(){
      
   
   }

}

class Car extends Vehicle{
    int baseRate = 50;
    
    
    
    @Override
    double calculateParkingFee(int hours){
      return baseRate * hours;
    
    }

}

class Bicycle extends Vehicle{
    int baseRate = 50;
    
    
    
    @Override
    double calculateParkingFee(int hours){
      return baseRate * hours;
    
    }

}

