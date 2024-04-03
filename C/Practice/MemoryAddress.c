#include <stdio.h>

int main(){

    // memory = an array of bytes within RAM'
    // Memory Block = a single unit (byte) within memory, used to hold some value
    // Memory Address = the address of where a memory block is located 

   char a = 'Z';
   double b[10];

    printf("%d bytes\n", sizeof(a));
    printf("%d bytes\n", sizeof(b));
    // printf("%d bytes\n", sizeof(c));

    printf("%p\n", &a);
    printf("%p\n", &b);
    // printf("%p\n", &c);




    return 0;
}