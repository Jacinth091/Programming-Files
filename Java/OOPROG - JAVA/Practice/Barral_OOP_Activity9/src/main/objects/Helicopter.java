package main.objects;

public class Helicopter extends Vh implements Vehicle {


    public Helicopter(String vhName, String vhType) {
        super(vhName, vhType);
    }


    // OVERRIDES!!

    @Override
    public String bookingTravelDestination(String destination) {
        return ("<html>" +
                "<p style='font-size: 14px; padding: 10px; word-wrap: break-word;'>" +
                "<span style='font-weight: bold;'>Booking Travel Destination to <br>" +destination+ " by " + super.getVhName() + "</span>" +
                "</html>");
    }

    @Override
    public void travelTo(String destination) {
        System.out.println("Travelling to " +destination+ " by " + super.getVhName());

    }
    @Override
    public String getVhName() {
        return super.getVhName();
    }

    @Override
    public String getVhType() {
        return super.getVhType();
    }
}
