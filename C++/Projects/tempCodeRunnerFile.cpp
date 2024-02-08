     do{
        cout << "Start Game? (Y/N): ";
        cin >> startGame;

        startGame = toupper(startGame);
        if(startGame == 'N'){
            break;
        }
    }while(startGame != 'Y' || startGame == 'N');