# 📚 Spring Boot Library Management API

This project is a practice API built with Spring Boot to learn and demonstrate unidirectional relationships between entities — specifically between Authors and Books. The goal is to understand how to model and implement a one-to-many unidirectional relationship where an Author can have multiple Books, but the Book does not hold a reference back to the Author entity directly.

---

## 🎯 Project Purpose

- Practice implementing **unidirectional one-to-many relationships** in JPA/Hibernate
- Build basic CRUD operations for both Authors and Books
- Learn how to manage data consistency and DTOs with related entities
- Understand how to create REST endpoints handling entities and their relations

---

## 🚀 Features

- Create and manage Authors and Books with unidirectional relationship
- CRUD operations: Create, Read (single and list), Update, Delete
- DTO pattern for API requests and responses
- Exception handling for not found resources
- Input validation with Javax Validation

---

## 🛠 Technologies Used
- Java 17
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- Maven
- Lombok
- Bean Validation (Jakarta)

---

## Setup & Run

```bash
  git clone https://github.com/martinfiguerola/spring-unidirectional-author-book.git
  cd spring-unidirectional-author-book
  mvn clean install
  mvn spring-boot:run
```
API will be available at: http://localhost:8080

---

## 🔗 API Endpoints

### 📚 Books

| Method  | Endpoint          | Description                   | Request Body        | Response Body           |
|---------|-------------------|-------------------------------|---------------------|-------------------------|
| `GET`   | `/api/books`      | Retrieve all books            | —                   | `List<BookResponseDTO>` |
| `GET`   | `/api/books/{id}` | Retrieve a book by its ID     | —                   | `BookResponseDTO`       |
| `POST`  | `/api/books`      | Create a new book             | `BookRequestDTO`    | `BookResponseDTO`       |
| `PUT`   | `/api/books/{id}` | Update an existing book       | `BookRequestDTO`    | `BookResponseDTO`       |
| `DELETE`| `/api/books/{id}` | Delete a book by its ID       | —                   | —                       |

---

### 👤 Authors

| Method  | Endpoint             | Description                                | Request Body          | Response Body             |
|---------|----------------------|--------------------------------------------|-----------------------|---------------------------|
| `GET`   | `/api/authors`       | Retrieve all authors                       | —                     | `List<AuthorResponseDTO>` |
| `GET`   | `/api/authors/{id}`  | Retrieve an author (with books)            | —                     | `AuthorBookResponseDTO`   |
| `POST`  | `/api/authors`       | Create a new author (optional: with books) | `AuthorRequestDTO`    | `AuthorResponseDTO`       |
| `PUT`   | `/api/authors/{id}`  | Update an existing author                  | `AuthorRequestDTO`    | `AuthorResponseDTO`       |
| `DELETE`| `/api/authors/{id}`  | Delete an author by its ID                 | —                     | —                         |

---


## 📄 License
This project is open-source and available under the MIT License.


