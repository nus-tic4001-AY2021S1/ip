@ECHO OFF

REM create bin directory if it doesn't exist
if not exist ..\bin mkdir ..\bin

REM delete output from previous run
if not exist ..\text-ui-test\ACTUAL.TXT echo. >NUL 2>ACTUAL.TXT else del ACTUAL.TXT
echo. >NUL 2>..\text-ui-testACTUAL.TXT

REM compile the code into the bin folder
javac  -cp ..\src\Duke\* -Xlint:none -d ..\bin ..\src\Duke\main\Duke.java
IF ERRORLEVEL 1 (
    echo ********** BUILD FAILURE **********
    exit /b 1
)
REM no error here, errorlevel == 0

REM run the program, feed commands from input.txt file and redirect the output to the ACTUAL.TXT
java -classpath ..\bin Duke.main.Duke < input.txt > ACTUAL.TXT

REM compare the output to the expected output
FC ACTUAL.TXT EXPECTED.TXT
