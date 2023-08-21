using System;
namespace PowerGMan
{
    class Solution
    {
        private Point _start = new Point();
        private Point _end = new Point();
        private Direction _startDirection = new Direction();

        public Point Start { get { return _start; } set{}}
        public Point End { get { return _end; } set{}}
        public Direction StartDirection { get { return _startDirection; } set{}}

        public void MakeStartPoint(int pointX, int pointY)
        {
            _start.X = pointX;
            _start.Y = pointY;
        }

        public void MakeEndPoint(int pointX, int pointY)
        {
            _end.X = pointX;
            _end.Y = pointY;
        }

        public void MakeStartDirection(string direct)
        {
            _startDirection.setDirection(direct);
        }

        public void CalculatePower()
        {
            const int StepPoint = 10;
            const int TurnPoint = 5;
            const int StartingPower = 200;

            int dx = _end.X - _start.X;
            int dy = _end.Y - _start.Y;
            
            int absDist = Math.Abs(dx) + Math.Abs(dy);

            int turnDist = _startDirection.CalcTurns(dx, dy);

            int distance = StartingPower - (absDist * StepPoint + turnDist * TurnPoint);

            Console.WriteLine("POWER " + distance);
        }
    }
}