cmake_minimum_required(VERSION 3.10)

project(GeekTrust)

set(CMAKE_CXX_STANDARD 11)

# Add the source files to your project
add_executable(geektrust
    main.cpp
    src/controller.cpp
    src/direction.cpp
)

# Include headers from the src folder
target_include_directories(geektrust PRIVATE src)

# Uncomment the following line if you need to use C++11 features
# target_compile_features(geektrust PRIVATE cxx_std_11)
