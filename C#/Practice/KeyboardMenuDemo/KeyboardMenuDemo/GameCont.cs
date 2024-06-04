using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;

namespace KeyboardMenuDemo
{
    internal class GameCont
    {
        private string[] menuOpt = { "Start", "Credits", "Exit" };
        //private string Title;

        Menu mainMenu;

        public void Start()
        {
            Title = "Tic Tac Toe!";
            runMenu();
        }


        public void runMenu()
        {
            int selectedIndex;
            string prompt = @"


████████╗██╗ ██████╗    ████████╗ █████╗  ██████╗    ████████╗ ██████╗ ███████╗
╚══██╔══╝██║██╔════╝    ╚══██╔══╝██╔══██╗██╔════╝    ╚══██╔══╝██╔═══██╗██╔════╝
   ██║   ██║██║            ██║   ███████║██║            ██║   ██║   ██║█████╗  
   ██║   ██║██║            ██║   ██╔══██║██║            ██║   ██║   ██║██╔══╝  
   ██║   ██║╚██████╗       ██║   ██║  ██║╚██████╗       ██║   ╚██████╔╝███████╗
   ╚═╝   ╚═╝ ╚═════╝       ╚═╝   ╚═╝  ╚═╝ ╚═════╝       ╚═╝    ╚═════╝ ╚══════╝
                                                                               

Welcome to Tic Tac Toe!!, select to any of the options!
(Use Up and Down Arrow Keys to Navigate, press ENTER to select.)";
     
            mainMenu = new Menu(menuOpt, prompt);

            selectedIndex = mainMenu.Run();
            //WriteLine($"You have selected {menuOpt[selectedIndex]}.");

            switch (selectedIndex) {
                case 0:

                    RunGame();
                    break;

                case 1:
                    GameCredits();
                    break;
                case 2:
                    ExitGame();
                    break;

            }

        }

 

        private void ExitGame()
        {
            Clear();
            WriteLine("Thank You For Playing!");
            WriteLine("See you next time!!");
            
            WriteLine("\r\n   _____                 _ _                \r\n  / ____|               | | |               \r\n | |  __  ___   ___   __| | |__  _   _  ___ \r\n | | |_ |/ _ \\ / _ \\ / _` | '_ \\| | | |/ _ \\\r\n | |__| | (_) | (_) | (_| | |_) | |_| |  __/\r\n  \\_____|\\___/ \\___/ \\__,_|_.__/ \\__, |\\___|\r\n                                  __/ |     \r\n                                 |___/      \r\n");

            WriteLine("Press any key to exit...");
            ReadKey(true);
            Environment.Exit(0);

            
        }
        private void GameCredits()
        {
            Clear();
            WriteLine("This Program is Made by Me!!");
            WriteLine("A Bachelor Of Science in Information Technology student at University of Cebu - Main");
            WriteLine("I am Jacinth an optimistic and wanna be game developer/software engineer");
            WriteLine("The Title font is by https://patorjk.com/");
            WriteLine("The game is still shit, but I'm currently improving. :)");
            WriteLine("So, Thanks for checking this out!!\n");

            WriteLine("Press any key to go back to Main Menu...");
            ReadKey(true);
            runMenu();


        }
        private void RunGame()
        {
            Clear();
            WriteLine("HEHE Game BRRT BRTT");
        }
    }
}
