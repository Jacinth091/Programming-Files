package anagramChecker;

import java.util.Scanner;
public class AnagramChecker {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] targetString = new String[2];
		String[] strTemp = new String[targetString.length];
		
		char[][] sortedStrArr = new char[targetString.length][];
		
		boolean isAnagram = true;
		
		System.out.println("Anagram Checker\n");
		
		for(int i =0; i < targetString.length; i++) {
			System.out.printf("Enter a word to check (%d): ", (i+1));
			targetString[i] = in.nextLine().trim();
			
			strTemp[i] = targetString[i].toLowerCase();
		}
		
		for(int k =0; k < targetString.length; k++) {
			char[] strArr = strTemp[k].toCharArray(); 
			for(int i= 0; i < strArr.length; i++) {
				for(int j = i + 1; j < strArr.length; j++) {
					if(strArr[j] < strArr[i]) {
						char temp = strArr[j];
						strArr[j] = strArr[i];
						strArr[i] = temp;
					}
				}
			}
			sortedStrArr[k] = strArr; 
			
		}
		for(int i =0; i < sortedStrArr.length; i++) {
			for(int j =0; j < sortedStrArr[i].length; j++) {
				if(sortedStrArr[0][j] != sortedStrArr[1][j]) {
					isAnagram = false;
					break;
				}
			}
		}
		
		
		String format = (isAnagram) ? "Anagrams" : "not Anagrams";
		System.out.printf("\n\nThe words \"%s\" and \"%s\" are %s.\n", targetString[0], targetString[1], format);
		
		
	}
}
