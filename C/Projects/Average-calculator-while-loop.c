#include <stdio.h>

int main () {
    int count;  // declaring the variable
    int total;  // declaring the variable
    int input;  // declaring the variable
    float ave;  // declaring the variable

    count = 0;  // declaring the value inside the variable
    total = 0;  // declaring the value inside the variable


    while (count <= 4)  // while count is less than or equal to '4' 
    {                                               // These statements will run on a loop
        printf("Enter Number : ");                  //  Asks for user input
        scanf("%d", &input);                        //  Scans the input and store it into the 'input' variable
        total+=input; // total = total + input;     //  increment the "total" variable by adding it with the "input" var
        count++;                                    //  increment the "count" variable in each loop
    }
                                                // outside of the while statement
    ave =  total / count;                       // initializing the average to be equal to (total / count)  
    printf("Result: %.2f", ave);               // Printing the result back to the user

    return 0;
}