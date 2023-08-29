@echo off

REM Verificar si no existe el directorio build y crearlo
if not exist build mkdir build
if not exist build\Buscaminas mkdir build\Buscaminas

REM Crear archivo MANIFEST.MF si no existe
if not exist build\MANIFEST.MF (
    echo Manifest-Version: 1.0>build\MANIFEST.MF
    echo Main-Class: App>>build\MANIFEST.MF
)

REM Verificar si no existe el directorio build o el archivo MANIFEST.MF, y mostrar error si falta
if not exist build\ goto error
if not exist build\MANIFEST.MF goto error

REM Compilar archivos fuente
javac -d bin -sourcepath src src/*.java

REM Crear archivo JAR con MANIFEST.MF y archivos compilados
jar cvfm build\Buscaminas\Buscaminas.jar build\MANIFEST.MF -C bin .

REM Ejecutar pyinstaller para generar archivo ejecutable
pyinstaller --onefile --noconsole .\Run\Run.py

REM Copiar archivos y carpetas necesarios al directorio Buscaminas
xcopy /E /I /Y JRE\* build\Buscaminas\
xcopy /E /I /Y res build\Buscaminas\res
xcopy /E /I /Y ico\* build\Buscaminas\
xcopy /E /I /Y dist\* build\Buscaminas\

echo Compilacion completada
pause
exit

:error
echo Error
pause
exit