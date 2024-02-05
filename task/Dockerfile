FROM maven:3.8.5-openjdk-17 AS build 
COPY . .
RUN mvn clean package -OskipTests

FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Task-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Task-0.0.1-SNAPSHOT.jar"]
