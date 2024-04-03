#include <stdio.h>


void printAge(int *pAge){
    // int y = 12;
    // *pAge = *pAge +1;
    printf("You are %d years old!\n",*pAge );
}

int main(){

    // pointer = a "variable-like" refrence that holds a memory address to another variable,array, etc
    //           some tasks are performed more easily with pointers
                // * = indication operator ( value of address)


    int age = 21;
    int *pAge = NULL; // good practice to assign NULL if declaring a pointer
    pAge = &age;

    // printf("Address of Age: %p\n", &age);
    // printf("Value of *pAge: %p\n", pAge);

    // printf("Size of Age: %d\n", sizeof(age));
    // printf("Size of *pAge: %d\n", sizeof(pAge));
    

    // printf("Value of Age: %d\n", age);
    // printf("Value at stored address: %d\n", *pAge); // dereferencing

    printAge(pAge);
    printf("%d", *pAge);

    return 0;
}