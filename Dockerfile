FROM jelastic/maven:3.9.5-openjdk-21  AS build
FROM maven:3.8.7  AS build
COPY . .
ARG MAVEN_COMMAND="mvn -B clean package -DskipTests"
RUN mvn -f EventEaze/pom.xml clean package -Dmaven.test.skip=true

FROM openjdk:17-jdk-slim
COPY --from=build /target/*.jar EventEaze.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "EventEaze.jar"]

