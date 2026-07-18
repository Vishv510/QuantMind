package com.stock.portfolio.dto;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
public record StockPriceUpdateEvent(UUID stockId, String symbol, BigDecimal currentPrice, BigDecimal previousClose, BigDecimal changePercent, Instant occurredAt) { }
