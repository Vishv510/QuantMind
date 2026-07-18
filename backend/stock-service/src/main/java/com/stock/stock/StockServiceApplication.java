package com.stock.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * Stock Service Application Entry Point
 * 
 * Manages real-time stock data with WebSocket and Kafka messaging support.
 */
@SpringBootApplication
@EnableKafka
public class StockServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockServiceApplication.class, args);
    }
}
