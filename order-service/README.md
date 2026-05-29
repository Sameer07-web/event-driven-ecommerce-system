# Event Driven Order Service

## Overview

This project is an Event-Driven Order Management System built using Spring Boot, PostgreSQL, Apache Kafka, and Docker.

When an order is created:

1. Order is saved in PostgreSQL.
2. Kafka Producer publishes an event.
3. Kafka Consumer receives the event.
4. Event is logged successfully.

---

## Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Apache Kafka
- Docker
- Docker Compose
- Swagger OpenAPI

---

## Features

- Create Order
- Get Order
- Update Order
- Delete Order
- Kafka Producer
- Kafka Consumer
- Dockerized Deployment
- Swagger API Documentation

---

## Architecture

Client
↓
REST API
↓
Order Service
↓
PostgreSQL
↓
Kafka Producer
↓
order-topic
↓
Kafka Consumer

---

## Run Project

```bash
docker compose up --build
```

Swagger:

```text
http://localhost:8080/swagger-ui/index.html
```

---

## Sample Event Flow

Order Created
↓
Kafka Producer
↓
order-topic
↓
Kafka Consumer
↓
Event Received

---

## Author

Mohammad Sameer