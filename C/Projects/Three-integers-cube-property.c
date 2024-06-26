#include <stdio.h>
#include <math.h> // Library for math function for example "pow(x,y)"

int main() {

    int userInput, digit;               // Initialize variable
    int input_Arr[3] = {0};        // Inititalize array variable
    int total = 0;                      // Initialize total and declaring it to equal to zero
    int size = sizeof(input_Arr) / sizeof(input_Arr[0]);        // Inititalize array variable

    
    printf("Input Only Three numbers: ");       // Asks for input
    scanf("%d", &userInput);                    // Stores the input into the "userInput" variable

    int duplicatedInput = userInput;            // Initialize "duplicatedInput" to be equal to the "userInput"
                                                // to duplicate the value stored in "userInput"
    for (int i = 0; i < size; ++i) {               // Looping to seperate individual digits from "duplicatedInput" variable
        digit = duplicatedInput %10;            // "duplicatedInput % 10" to remove the last number and then stores it to "digit" variable
        // printf("%d", digit);
        input_Arr[i] = digit;                  // The stored integers in "digit" will be stored in "input_Arr[]" in every loop
        duplicatedInput /= 10;                  // duplicatedInput is divided by 10 => 123 / 10 = 12 => 12 /10 = 1 and so on
        // printf("%d", duplicatedInput);

    }
    for(int i = 0; i < sizeof(input_Arr)/ sizeof(input_Arr[0]); i++){
        printf("%d ", input_Arr[i]);
    }
    for (int i = 0; i <size; ++i) {               // looping for the power ^ of 3 in every value stored in "input_Arr[]"
        total += pow(input_Arr[i], 3);          // input_Arr[value]^3 is being summed up inside "total" variable
    }

    printf("\nInputted Number: %d", userInput);    // Prints the Original User input stored in "userInput"
    printf("\nTotal: %d", total);                  // Prints the value stored inside the "total" variable

    if (total == userInput ){                   // Checks if the 'total" variable is EQUAL to the "userInput" variable
        printf("\nCondition: SATISFIED!\n");    // if true, it will display this block of code
        printf("Total value of %d is EQUAL to the Input number %d\n", total, userInput);
    }
    else {
        printf("\nCondition: NOT SATISFIED!\n"); // If false, it will run this block of code
        printf("Total value of %d is NOT EQUAL to the input number %d\n", total, userInput);
    }
    return 0; // Exit code with status 0
}

