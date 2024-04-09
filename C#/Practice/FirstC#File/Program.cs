using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FirstC_File
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
            Console.WriteLine("*****************************************\n");


            operations();





            Console.ReadLine();
        }

        static void dataTypes()
        {
            Console.WriteLine("\nData Types in C#");

            // Data Types in C#

            // int = Integers
            Console.WriteLine("\nInt data type");
            int age = 23;
            Console.WriteLine(age);
            Console.WriteLine(int.MaxValue);
            Console.WriteLine(int.MinValue);

            // long = long int64 numbers
            Console.WriteLine("\nLong data type");
            long longNumbers = 123456879123L;
            Console.WriteLine(longNumbers);
            Console.WriteLine(long.MaxValue);
            Console.WriteLine(long.MinValue);

            // double = floating-point numbers with high precision
            Console.WriteLine("\nDouble data type");
            double PI = 3.14159D;
            Console.WriteLine(PI);
            Console.WriteLine(double.MaxValue);
            Console.WriteLine(double.MinValue);

            // float = floating-point numbers with average precision
            Console.WriteLine("\nFloat data type");
            double price = 396.23F; // Must end with 'F' to know that it is a Float
            Console.WriteLine(price);
            Console.WriteLine(float.MaxValue);
            Console.WriteLine(float.MinValue);


            // decimal = numbers that are much more higher value than long
            Console.WriteLine("\nDecimal data type");
            decimal numbers = 123456789101112134M; // Must end with 'M' to know that it is a Decimal
            Console.WriteLine(numbers);
            Console.WriteLine(decimal.MaxValue);
            Console.WriteLine(decimal.MinValue);

            // char = holds only a singular character 'A';
            Console.WriteLine("\nChar data type");
            char grade = 'A';
            Console.WriteLine(grade);

            /*            Console.WriteLine(char.MaxValue);
                        Console.WriteLine(char.MinValue);*/

            // string = holds multiple caracters in one single phrase/word;
            Console.WriteLine("\nString data type");
            string name = "Jacinth Cedric Barral";
            Console.WriteLine("My name is: " + name + "\n");
            /*
            Console.WriteLine(string.MaxValue);
            Console.WriteLine(string.MinValue);*/

            // BOOLEAN DATA TYPE

            Console.WriteLine("Boolean Data Types: True or False");

            bool isWomen = false;
            Console.WriteLine(isWomen);
            bool isMale = true;
            Console.WriteLine(isMale);

            bool isStudent = Convert.ToBoolean(0);
            Console.WriteLine(isStudent);
            bool isHuman = Convert.ToBoolean(1);
            Console.WriteLine(isHuman);

        }

        static void operations()
        {
            int age = 21;
            age++;
            // age = age + 1 OR age += 1 <-- Shorthand shortcut
            Console.WriteLine(age);
            age--;
            Console.WriteLine(age);
        }
    }
}
