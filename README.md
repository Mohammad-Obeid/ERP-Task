# Inventory Management System

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.5-green)
![API](https://img.shields.io/badge/API-REST-blue)
![MySQL](https://img.shields.io/badge/Database-MySQL-blue)
![Swagger](https://img.shields.io/badge/Documentation-Swagger-green)
![Postman](https://img.shields.io/badge/Tested-Postman-orange)

## Overview

A robust and scalable Inventory Management System built with Java and Spring Boot that provides comprehensive RESTful APIs for efficiently managing warehouse operations. The system enables businesses to track products, define storage locations, and monitor inventory movements with precision and reliability.

## Key Features

- **Product Management**: Track products with unique barcodes and detailed information
- **Location Management**: Define and manage multiple storage locations with unique location codes
- **Inventory Movement Tracking**: Record product transfers between locations with timestamping
- **Stock Level Monitoring**: Real-time inventory levels by product and location
- **Balance Reporting**: View product quantities across different storage locations
- **Location-Based Inventory**: Quick access to all products stored in specific locations
- **Pagination Support**: Efficient handling of large datasets with page count information
- **Comprehensive API Documentation**: Interactive Swagger/OpenAPI documentation
- **Cross-Origin Support**: Configured for seamless frontend integration

## Project Structure

The application follows a clean, layered architecture that separates concerns and enhances maintainability:

- **Controllers**: Handle HTTP requests and responses
- **Services**: Implement business logic and transaction management
- **Repositories**: Manage data access and persistence
- **DTOs**: Transfer data between layers while hiding implementation details
- **Models**: Represent the core domain entities
- **Mappers**: Convert between entities and DTOs
- **Response Objects**: Standardize API responses with consistent formats

## API Endpoints

### Products API

| Method | Endpoint | Description | Response Status |
|--------|----------|-------------|----------------|
| `GET` | `/api/v1/product?page={pageNum}` | Get all products (paginated) | 200 OK |
| `GET` | `/api/v1/product/{id}` | Get product by ID | 200 OK, 404 Not Found |
| `POST` | `/api/v1/product` | Create a new product | 201 Created, 400 Bad Request |
| `PATCH` | `/api/v1/product` | Update a product | 200 OK, 400 Bad Request |

### Locations API

| Method | Endpoint | Description | Response Status |
|--------|----------|-------------|----------------|
| `GET` | `/api/v1/location?page={pageNum}` | Get all locations (paginated) | 200 OK, 404 Not Found |
| `GET` | `/api/v1/location/{id}` | Get location by ID | 200 OK, 404 Not Found |
| `GET` | `/api/v1/location/list` | Get all locations (non-paginated) | 200 OK, 404 Not Found |
| `GET` | `/api/v1/location/lists/{locationCode}` | Get all locations except specified one | 200 OK, 404 Not Found |
| `POST` | `/api/v1/location` | Create a new location | 201 Created, 400 Bad Request |
| `PATCH` | `/api/v1/location` | Update a location | 200 OK, 404 Not Found |
| `DELETE` | `/api/v1/location/{id}` | Delete a location | 200 OK, 404 Not Found |

### Product Movements API

| Method | Endpoint | Description | Response Status |
|--------|----------|-------------|----------------|
| `GET` | `/api/v1/product-movement?page={pageNum}` | Get all product movements (paginated) | 200 OK, 404 Not Found |
| `GET` | `/api/v1/product-movement/{id}` | Get product movement by ID | 200 OK, 404 Not Found |
| `GET` | `/api/v1/product-movement/product/{id}` | Get product balance by product ID | 200 OK, 404 Not Found |
| `GET` | `/api/v1/product-movement/location/{id}` | Get products in a specific location | 200 OK, 404 Not Found |
| `POST` | `/api/v1/product-movement` | Create a new product movement | 201 Created, 400 Bad Request |
| `PATCH` | `/api/v1/product-movement` | Update a product movement | 200 OK, 404 Not Found |

## Technical Highlights

- **DTO Pattern**: Clear separation between API contracts and internal domain models
- **Data Mapping**: Efficient entity-to-DTO conversions maintaining clean architecture
- **Response Standardization**: Consistent JSON response formats across all endpoints
- **Timestamped Movements**: Automatic timestamping of inventory transactions
- **Optimized Queries**: Efficient database operations for improved performance
- **Error Handling**: Appropriate HTTP status codes and descriptive error messages
- **Swagger Documentation**: Comprehensive API documentation with request/response examples

## Installation and Setup

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- MySQL Database

### Steps

1. Clone the repository:
   ```bash
   https://github.com/Mohammad-Obeid/ERP-Task.git
    ```

2. Create the MySQL database:
   ```sql
   CREATE DATABASE inventory_management;
   ```

3. Configure database connection in `application.properties`

4. Build and run the application:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

5. Access the application:
   - API Endpoints: `http://localhost:8080/api/v1/`
   - Swagger UI: `http://localhost:8080/swagger-ui.html`

## Testing

All API endpoints have been thoroughly tested using Postman to ensure:

- Correct functionality for all CRUD operations
- Proper HTTP status codes for success and error cases
- Valid JSON response structures with consistent formats
- Accurate pagination with proper page count information
- Data integrity across all operations
- Edge case handling for invalid inputs and empty responses

The OpenAPI/Swagger documentation provides interactive testing capabilities directly from the browser.

## Technology Stack

- **Backend Framework**: Java 17, Spring Boot 3.4.5
- **API Architecture**: RESTful with standardized JSON responses
- **Database**: MySQL with JPA/Hibernate ORM
- **Documentation**: OpenAPI 3.0 (Springdoc)
- **Build Tool**: Maven
- **Testing**: Postman for API testing
- **Cross-Origin Support**: Configured CORS for frontend integration


---

<div align="center">
<img src="https://img.shields.io/badge/ERP-MAX%20SOLUTION-blue" alt="ERP MAX SOLUTION" />
<br/>
Developed with Mohammad Obeid for efficient inventory management
</div>
