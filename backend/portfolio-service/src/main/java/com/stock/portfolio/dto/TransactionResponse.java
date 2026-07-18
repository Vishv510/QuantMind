package com.stock.portfolio.dto;
import com.stock.portfolio.entity.TransactionType; import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
public record TransactionResponse(UUID id, TransactionType type, BigDecimal quantity, BigDecimal price, BigDecimal realizedPnl, Instant executedAt) { }
