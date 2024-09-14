import java.util.Scanner;

class mein {
    static int phaseNum;
    static int[] phaseArr = {}; // Initialize with an empty array

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] array = {3,1,6,2,9,4}; // Sample array

        System.out.print("CURRENT ARRAY ITEMS -->: ");
        dispArray(array);



        // Ask the user for the phase number to display
        System.out.println("\nInput what phase # you want to display.");
        System.out.print("--> ");
        phaseNum = in.nextInt();

        // Ask the user for the sorting order: ascending or descending
        System.out.println("Choose sorting order: 'asc' for ascending, 'desc' for descending.");
        System.out.print("--> ");
        String order = in.next().trim().toLowerCase();
        boolean isAscending = order.equals("asc");

        // Ask the user to choose the sorting method
        System.out.println("Choose sorting method: 'bubble' for Bubble Sort, 'selection' for Selection Sort.");
        System.out.print("--> ");
        String method = in.next().trim().toLowerCase();

        dispArray(array); // Display the original array

        // Perform sorting based on the user's chosen method
        if (method.equals("bubble")) {
            bubbleSort(array, isAscending);
        } else if (method.equals("selection")) {
            selectionSort(array, isAscending);
        } else {
            System.out.println("Invalid sorting method chosen.");
            return;
        }

        System.out.print("\nSorted Array -->: ");
        dispArray(array); // Display the final sorted array

        // Display the array at the specified phase, check if phaseArr is empty or not
        if (phaseArr.length > 0) {
            System.out.print("Specified #"+phaseNum+" array phase -->: ");
            dispArray(phaseArr);
        } else {
            System.out.println("No swap occurred at the specified phase.");
        }

        in.close();
    }

    // Function to display an array
    public static void dispArray(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? " ]\n" : ", "));
        }
    }

    // Modified bubble sort to handle ascending and descending orders and display the process
    public static void bubbleSort(int[] array, boolean isAscending) {
        int n = array.length;
        boolean swapped;
        phaseArr = new int[0]; // Ensure phaseArr is initialized

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            System.out.print("\n\nPhase #" + (i+1) + "------------------------------------------------------------");
            for (int j = 0; j < (n - i) - 1; j++) {
                System.out.print("\nj = " + j + " | j + 1 = " + (j +1) + " -->: ");
                dispArray(array);

                // Compare based on sorting order and perform swap if needed
                if (isAscending ? array[j] > array[j + 1] : array[j] < array[j + 1]) {
                    // Swapping the elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;

                    System.out.print("      Swapped elements at indices j = " + j + " and j + 1 = " + (j + 1) + ".\n");
                    System.out.print("      Result -->: ");
                    dispArray(array);


                }
                // Store the phase result if it matches the specified phase number

                if (i == (phaseNum - 1)) {
                    phaseArr = copyArray(array);
                }
            }

            // If no elements were swapped, break the loop
            if (!swapped) {
                break;
            }
        }
    }

    // Modified selection sort to handle ascending and descending orders and display the process
    public static void selectionSort(int[] array, boolean isAscending) {
        int n = array.length;
        phaseArr = new int[0]; // Ensure phaseArr is initialized

        for (int i = 0; i < n - 1; i++) {
            int targetIndex = i;
            if (i == 0) {
                System.out.print("\n\nSwapping elements at indices i = " + i + " and targetIndex = " + targetIndex + "\nResult:    ");
                dispArray(array);
            }

            for (int j = i + 1; j < n; j++) {
                System.out.print("\ni = " + i + " j = " + j + " targetIndex = " + targetIndex + " ");
                dispArray(array);

                // Update target index based on the sorting order
                if (isAscending ? array[j] < array[targetIndex] : array[j] > array[targetIndex]) {
                    targetIndex = j;
                    System.out.print("      updated targetIndex to = " + j + ". ");
                }
            }

            // Swap if a new target index was found
            if (targetIndex != i) {
                int temp = array[i];
                array[i] = array[targetIndex];
                array[targetIndex] = temp;

                System.out.print("\n\nSwapping elements at indices i = " + i + " and targetIndex = " + targetIndex + "\nResult:    ");
                dispArray(array);

                // Store the phase result if it matches the specified phase number

            }
            if (i == (phaseNum - 1)) {
                phaseArr = copyArray(array);
            }
        }
    }

    // Function to copy an array
    public static int[] copyArray(int[] array) {
        int[] tempArr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            tempArr[i] = array[i];
        }
        return tempArr;
    }
}
