package com.stock.portfolio.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "portfolios", uniqueConstraints = @UniqueConstraint(name = "uk_portfolios_user_symbol", columnNames = {"user_id", "symbol"}))
public class Portfolio {
    @Id @GeneratedValue(strategy = GenerationType.UUID) private UUID id;
    @Column(name = "user_id", nullable = false) private UUID userId;
    @Column(nullable = false, length = 10) private String symbol;
    @Column(nullable = false, precision = 19, scale = 4) private BigDecimal quantity;
    @Column(name = "average_buy_price", nullable = false, precision = 19, scale = 4) private BigDecimal averageBuyPrice;
    @Column(name = "current_price", nullable = false, precision = 19, scale = 4) private BigDecimal currentPrice;
    @Column(name = "realized_pnl", nullable = false, precision = 19, scale = 4) private BigDecimal realizedPnl;
    @Column(name = "updated_at", nullable = false) private Instant updatedAt;
    @Version @Column(nullable = false) private long version;

    protected Portfolio() { }
    private Portfolio(UUID userId, String symbol, BigDecimal quantity, BigDecimal price) {
        this.userId = userId; this.symbol = symbol; this.quantity = quantity; this.averageBuyPrice = price;
        this.currentPrice = price; this.realizedPnl = BigDecimal.ZERO.setScale(4); this.updatedAt = Instant.now();
    }
    public static Portfolio create(UUID userId, String symbol, BigDecimal quantity, BigDecimal price) { return new Portfolio(userId, symbol, quantity, price); }
    public void buy(BigDecimal additionalQuantity, BigDecimal price) {
        BigDecimal totalCost = quantity.multiply(averageBuyPrice).add(additionalQuantity.multiply(price));
        quantity = quantity.add(additionalQuantity); averageBuyPrice = totalCost.divide(quantity, 4, java.math.RoundingMode.HALF_UP); currentPrice = price; updatedAt = Instant.now();
    }
    public BigDecimal sell(BigDecimal soldQuantity, BigDecimal price) {
        if (quantity.compareTo(soldQuantity) < 0) throw new IllegalArgumentException("Insufficient quantity to sell");
        BigDecimal realized = price.subtract(averageBuyPrice).multiply(soldQuantity).setScale(4, java.math.RoundingMode.HALF_UP);
        quantity = quantity.subtract(soldQuantity); realizedPnl = realizedPnl.add(realized); currentPrice = price; updatedAt = Instant.now(); return realized;
    }
    public void updateCurrentPrice(BigDecimal price) { currentPrice = price; updatedAt = Instant.now(); }
    public UUID getId() { return id; } public UUID getUserId() { return userId; } public String getSymbol() { return symbol; }
    public BigDecimal getQuantity() { return quantity; } public BigDecimal getAverageBuyPrice() { return averageBuyPrice; }
    public BigDecimal getCurrentPrice() { return currentPrice; } public BigDecimal getRealizedPnl() { return realizedPnl; } public Instant getUpdatedAt() { return updatedAt; }
}
