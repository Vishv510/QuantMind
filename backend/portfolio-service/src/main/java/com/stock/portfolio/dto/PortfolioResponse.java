package com.stock.portfolio.dto;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
public record PortfolioResponse(UUID id, UUID userId, String symbol, BigDecimal quantity, BigDecimal averageBuyPrice, BigDecimal currentPrice, BigDecimal marketValue, BigDecimal unrealizedPnl, BigDecimal realizedPnl, BigDecimal totalPnl, Instant updatedAt) { }
