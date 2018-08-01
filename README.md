# Сборка и запуск

Необходимо иметь установленный docker и maven.

#### С помощью bash скрипта

`sudo chmod +x buildAndRun.sh`

`./buildAndRun.sh`

#### С помощью maven и docker

`mvn clean install`

`docker build -t sdektest docker/.`

`docker run -p 80:8080 sdektest`

Далее можно делать запросы на 80 порт localhost.

Для удобства была использована embedded mysql.