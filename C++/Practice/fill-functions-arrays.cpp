#include <iostream>

using namespace std;

int main(){


    // fill() = fills a range of elements with a specified value
    //     syntax = fill(begin, end, value);

    const int SIZE = 40;
    string favDeserts[SIZE];

    fill(favDeserts, favDeserts + (SIZE/4), "Mango-Float");
    fill(favDeserts + (SIZE/4), favDeserts + (SIZE/4)*2 , "Macaroni Salad");
    fill(favDeserts + (SIZE/4)*2, favDeserts + (SIZE/4)*3, "Maja Blanca");
    fill(favDeserts + (SIZE/4)*3, favDeserts + SIZE, "Cheese Cake");

    for( string deserts : favDeserts){
        cout << deserts << "\n";
    }






}