#include <stdio.h>
#include <string.h>

int main(){

    char name[25];
    int age;


    printf("\nWhat is your name?: ");
    // scanf("%s", &name); // Doesn't include the whitespace "space"
    // fgets(name, 25, stdin); // Includes whitespace but will have a "\n"
    fgets(name, 25, stdin);
    name[strlen(name)-1] = '\0';

    printf("\nHow old are you?:  ");
    scanf("%d", &age);

    printf("Hellow! %s, you are %d years old! \n", name, age);  




    return 0;
}
void stringArraySearch()
{
    char string[25];
    char character;
    int count =0;
    
    printf("Enter a String: ");
    // fgets(string, 25, stdin);
    // string[strlen(string)-1] = '\0';
    scanf(" %s", &string);
    
    printf("Enter a character to count: ");
    scanf(" %c", &character);
    
    for(int i = 0; i < sizeof(string)/sizeof(string[0]); i++){
        if(character == string[i]){
            count++;
        }
        
    }
    
    printf("\nThe character '%c' appears %d times in the string.\n", character, count);

}

void matrixDiagoSum()
{
    int matrixSize = 0, matrixElements = 0;
    int diagonalSum =0;
    
    printf("\nEnter the size of the matrix: ");
    scanf("%d", &matrixSize);
    
    int matrixArray[matrixSize][matrixSize];
    printf("Enter the Elements of the matrix: \n");
    for(int row = 1; row <= matrixSize; row++){

        for(int col = 1; col <= matrixSize; col++){
            scanf("%d", &matrixElements);
            matrixArray[row][col] = matrixElements;
        }
        
    }
    for(int row = 1; row <= matrixSize; row++){

        for(int col = 1; col <= matrixSize; col++){
            if(row == col){
                diagonalSum += (matrixArray[row][col]);
            }
        }

    }
    printf("\nThe diagonal Sum of the matrix is: %d", diagonalSum);
    

}



