#include <iostream>

using namespace std;

int main() {

string phones[][3] = {{"Note 7", "S20 plus Ultra", "S23 Plus Ultra 5G"},
                    {"Iphone 11","Iphone 14 pro max", "Iphone 6 plus"},
                    {"F5 pro 5G", "X4 GT", "X5 Pro 5g"}};
int rows = sizeof(phones) / sizeof(phones[0]);
int columns = sizeof(phones[0])/ sizeof(phones[0][0]);


    for(int i= 0; i < rows; i++ ){
        // cout << phones[i] << "\n";
        for(int j= 0; j < columns ; j++ ){
            cout << phones[i][j] << ", ";
        }   
        cout << "\n\n";
    }

    // cout << phones[0][0] << ", ";
    // cout << phones[0][1] << ", ";
    // cout << phones[0][2] << " \n\n";

    // cout << phones[1][0] << ", ";
    // cout << phones[1][1] << ", ";
    // cout << phones[1][2] << " \n\n";

    // cout << phones[2][0] << ", ";
    // cout << phones[2][1] << ", ";
    // cout << phones[2][2] << " \n\n";
    

}