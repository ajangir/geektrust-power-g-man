#include "direction.h"

Direction::Direction() : _direction(NONE) {}

int Direction::getDirection() const {
    return _direction;
}

void Direction::setDirection(const std::string& value) {
    if (DB.find(value) != DB.end()) {
        _direction = DB.at(value);
    } else {
        throw std::invalid_argument("Invalid Direction: " + value);
    }
}

void Direction::setDirection(int value) {
    if (value >= 0 && value <= 3) {
        _direction = value;
    } else {
        throw std::invalid_argument("Invalid Direction: " + std::to_string(value));
    }
}

std::vector<int> Direction::getTurns(int dx, int dy) const {
    std::vector<int> toTurns;

    if (dx > 0) {
        toTurns.push_back(DB.at("E"));
    } else if (dx < 0) {
        toTurns.push_back(DB.at("W"));
    }

    if (dy > 0) {
        toTurns.push_back(DB.at("N"));
    } else if (dy < 0) {
        toTurns.push_back(DB.at("S"));
    }

    return toTurns;
}

int Direction::turnsTaken(const std::vector<int>& changes) const {
    int start = _direction;
    int countr = 0;
    int MAX_LEN = DB.size();

    for (int i : changes) {
        countr += std::min((i - start + MAX_LEN) % MAX_LEN, (start - i + MAX_LEN) % MAX_LEN);
        start = i;
    }
    return countr;
}

int Direction::calcTurns(int dx, int dy) const {
    std::vector<int> turns = getTurns(dx, dy);
    int ans = std::min(turnsTaken(turns), turnsTaken(std::vector<int>(turns.rbegin(), turns.rend())));
    return ans;
}
