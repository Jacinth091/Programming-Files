#include <stdio.h>

double square (double x) 
{
    double result = x*x;
    return result; // returns to the calling function in int main

    /*eturn x *x;*/

    

}
int main () {
    // return = returns a value back to a calng function
    
    double x = square(3.14); // the calling function to double result
    printf("\n%.2lf\n ", x);
    
    
    return 0; // the exit status that tells us the program has exited succesfully
}