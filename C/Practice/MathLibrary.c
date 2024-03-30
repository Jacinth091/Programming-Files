#include <stdio.h>
#include <math.h>

int main(){


    double A = sqrt(9);
    double B = pow(2, 4);
    int C = round(3.14);
    int D = ceil(3.14);
    int E = floor(3.99);
    double F = fabs(-100);
    double G = log(3);
    double H = sin(45);
    double I = cos(45);
    double J = tan(45);

    printf("<math.h> Library: \n\n"); 
    printf("(sqrt)  A: %.2lf\n", A); 
    printf("(pow)   B: %.2lf\n", B); 
    printf("(round) C: %d\n", C); 
    printf("(ciel)  D: %d\n", D); 
    printf("(floor) E: %d\n", E); 
    printf("(fabs)  F: %.2lf\n", F); 
    printf("(log)   G: %.2lf\n", G); 
    printf("(sin)   H: %.2lf\n", H); 
    printf("(cos)   I: %.2lf\n", I); 
    printf("(tan)   J: %.2lf\n", J); 



    return 0;
}