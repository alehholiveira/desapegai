# Stage 1: Build
FROM maven:3.8.4-openjdk-17 as builder

WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Stage 2: Run
FROM openjdk:17-jdk-slim

WORKDIR /app
COPY --from=builder /app/target/desapegai-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]