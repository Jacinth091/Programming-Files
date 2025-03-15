package anagramChecker;

import java.util.Scanner;
public class OtherAnagramChecker {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String[] targetString = new String[2];
		String[] strTemp = new String[targetString.length];
		int[] charCount = new int[26];
		boolean isAnagram = true;
		
		System.out.println("Anagram Checker (Without sorting)\n");
		for(int i =0; i < targetString.length; i++) {
			System.out.printf("Enter a word to check (%d): ", (i+1));
			targetString[i] = in.nextLine().trim();
			
			strTemp[i] = targetString[i].toLowerCase();
			strTemp[i]  = alphabOnly(strTemp[i]);
		}
		
		if(strTemp[0].length() != strTemp[1].length()) {
			isAnagram = false;
		}
		
        for (int i = 0; i < strTemp[0].length(); i++) {
            charCount[strTemp[0].charAt(i) - 'a']++;
        }

        for (int i = 0; i < strTemp[1].length(); i++) {
            charCount[strTemp[1].charAt(i) - 'a']--;
        }
        
		
        for (int count : charCount) {
            if (count != 0) {
                isAnagram = false;
                break;
            }
        }
        
		
		
		if(isAnagram) {
			System.out.printf("\n\nThe words \"%s\" and \"%s\" are Anagrams.\n", targetString[0], targetString[1]);
			
		}
		else
			System.out.printf("\n\nThe words \"%s\" and \"%s\" are not Anagrams.\n", targetString[0], targetString[1]);

		
		
		
	}
	
	public static String alphabOnly(String string) {
		StringBuilder sb = new StringBuilder();
		for(int i =0; i< string.length(); i++) {
			char ch = string.charAt(i);
			if(Character.isAlphabetic(ch)) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
}
