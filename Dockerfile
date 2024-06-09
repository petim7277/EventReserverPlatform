#FROM ubuntu:latest
#LABEL authors="Dell"
FROM maven:3.9.5-openjdk-21  AS build
COPY. .
RUN mvn clean package -DdskipTests
FROM openjdk:21-jdk
COPY --from=build /target/EventEaze-0.0.1-SNAPSHOT.jar EventEaze.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "EventEaze.jar"]