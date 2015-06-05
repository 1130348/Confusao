@echo off

echo Compiling...
call build

echo Copying temporary files...
call xcopy ..\src-resources ..\tmp-build /S /Q /Y > nul

echo Creating archive...
rmdir /S /Q  ..\dist 
mkdir ..\dist

call jar cfm ../dist/csheets.jar makejar.mf -C ../tmp-build/ .
call jar cvmf makejar.mf ../dist/csheets.jar -C ../src/ META-INF/persistence.xml



echo Copiar as dependencias
call copy /Y ..\lib\antlr-3.5.2-complete.jar ..\dist 
call copy /Y ..\lib\h2-1.3.176.jar ..\dist 
call copy /Y ..\lib\eclipselink\*.jar ..\dist 
call copy /Y ..\lib\eclipselinkmodelgen\*.jar ..\dist 

REM echo Removing temporary files...
REM call rmdir jar /Q /S
