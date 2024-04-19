public class Encapsulation {

    public static void main(String[] args) {

        // Encapsulation = attributes of a class will be hidden or private,
        // can be accessed only through methods (getters and setters)
        // You should make attributes private if you don't have a reason to make them
        // public/protected
        //

        Cars car = new Cars("Tesla", "CyberTruck", 2023);

        System.out.println(car.getMake());
        System.out.println(car.getModel());
        System.out.println(car.getYear());

        System.out.println();

        car.setMake("Chevrolet");
        car.setModel("Camaro");
        car.setYear(1991);

        System.out.println(car.getMake());
        System.out.println(car.getModel());
        System.out.println(car.getYear());
    }

}

class Cars {

    private String make;
    private String model;

    private int year;

    public Cars(String make, String model, int year) {
        this.setMake(make);
        this.setModel(model);
        this.setYear(year);
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
