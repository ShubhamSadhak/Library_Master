# Library Management API

This project is a Spring Boot application for managing books in a library system. It exposes REST endpoints for creating, retrieving, updating, and deleting books, and stores data in a MySQL database using Spring Data JPA.

## Tech Stack

- Java 17
- Spring Boot 3.4.3
- Spring Web
- Spring Data JPA
- MySQL
- Maven
- Lombok

## Project Structure

```text
library-master/
├── library/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/springproj/library/
│   │   │   │   ├── controller/
│   │   │   │   ├── dto/
│   │   │   │   ├── enitity/
│   │   │   │   ├── repository/
│   │   │   │   ├── service/
│   │   │   │   └── LibraryApplication.java
│   │   │   └── resources/application.properties
│   │   └── test/java/com/springproj/library/LibraryApplicationTests.java
│   ├── pom.xml
│   ├── mvnw
│   └── mvnw.cmd
└── README.md
```

## Features

- Add a new book
- View all books
- Fetch a single book by ID
- Update an existing book
- Delete a book
- MySQL-backed persistence with JPA

## Prerequisites

Before running the app, make sure you have:

- Java 17+
- Maven or Maven Wrapper (`mvnw` included)
- MySQL running locally
- A database named `Library` (or update the configuration)

## Database Configuration

The database settings are in:

```properties
library/src/main/resources/application.properties
```

Example configuration:

```properties
spring.application.name=library
spring.datasource.url=jdbc:mysql://localhost:3306/Library
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
```

Update the username and password for your local MySQL instance.

## Running the Application

From the `library` directory:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

The application will start on:

```text
http://localhost:8080
```

## API Endpoints

Base path:

```text
/api/book
```

### Create a book

```http
POST /api/book
Content-Type: application/json
```

Example body:

```json
{
  "bookName": "Clean Code",
  "bookPrice": 250,
  "bookWriter": "Robert C. Martin",
  "publisher": "Prentice Hall"
}
```

### Get all books

```http
GET /api/book/all
```

### Get book by ID

```http
GET /api/book/{id}
```

### Update a book

```http
PUT /api/book/{id}
Content-Type: application/json
```

### Delete a book

```http
DELETE /api/book/{id}
```

## Example Request

```bash
curl -X POST http://localhost:8080/api/book \
  -H "Content-Type: application/json" \
  -d '{
    "bookName": "Clean Code",
    "bookPrice": 250,
    "bookWriter": "Robert C. Martin",
    "publisher": "Prentice Hall"
  }'
```

## Notes

- This project is a simple CRUD library application intended for learning and backend API development.
- The application currently uses `spring.jpa.hibernate.ddl-auto=update`, which creates or updates database tables automatically.
- You may want to add validation, authentication, and a frontend later for production use.

## License

This project does not currently include a custom license file.
