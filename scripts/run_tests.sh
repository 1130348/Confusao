#!/bin/sh
java -cp ../tmp-build-tests:../dist/csheets.jar:`find ../lib -iname \*.jar | tr "\n" ":"` org.junit.runner.JUnitCore csheets.core.WorkbookTest csheets.core.SpreadsheetTest csheets.ext.comments.CommentableCellTest 

