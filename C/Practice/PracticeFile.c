// Remove Duplicate Problem

#include <stdio.h>
#include <stdbool.h>

void removeDuplicates();

int main(){

    int matrixSize = 0, matrixElements = 0;
    
    printf("\nEnter the size of the matrix: ");
    scanf("%d", &matrixSize);
    
    int matrixArray[matrixSize][matrixSize];
    printf("Enter the Elements of the matrix: \n");
    for(int row = 0; row < matrixSize; row++){

        for(int col = 0; col < matrixSize; col++){
            scanf("%d", &matrixArray[row][col]);
        }
        
    }

    for(int i =0; i < matrixSize; i++){
        for(int j = 0; j < matrixSize; j++){
            printf("%d ", matrixArray[j][i]);
        }
        printf("\n");
    }


    // removeDuplicates();







    return 0;
}




void removeDuplicates(){

    int arrSize, userIn, counter = 0;

    printf("Enter Size of array: ");
    scanf("%d", &arrSize);

    int numArr[arrSize];
    int dupeNumArr[arrSize];

    printf("\nEnter elements in array: \n");
    for(int i = 0; i < arrSize; i++){
        scanf("%d", &userIn);
        numArr[i] = userIn;
    } 

    for(int i =0; i < sizeof(numArr)/sizeof(numArr[0]); i++){
        bool foundDupe = false;
        for(int j = 0; j < counter; j++){
            if(numArr[i] == dupeNumArr[j]){
                foundDupe = true;
                break;
            }
        }
        if(!foundDupe){
            dupeNumArr[counter++] = numArr[i];
        }
    }  

    printf("\nArray after removing duplicates: "); 
    for(int i = 0; i < counter; i++){
        printf("%d ", dupeNumArr[i]);

    } 
}