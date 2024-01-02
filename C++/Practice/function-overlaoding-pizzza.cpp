#include <iostream>
#include <limits>
#include <string>
#include <ctime>

using std::string, std::cin, std::cout;



void bakePizza(string bread, string cheese);
void bakePizza(string bread, string sauce, string cheese);
void bakePizza(string bread, string sauce, string topping);
void bakePizza(string bread, string cheese, string topping);
void bakePizza(string bread, string sauce, string cheese, string topping);


int main(){

    string bread = "Sourdough";
    string sauce = "Spicy";
    string cheese = "Mozarella";
    string topping = "Pepperoni";
    int response =0, random = 0, randomNum;

    cout << "Input 1-5, get a random pizza: ";
    cin >> response;

    // srand(time(NULL));

    // random = (rand() % 5) + 1;
    // randomNum = (rand() % 5) + 1;

    // if(randomNum == random){
    //     bakePizza(bread, cheese);
    // }
    // else if (randomNum > random)
    // {
    //     bakePizza(bread, sauce, cheese);
    // }
    // else if(randomNum < random){
    //     bakePizza(bread, sauce, cheese, topping);
    // }
    
    bakePizza(bread, sauce, cheese, topping);






}
void bakePizza(string bread, string cheese){

    cout << "Here is your ";
    cout << bread << " ";
    cout << cheese << " ";
    cout << "pizza";
}
void bakePizza(string bread, string sauce, string cheese){
    cout << "Here is your ";
    cout << bread << " ";
    cout << cheese << " ";
    cout << sauce << " ";
    cout << "pizza";
}
void bakePizza(string bread, string sauce, string topping){
    cout << "Here is your ";
    cout << bread << " ";
    cout << sauce << " ";
    cout << topping << " ";
    cout << "pizza";

}
void bakePizza(string bread, string cheese, string topping){
    cout << "Here is your ";
    cout << bread << " ";
    cout << cheese << " ";
    cout << topping << " ";
    cout << "pizza";

}


void bakePizza(string bread, string sauce, string cheese, string topping){
    cout << "Here is your ";
    cout << bread << " ";
    cout << cheese << " ";
    cout << sauce << " ";
    cout << topping << " ";
    cout << "pizza";
}