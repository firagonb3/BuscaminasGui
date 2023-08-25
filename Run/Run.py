import subprocess

if __name__ == "__main__":
    command_to_run = "start bin\javaw -jar Buscaminas.jar"
    DETACHED_PROCESS = 0x00000008
    CREATE_NO_WINDOW = 0x08000000

    subprocess.Popen(
        command_to_run,
        creationflags=DETACHED_PROCESS | CREATE_NO_WINDOW,
        shell=True
    )