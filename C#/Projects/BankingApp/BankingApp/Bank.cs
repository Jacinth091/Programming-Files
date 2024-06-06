using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;

namespace BankingApp
{
    internal class Bank
    {
        private string loggedUsername;
        private string loggedUserAccNum;
        private int loggedUserId;
        private double loggedUserBal;
        private int selIndex;
        private bool isAdmin;
        private bool loggedSuccess = false;

        static Bank mainBank;
        static Database db;

        public Bank()
        {
            db = new Database();

        }

        //}
        public void MainMenu()
        {
            string[] options = { "Sign In", "Sign Up", "Exit" };
            string prompt = "Bank Program v1.0";
            Menu mainMenu = new Menu(options, prompt);

            selIndex = mainMenu.runMenu();

            switch (selIndex) {

                case 0:
                    userSignIn();

                    if (isAdmin)
                    {
                        WriteLine("Admin Dashboard");
                    }
                    else if (loggedSuccess)
                    {

                        MainBankApp();
                    }

                    break;
                case 1:

                    userSignUp();




                    break;
                case 2:
                    Clear();
                    db.dispList();
                    WriteLine("\nPress any key to exit the program....");
                    ReadKey();
                    Environment.Exit(0);

                    break;
                
            }

        }

        public void MainBankApp()
        {
            string[] options = {"Check Balance", "Withdraw Money", "Deposit Money", "Exit"};
            string prompt = $"Welcome back, {loggedUsername}.";
            Menu mainApp = new Menu(options, prompt);

            selIndex = mainApp.runMainApp();

            switch (selIndex)
            {

                case 0:
                    WriteLine("Check Balance");
                    WriteLine($"Your current balance is: {loggedUserBal:N2}\n");

                    WriteLine("\nPress any key to go back to the menu....");
                    ReadKey();
                    MainBankApp();

                    break;
                case 1:

                    WriteLine("Withdraw Money");
                    break;
                case 2:
                    WriteLine("Deposit Money");

                    break;
                case 3:
                    Clear();
                    db.dispList();
                    WriteLine("\nPress any key to exit the program....");
                    ReadKey();
                    Environment.Exit(0);

                    break;

            }
        }

        public void userSignIn()
        {

            bool isValid = false;
            bool invalidPass = false;

            string userName, userPass;

            do
            {
                Clear();
                WriteLine("\nSign In\n");
                if (invalidPass == true)
                {
                    BackgroundColor = ConsoleColor.DarkRed;
                    ForegroundColor = ConsoleColor.White;
                    Write("Message :");
                    BackgroundColor = ConsoleColor.White;
                    ForegroundColor = ConsoleColor.Black;
                    WriteLine(" Incorrect Password!!, try again\n");
                    ResetColor();
                    invalidPass = false;

                }

                Write("Username: ");
                userName =ReadLine();

                Write("Password: ");
                userPass = ReadLine();

                bool userFound = false;
                

                foreach(UserData data in db.usersDB)
                {
                    //UserData data = db.usersDB[i];

                    if (userName.Equals(data.userNameData))
                    {
                        userFound = true;
                        if (userPass.Equals(data.userPassData))
                        {
                            isAdmin = data.isAdminData;
                            isValid = true;
                            loggedSuccess = true;

                            getLoggedUserData(data);

                            break;
                        }
                        else
                        {
                            invalidPass = true;
                            break;

                        }

                    }
                }

                if (!userFound)
                {
                    WriteLine("Account don't exist, create an account first!");
                    WriteLine("\nPress any key to go back to the Main Menu....");
                    ReadKey(true);
                    MainMenu();
                }
                





            } while (!isValid);


        }
        public void userSignUp()
        {
            Clear();
            string userName, userPass;

            Write("Username:  ");
            userName = Console.ReadLine();
            Write("Password:  ");
            userPass = Console.ReadLine();

            if (!userName.Equals(db.adminKeysData[0]) && !userPass.Equals(db.adminKeysData[1]))
            {
                db.usersDB.Add(new UserData(userName, userPass, false));

            }
            //else
            //{
            //    WriteLine("There is an admin account already in the database!");
            //}



            MainMenu();
        }

        private void getLoggedUserData(UserData data)
        {
            logUsernameData = data.userNameData;
            logUserAccNumData = data.userAccNumData;
            logUserIdData = data.userIdData;
            logUserBalData = data.userBalData;
        }


        private string logUsernameData
        {
            get { return loggedUsername; }
            set { loggedUsername = value; }
        }

        private string logUserAccNumData
        {
            get { return loggedUserAccNum; }
            set { loggedUserAccNum = value; }
        }

        private double logUserBalData
        {
            get { return loggedUserBal; }
            set { loggedUserBal = value; }
        }
        private int logUserIdData
        {
            get { return loggedUserId; }
            set { loggedUserId = value; }
        }




        private void checkBalance()
        {

        }
        private void withdrawMoney()
        {

        }
        private void depositeMoney()
        {
                
        }




    }
}
