#include <stdio.h>

int main () {
    double num1, num2;
    double result;
    char operation;

    printf("Enter First Number: ");
    scanf("%lf", &num1);

    printf("Please Enter and Operator (+ - * /): ");
    scanf(" %c", &operation);


    switch (operation)
    {
    case '+':
        printf("Enter Second Number: ");
        scanf("%lf", &num2);
        result = num1 + num2;
        printf("Here is the Result: %.2lf", result);
        break;
    
    case '-':
        printf("Enter Second Number: ");
        scanf("%lf", &num2);
        result = num1 - num2;
        printf("Here is the Result: %.2lf", result);
        break;
    case '*':
        printf("Enter Second Number: ");
        scanf("%lf", &num2);
        result = num1 * num2;
        printf("Here is the Result: %.2lf", result);
        break;
    case '/':
        printf("Enter Second Number: ");
        scanf("%lf", &num2);
        result = num1 / num2;
        printf("Here is the Result: %.2lf", result);
        break;
    
    default:
    printf("%c Is not a valid Operator", operation);
        break;
    }

    /*
    if (operation == '+') {
        printf("Enter Second Number: ");
        scanf("%lf", &num2);
        result = num1 + num2;
        printf("Here is the Result: %.2lf", result);
    
    }
    else if (operation == '-') {
        printf("Enter Second Number: ");
        scanf("%lf", &num2);
        result = num1 - num2;
        printf("Here is the Result: %.2lf", result);
    }
    else if (operation == '*') {
        printf("Enter Second Number: ");
        scanf("%lf", &num2);
        result = num1 * num2;
        printf("Here is the Result: %.2lf", result);
    }
        else if (operation == '/') {
        printf("Enter Second Number: ");
        scanf("%lf", &num2);
        result = num1 / num2;
        printf("Here is the Result: %.2lf", result);
    }
    else {
        printf("Invalid Operation! --> %c <--", operation);
        return 1;
    }*/

    return 0;
}