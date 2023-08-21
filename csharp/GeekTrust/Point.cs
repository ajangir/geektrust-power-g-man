using System;
using System.Collections.Generic;

namespace PowerGMan
{
    class Point
    {
        public int X { get; set; }
        public int Y { get; set; }
    }

    class Direction
    {
        private Dictionary<string, int> _db = new Dictionary<string, int>
        {
            { "N", 0 }, { "E", 1 }, { "S", 2 }, { "W", 3 }
        };

        private int _direction = -1;

        public int DirectionValue
        {
            get { return _direction; }
            set
            {
                
                if (value >= 0 && value <= 3)
                    _direction = value;
                else
                    throw new ArgumentException("Invalid Direction int: " + value);
            }
        }
        public void setDirection(string value){
            if(_db.ContainsKey(value)){
                _direction = _db[value];
            }
            else{
                throw new ArgumentException("Invalid Direction string: " + value);
            }
        }
        public int CalcTurns(int dx, int dy)
        {
            List<int> turns = GetTurns(dx, dy);
            int turnsTaken0 = TurnsTaken(turns);
            turns.Reverse();
            int turnsTaken1 = TurnsTaken(turns);
            int ans = Math.Min(turnsTaken0, turnsTaken1);
            return ans;
        }

        private List<int> GetTurns(int dx, int dy)
        {
            List<int> toTurns = new List<int>();

            if (dx > 0)
                toTurns.Add(_db["E"]);
            else if (dx < 0)
                toTurns.Add(_db["W"]);

            if (dy > 0)
                toTurns.Add(_db["N"]);
            else if (dy < 0)
                toTurns.Add(_db["S"]);

            return toTurns;
        }

        private int TurnsTaken(List<int> changes)
        {
            int start = DirectionValue;
            int count = 0;
            int maxLen = _db.Count;

            foreach (int i in changes)
            {
                count += Math.Min((i - start + maxLen) % maxLen, (start - i + maxLen) % maxLen);
                start = i;
            }

            return count;
        }
    }
}
