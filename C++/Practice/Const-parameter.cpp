#include <iostream>
#include <string>

using std::cin, std::cout, std::endl, std::string;
void userInfo(const string userName, const int age, const string birthday[]);
int main(){
    // const parameter = parameter that is effectively read-only
    //                   code is more secure and conveys instant
    //                   useful for references and pointers.

    string userName, address;
    string birthday[1];
    int age;

    cout << "Hello user!, what's your name? ";
    // cin >> userName;
    getline(cin, userName);

    cout << "What is your current age?: ";
    cin >> age;

    cout << "When is your birthday?(mm/dd/yyyy): ";
    cin >> birthday[0];

    userInfo(userName, age, birthday);



}
void userInfo(const string userName, const int age, const string birthday[]){
    cout << endl;
    cout << "Your full name: " << userName << endl;
    cout << "Your age: " << age << endl;
    cout << "Your birthdate (mm/dd/yyyy): " << birthday[0] << endl;
    


}