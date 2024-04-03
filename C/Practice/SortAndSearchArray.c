
#include <stdio.h>

void sortArr(int array[], int size){
    int temp = 0;
    for(int i =0; i < size - 1; i++){
        
        for(int j = 0 ; j < size - i - 1; j++){
            if(array[j] > array[j+1]){
                temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
                
            }
        }
    }
    
}
void printArr(int array[], int size){
    
    for(int i =0; i < size; i++){
        printf("%d ", array[i]);
    }
    
}

int searchArr(int numToSearch, int array[], int size){
    int counter = 0;
    for(int i =0; i< size ; i++){
        if(numToSearch == array[i]){
            counter++;
        }
    }
    return counter;
}
int main()
{
    int numbers[] = {0,2,1,6,2,54,9,2,8,3,46,3,7}; 
    int size = sizeof(numbers)/sizeof(numbers[0]);
    int numToSearch, counter;
    
    sortArr(numbers, size);
    printArr(numbers, size);
    
    printf("\nEnter a number to search in the array: ");
    scanf("%d", &numToSearch);
    
    counter = searchArr(numToSearch, numbers, size);
    if(counter != 0){
        printf("\nThe number %d is in the array, it appeared %d time\\s.\n", numToSearch, counter);
    }
    else{
        printf("\nThe number %d is NOT in the array, it appeared %d time\\s.\n", numToSearch, counter);
    }

    return 0;
}


