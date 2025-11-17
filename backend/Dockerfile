# ---------- Build Stage ----------
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml and download dependencies first (faster builds)
COPY backend/pom.xml .
RUN mvn dependency:go-offline -B

# Copy the rest of the project and build
COPY backend/. .
RUN mvn clean package -DskipTests

# ---------- Run Stage ----------
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy built jar
COPY --from=build /app/target/*.jar app.jar

# Expose port (Render will override this)
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
