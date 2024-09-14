// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;
class sortingArr {
    static int phaseNum;
    static int[] minIndexArr;
    static int[] jIndexArr;
    static int[] phaseArr;
    public static void main(String[] args) {
//        int[] array = {90, 89, 78, 10, 2, 5};
        Scanner in = new Scanner(System.in);
        int[] array = {12, 7, 4, 9, 3, 6};




        System.out.println("Input what phase # you want to display.");
        System.out.print("--> ");
        phaseNum= in.nextInt();

        dispArray(array);
//        bubbleSort(array, false);
//         tempArr = new int[array.length];
        selectionSort(array, false);
        System.out.println();
        dispArray(array);

        dispArray(phaseArr);

//        dispArray(minIndexArr);
//        System.out.println();
//        dispArray(jIndexArr);
        in.close();

    }

    public static void dispArray(int[] arr){
        System.out.print("[ ");
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i] + (i == arr.length - 1 ? " ]\n" : ", "));
        }
    }

    public static void bubbleSort(int[] array, boolean key){
        int n = array.length;
        boolean swapped;


        for(int i =0; i< n -1; i++){
            swapped = false;
            for(int j = 0; j < (n -i) - 1; j++){
                if(key){
                    if(array[j] > array[j + 1]){
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j +1] = temp;
                        swapped = true;
                    }
                }
                else{
                    if(array[j] < array[j + 1]){
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j +1] = temp;
                        swapped = true;
                    }
                }

            }

            if(!swapped){
                break;
            }
        }

    }

    public static void selectionSort(int[] array, boolean key){
        int n = array.length;
        minIndexArr = new int[n];
        jIndexArr = new int[n];

        for(int i =0; i < n -1; i ++){
            int minIndex =i;
            if(i ==0){
                System.out.print("\n\nSwapping elemtents @ indices pointed by i= "+i+" and minIndex= "+minIndex+" \nResult:    ");
                dispArray(array);
            }

            for(int j = i+1; j < n; j++){
                System.out.print("\ni= " +i+ " j= " +j+ " minIndex= "+ minIndex+ " ");
                dispArray(array);
                if(array[j] > array[minIndex]){
                    minIndex = j;
                    System.out.print("      updated mindIndex to = "+j+". " );
                }

            }
            if(minIndex != i){
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
                System.out.print("\n\nSwapping elemtents @ indices pointed by i= "+i+" and minIndex= "+minIndex+" \nResult:    ");
                dispArray(array);
                if(i == (phaseNum-1)){
                    phaseArr = copyArray(array);
                }
            }
        }
    }

    public static int[] copyArray(int[] array){
        int[] tempArr = new int[array.length];

        for(int i = 0; i < array.length; i++){
            tempArr[i] = array[i];
        }

        return tempArr;
    }

    public static void dispProcess(int[] arr, int iIndex, int jIndex, int minIndex){
//        int n = arr.length;
//        int[] minIndexArr = new int[n];
//        int[] jIndexArr = new int[n];
//
//        for(int i =0; i < n; i ++){
//            minIndexArr[i] = minIndex;
//            jIndexArr[i] = jIndex;
//        }
//
//        dispArray(minIndexArr);
//        System.out.println();
//        dispArray(jIndexArr);
    }

}




