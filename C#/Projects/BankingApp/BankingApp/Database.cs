using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections.Generic;
using static System.Console;

namespace BankingApp
{
    internal class Database
    {
        UserData userData;

        private List<UserData> users = new List<UserData>();
        private Random rand = new Random();


        private List<string> userName = new List<string>();
        private List<string> userPass = new List<string>();
        private List<string> userAccNum = new List<string>();
        private List<int> userId = new List<int>();
        private List<double> userBal = new List<double>();


        public Database()
        {
            //users.Add(userData);
        }

        public List<UserData> usersDB
        {
            get { return users; }
            set { users = value; }
        
        }


        

        public void dispList()
        {

            string userName, userPass, userAccNum;
            int idNum;
            double userBal;
            for(int i =0; i <users.Count; i++)
            {
                UserData data = users[i];
                userName = data.userNameData;
                userPass = data.userPassData;
                userAccNum = data.userAccNumData;
                idNum  = data.userIdData;
                userBal = data.userBalData;

                WriteLine();
                WriteLine($@"Username: {userName},
Password: {userPass},
AccNum:   {userAccNum},
ID num:   {idNum},
Balance:  {userBal}"
                             
                             );
                
            }
        }





    }
}
