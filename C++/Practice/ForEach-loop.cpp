#include <iostream>
#include <ctime>

using std::cout;
using std::cin;
using std::string;

int main() {

    // for each loop = loop that eases the traversal over an 
    //                 iterable data set.


    string students[] = {"Kent", "Jacinth", "John", "Lance", "James", "Gilbert",};

    for(string student : students){
        cout << student << '\n';
    }

    int grades[] = {96, 89, 78, 85, 93, 90, 98};

    for(int grade : grades){
        cout << grade << '\n';
    }


}