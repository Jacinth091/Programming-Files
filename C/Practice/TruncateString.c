
#include <stdio.h>
#include <string.h>


int main()
{
    char str[50];
    int numOfChar;
    char truncatedSTR[numOfChar];
    
    printf("Enter a string: ");
    fgets(str, 50, stdin);
    str[strlen(str)-1] = '\0';
    
    printf("Enter the number of characters: ");
    scanf("%d", &numOfChar);
    
    printf("Truncated String: %s", strncpy(truncatedSTR, str, numOfChar));

    
    return 0;
}
