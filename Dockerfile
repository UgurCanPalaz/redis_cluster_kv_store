FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/kvstore-1.0-SNAPSHOT-jar-with-dependencies.jar kvstore.jar
CMD ["java", "-jar", "kvstore.jar"]
