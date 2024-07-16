# Book Catalog API

## Overview
This project is a RESTful API for a simple book catalog built using Java and Spring Boot. The API allows users to perform basic operations such as viewing a list of books, retrieving details of a specific book, and adding or editing books in the catalog.

## Features
- **List Books Endpoint:** Retrieve a list of all books in the catalog, displaying basic information like title and author.
- **Book Details Endpoint:** View detailed information about a specific book, such as summary, publication year, and genre.
- **In-Memory Database:** Uses H2 in-memory database for storing book data.
- **Data Generation:** Includes pre-generated book data in JSON format to simulate a real-world scenario.

## Technologies Used
- **Java**
- **Spring Boot**
- **Spring Security**
- **H2 Database**
- **Swagger/OpenAPI**

## Setup and Usage
- **Clone the Repository:**
      - git clone https://github.com/kiki-sv/book-catalog-api.git
      - cd book-catalog-api
- **Run the Application:**
      - ./mvnw spring-boot:run
- **Access API:**
     - Base URL: **http://localhost:8080**
     - Swagger UI: **http://localhost:8080/swagger-ui.html**

  ## Endpoints
  - **GET /books:** Retrieve a list of all books.
  - **GET /books{id}:** Retrieve details of a specific book.
  - **GET /books/search/title:** Retrieve details of book based on title.
  - **GET /books/search/author:** Retrieve details of book based on author.
  - **POST /books:** Add a new book.
  - **PUT /books/update/{id}:** Edit an existing book.
  - **DELETE books/delete/{id}:** Delete an existing book.
