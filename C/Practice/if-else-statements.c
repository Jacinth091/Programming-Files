#include <stdio.h>

int main (){
    /* switch = A more efficient alternative to using many "else if" statements 
                allows a value to be tested for equality against many cases 
    
    */

    char grade;

    printf("Enter a letter grade: ");
    scanf("%c", &grade);

    switch (grade)
    {
    case 'A':
       printf("You did very good!\n");
        break;
    case 'B':
       printf("You did well\n");
        break;
    case 'C':
       printf("You did okay!\n");
        break;
    case 'D':
       printf("Atleast it's not an F!\n");
        break;
    case 'F':
       printf("Unfortunately, You FAILED!\n");
        break;
    default:
        printf("Please Enter a Valid Grade! ");
    }

    /*
    // if, else if, else version
    if (grade == 'A') {
        printf("You did very good!\n");
    }
    else if (grade == 'B') {
        printf("You did well!\n");
    }
    else if (grade == 'C') {
        printf("You did okay!\n");
    }
    else if ( grade == 'D') {
        printf("At least its not an F\n");
    }
    else if (grade == 'F') {
        printf("Unfortunetly you FAILED..\n");
    }
    else {
        printf("Error! grade not identified");
        return 1;
    }*/






    return 0;
}

    /*int age;

    printf("Enter Age: ");
    scanf("%d", &age);

    if (age >= 19) {
        printf("Welcome!\n");

    }
    else {
        printf("Sorry, try again next time...\n");
    }*/