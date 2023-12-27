#include <iostream>

using std::cout;
using std::cin;
using std::string;

int main() {

    char usersPick, response, startGame;
    string breadOptions[] = {"Normal", "Lactose-free", "Vegan"};
    string toppingsOption[] = {"Lettuce", "Tomato", "Cucumber", "Cheese", "Oninons", "Pickles"};
    string pattyOptions[] = {"Meat", "Chicken", "Egg", "Vegan-Patty"};

    cout << "********************** Make a Burgir Game **********************\n";
    
    // do{
        cout << "Start Game? (Y/N): ";
        cin >> startGame;
        startGame = toupper(startGame);

    // // }while(startGame != 'Y' && startGame != 'N');
    // string options[sizeof(breadOptions) / sizeof(breadOptions[0])];


    cout << "Options for BUNS: \n\n";
    for(int i = 0; i < sizeof(breadOptions) / sizeof(breadOptions[0]); i++){
        cout << "\t" << i + 1 << ". " << breadOptions[i] << "." << '\n';
        // options[i] += breadOptions[i];
    }
    cout << "What bread would you like to choose? (1-3): ";
    cin >> usersPick;

    switch (usersPick)
    {
    case '1':   
        
        break;
    
    default:
        break;
    }

//  continuation    hahhahah
    




    



}