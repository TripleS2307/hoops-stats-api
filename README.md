# Hoops Stats API

A RESTful backend service built with Spring Boot and Java for managing basketball player statistics. Built with standard enterprise architectural patterns, clean controller-service separation, and JPA persistence.

## Tech Stack
- **Java 25** (Microsoft OpenJDK)
- **Spring Boot 4.1.2** (Spring Web, Spring Data JPA, Validation)
- **H2 Database** (In-Memory for Local Development)
- **JUnit 5 & Mockito** (Unit Testing & TDD)

## Package Structure
- `com.example.hoops.controller` - REST API endpoints and HTTP status mapping
- `com.example.hoops.service` - Business logic and repository coordination
- `com.example.hoops.repository` - Spring Data JPA data access interfaces
- `com.example.hoops.model` - JPA Entities

## Getting Started

### Prerequisites
- JDK 25 (Microsoft OpenJDK)
- Maven (or included `./mvnw` wrapper)

### Run the Application
```bash
./mvnw spring-boot:run
