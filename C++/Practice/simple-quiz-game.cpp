#include <iostream>

using namespace std;

int main(){

    
    char player[10];
    char playerAnswer;
    
    string questionTitle[] = {"Variables and Data Types", "Input and Output", "Equality Comparison", "Repetitive Execution", "Main Function Return Type", "Array Access", "Conditional Statements", "Functions", "Comments", "Object-Oriented Programming (OOP)"};
    string easyQuestions[] = {"What is the fundamental keyword used in many programming languages, including C++, to declare a variable that can store whole numbers?", "In programming, which commonly used header file is responsible for input and output operations?", "How is 'not equal to' represented in many programming languages, including C++?", "What type of control structure in programming is used to execute a block of code repeatedly as long as a specified condition is true?", "In programming languages like C++, what is the standard return type of the main function?", "How do you access the third element of an array in programming?", "What is the purpose of the 'else' statement in a conditional structure?", "In programming, what is a function?", "What is the purpose of comments in programming?", "In object-oriented programming, what is an object?" };
    string easyAnswers[] = {" A. Int\n B. Float\n C. Var\n D. Number\n\n", " A. iostream\n B. stdio\n C. io.h\n D. input.output\n\n", " A. !=\n B. ==\n C. <>\n D. /=\n\n", " A. For Loop\n B. While Loop\n C. Do-while Loop\n D. Switch Statement\n\n", " A. Void\n B. Int\n C. Main\n D. String\n\n", " A. array[2]\n B. array[3]\n C. array(2)\n D. array(3)\n\n", " A. It represents an alternative condition to be executed when the main condition is false.\n B. It marks the beginning of a loop.\n C. It is used to define a constant.\n D. It terminates the program.\n\n", " A. A variable that stores data.\n B. A keyword used for iteration.\n C. A block of reusable code that performs a specific task.\n D. A type of loop.\n\n",  " A. To mark the beginning of a program\n B. To add decorative elements to the code.\n C. To explain the code to developers and make it more readable.\n D. To highlight errors in the code.\n\n", " A. A piece of data.\n B. A sequence of characters.\n C. An instance of a class with its own attributes and behaviors.\n D. A loop structure.\n\n"};

    int i = 0;
    do{ 
        cout << "**********************************************************************************\n";
        cout << "Question " << i + 1 << ": " << questionTitle[i] << "\n\n"<< easyQuestions[i] << "\n\n";
        cout << easyAnswers[i];

        do{
            cout << "Answer: ";
            cin >> player[i];
        cout << "**********************************************************************************\n";
            player[i] = toupper(player[i]);
            if(player[i] != 'A' && player[i] != 'B' && player[i] != 'C' && player[i] != 'D' ){
                cout << "Invalid answer, try again. \n";
            }

        }while(player[i] != 'A' && player[i] != 'B' && player[i] != 'C' && player[i] != 'D' );

        i++;

    }while (i < sizeof(easyQuestions) / sizeof(easyQuestions[0]));
    for(int j = 0; j < sizeof(player)/ sizeof(player[0]); j++){
        cout << player[j] << "\n";
    }


}