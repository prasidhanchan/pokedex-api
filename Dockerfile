FROM gradle:8.7-jdk21 AS build
WORKDIR /home/gradle/src
COPY . .
RUN ./gradlew bootJar --no-daemon

FROM openjdk:21-jdk-slim
COPY --from=build /home/gradle/src/build/libs/pokedex-0.0.1.jar pokedex.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "pokedex.jar"]