#include <stdio.h>

// Its is a subsection of a code that can be used more than once 


void birthday(char x[], int y) // inside the paranthesis are called parameters
{
    printf("\nHappy Birthday dear %s!", x);
    printf("\nYou are now %d years old!\n ", y);

}

int main () {
    char name[] = "Jacinth";
    int age = 20;
    birthday(name, age);



    return 0;
}