#include <iostream>
#include <vector>


using std::cout;
using std::cin;
using std::string;
using std::vector;

int chooseDifficulty();
void determineGameMode(int playerDifficulty);
void gameEasyMode(int totalCorrect, int totalMistakes;
void gameMediumMode();
void gameHardMode();
char chooseAnswers(int i);
vector<char> getAnswers(char player[], int size);
int checkCorrectAnswers(int& totalCorrect, int& totalMistakes  , vector<char>& getAnswers, char correctAnswers[]);




int main(){

    int playerDifficulty, gameMode;
    char startGame, playAgain;
    int totalCorrect =0 , totalMistakes = 0,  totalScore = 0, overall = 0;
    
    

    
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

            playerDifficulty = chooseDifficulty();
            determineGameMode(playerDifficulty);



            cout << "Score: ";





            cout << "Play Again? (Y/N): ";
            cin >> playAgain;
            playAgain = toupper(playAgain);

            if(playAgain == 'N'){
                break;
            }
        }while(playAgain == 'Y');
    }





}
int chooseDifficulty(){
    int playerDifficulty= 0;
    do {
        cout << "Choose Dificulty: \n\n";
        cout << "\t 1. Easy (10 questions)\n";
        cout << "\t 2. Medium (5 questions)\n";
        cout << "\t 3. Hard (5 questions) \n\n";
        cout << "Your choice: ";
        cin >> playerDifficulty;
        if(playerDifficulty != 1 && playerDifficulty != 2 && playerDifficulty != 3){
            cout << "Invalid answer, try again. \n";
        }
    }while(playerDifficulty != 1 && playerDifficulty != 2 && playerDifficulty != 3  );
    
    return playerDifficulty;
}
void determineGameMode(int playerDifficulty){
    string mode;
    switch (playerDifficulty)
    {
    case 1:
        mode = "Easy";
        cout << "You have picked: " << mode << "\n\n";
        gameEasyMode();
        break;
    case 2:
        mode = "Medium";
        cout << "You have picked: " << mode << "\n\n";
        gameMediumMode();
        break;
    case 3:
        mode = "Hard";
        cout << "You have picked: " << mode << "\n\n";
        gameHardMode();
        break;
    
    default:
        break;
    }
}




