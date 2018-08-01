mvn clean install
docker build -t sdektest docker/.
docker run -p 80:8080 sdektest
