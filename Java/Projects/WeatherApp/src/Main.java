import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class Main {
    public static void main(String[] args){
        try{
            Scanner in = new Scanner(System.in);
            String city;
            do{
                System.out.println("Enter a Country (Type 'N' or \"No\" to Exit)");
                System.out.print("--> ");
                city = in.nextLine();

                if(city.equalsIgnoreCase("N") || city.equalsIgnoreCase("No")){break;}




            }while(true);

        }catch(IOException e){
            e.printStackTrace();
        }





    }
}
