#include <stdio.h>

int main(){

    int limit, seed = 0, next = 0, temp = 1;

    printf("**************** Fibonacci Sequence ****************\n");

    printf("Enter Limit: ");
    scanf("%d", &limit);  

    printf("\nFibonacci Sequence: "); 
    
    for(int i =0; i < limit; i++){
        printf("%d, ", seed);
        next = temp + seed;        
        seed = temp;
        temp = next;
    }
    printf("\n"); 
    for(int i =0; i < limit; i++){
        printf("%d ", i); 
    }


    return 0;
}