char chooseAnswers(int i){
    char player;
    int size = 1;
    do{
        do{
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
void gameEasyMode(int totalCorrect, int totalMistakes){
    string questionTitle[] = {"Variables and Data Types", "Input and Output", "Equality Comparison", "Repetitive Execution", "Main Function Return Type", "Array Access", "Conditional Statements", "Functions", "Comments", "Object-Oriented Programming (OOP)"};
    string easyQuestions[] = {"What is the fundamental keyword used in many programming languages, including C++, to declare a variable that can store whole numbers?", "In programming, which commonly used header file is responsible for input and output operations?", "How is 'not equal to' represented in many programming languages, including C++?", "What type of control structure in programming is used to execute a block of code repeatedly as long as a specified condition is true?", "In programming languages like C++, what is the standard return type of the main function?", "How do you access the third element of an array in programming?", "What is the purpose of the 'else' statement in a conditional structure?", "In programming, what is a function?", "What is the purpose of comments in programming?", "In object-oriented programming, what is an object?" };
    string easyAnswers[] = {" A. Int\n B. Float\n C. Var\n D. Number\n\n", " A. iostream\n B. stdio\n C. io.h\n D. input.output\n\n", " A. !=\n B. ==\n C. <>\n D. /=\n\n", " A. For Loop\n B. While Loop\n C. Do-while Loop\n D. Switch Statement\n\n", " A. Void\n B. Int\n C. Main\n D. String\n\n", " A. array[2]\n B. array[3]\n C. array(2)\n D. array(3)\n\n", " A. It represents an alternative condition to be executed when the main condition is false.\n B. It marks the beginning of a loop.\n C. It is used to define a constant.\n D. It terminates the program.\n\n", " A. A variable that stores data.\n B. A keyword used for iteration.\n C. A block of reusable code that performs a specific task.\n D. A type of loop.\n\n",  " A. To mark the beginning of a program\n B. To add decorative elements to the code.\n C. To explain the code to developers and make it more readable.\n D. To highlight errors in the code.\n\n", " A. A piece of data.\n B. A sequence of characters.\n C. An instance of a class with its own attributes and behaviors.\n D. A loop structure.\n\n"};
    char correctAnswers[] = {'A', 'B', 'C', 'D', 'A', 'B', 'C', 'D', 'A', 'C'};

    char player[sizeof(easyQuestions) / sizeof(easyQuestions[0])];
    const int arr_Size = sizeof(easyQuestions) / sizeof(easyQuestions[0]);

    int i = 0;
    do{ 
        cout << "**********************************************************************************\n";
        cout << "Question " << i + 1 << ": " << questionTitle[i] << "\n\n"<< easyQuestions[i] << "\n\n";
        cout << easyAnswers[i];
        player[i] = chooseAnswers(i);
        i++;

    }while (i < sizeof(easyQuestions) / sizeof(easyQuestions[0]));

    checkCorrectAnswers(totalCorrect, totalMistakes, getAnswers(player, arr_Size), correctAnswers);

    
}
void gameMediumMode(){
    string questionTitle[] = {"Operators", "Strings", "Conditional Statements", "User Input", "Functions"};
    string mediumQuestions[] = {"What does the '%' operator do in C++?", "How do you declare a string variable in C++?", "In C++, what is the purpose of the switch statement?", "How do you get user input in C++?", "What is the correct way to declare a function in C++ that takes two integers as parameters and returns their sum?" };
    string mediumAnswers[] = {" A. Calculates the power of a number.\n B. Performs integer division.\n C. Finds the remainder of the division of two numbers.\n D. Checks for equality.\n\n", " A. string myString;.\n B. char myString;.\n C. text myString;\n D. str myString;\n\n", " A.  It is used to define a constant.\n B. It marks the beginning of a loop.\n C. It is used for exception handling.\n D. It provides a way to select among multiple alternatives based on the value of an expression.\n\n", " A. scan()\n B. input()\n C. cin >>\n D. readline()\n\n", " A. int sum(int a, b) { return a + b; }\n B. sum(int a, int b) { return a + b; }\n C. int add(int a, int b) { a + b; }\n D. int add(int a, int b) => a + b;\n\n" };
    char player[sizeof(mediumQuestions) / sizeof(mediumQuestions[0])];
    int arr_Size = sizeof(mediumQuestions) / sizeof(mediumQuestions[0]);
    
    int i = 0;
    do{ 
        cout << "**********************************************************************************\n";
        cout << "Question " << i + 1 << ": " << questionTitle[i] << "\n\n"<< mediumQuestions[i] << "\n\n";
        cout << mediumAnswers[i];
        player[i] = chooseAnswers(i);

        i++;

    }while (i < sizeof(mediumQuestions) / sizeof(mediumQuestions[0]));
    getAnswers(player, arr_Size);
}
void gameHardMode(){
    string questionTitle[] = {"Pointers and Memory Management", "Advanced Functions", "Advanced Concepts", "Templates and Generic Programming", "Exception Handling"};
    string hardQuestions[] = {"What is a memory leak in C++?", "What is a lambda expression in C++?", "What is the purpose of the constexpr keyword in C++?", "In C++, what is a template specialization?", "What is the difference between throw and throws in C++?" };
    string hardAnswers[] = {" A. A situation where a program uses more memory than is available.\n B. A situation where a program allocates memory but forgets to deallocate it.\n C. A situation where a program crashes due to insufficient memory.\n D. A situation where a program uses pointers excessively.\n\n", " A. A function that doesn't have a name.\n B. A type of exception handling.\n C. A way to define global variables.\n D. A function that takes another function as an argument.\n\n", " A.  To declare a constant variable.\n B. To indicate that a function should be executed at compile-time.\n C. To define a type alias.\n D. To declare a variable with a variable-sized array.\n\n", " A. A technique for creating generic classes and functions.\n B. A process of optimizing template code for better performance.\n C. A way to override the default behavior of a template for a specific data type.\n D. A feature for generating random numbers in templates.\n\n", " A. 'throw' is used to raise an exception, while throws is used to catch an exception.\n B. 'throw' is used in function declarations to indicate that the function can throw an exception, while throws is used to actually throw the exception.\n C. There is no difference; both keywords are interchangeable.\n D. 'throw' is used to raise an exception, while throws is not a valid keyword in C++.\n\n" };

    char player[sizeof(hardQuestions) / sizeof(hardQuestions[0])];
    int arr_Size = sizeof(hardQuestions) / sizeof(hardQuestions[0]);
    
    int i = 0;
    do{ 
        cout << "**********************************************************************************\n";
        cout << "Question " << i + 1 << ": " << questionTitle[i] << "\n\n"<< hardQuestions[i] << "\n\n";
        cout << hardAnswers[i];
        player[i] = chooseAnswers(i);

        i++;

    }while (i < sizeof(hardQuestions) / sizeof(hardQuestions[0]));
    getAnswers(player, arr_Size);
}

vector<char> getAnswers(char player[], int size){
    
    vector<char> playerAnswer(size);
    cout << "GetAnswers funct\n";
    for(int i =0; i < size; i++ ){
        // cout << player[i] << "\n";

        playerAnswer[i] += player[i];
    }

    return playerAnswer;

}
int checkCorrectAnswers(int& totalCorrect, int& totalMistakes  , vector<char>& getAnswers, char correctAnswers[]){
    int overall = sizeof(correctAnswers);

    for(int i =0; i < getAnswers.size(); i++){
        if(getAnswers[i] == correctAnswers[i]){
            totalCorrect++;
        }
        else{
            totalMistakes++;
        }
    }

    cout << "Correct Answers: " << totalCorrect << "\n\n";
    cout << "Correct Answers: " << totalMistakes << "\n\n";


    return overall;
}
int calcTotalScore(int totalScore){

}   




