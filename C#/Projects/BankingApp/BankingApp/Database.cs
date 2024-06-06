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

        private List<UserData> users;
        private Random rand = new Random();
        private string[] adminKeys = {"admin", "admin123"};

        private List<string> userNameList;
        private List<string> userPassList;
        private List<string> userAccNumList;
        private List<int> userIdList;
        private List<double> userBalList;



        public Database()
        {
            users = new List<UserData>();
            userNameList = new List<string>();
            userPassList = new List<string>();
            userAccNumList = new List<string>();
            userIdList = new List<int>();
            userBalList = new List<double>();
            initAdminKeys();
            
        }

        public List<UserData> usersDB
        {
            get { return users; }
            set { users = value; }
        
        }

        public string[] adminKeysData
        {
            get { return adminKeys; }
            set { adminKeys = value; }
        }

        private void initAdminKeys()
        {
            users.Add(new UserData(adminKeys[0], adminKeys[1], true));
        }
        

        public void dispList()
        {

            string userName, userPass, userAccNum;
            int idNum;
            double userBal;
            bool adminStat;
            for (int i =0; i <users.Count; i++)
            {
                UserData data = users[i];
                userName = data.userNameData;
                userPass = data.userPassData;
                userAccNum = data.userAccNumData;
                idNum  = data.userIdData;
                userBal = data.userBalData;
                adminStat = data.isAdminData;


                userNameList.Add(userName);
                userPassList.Add(userPass);
                userIdList.Add(idNum);
                userAccNumList.Add(userAccNum);
                userBalList.Add(userBal);

                WriteLine();

                if (!adminStat)
                {
                    WriteLine($@"Username: {userName},
Password: {userPass},
AccNum:   {userAccNum},
ID num:   {idNum},
Balance:  ${userBal:N2},
Admin Status?: {adminStat}");
                }
                else
                {
                    WriteLine($@"Username: {userName}
Password: {userPass}
Admin Status?: {adminStat}");
                }

                
            }
        }

        public void initDataList()
        {
            string userName, userPass, userAccNum;
            int idNum;
            double userBal;
            for (int i = 0; i < users.Count; i++)
            {
                UserData data = users[i];
                userName = data.userNameData;
                userPass = data.userPassData;
                userAccNum = data.userAccNumData;
                idNum = data.userIdData;
                userBal = data.userBalData;

                userNameList.Add(userName);
                userPassList.Add(userPass);
                userIdList.Add(idNum);
                userAccNumList.Add(userAccNum);
                userBalList.Add(userBal);


            }
        }





    }
}
