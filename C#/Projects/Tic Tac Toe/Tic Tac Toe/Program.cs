using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tic_Tac_Toe
{
    internal class Program
    {
        static void Main(string[] args)
        {

            Console.WriteLine(">>>>>>>>>>>>>>>>>>>>>>> Tic-Tac-Toe <<<<<<<<<<<<<<<<<<<<<<<<<");

            const int GRID_SIZE = 3;

            int rowPos, colPos, time = 0;
            string[] tiles = { " X ", " O " };
            string plcHold = " - ";
            string[,] grid = new string[GRID_SIZE, GRID_SIZE];
            char exitChar = '\0';
            bool exitLoop = false;
            bool[,] isOccupied = new bool[GRID_SIZE, GRID_SIZE];

            grid = initGrid(GRID_SIZE);
            displayGrid(grid);

           
            do
            {
                do
                {
                    Console.WriteLine($"\nCurrent Loop: {time}");
                    Console.WriteLine();
                    rowPos = -1;
                    colPos = -1;


                    Console.WriteLine("Player One's Turn\n");
                    grid = player(grid, tiles[0], tiles[1], rowPos, colPos, plcHold);
                    displayGrid(grid);



                    if (checkForWinner(grid, tiles[0]))
                    {
                        Console.WriteLine("Player ONE WIN!!!");
                        break;
                    }
                    else if (checkForDraw(grid, tiles, plcHold))
                    {
                        Console.WriteLine("The Game is DRAW!!!");
                        break;


                    }



                    Console.WriteLine();

                    Console.WriteLine("Player Two's Turn\n");
                    grid = player(grid, tiles[1], tiles[0], rowPos, colPos, plcHold);
                    displayGrid(grid);

                    if (checkForWinner(grid, tiles[1]))
                    {
                        Console.WriteLine("Player TWO WIN!!!");
                        break;
                    }
                    else if (checkForDraw(grid, tiles, plcHold))
                    {
                        Console.WriteLine("The Game is DRAW!!!");
                        break;


                    }

                    Console.WriteLine();

                    time++;



                } while (true);
                Console.WriteLine();

                exitLoop = askForYOrN(exitChar);

            }while(exitLoop);

            Console.ReadLine();
        }

        static bool askForYOrN(char exitChar)
        {
            bool isYes = false;
            do
            {
                Console.Write("Try Again? (Y/N): ");
                while (!char.TryParse(Console.ReadLine().ToUpper(), out exitChar))
                {
                    Console.WriteLine("Input valid Input, try again!");
                }
                if (exitChar == 'Y')
                {
                    Console.WriteLine("Re-starting the game....");
                    isYes = true;
                }
                else if (exitChar == 'N')
                {
                    Console.WriteLine("Thank you for playing the game, see you next time!");
                    break;
                }
                else
                {
                    Console.WriteLine("Input Only Y or N, try again!");
                    continue;
                }

            } while (true);

            return isYes;
    
        }

        static bool checkForWinner(string[,] grid, string tileToCheck)
        {
            bool winnerCode  = false;

            if (checkStraight(grid, tileToCheck) || checkDiag(grid, tileToCheck))
            {
                winnerCode = true;
                
            }

            return winnerCode;
        }

        static bool checkForDraw(string[,] grid, string[] tiles, string plcHold)
        {
            int row = grid.GetLength(0);
            int col = grid.GetLength(1);

            for(int i =0; i < row; i++)
            {
                for(int j =0; j < col; j++)
                {
                    if (grid[i, j].Equals(plcHold))
                    {
                        return false;
                    }
                }
            }

            if(!checkForWinner(grid, tiles[0]) && !checkForWinner(grid, tiles[1]))
            {
                return true;
            }

            return false;
        }
        static bool checkStraight(string[,] grid, string tileToCheck)
        {
            bool straightMatch = false;

            for(int i =0; i < grid.GetLength(0); i++)
            {
                int rowMatch = 0;
                int colMatch = 0;
                for (int j = 0; j < grid.GetLength(1); j++)
                {
                    if (grid[i, j].Equals(tileToCheck))
                    {
                        rowMatch++;
                        if(rowMatch == 3)
                        {
                            //Console.WriteLine("Left To Right MATCH!");
                            return true;
                        }
                    }
                    else if (grid[j, i].Equals(tileToCheck))
                    {
                        colMatch++;
                        if(colMatch == 3)
                        {
                            //Console.WriteLine("Top To Bottom MATCH!");
                            return true;
                        }
                    }
                    else
                    {
                        rowMatch = 0;
                        colMatch = 0;
                    }
                }
            }
            return straightMatch;
        }

        static bool checkDiag(string[,] grid, string tileToCheck)
        {
            bool diagMatch = false;
            int row = grid.GetLength(0);

            int diag = 0;
            int secDiag = 0;
            for (int i =0; i < row; i++)
            {
                if (grid[i, i].Equals(tileToCheck))
                {
                    diag++;
                    if (diag == 3)
                    {
                        //Console.WriteLine("Diagonal MATCH!");
                        return true;
                    }

                }
                else if (grid[i, row - 1 - i].Equals(tileToCheck))
                {
                    secDiag++;
                    if(secDiag == 3)
                    {
                        //Console.WriteLine("Diagonal 2 MATCH!");
                        return true;
                    }
                }
                else
                {
                    secDiag = 0;
                    diag = 0;
                }


            }


            return diagMatch;
        }

        static string[,] player(string[,] grid, string tile,string tileToCheck ,int rowPos, int colPos, string plcHold)
        {
            string[,] input = grid;
            int GRID_SIZE = grid.GetLength(0);
            bool doneTurn = false;

            do
            {
                Console.Write("Input row: ");
                rowPos = validInput(GRID_SIZE);

                Console.Write("Input Col: ");
                colPos = validInput(GRID_SIZE);

                if (input[(rowPos - 1), (colPos - 1)].Equals(plcHold) && !input[(rowPos - 1), (colPos - 1)].Equals(tileToCheck))
                {
                    input[(rowPos - 1), (colPos - 1)] = tile;
                    //isOccupied[(rowPos - 1), (colPos - 1)] = true;
                    doneTurn = true;
                    Console.WriteLine();
                }
                else
                {
                    Console.WriteLine("The current location is occupied!, try again");
                }

            } while (!doneTurn);

            return input;
            
        }

        static int validInput(int gridSize)
        {
            int inpt;

            do
            {
                if (!int.TryParse(Console.ReadLine(), out inpt))
                {
                    Console.WriteLine("Input Valid Input, try again!");
                    Console.Write(">>>>>> ");

                }
                else if (inpt <= gridSize && inpt > 0)
                {
                    break;
                }
                else
                {
                    Console.WriteLine("Out Of Range, try again!");
                    Console.Write(">>>>>> ");
                }

            } while(true);

            return inpt;
        }
        static string[,] initGrid(int gridSize)
        {

            string[,] grid = new string[gridSize, gridSize ];

            for (int i = 0; i < grid.GetLength(0); i++)
            {
                for (int j = 0; j < grid.GetLength(1); j++)
                {
                    grid[i, j] = " - ";
                }
            }

            return grid;
        }
        static void displayGrid(string[,] grid)
        {
            Console.WriteLine("     1  |  2  |  3 ");
            Console.WriteLine("   ---------------- ");

            for (int i = 0; i < grid.GetLength(0); i++)
            {
                Console.Write($"{i + 1} | ");

                for (int j = 0; j < grid.GetLength(1); j++)
                {
                    Console.Write(grid[i, j]);
                    if (j < grid.GetLength(1) -1)
                    {
                        Console.Write(" | ");
                    }
                }
                Console.WriteLine();
                if (i < grid.GetLength(0) - 1)
                {
                    Console.WriteLine("    ----+-----+----");
                }

            }
        }
    }
}
