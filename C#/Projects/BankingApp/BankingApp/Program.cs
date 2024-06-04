using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;

namespace BankingApp
{
    internal class Program
    {
        static Bank mainBank;
        static UserData[] users;
        static Database db;

        static void Main(string[] args)
        {
            users = new UserData[1];
            db = new Database();
            string name, password;
            double bal =0;

            for (int i = 0; i < users.Length; i++)
            {
                Write("UserName:  ");
                name = Console.ReadLine();
                Write("Password:  ");
                password = Console.ReadLine();
                Write("Input Balance: ");
                bal = Double.Parse(Console.ReadLine());

                db.usersDB.Add(users[i] = new UserData(name, password, bal));
               
            }


            db.dispList();



            ReadKey(true);
        }
    }
}
