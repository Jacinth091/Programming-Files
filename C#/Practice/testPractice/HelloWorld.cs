using System;

namespace HelloWorld
{
  class Hello
  {
    public static void getAndDisp()
    {
      Console.WriteLine("Please enter some text:");
      string userInput = Console.ReadLine();
      Console.WriteLine("You entered: " + userInput);
    }
  }
}