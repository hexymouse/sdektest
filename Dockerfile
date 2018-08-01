FROM java:8

COPY target/. /opt/sdektest
RUN apt update
RUN apt install -y libaio1

WORKDIR /opt/sdektest

ENTRYPOINT exec java $JAVA_OPTS -jar sdek-test-1.0-SNAPSHOT.jar