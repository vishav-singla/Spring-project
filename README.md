# User CRUD Application

This is a User CRUD application built with Spring Boot and Java.

## Prerequisites

- Java 8 or higher
- Maven

## Running the Application

1. Clone the repository: `git clone https://github.com/vishav-singla/Spring-project.git`
2. Navigate into the directory: `cd Spring-project`
3. Build the project: `mvn clean install`
4. Run the application: `mvn spring-boot:run`

The application will start running at `http://localhost:8080`.

## API Endpoints

Here are some example cURL commands for the API endpoints:

### Register a User

```bash
curl -X POST -H "Content-Type: application/json" -d '{
    "username": "testUser",
    "email":"test@user.com",
    "password": "testPassword"
}' "http://localhost:8080/api/user/register"
```

### Fetch a User by Username

```bash
curl -X GET "http://localhost:8080/api/user?username=testUser"
```