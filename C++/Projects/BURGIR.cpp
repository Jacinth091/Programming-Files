#include <iostream>
#include <thread>  // Include the thread header
#include <chrono> 

using namespace std;

void burgerBuns(int& usersPick, string breadOptions[], string& playerBread);
void burgerToppings(int& usersPick, string toppingsOptions[], string& playerToppings);
void burgerPatty(int& usersPick, string pattyOptions[], string& playerPatty);



int main() {

    char  response, startGame;
    int usersPick;
    string breadOptions[] = {"Normal", "Lactose-free", "Vegan"};
    string toppingsOptions[] = {"Lettuce & Tomato", "Cucumber & Tomato", "Cheese & Tomato ", "Oninons & Pickles", "Cheese & Lettuce"};
    string pattyOptions[] = {"Pork", "Beef", "Chicken", "Egg", "Vegan"};
    string playerBread, playerToppings, playerPatty;

    cout << "********************** Make a Burgir Game **********************\n";
    
    do{
        cout << "Start Game? (Y/N): ";
        cin >> startGame;
        startGame = toupper(startGame);
        if(startGame == 'N'){
            break;
        }
    }while(startGame != 'Y' || startGame == 'N');
    if(startGame == 'N'){
        cout << "Goodbye :<\n";
    }
    else {
        do{
            do {

                cout << "Options for BUNS: \n\n";
                for(int i = 0; i < sizeof(breadOptions) / sizeof(breadOptions[0]); i++){
                    cout << "\t" << i + 1 << ". " << breadOptions[i] << '\n';
                }

                burgerBuns(usersPick, breadOptions, playerBread);
            } while (usersPick != 1 && usersPick != 2 && usersPick != 3);

            
            do {
                cout << "\nOptions for Toppings: \n\n";
                for(int i = 0; i < sizeof(toppingsOptions) / sizeof(toppingsOptions[0]); i++){
                    cout << "\t" << i + 1 << ". " << toppingsOptions[i] << '\n';
                }

                burgerToppings(usersPick, toppingsOptions, playerToppings);

            }while (usersPick != 1 && usersPick != 2 && usersPick != 3 && usersPick != 4 && usersPick != 5);

            do {
                cout << "\nOptions for Burger Patty: \n\n";
                for(int i = 0; i < sizeof(pattyOptions) / sizeof(pattyOptions[0]); i++){
                    cout << "\t" << i + 1 << ". " << pattyOptions[i] << '\n';
                }

                burgerPatty(usersPick, pattyOptions, playerPatty);
            }while(usersPick != 1 && usersPick != 2 && usersPick != 3 && usersPick != 4 && usersPick != 5);

            cout << "Creating your Burger... \n\n";
            cout.flush();  // Flush the buffer to ensure the message is displayed

            // Sleep for 2 seconds (adjust the duration as needed)
            this_thread::sleep_for(chrono::seconds(2));

            cout << "Here is your " << playerBread << " burger"<< ", with " << playerToppings << " toppings and a(n) " << playerPatty << " patty"<< "." << "\nEnjoy!!" << '\n';

            do {
                cout << "\n\nAgain? (Y/N): ";
                cin >> response;
                response = toupper(response);
                if (response == 'N'){
                    break;
                }    	
            }while (response != 'Y' && response != 'N');
                if (response == 'N') {
                    cout << "Thanks, see you again!" << '\n' <<'\n';
                    break;
                }

        }while (response == 'Y');
    }




}

void burgerBuns(int& usersPick, string breadOptions[], string& playerBread){
    cout << "\nWhat bread would you like to choose? (1-3): ";
    cin >> usersPick;

    switch (usersPick)
    {
    case 1: playerBread = breadOptions[0];
            cout << "You Picked: " << playerBread << " Buns" << '\n';
            
        break;
    case 2: playerBread = breadOptions[1];
            cout << "You Picked: " << playerBread << " Buns" << '\n';
        break;
    case 3: playerBread = breadOptions[2];
            cout << "You Picked: " << playerBread << " Buns" << '\n';
        break;
    
    default: cout << "Invalid bread selection. Please choose a number between 1 and 3.\n";
        break;
    }
    // usersPick = 
}

void burgerToppings(int& usersPick, string toppingsOptions[], string& playerToppings){
    cout << "\nWhat toppings would you like to choose? (1-5): ";
    cin >> usersPick;

    switch (usersPick)
    {
    case 1: playerToppings = toppingsOptions[0];
            cout << "You Picked: " << playerToppings << " Toppings" << '\n';
        break;
    case 2:  playerToppings = toppingsOptions[1];
            cout << "You Picked: " << playerToppings << " Toppings" << '\n';
        break;
    case 3:  playerToppings = toppingsOptions[2];
            cout << "You Picked: " << playerToppings << " Toppings" << '\n';
        break;
    case 4:  playerToppings = toppingsOptions[3];
            cout << "You Picked: " << playerToppings << " Toppings" << '\n';
        break;
    case 5:  playerToppings = toppingsOptions[4];
            cout << "You Picked: " << playerToppings << " Toppings" << '\n';
        break;
    
    default: cout << "Invalid toppings selection. Please choose a number between 1 and 5.\n";
        break;
    }

}

void burgerPatty(int& usersPick, string pattyOptions[], string& playerPatty){
    cout << "\nWhat burger patty would you like to choose? (1-5): ";
    cin >> usersPick;

    switch (usersPick)
    {
    case 1: playerPatty = pattyOptions[0];
            cout << "You Picked: " << playerPatty << " Patty" << '\n';
        break;
    case 2: playerPatty = pattyOptions[1];
            cout << "You Picked: " << playerPatty << " Patty" << '\n';
        break;
    case 3:playerPatty = pattyOptions[2];
            cout << "You Picked: " << playerPatty << " Patty" << '\n';
        break;
    case 4: playerPatty = pattyOptions[3];
            cout << "You Picked: " << playerPatty << " Patty" << '\n';
        break;
    case 5:playerPatty = pattyOptions[4];
            cout << "You Picked: " << playerPatty << " Patty" << '\n';
        break;
    
    default:  cout << "Invalid patty selection. Please choose a number between 1 and 5.\n";
        break;
    }
    
}
