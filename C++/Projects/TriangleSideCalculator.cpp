#include <iostream>
#include <cmath>
#include <string>

using std::cout;
using std::cin;
using std::string;

double calcSideA(double sideB, double sideC);
double calcSideB(double sideA, double sideC);
double calcSideC(double sideA, double sideB);


int main () {

    double sideA;
    double sideB;
    double sideC;
    double result;
    char response;
    char select_buffer;
  
    do
    {
        do
        {

            cout << "What side would like to solve? (A/B/C)? ";
            cin >> select_buffer;

            select_buffer = toupper(select_buffer);

            if (select_buffer != 'A' && select_buffer != 'B' && select_buffer != 'C' ){
                cout << "Only A, B, and C." << " Try Again!" << '\n';
            }


        } while (select_buffer != 'A' && select_buffer != 'B' && select_buffer != 'C' );

     switch (select_buffer)
        {
            case 'A':
                result = calcSideA(sideB, sideC);
                cout << "The Side A is: " << result << "cm" << '\n';
                cout << "----------------------------------" << '\n';
                cout << '\n';
                break;
            
            case 'B':
                result = calcSideB(sideA, sideC);
                cout << "The Side B is: " << result << "cm" << '\n';
                cout << "----------------------------------" << '\n';
                cout << '\n';
                break;
            
            case 'C':
                result = calcSideC(sideA, sideB);
                cout << "The Hypotenuse(side c) is: " << result << "cm" << '\n';
                cout << "----------------------------------" << '\n';
                cout << '\n';
                break;
            
            default:
                cout << "Invalid Input!";
                break;
        }

        do
        {
            cout << "Would like to repeat again? (Y/N) ";
            cin >> response;
            response = toupper(response);
            if(response == 'N') {
                break;
            }
        } while (response != 'Y' || response == 'N');
        if(response == 'N') {
            cout << "Thank You. See you again!" << '\n';
            break;
        }
       
    } while (response == 'Y');
    

    return 0;
}

double calcSideC(double sideA, double sideB){
    cout << "----------------------------------" << '\n';
    cout << "Solve for Side C: "<< '\n';
    cout << "Input side A: ";
    cin >> sideA;
    cout << "Input side B: ";
    cin >> sideB;


    return sqrt(pow(sideA, 2) + pow(sideB, 2));

}
double calcSideA(double sideB, double sideC){
    cout << "----------------------------------" << '\n';
    cout << "Solve for Side A: "<< '\n';
    cout << "Input side B: ";
    cin >> sideB;
    cout << "Input side C: ";
    cin >> sideC;


    return sqrt(pow(sideC, 2) - pow(sideB, 2));

}
double calcSideB(double sideA, double sideC){
    cout << "----------------------------------" << '\n';
    cout << "Solve for Side B: "<< '\n';
    cout << "Input side A: ";
    cin >> sideA;
    cout << "Input side C: ";
    cin >> sideC;


    return sqrt(pow(sideC, 2) - pow(sideA, 2));

}







   
