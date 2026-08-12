# Ecommerce API - Spring Boot REST Service

RESTful API for e-commerce system built with Spring Boot, Java 21, Spring Data JPA, and H2 Database.

## Features
- Full CRUD operations for Products, Clients, Brands, and Orders.
- Swagger / OpenAPI 3 documentation integrated.
- Pre-loaded sample data on startup.
- Standardized HTTP response status codes (200, 201, 204, 404).

## API Documentation & Access
Once the application is running (`EcommerceApplication.java`):

- **Swagger UI:** `http://localhost:8080/swagger-ui.html`
- **H2 Database Console:** `http://localhost:8080/h2-console`
  - **JDBC URL:** `jdbc:h2:mem:tiendadb`
