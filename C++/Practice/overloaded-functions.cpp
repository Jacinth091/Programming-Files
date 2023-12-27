#include <iostream>

using std::cout;
using std::cin;
using std::string;

void makeBurger();
void makeBurger(string topping1);
void makeBurger(string topping1, string topping2);

int main(){

    makeBurger("DOUBLE PATTY", "DOUBLE SAUCE");


}
void makeBurger(){
    cout << "Here is you big BURGIRRR!";

}
void makeBurger(string topping1){
    cout << "Here is you big " << topping1 << " BURGIRRR!";

}
void makeBurger(string topping1, string topping2){
    cout << "Here is you big " << topping1 << " and " << topping2 << " BURGIRRR!";

}