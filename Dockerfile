#FROM jelastic/maven:3.9.5-openjdk-21  AS build
FROM maven:3.8.7  AS build
WORKDIR /app
COPY . .
RUN mvn -B clean package -DskipTests
FROM openjdk:21
COPY --from=build /target/E*jar ventEaze.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "EventEaze.jar"]

