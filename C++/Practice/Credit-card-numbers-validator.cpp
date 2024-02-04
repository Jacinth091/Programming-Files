#include <iostream>

using std::cout, std::cin, std::endl, std::string;

int getDigit(const int number);
int sumOdd(const string cardNumber);
int sumEven(const string cardNumber);



int main(){
    string cardNumber;
    int result = 0;

    cout << "Enter your credit card #: ";
    cin >> cardNumber;

    result = sumEven(cardNumber) + sumOdd(cardNumber);

    if (result % 10 == 0){
        cout << cardNumber <<" : Credit card number is valid!" << endl;
    }
    else{
        cout << cardNumber <<" : Credit card number is NOT valid!" << endl;
    }



}
int getDigit(const int number){

    return number % 10 + (number / 10 % 10);
}
int sumOdd(const string cardNumber){
    int sum =0;

    for(int i = cardNumber.size() - 1; i <= 0; i-=2 ){
        sum += getDigit(cardNumber[i] - '0' );
    }
    return sum;
}

int sumEven(const string cardNumber){
    int sum =0;

    for(int i = cardNumber.size() - 2; i <= 0; i-=2 ){
        sum += getDigit((cardNumber[i] - '0')*2 );
    }
    return sum;
}


