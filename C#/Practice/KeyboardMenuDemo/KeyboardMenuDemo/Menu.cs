using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;

namespace KeyboardMenuDemo
{
    internal class Menu
    {
        private ConsoleKeyInfo cki;
        private string[] options;
        private string prompt;
        private int selOpt;

        public Menu()
        {

        }
        public Menu(string[] options, string prompt)
        {
            this.options = options;
            this.prompt = prompt;
            selOpt = 0;
        }

        private void displayMenu()
        {
            WriteLine(prompt);
            WriteLine("\n");

            for (int i =0; i < options.Length; i++)
            {
                string selectedOpt = options[i];
                string prefix;
                if(i == selOpt)
                {
                    BackgroundColor = ConsoleColor.White;
                    ForegroundColor = ConsoleColor.Black;
                    prefix = "-->";
                }
                else
                {
                    prefix = "   ";
                    BackgroundColor = ConsoleColor.Black;
                    ForegroundColor = ConsoleColor.White;


                }
                WriteLine($" {prefix} << {selectedOpt} >>");

                //getUserKeyIn();
                //Clear();
            }
            ResetColor();
            WriteLine();
        }

        public int Run()
        {
            do
            {
                Clear();
                displayMenu();

                getUserKeyIn();
          

            }   while (cki.Key != ConsoleKey.Enter);

            
    
            return selOpt;
        }

        public void getUserKeyIn()
        {
            //int selOpt = 0 ;
                ////Clear();

                //WriteLine($"Up SelOpt: {selOpt}");
                //WriteLine($"Up Selected Option: {options[selOpt]} \n");

                //WriteLine($"Down SelOpt: {selOpt}");
                //WriteLine($"Down Selected Option: {options[selOpt]} \n");


            cki = ReadKey();

            if (cki.Key == ConsoleKey.DownArrow)
            {
                selOpt++;
                if (selOpt == options.Length)
                {
                    selOpt = 0;
                }
                //WriteLine(selOpt);
                
            }
            else if (cki.Key == ConsoleKey.UpArrow)
            {
                selOpt--;
                if (selOpt < 0)
                {
                    selOpt = options.Length - 1;
                }
                //WriteLine(selOpt);
            }


            //return selInd;
        }

        /* public void test()
         {
             WriteLine("Hello Test!");



             do
             {
                 WriteLine("\nInput Keys to the console, press 'Escape' to exit!");

                 cki = ReadKey(true);
                 WriteLine("\nYou pressed the '{0}' key.", cki.Key);

                 if (cki.Key == ConsoleKey.Enter)
                 {
                     WriteLine("Input a Key, try again!");
                     continue;

                 }

                 if (cki.Key == ConsoleKey.UpArrow)
                 {
                     WriteLine("Up");
                 }
                 if (cki.Key == ConsoleKey.DownArrow)
                 {
                     WriteLine("Down");
                 }
                 if (cki.Key == ConsoleKey.LeftArrow)
                 {
                     WriteLine("Left");
                 }
                 if (cki.Key == ConsoleKey.RightArrow)
                 {
                     WriteLine("Right");
                 }





             } while (cki.Key != ConsoleKey.Escape);




             WriteLine("press any key to exit...");
             ReadKey(true);
         }*/
    }
}
