#include <stdio.h>
#include <math.h>

int main () {

    int num[3];
    int total = 0;
    int input;

    printf("Input 3 integers: ");
    

    // Putting 3 integers inside the array
    for (int i = 0; i < 3; ++i) {
        scanf("%d", &num[i]);
    }
    

    // checks if num_ARRAY is greater than or equal to zero to run
    if (num >= 0) {
        // looping for the num_ARRAY to be powered by 3 and storing the sum in TOTAL
        for (int i = 0; i < 3; ++i) {
            total += pow(num[i], 3);
        }
    }  
    else {
        printf("Error!");
        return 1;
    }   

    printf("\n%d\n", total);

    if (total != 0) {
        for (int i = 0; i < 3; ++i) {
            input = num[i];
            printf("%d", input);
        }

    }
    else {
        printf("Error!");
        return 1;
    }

    if (total == input) {
        printf("\nSATISFIED!");
    }
    else {
        printf("\nNOT SATISFIED!");
    }

    
    // printf("\nDisplay:  \n");
    // for (int i = 0; i < 3; ++i) {
    //     total += pow(num[i], 3);

    // }
    // for (int i = 0; i < 3; ++i) {
    //     printf("%d", num[i]);
    // }

        
    /*if (num != 0) {
  
        if (total == powResult) {
            printf("\n%d", powResult );
            printf("\nSATISFIED!");
            
        }
        else {
            printf("\nNOT SATISFIED!!!");
        }
    }
    else {
        printf("Error!");
        return 1;
    }*/


    return 0;
}