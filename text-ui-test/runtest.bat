@ECHO OFF

REM create bin directory if it doesn't exist
if not exist ..\bin mkdir ..\bin

REM delete output from previous run
del ACTUAL.TXT

REM compile the code into the bin folder
REM javac  -cp ..\src -Xlint:none -d ..\bin ..\src\main\java\Duke.java
rem javac  -cp ..\src -Xlint:none -d ..\bin -sourcepath D:\repo\TIC-4001\individual-project\ip\src\main\java Duke.java
javac  -cp ..\src\main\java -Xlint:none -d ..\bin ..\src\main\java\Duke.java
rem javac -Xlint:none -d ..\bin -sourcepath ..\src\main\java ..\src\main\java\Duke.java

IF ERRORLEVEL 1 (
    echo ********** BUILD FAILURE **********
    exit /b 1
)
REM no error here, errorlevel == 0

REM run the program, feed commands from input.txt file and redirect the output to the ACTUAL.TXT
java -classpath ..\bin Duke < input.txt > ACTUAL.TXT

REM compare the output to the expected output
FC ACTUAL.TXT EXPECTED.TXT

pause
