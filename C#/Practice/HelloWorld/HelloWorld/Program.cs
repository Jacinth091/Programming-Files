using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Remoting.Metadata.W3cXsd2001;
using System.Text;
using System.Threading.Tasks;

namespace HelloWorld
{
    internal class Program
    {
        static void Main(string[] args)
        {

            int age;
            string name;
            string course;

            Console.WriteLine("Hello, User!");
            Console.WriteLine("What is your name? ");
            Console.Write(">>>> ");
            name = Console.ReadLine();
            Console.WriteLine();

            Console.WriteLine("Great! Now, what is your age?");
            Console.Write(">>>> ");
            age = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine();


            Console.WriteLine("Awesome! Now, what is your college course?");
            Console.Write(">>>> ");
            course = Console.ReadLine();
            Console.WriteLine();


            Console.WriteLine("Nice! So you are..");
            Console.WriteLine("{0}, and your age is {1}, and currently taking {2} as your college course.", name, age, course );



            Console.ReadLine();





        }
    }
}
