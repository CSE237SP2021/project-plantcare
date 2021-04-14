#!/bin/bash
find -name "*.java" -not -path "./src/tests/*" > sources.txt
javac @sources.txt
java -cp src main.PlantCare
