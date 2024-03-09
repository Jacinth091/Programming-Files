import java.util.Arrays;

public class testing
{
    public static void main(String[] args) {
        String[][] food = {{"CheeseCake", "Binangkal", "Pandesak", "Hamburger", "Pizza"},
                {"CheeseCake1", "Binangkal2", "Pandesak3", "Hamburger4", "Pizza5"},

        };

        for(String[] element : food){
            String[] foodOne;

            for(String deepElement : element){
                foodOne = new String[]{Arrays.toString(element)};
                System.out.println(Arrays.toString(foodOne));
            }



        }
    }
}
