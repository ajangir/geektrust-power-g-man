@echo off

dotnet build -o bin
dotnet bin/geektrust.dll sample\in1.txt
dotnet bin/geektrust.dll sample\in2.txt
dotnet bin/geektrust.dll sample\in3.txt