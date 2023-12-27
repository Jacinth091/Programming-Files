#include <iostream>

using std::cout;
using std::cin;
using std::string;


void printOddNumbers(int start, int end);
void printEvenNumbers(int start, int end);
void usersChoice(char input, int start, int end);


int main() {
    
    int start;
    int end;
    char input, response;
    
    
    do{
        do{
            
            cout << "Even or Odd? (E/O): ";
            cin >> input;
            input = toupper(input);
            
            if(input != 'E' && input !=  'O') {
                cout << "Invald Input, Please try again!" << '\n';
            }
        
        }while(input != 'E' && input !=  'O');
        
        usersChoice(input, start, end);
        
        do {
           	cout << "Again? (Y/N): ";
           	cin >> response;
           	response = toupper(response);
           	if (response == 'N'){
       		    break;
	    	}    	
    	}while (response != 'Y' || response == 'N');

		if (response == 'N') {
			cout << "Thanks, see you again!" << '\n' <<'\n';
			break;
		}
	}while (response == 'Y');
   
    
    return 0;
}

void usersChoice(char input, int start, int end) {
    switch (input) {
        case 'E':
            cout << "**************** EVEN NUMBERS ****************\n";
            cout << "Enter starting number:  ";
            cin >> start;
            
            cout << "Enter ending number: ";
            cin >> end;
    
            printEvenNumbers(start, end);
            cout << "\n";
            cout << "\n";
            cout << "**************** ----------- *****************";
            cout << "\n";
        break;
        case 'O':
            cout << "**************** ODD NUMBERS ****************\n";
            cout << "Enter starting number:  ";
            cin >> start;
            
            cout << "Enter ending number: ";
            cin >> end;
            printOddNumbers(start, end);
            cout << "\n";
            cout << "\n";
            cout << "**************** ----------- ****************";
            cout << "\n";
        break;
        default:
            cout << "Error!";
        break;
     }
}

void printEvenNumbers(int start, int end){
    for (int i = start; i <= end; i++){
        if(i % 2 == 0) {
            cout << i << ' ';
            continue;
        }
    }
    
}

void printOddNumbers(int start, int end){
    
    for (int i = start; i <= end; i++){
    
        if(i % 2 >= 1) {
            cout << i << ' ';
            continue;
        }
    }
}



























