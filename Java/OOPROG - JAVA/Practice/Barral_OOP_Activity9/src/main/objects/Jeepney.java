package main.objects;

public class Jeepney extends Vh implements Vehicle{


    public Jeepney(String vhName, String vhType, int vhSpeed, int vhCapacity) {
        super(vhName, vhType, vhSpeed, vhCapacity);
    }


    public void setDefaults(){

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
