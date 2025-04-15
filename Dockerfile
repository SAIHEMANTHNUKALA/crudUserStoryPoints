# Use Amazon Corretto 17 from AWS Public ECR (avoids Docker Hub rate limits)
FROM public.ecr.aws/amazoncorretto/amazoncorretto:17

# Set working directory inside the container
WORKDIR /app

# Copy the compiled Java application JAR file into the container
COPY ./target/crud.jar /app

# Expose the port the Spring Boot application will run on
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "crud.jar"]