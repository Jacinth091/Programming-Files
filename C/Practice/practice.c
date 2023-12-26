#include <stdio.h>

int main ()
{

    // This is an example of a single line comment

    /* This 
        is 
        a 
        Multi
        Line
        Comment
    */

   /*   escape sequence = character combination consisiting of a backslash \
                          followed by a letter or combination of digits.
                          They specify actions within a line or string of text.
                          \n = new line
                          \t = tab 
   */


    // printf("1\t2\t3\n4\t5\t6\n7\t8\t9"); = combining escape sequences \n + \t to make a 
    //                                        grid of evenly spaces numbers both hrozontally
    //                                        and vertically


    /*  printf("\"I like bitches\" - Your Mom Preferably"); = displaying "" without making
                                                              the compiler display an error
                                                              \" is used


    */

    /*  variable = Allocated space in memory to store a value
                   We refer to a variable's name to access the stored value.
                   That variable now behaves as if it was the value it contains.
                   BUT we need to declare what type of data we are storing.

    */
   /*
   int x;       // declaration "int" is one of data types it means integer
   x = 123;         // initialization you are now storing a value inside the declared int data type 
   int y = 321;     // combining declaration + initialization in a single line


    int age = 20;           // int can only hold "whole numbers"
    float gpa = 1.02;       // floating point number it can only hold a number that has a decimal portion
    char grade = 'A';       // char stores a single character

    // Strings are objects in C because C is not object oriented langauge, there is no string data types

    char name[] = "Jacinth";    // In order to display string of characters we must use an array 

    // in order to display the stored values inside variables
    // we need to put a format specifier
    // % = serves as a placeholder and d = decimal
    // %d for decimals
    // %s for strings
    // %c for characters
    // %f for float
    
    printf("Hello! My Name is %s\n", name);
    printf("and I'm %d years old\n" ,age);
    printf("My highest grade is %c\n", grade);
    printf("My gpa is %f", gpa);*/

    /*
    // CONSTANT = fixed value that cannot be altered by the 
    //            program during its execution.
    //            In order for the assigned value to not change
    //            whatsowver use "const" before the variable

    const float PI = 3.14159;

    printf("%f", PI);*/

    /*
        ARITHMETIC OPERATORS

        + (addition)
        - (subtraction)
        * (multipilication)
        / (division)
        % (modulus)
        ++ (increment)
        -- (decrement)

    */
   /*
    int x = 5;
    int y = 2;

    /*int z = x + y;
    int z = x - y;
    int z = x * y;
    float z = x / (float)y;
    int z = x % y;

    x++;
    y--;

    printf("%d", y);*/

    /*
        AUGMENTED ASSIGNMENT OPERATORS = used to replace a statement where
                                         an operator takes a variable as one
                                         of its arguments and then assigns the
                                         results back to the same variable
                                         Example: 
                                         x = x + 1
                                         x+=1
    
    */
   /*
   int x = 10;

   //x = x + 2;
   //x+=2;

   //x = x - 3;
   //x-=3;

   //x = x * 4;
   //x*=4;
   
   // x = x / 5;
   // x/=5;

   // x = x % 2;
   // x%=5;

   printf("%d", x);*/




    return 0;
}