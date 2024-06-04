using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BankingApp
{
    internal class Bank
    {
        private string userName;
        private string userAccNum;
        private int userId;
        private double userBal;


        public Bank()
        {

        }

        public Bank(string userName, double userBal,string userAccNum, int userId)
        {
            this.userName = userName;
            this.userAccNum = userAccNum;
            this.userBal = userBal;
            this.userId = userId;


        }
        public void MainMenu()
        {
            string[] options = { "Sign In", "Sign Up", "Exit" };
            string prompt = "Bank Program v1.0";
            Menu mainMenu = new Menu(options, prompt);
            mainMenu.runMenu();
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
