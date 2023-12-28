#include <iostream>
#include <ctime>

using std::cout;
using std::cin;
using std::string;

int main() {

    // sizeof() = determines the size in bytes of a :
    //            variable, data type, class, objects, etc.

    string name = "Jacinth";
    double gpa = 2.5;
    char grade = 'F';
    bool student = true;
    char grades[] = {'A', 'B', 'C', 'D', 'F', 'Z'};
    string students[] = {"Kent", "Jacinth", "John", "Lance", "James", "Gilbert",};

    cout << sizeof(gpa) << " bytes\n";
    cout << sizeof(name) << " bytes\n";
    cout << sizeof(grade) << " bytes\n";
    cout << sizeof(student) << " bytes\n";
    cout << sizeof(grades) << " bytes\n";
    cout << sizeof(grades) / sizeof(char) << " elements inside.\n";
    cout << sizeof(students) << " bytes\n";
    cout << sizeof(students) / sizeof(string) << " elements inside.\n";






}