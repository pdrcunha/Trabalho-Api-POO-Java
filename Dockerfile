# Use the official OpenJDK 21 image as the base image
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven Wrapper executable and wrapper files
COPY .mvn/ .mvn/
COPY mvnw .
COPY pom.xml .

# Copy the source code
COPY src ./src

# Make the Maven Wrapper executable
RUN chmod +x mvnw

# Install dependencies and build the application
RUN ./mvnw clean install -DskipTests

# Expose the port the application will run on
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["./mvnw", "spring-boot:run"]
