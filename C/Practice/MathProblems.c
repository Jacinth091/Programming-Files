#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>
#include <ctype.h>

void clearInputBuffer();
void calcCircum();
void calcHypo();
void tempConvert();
void simpleCalcu();
const double PI = 3.14159;

int main(){

    bool exitLoop;
    char choice;
    char probl[4][25] = {"Solve for Circumference", "Solve for Hypotenuse", "Temperature Conversion", "Simple Calculator"};
    int userChoice, length = sizeof(probl)/sizeof(probl[0]);
    do
    {   
        userChoice = 0;
        printf("\nMath Problems\n\n"); 
        for(int i =0; i < length; i++){
            printf("%d). %s\n", (i+1), probl[i]); 
        }

        printf("\n\n"); 
        

        printf("What problem you want to solve?: ");
        if(scanf("%d", &userChoice) != 1){
            printf("Not a number!, try again!\n"); 
            clearInputBuffer();
            continue;
        }
        else{
            if(userChoice > length || userChoice <= 0){
                printf("Out of Range!, try again\n"); 
                continue;
            }
            else{
                switch(userChoice){
                        case 1:
                        calcCircum();
                        break;

                        case 2:
                        calcHypo();
                        break;

                        case 3:
                        tempConvert();
                        break;

                        case 4:
                        simpleCalcu();
                        break;
                        default:
                        printf("Invalid\n");
                        break;  
                    }   
                    
                do{
                    printf("Again, (Y for yes, N for No) ?: ");
                    scanf(" %c", &choice);
                    choice = toupper(choice);

                    if(choice != 'Y' && choice != 'N'){
                        printf("Invalid Input!\n\n");
                        // console.clear();
                        while(getchar() != '\n');
                        continue;
                    }
                    else if(choice == 'Y'){
                        break;
                    }
                    else{
                        printf("GOODBYE!!!\n"); 
                        exitLoop = true;
                        break;
                    }

                }while(true);
            }
        }
    } while(!exitLoop);

    // tempConvert();

    return 0;
}
void calcCircum(){

    double radius = 0 ;
    double circum = 0;
    double area = 0;
    printf("****************** Circumference ******************\n\n"); 
    printf("\nWhat is the radius of the circle?: ");
    scanf("%lf", &radius);

    circum = 2 * PI * radius;
    area = PI * (radius*radius);

    printf("\nCicumference: %.2lfm\n", circum);
    printf("Area: %.2lfm\n", area);   

    

}

void calcHypo(){

    double a, b, c;
    double result;
    printf("****************** Hypotenuse ******************\n\n"); 

    printf("Side A: ");
    scanf("%lf", &a );  

    printf("Side B: ");
    scanf("%lf", &b );

    c = sqrt(pow(a, 2) + pow(b,2));

    printf("Hypotenuse: %.2lf\n", c); 

}
void clearInputBuffer(){
    int number;
    while((number = getchar()) != '\n' && number != EOF);
}
void tempConvert(){

    printf("****************** Temperature Conversion ******************\n\n"); 

    char unit;
    double temp,tempTwo;

    printf("\nIs the the temperature in (F) or (c)?: ");
    scanf(" %c", &unit);
    unit = toupper(unit);

    if(unit == 'C'){
        printf("\nEnter the Temperature in Celsuis: ");
        scanf("%lf", &temp);
        tempTwo = temp;
        temp = ((temp * 9) / 5) + 32;  

        printf("\nThe temp %.2lf converted to Farenheit is: %.2lf\n", tempTwo, temp); 
    }
    else if(unit == 'F'){
        printf("\nEnter the Temperature in Fahrenheit: ");
        scanf("%lf", &temp);
        tempTwo = temp;
        temp = ((temp - 32) * 5) / 9;  
        printf("\nThe temp %.2lf converted to Celsuis is: %.2lf\n", tempTwo, temp); 
    }
    else {
        printf("You're in Hell bruh\n"); 
    }

    
    

}

void simpleCalcu(){

    printf("****************** Temperature Conversion ******************\n\n"); 

    char oper;
    double num1, num2, result;
    bool divideByZero = false, invalidOper = false;

    printf("Enter an Operator (+ - * / %%): ");
    scanf(" %c",&oper );

    printf("Enter num1: \n");
    scanf("%lf", &num1);    

    printf("Enter num2: \n");
    scanf("%lf", &num2);

    switch (oper)
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
            result = (int) num1 % (int)num2;
        }
        break;
    
    default:
        invalidOper =true;
        
        break;
    }
    if(!invalidOper){
        if(divideByZero){
            printf("Division By Zero is not Allowed!\n"); 
        }
        else{
            printf("Result: %.2lf\n", result); 
        }
    }
    else{
        printf("Invalid Operation!\n"); 
    }





}