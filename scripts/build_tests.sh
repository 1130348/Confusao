#!/bin/sh
# javac -cp ../src-tests:../dist/csheets.jar:../lib/antlr-3.5.2-complete.jar:../lib/junit-4.10.jar ../src-tests/csheets/ext/comments/*.java ../src-tests/csheets/core/*.java 
if [ -e ../tmp-build-tests ]   &&  [ -f ../tmp-build-tests ]
then
rm ../tmp-build
fi

if [ ! -d ../tmp-build-tests ]
then
mkdir ../tmp-build-tests
fi

find ../src-tests -name "*.java" | xargs javac -cp ../src-tests:../dist/csheets.jar:`find ../lib -iname \*.jar | tr "\n" ":"` -d ../tmp-build-tests
