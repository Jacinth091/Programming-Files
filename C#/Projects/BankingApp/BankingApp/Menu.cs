using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;

namespace BankingApp
{
    internal class Menu
    {
        private ConsoleKeyInfo keyPressed;
        private string[] menuOpt;
        private string dispPrompt;
        private int selIndex;
            
        public Menu(string[] opt, string dispPromt)
        {
            menuOpt = opt;
            this.dispPrompt = dispPromt;
            selIndex = 0;
        }

        public void runMenu()
        {
            do
            {
                Clear();
                dispOpt();
                getKeyPressed();


            } while (keyPressed.Key != ConsoleKey.Enter);


        }

        public void dispOpt()
        {
            string selItem;
            string prefix;
            for (int i = 0; i < menuOpt.Length; i++)
            {

                selItem = menuOpt[i];
                if (i == selIndex)
                {
                    BackgroundColor = ConsoleColor.White;
                    ForegroundColor = ConsoleColor.Black;
                    prefix = "-->";
                }
                else
                {
                    BackgroundColor = ConsoleColor.Black;
                    ForegroundColor = ConsoleColor.White;
                    prefix = "   ";

                }
                WriteLine($"{prefix} << {selItem} >>");
                ResetColor();

            }
        }
        public void getKeyPressed()
        {
            keyPressed = ReadKey(true);

            if (keyPressed.Key == ConsoleKey.UpArrow)
            {
                selIndex--;
                if (selIndex < 0)
                {
                    selIndex = menuOpt.Length - 1;
                }
            }
            else if (keyPressed.Key == ConsoleKey.DownArrow) { 
                
                selIndex++;
                if (selIndex == menuOpt.Length)
                {
                    selIndex = 0;
                }
            
            }


        }



    }
}
