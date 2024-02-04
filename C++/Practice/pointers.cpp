#include <iostream>

using std::cout, std::cin, std::endl, std::string;

int main(){
    // pointers = variable that stores a memory address of another variable
    //            sometimes It's easier to woek with an address


    // & - address-of operator
    // * - dereference opertator

    string name = "Jacinth";
    int age = 20;
    string freePizza[5] = {"pizza1", "pizza2", "pizza3", "pizza4", "pizza5", };


    string *pName = &name;
    int *pAge = &age;
    string *pFreePizza = freePizza;

    cout << pName << endl; // It displays the memory address of the variable "name".
    cout << *pName << endl; // It displays the value inside of variable "name"

    cout << pAge <<endl;
    cout << *pAge <<endl;

    cout << freePizza << endl;
    cout << *freePizza << endl;






}