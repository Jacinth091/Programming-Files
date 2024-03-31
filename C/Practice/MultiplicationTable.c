#include <stdio.h>

int main(){


    int num = 15;

    printf("\n"); 
    for(int rows = 1; rows <= num; rows++){
        for(int cols =1; cols <=num; cols++){
            printf("%-5d", cols * rows); 
        }
        printf("\n\n"); 
    }



    return 0;
}