package main.objects;

public class Bicycle extends Vh implements Vehicle{


    public Bicycle(String vhName, String vhType, int vhSpeed, int vhCapacity) {
        super(vhName, vhType, vhSpeed, vhCapacity);
    }



    // OVERRIDES!!

    @Override
    public void travelTo(String destination) {

    }


    @Override
    public void getVehicleImage() {

    }
}
