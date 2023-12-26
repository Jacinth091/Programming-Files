


//     // this is how you comment
//     /*
//     this is
//     how 
//     you multi
//     comment
    
//     std::cout << "Elize Megan Minoza\n";
//     std::cout << "Jacinth Cedric Barral";*/

//     /*int x = 5;
//     int y = 6;
//     int sum = x * y;



//     std::cout << x << '\n';
//     std::cout << y << '\n';
//     std::cout << sum << '\n';*/

//     // integer (whole numbers)
    
//     // data types

//     // int = can only store whole numbers
//     /*int age = 20;
//     int bdate = 26;
//     int grade = 90;

//     // double = can hold numbers including decimals
//     double price = 99.89;
//     double gpa = 78.9;
//     double temperature = 30.7;

//     // char = holds only single character

//     char rating = 'A';
//     char inital = 'B';
//     char letter = 'c';
//     char currency = '$';

//     // booleans = can hold only TRUE or FALSE or two states

//     bool answer = true;
//     bool attendance = false;
//     bool forSale = true;

//     // string = can hold multiple 'string' of characters

//     std::string name = "John";
//     std::string week = "Friday";
//     std::string city = "Cebu City";
//     std::string address = "Sitio Tahna";
//     std::string brgy = "Tisa";

//     std::cout << "Hello, My name is " << name << '.' << '\n';
//     std::cout << "And I'm " << age << " years old!" << '\n';
//     std::cout << "I live in " << address << ','  << ' ' << brgy << ' ' << city;*/

//     // THe "const" keyword specifies that a variable's value is constant
//     // tells the complier to prevent anything from modifying it
//     // (read-only)

//     //example
//     /*
//     const double PI = 3.14159; // by adding "const" the value of pi cannot be changed anymore
//     double radius = 10;
//     double circumference = 2 * PI * radius;
    
//     std::cout << circumference << " cm";*/

//     // const examples
//     /*const double PI = 3.14159;
//     const int lightSpeed = 299792458;
//     const int width = 1920;
//     const int height = 1080;*/


//     // Namespace = provides a solution for preventing name 
//     //             conflicts in large projects.
//     //             A namespace allows for identically named entities
//     //             as long as the namespaces are diffirent.

//     /*namespace first { // namespaces allow us to use identically
//                       // variables, in this case "x".

//         int x = 10;
//     }

//     namespace  second {

//      int x = 20;
//     }*/



//    //using namespace first; // "using" allows you to use a namespace 
//                           // without specifiyng the namespace
//                           // instead of "namespace::variable_name"
//                           // you can go with "std::cout << variable_name"
//                           // "using" tag generally shortens the syntax

//     //std::cout << second::x;


//     // when displaying namespace it must be specific 
//     // "::" is called scope resolution operator
//     // std::cout << first::x << '\n' << second::x;
//     // "namespace::variable_name"

//     //typedef = reserved keyword use to create an additional
//     //          name (alias) for another data type
//     //          Typedef basically shortens long syntaxes into
//     //          an easy variable-name
//     //          Although typedef works good, it has been
//     //          replaced by "using" because it works perfectly with templates

// /*#include <vector>
// using text_t = std::string;
// using number_t = int;
// using std::cout;*/

//     /* typedef examples
//    typedef std::string text_t; //"std::string" is shortened into "text_t"
//    typedef int number_t;       // great use when you have a long syntax

//     text_t firstName = "Jacinth";
//     number_t Age = 20; 

//     std::cout << firstName << '\n' << Age;*/
 
//     // using tag that works like typedef

//     /*text_t firstName = "Jacinth";
//     number_t Age = 20;

//     cout << firstName << '\n' << Age;*/

//     /* Arithmetic operators = return the result of
//         a arithmetic operation (+ - * / %)
//     */



    
//     //int student = 20;

//     /*students = students + 1; when working with this kind of equation
//                                 it is best to shorten the syntax
//     */

//    /* students+=1; example of a arithmetic operation (adding)
//       students++;
//    */

//    /* students-=2; example of a arithmetic operation (subtracting)
//       students--;
//    */

//    /* students*=2; example of a arithmetic operation (multiplying)
//    */

//     /* students/=2; example of a arithmetic operation (dividing)
//    */

//     /*
//     int remainder = students % 3; Modolus operator displaying only the
//                                   remainder
//     */

//    // int students = 6 + 5 - 10 * 30 * 2 / 4;

//    //std::cout << students;

//    /*
//         aritmetic operators inside a "()" have the highest precedence
//         meaning, they are solved first by the compiler

//         Multiplication, Division, and Modolus have the same precedence of "2"
//         in a case where there is both "*", "/", and "%" in an equation
//         you should solve first from LEFT to RIGHT

//         Addition and Subtraction have the same precedence of "3"
//         in case where there is both "+" and "-" inside an equation
//         you should solve in first from LEFT to RIGHT
//    */


//   /* TYPE CONVERSION = conversion a value of one data type to another
//                        Implicit = automatic
//                        Explicit = Precode value with new data type (int)
//   */

// #include <iostream>    
// int main() {  
//     /*
//     int x = 3.14159;
//     std::cout << x;  it will result to only 3 because "int" 
//                       can't hold decimalp points
//     */

//    // instead using "int" for decimals us "double"

// /*
//   double x = (int) 3.14; // instead of displaying 3.14 it
//                          // displays only 3 because we converted 
//                          // it into an int variable\
//                          // also an example of an Explicit/implicit conversion

//    std::cout << x;*/







//     return 0;
// }

