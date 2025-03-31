# Java Servlet REST API

## Overview

This project is a Java-based RESTful API for managing a Todo application. It utilizes the Jakarta Servlet API and Gson for JSON processing. The API allows users to perform CRUD (Create, Read, Update, Delete) operations on Todo items.

## Author

- **Vinay Koirala**
  - Personal Email: [koiralavinay@gmail.com](mailto:koiralavinay@gmail.com)
  - Professional Email: [binaya.koirala@iic.edu.np](mailto:binaya.koirala@iic.edu.np)
  - GitHub: [github.com/v-eenay](https://github.com/v-eenay)

## Repository

The source code can be found at: [https://github.com/v-eenay/java-servlet-rest-api.git](https://github.com/v-eenay/java-servlet-rest-api.git)

## Prerequisites

- Java 23 or higher
- Maven
- MySQL database

## Configuration

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/v-eenay/java-servlet-rest-api.git
   cd java-servlet-rest-api
   ```

2. **Set Up the Database:**
   - Create a MySQL database and configure the connection settings in the `application.properties` file (if applicable).

3. **Build the Project:**
   ```bash
   ./mvnw clean install
   ```

## Running the Project

To run the application, you can use the following command:

```bash
./mvnw spring-boot:run
```

Alternatively, you can deploy the generated WAR file located in the `target` directory to a servlet container like Apache Tomcat.

## API Endpoints

- **GET /api/todos**: Retrieve all Todo items.
- **GET /api/todos?id={id}**: Retrieve a Todo item by ID.
- **POST /api/todos**: Add a new Todo item.
- **PUT /api/todos**: Update an existing Todo item.
- **DELETE /api/todos?id={id}**: Delete a Todo item by ID.
- **PATCH /api/todos?id={id}**: Toggle the status of a Todo item.
