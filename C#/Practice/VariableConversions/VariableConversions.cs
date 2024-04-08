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

            string ageSTR = "65";
            int ageInt = Convert.ToInt32(ageSTR);

            Console.WriteLine("You're currently {0}, years old!\n", ageInt);
            Console.WriteLine(ageInt.GetType());

            Console.Write("What is your name?: ");
            string name = Console.ReadLine();

            Console.WriteLine("Hello! {0}, It's nice to meet you!\n", name);

            for(int i = 0; i< 10; i++)
            {
                Console.WriteLine("{0} ", i+1);
            }

            char choice;
            do
            {
                Console.Write("\nDo you want to try again? (Y = Yes, N = No): ");
                choice = char.ToUpper(Console.ReadLine()[0]);

                //input = Console.ReadLine();
                //choice = char.ToUpper(input[0]);
                //choice = char.ToUpper(Console.ReadKey().KeyChar);


                if (choice != 'Y' && choice != 'N')
                {
                    Console.Write("\nInvalid Input, try again!\n");
                    continue;
                }
                else if(choice == 'N')
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



            Console.Read();
        }
    }
}
