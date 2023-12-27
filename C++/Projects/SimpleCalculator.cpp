#include <iostream>
#include <cmath>
#include <string>

using std::cout;
using std::cin;
using std::string;

int main(){
	
	double num1, num2, result;
	char operat, response;
	 

	do {
		
		cout << "Simple Calculator:" << '\n';
		// Prompt and read num1
		cout << "Enter num 1: ";
		while (!(cin >> num1)) {
			cout << "Invalid input. Please enter a valid number: ";
			cin.clear(); // Clear the error flag
			cin.ignore(10000, '\n'); // Discard the input buffer up to newline
		}

		// Prompt and read num2
		cout << "Enter num 2: ";
		while (!(cin >> num2)) {
			cout << "Invalid input. Please enter a valid number: ";
			cin.clear(); // Clear the error flag
			cin.ignore(10000, '\n'); // Discard the input buffer up to newline
		
    	}
	
		do{
			cout << "Enter Operation (+, -, *, /, %): ";
			cin >> operat;
				
		}while( operat != '+' && operat != '-' && operat != '*' && operat != '/' && operat != '%'   );
		
		switch (operat) {
			case '+':
				result = num1 + num2;
			break;
			case '-':
				result = num1 - num2;
			break;
			case '*':
				result = num1 * num2;
			break;
			case '/':
				if (num2 == 0){
					cout << "Undefined";
					}
				else {
					result = num1 / num2;
					}
			break;
				case '%':
				result = (int) num1 % (int)num2;
			break;
			default:
				return 1;
			break;
		
			}
			cout << "Result: " << result << '\n';

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
	
	
	
}













