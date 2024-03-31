#include <stdio.h>
#include <stdbool.h>
#include <ctype.h>
#include <string.h>

void clearInputBuffer();
double fMod( double dividend, double divisor);

int main(){

    double num1, num2, result;
    char operator, choice;
    bool exitLoop = false;
    char operators[] = {'+', '-', '*', '/','%'};
    char operTitles[5][25] = {"Addition", "Subtraction", "Multiplication", "Division", "Modulo"};
    char operTitle[25];
    int length = sizeof(operators)/sizeof(operators[0]);
    int errMsg;

    do{
        bool isValidOper = false, divideByZero = false;
        do{
            operator = '\0';
            printf("\n******************* Simple Calculator *******************\n"); 
            printf("\nEnter an Operator (+ - * / %%): ");
            scanf(" %c", &operator);

            for(int i = 0; i < length; i++){
                if(operator == operators[i]){
                    isValidOper = true;
                    strcpy(operTitle, operTitles[i]);
                    break;
                }
            }
            if(!isValidOper){
                printf("\nInvalid Operator, try Again!\n"); 
                while(getchar() != '\n' );
                continue;
            }
        }while(!isValidOper);

        printf("\n******************* %s *******************\n", operTitle); 

        do{
            printf("\nEnter Num One: ");
            errMsg = scanf("%lf",&num1 );
            if( errMsg != 1){
                clearInputBuffer();
                continue;
            }  
              
        }while(errMsg != 1);
        do{
            printf("Enter Num Two: ");
            errMsg = scanf("%lf",&num2 );
            if( errMsg!= 1){
                clearInputBuffer();
                continue;
            }
        }while(errMsg != 1);
        printf("\n"); 
        switch (operator)
        {
        case '+':
            result = num1 + num2;
            break;
        case '-':
            result = num1 - num2;
            break;
        case '*':
            result = num1 * num2;
            break;
        case '/':
            if(num2 == 0){
                divideByZero = true;
            }
            else{
                result = num1 / num2;
            }

            break;
        case '%':
            if(num2 == 0){
                divideByZero = true;
            }
            else{
                result = fMod(num1, num2);
            }
            break;
        }
        if(divideByZero){
            printf("\nDivision By Zero is not Allowed!\n"); 
        }
        else{
            printf("\nResult: %.2lf\n", result); 
        }

        do{
            printf("\nAgain, (Y for yes, N for No) ?: ");
            scanf(" %c", &choice);
            choice = toupper(choice);

            if(choice != 'Y' && choice != 'N'){
                printf("\nInvalid Input!\n");
                // console.clear();
                while(getchar() != '\n');
                continue;
            }
            else if(choice == 'N'){
                printf("\nGOODBYE!!!\n"); 
                exitLoop = true;
                break;
            }
        }while(choice != 'Y' && choice != 'N');
 
    }while(!exitLoop);


    return 0;
}
void clearInputBuffer(){
    int num;
    while((num = getchar()) != '\n' && num != EOF);
}
double fMod( double dividend, double divisor){
    return dividend - ((int)(dividend / divisor)) * divisor;
}