public class toStringMethod {
    public static void main(String[] args) {

        // toString() = special method that all objects inherit,
        //              that returns a string that "textually represents" an object.
        //              can be used both implicitly and explicitly


        Phone phone = new Phone();

/*        System.out.println(phone.brand);
        System.out.println(phone.color);
        System.out.println(phone.chipset);
        System.out.println(phone.model);*/

        // Explicitly using toString()
        System.out.println("Explicitly:");
        System.out.println(phone.toString());


        // Implicitly using toString()
        System.out.println("Implicitly:");
        System.out.println(phone);


    }
}
class Phone{
    String brand = "Smsasung", color = "Ash-Gray", chipset = "Spandrogan";
    int model = 2024;


    public String toString() {
        return "Brand: "+brand + "\n" + "Color: "+color + "\n" + "Chipset: "+chipset + "\n" +"Model: "+model + "\n";

    }




}