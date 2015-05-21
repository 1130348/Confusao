#!/bin/sh
echo Compiling...
sh ./build.sh

if [ -e ../dist ]   &&  [ -f ../dist ]
then  
        rm ../dist 
fi 

if [ ! -d ../dist ]   
then 
        mkdir ../dist 
fi 



echo Copying resource files...
cp -R ../src-resources/ ../tmp-build 

echo Creating archive...
jar cmf makejar.mf ../dist/csheets.jar -C ../tmp-build/ .

echo Copiar as dependencias
cp ../lib/*.jar ../dist/

# echo Removing temporary files...
# rm -R jar