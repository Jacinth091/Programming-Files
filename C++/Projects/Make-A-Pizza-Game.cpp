#include <iostream>
#include <string>
#include <algorithm>
#include <limits>

using namespace std;

void makePizza(string bread, string titles[]);
void makePizza(string bread, string sauce, string titles[]);
void makePizza(string bread, string sauce, string cheese, string titles[]);
void makePizza(string bread, string sauce, string cheese, string topping, string titles[]);
// void ingredSelection(int size, int &response, string breadList[], string sauceList[], string cheeseList[], string toppingList[], string &bread, string &sauce, string &cheese, string &topping, char ingredKeys[]);
void clearInputBuffer();
void selectIngred(int userPick, int playerResponse, int size, string breadList[], string sauceList[], string cheeseList[], string toppingList[], string &bread, string &sauce, string &cheese, string &topping, string playerPizza);
void printItemsArray(string arrayList[], int arr_Size, string title);




int main() {
    int response = 0, choice = 0;
    string bread, sauce, cheese, topping, playerPizza, playerPizzaTemp;
    string pizzaKind[] = {"Bread", 
                          "Bread And Sauce",
                          "Bread, Sauce And Cheese",
                          "Bread, Sauce, Cheese, And Topping"};
    string breadList[] = {"Sourdough", "French", "Neoplitan", "Gluten-Free", "New York Style"};
    string sauceList[] = {"Marinara", "Alfredo", "Pesto", "Spicy Red", "BBQ"};
    string cheeseList[] = {"Mozzarella", "Provolone", "Fontina", "Muenster Cheese", "Cheddar"};
    string toppingList[] = {"Pepperoni", "Hawaiian (Ham & Pineapple)", "Capricciosa", "Supreme", "BBQ Meat"};
    char ingredKeys[4];
    int size = sizeof(breadList) / sizeof(breadList[0]);

    cout << "Make your own Pizza!"<< endl;
    cout << "Choose what kind of pizza you want to make: " << endl;
    cout << endl;
    for(int i = 0; i <sizeof(pizzaKind)/sizeof(pizzaKind[0]); i++){
        cout << "  " << i + 1 << ". " <<pizzaKind[i] << endl;
    }
    cout << endl;

    cout << "Your pick?: (1-4): ";
    do{
        // Check if the input is an integer
        if (cin >> response) {
            if (response != 1 && response != 2 && response != 3 && response != 4) {
                cout << "Please enter a valid response (1-4), try again: ";
                clearInputBuffer();
            } else {
                break;
            }
        } else {
            cout << "Invalid input. Enter a numeric value only (1-4), try again: ";
            clearInputBuffer();
        }

    }while(true);
    cout << endl;
    playerPizza = pizzaKind[response - 1];
    playerPizzaTemp = playerPizza;

    transform(playerPizzaTemp.begin(), playerPizzaTemp.end(), playerPizzaTemp.begin(), ::tolower);

    switch (response)
    {
    case 1:
        cout << "Really? Only " << playerPizzaTemp << "?" << endl;
        cout << "It's not even a pizza at this point. "<< endl ;
        cout << "It's just bread, a plain and boring bread." << endl << endl;
        
        break;
    case 2:
        cout << "You've picked the worst kind of pizza." << endl << "A " << playerPizzaTemp << " pizza, really?" << endl;
        cout << "Are you serious? Or are you hurt? Who hurt you?" << endl << endl;
        break;
    case 3:
        cout << "One step at a time huh?" << endl; 
        cout << "A " << playerPizzaTemp << " pizza, it's almost there." << endl;
        cout << "Hoping you'll not get bored with all those cheese." << endl << endl;
        break;
    case 4:
        cout << "Now that's more I like it, a proper pizza." << endl; 
        cout<< "A " << playerPizzaTemp << " pizza, nice choice!" << endl;
        cout << "You are gonna be a successful one in the future, you know that right?" << endl << endl;
        break;
    
    default:
        break;
    }

    selectIngred(choice, response, size, breadList, sauceList, cheeseList, toppingList, bread, sauce, cheese, topping, playerPizza);


    return 0;
}

