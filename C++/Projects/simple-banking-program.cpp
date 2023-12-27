#include <iostream>
#include <iomanip>

using std::cout;
using std::cin;
using std::string;
using std::setprecision;
using std::fixed;

void showBalance(double balance);
double bankDeposit(double balance);
double bankWithdraw(double balance);

int main() {

    double balance = 0;
    int userChoice = 0;

    do{

        cout << "*************************\n";
        cout << "      "<< "BANK" << '\n';
        cout << "*************************\n";
        cout << "    " << "1. Show Balance. " << '\n';
        cout << "    " << "2. Deposit Money. " << '\n';
        cout << "    " << "3. Withdraw Money. " << '\n';
        cout << "    " << "4. Exit. " << '\n';
        cout << "*************************\n";


        cout << "Enter your choice: ";
        cin >> userChoice;

        cin.clear();
        fflush(stdin);
        switch (userChoice){
            case 1: showBalance(balance);
            break;
            
            case 2: balance += bankDeposit(balance);
                    showBalance(balance);

            break;
            case 3: balance -= bankWithdraw(balance);
                    showBalance(balance);
            break;
            case 4: cout << "Thanks for Visting! \n";
            break;
        
            default: cout << "Invalid Choice!\nTry Again!!\n";
            break;
        }

    }while (userChoice != 4);

}
void showBalance(double balance){
    cout << "Your current balance is: $" << setprecision(2) << fixed << balance << '\n';


}
double bankDeposit(double balance){
    double amount = 0;

    cout << "Enter amount to be DEPOSITED: $";
    cin >> amount;

    if(amount > 0) {
        return amount;
    }
    else {
        cout << "Invalid Amount!\n\n";
        return 0;
    }





}
double bankWithdraw(double balance){
    double amount = 0;

    cout << "Enter amount to be WITHDRAWN: $";
    cin >> amount;

    if (amount < 0) {
        cout << "Invalid Amount! \n\n";
        return 0;
    }
    else if(amount > balance) {
        cout << "You have insufficient funds to WITHDRAW! \n\n";
        return 0;
    }
    else {
        return amount;
    }

}