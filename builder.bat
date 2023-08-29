@echo off
setlocal

REM Crear directorios de log y verificar si no existe el directorio "build" y crearlo
if not exist build (
    mkdir build
    call :WriteLog "Se creó el directorio build."
)
if not exist build\Buscaminas (
    mkdir build\Buscaminas
    call :WriteLog "Se creó el directorio build\Buscaminas."
)

REM Crear archivo MANIFEST.MF si no existe
if not exist build\MANIFEST.MF (
    (
        echo Manifest-Version: 1.0
        echo Main-Class: App
    ) > build\MANIFEST.MF
    call :WriteLog "Se creó el archivo MANIFEST.MF."
)

REM Verificar si no existe el directorio "build" o el archivo MANIFEST.MF, y mostrar error si falta
if not exist build\ (
    call :WriteLog "Falta el directorio build. Deteniendo el script."
    goto :error
)
if not exist build\MANIFEST.MF (
    call :WriteLog "Falta el archivo MANIFEST.MF. Deteniendo el script."
    goto :error
)

REM Compilar archivos fuente
javac -d bin -sourcepath src src/*.java >nul
if %errorlevel% neq 0 (
    call :WriteLog "Error durante la compilación de archivos fuente."
    goto :error
)
call :WriteLog "Archivos fuente compilados exitosamente."

REM Crear archivo JAR con MANIFEST.MF y archivos compilados
jar cvfm build\Buscaminas\Buscaminas.jar build\MANIFEST.MF -C bin . >nul
if %errorlevel% neq 0 (
    call :WriteLog "Error al crear el archivo JAR."
    goto :error
)
call :WriteLog "Archivo JAR creado exitosamente."

REM Ejecutar pyinstaller para generar archivo ejecutable
pyinstaller --onefile --noconsole .\Run\Run.py >nul
if %errorlevel% neq 0 (
    call :WriteLog "Error durante la generación del archivo ejecutable."
    goto :error
)
call :WriteLog "Archivo ejecutable generado exitosamente."

REM Copiar archivos y carpetas necesarios al directorio Buscaminas
xcopy /E /I /Y JRE\* build\Buscaminas\ >nul
xcopy /E /I /Y res build\Buscaminas\res >nul
xcopy /E /I /Y ico\* build\Buscaminas\ >nul
xcopy /E /I /Y dist\* build\Buscaminas\ >nul
call :WriteLog "Archivos y carpetas copiados exitosamente."

call :WriteLog "Compilación completada."
pause
exit

:error
call :WriteLog "¡Oops! Algo salió mal."
pause
exit

REM Función para escribir en el archivo de log
:WriteLog
echo %1
echo [%date% %time%] %1 >> build\log.txt
exit /b