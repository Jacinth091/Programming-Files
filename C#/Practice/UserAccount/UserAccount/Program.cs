using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections.Generic;
using static System.Console;

namespace UserAccount
{
    internal class Program
    {
        static List<UserData> users;
        static string[] adminKeys = { "admin", "admin123" };

        static void Main(string[] args)
        {
            users = new List<UserData>();
            bool isNewAcc;

            WriteLine("Sign UP");
            userSignUp();


            isNewAcc = userSignIn();

            if (!isNewAcc)
            {
                WriteLine("Main Menu");

            }
            else
            {
                WriteLine("Proceed");
            }

            dispList();

            ReadKey(true);

        }

        static public bool userSignIn()
        {
            bool oldAcc = false;
            bool isValid = false;
            string name, pass;

            do
            {
                WriteLine("Sign In\n");

                Write("Username: ");
                name = Console.ReadLine();

                Write("Password: ");
                pass = Console.ReadLine();


                for (int i = 0; i < users.Count(); i++)
                {
                    UserData data = users[i];

                    if (name.Equals(data.NameData))
                    {
                        if (pass.Equals(data.PassData))
                        {
                            oldAcc = true;
                            isValid = true;
                        }
                        else
                        {
                            WriteLine("Wrong Password, try again!");
                            continue;

                        }
                    }
                    else
                    {
                        WriteLine("Account don't exist, create an account first!!");
                        isValid = true;
                        //break;
                    }

                }

            } while (!isValid);

            return oldAcc;
        }

        static public void userSignUp()
        {
            string name, pass;

            Write("Username: ");
            name = Console.ReadLine();

            Write("Password: ");
            pass = Console.ReadLine();

            if (!name.Equals(adminKeys[0]) && !pass.Equals(adminKeys[1]))
            {
                users.Add(new UserData(name, pass, false));

            }
            else
            {
                users.Add(new UserData(name, pass, true));

            }

            WriteLine();
        }
        static public void dispList()
        {
            WriteLine();
            for (int i = 0; i < users.Count; i++) {
                UserData data = users[i];

                WriteLine("\nUser: " + (i+1));
                WriteLine($@"Username: {data.NameData}
Password: {data.PassData}
Admin Status?: {data.isAdminData}");


            }
            
        }
    }
    class UserData{
        string name;
        string pass;
        bool isAdmin;
        //string accId;
        //int idNum;


        public UserData(string name, string pass, bool isAdmin)
        {
            this.name = name;
            this.pass = pass;
            this.isAdmin = isAdmin;
        }

        public string NameData
        {
            get { return name; }
            set { name = value; }

        }

        public string PassData
        {
            get { return pass; }
            set { pass = value; }

        }

        public bool isAdminData
        {
            get { return isAdmin; }
            set { isAdmin = value; }

        }

    }
}
