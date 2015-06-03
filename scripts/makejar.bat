@echo off

echo Compiling...
call build

echo Copying temporary files...
call xcopy ..\src-resources ..\tmp-build /S /Q /Y > nul

echo Creating archive...
rmdir /S /Q  ..\dist 
mkdir ..\dist
call jar cfm ../dist/csheets.jar makejar.mf -C ../tmp-build/ .

echo Copiar as dependencias
call copy /Y ..\lib\antlr-3.5.2-complete.jar ..\dist 

REM echo Removing temporary files...
REM call rmdir jar /Q /S
