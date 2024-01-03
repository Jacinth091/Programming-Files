#include <iostream>

using std::cout, std::cin, std::string, std::endl;
void swapValue(string x, string y);
int main(){
    string x = "Jacinth", y = "Cedric";

    swapValue(x, y);
    cout << "X: " << x << endl << "Y: " << y;


}
void swapValue(string x, string y){
    string temp;
    temp = x;
    x = y; 
    y = temp;
}