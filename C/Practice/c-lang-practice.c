// Online C compiler to run C program online
#include <stdio.h>

int main() {
    
    int age;
    char name[100];
    char add[100];
    char city[100];
    
    printf("Name: ");
    fgets(name, sizeof(100), stdin); printf("\n");
    
    printf("Age: ");
    scanf("%d", &age);printf("\n");
    
    printf("Address: ");
    fgets(add, sizeof(100), stdin); printf("\n");
    
    printf("City: ");
    fgets(city, sizeof(100), stdin); printf("\n");

    printf("Your Name is %s\n", name);
    printf("You are %d years old\n", age);
    printf("You live in %s, %s", add, city);


    printf("Thank You!!!");
    

    

    return 0;
}