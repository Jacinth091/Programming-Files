#include <stdio.h>
#include <math.h> // C Library for math functions for example "pow(x,y)"

int main() {
    
    double a, b, c;             // Intitialize variable a, b, and c

    printf("Input Side A: ");   // Asks for Input
    scanf("%lf", &a);           // Stores the input into the variable "a"
    
    printf("Input Side B: ");   // Asks for Input
    scanf("%lf", &b);           // Stores the input into the variable "b"

    printf("Input Side C: ");   // Asks for Input
    scanf("%lf", &c);           // Stores the input into the variable "c"
    

    
    if ( a != 0 && b != 0 && c != 0) {                      // Checks if all the variable is NOT EQUAL to zero to run
        double power[] = {pow(a,2), pow(b,2), pow(c,2)};    // Initialize array variable "power[]" that holds individual power[value]^2
        if ((power[0] + power[1]) == power[2] ) {           // checks if the sum of power[0] and power[1] is EQUAL to power[2]
            printf("\n%.2lf^2 + %.2lf^2 = %.2lf^2\n", a, b, c); // If true, it will run this block of code 
            printf("%.2lf + %.2lf = %.2lf\n", power[0], power[1], power[2]);
            printf("\nA Right Triangle!\n");
            

        }
        else {                                              // If false, it will run these block of code
            printf("\n%.2lf^2 + %.2lf^2 = %.2lf^2\n", a, b, c);
            printf("%.2lf + %.2lf = %.2lf\n", power[0], power[1], power[2]);
            printf("\nNot a Right Triangle!\n");

        }
        
    }
    else {                  // If the value of variable's a, b, and c are equal to zero, it will run these block of code
        printf("Error!");
        return 1;           // Returns status 1
    }

    
    return 0;               // Exit with status 0
}