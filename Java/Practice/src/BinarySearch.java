
public class BinarySearch
{
	public static void main(String[] args) {

        int[] integers = {1,2,4, 5,7,8,9,11, 12, 15,17, 18,20, 23, 24,26, 30, 35, 37, 38, 40};
        int numToFind = 41;
        System.out.println("Binary Search Example");
        
        if(binarySearch(integers, numToFind) != -1){
            System.out.printf("The number %d is in the Array, at index: %d\n",numToFind, binarySearch(integers, numToFind));
        }
        else{
            System.out.printf("The number %d cannot be found\n", numToFind);
        }
	}
	private static int binarySearch(int[] numbers, int numberToFind){
	    int low =0;
	    int high = numbers.length -1;
	    while(low <= high){
	        int middlePosition = (low + high) / 2;
	        int middleNumber = numbers[middlePosition];
	        if(numberToFind == middleNumber)
	            return middlePosition;
	        else if(numberToFind < middleNumber)
	            high = middlePosition - 1;
	        else
	            low = middlePosition + 1;
	    }
	    return -1;
	}
}
