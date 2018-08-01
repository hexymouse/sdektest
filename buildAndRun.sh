mvn clean install
docker build -t sdektest .
docker run -p 80:8080 sdektest
