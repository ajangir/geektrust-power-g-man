@echo off
rmdir CMakeFiles
rm geektrust.exe CMakeCache.txt cmake_install.cmake

cmake -G"MinGW Makefiles" .
cmake --build .