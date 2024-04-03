#include <stdio.h>
#include <string.h>


int main()
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
    
    

    return 0;
}