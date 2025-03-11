FOR /F "tokens=5 delims= " %%P IN ('netstat -a -n -o ^| findstr :4444') DO TaskKill.exe /PID %%P /F

Taskkill /IM geckodriver.exe /F

Taskkill /IM chromedriver.exe /F

Taskkill /IM IEDriverServer.exe /F