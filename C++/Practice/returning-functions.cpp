#include <iostream>

using std::cout;
using std::cin;
using std::string;

// double areaSquare(double length);
// double areaCube(double length);
string concatStrings(string fristName, string lastName);


int main() {
    // double length = 6.0;
    // cout << "Area: " << areaSquare(length) << "cm^2" << '\n';
    // cout << "Volume: " << areaCube(length) << "cm^3" << '\n';

    string firstName = "Jacinth Cedric";
    string lastName = "Barral";

    cout << "Hello!, " << concatStrings(firstName, lastName) << '\n';

}
string concatStrings(string fristName, string lastName){
    return fristName + " " + lastName;
}
// double areaSquare(double length){

//     double res = length * length;
//     return res;

// }
// double areaCube(double length){

//     double res = length * length * length;
//     return res;

// }