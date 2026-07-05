# 🛒 Event-Driven E-Commerce Platform

> A production-inspired, event-driven e-commerce backend built using Java, Spring Boot, Apache Kafka, PostgreSQL, and Microservices Architecture.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Apache Kafka](https://img.shields.io/badge/Apache-Kafka-black)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![Docker](https://img.shields.io/badge/Docker-Containerized-2496ED)
![License](https://img.shields.io/badge/Status-In%20Development-yellow)

---

# 📖 Overview

This project demonstrates how modern large-scale e-commerce systems are built using **Microservices**, **Event-Driven Architecture**, and **Domain-Driven Design (DDD)**.

Instead of building a monolithic application, the platform is divided into independent business services that communicate through **Apache Kafka** events and REST APIs.

The goal of this project is to showcase **production-inspired backend engineering practices**, including:

- Clean Architecture
- Domain-Driven Design (DDD)
- Event-Driven Communication
- RESTful APIs
- Asynchronous Messaging with Kafka
- Standard API Responses
- DTO-Based Architecture
- Bean Validation
- MapStruct Mapping
- Dockerized Development
- Scalable Microservice Design

---

# 🏗️ Architecture

```
                         Client
                            │
                            ▼
                     API Gateway
                            │
        ┌───────────────┬───────────────┐
        ▼               ▼               ▼
 Identity Service   Order Service   Product Service
                          │
                    OrderCreatedEvent
                          │
                          ▼
                 Apache Kafka Broker
                  │               │
                  ▼               ▼
          Inventory Service   Payment Service
                  │               │
                  └──────┬────────┘
                         ▼
                Notification Service
```

---

# 🎯 Project Goals

- Build a production-inspired backend platform
- Learn Microservices Architecture
- Implement Event-Driven Communication
- Follow Clean Architecture principles
- Practice Domain-Driven Design
- Build a strong backend portfolio project for Software Engineering interviews

---

# 🧩 Microservices

| Service | Responsibility | Status |
|----------|----------------|--------|
| API Gateway | Routing, Authentication, Rate Limiting | ⏳ Planned |
| Identity Service | Authentication, JWT, User Management | ⏳ Planned |
| Product Service | Product Catalog & Search | ⏳ Planned |
| Order Service | Order Management | 🚧 In Progress |
| Inventory Service | Stock Management | ⏳ Planned |
| Payment Service | Payment Processing | ⏳ Planned |
| Notification Service | Email/SMS Notifications | ⏳ Planned |

---

# 🛠️ Technology Stack

## Backend

- Java 21
- Spring Boot 3.x
- Spring Data JPA
- Spring Validation
- Spring Security (Planned)

## Messaging

- Apache Kafka

## Database

- PostgreSQL

## Build Tool

- Maven

## Documentation

- OpenAPI / Swagger (In Progress)

## Testing

- JUnit 5
- Mockito
- Testcontainers (Planned)

## DevOps

- Docker
- Docker Compose
- GitHub Actions (Planned)

## Monitoring

- Spring Boot Actuator (Planned)
- Prometheus (Planned)
- Grafana (Planned)

---

# 📂 Project Structure

```
event-driven-ecommerce-system

├── common-module
│
├── order-service
│
├── product-service          (Planned)
│
├── inventory-service        (Planned)
│
├── payment-service          (Planned)
│
├── notification-service     (Planned)
│
├── identity-service         (Planned)
│
├── api-gateway              (Planned)
│
├── docker-compose.yml
│
└── pom.xml
```

---

# 🚀 Current Progress

## ✅ Sprint 1 – Project Foundation

- Maven Multi-Module Architecture
- Common Module
- Standard API Response (`ApiResponse`)
- Standard API Error (`ApiError`)
- Base Event Contract (`BaseEvent`)
- Correlation ID Support
- Root Maven Build

---

## 🚧 Sprint 2 – Order Service (In Progress)

### ✅ Milestone 1

- Configuration migrated to `application.yml`
- Externalized configuration using `@ConfigurationProperties`
- Project configuration cleanup

### ✅ Milestone 2

- DTO-based API design
- MapStruct integration
- Bean Validation
- Standard API Responses
- Updated Unit Tests
- Order Service evolving into the **Golden Reference Service**

### ⏳ Upcoming

- Thin Controllers
- Service Layer Refactoring
- Event Publisher
- OpenAPI Documentation
- Integration Tests

---

# 📌 Engineering Principles

This project follows:

- Clean Architecture
- SOLID Principles
- Domain-Driven Design (DDD)
- Event-Driven Architecture
- Separation of Concerns
- DTO-Based API Design
- Standard API Contracts
- Twelve-Factor App Principles

---

# 🔄 Event Flow

```
Create Order

      │

      ▼

Order Service

      │

      ▼

OrderCreatedEvent

      │

      ▼

Apache Kafka

      │

      ├────────► Inventory Service

      │              │

      │              ▼

      │      InventoryReservedEvent

      │

      ▼

Payment Service

      │

      ▼

PaymentSuccessEvent

      │

      ▼

Notification Service
```

---

# 📋 Future Roadmap

- Product Service
- Inventory Service
- Payment Service
- Notification Service
- Identity Service
- API Gateway
- JWT Authentication
- Redis Caching
- Prometheus & Grafana
- GitHub Actions CI/CD
- Docker Deployment
- Distributed Saga Pattern

---

# 💻 Running Locally

```bash
git clone https://github.com/Sameer07-web/event-driven-ecommerce-system.git

cd event-driven-ecommerce-system

mvn clean install

docker compose up
```

---

# 📈 Version History

| Version | Description |
|----------|-------------|
| v0.1.0 | Project Foundation |
| v0.2.0 | Golden Reference Service Foundation |
| v0.3.0 | Order Service Completion *(Planned)* |
| v0.4.0 | Product Service *(Planned)* |
| v1.0.0 | Production-Inspired Event-Driven Platform *(Target)* |

---

# 🎯 Learning Objectives

This project demonstrates practical experience with:

- Java Backend Development
- Spring Boot
- Microservices
- Apache Kafka
- REST APIs
- Docker
- PostgreSQL
- Distributed Systems
- Domain-Driven Design
- Clean Architecture

---

# 👨‍💻 Author

**Mohammad Sameer**

- GitHub: https://github.com/Sameer07-web
- LinkedIn: https://www.linkedin.com/in/mohammadsameer007/

---

⭐ If you found this project interesting, consider giving it a star!
