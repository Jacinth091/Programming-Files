#include <iostream>
#include <string>

using namespace std;

int main( ){

    string favDeserts[5];
    int size = sizeof(favDeserts) / sizeof(favDeserts[0]);
    string temp;
    cout << "Input 5 of your favorite deserts: \n";

    for(int i=0; i< size; i++){
        cout << "Enter a desert you like or 'q' to quit # "<<i + 1 << ": ";
        getline(cin, temp);
        if(temp == "q"){
            break;
        }
        else{
            favDeserts[i] = temp;
        }

        // cin >> favDeserts[i];
    }
    cout << "\n5 of your favorite deserts \n";

    for(int i = 0; !favDeserts[i].empty(); i++){
        cout << favDeserts[i] << "\n";
    }



}