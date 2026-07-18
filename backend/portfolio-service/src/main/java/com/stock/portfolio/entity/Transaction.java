package com.stock.portfolio.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity @Table(name = "transactions")
public class Transaction {
    @Id @GeneratedValue(strategy = GenerationType.UUID) private UUID id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(name = "portfolio_id", nullable = false) private Portfolio portfolio;
    @Enumerated(EnumType.STRING) @Column(name = "transaction_type", nullable = false, length = 4) private TransactionType type;
    @Column(nullable = false, precision = 19, scale = 4) private BigDecimal quantity;
    @Column(nullable = false, precision = 19, scale = 4) private BigDecimal price;
    @Column(name = "realized_pnl", nullable = false, precision = 19, scale = 4) private BigDecimal realizedPnl;
    @Column(name = "executed_at", nullable = false) private Instant executedAt;
    protected Transaction() { }
    private Transaction(Portfolio portfolio, TransactionType type, BigDecimal quantity, BigDecimal price, BigDecimal realizedPnl) { this.portfolio=portfolio; this.type=type; this.quantity=quantity; this.price=price; this.realizedPnl=realizedPnl; this.executedAt=Instant.now(); }
    public static Transaction create(Portfolio p, TransactionType t, BigDecimal q, BigDecimal price, BigDecimal pnl) { return new Transaction(p,t,q,price,pnl); }
    public UUID getId() { return id; } public TransactionType getType() { return type; } public BigDecimal getQuantity() { return quantity; } public BigDecimal getPrice() { return price; } public BigDecimal getRealizedPnl() { return realizedPnl; } public Instant getExecutedAt() { return executedAt; }
}
