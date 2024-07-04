# Recipe Management API

This is a Spring Boot application that provides a RESTful API for managing recipes.

## Requirements

- Java 11
- Maven
- PostgreSQL

## Setup

1. Clone the repository
2. Create a PostgreSQL database named `recipe_management`
3. Update `src/main/resources/application.properties` with your database credentials
4. Run `mvn clean install` to build the project
5. Run `mvn spring-boot:run` to start the application

The application will start on `http://localhost:8080`

## API Documentation

Once the application is running, you can access the Swagger UI at:

`http://localhost:8080/swagger-ui/`

## Authentication

This API uses JWT for authentication. To get a token, send a POST request to `/auth/signin` with username and password in the request body. Use the returned token in the Authorization header for subsequent requests.

## Running Tests

Run `mvn test` to execute the unit tests.

## Deployment

To deploy the application:

1. Build the project: `mvn clean package`
2. The resulting JAR file will be in the `target` directory
3. Run the JAR file: `java -jar target/recipe-management-1.0-SNAPSHOT.jar`

For deployment to a production environment, consider using a process manager like systemd or a container orchestration platform like Kubernetes.