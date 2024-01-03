#include <iostream>

using std::cout, std::cin, std::string, std::endl;

int main () {

    // Memory Address = a location in memory where data is stored
    // a memory address can be accessednwith '&' (address-of-operator)

    string name = "Jacinth";
    int age = 20;
    bool isStudent = true;

    cout << &name << endl;
    cout << &age << endl;
    cout << &isStudent << endl;




}