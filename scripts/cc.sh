#!/bin/sh
java -cp ../lib/antlr-3.5.2-complete.jar org.antlr.Tool -verbose -fo ../build/generated-sources/antlr-output/csheets/core/formula/compiler ../grammar/csheets/core/formula/compiler/Formula.g
# java -cp ../lib/antlr-3.5.2-complete.jar antlr.Tool -o ../src/csheets/ext/assertion ../src/csheets/ext/assertion/AssertionParser.g
