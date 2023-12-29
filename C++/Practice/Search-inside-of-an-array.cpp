#include <iostream>

using namespace std;
int searchMenu(string menu[], int size, string customersChoice);
// int searchArray(int array[], int size, int element);

int main () {

    // int numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    // int size = sizeof(numbers) / sizeof(numbers[0]);
    // int index;
    // int myNum;

    // cout << "Enter an element that you want to search: ";
    // cin >> myNum;


    // index = searchArray(numbers, size, myNum);

    // if(index != -1){
    //     cout << "The element " << myNum << " is at index " << index << " and it is in the array.\n";
    // }
    // else {
    //     cout << "The element " << myNum << " is  not in the array.\n";

    // }

    string menu[] ={"Egg-omelet", "Humba", "Lumpia", "Pinaksiw", "Ginaling", "Ham-Bilog", "Monggos", "Chorizo" };
    int sizeofMenu = sizeof(menu) / sizeof(menu[0]);
    int index2;
    string food;

    cout << "Menu: \n\n";
    for(int i = 0; i < sizeofMenu; i++){
        cout << "\t" << i + 1 << ". " << menu[i] << ". \n";
    }
    cout << "\n\n";


    cout << "Enter what Food you want: ";
    cin >> food;

    index2 = searchMenu(menu, sizeofMenu, food);

    if (index2 != -1){
        cout << "Your order " << food << " will be ready.\n";
    }
    else {
        cout << "Your order " << food << " is not on the menu.\nChoose other dishes.\n";

    }

}
int searchMenu(string menu[], int size, string customersChoice){
    for(int i=0; i < size; i++){
        if(menu[i] == customersChoice){
            return i;
        }
    }
    return -1;
}

// int searchArray(int array[], int size, int element){
//     for(int i=0; i < size; i++){
//         if(array[i] == element){
//             return i;
//         }
//     }
//     return -1;

// }