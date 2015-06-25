@echo off
rmdir /S /Q  ..\tmp-build 
mkdir ..\tmp-build
mkdir ..\tmp-build\META-INF
REM del /S /Q ..\tmp-build\*.class >nul
dir /B /S /O:N ..\src\*.java > c.lst
dir /B /S /O:N ..\build\generated-sources\antlr-output\*.java >> c.lst
call copy /Y ..\src\META-INF\* ..\tmp-build\META-INF
javac -processor org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor -Aeclipselink.persistencexml=..\src\META-INF\persistence.xml -cp ..\src;..\lib\antlr-3.5.2-complete.jar;..\lib\javax.mail.jar;..\lib\h2-1.3.176.jar;..\lib\eclipselink\eclipselink.jar;..\lib\eclipselink\javax.persistence_2.1.0.v201304241213.jar;..\lib\eclipselink\org.eclipse.persistence.jpa.jpql_2.5.2.v20140319-9ad6abd.jar;..\lib\eclipselinkmodelgen\org.eclipse.persistence.jpa.modelgen_2.5.2.v20140319-9ad6abd.jar;..\lib\bsh-2.0b4.jar -d ..\tmp-build @c.lst %1 %2 %3
del c.lst