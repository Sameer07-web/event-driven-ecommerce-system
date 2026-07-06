# 🛒 Event-Driven E-Commerce Platform

> A production-inspired Event-Driven Microservices platform built using **Java 21, Spring Boot 3, Apache Kafka, PostgreSQL, Docker, and Domain-Driven Design (DDD)**.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Apache Kafka](https://img.shields.io/badge/Apache-Kafka-black)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![Docker](https://img.shields.io/badge/Docker-Containerized-2496ED)
![Microservices](https://img.shields.io/badge/Architecture-Microservices-blueviolet)
![Status](https://img.shields.io/badge/Status-Active%20Development-success)

---

# 📖 Overview

This project demonstrates how modern large-scale e-commerce systems are designed using **Microservices**, **Event-Driven Architecture**, and **Domain-Driven Design (DDD)**.

Instead of a monolithic application, the platform is divided into autonomous business services that communicate through **Apache Kafka events** and REST APIs.

The project emphasizes production-inspired backend engineering practices, including:

- Clean Architecture
- Domain-Driven Design (DDD)
- SOLID Principles
- Event-Driven Communication
- REST APIs
- Apache Kafka
- DTO-Based Architecture
- Bean Validation
- MapStruct
- Global Exception Handling
- Standard API Contracts
- OpenAPI / Swagger
- Dockerized Development
- Multi-Module Maven Architecture

---

# 🏗️ Target Architecture

```text
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

# 🏗️ Current Architecture

```text
                common-module
                      │
        ┌─────────────┴─────────────┐
        ▼                           ▼
  Order Service               Product Service
        │                           │
        └──────── Kafka Producers ──┘
```

---

# 🎯 Project Goals

- Build a production-inspired backend platform
- Learn enterprise microservices architecture
- Implement event-driven communication using Kafka
- Follow Clean Architecture and DDD
- Build a portfolio-quality backend project for Software Engineering interviews

---

# 🧩 Microservices

| Service | Responsibility | Status |
|----------|----------------|--------|
| Common Module | Shared DTOs, Events, Exceptions & Utilities | ✅ Complete |
| Order Service | Order Management (Golden Reference Service) | ✅ Complete |
| Product Service | Product Catalog & Product Management (Golden Reference Service) | ✅ Complete |
| Inventory Service | Inventory & Stock Reservation | 🚧 Next Sprint |
| Payment Service | Payment Processing | ⏳ Planned |
| Notification Service | Email/SMS Notifications | ⏳ Planned |
| Identity Service | Authentication & JWT | ⏳ Planned |
| API Gateway | Routing & API Management | ⏳ Planned |

---

# ⭐ Enterprise Engineering Features

- ✅ Multi-Module Maven Architecture
- ✅ Clean Architecture
- ✅ SOLID Principles
- ✅ Domain-Driven Design (DDD)
- ✅ DTO-Based APIs
- ✅ MapStruct
- ✅ Bean Validation
- ✅ Global Exception Handling
- ✅ Standard API Responses
- ✅ Correlation ID Support
- ✅ Event Metadata Factory
- ✅ Event Publisher Abstraction
- ✅ Versioned Kafka Topics
- ✅ OpenAPI / Swagger
- ✅ Structured Logging
- ✅ Shared Common Module

---

# 🛠️ Technology Stack

## Backend

- Java 21
- Spring Boot 3.x
- Spring Data JPA
- Spring Validation
- Spring Security *(Planned)*

## Messaging

- Apache Kafka

## Database

- PostgreSQL

## Build Tool

- Maven (Multi-Module)

## Documentation

- OpenAPI
- Swagger

## Testing

- JUnit 5
- Mockito
- Testcontainers *(Planned)*

## DevOps

- Docker
- Docker Compose
- GitHub Actions *(Planned)*

## Monitoring

- Spring Boot Actuator *(Planned)*
- Prometheus *(Planned)*
- Grafana *(Planned)*

---

# 📂 Project Structure

```text
event-driven-ecommerce-system

├── common-module
│   ├── constants
│   ├── dto
│   ├── event
│   ├── exception
│   ├── filter
│   ├── helper
│   └── validation
│
├── order-service
│
├── product-service
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

# 🚀 Development Progress

## ✅ Sprint 1 – Project Foundation

- Multi-Module Maven Architecture
- Common Module
- Standard API Response
- Standard API Error
- Base Event
- Correlation ID
- Docker Environment

---

## ✅ Sprint 2 – Golden Reference Order Service

### Architecture

- Clean Architecture
- DTO Layer
- Bean Validation
- MapStruct
- Thin Controllers
- Service Interface & Implementation
- Repository Layer
- Global Exception Handling

### Event Architecture

- Domain Events
- Event Publisher
- Event Mapper
- Versioned Kafka Topics
- Structured Logging

### API

- OpenAPI
- Swagger

---

## ✅ Sprint 3 – Golden Reference Product Service

### Architecture

- Clean Architecture
- DTO Layer
- Bean Validation
- MapStruct
- Repository Layer
- Service Layer
- REST Controller

### Event Architecture

- ProductCreatedEvent
- ProductUpdatedEvent
- ProductDeletedEvent
- ProductEventPublisher
- ProductEventMapper
- Versioned Kafka Topics

### API

- OpenAPI
- Swagger

---

## ✅ Sprint 3.5 – Platform Standardization

- Shared Constants
- Event Metadata Factory
- EventType Enum
- Business Exception Hierarchy
- Validation Helper
- Common Infrastructure Cleanup
- Zero Compilation Errors
- Zero Test Failures

---

## 🚧 Sprint 4 – Inventory Service

Upcoming:

- Inventory Domain
- Kafka Consumer
- Inventory Events
- Stock Reservation
- OpenAPI
- Integration Testing

---

# 🔄 Current Event Flow

```text
Product Service
       │
       ▼
ProductCreatedEvent
       │
       ▼
Apache Kafka
```

---

# 🎯 Target Event Flow

```text
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

# 📋 Roadmap

- ✅ Project Foundation
- ✅ Golden Reference Order Service
- ✅ Golden Reference Product Service
- ✅ Platform Standardization
- 🚧 Inventory Service
- ⏳ Payment Service
- ⏳ Notification Service
- ⏳ Identity Service
- ⏳ API Gateway
- ⏳ JWT Authentication
- ⏳ Redis
- ⏳ Saga Pattern
- ⏳ Prometheus & Grafana
- ⏳ GitHub Actions CI/CD
- ⏳ Kubernetes Deployment

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
| v0.2.0 | Multi-Module Architecture & Common Module |
| v0.3.0 | Golden Reference Order Service |
| v0.4.0 | Order Service Event Architecture & OpenAPI |
| v0.5.0 | Golden Reference Product Service |
| v0.5.1 | Platform Standardization |
| v0.6.0 | Inventory Service *(Planned)* |
| v1.0.0 | Production-Inspired Event-Driven Platform *(Target)* |

---

# 🎯 Learning Objectives

This project demonstrates practical experience with:

- Java 21
- Spring Boot
- Microservices
- Apache Kafka
- REST APIs
- PostgreSQL
- Docker
- Distributed Systems
- Domain-Driven Design
- Clean Architecture
- Event-Driven Architecture
- API Design
- Software Engineering Best Practices

---

# 👨‍💻 Author

**Mohammad Sameer**

- GitHub: https://github.com/Sameer07-web
- LinkedIn: https://www.linkedin.com/in/mohammadsameer007/

---

⭐ **If you found this project interesting, consider giving it a star!**
