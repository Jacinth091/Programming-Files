
public class InsertionSort {
    public static void main(String[] args) {

        int[] num = {3,2,2,2,2, 4, 5, 8, 9, 10, 20, 21, 15, 17, 13, 12, 14, 9, 2, 4, 12, 14, 19, 21, 23, 26, 28, 31, 51};
        int[] dupedNum = new int[num.length];
        int temp = 0, duplicate = 0;
        // boolean isSorted;

        for (int i = 1; i < num.length; i++) {
            int j = i;
            while (j > 0 && num[j - 1] > num[j]) {
                temp = num[j];
                num[j] = num[j - 1];
                num[j - 1] = temp;
                j--;

            }

        }
        System.out.print("Sorted Array: ");

        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                if (dupedNum[num[i]] == 0) {
                    dupedNum[num[i]] = num[i];
                    duplicate++;
                }
            }
            System.out.printf("%d ", num[i]);
        }
        System.out.print("\n\n");
        System.out.print("Duplicated Numbers: ");
        for (int i = 0; i < num.length; i++) {
            if (dupedNum[i] != 0) {
                System.out.printf("%d ", dupedNum[i]);
            }
//            System.out.printf("%d ", dupedNum[i]);

        }
        System.out.printf("\nUnique Duped Num: %d", duplicate);
    }
}

