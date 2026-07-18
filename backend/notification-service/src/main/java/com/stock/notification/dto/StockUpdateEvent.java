package com.stock.notification.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record StockUpdateEvent(
        UUID stockId,
        String symbol,
        BigDecimal currentPrice,
        BigDecimal previousClose,
        BigDecimal changePercent,
        Instant occurredAt
) {
}
