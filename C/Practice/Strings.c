#include <stdio.h>
#include <string.h>

int main(){

    char name[25];
    int age;


    printf("\nWhat is your name?: ");
    // scanf("%s", &name); // Doesn't include the whitespace "space"
    // fgets(name, 25, stdin); // Includes whitespace but will have a "\n"
    fgets(name, 25, stdin);
    name[strlen(name)-1] = '\0';

    printf("\nHow old are you?:  ");
    scanf("%d", &age);

    printf("Hellow! %s, you are %d years old! \n", name, age);  




    return 0;
}