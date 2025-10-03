# E-Commerce Microservices Project

## Overview

This is a full-stack **E-Commerce application** built with a **microservices architecture**.
The system is designed to demonstrate **scalable, maintainable and observable distributed applications** using modern technologies.

## Architecture

The application is composed of multiple services, each responsible for a single domain:

* **Frontend (Angular)**
  User interface for browsing products, placing orders, and viewing status.

* **API Gateway (Spring Cloud Gateway)**
  Entry point to the system, handling routing, authentication (via Keycloak), and request forwarding.

* **Product Service (Spring Boot)**
  Manages product catalog (CRUD operations, DTO mapping).

* **Inventory Service (Spring Boot)**
  Tracks product stock and integrates with the order service to validate availability.

* **Order Service (Spring Boot)**
  Handles order placement, communicates with inventory, and emits events for notifications.

* **Notification Service (Spring Boot)**
  Listens to order events and sends notifications to the user.

## Key Features

* **Microservices architecture** with independent Spring Boot services.
* **API Gateway** for routing, security and centralized access.
* **Keycloak** integration for authentication & authorization.
* **Event-driven communication** for order and notification flow.
* **Observability** with Grafana, Prometheus and Tempo (metrics, traces, dashboards).
* **Docker Compose** setup for local development and service orchestration.
* **Angular frontend** for client-side interaction.

## Getting Started

### Prerequisites

* Docker & Docker Compose
* Java 17+
* Node.js (for Angular frontend)

### Run the project

```bash
# Start backend services
docker-compose up --build

# Run frontend
cd frontend
npm install
npm start
```

The application will be available at:

* **Frontend**: [http://localhost:4200](http://localhost:4200)
* **API Gateway**: [http://localhost:8080](http://localhost:8080)

## Project Structure

```
ecommerce-main/
 ├── api-gateway/           # Gateway + Keycloak + observability configs
 ├── product-service/       # Product CRUD microservice
 ├── inventory-service/     # Stock microservice
 ├── order-service/         # Orders microservice
 ├── notification-service/  # Notifications microservice
 └── frontend/              # Angular web client
```
