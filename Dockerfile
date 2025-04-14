# ✅ Use a stable Java version — OpenJDK 17 is the LTS (recommended for production)
FROM openjdk:17

# Set working directory inside the container
WORKDIR /app

# Copy the compiled Java application JAR file into the container
COPY ./target/crud.jar /app

# Expose the port the Spring Boot application will run on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "crud.jar"]