#include <stdio.h>

int cubeNumber(int num);
int main(){

    int userIn, temp =0, digits =0, total = 0;
    int digit_ARR[3] ={0}; 

    printf("Input an Armstrong Number: ");
    scanf("%d", &userIn);

    temp = userIn;

    for(int i =0; i < sizeof(digit_ARR)/sizeof(digit_ARR[0]); i++){
        if(temp>0){
            digits = temp % 10;
            digit_ARR[i] = digits;
            temp /= 10;

            total += cubeNumber(digit_ARR[i]);
        }
    }

    if(total == userIn){
        printf("\n\nThe Number is an Armstrong Number!\n");
        printf("The Total cube number of %d. is equals to %d.\n", total, userIn);
    }
    else{
        printf("\n\nThe Number is NOT an Armstrong Number!\n");
        printf("The Total cube number of %d. is equals to %d.\n", total, userIn);
    }


    return 0;
}
int cubeNumber(int num){
    return num*num*num;
}