#include <iostream>

using std::cout, std::cin, std::endl, std::string;

int main() {
    // Null value - a special value that means something has no value.
    //              When a pointer is holding a null value,
    //              that pointer is not pointing at anything (null pointer)

    // nullptr = keyword represents a null pointer literal

    // nullptrs are helpful when determining if an address
    // was successfully assigned to a pointer

    // When  using pointers, be carefull that your code isn't derefencing
    // nullptr or pointing to free memory
    // this will cause undefined behavior

    



    int *pointer = nullptr;
    int x = 123;

    pointer = &x;

    if(pointer == nullptr){
        cout << "Address wa not assigned! " << endl;
    }
    else {
        cout << "Address was assigned!" << endl;
        cout << *pointer << endl;
    }





}