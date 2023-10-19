@echo off

dotnet build -o bin
bin\geektrust.exe sample\in1.txt
bin\geektrust.exe sample\in2.txt
bin\geektrust.exe sample\in3.txt