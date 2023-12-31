#include <iostream>
#include <limits>
#include <iomanip>

using namespace std;

int easyGameMode(int &totalCorrect);
int mediumGameMode(int &totalCorrect);
int hardGameMode(int &totalCorrect);
int chooseDifficulty();

int main() {

    int difficulty, totalCorrect, size = 0, multiplier = 0;
    char startGame, playAgain;

    cout << endl << endl;
    cout << "*********************************************" << endl;
    cout << "*               C++ QUIZ BOWL               *" << endl;
    cout << "*********************************************" << endl << endl;

     do{
        cout << "Start Game? (Y/N): ";
        cin >> startGame;

        startGame = toupper(startGame);
        if(startGame == 'N'){
            break;
        }
    }while(startGame != 'Y' || startGame == 'N');
    if(startGame == 'N'){
        cout << "Goodbye :<" << endl;
    }
    else{
        do {
            totalCorrect = 0;
            cout << endl;
            difficulty = chooseDifficulty();
            cout << endl;

            switch(difficulty){
            case 1:
                cout << "***********************************************" << endl;
                cout << "*                   EASY MODE                 *" << endl;
                cout << "***********************************************" << endl;
                size = easyGameMode(totalCorrect);
                cout << endl;
                cout << "*********************************************** " << endl;
                cout << "*                    Results                  *" << endl;
                cout << "***********************************************" << endl;
                cout << "Your answers that are correct: " << totalCorrect << "\n";
                cout << "Total # of questions: " << size << "\n";
                cout << "Total average: " << (totalCorrect/(double)size)*100 << "%" <<"\n";
            break;
            case 2:
                multiplier = 2;
                cout << "***********************************************" << endl;
                cout << "*                  MEDIUM MODE                *" << endl;
                cout << "*                 2 POINTS EACH               *" << endl;
                cout << "***********************************************" << endl;

                size = mediumGameMode(totalCorrect);
                cout << endl;
                cout << "***********************************************" << endl;
                cout << "*                    Results                  *" << endl;
                cout << "***********************************************" << endl;
                cout << "Your answers that are correct multiplied by 2: " << totalCorrect * multiplier << "\n";
                cout << "Total score of Medium Mode: " << size * multiplier << endl;
                cout << "Total average: " << ((totalCorrect*multiplier)/(double)(size * multiplier))*100 << "%" <<"\n";
            break;
            case 3:
                multiplier = 5;
                cout << "***********************************************" << endl;
                cout << "*                   HARD MODE                 *" << endl;
                cout << "*                 5 POINTS EACH               *" << endl;
                cout << "***********************************************" << endl;
                size = hardGameMode(totalCorrect);
                cout << endl;
                cout << "***********************************************" << endl;
                cout << "*                    Results                  *" << endl;
                cout << "***********************************************" << endl;
                cout << "Your answers that are correct multiplied by 5: " << totalCorrect * multiplier << "\n";
                cout << "Total score of Medium Mode: " << size * multiplier << endl;
                cout << "Total average: " << ((totalCorrect*multiplier)/(double)(size * multiplier))*100 << "%" <<"\n";
            break;
            default:
            break;
        }

            cout << "Play Again? (Y/N): ";
            cin >> playAgain;
            playAgain = toupper(playAgain);

            if(playAgain == 'N'){
                break;
            }
        }while(playAgain == 'Y');
        cout<< endl;
        cout << "Thanks for playing :>" << endl;
    }


}
int chooseDifficulty(){
    int difficulty = 0;

    cout << "*********************************************\n";
    cout << "Choose your desired difficulty: \n";
    cout << "\t1. Easy      (10 Questions)\n";
    cout << "\t2. Medium    ( 7 Questions 2 points each)\n";
    cout << "\t3. Hard      ( 5 Questions 5 points each)\n";
    cout << "*********************************************\n";
    do{
        cout << "Enter (1-3) to choose your difficulty: ";
        // Check if the input is an integer
        if (cin >> difficulty) {
            if (difficulty != 1 && difficulty != 2 && difficulty != 3) {
                cout << "Please enter a valid response (1-3), try again:\n";
                // Clear the input buffer to handle invalid input
                cin.clear();
                // Discard the invalid input
                cin.ignore(numeric_limits<streamsize>::max(), '\n');
            } else {
                break;
            }
        } else {
            cout << "Invalid input. Please enter a number (1-3), try again:\n";
            // Clear the input buffer to handle invalid input
            cin.clear();
            // Discard the invalid input
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
        }

    }while(true);

    return difficulty;


}
int easyGameMode(int &totalCorrect){
    char playerAnswer;
    string easyQuestions[] = {"In c++, which commonly used header file is responsible for input and output operations?",
                              "How is 'not equal to' represented in many programming languages, including C++?",
                              "What is the fundamental keyword used in many programming languages, including C++, to declare a variable that can store whole numbers?",
                              "In programming languages like C++, what is the standard return type of the main function?",
                              "What type of control structure in programming is used to execute a block of code repeatedly as long as a specified condition is true?", 
                              "How do you access the third element of an array in programming?",
                              "In programming, what is a function?",
                              "What is the purpose of comments in programming?",
                              "What is the purpose of the 'else' statement in a conditional structure?",
                              "In object-oriented programming, what is an object?" };

    string easyChoices[][4] = {{"A. iostream", "B. io.h", "C. input.output", "D. stdio.h"},
                                {"A. !=", "B. ==", "C. <>", "D. *="},
                                {"A. Int", "B. Float", "C. String", "D. Char"},
                                {"A. Void", "B. Int", "C. Main", "D. Float"},
                                {"A. For Loop", "B. While Loop", "C. Do-while Loop", "D. All of the above"},
                                {"A. arr_Num[3]", "B. arr_Num[2]", "C. arr_Num(2)", "D. arr_Num(3)"},
                                {"A. A variable that stores data.", "B. A block of reusable code that performs a specific task.", "C. A keyword used for iteration.", "D. A type of loop."},
                                {"A. To highlight errors in the code.", "B. To mark the beginning of a program.", "C. To add decorative elements to the code.", "D. To explain the code to developers and make it more readable."},
                                {"A. It terminates the program.", "B. It marks the beginning of a loop.", "C. It represents an alternative condition to be executed when the main condition is false.", "D. It is used to define a constant."},
                                {"A. An instance of a class with its own attributes and behaviors.", "B. A sequence of characters.", "C. A loop structure.", "D. A piece of data."}};
    char answerKey[] = {'A', 'A', 'A', 'B', 'D', 'B', 'B', 'D', 'C', 'A'};

    int size = sizeof(answerKey) / sizeof(answerKey[0]);

    for(int i=0; i < size; i++){
        cout << endl;
        cout << "***********************************************" << endl;
        cout << i + 1 << ". "  << easyQuestions[i] << endl;
        cout << "***********************************************" << endl << endl;

        for(int j = 0; j < sizeof(easyChoices[i]) / sizeof(easyChoices[i][0]); j++ ){
            cout  << easyChoices[i][j] << endl;
        }
        cout << endl;
        do{
            cout << "Answer: ";
            cin >> playerAnswer;

            playerAnswer = toupper(playerAnswer);
            if(playerAnswer != 'A' && playerAnswer != 'B' && playerAnswer != 'C' && playerAnswer != 'D' ){
                cout << "Please enter a valid answer.\nTry again.\n";
            }
            else{break;}
        }while(playerAnswer != 'A' && playerAnswer != 'B' && playerAnswer != 'C' && playerAnswer != 'D' );
        if(playerAnswer == answerKey[i]){
            cout << endl;
            cout << "Correct!\nThe answer was: " << answerKey[i] << endl; 
            totalCorrect++;
        }
        else{
            cout << endl;
            cout << "Wrong!\nThe answer is: " << answerKey[i] << endl;
        }
    }
    return size;


}
int mediumGameMode(int &totalCorrect){
    char playerAnswer;
    string mediumQuestions[] = {"What is the difference between pass by value and pass by reference in C++? Provide an example to illustrate each.",
                                "Explain the concept of function overloading in C++. Provide an example with two overloaded functions.",
                                "Describe the purpose and usage of the const keyword in C++. Provide examples in different contexts.",
                                "What is a pointer in C++? Explain how pointers differ from regular variables, and provide an example demonstrating their use.",
                                "Discuss the differences between new and malloc() in C++. When and why would you prefer one over the other for dynamic memory allocation?",
                                "Explain the concept of inheritance in object-oriented programming with respect to C++. Provide an example demonstrating single inheritance.",
                                "Describe what an exception is in C++. How do you handle exceptions using try, catch, and throw blocks? Provide a simple example."};

    string mediumChoices[][4] = {{"A. Pass by Value: Copies the actual value of the argument.", "B. Pass by Reference: Passes the memory address of the argument.", "C. Pass by Value: Requires the use of pointers.", "D. Pass by Reference: Copies the actual value of the argument.",},
                                 {"A. Function Overloading: Using the same function name with different return types.", "B. Function Overloading: Using the same function name with different parameter types or a different number of parameters.", "C. Function Overloading: Using completely unrelated function names.", "D. Function Overloading: Limited to member functions only.",},
                                 {"A. const: Used to declare constant variables.", "B. const: Specifies that a member function does not modify the object.", "C. const: Can be used to create read-only parameters in functions.", "D. All of the above.",},
                                 {"A. Pointer: Stores the actual value of a variable.", "B. Pointer: Holds the memory address of a variable.", "C. Pointer: Can only be used with integer variables.", "D. Pointer: Used to define constant values.",},
                                 {"A. new: Returns a pointer to the allocated memory and calls constructors.", "B. malloc(): Returns a pointer to the allocated memory without calling constructors.", "C. new: Limited to allocating memory for primitive data types.", "D. malloc(): Automatically initializes the allocated memory to zero.",},
                                 {"A. Inheritance: The ability of a class to inherit properties and behavior from another class.", "B. Single Inheritance: A class can inherit from multiple base classes", "C. Inheritance: Can only be applied to member variables, not member functions.", "D. Single Inheritance: A class inherits from a single base class.",},
                                 {"A. Exception: A runtime error that cannot be handled.", "B. Exception Handling: Utilizes try, catch, and throw to manage errors gracefully.", "C. try: Identifies the location where an exception might occur.", "D. All of the above.",}};
    char answerKey[] = {'B', 'B', 'D', 'B', 'A', 'D', 'D'};

    int size = sizeof(answerKey) / sizeof(answerKey[0]);

    for(int i=0; i < size; i++){
        cout << endl;
        cout << "***********************************************" << endl;
        cout << i + 1 << ". "  << mediumQuestions[i] << endl;
        cout << "***********************************************" << endl << endl;


        for(int j = 0; j < sizeof(mediumChoices[i]) / sizeof(mediumChoices[i][0]); j++ ){
            cout << mediumChoices[i][j] << endl;
        }
        cout << endl;
        do{
            cout << "Answer: ";
            cin >> playerAnswer;

            playerAnswer = toupper(playerAnswer);
            if(playerAnswer != 'A' && playerAnswer != 'B' && playerAnswer != 'C' && playerAnswer != 'D' ){
                cout << "Please enter a valid answer.\nTry again.\n";
            }
            else{break;}
        }while(playerAnswer != 'A' && playerAnswer != 'B' && playerAnswer != 'C' && playerAnswer != 'D' );
        if(playerAnswer == answerKey[i]){
            cout << endl;
            cout << "Correct!\nThe answer was: " << answerKey[i] << endl; 
            totalCorrect++;
        }
        else{
            cout << endl;
            cout << "Wrong!\nThe answer is: " << answerKey[i] << endl;
        }
    }
    return size;
}
int hardGameMode(int &totalCorrect){
    char playerAnswer;
    string hardQuestions[] = {"Explain the concept of virtual functions in C++. Provide an example demonstrating the use of virtual functions in a class hierarchy.", 
                              "Discuss the differences between deep copy and shallow copy in C++. Provide examples illustrating the distinctions between the two.",
                              "What is the role of the typeid operator in C++? How can it be used to determine the type of an object dynamically?",
                              "Explain the purpose of the Standard Template Library (STL) in C++. Provide examples of commonly used containers and algorithms from the STL.",
                              "Describe the concept of multithreading in C++. How does it differ from multiprocessing, and what are the advantages and challenges of multithreading?",};

    string hardChoices[][4] = {{"A. Virtual functions: Defined in the base class and overridden in derived classes.", "B. Virtual functions: Can only be used with primitive data types.", "C. Virtual functions: Exclusively applicable to member variables.", "D. Virtual functions: Automatically called at program startup." },
                               {"A. Deep Copy: Copies the values of pointers, not the memory they point to.", "B. Shallow Copy: Creates a duplicate of the entire object, including dynamic memory.", "C. Deep Copy: Suitable for simple data structures.", "D. Shallow Copy: Copies only the values, not the addresses, of the data members." },
                               {"A. typeid: Determines the size of a variable.", "B. typeid: Used to check if an object is empty.", "C. typeid: Retrieves information about the type of an object during runtime.", "D. typeid: Limited to built-in data types only." },
                               {"A. STL: Provides a collection of template classes and functions.", "B. STL: Focused exclusively on numerical algorithms.", "C. STL: Primarily used for low-level memory management.", "D. STL: Limited to simple data structures like arrays." },
                               {"A. Multithreading: Involves multiple processes executing simultaneously.", "B. Multithreading: Allows multiple threads within a single process to run concurrently.", "C. Multithreading: Primarily used for sequential programming.", "D. Multithreading: Does not impact the performance of a program." }};
    char answerKey[] = {'A', 'B', 'C', 'A', 'B'};

    int size = sizeof(answerKey) / sizeof(answerKey[0]);

    for(int i=0; i < size; i++){
        cout << endl;
        cout << "***********************************************" << endl;
        cout << i + 1 << ". "  <<  hardQuestions[i] << endl;
        cout << "***********************************************" << endl << endl;


        for(int j = 0; j < sizeof(hardChoices[i]) / sizeof(hardChoices[i][0]); j++ ){
            cout  << hardChoices[i][j] << endl;
        }
        cout << endl;
        do{

            cout << "Answer: ";
            cin >> playerAnswer;

            playerAnswer = toupper(playerAnswer);
            if(playerAnswer != 'A' && playerAnswer != 'B' && playerAnswer != 'C' && playerAnswer != 'D' ){
                cout << "Please enter a valid answer.\nTry again.\n";
            }
            else{break;}
        }while(playerAnswer != 'A' && playerAnswer != 'B' && playerAnswer != 'C' && playerAnswer != 'D' );
        if(playerAnswer == answerKey[i]){
            cout << endl;
            cout << "Correct!\nThe answer was: " << answerKey[i] << endl; 
            totalCorrect++;
        }
        else{
            cout << endl;
            cout << "Wrong!\nThe answer is: " << answerKey[i] << endl;
        }
    }
    return size;
}
