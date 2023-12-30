#include <iostream>

using namespace std;

int main(){

    string questions[] = {"Who created Facebook?: ",
                          "How do you declare a string variable in c++?:", 
                          "What is the expected output for this equation?:\ncout << '100 + 2';", 
                          "How do you access the 2nd element in an array?: ",
                          "Which of these are correct in naming variables?: "};

    string choices[][5] = {{"A. Mark Zuckerberg", "B. Elon Musk", "C. Jeff Bezos", "D. Henry Sy" },
                           {"A. std::strings var_name", "B. std::text var name", "C. std::string var_Name", "D. std:string var_Name"},
                           {"A. 102", "B. '1002'",  "C. 539697202 ", "D. 100 + 2"},
                           {"A. array(2)", "B. array[1]", "C. array(1)", "D. array[2]"},
                           {"A. 1_item", "B. #item_One", "C. _itemOne", "D. itemOne"}};

    char answerKey[] = {'A', 'C', 'C', 'B', 'D'};
    int size = sizeof(questions)/ sizeof(questions[0]);
    char playerAnswer;
    int score;

    for(int i = 0; i < size; i++){
        cout << "***********************************************\n";
        cout << i + 1 << ". " << questions[i] << "\n";
        cout << "***********************************************\n";
        for(int j = 0; j < sizeof(choices[i])/sizeof(choices[i][j]); j++){
            cout << choices[i][j] << "\n";
        }
        cout << "Answer: ";
        cin >> playerAnswer;
        playerAnswer = toupper(playerAnswer);

        if(playerAnswer == answerKey[i]){
            cout << "Correct!\n";
            score++;
        }
        else{
            cout << "Wrong!\nCorrect answer is: " << answerKey[i] << "\n";
        }
    }
        cout << "****************************\n";
        cout << "*          RESULTS         *\n";
        cout << "****************************\n";
        cout << "Your answers that are correct: " << score << "\n";
        cout << "Total # of questions: " << size << "\n";
        cout << "Percentage: " << (score/(double)size)*100 << "%" <<"\n";





}