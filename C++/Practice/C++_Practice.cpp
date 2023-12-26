#include <iostream>
#include <vector>  // library to use "typedef"

/* // Namespace = allows you to redeclare the same name of a variable

namespace first {
    int x = 10;
}
namespace second {
    int x = 20;
} */

// int main() {


    // Standard Character Output
    // std::cout << "Hello!, I'm Jacinth!";

    // Variables / Data Types

    // Integers(Whole numbers)

    // int x = 231;
    // int y = 21;
    // int z = 991;

    // Floating point Numbers ( With decimal)

    // float price = 23.1;
    // float gravity = 9.8;
    // double size = 3.23; // Double has more bits
    // double mass = 3423.2; // Double has more bits



    // Booleans (True or False)

    // bool isPassed = true;
    // bool isStudent = false;
    // bool isMale = 0;
    // bool isFemale = 1;

    // Characters (One character only)
 
    // char grade = 'A';
    // char celsuis = 'C';
    // char fahrenheit = "F";


    // Strings (basically an object that holds multiple single characters)

    // std::string userName = "Jacinth";
    // std::string favFood = "Mango-Float";
    // std::string age = "21";
    // std::string school = "University of Cebu - Main Campus";

    // std::cout << "Hello! " << userName << "." << " \n";
    // std::cout << "Your favorite food is " << favFood << "." << " \n";
    // std::cout << "You are " << age << " years old!." << " \n";
    // std::cout << "You are studying at " << school << "." <<  " \n";



    // Constant Variable = const

    // const double PI = 3.14159; // PI has become "read-only" variable, the value won't change and can't be altered
    // double radi = 10;
    // double circum = 2*PI*radi;

    // std::cout<< "The circumference of the circle is: " << circum << "cm" << '\n';

    // // examples of uss of const variables

    // const int LIGHT_SPEED = 299792458;
    // const int WIDTH = 1920;
    // const int HEIGHT = 1080; 

    // using namespace first; // tells the main function that we are currently using the namespace "first"

    // int x = 30;
    // // TO ACCESS a variable inside of a namespace, pre-seed the name of the namespace
    // // and then join it with "::" and with the name of the variable you want to access
    // std::cout << first::x + second::x + x; 
    
    // 

//    return 0;
// }





// typedef (give nicknames to long variables) 
// To give nicknames to long variables 
// typedef std::vector<std::pair<std::string, int>> pairList_t;
// typedef std::string text_t;
// typedef int number_t;

//"using" keyword (generally functions the same as typedef but works great in templates)
using text_t = std::string;
using number_t = int;

int main () 
{
    // text_t userName = "SoyaMilk01";
    // std::cout << "Username: " <<userName  << '\n';

    // number_t age = 21;
    // std::cout << "Age: " << age <<'\n';


    // return 0;

    // Useful Math functions
    // double x = 3.14;
    // double y = 4.99;
    // double z;

    // // z = std::max(x, y); //checks for the greater number between the given value
    // // z = std::min(x, y); //checks for the least number between the given value

    // /*z = pow(2, 3);*/
    // z = sqrt(x);
    // z = abs(-3);
    // z = round(x);
    // z = ceil(y);
    // z = floor(y);

    // // Visit cplusplus.com/reference/cmath/ for more math functions in c++!

    // cout << z;
}


// Taking in User-Input


// #include <iostream>
// #include <string>

// using std::string;
// using std::cout;
// using std::cin;
// using std::getline;


// int main() {

//     string userName;
//     int age;

//     cout << "What is your current age? ";
//     cin >> age;

//     cout << "What is your full name? ";
//     getline(cin >> std::ws, userName);



//     cout << "Hello, " << userName << ", \nIt is nice to meet you!"<< '\n' ;
//     cout << "Wow you are " << age << " years old!" << '\n' ;

    // Simple Hypotenuse Calculator (taking input as well as using math functions)

    // double sideA;
    // double sideB;
    // double sideC;

    // cout << "Input side A: ";
    // cin >> sideA;
    // cout << "Input side B: ";
    // cin >> sideB;

    // sideC = sqrt(pow(sideA, 2) + pow(sideB, 2));

    // cout << "The hypotenuse is: " << sideC << "cm" <<'\n';





// }

