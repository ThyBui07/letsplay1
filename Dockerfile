# Use a Gradle image with a compatible Java version for building the application
FROM gradle:8.3-jdk17 AS builder
WORKDIR /app

# Copy the project files and set executable permissions
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew

# Download and cache dependencies
RUN ./gradlew dependencies

# Build the application without running tests
RUN ./gradlew build -x test

# For the runtime stage, use an OpenJDK image compatible with your application
FROM openjdk:17-jdk
WORKDIR /app

# Copy the built application from the builder stage
COPY --from=builder /app/build/libs/*-SNAPSHOT.jar ./app.jar

EXPOSE 8080

# Define the command to run the application
CMD java -jar /app/*.jar
