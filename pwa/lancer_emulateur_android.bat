set USER_NAME=Formation
set ANDROID_SDK_DIR=C:\Users\%USER_NAME%\AppData\Local\Android\Sdk
cd "%ANDROID_SDK_DIR%\emulator"

REM emulator -list-avds 
REM pour lister les emulateurs android existants

SET EMULATOR_NAME=Nexus_5X_API_24
emulator -avd %EMULATOR_NAME%
pause