#include <iostream>
#include <ctime>

using std::cout;
using std::cin;
using std::string;

int main() {

    srand(time(0));

    int randNum = (rand() % 5 ) + 1;

    switch (randNum)
    {
    case 1:
        cout << "You win a 10 tickets!";
    break;
    case 2:
        cout << "You win a 15 tickets";
        
    break;
    case 3:
        cout << "You win two jolly ranchers";
        
    break;
    case 4:
        cout << "You win a lays chip bag";
        
    break;
    case 5:
        cout << "You win a pringles can!";
    break;
    
    default:
    
    break;
    }




}
