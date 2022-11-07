FROM openjdk:8
EXPOSE 8089
ADD target/tpAchatProject-0.0.1-SNAPSHOT.jar tpAchatProject-0.0.1-SNAPSHOT-exec.jar
ENTRYPOINT ["java", "-jar", "/tpAchatProject-1.0.jar"]