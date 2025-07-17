@echo off
echo Cleaning previous class files...
del /Q *.class

echo Compiling Java files...
javac --module-path "C:\Users\hp\Downloads\openjfx-24.0.1_windows-x64_bin-sdk\javafx-sdk-24.0.1\lib" --add-modules javafx.controls ContactTracingApp_Animated.java Graph.java Encryptor.java IoTSimulator.java

IF ERRORLEVEL 1 (
    echo ❌ Compilation failed!
    pause
    exit /b
)

echo Launching animated GUI...
java --module-path "C:\Users\hp\Downloads\openjfx-24.0.1_windows-x64_bin-sdk\javafx-sdk-24.0.1\lib" --add-modules javafx.controls ContactTracingApp_Animated

pause
