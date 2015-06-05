#!/bin/sh
java -cp ../dist/.:`find ../dist -iname \*.jar | tr "\n" ":"` csheets.CleanSheets
