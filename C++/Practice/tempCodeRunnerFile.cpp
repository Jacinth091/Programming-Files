    cout << endl << "*********************************************" << endl;
    cout << endl;
    cout << "*********************************************" << endl;
    cout << "*                 Receipt                   *" << endl;
    cout << "*********************************************" << endl << endl;

    cout << "  Items: \t\t\tPrice:" << endl << endl;

    for(int i = 0; i < count; i++){
        if (!itemsBought[i].empty() && itemsPrices[i] != 0.0 ) {
            cout << "  " << i + 1 << ". " << setw(30) << left << itemsBought[i] << " || $" << setprecision(2) << fixed << itemsPrices[i] << endl;
            totalBill += itemsPrices[i];    
        }
    }

    cout << endl << "Your total bill: $" << setprecision(2) << fixed << totalBill << endl;
    cout << endl << "*********************************************" << endl;
