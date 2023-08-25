@echo off

set input=src
set ouput=build
set main=Main.jar
set icon=ico\package-icon.ico
set defaultName=main

echo 1. MSI (recomendado)
echo 2. EXE

choice /M "Selecione una opcion" /C:12
if %errorlevel% == 1 (set type=msi)
if %errorlevel% == 2 (set type=app-image)

set /p name="Nombre del build: "

if %name%=="" (set name=%defaultName%)

if exist %input%\%main% (
 echo buildeando app...
 jpackage --type %type% --icon %icon% --input %input% --dest %ouput% --main-jar %main% --name %name% --verbose
 rem jpackage --type %type% --icon %icon% --input %input% --dest %ouput% --main-jar %main% --name %name% --verbose >> logs\log.txt
 start %ouput%
) else (echo No se encontro el %main%)

pause