using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;

namespace KeyboardMenuDemo
{
    internal class Program
    {


        static void Main(string[] args)
        {
            GameCont game = new GameCont();

            game.Start();



            WriteLine("Press any key to exit...");
            ReadKey(true);


        }
    }
}
