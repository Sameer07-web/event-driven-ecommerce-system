# Event-Driven E-Commerce System

## Overview

A scalable event-driven e-commerce backend built using Spring Boot, Apache Kafka, PostgreSQL, Docker, and Microservices Architecture.

The project demonstrates how modern distributed systems communicate asynchronously using Kafka events while maintaining reliable data persistence with PostgreSQL.

---

## Features

* Create, Update, Retrieve, and Delete Orders
* Event-Driven Architecture using Apache Kafka
* Kafka Producer and Consumer Integration
* PostgreSQL Database Integration
* Dockerized Infrastructure
* Spring Data JPA & Hibernate
* RESTful APIs with Swagger Documentation
* Microservices-Based Design
* Automatic Event Publishing on Order Operations

---

## Tech Stack

| Technology      | Purpose                  |
| --------------- | ------------------------ |
| Java 17         | Programming Language     |
| Spring Boot     | Backend Framework        |
| Spring Data JPA | Database Access          |
| PostgreSQL      | Relational Database      |
| Apache Kafka    | Event Streaming Platform |
| Docker          | Containerization         |
| Maven           | Dependency Management    |
| Swagger OpenAPI | API Documentation        |

---

## Architecture

```text
Client
   |
   v
Order REST API
   |
   v
PostgreSQL Database

Order Service
   |
   v
Kafka Producer
   |
   v
Kafka Topic (order-topic)
   |
   v
Kafka Consumer
```

---

## Project Structure

```text
order-service
│
├── controller
├── service
├── repository
├── entity
├── kafka
│   ├── OrderProducer
│   └── OrderConsumer
├── dto
└── resources
```

---

## API Endpoints

### Create Order

```http
POST /api/orders
```

Request:

```json
{
  "productName": "iPhone 16",
  "quantity": 2,
  "price": 85000
}
```

---

### Get Order

```http
GET /api/orders/{id}
```

---

### Update Order

```http
PUT /api/orders/{id}
```

Request:

```json
{
  "productName": "iPhone 16 Pro Max",
  "quantity": 3,
  "price": 95000,
  "status": "SHIPPED"
}
```

---

### Delete Order

```http
DELETE /api/orders/{id}
```

---

## Kafka Event Flow

### Order Creation

```text
Order Created
     |
     v
Kafka Producer
     |
     v
order-topic
     |
     v
Kafka Consumer
```

### Order Update

```text
Order Updated
     |
     v
Kafka Producer
     |
     v
order-topic
     |
     v
Kafka Consumer
```

### Order Deletion

```text
Order Deleted
     |
     v
Kafka Producer
     |
     v
order-topic
     |
     v
Kafka Consumer
```

---

## Running the Project

### Clone Repository

```bash
git clone https://github.com/Sameer07-web/event-driven-ecommerce-system.git
```

### Start Docker Services

```bash
docker-compose up --build
```

### Access Swagger UI

```text
http://localhost:8080/swagger-ui/index.html
```

---

## Sample Kafka Logs

```text
Order Event Sent: Order Created with ID: 41
Received Order Event: Order Created with ID: 41
```

---

## Future Enhancements

* Global Exception Handling
* DTO Validation
* API Gateway
* Inventory Service
* Payment Service
* Notification Service
* Redis Caching
* Centralized Logging
* CI/CD Pipeline

---

## Author

Mohammad Sameer

GitHub:
https://github.com/Sameer07-web

LinkedIn:
https://linkedin.com/in/mohammadsameer007
