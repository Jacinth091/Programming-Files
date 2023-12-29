#include <iostream>


using std::cout;
using std::cin;
using std::string;
using namespace std;



int checkDifficulty(int difficulty);
char chooseAnswer(int i);
void determineMode(int gameMode);
void totalCorrectAnswer();
void easyQuestions();
void mediumQuestions();
void hardQuestions();


int main() {
    int difficulty, gameMode;
    string Mode;
    char response, startGame;


    cout << "\n\n*************************************\n";
    cout << "          Simple Quiz Game\n";
    cout << "*************************************\n\n";

    do{
        cout << "Start Game? (Y/N): ";
        cin >> startGame;

        startGame = toupper(startGame);
        if(startGame == 'N'){
            break;
        }
    }while(startGame != 'Y' || startGame == 'N');
    if(startGame == 'N'){
        cout << "Goodbye!\n";
    }
    else{
        do {


            gameMode = checkDifficulty(difficulty);
            determineMode(gameMode);


            cout << "Game Mode: " << gameMode << '\n';





















            cout << "Play Again? (Y/N): ";
            cin >> response;
            response = toupper(response);

            if(response == 'N'){
                break;
            }
        }while(response == 'Y');
    }





}
int checkDifficulty(int difficulty){
    do {
        cout << "Choose Dificulty: \n\n";
        cout << "\t 1. Easy (10 questions)\n";
        cout << "\t 2. Medium (5 questions)\n";
        cout << "\t 3. Hard (3 questions) \n\n";
        cout << "Your choice: ";
        cin >> difficulty;
        if(difficulty != 1 && difficulty != 2 && difficulty != 3){
            cout << "Invalid answer, try again. \n";
        }
    }while(difficulty != 1 && difficulty != 2 && difficulty != 3  );
    
    return difficulty;
}

void determineMode(int gameMode){

    string mode;
    switch (gameMode)
    {
    case 1:
        mode = "Easy";
        cout << "You have picked: " << mode << "\n\n";
        easyQuestions();
        break;
    case 2:
        mode = "Medium";
        cout << "You have picked: " << mode << "\n\n";
        easyQuestions();
        break;
    case 3:
        mode = "Hard";
        cout << "You have picked: " << mode << "\n\n";
        easyQuestions();
        break;
    
    default:
        break;
    }

}

char chooseAnswer(int i){
    char player;
    int size = 1;
    do{
        do{
            // char temp;
            cout << "Answer: ";
            cin >> player;
            cout << "**********************************************************************************\n";
            player = toupper(player);
            if(player != 'A' && player!= 'B' && player != 'C' && player != 'D' ){
                cout << "Invalid answer, try again. \n";
            }

        }while(player != 'A' && player != 'B' && player != 'C' && player != 'D' );
        i++;

    }while ( i < size);
    return player;
}

void totalCorrectAnswer(){

}

void easyQuestions(){
        
    char player[10];
    
    string questionTitle[] = {"Variables and Data Types", "Input and Output", "Equality Comparison", "Repetitive Execution", "Main Function Return Type", "Array Access", "Conditional Statements", "Functions", "Comments", "Object-Oriented Programming (OOP)"};
    string easyQuestions[] = {"What is the fundamental keyword used in many programming languages, including C++, to declare a variable that can store whole numbers?", "In programming, which commonly used header file is responsible for input and output operations?", "How is 'not equal to' represented in many programming languages, including C++?", "What type of control structure in programming is used to execute a block of code repeatedly as long as a specified condition is true?", "In programming languages like C++, what is the standard return type of the main function?", "How do you access the third element of an array in programming?", "What is the purpose of the 'else' statement in a conditional structure?", "In programming, what is a function?", "What is the purpose of comments in programming?", "In object-oriented programming, what is an object?" };
    string easyAnswers[] = {" A. Int\n B. Float\n C. Var\n D. Number\n\n", " A. iostream\n B. stdio\n C. io.h\n D. input.output\n\n", " A. !=\n B. ==\n C. <>\n D. /=\n\n", " A. For Loop\n B. While Loop\n C. Do-while Loop\n D. Switch Statement\n\n", " A. Void\n B. Int\n C. Main\n D. String\n\n", " A. array[2]\n B. array[3]\n C. array(2)\n D. array(3)\n\n", " A. It represents an alternative condition to be executed when the main condition is false.\n B. It marks the beginning of a loop.\n C. It is used to define a constant.\n D. It terminates the program.\n\n", " A. A variable that stores data.\n B. A keyword used for iteration.\n C. A block of reusable code that performs a specific task.\n D. A type of loop.\n\n",  " A. To mark the beginning of a program\n B. To add decorative elements to the code.\n C. To explain the code to developers and make it more readable.\n D. To highlight errors in the code.\n\n", " A. A piece of data.\n B. A sequence of characters.\n C. An instance of a class with its own attributes and behaviors.\n D. A loop structure.\n\n"};

    int i = 0;
    do{ 
        cout << "**********************************************************************************\n";
        cout << "Question " << i + 1 << ": " << questionTitle[i] << "\n\n"<< easyQuestions[i] << "\n\n";
        cout << easyAnswers[i];
        player[i] = chooseAnswer(i);

        i++;

    }while (i < sizeof(easyQuestions) / sizeof(easyQuestions[0]));
    for(int j = 0; j < sizeof(player)/ sizeof(player[0]); j++){
        cout << player[j] << "\n";
    }

}

void mediumQuestions(){

}
void hardQuestions(){

}
