#!/bin/sh
if [ -e ../tmp-build ]   &&  [ -f ../tmp-build ]
then  
	rm ../tmp-build 
fi 

if [ ! -d ../tmp-build ]   
then 
	mkdir ../tmp-build 
fi 
find ../src ../build/generated-sources/antlr-output -name "*.java" | xargs javac -cp ../src:`find ../lib -iname \*.jar | tr "\n" ":"` -d ../tmp-build 