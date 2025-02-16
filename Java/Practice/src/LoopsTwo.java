import java.util.Scanner;

public class LoopsTwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numOfQuery = in.nextInt();

        int[] a = new int[numOfQuery], b = new int[numOfQuery], n = new int[numOfQuery];
        int[][] resArr = new int [numOfQuery][];

        for (int i = 0; i < numOfQuery; i++) {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
            n[i] = in.nextInt();

            int resu = a[i];
            resArr[i] = new int[n[i]];

            for (int j = 0; j < n[i]; j++) {
                resu += powCalc(2, j) * b[i];
                resArr[i][j] = resu;

            }
        }
        
        for(int[] numbers : resArr){
            for(int num : numbers){
               System.out.printf("%d ", num);
               
            
            }
            System.out.println();
        }
        
    }

   public static int powCalc(int base, int expo){
     
      long res =1;
      
      while(expo != 0){
         res *= base;
         --expo;
      
      }
      
      return (int)res;
   
   
   }
}
