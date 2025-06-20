FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY /contactlist_spring/pom.xml
COPY /contactlist_spring/src ./src
RUN mvn clean package -DskipTests
FROM Openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=build /app/target/contactlist-0.0.1-SNAPSHOT.jar contactlist.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "contactlist.jar"]