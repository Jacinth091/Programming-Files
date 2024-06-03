using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Simple_Calculator
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("*********************************** Simple Calculator ***********************************");


            double num1, num2, result = 0 ;
            char oper;
            bool num2IsZero = false, invalidOper = false;

            Console.Write("Enter number 1: ");
            num1 = checkValidInput();

            Console.Write("Enter number 2: ");
            num2 = checkValidInput();

            Console.Write("Enter operation ( +, -, *, / ): ");
            oper = checkValidChar();

            switch (oper)
            {
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;

                case '*':
                    result = num1 * num2;
                    break;

                case '/':
                    if (num2 == 0)
                    {
                        Console.WriteLine("Dividing by Zero is not Allowed!");
                        num2IsZero = true;
                        return;
                    }
                    else
                    {
                        result = num1 / num2;
                    }
                    break;

                case '%':
                    if (num2 == 0)
                    {
                        num2IsZero = true;

                        return;
                    }
                    else
                    {
                        result = num1 % num2;
                    }
                    break;

                default:
                    invalidOper = true;
                    break;

            }

            if (num2IsZero)
            {
                
                Console.WriteLine("Dividing by Zero is not Allowed!");


            }
            else
            {
                if (invalidOper)
                {
                    Console.WriteLine("Invalid Operator!");

                }
                else
                {
                    Console.WriteLine($"Result: {result:N2}");

                }
            }






            Console.WriteLine("\nThe program has ended, press any key to exit...");

            Console.ReadKey();
        }

        static double checkValidInput()
        {   
            double inp = 0;

            while (!double.TryParse(Console.ReadLine(), out inp))
            {
                Console.WriteLine("Enter a valid number!, try again.");
            }
            

            return inp;
        }

        static char checkValidChar()
        {
            char inpt;

            while (!char.TryParse(Console.ReadLine(),out inpt))
            {
                Console.WriteLine("Enter a character only!, try again.");
            }


            return inpt;
        }
    }
}
