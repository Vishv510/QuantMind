# Real-Time Stock Analytics System

A microservices-based platform for real-time stock data analysis, portfolio management, and notifications.

## Architecture Overview

This project follows a microservices architecture with the following components:

### Services (Day 1)
- **Auth Service**: Authentication and authorization with JWT tokens
- **Stock Service**: Real-time stock data management with WebSocket and Kafka support
- **Common Library**: Shared utilities, DTOs, and configurations

### Services (Future)
- **Portfolio Service**: User portfolio management
- **Notification Service**: Event-driven notifications via Kafka
- **API Gateway**: Central entry point for all services

## Project Structure

```
backend/
├── pom.xml                      # Parent POM for multi-module Maven project
├── common-library/              # Shared library module
├── auth-service/                # Authentication service
├── stock-service/               # Stock data service
└── (portfolio-service/)         # Coming soon
```

## Prerequisites

- Java 17+
- Maven 3.8+
- PostgreSQL 13+
- Docker (optional, for local development)

## Build & Run

### Build All Modules
```bash
cd backend
mvn clean package
```

### Build Specific Module
```bash
mvn clean package -pl auth-service
```

### Run Auth Service
```bash
cd backend/auth-service
mvn spring-boot:run
```

### Run Stock Service
```bash
cd backend/stock-service
mvn spring-boot:run
```

## Development Environment

### Docker Compose (Future)
```bash
docker-compose -f docker/docker-compose.yml up
```

### Database Setup
PostgreSQL connection details are configured in `application.yml` for each service.

## Configuration

Each service has its own `application.yml` in `src/main/resources/`:
- **Auth Service**: Authentication configuration and database
- **Stock Service**: WebSocket, Kafka, and database configuration

## API Documentation

API endpoints will be documented in individual service READMEs (coming soon).

## Testing

### Unit Tests
```bash
mvn test
```

### Integration Tests
```bash
mvn verify
```

## Deployment

- **Docker**: Dockerfiles will be provided in `docker/services/`
- **Kubernetes**: Deployment manifests in `kubernetes/`
- **CI/CD**: Pipeline configurations in GitHub Actions (coming soon)

## Contributing

1. Create a feature branch
2. Commit changes with clear messages
3. Submit a pull request

## License

MIT License - see LICENSE file for details
