package duplicateChecker;

import java.util.Scanner;
public class DuplicateChecker {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int[] numArr = new int[6];

		int filledCount=0;
		System.out.println("Duplicate Checker\n");
		
		for(int i =0; i < numArr.length ; i++) {
			System.out.print("Enter an integer: ");
			int temp = in.nextInt();
			boolean isDuplicate = false;
			for(int j =0; j < filledCount; j++) {
				if(temp == numArr[j]) {
					isDuplicate = true;
				}
			}
			if(!isDuplicate) {
				numArr[filledCount++] = temp;
				
			}
			
		}
		System.out.println();
		for(int i =0; i < filledCount; i++) {
			System.out.printf("%d ", numArr[i]);
		}
		
		
	}

}
