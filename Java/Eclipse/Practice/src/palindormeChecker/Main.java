package palindormeChecker;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String target = "";
		char[] strArr;
		
		System.out.println("Palindrome Checker\n\n");
		System.out.print("Enter a word to check: ");
		target = in.nextLine().trim();
		
		strArr = target.toCharArray();
		int mid = strArr.length / 2;
		boolean isPalindrome = true;
		int count =0;
		for(int i =0; i < mid; i++) {
			int j = strArr.length - 1 - i;
			if((strArr[i] != strArr[j])) {
//				System.out.printf("i: %c != j: %c\n", strArr[i], strArr[j]);
				isPalindrome = false;
				break;
			}
			else {
//				System.out.printf("i: %c === j: %c\n", strArr[i], strArr[j]);
			}
				
		}

		
		System.out.println("The word \'" + target + "\' is " + ((isPalindrome) ? "a palindome" : "not a palindrome" ) + ".");

		
	}
}
