# ---- Build Stage ----
FROM maven:3.9.9-eclipse-temurin-21 AS builder
WORKDIR /app

# Copy pom and fetch dependencies first (for caching)
COPY pom.xml .
RUN mvn -B dependency:go-offline

# Copy project source
COPY src ./src

# Package application
RUN mvn -B clean package

# ---- Runtime Stage ----
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copy the jar from the build stage
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
