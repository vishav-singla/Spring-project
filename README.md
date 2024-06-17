# User CRUD Application

This is a User CRUD application built with Spring Boot and Java.

## Prerequisites

- Java 8 or higher
- Maven
- MySQL

## Setup MySQL

1. Install MySQL if you haven't already.
2. Create a new database for the application.
3. Note down the database name, MySQL username, and password.

## Configure application.properties

Update the `application.properties` file to include the necessary configuration for connecting to your MySQL database:

```ini
spring.application.name=UserCrud
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name?useSSL=false&serverTimezone=UTC
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.mvc.pathmatch.matching-strategy: ant_path_matcher
```

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