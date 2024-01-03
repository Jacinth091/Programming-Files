#include <iostream>
#include <iomanip>

using namespace std;


int main(){

    // shopping cart 

    string items[] = {"Nutella", "Apple", "KitKat", "Axe Body Spray", "Safeguard Body Wash" };
    string customerItems;
    string itemsBought[100];
    char askCustomer;
    int itemQuantity[] = {138, 67, 153, 74, 30};
    float itemPrices[] = {150.00, 13.00, 160.00, 150.00, 190.00 };
    float totalPrice = 0, totalBill = 0;
    float itemsPrices[100];
    int addToCart = 0, numItems = 0, count = 0, itemsCounter = 0;
    bool continueShopping = true;
                         
    cout << endl << "*********************************************" << endl;
    cout << "*                   Store                   *" << endl;
    cout << "*********************************************" << endl << endl;

    for(int i = 0; i < sizeof(items) / sizeof(items[0]); i++){
        cout << "  " << i + 1 << ". " << items[i] << ":  x" << itemQuantity[i] << endl;
        cout << "     " << "Price: $" << fixed << setprecision(2)  << itemPrices[i] << endl << endl;
        cout << defaultfloat;
    }

    cout << endl << "*********************************************" << endl;

    cout << "*********************************************" << endl;
    cout << "*                 Your Cart                 *" << endl;
    cout << "*********************************************" << endl << endl;

    do
    {   
        numItems = 0, itemsCounter = 0, totalPrice = 0;

        cout << endl;
        cout << "Add one to cart, item #: ";
        cin >> addToCart;

        customerItems = items[addToCart - 1];
        itemsBought[count] += customerItems;

        cout << "How many would you like to buy for \"" << customerItems << "\" ?: ";
        cin >> numItems;
        itemsCounter = itemPrices[addToCart - 1];

        if (numItems != 0){
            totalPrice = (float) numItems * itemsCounter;
            itemsPrices[count] += totalPrice;

        }
        do {
            cout << endl << "Would you like to buy another? (Y/N): ";
            cin >> askCustomer;

            askCustomer = toupper(askCustomer);
            if (askCustomer == 'N') {
                continueShopping = false;
                break;
            }
            else if (askCustomer == 'Y') {
                continueShopping = true;
                break;
            }
        } while (true);

        count++;
    } while (continueShopping);
    cout << "*********************************************" << endl;
    cout << endl;
    cout << "*********************************************" << endl;
    cout << "*                 Receipt                   *" << endl;
    cout << "*********************************************" << endl << endl;

    cout << "  Items:                       Price:" << endl << endl;

    for(int i = 0; i < count; i++){
        if (!itemsBought[i].empty() && itemsPrices[i] != 0.0 ) {
            cout << "  " << i + 1 << ". " << setw(30) << left << itemsBought[i] << " || $" << setw(7) << setprecision(2) << fixed << itemsPrices[i] << endl;
            totalBill += itemsPrices[i];    
        }
    }

    cout << endl << "Your total bill: $" << setw(7) << setprecision(2) << fixed << totalBill << endl << endl;
    cout << "*********************************************" << endl;




}