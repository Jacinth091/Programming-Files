
#include <stdio.h>
#include <stdbool.h>
#include <ctype.h>

void clearInputBuffer();
void dispArr(char *array[], int length);
int dispAndGetUserIn(char *array[], int length);

void checkBalance(double balance, char title[]);
double depositMoney(double currentBalance);
double withdrawMoney(double currentBalance);
int main()
{
    const double seedBalance = 1000000.00;
    printf("\n****************** Simple Bank Program ******************\n\n");
    
    double deposit=0, withdraw=0, balance = seedBalance;
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
        userIn = dispAndGetUserIn(bankMenu, length);

        // printf("User Input : %d", userIn);
        switch(userIn){
            case 1:
                checkBalance(balance, "Current");
            continue;

            case 2:
                balance = depositMoney(balance);
            continue;

            case 3:
                balance = withdrawMoney(balance);
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
                balance = seedBalance;
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

void checkBalance(double balance, char title[]){



    printf("\n******************* %s Bank Balance *******************\n", title);

    printf("\nYour Balance: %.2lf\n", balance);

    printf("\n************************************************************\n");

}

double withdrawMoney(double currentBalance){

    double userWithdraw = 0;
    bool isInputValid = false, deductBalance;
    int maxWithdraw = currentBalance;

    char choice;
    printf("\n******************* Withdraw Money *******************\n");

    printf("\nHow much money you want to WITHDRAW for your account?\n");
    
    do{
        printf("Amount to Withdraw: ");
        if(scanf("%lf", &userWithdraw) != 1){
            printf("\nInvalid Input, try again!\n");
            clearInputBuffer();
            continue;
        }
        else if( userWithdraw > maxWithdraw){
            printf("\nInsuffcient Balance!, try again\n");
            clearInputBuffer();
            continue;
        }
        else if(userWithdraw <= 0){
            printf("\nYou are not allowed enter amount of 0 or below!, try again!\n");
            clearInputBuffer();
            continue;
        }
        else if(userWithdraw == currentBalance){

            printf("\nYou are about to EMPTY your Account, would you like to proceed?\n");
            do{
                deductBalance =false;
                printf("\n(Y = YES, N = NO)\n");
                printf("------->: ");
                scanf(" %c", &choice);
                choice = toupper(choice);

                if(choice != 'Y' && choice != 'N'){
                    printf("\nInvalid Input, try again!\n");
                    while(getchar() != '\n');
                    continue;
                }
                else if( choice == 'Y'){
                    printf("\nWithdrwaing (%.2lf) from your account, please wait.....\n",userWithdraw); 
                    break;
                }
                else{
                    printf("\nWhat amount would you like to Withdraw?\n");
                    deductBalance = true;
                    break;

                }



            }while(true);

            if(deductBalance){
                continue;
            }
            else{
                isInputValid = true;
                break;
            }


        }   
        else{

             printf("\nYou are about to Withdraw (%.2lf) from your Account, would you like to proceed?\n", userWithdraw);
            do{
                printf("\n(Y = YES, N = NO)\n");
                printf("------->: ");
                scanf(" %c", &choice);
                choice = toupper(choice);

                if(choice != 'Y' && choice != 'N'){
                    printf("\nInvalid Input, try again!\n");
                    while(getchar() != '\n');
                    continue;
                }
                else if( choice == 'Y'){
                    printf("\nWithdrwaing (%.2lf) from your account, please wait.....\n",userWithdraw); 
                    break;
                }
                else{
                    printf("\nWhat amount would you like to Withdraw?\n");
                    deductBalance = true;
                    break;

                }



            }while(true);

            if(deductBalance){
                continue;
            }
            else{
                isInputValid = true;
            }
        }
    }while(!isInputValid);

    currentBalance -= userWithdraw;

    printf("\n*******************************************************\n");

    checkBalance(currentBalance, "New"); 


    return currentBalance;

    
}

double depositMoney(double currentBalance){
    double userDepos = 0;
    bool isInputValid = false, addBalance;
    int maxDepo = 2000000;
    char choice;
    printf("\n******************* Depost Money *******************\n");

    printf("\nHow much money you want to DEPOSIT from your account?\n");
    
    do{
        printf("Amount to Deposit: ");
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
        else if(userDepos < 0){
            printf("\nYou are not allowed to put value below 0!, try again!\n");
            clearInputBuffer();
            continue;
        }   
        else{
             printf("\nYou are about to Deposit (%.2lf) into your Account, would you like to proceed?\n",userDepos);
            do{
                addBalance = false;
                printf("\n(Y = YES, N = NO)\n");
                printf("------->: ");
                scanf(" %c", &choice);
                choice = toupper(choice);

                if(choice != 'Y' && choice != 'N'){
                    printf("\nInvalid Input, try again!\n");
                    while(getchar() != '\n');
                    continue;
                }
                else if( choice == 'Y'){
                    printf("\nDepositing (%.2lf )into your account, please wait.....\n", userDepos); 
                    break;
                }
                else{
                    printf("\nWhat amount would you like to Deposit?\n");
                    addBalance = true;
                    break;

                }



            }while(true);

            if(addBalance){
                continue;
            }
            else{
                isInputValid = true;
            }
        }
    }while(!isInputValid);

    currentBalance += userDepos;

    printf("\n*******************************************************\n");

    checkBalance(currentBalance, "New"); 


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
        printf("\n Choose your Options \n");
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
















