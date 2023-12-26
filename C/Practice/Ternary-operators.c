#include <stdio.h>

int findMax(int x, int y ) 
{
    /*if ( x > y) {
        return x;
    }
    else {
        return y;
    }*/

    return (x > y) ? x : y; // ternary operator example
    // if our condition is true return the value x, if false return value y
}




int main () {

    // ternary operator = shortcut to if/else when assigning/returning a value
    // (condition) ? value if true : valu if false

    int max = findMax(5,4);
    printf("\n%d\n ", max);






    return  0;
}