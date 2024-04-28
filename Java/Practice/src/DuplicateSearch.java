import java.util.Scanner;

class DuplicateSearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int inp;
        int[] numAr, dupes;

        System.out.print("Enter the number of elements in the array: ");
        inp = in.nextInt();
        numAr = new int[inp];
        System.out.printf("Enter %d elements in the array: \n", inp);
        for (int i = 0; i < numAr.length; i++) {
            numAr[i] = in.nextInt();
        }

        dupes = checkForDupe(numAr);

        if (dupes.length == 0) {
            System.out.println("No duplicate elements found in the array.");
        } else {
            System.out.print("Duplicate elements in the array are: ");
            for (int i = 0; i < dupes.length; i++) {
                if (dupes[i] > 0) {
                    System.out.printf("%d, ", dupes[i]);
                }
            }
        }

        /*
         * if( dupe != 0){
         * System.out.println("Duplicate elements in the array are: " + dupe);
         * 
         * }
         * else{
         * System.out.println("Duplicate elements in the array are: None");
         * 
         * }
         */

    }

    static int[] checkForDupe(int[] array) {
        int temp = 0, index = 0;
        int[] dupeNum = new int[array.length];

        for (int i = 0; i < array.length - 1; i++) {

            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    boolean isFound = false;
                    for (int k = 0; k < index; k++) {
                        if (dupeNum[k] == dupeNum[i]) {
                            isFound = true;
                            break;
                        }
                    }
                    if (!isFound) {
                        dupeNum[index++] = array[i];

                    }
                    break;
                }

            }

        }

        int[] duplicates = new int[index]; // Resize array to remove unused elements
        System.arraycopy(dupeNum, 0, duplicates, 0, index);
        return duplicates;

    }
}