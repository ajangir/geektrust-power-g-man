#ifndef CONTROLLER_H
#define CONTROLLER_H

#include "Point.h"
#include "Direction.h"

class Solution {
private:
    Point _start;
    Point _end;
    Direction _startDirection;

public:
    Solution();

    Point getStart() const;
    Point getEnd() const;
    Direction getStartDirection() const;

    void makeStartPoint(int pointX, int pointY);
    void makeEndPoint(int pointX, int pointY);
    void makeStartDirection(const std::string& direct);

    void calculatePower();
};

#endif // CONTROLLER_H
