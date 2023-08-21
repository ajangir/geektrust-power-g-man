@echo off
call mvn install -DskipTests assembly:single -q
java -jar target\geektrust.jar sample\input1.txt
java -jar target\geektrust.jar sample\input2.txt
java -jar target\geektrust.jar sample\input3.txt
mvn clean test
mvn clean verify
mvn jacoco:report