@echo off
rmdir /S /Q  ..\tmp-build 
mkdir ..\tmp-build
REM del /S /Q ..\tmp-build\*.class >nul
dir /B /S /O:N ..\src\*.java > c.lst
dir /B /S /O:N ..\build\generated-sources\antlr-output\*.java >> c.lst
javac -cp ..\src;..\lib\antlr-3.5.2-complete.jar;..\lib\h2-1.3.176;..\lib\eclipselink\eclipselink.jar;..\lib\eclipselink\javax.persistence_2.1.0.v201304241213.jar;..\lib\eclipselink\org.eclipse.persistence.jpa.jpql_2.5.2.v20140319-9ad6abd.jar;..\lib\eclipselinkmodelgen\org.eclipse.persistence.jpa.modelgen_2.5.2.v20140319-9ad6abd.jar -d ..\tmp-build @c.lst %1 %2 %3
del c.lst