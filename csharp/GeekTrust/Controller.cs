using System;
using System.Collections.Generic;
namespace PowerGMan
{
    class Controller
    {
        public static void RunController(string[] inText)
        {
            Solution solver = new Solution();

            foreach (string line in inText)
            {
                string[] tokens = line.Split();

                if (tokens.Length == 0)
                    continue;

                if (tokens[0] == "SOURCE")
                {
                    solver.MakeStartPoint(int.Parse(tokens[1]), int.Parse(tokens[2]));
                    solver.MakeStartDirection(tokens[3]);
                }
                else if (tokens[0] == "DESTINATION")
                {
                    solver.MakeEndPoint(int.Parse(tokens[1]), int.Parse(tokens[2]));
                }
                else if (tokens[0] == "PRINT_POWER")
                {
                    solver.CalculatePower();
                }
                else
                {
                    throw new ArgumentException("Invalid token: " + tokens[0]);
                }
            }
        }
    }
}