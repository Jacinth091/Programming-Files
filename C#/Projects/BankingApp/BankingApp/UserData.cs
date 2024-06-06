using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections.Generic;
using static System.Console;

namespace BankingApp
{
    internal class UserData
    {
        private Random rand = new Random();
        private string userName;
        private string userPass;
        private string userAccNum;
        private int userId;
        private double userBal;
        private bool isAdmin;


        public UserData()
        {

        }
        public UserData(string userName, string userPass, bool isAdmin)
        {
            this.userName = userName;
            this.userPass = userPass;
            userBalData = setUserBal();
            userIdData = setUserId();
            userAccNumData = setUserAccNum();
            this.isAdmin = isAdmin;

        }

        public string userNameData
        {
            get { return this.userName; }
            set { this.userName = value; }
        }

        public string userPassData
        {
            get { return this.userPass; }
            set { this.userPass = value; }
        }


        public string userAccNumData
        {
            get { return this.userAccNum; }
            set { this.userAccNum = value; }
        }
        public int userIdData
        {
            get { return this.userId; }
            set { this.userId = value; }
        }

        public double userBalData
        {
            get { return this.userBal; }
            set { this.userBal = value; }
        }

        public bool isAdminData
        {
            get { return isAdmin; }
            set { isAdmin = value; }
        }


        public string setUserAccNum()
        {
            //string characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            string characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            char[] tempChar = new char[8];
            StringBuilder temp = new StringBuilder(8);
            rand = new Random();

            for(int i = 0; i < tempChar.Length; i++)
            {
                tempChar[i] = Convert.ToChar(characters[rand.Next(characters.Length)]);

                temp.Append(tempChar[i]);
                
            }

            string accIdNum = temp.ToString();

            return accIdNum;
        }

        public int setUserId() {
            return rand.Next(1000, 10000);
        }

        public double setUserBal()
        {
            double min = 1000.00;
            double max = 99999.00;
            return min + (rand.NextDouble()) *(max -min);
        }




    }
}
