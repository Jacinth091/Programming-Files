#include <stdio.h>

int main(){
    
    int n;
    int i, j;

    printf("Enter number of rows: ");
    scanf("%d",&n);
    for (i = n; i >= 1; i--) {
        for (j = n; j > i; j--) {
            printf(" ");
        }
        for (j = 1; j <= (2 * i) - 1; j++) {
            printf("*");
        }
        printf("\n");
    }

    for( i =2; i <=n; i++){
        for(j = i; j<n; j++){
            printf(" ");
        }
        for (j = 1; j <= (2 * i) - 1; j++) {
            printf("*");
        }
        printf("\n");
    }
    
    return 0;
}
