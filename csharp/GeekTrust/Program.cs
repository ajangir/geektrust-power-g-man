using System;
using System.Collections.Generic;
using System.IO;

namespace PowerGMan
{
    class Program
    {
        static void Main(string[] args)
        {
            if (args.Length != 1)
            {
                Console.WriteLine("File path not entered");
                return;
            }
            try
            {
                string[] inputData = File.ReadAllLines(args[0]);

                Controller.RunController(inputData);
            }
            catch(Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }
    }
}
