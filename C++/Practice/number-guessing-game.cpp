#include <iostream>
#include <ctime>

using std::cout;
using std::cin;
using std::string;

int main() {

    int num, guess, tries = 0;

    srand(time(0));

    num = (rand() % 100) + 1;

    cout << "************* Number Guesing Game *************\n";


    do {
        cout << "Enter a guess between (1- 100): ";
        cin >> guess; 
        tries++;

        if (guess > num) {
            cout << "Too High, try lower. \n";
        }
        else if(guess < num ){
            cout << "Too Low, try higher.\n";

        }
        else {
            cout << "Correct!\nYou've guessed " << tries << " times! "<<'\n';
        }


    }while (guess != num);

        cout << "*******************************************\n";




}