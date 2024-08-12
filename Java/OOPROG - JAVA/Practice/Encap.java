public class Encap {
    public static void main(String[] args){
        Cars carOne = new Cars();


   /*     String u_Mod, u_Col;
        int u_Year;


        System.out.println("");*/

        System.out.println("Your chosen Car Details:\n");

        System.out.println("Model: " + carOne.getModel() + ",");
        System.out.println("Color: " + carOne.getColor() + ",");
        System.out.println("Manufacture Year: " + carOne.getYear() + ".");

    }
}

class Cars
{

    private String carModel = "Tesla Model Y (Long Range RWD)";
    private int carYear = 2022;
    private String carColor = "Midnight Blue";


    public Cars(){

    }
    public Cars(String mod, int year, String col){
        this.setModel(mod);
        this.setYear(year);
        this.setColor(col);


    }

    public String getModel(){
        return carModel;
    }

    public void setModel(String model){
        carModel = model;
    }

    public int getYear(){
        return carYear;
    }

    public void setYear(int year){
        carYear = year;
    }

    public String getColor(){
        return carColor;
    }

    public void setColor(String color){
        carColor = color;
    }


}

