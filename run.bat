@echo off
javac -cp src/core.jar -d bin/ @sources

cd bin
java -cp ".;./core.jar" BasicInteraction #This must be run from bin folder
cd ..