void selectIngred(int userPick, int playerResponse, int size, string breadList[], string sauceList[], string cheeseList[], string toppingList[], string &bread, string &sauce, string &cheese, string &topping, string playerPizza){
    string titles[] = {"bread", "sauce", "cheese", "topping"};
    switch(playerResponse){
        case 1: 
            cout << playerPizza << " Pizza." << endl << endl;
            cout << "Choose your preferred bread: "<< endl;
            printItemsArray(breadList, size, titles[0]);
            cout << "Your pick? (1-5): ";
            do{
                if (cin >> userPick) {
                    if (userPick != 1 && userPick != 2 && userPick != 3 && userPick != 4 && userPick != 5) {
                        cout << "Please enter a valid response (1-5), try again: ";
                        clearInputBuffer();
                    } else {
                        bread = breadList[userPick - 1];
                        break;
                    }
                } else {
                    cout << "Invalid input. Enter a numeric value only (1-5), try again: ";
                    clearInputBuffer();
                }

            }while(true);
            cout << endl;
            cout << "You have picked: " << bread << " " << titles[0] << endl << endl;
            cout << endl;
            makePizza(bread, titles);

        break;
        case 2: 
            cout << playerPizza << " Pizza." << endl << endl;
            cout << "Choose your preferred bread: "<< endl;
            printItemsArray(breadList, size, titles[0]);
            cout << "Your pick? (1-5): ";
            do{
                if (cin >> userPick) {
                    if (userPick != 1 && userPick != 2 && userPick != 3 && userPick != 4 && userPick != 5) {
                        cout << "Please enter a valid response (1-5), try again: ";
                        clearInputBuffer();
                    } else {
                        bread = breadList[userPick - 1];
                        break;
                    }
                } else {
                    cout << "Invalid input. Enter a numeric value only (1-5), try again: ";
                    clearInputBuffer();
                }

            }while(true);
            cout << endl;
            cout << "You have picked: " << bread << " " << titles[0] << endl << endl;

            cout << "Choose your preferred sauce: "<< endl;
            printItemsArray(sauceList, size, titles[1]);
            cout << "Your pick? (1-5): ";
            do{
                if (cin >> userPick) {
                    if (userPick != 1 && userPick != 2 && userPick != 3 && userPick != 4 && userPick != 5) {
                        cout << "Please enter a valid response (1-5), try again: ";
                        clearInputBuffer();
                    } else {
                        sauce = sauceList[userPick - 1];
                        break;
                    }
                } else {
                    cout << "Invalid input. Enter a numeric value only (1-5), try again: ";
                    clearInputBuffer();
                }

            }while(true);
            cout << endl;
            cout << "You have picked: " << sauce << " " << titles[1] << endl << endl;
            cout << endl;
            makePizza(bread, sauce, titles);
        break;
        case 3: 
            cout << playerPizza << " Pizza." << endl << endl;
            cout << "Choose your preferred bread: "<< endl;
            printItemsArray(breadList, size, titles[0]);
            cout << "Your pick? (1-5): ";
            do{
                if (cin >> userPick) {
                    if (userPick != 1 && userPick != 2 && userPick != 3 && userPick != 4 && userPick != 5) {
                        cout << "Please enter a valid response (1-5), try again: ";
                        clearInputBuffer();
                    } else {
                        bread = breadList[userPick - 1];
                        break;
                    }
                } else {
                    cout << "Invalid input. Enter a numeric value only (1-5), try again: ";
                    clearInputBuffer();
                }

            }while(true);
            cout << endl;
            cout << "You have picked: " << bread << " " << titles[0] << endl << endl;


            cout << "Choose your preferred sauce: "<< endl;
            printItemsArray(sauceList, size, titles[1]);
            cout << "Your pick? (1-5): ";
            do{
                if (cin >> userPick) {
                    if (userPick != 1 && userPick != 2 && userPick != 3 && userPick != 4 && userPick != 5) {
                        cout << "Please enter a valid response (1-5), try again: ";
                        clearInputBuffer();
                    } else {
                        sauce = sauceList[userPick - 1];
                        break;
                    }
                } else {
                    cout << "Invalid input. Enter a numeric value only (1-5), try again: ";
                    clearInputBuffer();
                }

            }while(true);
            cout << endl;
            cout << "You have picked: " << sauce << " " << titles[1] << endl << endl;


            cout << "Choose your preferred cheese: "<< endl;
            printItemsArray(cheeseList, size, titles[2]);
            cout << "Your pick? (1-5): ";
            do{
                if (cin >> userPick) {
                    if (userPick != 1 && userPick != 2 && userPick != 3 && userPick != 4 && userPick != 5) {
                        cout << "Please enter a valid response (1-5), try again: ";
                        clearInputBuffer();
                    } else {
                        cheese = cheeseList[userPick - 1];
                        break;
                    }
                } else {
                    cout << "Invalid input. Enter a numeric value only (1-5), try again: ";
                    clearInputBuffer();
                }
            }while(true);
            cout << endl;
            cout << "You have picked: " << cheese << " " << titles[2] << endl << endl;
            cout << endl;
            makePizza(bread, sauce, cheese, titles);
        break;
        case 4: 
            cout << playerPizza << " Pizza." << endl << endl;
            cout << "Choose your preferred bread: "<< endl;
            printItemsArray(breadList, size, titles[0]);
            cout << "Your pick? (1-5): ";
            do{
                if (cin >> userPick) {
                    if (userPick != 1 && userPick != 2 && userPick != 3 && userPick != 4 && userPick != 5) {
                        cout << "Please enter a valid response (1-5), try again: ";
                        clearInputBuffer();
                    } else {
                        bread = breadList[userPick - 1];
                        break;
                    }
                } else {
                    cout << "Invalid input. Enter a numeric value only (1-5), try again: ";
                    clearInputBuffer();
                }

            }while(true);
            cout << endl;
            cout << "You have picked: " << bread << " " << titles[0] << endl << endl;


            cout << "Choose your preferred sauce: "<< endl;
            printItemsArray(sauceList, size, titles[1]);
            cout << "Your pick? (1-5): ";
            do{
                if (cin >> userPick) {
                    if (userPick != 1 && userPick != 2 && userPick != 3 && userPick != 4 && userPick != 5) {
                        cout << "Please enter a valid response (1-5), try again: ";
                        clearInputBuffer();
                    } else {
                        sauce = sauceList[userPick - 1];
                        break;
                    }
                } else {
                    cout << "Invalid input. Enter a numeric value only (1-5), try again: ";
                    clearInputBuffer();
                }

            }while(true);
            cout << endl;
            cout << "You have picked: " << sauce << " " << titles[1] << endl << endl;


            cout << "Choose your preferred cheese: "<< endl;
            printItemsArray(cheeseList, size, titles[2]);
            cout << "Your pick? (1-5): ";
            do{
                if (cin >> userPick) {
                    if (userPick != 1 && userPick != 2 && userPick != 3 && userPick != 4 && userPick != 5) {
                        cout << "Please enter a valid response (1-5), try again: ";
                        clearInputBuffer();
                    } else {
                        cheese = cheeseList[userPick - 1];
                        break;
                    }
                } else {
                    cout << "Invalid input. Enter a numeric value only (1-5), try again: ";
                    clearInputBuffer();
                }
            }while(true);
            cout << endl;
            cout << "You have picked: " << cheese << " " << titles[2] << endl << endl;


            cout << "Choose your preferred topping: "<< endl;
            printItemsArray(toppingList, size, titles[3]);
            cout << "Your pick? (1-5): ";
            do{
                if (cin >> userPick) {
                    if (userPick != 1 && userPick != 2 && userPick != 3 && userPick != 4 && userPick != 5) {
                        cout << "Please enter a valid response (1-5), try again: ";
                        clearInputBuffer();
                    } else {
                        topping = toppingList[userPick - 1];
                        break;
                    }
                } else {
                    cout << "Invalid input. Enter a numeric value only (1-5), try again: ";
                    clearInputBuffer();
                }
            }while(true);
            cout << endl;
            cout << "You have picked: " << topping << " " << titles[3] << endl << endl;
            cout << endl;
            makePizza(bread, sauce, cheese, topping, titles);
        break;
    }
    



}

