#ifndef DIRECTION_H
#define DIRECTION_H

#include <map>
#include <string>
#include <vector>

class Direction {
private:
    const std::map<std::string, int> DB = {{"N", 0}, {"E", 1}, {"S", 2}, {"W", 3}};
    static const int NONE = -1;
    int _direction = NONE;

public:
    Direction();

    int getDirection() const;
    void setDirection(const std::string& value);
    void setDirection(int value);

    std::vector<int> getTurns(int dx, int dy) const;
    int turnsTaken(const std::vector<int>& changes) const;
    int calcTurns(int dx, int dy) const;
};

#endif // DIRECTION_H
