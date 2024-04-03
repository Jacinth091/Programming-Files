#include <stdio.h>
#include <string.h>
#include <ctype.h>

// Function to check if two strings are anagrams
int areAnagrams(char *str1, char *str2) {
    // Create arrays to store the count of each character in the strings
    int count1[256] = {0}; // Assuming ASCII characters
    int count2[256] = {0};
    
    // Lengths of the strings
    int len1 = strlen(str1);
    int len2 = strlen(str2);
    
    // If lengths are not equal, strings can't be anagrams
    if (len1 != len2) 
        return 0;
    
    // Count occurrences of each character in the first string
    for (int i = 0; i < len1; i++) {
        count1[tolower(str1[i])]++;
    }
    
    // Count occurrences of each character in the second string
    for (int i = 0; i < len2; i++) {
        count2[tolower(str2[i])]++;
    }
    
    // Compare counts of each character in both strings
    for (int i = 0; i < 256; i++) {
        if (count1[i] != count2[i])
            return 0; // If counts don't match, strings are not anagrams
    }
    
    return 1; // Strings are anagrams
}

int main() {
    char str1[50], str2[50];
    
    // Input the strings
    printf("Enter first string: ");
    fgets(str1, 50, stdin);
    str1[strcspn(str1, "\n")] = '\0'; // Remove newline character
    
    printf("Enter second string: ");
    fgets(str2, 50, stdin);
    str2[strcspn(str2, "\n")] = '\0'; // Remove newline character
    
    // Check if strings are anagrams
    if (areAnagrams(str1, str2))
        printf("%s and %s are anagrams.\n", str1, str2);
    else
        printf("%s and %s are not anagrams.\n", str1, str2);
    
    return 0;
}