void makePizza(string bread, string titles[]){

    cout << "Creating your ""pizza""... " << endl << endl;

    cout << "Here is your ";
    cout << bread << " " << titles[0] << " ";
    cout << """pizza.""" << endl;
    cout << "Just plain ol' bread, huh?" << endl;

}
void makePizza(string bread, string sauce, string titles[]){
    cout << "Creating your ""pizza""... " << endl << endl;
    cout << "Here is your ";
    cout << bread << " " << titles[0] << ", ";
    cout << sauce << " " << titles[1] << " ";
    cout << "pizza" << endl;
    cout << "Bro... you're alright right?" << endl;
}
void makePizza(string bread, string sauce, string cheese, string titles[]){
    cout << "Creating your pizza... " << endl << endl;
    cout << "Here is your ";
    cout << bread << " " << titles[0] << ", ";
    cout << sauce << " " << titles[1] << ", ";
    cout << cheese << " " << titles[2] << " ";
    cout << "pizza" << endl;
    cout << "Well atleast it has cheese on it..." << endl;

}
void makePizza(string bread, string sauce, string cheese, string topping, string titles[]){
    cout << "Creating your pizza... " << endl << endl;
    cout << "Here is your ";
    cout << bread << " " << titles[0] << ", ";
    cout << sauce << " " << titles[1] << ", ";
    cout << cheese << " " << titles[2] << ", ";
    cout << topping << " " << titles[3] << " ";
    cout << "pizza" << endl << endl;

    cout << "Now this, this is pizza!" << endl;
}
void clearInputBuffer(){
    cin.clear();
    // Discard the invalid input
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
}
void printItemsArray(string arrayList[], int arr_Size, string title){
    cout << endl;
    for(int i = 0; i < arr_Size; i++){
    cout << "  " << i + 1 << ". " << arrayList[i] << " " << title << endl;
    }
    cout << endl;
}