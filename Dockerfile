# Step 1: Build stage (optional, if you want to build inside Docker)
# FROM maven:3.9.6-eclipse-temurin-17 AS builder
# WORKDIR /app
# COPY . .
# RUN mvn clean package -DskipTests

# Step 2: Runtime stage
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the Spring Boot JAR from your local build (or from the builder stage)
COPY target/*.jar app.jar

# Expose the app port (optional, for documentation)
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
