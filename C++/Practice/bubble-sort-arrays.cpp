#include <iostream>

using namespace std;

void sortAlgo(int numbers[], int size);

int main() {
     
    int array[] = {100, 200, 1, 150, 99, 23, 8, 17, 16, 34, 5};
    int size = sizeof(array) / sizeof(array[0]);

    sortAlgo(array, size);

    for(int element : array){
        cout << element << " ";
    }

}
void  sortAlgo(int numbers[], int size){
    int temp;
    for (int i= 0; i < size - 1; i++){
        for(int j= 0; j < size - i - 1; j++)
        if(numbers[j] > numbers[j + 1] ){
            temp = numbers[j];
            numbers[j] = numbers[ j + 1];
            numbers[j +1] = temp;

        }
    }

}