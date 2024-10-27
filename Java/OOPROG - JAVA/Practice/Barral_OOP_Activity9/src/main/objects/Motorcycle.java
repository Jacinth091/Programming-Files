package main.objects;

public class Motorcycle extends Vh implements Vehicle{


    public Motorcycle(String vhName, String vhType, int vhSpeed, int vhCapacity) {
        super(vhName, vhType, vhSpeed, vhCapacity);
    }


    // OVERRIDES!!

    @Override
    public void travelTo(String destination) {
        System.out.println("Travelling to " +destination+ " by " + super.getVhName());
    }


    @Override
    public void getVehicleImage() {

    }
}
