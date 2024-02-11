import java.util.Scanner;
public class Multi_dimensional_Arrays {
    public static void  main(String[] args){
        Scanner input = new Scanner(System.in);
        // 2D Arrays = an array of arrays

/*        String[][] cars = new String[3][3];

        cars[0][0] = "Camero";
        cars[0][1] = "Silverado";
        cars[0][2] = "Corvette";

        cars[1][0] = "Mustang";
        cars[1][1] = "Ranger";
        cars[1][2] = "F1 50";

        cars[2][0] = "Ferrari";
        cars[2][1] = "Dodger";
        cars[2][2] = "Lamborghini";*/

//        String[][] cars =
//        {
//                {"Camero", "Silverado", "Corvette"},
//                {"Mustang", "Ranger", "F1-50"},
//                {"Ferrari", "Dodger", "Lamborghini"}
//        };

        String[][] cars = new String[2][2];

        for(int i = 0; i < cars.length; i++){
            System.out.println("\nCar Set no. " + (i + 1) + ": ");
            for(int j = 0; j < cars.length; j++){
                String userCar= "";
                System.out.print("Set " + (i + 1) + ", enter car: ");
                userCar = input.nextLine();
                cars[i][j] = userCar;

            }
        }



        for(int i = 0; i < cars.length; i++){
            System.out.println();
            for(int j= 0; j < cars[i].length; j++){
                System.out.print(cars[i][j] + " ");
            }
        }

    }
}
