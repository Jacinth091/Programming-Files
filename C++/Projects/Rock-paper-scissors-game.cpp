#include <iostream>
#include <ctime>

using std::cout;
using std::cin;
using std::string;

char getPlayerSide();
char getCompSide();
void showSide(char choice);
void chooseWinner(char computer, char player);


int main() {
    char player, computer, response;
    
    cout << "\n\nRock Paper & Scissors Game!!\n\n";

    do {
        cout << "****************************\n";

        player = getPlayerSide();
        cout << "****************************\n";
        cout << "You choose: ";
        showSide(player);

        computer = getCompSide();
        cout << "****************************\n";
        cout << "Computer choose: ";
        showSide(computer);

        cout << "****************************\n";
        chooseWinner(computer, player);

        do{    
            cout << "You want to play again? (Y/N): ";
            cin >> response;
            response = toupper(response);
            if(response == 'N'){
                break;
            }
        }while(response != 'Y' && response != 'N');

        if(response == 'N'){
                break;
        }
    }while(response == 'Y');
    cout << "Thanks For Playing!! :>\n";




}


char getPlayerSide(){
    char player;
    do
    {
        cout << "Choose what side are you playing: \n";
        cout << "****************************\n";
        cout << "\t'r' for ROCK \n";
        cout << "\t'p' for PAPER \n";
        cout << "\t's' for SCISSORS \n";
        cin >> player;
    } while (player != 'r' && player != 'p' && player != 's');
    return player;
}
char getCompSide() {
    srand(time(0));
    int randomNum = (rand() % 3) + 1;
    switch (randomNum) {
        case 1: return 'r'; break;
        case 2: return 'p'; break;
        case 3: return 's'; break;
        default: cout << "Invalid!!"; break;
    }   
    return 0;
}

void showSide(char choice){
    switch (choice) {
        case 'r': cout << "Rock" << '\n';
        break;
        case 'p': cout << "Paper" << '\n';
        break;
        case 's': cout << "Scissors" << '\n';
        break;
    }
}
void chooseWinner(char computer, char player){
    switch (player) {
        case 'r': 
            if(computer == 'r'){
                cout << "It's a Tie!\n";       
            } 
            else if (computer == 'p'){
                cout << "You Lose!\n";
            }
            else {
                cout << "You Win!\n";
            }
        break;
        case 'p': 
            if(computer == 'r'){
                cout << "You Win!\n";       
            } 
            else if (computer == 'p'){
                cout << "It's a Tie!\n";
            }
            else {
                cout << "You Lose!\n";
            }   
        break;
        case 's': 
            if(computer == 'r'){
                cout << "You Lose!\n";       
            } 
            else if (computer == 'p'){
                cout << "You Win!\n";
            }
            else {
                cout << "It's a Tie!\n";
            }
        break;
        default: cout << "ERROR!\n";
        break;                
    }

}


