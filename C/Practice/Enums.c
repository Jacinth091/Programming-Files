#include <stdio.h>

enum Day{
Sunday =1, Monday , Tuesday  , 
Wednesday, Thrusday, Friday, 
Saturday
};


int main(){


    // enum = a user defined type of named Integer indentifiers
    //        that helps to make a program more readable


    enum Day today = Sunday; // enums aree NOT STRINGS, but they can be treated as INTEGERS

    // printf("%d", today);

    if(today == Sunday || today == Saturday){
        printf("Currently on the Weekends! :D\n");
    }
    else{
        printf("Currently on the Weekdays :(\n");
    }



    return 0;
}