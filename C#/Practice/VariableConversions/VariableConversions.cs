using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VariableConversions
{
    internal class VariableConversions
    {
        static void Main(string[] args)
        {
            // Convert String to Int = Convert.ToInt32();
            string ageSTR = "65";
            int ageInt = Convert.ToInt32(ageSTR);
            Console.WriteLine(ageInt);

            // Convert String to Long = Convert.ToInt64();
            string strBigNumber = "-900000000";
            long bigNumber = Convert.ToInt64(strBigNumber);
            Console.WriteLine(bigNumber);

            // Convert String to Double = Convert.ToDouble();
            string strPI = "3.141596854789315";
            double PI = Convert.ToDouble(strPI);
            Console.WriteLine(PI);

            // Convert String to float = Convert.ToSingle();
            string strPrice = "1040.256";
            float price = Convert.ToSingle(strPrice);
            Console.WriteLine(price);

            // Convert String to Decimal = Convert.ToDecimal();
            string strMoney = "23241635746254683468";
            decimal money = Convert.ToDecimal(strMoney);
            Console.WriteLine(money);


            Console.Read();
        }

        static void pyramid()
        {
            int i, j, n = 10;
            for (i = 1; i <= n; i++)
            {
                for (j = 1; j <= (2 * n) - 1; j++)
                {
                    if (j >= n - (i - 1) && j <= n + (i - 1))
                    {
                        Console.Write("*");
                    }
                    else
                    {
                        Console.Write(" ");
                    }
                }
                Console.Write("\n");
            }
        }

        static void misInputEx()
        {
            char choice;
            do
            {
                Console.Write("\nDo you want to try again? (Y = Yes, N = No): ");
                choice = char.ToUpper(Console.ReadLine()[0]);

                //input = Console.ReadLine();
                //choice = char.ToUpper(input[0]);
                choice = char.ToUpper(Console.ReadKey().KeyChar);


                if (choice != 'Y' && choice != 'N')
                {
                    Console.Write("\nInvalid Input, try again!\n");
                    continue;
                }
                else if (choice == 'N')
                {
                    Console.Write("\nThank you for using the program, see ya!\n");
                    break; ;
                }
                else
                {
                    Console.Write("\nProceed with the program!\n");
                    break;
                }

            } while (true);
        }
    }
}
