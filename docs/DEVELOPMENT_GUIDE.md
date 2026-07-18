# Project Setup and Development Guide

## Quick Start

### Prerequisites
- Java 17+
- Maven 3.8+
- PostgreSQL 13+
- Optional: Docker and Docker Compose

### Initial Setup

1. **Clone and Navigate**
   ```bash
   cd backend
   ```

2. **Build All Modules**
   ```bash
   mvn clean install
   ```

3. **Database Setup** (PostgreSQL)
   ```sql
   CREATE DATABASE stock_auth_db;
   CREATE DATABASE stock_data_db;
   ```

4. **Run Services**
   ```bash
   # Terminal 1: Auth Service
   cd auth-service
   mvn spring-boot:run

   # Terminal 2: Stock Service
   cd stock-service
   mvn spring-boot:run
   ```

## Project Structure

```
backend/
├── pom.xml                           # Parent POM
├── common-library/                   # Shared module
│   ├── pom.xml
│   └── src/main/java/com/stock/common/
│       ├── config/                   # Shared configurations
│       ├── dto/                      # Data Transfer Objects
│       ├── exception/                # Custom exceptions
│       ├── util/                     # Utility classes
│       └── constants/                # Application constants
│
├── auth-service/                     # Authentication Service
│   ├── pom.xml
│   └── src/main/java/com/stock/auth/
│       ├── AuthServiceApplication.java
│       ├── controller/               # REST endpoints
│       ├── service/                  # Business logic
│       ├── repository/               # Data access
│       ├── entity/                   # JPA entities
│       ├── dto/                      # Service-specific DTOs
│       ├── security/                 # Security configurations
│       └── config/                   # Service configuration
│
└── stock-service/                    # Stock Data Service
    ├── pom.xml
    └── src/main/java/com/stock/stock/
        ├── StockServiceApplication.java
        ├── controller/               # REST endpoints
        ├── service/                  # Business logic
        ├── repository/               # Data access
        ├── entity/                   # JPA entities
        ├── dto/                      # Service-specific DTOs
        ├── websocket/                # WebSocket handlers
        ├── kafka/                    # Kafka producers/consumers
        └── config/                   # Service configuration
```

## Common Library Usage

The `common-library` module is shared across all services. It includes:

- **Exceptions**: `StockAnalyticsException` and custom exceptions
- **DTOs**: `ApiResponse`, `ErrorResponse`
- **Constants**: `AppConstants` for Kafka topics, cache keys, etc.
- **Utils**: Utility classes (to be added)
- **Config**: Shared configurations (to be added)

### Example: Using Common Library in a Service

```java
// In your pom.xml
<dependency>
    <groupId>com.stock</groupId>
    <artifactId>common-library</artifactId>
    <version>1.0.0</version>
</dependency>

// In your code
import com.stock.common.dto.ApiResponse;
import com.stock.common.exception.StockAnalyticsException;
import com.stock.common.constants.AppConstants;
```

## Key Features (Day 1)

### Auth Service
- JWT-based authentication
- User credentials validation
- Token generation and refresh
- Integration with common-library

### Stock Service
- Real-time stock data fetching
- WebSocket support for live updates
- Kafka integration for event streaming
- Redis caching
- Integration with common-library

## Testing

### Unit Tests
```bash
mvn test
```

### Integration Tests
```bash
mvn verify
```

### Specific Service Tests
```bash
cd auth-service
mvn test
```

## Development Tips

1. **Hot Reload**: Use DevTools for faster development
   ```bash
   mvn spring-boot:run
   ```

2. **Database Migrations**: Flyway/Liquibase can be added later

3. **API Documentation**: Swagger/SpringDoc OpenAPI can be added to services

4. **Logging**: Check `application.yml` for logging levels

5. **Local Development**: Use `application-local.yml` for local database configs

## Troubleshooting

### Maven Build Issues
```bash
# Clean Maven cache
mvn clean -U
# Rebuild
mvn clean package
```

### Database Connection Issues
- Ensure PostgreSQL is running
- Check credentials in `application.yml`
- Verify database exists

### Port Conflicts
- Auth Service: 8081
- Stock Service: 8082
- Change `server.port` in `application.yml` if needed

## Next Steps

1. Implement authentication endpoints in Auth Service
2. Add database entities and repositories
3. Create REST controllers
4. Set up WebSocket for real-time updates
5. Configure Kafka for event streaming
6. Add unit and integration tests
7. Deploy with Docker

## Useful Commands

```bash
# Build and skip tests
mvn clean package -DskipTests

# Build specific module
mvn clean package -pl auth-service

# Run specific service
cd auth-service && mvn spring-boot:run

# Check dependencies
mvn dependency:tree

# Update dependencies
mvn versions:display-dependency-updates
```

For more detailed information, see individual service README files (coming soon).
