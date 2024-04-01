
#include <stdio.h>
#include <stdbool.h>
#include <ctype.h>

void clearInputBuffer();
void dispArr(char *array[], int length);
int dispAndGetUserIn(char *array[], int length);

void checkBalance(double balance);
double depositMoney(double currentBalance);
int main()
{
    printf("\n****************** Simple Bank Program ******************\n\n");
    
    double deposit=0, withdraw=0, balance = 10000.00;
    char *bankMenu[] = {"Check Balance", "Deposit Money", "Withdraw Money", "Review Transactions", "Exit"};
    char choice;
    bool exitLoop, tryAgain;
    int length = sizeof(bankMenu)/sizeof(bankMenu[0]);
    int userIn = 0;
    double temp;


        printf("\n Welcome To the Bank \n");
    do{
        userIn =0;
        exitLoop = false;
        printf("\n Choose your Options \n");
        userIn = dispAndGetUserIn(bankMenu, length);

        // printf("User Input : %d", userIn);
        switch(userIn){
            case 1:
                checkBalance(balance);
            continue;

            case 2:
                balance = depositMoney(balance);
            continue;

            case 3:
            
            continue;

            case 4:
            
            continue;

            case 5:
                // exitLoop = true;
                printf("\nThank You for your cooperation!, Come Back Again!\n");
            break;


            default:

            break;
        }
        do{
            tryAgain = false;
            printf("\nTry Again? (Y = YES, N = NO)\n");
            printf("------->: ");
            scanf(" %c", &choice);
            choice = toupper(choice);

            if(choice != 'Y' && choice != 'N'){
                printf("\nInvalid Input, try again!\n");
                while(getchar() != '\n');
                continue;
            }
            else if( choice == 'Y'){
                tryAgain = true;
            }
            else{
                tryAgain = true;
                exitLoop = true;
                printf("\nNow Exiting.... \n");

            }



        }while(!tryAgain);
        
        
    }while(!exitLoop);
    
    return 0;
}

void checkBalance(double balance){

    printf("\n******************* Current Bank Balance *******************\n");

    printf("\nYour Balance: %.2lf\n", balance);

    printf("\n************************************************************\n");

}

double depositMoney(double currentBalance){
    double userDepos = 0;
    bool isInputValid = false;
    int maxDepo = 1000000;
    printf("\n******************* Depost Money *******************\n");

    printf("\nHow much money you want to Deposit?\n");
    
    do{
        printf("Your Deposit: ");
        if(scanf("%lf", &userDepos) != 1){
            printf("\nInvalid Input, try again!\n");
            clearInputBuffer();
            continue;
        }
        else if( userDepos > maxDepo){
            printf("\nMaximum Deposit Reached!, You can only Deposit value of 1,000,000 below!\n");
            clearInputBuffer();
            continue;
        }
        else{
            isInputValid = true;
        }
    }while(!isInputValid);

    currentBalance += userDepos;

    printf("\n************************************************************\n");




    return currentBalance;
}

void clearInputBuffer(){
    int num;
    while((num = getchar()) != '\n' && num != EOF);
    
    
}

void dispArr(char *array[], int length){
    
    for(int i = 0; i < length; i++){
        printf(" %d. %s\n",(i+1), array[i]);
    }
    
}
int dispAndGetUserIn(char *array[], int length){
    int userIn =0;
    bool isInputValid = false;

    do{
        dispArr(array, length);
        printf("Your choice ==>: ");
        if(scanf("%d", &userIn) != 1){
            printf("\nInvalid Input, try again!\n");
            clearInputBuffer();
            continue;
        }
        else if( userIn > length || userIn <= 0){
            printf("\nOut of Range, try again!\n");
            clearInputBuffer();
            continue;
        }
        else{
            isInputValid = true;
        }



    }while(!isInputValid);

    return userIn;


}
















