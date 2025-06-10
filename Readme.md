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

## 🌐 API Endpoints

---

## 📄 License
This project is open-source and available under the MIT License.
