#include <iostream>
#include <ctime>

using std::cout;
using std::cin;
using std::string;

int main() {

    string students[] = {"Kent", "Jacinth", "John", "Lance", "James", "Gilbert",};

    for(int i = 0; i < sizeof(students) / sizeof(string); i++){
        cout << i + 1 << ". " << students[i] << '\n';
    }

    char grades[] = {'A', 'B', 'C', 'D', 'F', 'Z'};

    for(int i = 0; i < sizeof(grades) / sizeof(char); i++){
        cout << i + 1 << ". " << grades[i] << '\n';
    }


}