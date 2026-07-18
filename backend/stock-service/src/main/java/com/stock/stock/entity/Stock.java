package com.stock.stock.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Version;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "stocks", uniqueConstraints = @UniqueConstraint(name = "uk_stocks_symbol", columnNames = "symbol"))
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 10)
    private String symbol;

    @Column(name = "company_name", nullable = false, length = 200)
    private String companyName;

    @Column(name = "current_price", nullable = false, precision = 19, scale = 4)
    private BigDecimal currentPrice;

    @Column(name = "previous_close", nullable = false, precision = 19, scale = 4)
    private BigDecimal previousClose;

    @Column(name = "last_updated_at", nullable = false)
    private Instant lastUpdatedAt;

    @Version
    @Column(nullable = false)
    private long version;

    protected Stock() {
    }

    private Stock(String symbol, String companyName, BigDecimal openingPrice) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.currentPrice = openingPrice;
        this.previousClose = openingPrice;
        this.lastUpdatedAt = Instant.now();
    }

    public static Stock create(String symbol, String companyName, BigDecimal openingPrice) {
        return new Stock(symbol, companyName, openingPrice);
    }

    public void updateDetails(String companyName) {
        this.companyName = companyName;
        this.lastUpdatedAt = Instant.now();
    }

    public void updatePrice(BigDecimal price) {
        this.currentPrice = price;
        this.lastUpdatedAt = Instant.now();
    }

    public UUID getId() { return id; }
    public String getSymbol() { return symbol; }
    public String getCompanyName() { return companyName; }
    public BigDecimal getCurrentPrice() { return currentPrice; }
    public BigDecimal getPreviousClose() { return previousClose; }
    public Instant getLastUpdatedAt() { return lastUpdatedAt; }
}
