import java.util.Scanner;

class OddSkip {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, counter = 0;

        System.out.print("Enter a number: ");
        n = in.nextInt();

        for (int i = 0; i <= n; i++) {
            if ((i % 2) > 0) {
                counter++;
                if ((counter % 3) == 0)
                    continue;
                else
                    System.out.printf("%d ", i);
            }
        }

    }
}