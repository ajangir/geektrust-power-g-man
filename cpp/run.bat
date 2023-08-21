@echo off
g++ main.cpp src/direction.cpp src/controller.cpp -o geektrust 
:: -lboost_filesystem -lboost_system

geektrust sample/in1.txt
geektrust sample/in2.txt
geektrust sample/in3.txt