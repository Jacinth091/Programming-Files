#include <iostream>
#include <ctime>

using std::cout;
using std::cin;
using std::string;

double getTotal(double prices[], int size);

int main() {

    double prices[] = {99.91, 50.23, 501, 100, 758.23, 1000.25};
    int size = sizeof(prices) / sizeof(prices[0]);
    double total = getTotal(prices, size);

    cout << "Total: $" << total << '\n';


}
double getTotal(double prices[], int size){
    double total =0;

    for(int i = 0; i < size; i++ ){
        total += prices[i];
    }

    return total;

} 
