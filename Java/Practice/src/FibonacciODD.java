import java.util.Scanner;
class FibonacciODD{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n, start = 0, next =1, res = 0;

        System.out.print("Enter the number of terms: ");
        n = in.nextInt();

        System.out.print("0 ");
        for(int i = 0; i < n -1; i++){
            

            res = start + next;
            start = next;
            next = res;

            if (start % 2 == 0) {
                continue;
            }
            System.out.printf("%d ", start);


        }
    }
}
