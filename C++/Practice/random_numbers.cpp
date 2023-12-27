#include <iostream>
#include <ctime>

using std::cout;
using std::cin;
using std::string;

int main() {


    srand(time(NULL));

    int num1 = (rand() % 6) + 1;
    int num2 = (rand() % 6) + 1;
    int num3 = (rand() % 6) + 1;

    cout << num1 << '\n';
    cout << num2 << '\n';
    cout << num3 << '\n';



}
