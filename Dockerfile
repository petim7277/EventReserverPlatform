#FROM jelastic/maven:3.9.5-openjdk-21  AS build
FROM maven:3.8.7  AS build
COPY . .
RUN mvn -B clean package -DskipTests
FROM openjdk:21
COPY --from=build /target/EventEaze-0.0.1-SNAPSHOT.jar EventEaze.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "EventEaze.jar"]

#FROM maven:3.8.6 as build
 #COPY . .
 #RUN mvn -B clean package -DskipTests
 #
 #FROM openjdk:21-jdk
 #COPY --from=build ./target/*.jar CampusNestProject.jar
 #EXPOSE 8080
 #ENTRYPOINT ["java", "-jar" , "CampusNestProject.jar"]