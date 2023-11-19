# Use a base image with Java 17
FROM openjdk:17-jdk

# Set the working directory in the Docker container
WORKDIR /app

# Copy the Gradle executable to the Docker image
COPY gradlew .
COPY gradle gradle

# Copy the Gradle build file
COPY build.gradle .
COPY settings.gradle .

# Copy the src directory
COPY src src

# Grant execution rights on the gradlew
RUN chmod +x ./gradlew

# Download and cache dependencies
RUN ./gradlew --version
RUN ./gradlew dependencies || return 0

# Build the application
RUN ./gradlew build -x test

# Run the application
CMD ["./gradlew", "bootRun"]
