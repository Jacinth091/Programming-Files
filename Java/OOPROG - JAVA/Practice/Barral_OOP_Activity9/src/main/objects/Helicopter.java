package main.objects;

public class Helicopter extends Vh implements Vehicle{


    public Helicopter(String vhName, String vhType, int vhSpeed, int vhCapacity) {
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
