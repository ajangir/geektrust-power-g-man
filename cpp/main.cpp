#include <iostream>
#include <sstream>
#include <fstream>

#include "src/controller.h"

void runController(const std::vector<std::string>& inText) {
    Solution solver;

    for (const std::string& line : inText) {
        // Split line into tokens
        std::istringstream iss(line);
        std::vector<std::string> tokens;
        std::string token;
        while (iss >> token) {
            tokens.push_back(token);
        }

        if (tokens.size() == 0) {
            continue;
        }

        if (tokens[0] == "SOURCE") {
            solver.makeStartPoint(std::stoi(tokens[1]), std::stoi(tokens[2]));
            solver.makeStartDirection(tokens[3]);
        } else if (tokens[0] == "DESTINATION") {
            solver.makeEndPoint(std::stoi(tokens[1]), std::stoi(tokens[2]));
        } else if (tokens[0] == "PRINT_POWER") {
            solver.calculatePower();
        } else {
            throw std::invalid_argument("Invalid token: " + tokens[0]);
        }
    }
}

int main(int argc, char* argv[]) {
    
    if (argc != 2) {
        std::cerr << "File path not entered" << std::endl;
        return 1;
    }

    std::ifstream fileName(argv[1]);
    if (!fileName.is_open()) {
        std::cerr << "Error opening file" << std::endl;
        return 1;
    }

    std::vector<std::string> lines;
    std::string line;
    while (std::getline(fileName, line)) {
        lines.push_back(line);
    }

    fileName.close();

    try {
        runController(lines);
    } 
    catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
        return 1;
    }
    return 0;
}