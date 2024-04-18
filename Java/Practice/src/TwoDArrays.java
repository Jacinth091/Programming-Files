import java.util.Scanner;
import java.util.Random;

class TwoDArrays{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        int row, col;

        System.out.print("Enter size of the array: ");
        row = in.nextInt();
        col = in.nextInt();
        in.nextLine();

        int[][] matrix = new int[row][col]; 

        // System.out.println("Enter the value of the matrix array: ");

        // for(int i = 0; i < row; i++ ){
        //     for(int j =0; j< col; j++){
        //         matrix[i][j] = in.nextInt();
        //     }
        // }

        // for(int i = 0; i < row; i++ ){
        //     for(int j =0; j< col; j++){
        //         matrix[i][j] =  (col - j) * (row - i);
        //     }
        // }
        // System.out.println();
        // for(int i = 0; i < row; i++ ){
        //     for(int j = 0; j < col; j++){
        //         System.out.printf("%-5d ", matrix[i][j]);
        //     }
        //     System.out.println();

        // }
        int min = 0, max= 9;

        for(int i = 0; i < row; i++ ){
            for(int j =0; j< col; j++){
                // matrix[i][j] =  rand.nextInt(max - min + 1) + min;
                System.out.printf("Enter Value for row #%d, column #%d: ", (i+1), (j+1));
                matrix[i][j] = in.nextInt();
            }
        }
        System.out.println();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.printf("%4d ", matrix[i][j]);
            }
            System.out.println("\n");
        }
        System.out.printf("\nMax : %d\n", getMax(matrix));

        

    }
    static int getMax(int[][] array){
        int max = 0;
        for(byte i =0; i< array.length; i++){
            for(int j =0; j < array[0].length; j++){
                if(max < array[i][j]){
                    max = (int)array[i][j];
                }
            }
        }
        return max;
    }
}