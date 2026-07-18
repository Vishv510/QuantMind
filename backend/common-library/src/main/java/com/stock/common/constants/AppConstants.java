package com.stock.common.constants;

/**
 * Application-wide constants
 */
public class AppConstants {

    // API Versioning
    public static final String API_V1 = "/v1";

    // Service Names
    public static final String AUTH_SERVICE = "auth-service";
    public static final String STOCK_SERVICE = "stock-service";
    public static final String PORTFOLIO_SERVICE = "portfolio-service";
    public static final String NOTIFICATION_SERVICE = "notification-service";

    // Kafka Topics
    public static final String KAFKA_TOPIC_STOCK_PRICE_UPDATES = "stock-price-updates";
    public static final String KAFKA_TOPIC_PORTFOLIO_CHANGES = "portfolio-changes";
    public static final String KAFKA_TOPIC_NOTIFICATIONS = "notifications";

    // Cache Keys
    public static final String CACHE_KEY_STOCK_PRICE = "stock:price:";
    public static final String CACHE_KEY_USER_PORTFOLIO = "user:portfolio:";

    // HTTP Headers
    public static final String HEADER_X_REQUEST_ID = "X-Request-ID";
    public static final String HEADER_X_USER_ID = "X-User-ID";
    public static final String HEADER_AUTHORIZATION = "Authorization";

    // Time Constants (in milliseconds)
    public static final long CACHE_EXPIRY_5_MINUTES = 5 * 60 * 1000;
    public static final long CACHE_EXPIRY_1_HOUR = 60 * 60 * 1000;

    private AppConstants() {
        // Private constructor to prevent instantiation
    }
}
