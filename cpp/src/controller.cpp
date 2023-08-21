#include "controller.h"
#include <iostream>

Solution::Solution() : _start(Point()), _end(Point()), _startDirection(Direction()) {}

Point Solution::getStart() const {
    return _start;
}

Point Solution::getEnd() const {
    return _end;
}

Direction Solution::getStartDirection() const {
    return _startDirection;
}

void Solution::makeStartPoint(int pointX, int pointY) {
    _start.setX(pointX);
    _start.setY(pointY);
}

void Solution::makeEndPoint(int pointX, int pointY) {
    _end.setX(pointX);
    _end.setY(pointY);
}

void Solution::makeStartDirection(const std::string& direct) {
    _startDirection.setDirection(direct);
}

void Solution::calculatePower() {
    const int STEP_POINT = 10;
    const int TURN_POINT = 5;
    const int STARTING_POWER = 200;

    int dx = _end.getX() - _start.getX();
    int dy = _end.getY() - _start.getY();
    int absDist = std::abs(dx) + std::abs(dy);

    int turnDist = _startDirection.calcTurns(dx, dy);

    int distance = STARTING_POWER - (absDist * STEP_POINT + turnDist * TURN_POINT);

    std::cout << "POWER " << distance << std::endl;
}

